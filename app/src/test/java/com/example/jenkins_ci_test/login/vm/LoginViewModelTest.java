package com.example.jenkins_ci_test.login.vm;

import androidx.lifecycle.MutableLiveData;

import com.example.jenkins_ci_test.base.domain.models.login.LoginResponseModel;
import com.example.jenkins_ci_test.base.domain.repository.Repository;
import com.example.jenkins_ci_test.login.di.names.LivePasswordKey;
import com.example.jenkins_ci_test.login.di.names.LiveUsernameKey;
import com.example.jenkins_ci_test.login.domain.repository.LoginTask;
import com.example.jenkins_ci_test.login.domain.usecases.LoginUseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {

    @InjectMocks
    LoginViewModel mockedLoginViewModel;

    @InjectMocks
    LoginUseCase mockedLoginUseCase;

    @LiveUsernameKey
    @InjectMocks
    MutableLiveData<String> mockedUsername;

    @LivePasswordKey
    @InjectMocks
    MutableLiveData<String> mockedPassword;

    @LivePasswordKey
    @InjectMocks
    MutableLiveData<LoginResponseModel> mockedLoginResponse;

    @Before
    public void initialize()
    {
        LoginTask loginTask = Mockito.mock(LoginTask.class);
        mockedLoginUseCase = new LoginUseCase(loginTask);

        mockedLoginViewModel = new LoginViewModel(mockedLoginUseCase, mockedUsername, mockedPassword, mockedLoginResponse);
    }

    @Test
    public void checkSettersAndGetters()
    {
        //  Setters
        mockedLoginViewModel.setUsername(mockedUsername.getValue());
        mockedLoginViewModel.setPassword(mockedPassword.getValue());
        mockedLoginViewModel.setLoginResponse(mockedLoginResponse.getValue());

        //  Getters
        MutableLiveData<String> username = mockedLoginViewModel.getUsername();
        MutableLiveData<String> password = mockedLoginViewModel.getPassword();
        MutableLiveData<LoginResponseModel> loginResponse = mockedLoginViewModel.getLoginResponse();

        assertNotNull(username);
        assertNotNull(password);
        assertNotNull(loginResponse);
    }

    @Test
    public void checkIfLoginWorks()
    {
        mockedLoginViewModel.onLoginClick();
    }
}