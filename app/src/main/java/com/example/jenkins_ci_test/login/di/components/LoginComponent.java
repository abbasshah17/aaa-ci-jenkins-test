package com.example.jenkins_ci_test.login.di.components;

import com.example.jenkins_ci_test.jenkins_ci_test.di.modules.ViewModelsFactoryModule;
import com.example.jenkins_ci_test.login.di.modules.LoginModule;
import com.example.jenkins_ci_test.login.di.scopes.LoginScope;
import com.example.jenkins_ci_test.login.views.LoginActivity;

import dagger.Subcomponent;

@LoginScope
@Subcomponent(modules = {
        LoginModule.class,
        ViewModelsFactoryModule.class
})
public interface LoginComponent {

    void inject(LoginActivity activity);

    @Subcomponent.Builder
    interface Builder {
        LoginComponent build();
    }
}
