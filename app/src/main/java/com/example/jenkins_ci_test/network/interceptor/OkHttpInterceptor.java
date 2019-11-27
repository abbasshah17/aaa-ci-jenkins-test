package com.example.jenkins_ci_test.network.interceptor;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpInterceptor implements Interceptor {

    private static final String TAG = "OkHttpInterceptor";


    @Inject
    OkHttpInterceptor()
    {

    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException
    {
        Response response =  chain.proceed(chain.request());

        int responseCode = response.code();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            Log.e(TAG, "Error Occurred.");
        }

        return response;
    }
}
