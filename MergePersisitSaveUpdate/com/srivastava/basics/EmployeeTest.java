package com.srivastava.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeTest {
	
	public static void save(Employee emp){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(emp);
		//session.saveOrUpdate(emp);
		session.persist(emp);
		transaction.commit();
		session.close();
		
		System.out.println("Record Added...");
		
	}
	
	public static void saveDeatached(Employee emp){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session firstSession = factory.openSession();
		Transaction transaction = firstSession.beginTransaction();
		//firstSession.save(emp);
		//firstSession.saveOrUpdate(emp);
		firstSession.persist(emp);
		//firstSession.update(emp);
		
		transaction.commit();
		firstSession.close();
		System.out.println("Record Added...");
		emp.setSalary(emp.getSalary()+ 9999);
		Session secondSession = factory.openSession();
		transaction = secondSession.beginTransaction();
		//secondSession.update(emp);
		//secondSession.save(emp);
		//secondSession.saveOrUpdate(emp);
		secondSession.persist(emp);
		
		transaction.commit();
		secondSession.close();
		System.out.println("2nd Time Updation...");
		
		
		
		
		
	}
	/*
	 * If you load an object instance in the first Hibernate session, then close the session, 
	 * that instance becomes detached. If you open a new session, then load the same object (same ID)
	 * , Hibernate will construct a new instance, and if you try to use saveOrUpdate on the
	 *  object obtained in the first session, Hibernate will throw a NonUniqueObjectException.
	 * Merge is a way to tell Hibernate "I want you assume any changes I made to this 
	 * Hibernate entity should be saved, even if I made them to a different instance of the 
	 * object than the once I'm asking you to save." SaveOrUpdate is a way to tell 
	 * Hibernate to be more conservative and throw an Exception instead.
	 */
	public static void updateOrMerge(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Employee emp = (Employee)session.get(Employee.class, 1);
		System.out.println("Emp Object is "+emp);
		session.close();
		// Deattach
		emp.setName("Mac Mike1");
		session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		Employee emp2 = (Employee)session.get(Employee.class, 1);
		if(emp==emp2){
			System.out.println("Same Ref");
		}
		else
		{
			System.out.println("Not Same Ref");
		}
		//session.update(emp);
		
		
		Employee empObject =(Employee)session.merge(emp);
		if(empObject == emp){
			System.out.println("Same Ref (Merge)");
		}
		else
		{
			System.out.println("Not Same Ref (Merge)");
		}
		transaction.commit();
		
		session.close();
		factory.close();
		System.out.println("Updated...");
		
		
		
		
	}
	
	public static void getVsLoad(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Employee emp = (Employee)session.get(Employee.class, 1);
		System.out.println("GET --> Emp Object HashCode is "+emp.hashCode());
		System.out.println("Using GET Employee Id is "+emp.getId());
		System.out.println("Now Full Employee Object is "+emp);
		//Employee emp = (Employee)session.load(Employee.class, 10);
		//System.out.println("Emp is "+emp);
		session.close();
		session = factory.openSession();
		emp = (Employee)session.load(Employee.class, 1);
		System.out.println("LOAD --> Emp Object HashCode is "+emp.hashCode());
		System.out.println("Using Load Employee Id is "+emp.getId());
		System.out.println("Now Full Employee Object is "+emp);
		//Employee emp = (Employee)session.load(Employee.class, 10);
		//System.out.println("Emp is "+emp);
		session.close();
		factory.close();
	}

	public static void main(String[] args) {
		Employee obj = new Employee();
		//obj.setId(1001);
		obj.setName("Mike");
		obj.setSalary(7090);
		//save(obj);
		saveDeatached(obj);
		//updateOrMerge();
		//getVsLoad();

	}

}
