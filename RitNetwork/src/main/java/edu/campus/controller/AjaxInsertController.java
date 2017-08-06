package edu.campus.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.campus.dao.InsertionDAO;
import edu.campus.dto.Activities;
import edu.campus.dto.Faculty;
import edu.campus.dto.NoticeBoard;
import edu.campus.dto.Q_answers;
import edu.campus.dto.Questions;
import edu.campus.dto.Requests;
import edu.campus.dto.Response;
import edu.campus.dto.Student;

@Controller
public class AjaxInsertController {

	ModelAndView mv;
	HttpSession sess;
	@Autowired
	InsertionDAO idao;
	
	@Autowired
	ApplicationContext factory;
	

	@RequestMapping("/insNotice")
	public void insertNotice(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("in controller insnotice");
		
		sess = req.getSession(false);
		Enumeration e1 = sess.getAttributeNames();
		while ( e1.hasMoreElements() )
		{
		String key = (String)e1.nextElement();
		System.out.println("login controller :"+ key + " = " + sess.getAttribute( key ) + " <br>" );
		}
		
		
		Faculty facobj = (Faculty) sess.getAttribute("userobj");
		NoticeBoard notice = new NoticeBoard();
		notice.setFac(facobj);
		notice.setNotice_desc(req.getParameter("desc"));
		notice.setNotice_dept(req.getParameter("dept"));
		notice.setNotice_course(req.getParameter("course"));
		notice.setNotice_sem(req.getParameter("sem"));
		Date date = new Date();
		notice.setNotice_date(date);
		try{
			if(idao.insertNotice(notice) == 0){
				System.out.println("returned to controller insnotice from insertion dao");
				resp.getWriter().write("true");
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/insQues")
	public void insertQuestion(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("in controller insQues");
		sess = req.getSession(false);
		Student studobj = (Student) sess.getAttribute("userobj");
		Questions ques = new Questions();
		ques.setStud(studobj);
		Date date = new Date();
		ques.setQues_time(date);
		ques.setQuestion(req.getParameter("ques"));
		try{
			if(idao.insertQuestion(ques) == 0){
				System.out.println("returned to controller insQues from insertion dao");
				resp.getWriter().write("true");
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/insReq")
	public void insertRequest(@RequestParam("req_title") String title, @RequestParam("desc") String desc,HttpServletRequest req, HttpServletResponse resp){
		System.out.println("in controller insReq");
		sess = req.getSession(false);
		Student stud = (Student) sess.getAttribute("userobj");
		Requests reqobj = new Requests();
		reqobj.setStud(stud);
		Date date = new Date();
		reqobj.setReq_date(date);
		reqobj.setReq_title(title);
		reqobj.setReq_desc(desc);
		try{
			if(idao.insertRequest(reqobj) == 0){
				System.out.println("returned to controller insReq from insertion dao");
				resp.getWriter().write("true");
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/insertResp")
	public void insertResp(HttpServletRequest req, HttpServletResponse resp){
		Response respobj = new Response();
		respobj.setResp(req.getParameter("resp_textarea"));
		System.out.println("values in servlet: reqid "+req.getParameter("reqid")+" date "+req.getParameter("date"));
		Date date = new Date();
		System.out.println("date generated : "+date);
		respobj.setResDate(date);
		respobj.setAllot_date(req.getParameter("date"));
		sess = req.getSession(false);
		respobj.setFac((Faculty) sess.getAttribute("userobj"));
		System.out.println("printing faculty object in insertresponse controller " +(Faculty) sess.getAttribute("userobj"));
		int reqid = Integer.parseInt(req.getParameter("reqid"));
		try{
			if(idao.insertResp(respobj, reqid) == 0){
				System.out.println("inserted response and back in controller");
				System.out.println("printing faculty object in insertresponse controller after inserting : " +(Faculty) sess.getAttribute("userobj"));
				resp.getWriter().write("true");
				//mv = new ModelAndView();
				//mv.setViewName("requests.jsp");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//return mv;
	}
	
	
	@RequestMapping("/updateStud")
	public void updateStudent(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("in controller updateStud");
		sess = req.getSession(false);
		Student stud = (Student) sess.getAttribute("userobj");
		stud.setAbout(req.getParameter("about"));
		stud.setName(req.getParameter("name"));
		String str = req.getParameter("sem");
		int sem = Integer.parseInt(str.replaceAll("\\s", ""));
		stud.setSemester(sem);
		String phn = req.getParameter("phno");
		long phno = Long.parseLong(phn.replaceAll("\\s", ""));
		stud.setPhoneNo(phno);
		stud.setSkills(req.getParameter("skills"));
		stud.setHobbies(req.getParameter("hobbies"));
		try{
			if(idao.updateStudent(stud) == 0){
				System.out.println("returned to controller updateStud from insertion dao");
				sess.setAttribute("userobj", stud);
				resp.getWriter().write("true");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/updateFac")
	public void updateFaculty(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("in controller updateFac");
		sess = req.getSession(false);
		Faculty fac = (Faculty) sess.getAttribute("userobj");
		fac.setAbout(req.getParameter("about"));
		fac.setName(req.getParameter("name"));
		fac.setSubjects(req.getParameter("subs"));
		
		String phn = req.getParameter("phno");
		long phno = Long.parseLong(phn.replaceAll("\\s", ""));
		fac.setPhoneNo(phno);
		try{
			if(idao.updateFaculty(fac) == 0){
				System.out.println("returned to controller updateFac from insertion dao");
				sess.setAttribute("userobj", fac);
				resp.getWriter().write("true");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/reqInterested")
	public void reqInterested(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("inside reqInterested controller");
		sess = req.getSession(false);
		Student stud = (Student) sess.getAttribute("userobj");
		int id = Integer.parseInt(req.getParameter("reqid"));
		try {
			if(idao.reqInterested(stud, id) == 0){
				System.out.println("returned to controller reqInterested from insertion dao");
				resp.getWriter().write("true");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/insans")
	public void insans(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("insert insans");
		sess = req.getSession(false);
		Q_answers ans = new Q_answers();
		String type = (String) sess.getAttribute("type");
		if(type.equals("student")){
			ans.setStud((Student)sess.getAttribute("userobj"));
		}else if(type.equals("faculty")){
			ans.setFac((Faculty)sess.getAttribute("userobj"));
		}
		int id = Integer.parseInt(req.getParameter("quesid"));
		Date date = new Date();
		ans.setAns_time(date);
		ans.setAnswer_desc(req.getParameter("ansDesc"));
		ans.setUser_type(type);
		if(idao.insans(id, ans)==0){
			System.out.println("back in insans from dao");
			try {
				resp.getWriter().write("true");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/insact")
	public void insact(HttpServletRequest req, HttpServletResponse resp){
		sess = req.getSession(false);
		Activities act = new Activities();
		Date date = new Date();
		act.setActpostdate(date);
		act.setActDate(req.getParameter("actdatetime"));
		act.setActEndDate(req.getParameter("actenddate"));
		act.setActName(req.getParameter("acttitle"));
		act.setActDesc(req.getParameter("actdesc"));
		act.setStud((Student)sess.getAttribute("userobj"));
		if(idao.insertact(act)==0){
			System.out.println("saved activity back in controller");
			try {
				resp.getWriter().write("true");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}













