package com.wilson.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {

        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    //Inflar el layout y lo pasará al viewholder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(view);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaAdaptador.MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombreMascota());
        holder.tvRating.setText(mascota.getRanking());



        //Evento onClic imgFoto
        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getNombreMascota(), Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(activity, MascotasFavoritas.class);
                //intent.putExtra("nombre", mascota.getNombreMascota());
                //activity.startActivity(intent);
            }
        });


        //Evento onClic btnLike
        holder.imgHueso2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste Like a: " + mascota.getNombreMascota(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRating;
        private ImageView imgHueso2;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            imgHueso2 = itemView.findViewById(R.id.imgHueso2);
            tvRating = itemView.findViewById(R.id.tvRating);



        }

    }


}

