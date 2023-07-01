package com.firstCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akanksha.Student;

public class FirstDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		// by default enabled

		Student student = session.get(Student.class, 202);
		System.out.println(student);
		
		System.out.println("working --------------------------");
		
		Student student2 = session.get(Student.class, 202);
		System.out.println(student);

		System.out.println(session.contains(student2));
		
		session.close();
		factory.close();
	}

}
