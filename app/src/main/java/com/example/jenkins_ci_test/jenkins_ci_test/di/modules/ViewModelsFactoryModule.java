package com.example.jenkins_ci_test.jenkins_ci_test.di.modules;

import androidx.lifecycle.ViewModelProvider;

import com.example.jenkins_ci_test.base.vm.ViewModelFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelsFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindsViewModelProviderFactory(ViewModelFactory viewModelFactory);
}
