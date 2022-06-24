package com.platinouss.springEx.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GlobalUserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto)target;
        String id = userDto.getId();
        String pwd = userDto.getPwd();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");

        if(id.length() > 0 && (id.length() < 4 || id.length() > 12)) {
            errors.rejectValue("id", "invalidLength", new String[]{"3", "12"}, null);
        }

        if(pwd.length() > 0 && (pwd.length() < 8 || pwd.length() > 12)) {
            errors.rejectValue("pwd", "invalidLength", new String[]{"8", "12"}, null);
        }
    }
}
