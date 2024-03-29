package com.example.jenkins_ci_test.login.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.jenkins_ci_test.R;
import com.example.jenkins_ci_test.base.domain.models.login.LoginResponseModel;
import com.example.jenkins_ci_test.base.vm.ViewModelFactory;
import com.example.jenkins_ci_test.databinding.ActivityMainBinding;
import com.example.jenkins_ci_test.jenkins_ci_test.app.JCITApplication;
import com.example.jenkins_ci_test.login.di.components.LoginComponent;
import com.example.jenkins_ci_test.login.vm.LoginViewModel;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    JCITApplication jcitApplication;
    LoginComponent loginComponent;

    @Inject
    ViewModelFactory vmFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        onLaunch();
    }

    void onLaunch()
    {
        jcitApplication = (JCITApplication) getApplication();

        loginComponent = jcitApplication.getJcitComponent().getLoginComponentBuilder().build();

        loginComponent.inject(this);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setLifecycleOwner(this);

        LoginViewModel viewModel = ViewModelProviders.of(this, vmFactory).get(LoginViewModel.class);

        binding.setLoginViewModel(viewModel);

        viewModel.getLoginResponse().observe(this, (response) -> {
            onLoginSuccess(LoginActivity.this, response);
        });
    }

    void onLoginSuccess(Context context, LoginResponseModel loginResponseModel)
    {
        String toastMessage = "Invalid response format";

        if (loginResponseModel == null || loginResponseModel.getStatus().equalsIgnoreCase("failure")) {
            toastMessage = "Failure : " + (loginResponseModel == null ? null : loginResponseModel.getMessage());
        }
        else if (loginResponseModel.getStatus().equalsIgnoreCase("success")) {
            toastMessage = "Success : " + loginResponseModel.getMessage();
        }

        Log.d(TAG, toastMessage);

        Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show();
    }
}
