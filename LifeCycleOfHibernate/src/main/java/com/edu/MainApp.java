package com.edu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp {
	public static void main(String[] args) {
		MyLaptop lob=new MyLaptop();
		lob.setLid(12);
		lob.setLname("charles");
		lob.setLprice(40000);
		
		Configuration conn=new Configuration().configure().addAnnotatedClass(MyLaptop.class);
		
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conn.getProperties()).buildServiceRegistry();
		
		SessionFactory sf=conn.buildSessionFactory(reg);
		Session ses=sf.openSession();
		
		
		Transaction tx=ses.beginTransaction();
		
		  ses.save(reg);
	        tx.commit();
		
}
}