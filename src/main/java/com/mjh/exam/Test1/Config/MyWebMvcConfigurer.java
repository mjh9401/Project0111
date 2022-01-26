package com.mjh.exam.Test1.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mjh.exam.Test1.Interceptor.BeforeActionInterceptor;
import com.mjh.exam.Test1.Interceptor.NeedLoginInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	@Autowired
	BeforeActionInterceptor beforeActionInterceptor;
	@Autowired
	NeedLoginInterceptor needLoginInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		InterceptorRegistration ir;
		ir = registry.addInterceptor(beforeActionInterceptor);
		ir.addPathPatterns("/**");
		ir.excludePathPatterns("/favicon.ico");
		ir.excludePathPatterns("/resource/**");
		ir.excludePathPatterns("/error");
		
	}
}
