package com.srivastava.basics;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
     


	public void add(int id, String name, double salary, Date joiningDate)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Employee ram = new Employee();
		ram.setId(id);
		ram.setName(name);
		ram.setSalary(salary);
		ram.setJoiningDate(joiningDate);
		Address address = new Address();
		address.setCity("Noida");
		address.setState("UP");
		address.setZipCode("2222");
		ram.setAddress(address);
		//ram.setAddress(address);
		//Address offaddress = new Address();
		/*offaddress.setCity("Mumbai");
		offaddress.setState("MH");
		offaddress.setZipCode("3333");
		Set<Address> set = new HashSet<>();
		set.add(address);
		set.add(offaddress);*/
		//ram.setAddress(set);
		//ram.setOffaddress(offaddress);
		/*Address address = new Address();
		address.setCity("Noida");
		address.setState("UP");
		address.setZipCode("2222");
		Set<Address> addressSet = new HashSet<Address>();
		addressSet.add(address);
		address = new Address();
		address.setCity("Greater Noida");
		address.setState("UP");
		address.setZipCode("3333");
		addressSet.add(address);
		ram.setAddress(addressSet);*/
		session.save(ram);
		transaction.commit();
		session.close();

	}
	
}
