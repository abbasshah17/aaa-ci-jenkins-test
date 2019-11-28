package com.example.jenkins_ci_test.jenkins_ci_test.di.modules;

import androidx.lifecycle.MutableLiveData;

import com.example.jenkins_ci_test.base.domain.models.login.LoginResponseModel;
import com.example.jenkins_ci_test.base.domain.repository.Task;
import com.example.jenkins_ci_test.jenkins_ci_test.app.JCITApplication;
import com.example.jenkins_ci_test.jenkins_ci_test.di.scopes.JcitScope;
import com.example.jenkins_ci_test.login.di.names.LivePasswordKey;
import com.example.jenkins_ci_test.login.di.names.LiveResponseModelKey;
import com.example.jenkins_ci_test.login.di.names.LiveUsernameKey;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class JCITModule {
    private static JCITApplication jcitApplication;

    public JCITModule(JCITApplication application)
    {
        jcitApplication = application;
    }

    @JcitScope
    @Provides
    static JCITApplication providesJcitApplication()
    {
        return jcitApplication;
    }

    @Provides
    static List<Task> providesTasksList()
    {
        return new ArrayList<>();
    }

    @Provides
    @LiveUsernameKey
    static MutableLiveData<String> providesLiveUserName() {
        return new MutableLiveData<>();
    }

    @Provides
    @LivePasswordKey
    static MutableLiveData<String> providesLivePassword() {
        return new MutableLiveData<>();
    }

    @Provides
    @LiveResponseModelKey
    static MutableLiveData<LoginResponseModel> providesLiveLoginResponseModel() {
        return new MutableLiveData<>();
    }
}
