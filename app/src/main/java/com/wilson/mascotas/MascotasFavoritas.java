package com.wilson.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        listaMascotas = findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);


        //GridLayoutManager glm = new GridLayoutManager(this, 2);
        //listaMascotas.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Toby", R.drawable.mascota_dog, "2"));
        mascotas.add(new Mascota("Kitty", R.drawable.mascota_gato, "3"));
        mascotas.add(new Mascota("Wonny", R.drawable.mascota_conejo, "1"));
        mascotas.add(new Mascota("Stuart", R.drawable.mascota_hamster, "2"));
        mascotas.add(new Mascota("Tiburoncin", R.drawable.mascota_pez, "5"));
    }
}