package springbook.learningtest.spring.ioc.annotation;

import springbook.learningtest.spring.ioc.bean.Printer;

public class StringPrinter implements Printer{
	private StringBuffer buffer = new StringBuffer();
	
	public void print(String message) {
		this.buffer.append(message);
	}
	
	public String toString() {
		return this.buffer.toString();
	}

}
