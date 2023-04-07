package com.company.model;

import java.util.Random;

public abstract class Personaje {

    String raza;
    String nombre;
    String apodo;
    String fechaNacimiento;
    int edad;
    double salud;
    int velocidad;
    int destreza;
    int fuerza;
    int nivel;
    int armadura;
    Random random = new Random();

    //Controladores
    public Personaje() {}

    public Personaje(String raza, String nombre, String apodo, String fechaNacimiento, int edad, int salud, int velocidad, int destreza, int fuerza, int nivel, int armadura) {
        this.raza = raza;
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.salud = 100;
        this.velocidad = velocidad;
        this.destreza = destreza;
        this.fuerza = fuerza;
        this.nivel = nivel;
        this.armadura = armadura;
    }

    //Setters y getters

    public double getSalud() {
        return salud;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
//METODOS


        // CREAR PERSONAJE ALEATORIO
    public abstract Personaje crearPersonaje(Object[] d);

        // CALCULOS
    private int calcularPoderDisparo(int destreza, int fuerza, int nivelPersonaje){
        return destreza * fuerza * nivelPersonaje;
    }

    /*
    //TODO: Ver si es lo mismo
    private int calcularPoderDisparo(){
        return destreza * fuerza * nivel;
    }
     */

    private float calcularEfectividadDisparo(){

        float numRandom = random.nextInt(100)+1;
        return (numRandom / 100);
    }

    public int calcularValorDeAtaque(int destreza, int fuerza, int nivelPersonaje){
        return Math.round(calcularPoderDisparo(destreza, fuerza, nivelPersonaje) * calcularEfectividadDisparo());
    }

    // TODO: O le doy una variablidad como la efectividadDisparo o hago que se desgaste el poder en cada vuelta (por ejemplo bajar 1 punto desde 20)
    public int calcularPoderDefensa(int armadura, int velocidad){
        return armadura * velocidad;
    }

    public abstract double atacar(int VA, int PDEF);

    public void recibirDanio(double danioProvocado) {
        double salud = this.salud - danioProvocado;

        if (salud < 0) {
            salud = 0;
        }

        this.setSalud(salud);
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "raza='" + raza + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apodo='" + apodo + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", edad=" + edad +
                ", salud=" + salud +
                ", velocidad=" + velocidad +
                ", destreza=" + destreza +
                ", fuerza=" + fuerza +
                ", nivel=" + nivel +
                ", armadura=" + armadura +
                '}';
    }
}


