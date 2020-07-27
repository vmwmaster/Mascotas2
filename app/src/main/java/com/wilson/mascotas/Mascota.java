package com.wilson.mascotas;

public class Mascota {

    private String nombreMascota;
    private String ranking;
    private int foto;

    public Mascota(String nombreMascota, int foto, String ranking) {
        this.nombreMascota = nombreMascota;
        this.foto = foto;
        this.ranking = ranking;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
