package com.eab.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			System.out.println("begin query");
			// start transaction
			session.beginTransaction();

			// query students
			List<Student> studentList = session.createQuery("from Student").getResultList();
			printResult(studentList);

			// query students: last name starts with an
			studentList = session.createQuery("from Student s where s.lastName ='karunarathne'").getResultList();
			printResult(studentList);

			// query students: firstName=eab/ lastName=karunarathne
			studentList = session.createQuery("from Student s where s.firstName ='eab' or s.lastName='karunarathne'")
					.getResultList();
			printResult(studentList);
			
			// query students: first name like an%
			studentList = session.createQuery("from Student s where s.firstName like 'an%'").getResultList();
			printResult(studentList);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

	private static void printResult(List<Student> students) {
		System.out.println("\nPrintin result list");
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
