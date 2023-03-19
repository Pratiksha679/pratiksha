package com.example.geektrust.repository;

import com.example.geektrust.entities.Register;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import com.example.geektrust.entities.Course;
public class RegisterRepository implements  IRegisterRepository{

  public Map<String, Register> registerMap;
  public RegisterRepository(){
    registerMap = new HashMap<>();
  }

  @Override
  public Register save(Register register) {
    registerMap.put(register.getRegistrationId(),register);
    return register;
  }

  @Override
  public List<Register> getRegisterList(Course course) {
    return registerMap.values().stream().filter(r->r.getCourse()==course).collect(Collectors.toList());
  }

  @Override
  public Optional<Register> findById(String id) {
    return Optional.ofNullable(registerMap.get(id));
  }
}
