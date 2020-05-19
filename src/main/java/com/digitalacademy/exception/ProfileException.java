package com.digitalacademy.exception;

import com.digitalacademy.constants.ProfileError;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ProfileException extends Exception{
    private ProfileError profileError;
    private HttpStatus httpStatus = HttpStatus.OK;

    public ProfileException(ProfileError loanError, HttpStatus httpStatus) {
        this.profileError = loanError;
        this.httpStatus = httpStatus;
    }
}
