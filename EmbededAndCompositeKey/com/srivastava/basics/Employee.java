package com.srivastava.basics;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Emp_tab7")
public class Employee {
	/*@Id
	private int id;*/
	
	// Composite Key 
	@EmbeddedId
	private CompositeKey compKey;
	
	
	
	public CompositeKey getCompKey() {
		return compKey;
	}
	public void setCompKey(CompositeKey compKey) {
		this.compKey = compKey;
	}
	@Column(name="empname" , nullable=false)
	private String name;
	private double salary;
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	/*@Embedded
	private Address resaddress;   // Has - A RelationShip
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="city", column=@Column(name="officecity")),
        @AttributeOverride(name="state", column=@Column(name="officestate")),
        @AttributeOverride(name="zipCode", column=@Column(name="officezipcode"))
        
    })
	private Address offaddress;   // Has - A RelationShip
*/	
	/*@ElementCollection
	@JoinTable(name="Emp_Address_Mapping",joinColumns=@JoinColumn(name="emp_id"))
	private List<Address> addressList ;*/
	
	
	
	
	/*@Embedded
	private Address address;  // Has - A 
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="city", column=@Column(name="officecity")),
        @AttributeOverride(name="state", column=@Column(name="officestate")),
        @AttributeOverride(name="zipCode", column=@Column(name="officezipcode"))
        
    })*/
	
/*	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}*/
	/*public Address getResaddress() {
		return resaddress;
	}
	public void setResaddress(Address resaddress) {
		this.resaddress = resaddress;
	}
	public Address getOffaddress() {
		return offaddress;
	}
	public void setOffaddress(Address offaddress) {
		this.offaddress = offaddress;
	}*/
	//private Address offaddress; 
	//@ElementCollection
	//@JoinTable(name="Emp_Address_Mapping",joinColumns=@JoinColumn(name="emp_id"))
	//private Set<Address> address = new HashSet<Address>();
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
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
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	/*public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}*/
	
	
	
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	
	
	
	/*public Address getOffaddress() {
		return offaddress;
	}
	public void setOffaddress(Address offaddress) {
		this.offaddress = offaddress;
	}*/
	/*@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", joiningDate=" + joiningDate + ", address=" + address + "]";
	}*/
	
	
	/*public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}*/
	/*@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", joiningDate=" + joiningDate + ", address=" + address + "]";
	}*/
	
	
	
	

}
