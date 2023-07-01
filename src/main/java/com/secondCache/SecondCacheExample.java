package com.secondCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.akanksha.Student;

public class SecondCacheExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		// first
		Student srStudent = session.get(Student.class, 201);
		System.out.println(srStudent);

		session.close();

		Session session2 = factory.openSession();
		// second
		Student srStudent2 = session2.get(Student.class, 201);
		System.out.println(srStudent2);
		session2.close();
	}
}
