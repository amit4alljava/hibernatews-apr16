package com.srivastava.basics;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {
		Employee ram = new Employee();  // Transient Object
		ram.setId(1003);
		ram.setName("Tim");
		ram.setDateOfJoining(new Date());
		ram.setSalary(9000.00);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//SessionFactory sf = (SessionFactory) new Configuration().configure(path); This is for When you have multiple DataBase Use in Hibernate so multiple cfg.xml file will be create
		// eg. hibernate-oracle.cfg.xml , hibernate-mysql.cfg.xml
		
		Session session = sessionFactory.openSession();
		Transaction transaction =session.beginTransaction();
		session.save(ram);
		ram.setSalary(8989);  // Attach or Persistance Object
		ram.setSalary(7777);
		transaction.commit();
		session.close();
		sessionFactory.close();
		ram.setSalary(8989); //Deattach Object
		System.out.println("Record Added SuccessFully...");
		
		

	}

}
