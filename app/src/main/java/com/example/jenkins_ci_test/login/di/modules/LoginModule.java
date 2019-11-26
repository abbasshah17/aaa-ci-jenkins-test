package com.example.jenkins_ci_test.login.di.modules;

import androidx.lifecycle.ViewModel;

import com.example.jenkins_ci_test.base.vm.ViewModelKey;
import com.example.jenkins_ci_test.login.di.scopes.LoginScope;
import com.example.jenkins_ci_test.login.vm.LoginViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class LoginModule {

    @Binds
    @IntoMap
    @LoginScope
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bindsLoginViewModel(LoginViewModel viewModel);
}
