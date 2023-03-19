package com.example.geektrust.constants;

public enum CourseAllomentStatus {
  CONFIRMED("CONFIRMED");
  private String courseAllomentStatus;

  CourseAllomentStatus(String courseAllomentStatus){
    this.courseAllomentStatus=courseAllomentStatus;
  }

  public String getCourseAllomentStatus(){
    return courseAllomentStatus;
  }
}
