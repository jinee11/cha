package com.my.cha.member;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.cha.member.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	Member findByEmail(String email);

}
