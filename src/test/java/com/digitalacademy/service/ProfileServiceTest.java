package com.digitalacademy.service;

import com.digitalacademy.constants.ProfileError;
import com.digitalacademy.exception.ProfileException;
import com.digitalacademy.model.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProfileServiceTest {

    @InjectMocks
    ProfileService profileService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        profileService = new ProfileService();
    }

    @DisplayName("Test get profile info by id equals 7 should return profile information")
    @Test
    public void testProfileInfoByIdEquals7() throws Exception{
        Profile resp = profileService.getProfile(7L);
        assertEquals("7", resp.getId().toString());
        assertEquals("Tanakrid", resp.getFirstName());
        assertEquals("Chanburi", resp.getLastName());
        assertEquals(21, resp.getAge());
        assertEquals("0837704301", resp.getTelephone());
        assertEquals("Kasetsart University",resp.getGraduatedForm());
        assertEquals(2.98,resp.getGrade());
        assertEquals("Computer Science",resp.getMajor());
        assertEquals("Software Engineer",resp.getJob());
    }

    @DisplayName("Test get profile info by id equals 1 should return profile information")
    @Test
    public void testProfileInfoByIdEquals1() throws Exception{
        Profile resp = profileService.getProfile(1L);
        assertEquals("1", resp.getId().toString());
        assertNull(resp.getFirstName());
        assertNull(resp.getLastName());
        assertEquals(0, resp.getAge());
        assertNull(resp.getTelephone());
        assertNull(resp.getGraduatedForm());
        assertEquals(0, resp.getGrade());
        assertNull(resp.getMajor());
        assertNull(resp.getJob());
    }

    @DisplayName("Test get profile by excepted id 7 and 1 should throw Loan Exception loan info not found")
    @Test
    void testGetLoanInfoByIdEqualsOther() throws Exception{
        Long reqParam = 10L;
        ProfileException thrown = assertThrows(ProfileException.class
                , () -> profileService.getProfile(reqParam));
        assertEquals(400, thrown.getHttpStatus().value());
        assertEquals("PROFILE4002", thrown.getProfileError().getCode());
        assertEquals("profile information not found", thrown.getProfileError().getMessage());
    }
}
