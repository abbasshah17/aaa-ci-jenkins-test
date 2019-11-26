package com.example.jenkins_ci_test.login.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.jenkins_ci_test.R;
import com.example.jenkins_ci_test.base.vm.ViewModelFactory;
import com.example.jenkins_ci_test.databinding.ActivityMainBinding;
import com.example.jenkins_ci_test.jenkins_ci_test.app.JCITApplication;
import com.example.jenkins_ci_test.login.di.components.LoginComponent;
import com.example.jenkins_ci_test.login.vm.LoginViewModel;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    JCITApplication jcitApplication;
    LoginComponent loginComponent;

    @Inject
    ViewModelFactory vmFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        jcitApplication = (JCITApplication) getApplication();

        loginComponent = jcitApplication.getJcitComponent().getLoginComponentBuilder().build();

        loginComponent.inject(this);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setLifecycleOwner(this);

        LoginViewModel viewModel = ViewModelProviders.of(this, vmFactory).get(LoginViewModel.class);

        binding.setLoginViewModel(viewModel);
    }
}
