package com.example.jenkins_ci_test.base.domain.repository;

import android.util.Log;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;

public abstract class RetrofitTask <Api, Result> extends BackgroundTask<Result> {

    private static final String TAG = "RetrofitTask";

    @Inject
    Retrofit retrofit_2_0;

    private Class<? extends Api> clazz;


    public RetrofitTask()
    {
    }

    protected void requestApi(Class<? extends Api> clazz)
    {
        this.clazz = clazz;

        runBackground();
    }

    @Override
    public final void runBackground()
    {
        super.runBackground();
    }

    protected abstract Call<Result> getCall(Api api);

    @Override
    public Result run()
    {
        try {
            Call<Result> call = getCall(retrofit_2_0.create(clazz));

            // Since we're already running on Background Thread.
            return call.execute().body();
        }
        catch (IOException | RuntimeException ex) {
            Log.d(TAG, "run-Error: " + ex.getMessage(), ex);
        }

        return null;
    }
}
