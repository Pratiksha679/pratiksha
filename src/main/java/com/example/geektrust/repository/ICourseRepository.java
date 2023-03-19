package com.example.geektrust.repository;

import com.example.geektrust.entities.Course;
import java.util.Optional;
public interface ICourseRepository {
  Course save(Course course);
  Optional<Course> getById(String courseId);
}
