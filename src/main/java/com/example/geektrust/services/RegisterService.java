package com.example.geektrust.services;

import com.example.geektrust.repository.IRegisterRepository;
import com.example.geektrust.entities.Register;
import com.example.geektrust.entities.Course;
import com.example.geektrust.repository.ICourseRepository;
import com.example.geektrust.constants.RegisterStatus;
import java.util.List;
import java.util.Collections;
import com.example.geektrust.constants.CourseAllomentStatus;
public class RegisterService {
  private final IRegisterRepository registerRepository;
  private final ICourseRepository courseRepository;

  public RegisterService(IRegisterRepository registerRepository,ICourseRepository courseRepository){
    this.registerRepository =registerRepository;
    this.courseRepository =courseRepository;
  }

  public Register registerEmployeeToCourse(String employeeMailId, String courseId) {
    Course c = courseRepository.getById(courseId).orElseThrow(
        () -> new RuntimeException("Course with course Id " + courseId + " does not exist"));
    if (c.getMaxEmployees() == 0) {
      Register register = new Register(c, employeeMailId);
      register.setRegisterationStatus(RegisterStatus.COURSE_FULL_ERROR);
      return register;
    } else {
      String registerationId =
          "REG-COURSE-" + employeeMailId.split("@")[0] + "-" + courseId.split("-")[1];
      Register register = new Register(c, employeeMailId);
      register.setRegistrationId(registerationId);
      register.setRegisterationStatus(RegisterStatus.ACCEPTED);
      c.setMaxEmployees(c.getMaxEmployees() - 1);
      return registerRepository.save(register);
    }
  }
    public List<Register> allotCourse(String courseId){
      Course c = courseRepository.getById(courseId).orElseThrow(
          () -> new RuntimeException("Course with course Id " + courseId + " does not exist"));
      c.setCourseAllomentStatus(CourseAllomentStatus.CONFIRMED);
      List<Register> registerList= registerRepository.getRegisterList(c);
      Collections.sort(registerList,(Register a,Register b)-> a.getRegistrationId().compareTo(b.getRegistrationId()));
      return registerList;
    }

    public Register cancelRegistrationIfNotCourseNotConfirmed(String id){
       Register r = registerRepository.findById(id).orElseThrow(()-> new RuntimeException("Registration id "+id+ " is not found"));
       if(r.getCourse().getCourseAllomentStatus() != CourseAllomentStatus.CONFIRMED){
         r.setRegisterationStatus(RegisterStatus.CANCEL_ACCEPTED);
         return r;
      }
       else{
         r.setRegisterationStatus(RegisterStatus.CANCEL_REJECTED);
         return r;
       }
    }
}
