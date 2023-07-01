package com.akanksha;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class EmbeddedDemo {

	public static void main(String args[]) {
		
		Configuration cong= new Configuration();
		cong.configure("hibernate.cfg.xml");
		
		SessionFactory sf= cong.buildSessionFactory();
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Student student1=new Student();
		student1.setId(201);
		student1.setName("Vedangi");
		student1.setCity("Taljai");
		
		Certificate certi=new Certificate();
		certi.setCourse("Hibernate");
		certi.setDuration("2 months");
		student1.setCerti(certi);
		
		Student student2=new Student();
		student2.setId(202);
		student2.setName("Rudra");
		student2.setCity("Taljai");
		
		Certificate certi2=new Certificate();
		certi2.setCourse("SQL");
		certi2.setDuration("2 months");
		student2.setCerti(certi2);
		
		session.save(student1);
		session.save(student2);
		
		tx.commit();
		session.close();
		sf.close();
		
	}
}
