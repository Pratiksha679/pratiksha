package com.example.geektrust.constants;

public enum RegisterStatus {
  ACCEPTED("ACCEPTED"), COURSE_FULL_ERROR("COURSE_FULL_ERROR"),
  CANCEL_ACCEPTED("CANCEL_ACCEPTED"), CANCEL_REJECTED("CANCEL_REJECTED");
  public String registerStatusDesc;


  RegisterStatus(String registerStatusDesc) {
    this.registerStatusDesc =registerStatusDesc;
  }

  public String getRegisterStatusDesc(){
    return registerStatusDesc;
  }
}
