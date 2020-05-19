package com.digitalacademy.constants;

import lombok.Getter;

@Getter
public enum ProfileError {
    GET_PROFILE_INFO_EXCEPTION("PROFILE4001", "Cannot get profile information"),
    GET_PROFILE_INFO_NOT_FOUND("PROFILE4002", "profile information not found");

    private String code;
    private String message;

    ProfileError(String code, String message){
        this.code = code;
        this.message = message;
    }
}
