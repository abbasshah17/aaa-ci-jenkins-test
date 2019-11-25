package com.example.jenkins_ci_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.jenkins_ci_test.databinding.ActivityMainBinding;
import com.example.jenkins_ci_test.vm.HelloViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        HelloViewModel viewModel = ViewModelProviders.of(this).get(HelloViewModel.class);

        binding.setHelloViewModel(viewModel);
    }
}