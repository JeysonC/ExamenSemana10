package com.example.examensemana10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.examensemana10.adapters.PokemonAdapter;
import com.example.examensemana10.entities.Pokemon;
import com.example.examensemana10.factories.RetrofitFactory;
import com.example.examensemana10.services.PokemonService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Pokemon> pokemons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Exam10","onCreate");
        setContentView(R.layout.activity_main);


        Retrofit retrofit = RetrofitFactory.build();

        Button btnMostrar = findViewById(R.id.btnMostrar);
        Button btnCrear = findViewById(R.id.btnCrear);



        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pasamos a la segunda actividad
                Intent intent = new Intent(getApplicationContext(),SegundaActividad.class);
                startActivity(intent);
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pasamos a la tercera actividad
                Intent intent = new Intent(getApplicationContext(),TerceraActividad.class);

                Retrofit retrofit = RetrofitFactory.build();
                PokemonService service = retrofit.create(PokemonService.class);
                Call<List<Pokemon>> call = service.getPokemon();

                call.enqueue(new Callback<List<Pokemon>>() {
                    @Override
                    public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                        if(!response.isSuccessful()){
                            Log.e("Exam10", "Error de app");
                        }else{
                            Log.i("Exam10", "Conexion Exitosa");
                            Log.i("Exam10", new Gson().toJson(response.body()));

                            pokemons = response.body();
                            PokemonAdapter Pokadapter = new PokemonAdapter(pokemons);

                            RecyclerView rv = findViewById(R.id.rvPokemons);
                            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            rv.setHasFixedSize(true);
                            rv.setAdapter(Pokadapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Pokemon>> call, Throwable t) {

                    }
                });

                startActivity(intent);
            }
        });






    }
}