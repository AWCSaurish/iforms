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
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		if("Indexer".equalsIgnoreCase(ifr.getActivityName())) {
			System.out.println("If Clause");
			return ctx.getBean(Indexer.class);
		}
		else {
			System.out.println("Else Clause !");
			return ctx.getBean(Posting.class);
		}
	}

}
