package edu.campus.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import edu.campus.dao.DeleteDAO;
import edu.campus.dao.FetchDAO;
import edu.campus.dao.InsertionDAO;
import edu.campus.dao.RegistrationDAO;
import edu.campus.dto.Faculty;
import edu.campus.dto.RegistrationDTO;
import edu.campus.dto.Student;

@Configuration
@ComponentScan({ "edu.campus.controller" })
@EnableWebMvc
public class ControllerConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
//	@Bean
//	public Ques getQuestions(){
//		return new Questions();
//	}
//	
//	@Bean
//	public Request getRequest(){
//		return new Request();
//	}
//	
//	@Bean
//	public NoticeBoard getNoticeboard(){
//		return new NoticeBoard();
//	}
//	
	@Bean
	public DeleteDAO getddao(){
		return new DeleteDAO();
	}
	
	
	@Bean
	public InsertionDAO getinsdao(){
		return new InsertionDAO();
	}
	
	@Bean
	public RegistrationDTO getuser(){
		return new RegistrationDTO();
	}
	
	@Bean
	public RegistrationDAO getregdao(){
		return new RegistrationDAO();
	}
	
	@Bean
	public Student getStud(){
		return new Student();
	}
	
	@Bean
	public Faculty getfac(){
		return new Faculty();
	}
	
	@Bean
	public FetchDAO getfdao(){
		return new FetchDAO();
	}
	
}
