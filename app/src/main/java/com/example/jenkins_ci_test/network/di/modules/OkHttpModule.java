package com.example.jenkins_ci_test.network.di.modules;

import com.example.jenkins_ci_test.BuildConfig;
import com.example.jenkins_ci_test.jenkins_ci_test.di.scopes.JcitScope;
import com.example.jenkins_ci_test.network.interceptor.OkHttpInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public abstract class OkHttpModule {

    @JcitScope
    @Provides
    public static OkHttpClient providesOkHttpClient(OkHttpInterceptor interceptor)
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

            //  NONE, BASIC, HEADERS, BODY
            logging.setLevel(HttpLoggingInterceptor.Level.BODY); // set your desired log level

            httpClient.addInterceptor(logging);// add logging as last interceptor
        }

        httpClient.addInterceptor(interceptor);

        httpClient.connectTimeout(15, TimeUnit.SECONDS);
        httpClient.writeTimeout(15, TimeUnit.SECONDS);
        httpClient.readTimeout(15, TimeUnit.SECONDS);

//        httpClient.networkInterceptors().add(REWRITE_CACHE_CONTROL_INTERCEPTOR);

        return httpClient.build();
    }
}
