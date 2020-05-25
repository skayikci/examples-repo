package com.example.constraints.validators;

import com.example.constraints.services.UserService;
import com.example.constraints.validators.annotations.UsernameUnique;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsernameUniqueValidator implements ConstraintValidator<UsernameUnique, String> {

    private final UserService userService;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        return !userService.existsUserByUserName(userName); // guess what happens if the user exists :)
    }
}
