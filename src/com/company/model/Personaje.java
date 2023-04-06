package com.company.model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    /*
    public Object[] datosAleatorios(){
        Random random = new Random();


        int numNombre = random.nextInt(10)+1;
        String[] nombreApodo = generarNombreYApodo(numRaza, numNombre);
        String nombre = nombreApodo[0];
        String apodo = nombreApodo[1];


        String nombre = "Calipsus";
        String apodo = "El gladiador";

        String fechaNacimiento = generarFechaNacimientoAleatoria();
        int edad = random.nextInt(300)+1;
        int velocidad = random.nextInt(10)+1;
        int destreza = random.nextInt(5)+1;
        int fuerza = random.nextInt(10)+1;
        int nivel = random.nextInt(10)+1;
        int armadura = random.nextInt(10)+1;

        return new Object[]{nombre, apodo, fechaNacimiento, edad, velocidad, destreza, fuerza, nivel, armadura};
        //return new String[]{nombre, apodo, fechaNacimiento, String.valueOf(edad), String.valueOf(velocidad)};
    }
    */

    /*
    public Personaje generarPersonaje(int numRaza){

        Random random = new Random();

        int numNombre = random.nextInt(10)+1;
        String[] nombreApodo = generarNombreYApodo(numRaza, numNombre);
        String nombre = nombreApodo[0];
        String apodo = nombreApodo[1];

        String fechaNacimiento = generarFechaNacimientoAleatoria();
        int edad = random.nextInt(300)+1;
        int velocidad = random.nextInt(10)+1;
        int destreza = random.nextInt(5)+1;
        int fuerza = random.nextInt(10)+1;
        int nivel = random.nextInt(10)+1;
        int armadura = random.nextInt(10)+1;


        if (numRaza == 1){
            return new Humano("Humano", nombre, apodo, fechaNacimiento, edad, this.salud ,velocidad, destreza, fuerza, nivel, armadura);
        }
        else if (numRaza == 2) {
            return new Orco("Orco", nombre, apodo, fechaNacimiento, edad, this.salud ,velocidad, destreza, fuerza, nivel, armadura);
        }
        else{
            return new Elfo("Elfo", nombre, apodo, fechaNacimiento, edad, this.salud ,velocidad, destreza, fuerza, nivel, armadura);
        }



    }
    */

    /*
    private Personaje generarRaza(int numRaza, String nombre, String apodo, String fechaNacimiento, int edad, int salud, int velocidad, int destreza, int fuerza, int nivel, int armadura){
        String raza;
        if (numRaza == 1){
            raza = "Humano";
        }
        else if (numRaza == 2) {
            raza = "Orco";
        }
        else{
            raza = "Elfo";
        }
        return new Orco(raza, nombre, apodo, fechaNacimiento, edad, salud ,velocidad, destreza, fuerza, nivel, armadura);
    }

    */
    // TODO: Consumir una api con nombres ??
    private String[] generarNombreYApodo(int numRaza, int numNombre){

        String [][] nombresHumanos = {{"Ivar", "El arquero"}, {"Gerda", "La fortaleza"}, {"Atila", "El húngaro"}, {"Eric", "El hacha sangrienta"}, {"César", "El Divino"}, {"Leónidas", "El hijo del león"}, {"Helga", "La daga"}, {"Sigrid", "La victoria"}, {"William", "El cuervo"}, {"Ian", "El destructor"}};

        String [][] nombresOrcos = {{"Kruhlu", "Sangre salvaje"}, {"Ulumpha", "Martillo estruendoso"}, {"Anakkin", "Reliquia del fuego"}, {"Ayleids", "Sombra de ira"}, {"Tjasatheni", "Colmillo de demonio"}, {"Sinnamnuria", "Rugido silencioso"}, {"Trurnuk", "Puño de roca"}, {"Xoruk", "Paso fuerte"}, {"Xoruk", "Furia Gigante"}, {"Dakagrod", "Golpes de piedra"}};

        String [][] nombresElfos = {{"Fëanor", "Espíritu de fuego"}, {"Legolas", "Hoja verde"}, {"Arwen", "Doncella noble"}, {"Isildur", "Sirviente de la Luna"}, {"Lúthien", "Hija del crepúsculo"}, {"Miriel", "Mujer de las agujas"}, {"Angrod", "Héroe de hierro"}, {"Círdan", "Carpintero de barcos"}, {"Mablung", "Mano pesada"}, {"Celeborn ", "Árbol de plata"}};

        // http://escueladeprogramacion.es/snippets/Java/Algoritmos/Matrices/Recorrer.html COMO RECORRER MATRIZ

        String nombre = "";
        String apodo = "";

        if (numRaza == 1){
            for (int i = 0; i < numNombre; i++) {
                nombre = nombresHumanos[i][0];
                apodo = nombresHumanos[i][1];
            }
        }
        else if (numRaza == 2) {
            for (int i = 0; i < numNombre; i++) {
                nombre = nombresOrcos[i][0];
                apodo = nombresOrcos[i][1];
            }
        }
        else {
            for (int i = 0; i < numNombre; i++) {
                nombre = nombresElfos[i][0];
                apodo = nombresElfos[i][1];
            }
        }

        return new String[]{nombre, apodo};
    }


    private String generarFechaNacimientoAleatoria(){
        Random random = new Random();

        int dia = random.nextInt(31)+1;
        int mes = random.nextInt(12)+1;
        int anio = ThreadLocalRandom.current().nextInt(1800, 2022)+1;

        return dia + "/" + mes + "/" + anio;
    }

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


