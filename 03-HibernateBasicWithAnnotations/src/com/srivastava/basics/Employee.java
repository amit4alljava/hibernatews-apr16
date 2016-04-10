package com.srivastava.basics;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="Emp_MST")
public class Employee {
@Id	
private int id;
@Column(name="ename",nullable=false,length=50,unique=true)
private String name;
private double salary;
@Temporal(TemporalType.DATE)
private Date dateOfJoining;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public Date getDateOfJoining() {
	return dateOfJoining;
}
public void setDateOfJoining(Date dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
			+ ", dateOfJoining=" + dateOfJoining + "]";
}

}
