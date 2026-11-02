package com.library;
import java.io.Serializable;
public class Member implements Serializable{
	private static final long serialVersionUID = 1L;
private int memberId;

private String name;
private String phone;


  public Member(int memberId , String name,String phone) {
	  this.memberId=memberId;
	  this.name=name;
	  this.phone=phone;
  }
  
  

  public int getMemberId() {
	  return memberId;
  }
  
  public String getName() {
	  return name;
  }

  public String getPhone() {
	  return phone;
  }


  @Override
  public String toString() {
	return "Member [memberId=" + memberId + ", name=" + name + ", phone=" + phone + "]";
  }
  
  
}
