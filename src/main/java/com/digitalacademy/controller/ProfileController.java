package com.digitalacademy.controller;

import com.digitalacademy.constants.ProfileError;
import com.digitalacademy.constants.Response;
import com.digitalacademy.exception.ProfileException;
import com.digitalacademy.model.Profile;
import com.digitalacademy.model.ResponseModel;
import com.digitalacademy.model.StatusModel;
import com.digitalacademy.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/profile")
public class ProfileController {
    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){ this.profileService = profileService; }

    @GetMapping("/{id}")
    public HttpEntity<?> getProfileByCustomerId(@PathVariable Long id) throws Exception{
        try {
            Profile result = profileService.getProfile(id);
            StatusModel status = new StatusModel(Response.SUCCESS_CODE.getContent(), Response.SUCCESS.getContent());
            return ResponseEntity.ok(new ResponseModel(status, result));
        }catch(ProfileException e) {
            ProfileError profileError = e.getProfileError();
            return ResponseEntity.ok(
                    new ResponseModel(
                            new StatusModel(profileError.getCode(), profileError.getMessage())
                    )
            );
        }
    }
}
