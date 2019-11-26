package com.example.jenkins_ci_test.base.views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        hideActionBar();
    }

    protected void hideActionBar()
    {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        if (getActionBar() != null) {
            getActionBar().hide();
        }
    }
}
