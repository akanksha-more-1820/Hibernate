package com.HQLPagination;

import org.hibernate.query.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.akanksha.Student;



public class HQLPagination {
	
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		
		
		Query  q1=session.createQuery("from Student");
		
		//implementing pagination
		
		q1.setFirstResult(3);
		q1.setMaxResults(3);
		List<Student> list=q1.list();
		
		for(Student s:list) {
			System.out.println(s.getId()+" "+ s.getName()+" "+s.getCity());
		}
		
		
		
		
		
		session.close();
		factory.close();
	}

}
