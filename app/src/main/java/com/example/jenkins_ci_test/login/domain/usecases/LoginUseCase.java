package com.example.jenkins_ci_test.login.domain.usecases;

import com.example.jenkins_ci_test.base.domain.models.login.LoginResponseModel;
import com.example.jenkins_ci_test.base.domain.usecase.UseCase;
import com.example.jenkins_ci_test.login.domain.repository.LoginTask;

import javax.inject.Inject;

public class LoginUseCase extends UseCase<LoginResponseModel> {

    private LoginTask loginTask;


    @Inject
    public LoginUseCase(LoginTask loginTaskProvider)
    {
        this.loginTask = loginTaskProvider;
    }

    public void performLogin(String username, String password)
    {
        addTask(loginTask);

        loginTask.setCallback(this::notifyComplete);

        loginTask.performLogin(username, password);
    }

    @Override
    public void clear()
    {
        super.clear();

        loginTask = null;
    }
}
