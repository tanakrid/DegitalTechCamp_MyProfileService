package com.digitalacademy.service;

import com.digitalacademy.constants.ProfileError;
import com.digitalacademy.exception.ProfileException;
import com.digitalacademy.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    public Profile getProfile(Long id) throws Exception {
        Profile profile = new Profile();
        profile.setId(7L);
        profile.setFirstName("Tanakrid");
        profile.setLastName("Chanburi");
        profile.setAge(21);
        profile.setTelephone("0837704301");
        profile.setGraduatedForm("Kasetsart University");
        profile.setGrade(2.98);
        profile.setMajor("Computer Science");
        profile.setJob("Software Engineer");

        if (id.equals(7L)){
            return profile;
        }else if (id.equals(1L)){
            profile = new Profile();
            profile.setId(1L);
            return profile;
        }else{
            throw new ProfileException(ProfileError.GET_PROFILE_INFO_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }
//        return profile;
    }
}
