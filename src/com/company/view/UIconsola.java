
package com.company.view;
import com.company.controller.GameController;

import java.util.Calendar;
import java.util.Scanner;

public class UIconsola {

    Scanner sc;

    public UIconsola() {
        sc = new Scanner(System.in);
    }

    public void print(String texto){
        System.out.println(texto);
    }

    public int menu() {
        System.out.println("\nBienvenido");
        System.out.println("¿Deseas jugar una partida?");
        System.out.println("1. Jugar");
        System.out.println("2. Leer historial de partidas");
        System.out.println("3. Borrar historial");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");

        return sc.nextInt();
    }

    public String ingresarNombre(){
        System.out.print("Vamos a emprezar, primero dime como te llamas: ");
        return sc.next();
    }

    public int opcionCreacionPersonajes(){
        System.out.println("Como desea crear los personajes?");
        System.out.println("1. Manual");
        System.out.println("2. Aleatorio");
        System.out.print("Elija una opción: ");
        return sc.nextInt();
    }

    public Object[] ingresarDatosPersonaje() {
        System.out.print("Raza (1.Humano, 2.Orco, 3.Elfo): ");
        int numRaza = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Apodo: ");
        String apodo = sc.next();

        System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
        String fechaNacimiento = sc.next();

        GameController controller = new GameController();
        int edad = controller.calcularEdad(convertirStringACalender(fechaNacimiento));

        System.out.println("Edad: " + edad);

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

        return new Object[]{numRaza, nombre, apodo, fechaNacimiento, edad, velocidad, destreza, fuerza, nivel, armadura};
        //Devuelvo y despues el controller valida los datos
    }

    private Calendar convertirStringACalender(String fecha) {
        int dia = Integer.parseInt(fecha.substring(0, 2));
        int mes = Integer.parseInt(fecha.substring(3, 5));
        int anio = Integer.parseInt(fecha.substring(6, 10));

        Calendar calendar = Calendar.getInstance();
        calendar.set(anio, mes, dia);

        return calendar;
    }

}
