package com.my.cha.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, length =50)
	private String email;
	
	@Column(length =30)
	private String pass;
	
	@Column(length =200)
	private String name;
	
	@Column(length =30)
	private String phone;

}
