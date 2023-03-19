package com.example.geektrust.repository;

import com.example.geektrust.entities.Register;
import java.util.Optional;
import java.util.List;
import com.example.geektrust.entities.Course;
public interface IRegisterRepository {
  Register save( Register register);

  List<Register> getRegisterList(Course course);

  Optional<Register> findById(String id);
}
