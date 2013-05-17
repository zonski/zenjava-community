package com.zenjava.community.service.data;

import com.zenjava.community.service.impl.validator.ConfirmedPassword;

import javax.validation.constraints.Pattern;

@ConfirmedPassword
public interface ConfirmedPasswordRequest {

    /**
     * Minimum 6 and Maximum 20 Character.
     * At least 1 number
     * At least 1 alphabet in capitals.
     * No Special char allowed
     */
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{6,20}$",
            message = "must have between 6 and 20 characters, 1 number, 1 capital and no special characters")
    String getPassword();

    String getConfirmPassword();
}
