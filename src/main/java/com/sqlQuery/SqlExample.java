package com.sqlQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.akanksha.Student;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class SqlExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		String qString = "select * from student";

		 NativeQuery nQuery=session.createSQLQuery(qString);
		 
		 List<Object[]> list=nQuery.list();
		 
		 for(Object[] s:list) {
			 System.out.println(s[4]+":-"+s[3]);
		 }
		 
		session.close();
		factory.close();
	}

}
