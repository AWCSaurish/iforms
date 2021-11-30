package com.newgen.iforms.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newgen.iforms.custom.IFormListenerFactory;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;

public class ETB implements IFormListenerFactory {
	public ETB() {
		System.out.println("ETB Constructor !!");
	}
	@Override
	public IFormServerEventHandler getClassInstance(IFormReference ifr) {
		if("Indexer".equalsIgnoreCase(ifr.getActivityName())) {
			ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
			return ctx.getBean(Indexer.class);
		}
		else {
			return null;
		}
	}

}
