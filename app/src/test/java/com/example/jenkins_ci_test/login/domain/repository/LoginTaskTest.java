package com.example.jenkins_ci_test.login.domain.repository;

import com.example.jenkins_ci_test.base.domain.repository.Repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginTaskTest {

    private String [] credentials = {
            "abbasshah17@gmail.com", "12345678",
            "abbasshah17@gmail.com", "123",
            "abbasshah17@gmail.com", "12345678901234567890",
            "abbasshah17@gmail.com", "",
            "abbasshah17@gmail.com", null,
            "123@gmail.com", "12345678",
            "123@gmail.com", "",
            "123@gmail.com", null,
            "ABC@gmail.com", "123456678",
            "ABC@gmail.com", null,
            "ABC@gmail", "12345678",
            "ABC@gmail", "1234",
            "ABC@gmail", "12345678901234567890",
            "ABC@gmail", null,
            "ABC", "12345678",
            "ABC", "123",
            "ABC", "12345678901234567890",
            "ABC", null,
            null, null
    };

//    @InjectMocks
    private LoginTask mockedLoginTask;


    @Before
    public void initialize()
    {
        mockedLoginTask = new LoginTask();
    }

    @Test
    public void checkLogin()
    {
        for (int i = 0; i < credentials.length; i++) {
            mockedLoginTask.setCallback((result) -> {

            });
            mockedLoginTask.performLogin(credentials[i], credentials[++i]);
        }
    }

    @After
    public void cleanUp()
    {
        mockedLoginTask.stop();
        mockedLoginTask = null;
    }
}