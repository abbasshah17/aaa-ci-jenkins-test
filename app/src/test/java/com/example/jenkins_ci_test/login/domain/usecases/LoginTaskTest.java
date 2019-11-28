package com.example.jenkins_ci_test.login.domain.usecases;

import com.example.jenkins_ci_test.login.domain.repository.LoginTask;

import org.junit.Test;
import org.mockito.InjectMocks;

public class LoginTaskTest {

    private static String[] loginCredentials = {
            "abbasshah17@gmail.com", "12345678",
            "abbasshah17", "12345678",
            "gmail.com", "123",
            "abbas", "123",
            "", "",
            null, null,
            "", null,
            null, ""
    };

    @InjectMocks
    private LoginTask loginTask;

    @Test
    public void isLoginResponseValid()
    {
        for (int i = 0; i < loginCredentials.length; i++) {
            String testUsername = loginCredentials[i];
            String testPassword = loginCredentials[++i];

            loginTask.performLogin(testUsername, testPassword);
        }
    }
}