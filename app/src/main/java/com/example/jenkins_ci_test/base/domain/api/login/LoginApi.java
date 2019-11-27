package com.example.jenkins_ci_test.base.domain.api.login;

import com.example.jenkins_ci_test.base.domain.models.login.LoginResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface LoginApi {

    String LOGIN_URL = "http://ec2-34-201-54-35.compute-1.amazonaws.com/user_login.php";

    @GET
    Call<LoginResponseModel> loginUser(
            @Url String url,
            @Header("USERNAME") String username,
            @Header("PASSWORD") String password
    );
}
