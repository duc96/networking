package com.example.gojobs.api;

import com.example.gojobs.modal.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    @FormUrlEncoded
    @POST("dangKy")
    Call<Void>addUser(@Field("tenNguoiDung") String tenNguoiDung, @Field("matKhau") String matKhau, @Field("email") String email, @Field("phone") String phone);

    @GET("/allUser")
    Call<List<User>> getAllUser();


}
