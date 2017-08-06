package edu.campus.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibSession {
	
	static Configuration cfg;
	static ServiceRegistry reg;
	static SessionFactory sf;
	static Session session;
	
	
	public static Session getSession() {  
	      
		if(session == null){
			cfg=new Configuration().configure();
			reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
			sf=cfg.buildSessionFactory(reg);
			session=sf.openSession();
		}      
		return session;       
	}  
}
