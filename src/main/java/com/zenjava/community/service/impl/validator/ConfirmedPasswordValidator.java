package com.zenjava.community.service.impl.validator;

import com.zenjava.community.service.data.ConfirmedPasswordRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmedPasswordValidator implements ConstraintValidator<ConfirmedPassword, ConfirmedPasswordRequest> {

    @Override
    public void initialize(ConfirmedPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(ConfirmedPasswordRequest request, ConstraintValidatorContext context) {
        boolean passwordsMatch = request.getPassword().equals(request.getConfirmPassword());

        if (!passwordsMatch) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("passwords do not match")
                    .addNode("confirmPassword")
                    .addConstraintViolation();
        }

        return passwordsMatch;
    }
}
