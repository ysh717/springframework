package com.mycompany.webapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.webapp.dto.Ch04Member;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Ch04MemberJoinFormValidator implements Validator {

	//유효성 검사가 객체인지를 조사
	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		boolean result = Ch04Member.class.isAssignableFrom(clazz);
		return result;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}

}
