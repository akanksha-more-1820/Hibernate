package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String args[]) {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		
//		Question q1=new Question();
//		q1.setQuestion_id(101);
//		q1.setQuestion("what is java");
//		
//		Answer ans1=new Answer();
//		ans1.setAnswer_id(201);
//		ans1.setAnswer("prog lang");
//		ans1.setQuestion(q1);
//		
//		Answer ans2=new Answer();
//		ans2.setAnswer_id(202);
//		ans2.setAnswer("we can create softwares");
//		ans2.setQuestion(q1);
//		
//		Answer ans3=new Answer();
//		ans3.setAnswer_id(203);
//		ans3.setAnswer("has diff frame works");
//		ans3.setQuestion(q1);
//		
//		List<Answer> list=new ArrayList<Answer>();
//		list.add(ans1);
//		list.add(ans2);
//		list.add(ans3);
//		
//		q1.setAnswers(list);
		
		
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
//		session.save(q1);
//		session.save(ans1);
//		session.save(ans2);
//		session.save(ans3);
//		
		
		Question question=session.get(Question.class, 101);
		System.out.println(question.getQuestion());
		System.out.println(question.getAnswers().size());
//		for(Answer a: question.getAnswers()) {
//			System.out.println(a.getAnswer());
//		}
		
		tx.commit();
		
		//fetch
		
//		System.out.println(session.get(Question.class,101).getQuestion());
//		System.out.println(session.get(Answer.class,201).getAnswer());
		
		session.close();
		sessionFactory.close();
	}
}
