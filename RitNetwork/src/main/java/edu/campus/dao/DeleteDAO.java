package edu.campus.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.campus.dto.NoticeBoard;

public class DeleteDAO {
	
	Session session; 
	Transaction tx;
	Criteria criteria;

	public int delNotice(int id){
		session = HibSession.getSession();
		tx= session.beginTransaction();
		try{
			NoticeBoard notice = (NoticeBoard) session.load(NoticeBoard.class, id);
			session.delete(notice);
			tx.commit();
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return 1;
		}
		
	}
	
}
