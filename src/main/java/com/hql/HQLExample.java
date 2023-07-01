package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

import com.akanksha.Student;

public class HQLExample {

	public static void main(String[] args) {

		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		String queryString="from Student where city='Dhankawadi'";
		String queryString2="from Student as s where s.city= :x and s.name=:n";
		
	
		
		Session session=factory.openSession();
		
		Query query=session.createQuery(queryString);
		Query query2=session.createQuery(queryString2);
		
		query2.setParameter("x", "shivaji nagar");
		query2.setParameter("n", "Vidya");
		
		List<Student> list=query.list();
		List<Student> list2=query2.list();
		
		for(Student s:list) {
			System.out.println(s.getName() +" "+ s.getCerti());
		}
		
		for(Student s:list2) {
			System.out.println(s.getName() +" "+ s.getCerti().getCourse());
		}
		
		System.out.println("-----------------delete example---------------------------");
		
		Transaction txTransaction=session.beginTransaction();
		
//		Query query3=session.createQuery("delete from Student where name =:n");
//		query3.setParameter("n", "Vidya");
//		
//		int no=  query3.executeUpdate();
		
		System.out.println("-----------------update example---------------------------");
		
//		Query q4=session.createQuery("update Student set city=:c where name=:n");
//		q4.setParameter("c", "Kolhapur");
//		q4.setParameter("n", "Dinkar");
//		
//		int no= q4.executeUpdate();
//		System.out.println(no);
//		txTransaction.commit();
		
		System.out.println("-----------------join example---------------------------");
		
		Query q5=session.createQuery("select q.question, q.question_id  from Question as q INNER JOIN answers as a");
		
		 List<Object[]> list3=q5.getResultList();
		 
		 for(Object[] arr:list3) {
			 System.out.println(arr.toString());
		 }
		 
		session.close();
		factory.close();
	}
}
