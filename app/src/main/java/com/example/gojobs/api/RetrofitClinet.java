package com.example.gojobs.api;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClinet {

    public static final String ROOT_URL2 = "http://192.168.1.28:1996/";

    public static retrofit2.Retrofit retrofit = null;

    public static retrofit2.Retrofit getClien(){
        if (retrofit==null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(ROOT_URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
