package com.example.apiHelpers;

import com.example.apiHelpers.pojo.User;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("users/2")
    Call<User> getUser();

    @GET("users/23")
    Call<User> getUserNotFound();

    @DELETE("users/2")
    Call<User> deleteUser();
}
