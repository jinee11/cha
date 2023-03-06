package com.my.cha.member;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberRepository MemberRepository;
	
	public Member create(String email, String pass, String name, String phone) {
		
		Member member = new Member();
		member.setEmail(email);
		member.setName(name);
		member.setPhone(phone);
		member.setPass(pass);
		
		this.MemberRepository.save(member);
		
		return member;
		
	}

}
