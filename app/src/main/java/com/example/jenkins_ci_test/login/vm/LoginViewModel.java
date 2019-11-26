package com.example.jenkins_ci_test.login.vm;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.jenkins_ci_test.base.vm.BaseViewModel;
import com.example.jenkins_ci_test.login.di.scopes.LoginScope;
import com.example.jenkins_ci_test.login.domain.usecases.LoginTask;

import javax.inject.Inject;

@LoginScope
public class LoginViewModel extends BaseViewModel {

    private static final String TAG = "LoginViewModel";

    private MutableLiveData<String> username;
    private MutableLiveData<String> password;

    private LoginTask loginTask;

    @Inject
    public LoginViewModel(LoginTask loginTask)
    {
        this.loginTask = loginTask;

        username = new MutableLiveData<>("");
        password = new MutableLiveData<>("");
    }

    public void setUsername(String username)
    {
        if (this.username == null) {
            this.username = new MutableLiveData<>();
        }

        this.username.postValue(username);
    }

    public MutableLiveData<String> getUsername()
    {
        return username;
    }

    public void setPassword(String password)
    {
        if (this.password == null) {
            this.password = new MutableLiveData<>();
        }
        
        this.password.postValue(password);
    }

    public MutableLiveData<String> getPassword()
    {
        return password;
    }

    public void onLoginClick()
    {
        Log.d(TAG, "onLoginClick: Username ='" + getUsername().getValue() + "', Password ='"
                + getPassword().getValue());

        loginTask.performLogin(getUsername().getValue(), getPassword().getValue());
    }
}
