package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.akanksha.Certificate;
import com.akanksha.Student;

public class StateDemo {

	public static void main(String args[]) {

		// Transient

		// Detached

		// Removed

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// creating student object
		// student in transient object
		Student student = new Student();
		student.setId(303);
		student.setName("Vidya");
		student.setCity("shivaji nagar");
		student.setCerti(new Certificate("Java Hibernate", "11 months"));

		// Persistent
		Session session = factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(student);
		
		
		transaction.commit();
		
		//detached state
		
		student.setName("xyz");
		System.out.println(student.getName());
		
		//removed
		session.delete(student);
		session.close();

		factory.close();
		
		

	}
}
