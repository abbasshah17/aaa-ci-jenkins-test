package com.example.jenkins_ci_test.login.domain.repository;

import com.example.jenkins_ci_test.base.domain.api.login.LoginApi;
import com.example.jenkins_ci_test.base.domain.models.login.LoginResponseModel;
import com.example.jenkins_ci_test.base.domain.repository.RetrofitTask;

import javax.inject.Inject;

import retrofit2.Call;

public class LoginTask extends RetrofitTask<LoginApi, LoginResponseModel> {

    private String username;
    private String password;


    @Inject
    public LoginTask()
    {
        super();
    }

    @Override
    protected Call<LoginResponseModel> getCall(LoginApi loginApi)
    {
        return loginApi.loginUser(LoginApi.LOGIN_URL, username, password);
    }

    public void performLogin(String username, String password)
    {
        this.username = username;
        this.password = password;

        requestApi(LoginApi.class);
    }

    @Override
    protected void onComplete(LoginResponseModel result)
    {
        username = null;
        password = null;
    }
}
