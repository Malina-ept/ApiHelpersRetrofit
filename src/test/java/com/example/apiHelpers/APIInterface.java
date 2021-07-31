package com.example.apiHelpers;

import com.example.apiHelpers.pojo.CreateUserRequest;
import com.example.apiHelpers.pojo.CreateUserResponse;
import com.example.apiHelpers.pojo.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @GET("users/2")
    Call<User> getUser();

    @GET("users/23")
    Call<User> getUserNotFound();

    @POST("users")
    Call<CreateUserResponse> createUser(@Body CreateUserRequest createUserRequest);

    @DELETE("users/2")
    Call<User> deleteUser();

}
