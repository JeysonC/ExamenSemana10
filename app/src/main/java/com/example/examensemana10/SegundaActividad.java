package com.example.examensemana10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examensemana10.entities.Pokemon;
import com.example.examensemana10.factories.RetrofitFactory;
import com.example.examensemana10.services.PokemonService;

import retrofit2.Call;
import retrofit2.Retrofit;

public class SegundaActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);


        EditText editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        EditText editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        EditText editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        EditText editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);

        Button btnCrear = findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = RetrofitFactory.build();
                PokemonService service = retrofit.create(PokemonService.class);

                Pokemon pokemon = new Pokemon();
                pokemon.numero= Integer.parseInt(editTextTextPersonName.getText().toString());
                pokemon.nombre = String.valueOf(editTextTextPersonName2.getText());
                pokemon.region =String.valueOf( editTextTextPersonName3.getText());
                pokemon.tipo =String.valueOf( editTextTextPersonName4.getText());

                //Call<Pokemon> call = service.create(pokemon);
            }
        });

    }
}