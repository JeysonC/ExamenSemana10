package com.example.examensemana10.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examensemana10.R;
import com.example.examensemana10.entities.Pokemon;
import com.example.examensemana10.factories.RetrofitFactory;
import com.example.examensemana10.services.PokemonService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {


    //este constructor recibe los pokemon
    List<Pokemon> pokemons;
    public PokemonAdapter(List<Pokemon> pokemons){
        this.pokemons=pokemons;
    }

    @NonNull
    @Override
    public PokemonAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        PokemonViewHolder vh= new PokemonViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder vh, int position) {

        Pokemon pokemon = pokemons.get(position);
        TextView tvPokemonNumber = vh.itemView.findViewById(R.id.tvPokemonNumber);
        TextView tvPokemonName = vh.itemView.findViewById(R.id.tvPokemonName);
        TextView tvPokemonType = vh.itemView.findViewById(R.id.tvPokemonTipo);
        TextView tvPokemonRegion = vh.itemView.findViewById(R.id.tvPokemonRegion);
        View ly = vh.itemView.findViewById(R.id.lyBase);

        tvPokemonNumber.setText(pokemon.numero);
        tvPokemonName.setText(pokemon.nombre);
        tvPokemonType.setText(pokemon.tipo);
        tvPokemonRegion.setText(pokemon.region);



    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    class PokemonViewHolder extends RecyclerView.ViewHolder{

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
