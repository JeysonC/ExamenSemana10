package com.example.examensemana10.services;

import com.example.examensemana10.entities.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PokemonService {

    @GET("pokemon")
    Call<List<Pokemon>> getPokemon();


}
