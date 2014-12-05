package springbook.learningtest.spring.ioc.bean;

import org.springframework.beans.factory.annotation.Value;


public class Hellow {
	public Hellow() {
		
	}
	@Value("#{systemProperties['os.name']}") String name;

}
