package springbook.learningtest.spring.ioc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

public class ValueInjectionTest {

	@Test
	public void valueInjection() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanSP.class, ConfigSP.class, DatabasePropertyPlaceHolder.class);
		BeanSP bean = ac.getBean(BeanSP.class); 
		ConfigSP bean2 = ac.getBean(ConfigSP.class);
		
		
		assertThat(bean2, is(notNullValue()));
		assertThat(bean.username, is("Spring"));
		assertThat(bean.hellow.name, is("Windows 7"));
		assertThat(bean.hello.name, is("Spring"));
	}
	static class BeanSP {
		@Value("${database.username}") String username;
		@Autowired Hello hello;
		@Autowired Hello hellow;
	}
	
	static class ConfigSP {
		@Bean public Hello hellow(@Value("#{systemProperties['os.name']}") String osname) {
			Hello hellow = new Hello();
			hellow.name = osname;
			return hellow;
		}
		
		@Bean public Hello hello(@Value("${database.username}") String username) {
			Hello hello = new Hello();
			hello.name = username;
			return hello;
		}
	}
	static class Hello { String name; }
	static class DatabasePropertyPlaceHolder extends PropertyPlaceholderConfigurer {
		public DatabasePropertyPlaceHolder() {
			this.setLocation(new ClassPathResource("database.properties", getClass()));
		}
	}
}
