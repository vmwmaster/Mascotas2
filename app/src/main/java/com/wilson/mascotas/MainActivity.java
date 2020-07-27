package com.wilson.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = findViewById(R.id.rvMascotas);

        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listaMascotas.setLayoutManager(llm);

        GridLayoutManager glm = new GridLayoutManager(this, 2);
        listaMascotas.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.mFavoritas:
                Intent intent = new Intent(this, MascotasFavoritas.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Toby", R.drawable.mascota_dog, "0"));
        mascotas.add(new Mascota("Kitty", R.drawable.mascota_gato, "0"));
        mascotas.add(new Mascota("Wonny", R.drawable.mascota_conejo, "0"));
        mascotas.add(new Mascota("Stuart", R.drawable.mascota_hamster, "0"));
        mascotas.add(new Mascota("Tiburoncin", R.drawable.mascota_pez, "0"));
        mascotas.add(new Mascota("Alfredo", R.drawable.mascota_kitty, "0"));
    }
}