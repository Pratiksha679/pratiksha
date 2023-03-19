package com.example.geektrust;


import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import com.example.geektrust.services.CourseService;
import com.example.geektrust.repository.ICourseRepository;
import com.example.geektrust.repository.CourseRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import com.example.geektrust.entities.Course;
import com.example.geektrust.entities.Register;
import com.example.geektrust.repository.IRegisterRepository;
import com.example.geektrust.repository.RegisterRepository;
import com.example.geektrust.services.RegisterService;
import com.example.geektrust.constants.RegisterStatus;
public class Main {
    private static final String INPUT_DATA_ERROR = "INPUT_DATA_ERROR";
    public static void main(String[] args)  {
        if (args.length != 1){
            throw new RuntimeException();
        }
        List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        run(commandLineArgs);
	}
  public static void run(List<String> commandLineArgs){

      ICourseRepository iCourseRepository = new CourseRepository();
      IRegisterRepository registerRepository = new RegisterRepository();
      CourseService courseService = new CourseService(iCourseRepository);
      RegisterService registerService = new RegisterService(registerRepository,iCourseRepository);

      String inputFile = commandLineArgs.get(0).split("=")[1];

      try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
          while(true){
              String line =reader.readLine();
              if(line == null){
                  break;
              }
              List<String> tokens =Arrays.asList(line.split(" "));

              switch(tokens.get(0)){
              case "ADD-COURSE-OFFERING":{
                  try{
                      String courseTitle = tokens.get(1);
                      String instructorName =tokens.get(2);
                      String date =tokens.get(3);
                      int min=Integer.parseInt(tokens.get(4));
                      int max=Integer.parseInt(tokens.get(5));
                      Course c =courseService.addCourseOffering(courseTitle,instructorName,date,min,max);
                      System.out.println(c.getId());
                  }
                  catch(IndexOutOfBoundsException e){
                      System.out.println(INPUT_DATA_ERROR);
                  }
                  }
                  break;
              case "REGISTER":{
                  try{
                      String employeeid = tokens.get(1);
                      String courseId =tokens.get(2);
                      Register register = registerService.registerEmployeeToCourse(employeeid,courseId);
                      if(register.getRegisterationStatus() == RegisterStatus.COURSE_FULL_ERROR){
                          System.out.println(RegisterStatus.COURSE_FULL_ERROR.getRegisterStatusDesc());
                      }
                      else{
                          System.out.println(register.getRegistrationId()+" "+register.getRegisterationStatus());
                      }

                  }
                  catch(IndexOutOfBoundsException e){
                      System.out.println(INPUT_DATA_ERROR);
                  }
              }
              break;
              case "ALLOT":
              {
                  try{
                      String courseId = tokens.get(1);
                      List<Register> registerList= registerService.allotCourse(courseId);
                      registerList.forEach(register -> System.out.println(register.toString()));
                  }
                  catch(IndexOutOfBoundsException e){
                      System.out.println(INPUT_DATA_ERROR);
                  }
              }
              break;
              case "CANCEL":{
                  try{
                      String id = tokens.get(1);
                      Register r = registerService.cancelRegistrationIfNotCourseNotConfirmed(id);
                      System.out.println(r.getRegistrationId()+" "+r.getRegisterationStatus());
                  }
                  catch(IndexOutOfBoundsException e){
                      System.out.println(INPUT_DATA_ERROR);
                  }
              }
              break;
              default: {
                  System.out.println("Invalid command");
              }
              }
          }
          reader.close();
      } catch (Exception e) {
          e.printStackTrace();
      }

  }

  public static void printSystemInputError(){
        System.out.println(INPUT_DATA_ERROR);
  }
}
