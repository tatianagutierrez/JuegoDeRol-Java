package com.company.model;

public class Humano extends Personaje{

    //Contructor
    public Humano(){}

    public Humano(String raza, String nombre, String apodo, String fechaNacimiento, int edad, int salud, int velocidad, int destreza, int fuerza, int nivel, int armadura) {
        super(raza, nombre, apodo, fechaNacimiento, edad, salud, velocidad, destreza, fuerza, nivel, armadura);
    }

    //Metodos
    public Personaje crearPersonaje(Object[] d) {

        return new Humano("Humano", (String) d[1], (String) d[2], (String) d[3], (Integer) d[4] , 100,(Integer) d[5], (Integer) d[6], (Integer) d[7], (Integer) d[8], (Integer) d[9]);
    }

    @Override
    public double atacar(int VA, int PDEF) {
        double danio = ( (double) (VA - PDEF) / 500) * 100;

        return (danio < 0)?0:danio;
    }
}
