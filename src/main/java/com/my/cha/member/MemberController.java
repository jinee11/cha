package com.my.cha.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {

    
    private MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/member/join")
    public String memberJoinForm(MemberForm memberForm) {
     
        return "join_box";
    }

    @PostMapping("/member/join")
    public String memberJoinForm(@Valid MemberForm memberForm,
    		BindingResult bindingResult) {
    	
    	if (bindingResult.hasErrors()) {
    		 return "join_box";
    	}
     
    	if (!memberForm.getPass1().equals(memberForm.getPass2())) {
    		bindingResult.rejectValue("pass1", "pass2", "2개의 패스워드가 일치하지 않습니다.");
    		
    		return "join_box";
    	}
    	
    	return "redirect:/";
    }
    
    @GetMapping("/login")
	public String login() {
		
		return "login";
	}
    
    @PostMapping("/login")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", "메일 또는 비밀번호를 확인해주세요");
		return "login";
	}
    
    
}