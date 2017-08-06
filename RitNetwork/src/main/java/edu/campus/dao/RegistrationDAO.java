package edu.campus.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.campus.dto.Faculty;
import edu.campus.dto.Student;

public class RegistrationDAO {
	Session session;
	
	
	// method to save record of new student 
	public int registerStud(Student st){
		session = HibSession.getSession();
		Transaction tx = session.beginTransaction();
		try{
			session.save(st);
			tx.commit();
			return 0;
		}catch (Exception e) {
			tx.rollback();
			return -1;
		}
	}
	
	// method to save record of new faculty
	public int registerFac(Faculty st){
		session = HibSession.getSession();
		Transaction tx = session.beginTransaction();
		try{
			session.save(st);
			tx.commit();
			return 0;
		}catch (Exception e) {
			tx.rollback();
			return -1;
		}
	}
	
	// authenticate Student credentials
	public Student validateStud(String email, String pass){
		session = HibSession.getSession();
		Query qry = session.createQuery("from Student where email=:name and password=:pass");
		qry.setParameter("name", email);
        qry.setParameter("pass", pass);
        Student stud = (Student)qry.uniqueResult();
        return stud;
	}
	
	// authenticate Faculty credentials
	public Faculty validateFac(String email, String pass){
		session = HibSession.getSession();
		Query qry = session.createQuery("from Faculty where email=:name and password=:pass");
		qry.setParameter("name", email);
        qry.setParameter("pass", pass);
        System.out.println(email);
        System.out.println(pass);
        Faculty fac = (Faculty)qry.uniqueResult();
        return fac;
	}
	
	
}
