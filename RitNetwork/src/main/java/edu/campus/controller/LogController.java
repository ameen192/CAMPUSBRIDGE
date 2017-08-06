package edu.campus.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.campus.dao.FetchDAO;
import edu.campus.dao.RegistrationDAO;
import edu.campus.dto.Faculty;
import edu.campus.dto.NoticeBoard;
import edu.campus.dto.RegistrationDTO;
import edu.campus.dto.Student;

@Controller
public class LogController {

	RequestDispatcher rd;
	PrintWriter out;
	HttpSession sess;
	ModelAndView mv;
	static int count = 0;
	
	@Autowired
	ApplicationContext factory;
	
	@Autowired
	RegistrationDAO rdao;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("in login servlet");
		String type = req.getParameter("type");
		System.out.println("email value in login : "+req.getParameter("email"));
		System.out.println("type value in login servlet : "+type);
		RegistrationDTO userobj = new RegistrationDTO();
		if(type != null && type.equals("student")){
			userobj = (Student) rdao.validateStud(req.getParameter("email"), req.getParameter("password"));
		}else if(type != null && type.equals("faculty")){
			userobj = (Faculty) rdao.validateFac(req.getParameter("email"), req.getParameter("password"));
		}
		System.out.println("count value :"+count);
		if(userobj == null){
			mv = new ModelAndView();
			mv.setViewName("login.jsp");
			mv.addObject("invalid","invalid username or password");
		}else{
			if(count == 0){
				System.out.println("creating new session in login controller");
				sess = req.getSession(true);
				sess.setMaxInactiveInterval(600*60);
				sess.setAttribute("type", type);
				sess.setAttribute("userobj", userobj);
				count++;
			}else{
				System.out.println("creating new session in login controller");
				sess = req.getSession(false);
			}
			
			
			@SuppressWarnings("rawtypes")
			Enumeration e1 = sess.getAttributeNames();
			while ( e1.hasMoreElements() )
			{
			String key = (String)e1.nextElement();
			System.out.println("login controller :"+ key + " = " + sess.getAttribute( key ) + " <br>" );
			}

			rd = req.getRequestDispatcher("fetchHome");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mv;
	}


	@RequestMapping("/test")
	public void test(HttpServletRequest req, HttpServletResponse resp){
		Session session = (Session) factory.getBean("getSession");
		System.out.println(factory);
		System.out.println(session);
		if(session != null){
			System.out.println("got session!!!");
		}
	}
	
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse resp){
		count = 0;
		sess.setAttribute("type", null);
		sess.setAttribute("userobj", null);
		mv = new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;
	}
	
	

	@RequestMapping("/RegServ")
	public void register(HttpServletRequest req, HttpServletResponse resp){

		if(req.getParameter("type").equals("student")){
			Student rdto = factory.getBean(Student.class);
			rdto.setName(req.getParameter("name"));
			rdto.setPassword(req.getParameter("password"));
			rdto.setGender(req.getParameter("gender"));
			rdto.setEmail(req.getParameter("email"));
			rdto.setType(req.getParameter("type"));
			rdto.setDepartment(req.getParameter("sdepartment"));
			rdto.setCourse(req.getParameter("course"));
			rdto.setSemester(Integer.parseInt(req.getParameter("semester")));
			rdto.setUsn(req.getParameter("usn"));
			if(rdao.registerStud(rdto)==0){
				try {
					req.setAttribute("name", req.getParameter("name"));
					rd = req.getRequestDispatcher("studRegSucc.jsp");
					rd.forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				try {
					resp.getWriter().println("<h2>problem occured while regitration <br> please try again</h2>");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}else{
			Faculty fdto = factory.getBean(Faculty.class);
			fdto.setName(req.getParameter("name"));
			fdto.setPassword(req.getParameter("password"));
			fdto.setGender(req.getParameter("gender"));
			fdto.setEmail(req.getParameter("email"));
			fdto.setType(req.getParameter("type"));
			fdto.setDepartment(req.getParameter("fdepartment"));
			fdto.setFaculty_coll_id(req.getParameter("faculty_coll_id"));
			if(rdao.registerFac(fdto)==0){
				try {
					req.setAttribute("name", req.getParameter("name"));
					rd = req.getRequestDispatcher("facRegSucc.jsp");
					rd.forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}else{
				try {
					resp.getWriter().println("<h2>problem occured while regitration <br> please try again</h2>");
				} catch (IOException e) {
				}
			}
		}

	}
}
