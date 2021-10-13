package com.webapp6.util;

import com.webapp6.models.User;
import com.webapp6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired(required = false)
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userService.getOne(user.getEmail()) != null) {
            errors.rejectValue(
                    "email", "", "This email is already in use"
            );
        }
    }

}