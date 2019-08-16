package com.spring.Test;

import org.apache.naming.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	// 通常App的设计都分为三层：Dao层、Service层和应用层
	// Dao=Data Access Object是和数据库交互或者实现功能的
	// Service是向用户提供“服务”这个API去供其使用的
	// 应用层，简单理解为main函数去调用
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IService hello = (IService) context.getBean("service");

		// 这里没有实例化任何Dao、Service对象，而是从Spring容器中直接取出的
		// 即：Spring实例化并维护这些对象。
		// 因此Spring是一个轻量级的容器，能生产、管理、维护各种实例
		hello.service("Pan");

		// 要向上转型才能有close方法
		((ConfigurableApplicationContext)context).close();
		
		/*
		 * Service、Dao是作为独立组件出现的，在编码阶段，既没有实例化对象，也没有设置依赖关系。
		 * 而是把他们交给Spring，由Spring在运行阶段实例化、组装对象，这种做法颠覆了传统的写代码实例化，
		 * 组装对象，然后一步步执行的做法，被称为控制反转IoC。
		 */
		
	}

}
