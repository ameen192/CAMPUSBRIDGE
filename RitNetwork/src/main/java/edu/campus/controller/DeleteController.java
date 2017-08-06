package edu.campus.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.campus.dao.DeleteDAO;
import edu.campus.dto.NoticeBoard;

@Controller
public class DeleteController {

	ModelAndView mv;
	HttpSession sess;
	
	@Autowired
	ApplicationContext factory;
	
	@Autowired
	DeleteDAO dao;
	
	@RequestMapping("/delNotice")
	public void delNotice(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("inside delete notice");
		int id = Integer.parseInt(req.getParameter("id"));
		if(dao.delNotice(id)==0){
			try {
				resp.getWriter().write("true");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
