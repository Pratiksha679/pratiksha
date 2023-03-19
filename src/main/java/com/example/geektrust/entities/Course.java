package com.example.geektrust.entities;


import java.util.List;
import java.util.ArrayList;
import com.example.geektrust.constants.CourseAllomentStatus;

public class Course {
  private String id;
  private String courseTitle;
  private String instructorName;
  private String date;
  private int minEmployees;
  private int maxEmployees;

  private CourseAllomentStatus courseAllomentStatus;

  private List<Register> registerList;

  public Course(String courseTitle, String instructorName, String date, int minEmployees, int maxEmployees, String id){
    this.courseTitle = courseTitle;
    this.instructorName = instructorName;
    this.date = date;
    this.minEmployees= minEmployees;
    this.maxEmployees = maxEmployees;
    this.id =id;
  }
  public Course(String courseTitle,String instructorName, String date, int minEmployees, int maxEmployees){
    this(courseTitle,instructorName,date,minEmployees,maxEmployees,"OFFERING-"+courseTitle+"-"+instructorName);
  }
  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getCourseTitle(){
    return courseTitle;
  }

  public void setCourseTitle(String courseTitle){
    this.courseTitle = courseTitle;
  }

  public String getInstructorName(){
    return instructorName;
  }

  public void setInstructorName(String instructorName){
    this.instructorName = instructorName;
  }

  public String getDate(){
    return date;
  }

  public void setDate(String date){
    this.date = date;
  }

   public int getMinEmployees(){
    return minEmployees;
   }

   public void setMinEmployees(int minEmployees){
    this.minEmployees = minEmployees;
   }

   public int getMaxEmployees(){
    return maxEmployees;
   }

   public void setMaxEmployees(int maxEmployees){
    this.maxEmployees = maxEmployees;
   }
   @Override
   public String toString(){
    return id+" "+courseTitle+" "+instructorName+" "+date+" "+courseAllomentStatus;
   }

   public List<Register> getEmployeeList(){
    return registerList;
   }

   public void setCourseAllomentStatus(CourseAllomentStatus courseAllomentStatus){
    this.courseAllomentStatus =courseAllomentStatus;
   }
   public CourseAllomentStatus getCourseAllomentStatus(){
    return courseAllomentStatus;
   }
}
