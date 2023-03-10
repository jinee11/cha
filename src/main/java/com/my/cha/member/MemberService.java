package com.my.cha.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewMember(MemberForm memberForm) {
        Member member = new Member();
        member.setEmail(memberForm.getEmail());
        member.setName(memberForm.getName());
        member.setPhone(memberForm.getPhone());
        member.setPass(passwordEncoder.encode(memberForm.getPass1()));

        memberRepository.save(member);
    }
}