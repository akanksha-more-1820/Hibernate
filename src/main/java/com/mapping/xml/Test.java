package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Person p1=new Person(23,"Ram","Delhi","1234567890");
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(p1);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
