package com.my.cha.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.my.cha.constant.Role;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Transactional
@Log4j2
@Service
public class MemberService implements UserDetailsService{


    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    //회원가입
    public Member registerNewMember(MemberForm memberForm) {
        Member member = new Member();
        member.setEmail(memberForm.getEmail());
        member.setName(memberForm.getName());
        member.setPhone(memberForm.getPhone());
        member.setPass(passwordEncoder.encode(memberForm.getPass1()));

        memberRepository.save(member);
        
        return member;
    }

    //로그인
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//		 Member member = memberRepository.findByEmail(email);
//		 
//		 log.info(email);
//		 log.info(member.getEmail());
//		 
//		 if(member == null){
//	            throw new UsernameNotFoundException(email);  //예외(오류)를 강제로 발생 시킴 ""
//	        }
//		 
//		// User 객체에는 2가지 값이 반드시 적용 : 1. ID , 2. Pass
//	        return User.builder()
//	                .username(member.getEmail())
//	                .password(member.getPass())
//	                .build();
		
 
			
			Optional<Member> _Member = this.memberRepository.findByEmail(email);
			
			if(_Member.isEmpty()) {
				
				throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
			}
			
			//폼에서 넘어오는 username을 DB에서 쿼리해서 siteUser 객체에 담은 값을 Optional에서 뽑아옴
			//sieteUser : DB 에서 select 한 레코드
			Member member = _Member.get();
			
			//Authentication (인증) : Identity (ID) + Password를 확인하는것
			//Authorization (허가) : 인증도니 사용자에게 사이트의 서비스를 쓸 수 있도록 권한을 부여하는 것
				// 계정이 admin이라면 ADMIN Role을 적용
				// 계정이 admin이 아니라면 USER Role을 적용
			List<GrantedAuthority> authorities=new ArrayList<>();
			
			if("admin".equals(email)) {
				
				authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
			
			}
			
			return new User(member.getEmail(), member.getPass(), authorities);
			
		}
		
	
	
    
    
}