package com.example.geektrust.repository;

import com.example.geektrust.entities.Course;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
public class CourseRepository implements ICourseRepository {
  public Map<String, Course> courseMap;

  public CourseRepository(){
    courseMap = new HashMap<String, Course>();
  }
  @Override
  public Course save(Course course) {
    courseMap.put(course.getId(),course);
    return course;
  }

  @Override
  public Optional<Course> getById(String courseId) {
    return Optional.ofNullable(courseMap.get(courseId));
  }
}
