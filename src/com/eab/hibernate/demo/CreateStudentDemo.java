package com.eab.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// use session obj to save java obj
			
			// create Student object
			System.out.println("creating new student object");
			Student student = new Student("eab", "bandara", "eab@gmail.com");
			
			// begin a transaction 
			session.beginTransaction();
			
			// save the student object
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
			
		} finally {
			factory.close();
		}
	}

}
