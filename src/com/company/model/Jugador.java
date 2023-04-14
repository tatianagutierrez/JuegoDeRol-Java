package com.company.model;

import java.util.ArrayList;
import java.util.Random;

public class Jugador {

    String nombre;
    ArrayList<Personaje> listaPersonajes = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Personaje> getListaPersonajes() {
        return listaPersonajes;
    }

    public void agregarPersonje(Personaje pj){
        listaPersonajes.add(pj);
    }

    public void eliminarPersonaje(Personaje pj){
        listaPersonajes.remove(pj);
    }

    public Personaje obtenerPersonajeRandom(){
        Random random = new Random();
        int indexRandom = random.nextInt(listaPersonajes.size());
        return listaPersonajes.get(indexRandom);
    }

    public Personaje obtenerPersonajeByIndex(int index){
        return listaPersonajes.get(index);
    }


}
