package com.company.model;

public class Orco extends Personaje{

    //Contructor
    public Orco(String raza, String nombre, String apodo, String fechaNacimiento, int edad, int salud, int velocidad, int destreza, int fuerza, int nivel, int armadura) {
        super(raza, nombre, apodo, fechaNacimiento, edad, salud, velocidad, destreza, fuerza, nivel, armadura);
    }

    //Metodos
    @Override
    public double atacar(int VA, int PDEF) {
        return (( (double) (VA - PDEF) / 500) * 100) * 1.1;
    }
}
