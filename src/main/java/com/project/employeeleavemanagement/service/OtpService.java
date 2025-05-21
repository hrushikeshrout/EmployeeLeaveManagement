package com.project.employeeleavemanagement.service;


import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class OtpService {


    private final SecureRandom random = new SecureRandom();

    public String generateOtp(){
        StringBuilder otp = new StringBuilder(6);
        for (int i = 0; i<6; i++){
            String DIGIT = "0123456789";
            int index = random.nextInt(DIGIT.length());
            otp.append(DIGIT.charAt(index));
        }
        return otp.toString();
    }
}
