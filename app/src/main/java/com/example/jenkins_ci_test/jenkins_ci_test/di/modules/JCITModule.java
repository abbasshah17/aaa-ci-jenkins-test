package com.example.jenkins_ci_test.jenkins_ci_test.di.modules;

import com.example.jenkins_ci_test.jenkins_ci_test.app.JCITApplication;
import com.example.jenkins_ci_test.jenkins_ci_test.di.scopes.JcitScope;

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
    public static JCITApplication providesJcitApplication()
    {
        return jcitApplication;
    }
}
