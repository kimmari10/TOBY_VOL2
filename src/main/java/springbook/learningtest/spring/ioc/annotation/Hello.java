package springbook.learningtest.spring.ioc.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import springbook.learningtest.spring.ioc.bean.Printer;

@Component
public class Hello {
	private String name;
	
	//참조할 빈 이름 지정, 생략가능, 필드주입
	@Resource(name="printer")
	private Printer printer;
	
	public String sayHello() {
		return "Hello " + name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}

	public void setName(String name) {
		this.name = name;
	}

}
