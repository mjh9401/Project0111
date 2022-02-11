package com.mjh.exam.Test1.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mjh.exam.Test1.Interceptor.BeforeActionInterceptor;
import com.mjh.exam.Test1.Interceptor.NeedLogOutInterceptor;
import com.mjh.exam.Test1.Interceptor.NeedLoginInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	@Autowired
	BeforeActionInterceptor beforeActionInterceptor;
	@Autowired
	NeedLoginInterceptor needLoginInterceptor;
	@Autowired
	NeedLogOutInterceptor needLogOutInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		InterceptorRegistration ir;
		ir = registry.addInterceptor(beforeActionInterceptor);
		ir.addPathPatterns("/**");
		ir.excludePathPatterns("/favicon.ico");
		ir.excludePathPatterns("/resource/**");
		ir.excludePathPatterns("/error");
		
		
		ir = registry.addInterceptor(needLoginInterceptor);
		ir.addPathPatterns("/article/write");
		ir.addPathPatterns("/article/dowrite");
		ir.addPathPatterns("/article/detail");
		ir.addPathPatterns("/article/doIncreaseHitCount");
		ir.addPathPatterns("/article/delete");
		ir.addPathPatterns("/article/modify");
		ir.addPathPatterns("/article/doModify");
		ir.addPathPatterns("/member/Mypage");
		ir.addPathPatterns("/member/logout");
		ir.addPathPatterns("/article/memberDrop");
		ir.addPathPatterns("/article/doMemberDrop");
		ir.addPathPatterns("/article/memberModify");
		ir.addPathPatterns("/article/domemberModify");
		
		
		ir=registry.addInterceptor(needLogOutInterceptor);
		ir.addPathPatterns("/member/join");
		ir.addPathPatterns("/member/dojoin");
		ir.addPathPatterns("/member/findId");
		ir.addPathPatterns("/member/doFindId");
		ir.addPathPatterns("/member/findPw");
		ir.addPathPatterns("/member/dofidnPw");
		ir.addPathPatterns("/member/login");
		ir.addPathPatterns("/member/doLogin");
	}
}
