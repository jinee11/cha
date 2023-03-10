package com.my.cha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
	
	@GetMapping("/")
	//@ResponseBody
	public String index() {
		
		return "index";
	}

	
//	@RequestMapping(value = "/")
//    public String index() {
//     
//     return "index";
//	}
	
	@GetMapping("/cha/list")
	public String sub1() {
		
		return "sub1_main";
	}
	
	@GetMapping("/cha/item")
	public String sub2() {
		
		return "sub2_main";
	}
	
	@GetMapping("/aside")
	public String aside() {
		
		return "aside";
	}
	
	@GetMapping("/chatting")
	public String chatting() {
		
		return "chatting";
	}
	
	@GetMapping("/join")
	public String join() {
		
		return "join";
	}
	
	
}
