package com.eab.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// use session obj to save java obj
			int studentId=1;
			
			// create a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student base on id
			System.out.println("\nGetting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setEmail("erandaka@yahoo.com");
			
			System.out.println("update emails of students");
			session.createQuery("update Student s set email = 'eaback@gmail.com' where s.email='erandaka@yahoo.com'").executeUpdate();
			
			System.out.println(myStudent);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("done!");
			 
		} finally {
			factory.close();
		}
	}

}
