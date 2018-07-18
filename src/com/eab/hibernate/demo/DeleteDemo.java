package com.eab.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.hibernate.demo.entity.Instructor;
import com.eab.hibernate.demo.entity.InstructorDetail;
import com.eab.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// create objects
			Instructor instructor = new Instructor("nimal", "karunarathne", "nimalkarunarathne@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube/nimalwatchwork","film");
			
			// associate objects
			instructor.setInstructorDetail(instructorDetail);
			
			// begin transaction
			session.beginTransaction();
			
			// save instructor
			System.out.println("saving instructor...");
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

}
