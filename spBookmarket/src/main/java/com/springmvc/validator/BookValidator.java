package com.springmvc.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springmvc.domain.Book;

public class BookValidator implements Validator
{
	@Autowired
	private javax.validation.Validator beanValidator;
	
	private Set<Validator> springValidators;
	
	public BookValidator()
	{	//생성자
		springValidators = new HashSet<Validator>();
	}
	public void setSpringValidators(Set<Validator> springValidators)
	{
		this.springValidators = springValidators;
	}
	
	@Override
	public boolean supports(Class<?> clazz) 
	{
		
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{	//Bean Validation 설정
		Set<ConstraintViolation<Object>> violations = beanValidator.validate(target);
		for(ConstraintViolation<Object> violation : violations)
		{	//오류 발생 필드 저장
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			errors.rejectValue(propertyPath, "", message);
		}
		for(Validator validator : springValidators)
		{
			validator.validate(target, errors); //발생된 오류 정보를 전달
		}
	}

}
