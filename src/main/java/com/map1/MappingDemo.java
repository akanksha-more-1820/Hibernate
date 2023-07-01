package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;import com.map.Question;

public class MappingDemo {

	public static void main(String args[]) {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		Employee emp1=new Employee();
		emp1.setEmpId(103);
		emp1.setEmpName("Akanksha");
		
		Employee emp2=new Employee();
		emp2.setEmpId(104);
		emp2.setEmpName("Aditya");
		
		Project p1=new Project();
		p1.setPid(203);
		p1.setProjectName("Coaching");
		
		Project p2=new Project();
		p2.setPid(204);
		p2.setProjectName("Login");
		
		List<Employee> list1=new ArrayList<Employee>();
		List<Project> list2=new ArrayList<Project>();
		
		list1.add(emp1);
		list1.add(emp2);
		
		list2.add(p1);
		list2.add(p2);
		
		emp1.setProject(list2);
		emp2.setProject(list2);
		p1.setEmployee(list1);
		
		session.save(emp1);
		session.save(emp2);
		session.save(p1);
		session.save(p2);
		
		
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
