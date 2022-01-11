package com.mjh.exam.Test1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/usr/home/main")
	public String Showmain() {
		return "usr/home/main";
	}
}
