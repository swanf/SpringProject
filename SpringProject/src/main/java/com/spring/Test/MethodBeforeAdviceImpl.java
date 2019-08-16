package com.spring.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

// 跟Filter一样，可以把AOP类比成一个个关卡
// 需要实现特定接口
// Spring把这些实现特定AOP接口的类称为拦截器Interceptor,包括before、after、exception等拦截器
public class MethodBeforeAdviceImpl implements MethodBeforeAdvice { 

	// 方法前执行的拦截器
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Test Before Running...");
		System.out.println("Method: "+method.getName());
		System.out.println("Args: "+Arrays.asList(args));
		System.out.println("Object: "+target);
	}

}
