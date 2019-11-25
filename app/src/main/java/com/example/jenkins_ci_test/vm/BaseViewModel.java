package com.example.jenkins_ci_test.vm;

import android.app.Application;

import androidx.lifecycle.ViewModel;

abstract class BaseViewModel extends ViewModel {

    public BaseViewModel()
    {

    }

    @Override
    public void onCleared()
    {
    }
}
