package com.my.cha.member;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/join")
	public String signup(MemberForm memberForm) {
		
		return "join_box";
	}
	
	@PostMapping("/join")
	public String signup(@Valid MemberForm memberForm,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "join_box";
		}
		if(!memberForm.getPass1().equals(memberForm.getPass2())) {
			bindingResult.rejectValue("pass1", "pass2",
					"패스워드 확인이 일치하지 않습니다.");
			return "join_box";
		}
		
		memberService.create(memberForm.getEmail(), memberForm.getName(), 
				memberForm.getPhone(), memberForm.getPass1());
		
		return "redirect:/";
	}

}
