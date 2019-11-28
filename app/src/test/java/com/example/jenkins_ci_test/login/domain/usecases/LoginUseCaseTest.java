package com.example.jenkins_ci_test.login.domain.usecases;

import com.example.jenkins_ci_test.login.domain.repository.LoginTask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Field;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class LoginUseCaseTest {

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

    private LoginUseCase mockedLoginUseCase;

    @Before
    public void initialize()
    {
        LoginTask loginTask = Mockito.mock(LoginTask.class);

        mockedLoginUseCase = new LoginUseCase(loginTask);

        try {
            Field[] fields = mockedLoginUseCase.getClass().getSuperclass().getDeclaredFields();

            for (Field field : fields)
            {
                System.out.print("Name : " + field.getName() + ", ");
            }

            System.out.println();

            FieldSetter fieldSetter = new FieldSetter(mockedLoginUseCase,
                    mockedLoginUseCase.getClass().getSuperclass().getDeclaredField("tasks"));

            fieldSetter.set(new ArrayList<>());
        }
        catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void doesLoginWork()
    {
        for (int i = 0; i < credentials.length; i++) {
            mockedLoginUseCase.performLogin(credentials[i], credentials[++i]);
        }
    }

    @After
    public void cleanUp()
    {
        mockedLoginUseCase.clear();
        mockedLoginUseCase = null;
    }
}