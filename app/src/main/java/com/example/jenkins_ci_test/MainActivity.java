package com.example.jenkins_ci_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.jenkins_ci_test.databinding.ActivityMainBinding;
import com.example.jenkins_ci_test.vm.HelloViewModel;
import com.example.jenkins_ci_test.vm.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setLifecycleOwner(this);

        LoginViewModel viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        binding.setLoginViewModel(viewModel);
    }
}
