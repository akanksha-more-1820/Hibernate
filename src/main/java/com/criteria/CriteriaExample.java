package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.akanksha.Student;

public class CriteriaExample {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		
		 Criteria criteria=session.createCriteria(Student.class);
		 
		 //criteria.add(Restrictions.eq("certi.course", "SQL"));
		 //criteria.add(Restrictions.gt("id", 240));
		 criteria.add(Restrictions.like("certi.course", "Java%"));
		  List<Student> list= criteria.list();
		  
		  for(Student student: list) {
			  System.out.println(student);
		  }
		
		factory.close();
		session.close();
	}
}
