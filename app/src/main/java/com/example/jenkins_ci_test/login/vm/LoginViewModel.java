package com.example.jenkins_ci_test.login.vm;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.jenkins_ci_test.base.domain.models.login.LoginResponseModel;
import com.example.jenkins_ci_test.base.vm.BaseViewModel;
import com.example.jenkins_ci_test.login.di.names.LivePasswordKey;
import com.example.jenkins_ci_test.login.di.names.LiveResponseModelKey;
import com.example.jenkins_ci_test.login.di.names.LiveUsernameKey;
import com.example.jenkins_ci_test.login.di.scopes.LoginScope;
import com.example.jenkins_ci_test.login.domain.usecases.LoginUseCase;

import javax.inject.Inject;

@LoginScope
public class LoginViewModel extends BaseViewModel {

    private static final String TAG = "LoginViewModel";

    private MutableLiveData<String> username;
    private MutableLiveData<String> password;

    private MutableLiveData<LoginResponseModel> loginResponse;

    private LoginUseCase loginUseCase;


    @Inject
    LoginViewModel(LoginUseCase loginUseCase,
                          @LiveUsernameKey MutableLiveData<String> username,
                          @LivePasswordKey MutableLiveData<String> password,
                          @LiveResponseModelKey MutableLiveData<LoginResponseModel> loginResponseModel)
    {
        this.loginUseCase = loginUseCase;

        this.username = username;
        this.password = password;

        loginResponse = loginResponseModel;
    }

    public void setUsername(String username)
    {
        this.username.postValue(username);
    }

    public MutableLiveData<String> getUsername()
    {
        return username;
    }

    public void setPassword(String password)
    {
        this.password.postValue(password);
    }

    public MutableLiveData<String> getPassword()
    {
        return password;
    }

    public void setLoginResponse(LoginResponseModel loginResponse)
    {
        this.loginResponse.postValue(loginResponse);
    }

    public MutableLiveData<LoginResponseModel> getLoginResponse()
    {
        return loginResponse;
    }

    public void onLoginClick()
    {
//        Log.d(TAG, "onLoginClick: Username ='" + getUsername().getValue() + "', Password ='"
//                + getPassword().getValue());

        loginUseCase.subscribe((result -> {
            Log.d(TAG, "onResult: " + result);

            setLoginResponse(result);
        }));
        loginUseCase.performLogin(getUsername().getValue(), getPassword().getValue());
    }
}
