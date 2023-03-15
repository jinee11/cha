package com.my.cha.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.cha.member.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	Optional<Member> findByEmail(String email);
	
	//로그인 구현
	//Optional<Member> findByUsername(String username);

}
