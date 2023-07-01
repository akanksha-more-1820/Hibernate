package com.akanksha;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class FetchDemo {

	public static void main(String args[]) {
		//get, load
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf= cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		// get student 101
		Student st=session.get(Student.class, 104);
		Address ad=session.load(Address.class, 1);
		System.out.println(st);
		System.out.println(ad.getCity());
		
		session.close();
		sf.close();
		
		
		
	}
	
}
