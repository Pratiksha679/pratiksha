package com.example.geektrust.services;

import com.example.geektrust.repository.ICourseRepository;
import com.example.geektrust.entities.Course;
public class CourseService {
  private final ICourseRepository courseRepository;

  public CourseService(ICourseRepository courseRepository){
    this.courseRepository = courseRepository;
  }

  public Course addCourseOffering(String courseTitle, String instructorName, String date, int min, int max){
    Course course = new Course(courseTitle,instructorName,date,min,max);
    return courseRepository.save(course);
  }


}
