package com.company.model;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Personaje {

    String raza;
    String nombre;
    String apodo;
    String fechaNacimiento;
    int edad;
    int salud;
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

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }


    //METODOS

    /*

        // CREAR PERSONAJE ALEATORIO
    public Personaje generarPersonaje(){

        Random random = new Random();
        int numRaza = random.nextInt(3)+1;

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

        /*
        if (numRaza == 1){
            raza = "Humano";
            return new Humano(raza, nombre, apodo, fechaNacimiento, edad, this.salud ,velocidad, destreza, fuerza, nivel, armadura);
        }
        else if (numRaza == 2) {
            raza = "Orco";
            return new Orco(raza, nombre, apodo, fechaNacimiento, edad, this.salud ,velocidad, destreza, fuerza, nivel, armadura);
        }
        else{
            raza = "Elfo";
            return new Elfo(raza, nombre, apodo, fechaNacimiento, edad, this.salud ,velocidad, destreza, fuerza, nivel, armadura);
        }



        return generarRaza(numRaza, nombre, apodo, fechaNacimiento, edad, this.salud ,velocidad, destreza, fuerza, nivel, armadura);

    }

    private Personaje generarRaza(int numRaza, String nombre, String apodo, String fechaNacimiento, int edad, int salud, int velocidad, int destreza, int fuerza, int nivel, int armadura){
        String raza;
        if (numRaza == 1){
            raza = "Humano";
            return new Humano(raza, nombre, apodo, fechaNacimiento, edad, salud ,velocidad, destreza, fuerza, nivel, armadura);
        }
        else if (numRaza == 2) {
            raza = "Orco";
            return new Orco(raza, nombre, apodo, fechaNacimiento, edad, salud ,velocidad, destreza, fuerza, nivel, armadura);
        }
        else{
            raza = "Elfo";
            return new Elfo(raza, nombre, apodo, fechaNacimiento, edad, salud ,velocidad, destreza, fuerza, nivel, armadura);
        }
    }


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

        // CREAR PERSONAJE MANUALMENTE
    //TODO: Los datos tienen que ser ingresados desde la UI
    public Personaje generarPersonajeManualmente(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Raza (1.Humano, 2.Orco, 3.Elfo): ");
        int numRaza = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Apodo: ");
        String apodo = sc.next();
        System.out.print("Fecha de nacimiento (dd/mm/aa): ");
        String fechaNacimiento = sc.next();
        System.out.print("Edad: ");
        int edad = sc.nextInt();

        //TODO: Validar datos que no se pasen del maximo ni del minimo
        System.out.print("Velocidad (1 a 10): ");
        int velocidad = sc.nextInt();
        System.out.print("Destreza (1 a 5): ");
        int destreza = sc.nextInt();
        System.out.print("Fuerza (1 a 10): ");
        int fuerza = sc.nextInt();
        System.out.print("Nivel (1 a 10): ");
        int nivel = sc.nextInt();
        System.out.print("Armadura (1 a 10): ");
        int armadura = sc.nextInt();

        return generarRaza(numRaza, nombre, apodo, fechaNacimiento, edad, this.salud ,velocidad, destreza, fuerza, nivel, armadura);
    }
    */

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

    // TODO: Bajar? se hacen eternas las partidas porque la defensa es alta
    public int calcularPoderDefensa(int armadura, int velocidad){
        return armadura * velocidad;
    }
    public abstract double atacar(int VA, int PDEF);

    public void recibirDanio(int danioProvocado, Personaje personaje2) {
        personaje2.setSalud(salud - danioProvocado);
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


