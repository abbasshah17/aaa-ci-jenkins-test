package com.example.jenkins_ci_test.network.di.modules;

import com.example.jenkins_ci_test.BuildConfig;
import com.example.jenkins_ci_test.jenkins_ci_test.di.scopes.JcitScope;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public abstract class OkHttpModule {

    @JcitScope
    @Provides
    public static OkHttpClient providesOkHttpClient()
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

            //  NONE, BASIC, HEADERS, BODY
            logging.setLevel(HttpLoggingInterceptor.Level.BODY); // set your desired log level

            httpClient.addInterceptor(logging);// add logging as last interceptor
        }

        httpClient.connectTimeout(1, TimeUnit.MINUTES);
        httpClient.writeTimeout(1, TimeUnit.MINUTES);
        httpClient.readTimeout(1, TimeUnit.MINUTES);

//        httpClient.networkInterceptors().add(REWRITE_CACHE_CONTROL_INTERCEPTOR);

        return httpClient.build();
    }
}
