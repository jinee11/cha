package com.my.cha.member;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberForm {
	
	@NotBlank(message="이메일은 필수 항목 입니다")
	@Email(message = "이메일 형식으로 입력해주세요.")
	private String email;
	
	@NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
	private String pass1;
	
	@NotEmpty(message="비밀번호 확인은 필수 항목 입니다")
	private String pass2;
	

	@NotBlank(message = "이름은 필수 입력 값입니다.")
	private String name;
	
	@NotEmpty(message="폰번호는 필수 항목 입니다")
	private String phone;

}
