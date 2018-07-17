package com.eab.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating new student objects");
			Student student1 = new Student("anj","karunarathne","anj@gmail.com");
			Student student2 = new Student("nimal","karunarathne","asw@gmail.com");
			Student student3 = new Student("anoja","karunarathne","anoja@gmail.com");
			
			session.beginTransaction();
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
			System.out.println("done!");
			
		} finally {
			factory.close();
		}

	}

}
