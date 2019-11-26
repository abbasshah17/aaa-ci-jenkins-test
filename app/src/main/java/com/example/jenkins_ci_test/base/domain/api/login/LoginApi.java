package com.example.jenkins_ci_test.base.domain.api.login;

import com.example.jenkins_ci_test.base.domain.models.login.LoginResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface LoginApi {

    //  TODO : Provide a valid url.
    String LOGIN_URL = "http://";

    @Headers("Cache-Control: no-cache")
    @GET
    Call<LoginResponseModel> api(
            @Url String url,
            @Header("USERNAME") String username,
            @Header("PASSWORD") String password
    );
}
