
package com.company.view;
import com.company.controller.GameController;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println("Como deseas crear los personajes?");
        System.out.println("1. Manual");
        System.out.println("2. Aleatorio");
        System.out.print("Elija una opción: ");
        return sc.nextInt();
    }

    public Object[] ingresarDatosPersonaje() {
        System.out.print("Raza (1.Humano, 2.Orco, 3.Elfo): ");
        int numRaza = sc.nextInt();
        numRaza = validarDato("Raza (1.Humano, 2.Orco, 3.Elfo)", numRaza, 3);

        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Apodo: ");
        String apodo = sc.next();

        System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
        String fechaNacimiento = sc.next();
        fechaNacimiento = validarFecha(fechaNacimiento);

        GameController controller = new GameController();
        int edad = controller.calcularEdad(convertirStringACalender(fechaNacimiento));

        System.out.println("Edad: " + edad);

        System.out.print("Velocidad (1 a 10): ");
        int velocidad = sc.nextInt();
        velocidad = validarDato("Velocidad", velocidad, 10);

        System.out.print("Destreza (1 a 5): ");
        int destreza = sc.nextInt();
        destreza = validarDato("Destreza", destreza, 5);

        System.out.print("Fuerza (1 a 10): ");
        int fuerza = sc.nextInt();
        fuerza = validarDato("Fuerza", fuerza, 10);

        System.out.print("Nivel (1 a 10): ");
        int nivel = sc.nextInt();
        nivel = validarDato("Nivel", nivel, 10);

        System.out.print("Armadura (1 a 10): ");
        int armadura = sc.nextInt();
        armadura = validarDato("Armadura", armadura, 10);

        return new Object[]{numRaza, nombre, apodo, fechaNacimiento, edad, velocidad, destreza, fuerza, nivel, armadura};
    }

    private Calendar convertirStringACalender(String fecha) {
        int dia = Integer.parseInt(fecha.substring(0, 2));
        int mes = Integer.parseInt(fecha.substring(3, 5));
        int anio = Integer.parseInt(fecha.substring(6, 10));

        Calendar calendar = Calendar.getInstance();
        calendar.set(anio, mes, dia);

        return calendar;
    }

    private int validarDato(String nombreDato, int dato, int numMax){
        boolean numValido = false;
        while (!numValido){
            if (dato < 1 || dato > numMax){
                System.out.println("Fuera de rango. Debe estar entre " + 1 + " y " + numMax);
                System.out.print(nombreDato + ": ");
                dato = sc.nextInt();
            }
            else{
                numValido = true;
            }
        }
        return dato;
    }

    private String validarFecha(String fecha){

        String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((172[3-9]|17[3-9]\\d|18\\d{2}|19\\d{2}|20[0-2]\\d|202[0-3]))$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fecha);

        while (!matcher.matches()){
            System.out.println("La fecha no es válida.");
            System.out.println("Ten en cuenta que el año mínimo es el 1723 y el máximo el 2023.");
            System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
            fecha = sc.next();
            matcher = pattern.matcher(fecha);
        }

        return fecha;
    }

}
