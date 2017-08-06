package edu.campus.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import edu.campus.dto.Faculty;
import edu.campus.dto.NoticeBoard;
import edu.campus.dto.Questions;
import edu.campus.dto.Requests;
import edu.campus.dto.Student;

public class FetchDAO {

	Session session; 
	Transaction tx;
	Criteria criteria;

	@SuppressWarnings("unchecked")
	public List<NoticeBoard> fetchNotices(Student stud, Faculty fac){
		System.out.println("inside fetchNotices of fetchDAO");
		session = HibSession.getSession();
		criteria = session.createCriteria(NoticeBoard.class);
		criteria.addOrder(Order.desc("notice_id"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(15);
		if(stud != null){
			criteria.add(Restrictions.or(Restrictions.eq("notice_dept", "all"), Restrictions.eq("notice_dept", stud.getDepartment())))
			.add(Restrictions.or(Restrictions.eq("notice_course", "all"), Restrictions.eq("notice_course", stud.getCourse())))
			.add(Restrictions.or(Restrictions.eq("notice_sem", "all"), Restrictions.eq("notice_sem", String.valueOf(stud.getSemester()))));
		}else if(fac != null){
			criteria.add(Restrictions.or(Restrictions.eq("notice_dept", "all"), Restrictions.eq("notice_dept", fac.getDepartment())));
		}

		List<NoticeBoard> notice = (List<NoticeBoard>) criteria.list();

		return notice;
	}

	@SuppressWarnings("unchecked")
	public List<Questions> fetchQnA(){
		System.out.println("inside fetchQnA of fetchDAO");
		session = HibSession.getSession();
		//session.flush();
		session.clear();
		tx = session.beginTransaction();
		try{
			criteria = session.createCriteria(Questions.class);
			criteria.addOrder(Order.desc("ques_id"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(20);
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		List<Questions> ques = (List<Questions>) criteria.list();
		return ques;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<List<Requests>> fetchRequests(){
		System.out.println("inside fetchRequests of fetchDAO");
		session = HibSession.getSession();
		criteria = session.createCriteria(Requests.class);
		criteria.add(Restrictions.isNull("resp"));
		criteria.addOrder(Order.desc("reqID"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(20);
		List<Requests> reqs = (List<Requests>) criteria.list();
		ArrayList<List<Requests>> rarr = new ArrayList<List<Requests>>();
		rarr.add(reqs);
		
		criteria = session.createCriteria(Requests.class);
		criteria.add(Restrictions.isNotNull("resp"));
		criteria.addOrder(Order.desc("reqID"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(20);
		List<Requests> respreqs = (List<Requests>) criteria.list();
		rarr.add(respreqs);
		
		return rarr;
	}
	
	public List<Student> viewProfilesStudent(){
		session = HibSession.getSession();
		criteria = session.createCriteria(Student.class);
		List<Student> stud = (List<Student>) criteria.list();
		return stud;
	}
	
	public List<Faculty> viewProfilesFaculty(){
		session = HibSession.getSession();
		criteria = session.createCriteria(Faculty.class);
		List<Faculty> fac = (List<Faculty>) criteria.list();
		return fac;
	}

}




















