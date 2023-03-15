package com.my.cha.constant;

import lombok.Getter;

@Getter
public enum Role {
	ADMIN("ROLE_ADMIN"),
	
	USER("RLOE_USER");
	
	
	Role(String value) {
		
		this.value = value;
	}
	
	private String value;
}
