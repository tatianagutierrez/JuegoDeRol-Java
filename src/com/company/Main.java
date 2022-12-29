package com.company;
import com.company.view.UIconsola;

public class Main {

    public static void main(String[] args) {

        UIconsola UIconsola = new UIconsola();
        int opcion = UIconsola.elegirOpcion();
        UIconsola.ejecutarOpcion(opcion);
    }
}

