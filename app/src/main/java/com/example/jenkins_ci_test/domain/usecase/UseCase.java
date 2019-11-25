package com.example.jenkins_ci_test.domain.usecase;

import android.app.Application;
import android.os.Handler;

public abstract class UseCase<T> implements Task<T> {


    public UseCase()
    {
    }

    public void runAsync()
    {
        Handler mHandler = new Handler();

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                T response  = UseCase.this.run();

                respond(response);
            }
        });
    }

    protected abstract void respond(T response);
}
