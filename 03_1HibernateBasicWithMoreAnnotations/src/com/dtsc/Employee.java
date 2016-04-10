package com.dtsc;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "EMPLOYEE2")
public class Employee {
   @Id 
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name = "empid")
   private int id;

   @Column(name = "first_name",nullable=false,length=30)
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "salary")
   private int salary; 
   

   
   @Type(type="yes_no")

   private boolean active;
   
   @Temporal(TemporalType.TIMESTAMP)
   //@Temporal(TemporalType.DATE)
  //@Temporal(TemporalType.TIME)
   private Date currentDate;
   
   
   
   @Transient
   private String country;
   
   


   
public Date getCurrentDate() {
	return currentDate;
}
public void setCurrentDate(Date currentDate) {
	this.currentDate = currentDate;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}

public Employee() {}
   public int getId() {
      return id;
   }
   public void setId( int id ) {
      this.id = id;
   }
   public String getFirstName() {
      return firstName;
   }
   public void setFirstName( String first_name ) {
      this.firstName = first_name;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName( String last_name ) {
      this.lastName = last_name;
   }
   public int getSalary() {
      return salary;
   }
   public void setSalary( int salary ) {
      this.salary = salary;
   }
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
   
}