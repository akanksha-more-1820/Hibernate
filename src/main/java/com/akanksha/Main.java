package com.akanksha;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

public class Main {
    public static void main(String[] args) throws IOException {
       
        
        Configuration con=new Configuration().configure();
        SessionFactory factory=con.buildSessionFactory();
        
        Student st=new Student();
        st.setId(104);
        st.setName("Dinkar");
        st.setCity("Dhankawadi");
        
        //address object
        
        Address add=new Address();
        add.setStreet("sahakarnagar");
        add.setCity("pune");
        add.setOpen(true);
        add.setAddedDate(new Date());
        add.setX(123.34);
        
        //reading image
        FileInputStream fis=new FileInputStream("src/main/java/image.jpg");
        byte[] data=new byte[fis.available()];
        add.setImage(data);
        
        Session session=factory.openSession();
         Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(add);
        tx.commit();
        System.out.println(st);
        session.close();
        System.out.println("session closed");    
        }
}