package com.mjh.exam.Test1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping()
	public String ShowIndex() {
		return "usr/home/index";
	}
	
	@RequestMapping("/main")
	public String ShowMain() {
		return "usr/home/main";
	}
	
}
