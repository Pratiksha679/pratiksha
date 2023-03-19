package com.example.geektrust.entities;
import com.example.geektrust.constants.RegisterStatus;
public class Register {
  private String registrationId;
  private String employeeMail;
  private Course course;

  private RegisterStatus registerationStatus;

  public Register(Course course,String employeeMail,String registrationId){
    this.course = course;
    this.employeeMail =employeeMail;
    this.registrationId =registrationId;
  }

  public Register(Course course,String employeeMail){
    this(course,employeeMail, null);
  }

  public String getRegistrationId(){
    return registrationId;
  }

  public void setRegistrationId(String registrationId){
    this.registrationId = registrationId;
  }

  public Course getCourse(){
    return course;
  }

  public void setCourse(Course course){
    this.course =course;
  }

  public String getEmployeeMail(){
    return employeeMail;
  }

  public void setEmployeeMail(String employeeMail){
    this.employeeMail =employeeMail;
  }

  public RegisterStatus getRegisterationStatus(){
    return registerationStatus;
  }

  public void setRegisterationStatus(RegisterStatus registerationStatus) {
    this.registerationStatus = registerationStatus;
  }

  @Override
  public String toString(){
    return registrationId+" " +employeeMail+" " +course;
  }
}
