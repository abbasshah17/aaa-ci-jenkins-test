package com.example.jenkins_ci_test.network.di.modules;

import com.example.jenkins_ci_test.jenkins_ci_test.di.scopes.JcitScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(
        includes = {
                OkHttpModule.class
        }
)
public abstract class RetrofitModule {

    private static final String DUMMY_BASE_URL = "https://google.com";


    @JcitScope
    @Provides
    public static Retrofit providesRetrofit(OkHttpClient okHttpClient)
    {
        return new Retrofit.Builder()
                .baseUrl(DUMMY_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
