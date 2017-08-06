package edu.campus.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.campus.dao.FetchDAO;
import edu.campus.dto.Faculty;
import edu.campus.dto.NoticeBoard;
import edu.campus.dto.Questions;
import edu.campus.dto.Requests;
import edu.campus.dto.Student;

@Controller
public class FetchController {
	

	ModelAndView mv;
	HttpSession sess;
	
	@Autowired
	ApplicationContext factory;
	
	@Autowired
	FetchDAO fdao;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/fetchHome")
	public ModelAndView fecthHome(HttpServletRequest req, HttpServletResponse resp){
		
		System.out.println("in fetchhome");
		List<NoticeBoard> notice = null;
		Student stud;
		Faculty fac;
		
		sess = req.getSession(false);
		
		Enumeration e1 = sess.getAttributeNames();
		while ( e1.hasMoreElements() )
		{
		String key = (String)e1.nextElement();
		System.out.println("fecth home controller :"+ key + " = " + sess.getAttribute( key ) + " <br>" );
		}
		
		
		String type = (String) sess.getAttribute("type");
		System.out.println("printing in fetch home type:"+type);
		if(type != null && type.equals("student")){
			stud = (Student) sess.getAttribute("userobj");
			System.out.println("printing in fetch home :"+stud);
			notice = fdao.fetchNotices(stud,null);
			System.out.println("got list of stud notices from fetchNotices of fetchDAO");
		}else if(type != null && type.equals("faculty")){
			fac = (Faculty) sess.getAttribute("userobj");
			System.out.println("printing in fetch home :"+fac);
			notice = fdao.fetchNotices(null,fac);
			System.out.println("got list of fac notices from fetchNotices of fetchDAO");
		}
	
		
		req.setAttribute("notice", notice);
		
		mv = new ModelAndView();
		mv.setViewName("home.jsp");
		return mv;
	
	}
	
	@RequestMapping("/fetchQnA")
	public ModelAndView fetchQnA(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("in fetchqna controller");
		List<Questions> ques = fdao.fetchQnA();
		mv = new ModelAndView();
		mv.addObject("ques", ques);
		mv.setViewName("QnA.jsp");
		return mv;
	}
	
	@RequestMapping("/fetchRequests")
	public ModelAndView fetchRequests(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("in fetchRequests controller");
		ArrayList<List<Requests>> reqs = fdao.fetchRequests();
		mv = new ModelAndView();
		mv.addObject("reqs", reqs.get(0));
		mv.addObject("respreqs", reqs.get(1));
		mv.setViewName("requests.jsp");
		return mv;
	}
	
	@RequestMapping("/viewProfiles")
	public ModelAndView viewProfiles(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("inside viewProfiles");
		List<Student> studs = fdao.viewProfilesStudent();
		List<Faculty> facs = fdao.viewProfilesFaculty();
		mv = new ModelAndView();
		mv.addObject("studs", studs);
		mv.addObject("facs", facs);
		mv.setViewName("viewProf.jsp");
		return mv;
	}
	
}













