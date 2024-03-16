package com.ayoub.real_estate.business.factory;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public abstract class ContextFactory {
	
	private static DataSource dataSource;
	
	private static final ApplicationContext app= new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");
	

	
	public  DataSource DataSource() {
		return dataSource;
	}

	public static ApplicationContext Context() {
		return app;
	}

	public static void setDataSource(DataSource dataSource) {
		ContextFactory.dataSource = dataSource;
	}
	
	
	
	
	
	
}
