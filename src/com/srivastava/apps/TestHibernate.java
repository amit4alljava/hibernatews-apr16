package com.srivastava.apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {
		// This Line Read the hibernate.cfg.xml file
		SessionFactory sf = new Configuration()
		.configure().buildSessionFactory();
		// Connection Open
		Session session = sf.openSession();	
		Transaction trans = session.beginTransaction();
		/*Employee ram = new Employee();
		ram.setEmpid(1003);
		ram.setName("Mike");
		ram.setSalary(9090);
		session.save(ram); // Insert 
*/		
		//Employee emp = (Employee)session.load(Employee.class, 1009);
		
		Employee emp = (Employee)session.get(Employee.class, 1009);
		System.out.println("I am Here");
		if(emp==null){
			System.out.println("Not Found...");
		}
		else{
			System.out.println("Iam Here2");
			System.out.println("Found "+emp.getName()+" "+emp.getSalary());
			emp.setName("Abcd");
			//Employee e = new Employee();
			//e.setName("Xyz");
			///session.update(e);
			//session.delete(emp);
			
		}
		
		trans.commit();
		session.close();
		//System.out.println("Record Added....");
	}

}
