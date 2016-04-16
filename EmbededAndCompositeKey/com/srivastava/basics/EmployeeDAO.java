package com.srivastava.basics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		CompositeKey ck = new CompositeKey();
		ck.setEmail("ram@yahoo.com");
		ck.setPhone("2222");
		ram.setCompKey(ck);
		//ram.setId(id);
		ram.setName(name);
		ram.setSalary(salary);
		ram.setJoiningDate(joiningDate);
		Address address = new Address();
		address.setCity("Noida");
		address.setState("UP");
		address.setZipCode("2222");
		/*ram.setResaddress(address);*/
		
		Address offaddress = new Address();
		offaddress.setCity("Noida");
		offaddress.setState("UP");
		offaddress.setZipCode("3222");
		/*ram.setOffaddress(offaddress);*/
		List<Address> addressList = new ArrayList<>();
		addressList.add(address);
		addressList.add(offaddress);
		//ram.setAddressList(addressList);
		
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
