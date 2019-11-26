package com.example.jenkins_ci_test.jenkins_ci_test.app;

import android.app.Application;

import com.example.jenkins_ci_test.jenkins_ci_test.di.component.DaggerJCITComponent;
import com.example.jenkins_ci_test.jenkins_ci_test.di.component.JCITComponent;

public class JCITApplication extends Application {

    private JCITComponent jcitComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();

        jcitComponent = DaggerJCITComponent.builder().build();
    }

    public JCITComponent getJcitComponent()
    {
        return jcitComponent;
    }
}
