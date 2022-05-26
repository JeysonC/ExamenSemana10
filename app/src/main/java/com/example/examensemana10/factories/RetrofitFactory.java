package com.example.examensemana10.factories;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    public static Retrofit build(){
        //invocar los datos de retrofit
        return new Retrofit.Builder()
                .baseUrl("https://628f5e820e69410599db36a5.mockapi.io/api/v1/") //ponemos el protocolo + dominio
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
