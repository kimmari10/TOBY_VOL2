package springbook.learningtest.spring.enable;

import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.learningtest.spring.ioc.BeanDefinitionUtils;

public class BeanRoleTest {
	
	@Test
	public void configTest() {
		GenericApplicationContext ctx = new GenericXmlApplicationContext(
				BeanRoleTest.class, "beanrole.xml");
		
		BeanDefinitionUtils.printBeanDefinitions(ctx);
		//이를 활용해 루트 컨텍스트에 등록된 빈을 살펴볼 수 있다.
		
		SimpleConfig sc = ctx.getBean(SimpleConfig.class);
		sc.hello.sayHello();
		
	}
	
}

