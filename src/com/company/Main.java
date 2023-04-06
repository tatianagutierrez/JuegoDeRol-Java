package com.company;
import com.company.controller.UIcontroller;
import com.company.view.UIconsola;
import com.company.view.UImenu;

public class Main {

    public static void main(String[] args) {

        UIconsola consola = new UIconsola();
        UIcontroller controller = new UIcontroller();
        int opcion = consola.menu();

        while (opcion != 4){
            switch (opcion){
                case 1:
                    String nombre = consola.ingresarNombre();
                    int opcionPersonajes = consola.opcionCreacionPersonajes();
                    controller.crearJuego(nombre, opcionPersonajes);
                    break;
                case 2:
                    controller.leerHistorial();
                    break;
                case 3:
                    controller.borrarHistorial();
                    break;
            }
            opcion = consola.menu();
        }

        /*
        UImenu ui = new UImenu();
        ui.setVisible(true);
        */
    }
}

