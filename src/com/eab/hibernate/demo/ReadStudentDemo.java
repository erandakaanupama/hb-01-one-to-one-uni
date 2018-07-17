package com.eab.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("test", "bandara", "eab@gmail.com");
			
			// begin a transaction 
			session.beginTransaction();
			
			// save the student object
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			//System.out.println("Saved student. Generated Id: " + student.getId());
			
			// create a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student base on id
			System.out.println("\nGetting student id: " + student.getId());
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println(myStudent);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("done!");
			 
		} finally {
			factory.close();
		}
	}

}