package edu.campus.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.campus.dto.Activities;
import edu.campus.dto.Faculty;
import edu.campus.dto.NoticeBoard;
import edu.campus.dto.Q_answers;
import edu.campus.dto.Questions;
import edu.campus.dto.Requests;
import edu.campus.dto.Response;
import edu.campus.dto.Student;

public class InsertionDAO {

	Session session;
	Transaction tx;
	
	
	public int insertNotice(NoticeBoard notice){
		session = HibSession.getSession();
		tx = session.beginTransaction();
		try{
			session.save(notice);
			tx.commit();
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error while inserting notice");
			tx.rollback();
			return -1;
		}
	}
	
	public int insertact(Activities act){
		session = HibSession.getSession();
		tx = session.beginTransaction();
		try{
			session.save(act);
			tx.commit();
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error while inserting activity");
			tx.rollback();
			return -1;
		}
	}
	
	public int insertQuestion(Questions ques){
		session = HibSession.getSession();
		System.out.println("called dao");
		tx = session.beginTransaction();
		System.out.println(ques);
		System.out.println(ques.getStud().getName());
		try{
			session.save(ques);
			tx.commit();
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error while inserting question");
			tx.rollback();
			return -1;
		}
	}
	
	public int insans(int id, Q_answers ans){
		session = HibSession.getSession();
		tx = session.beginTransaction();
		Questions ques = (Questions) session.get(Questions.class, id);
		ans.setQues(ques);
		try{
			session.save(ans);
			tx.commit();
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return -1;
		}
		
	}
	
	public int insertRequest(Requests reqs){
		session = HibSession.getSession();
		System.out.println("called dao");
		tx = session.beginTransaction();
		try{
			session.save(reqs);
			tx.commit();
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error while inserting request");
			tx.rollback();
			return -1;
		}
	}
	
	public int updateStudent(Student stud){
		session = HibSession.getSession();
		tx = session.beginTransaction();
		try{
			session.update(stud);
			tx.commit();
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error while updating student");
			tx.rollback();
			return -1;
		}
	}

	public int updateFaculty(Faculty fac) {
		session = HibSession.getSession();
		tx = session.beginTransaction();
		try{
			session.update(fac);
			tx.commit();
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error while updating faculty");
			tx.rollback();
			return -1;
		}
	}
	
	public int insertResp(Response resp,int id){
		session = HibSession.getSession();
		tx = session.beginTransaction();
		Requests req = null;
		try{
			session.save(resp);
		}catch (Exception e) {
			System.out.println("error while saving resp");
			e.printStackTrace();
			tx.rollback();
			return -1;
		}
		try{
			req = (Requests) session.get(Requests.class, id);
			req.setResp(resp);
			session.update(req);
			tx.commit();
			return 0;
		}
		catch (Exception e) {
			System.out.println("error while inserting response");
			e.printStackTrace();
			tx.rollback();
			return -1;
		}
	}
	
	public int reqInterested(Student stud, int id){
		session = HibSession.getSession();
		tx = session.beginTransaction();
		Requests req = null;
		req = (Requests) session.get(Requests.class, id);
		req.getStudReqInterested().add(stud);
		try{
			session.save(req);
			tx.commit();
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return -1;
		}
	}
	
	
}











