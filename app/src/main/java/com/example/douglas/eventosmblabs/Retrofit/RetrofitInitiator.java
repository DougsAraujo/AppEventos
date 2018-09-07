package com.example.douglas.eventosmblabs.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInitiator {

    private  Retrofit retrofit = null;

    public Retrofit RetrofitInitiator() {

        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://eventosmblabs.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
