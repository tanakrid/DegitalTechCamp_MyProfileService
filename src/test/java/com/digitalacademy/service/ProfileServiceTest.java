package com.digitalacademy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

//    @DisplayName("Test get loan by in equals 2 should throw Loan Exception loan info not found")
//    @Test
//    void testGetLoanInfoByIdEquals2() throws Exception{
//        Long reqParam = 2L;
//        LoanException thrown = assertThrows(LoanException.class,
//                () -> loanService.getLoanInfoById(reqParam),
//                "Expected LoanInfoById(reqParam) to throw, but it didn't");
//
//        assertEquals(400, thrown.getHttpStatus().value());
//        assertEquals("LOAN4002", thrown.getLoanError().getCode());
//        assertEquals("Loan information not found", thrown.getLoanError().getMessage());
//    }
}
