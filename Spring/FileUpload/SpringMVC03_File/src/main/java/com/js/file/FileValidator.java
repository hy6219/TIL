package com.js.file;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UploadFile file=(UploadFile)target;
		
		if(file.getFile().getSize()==0) {
			errors.rejectValue("file","invalid file" ,"파일을 다시 확인해주십시오!");
		}
	}

}
