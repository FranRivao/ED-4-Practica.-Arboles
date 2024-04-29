package arbolbinario;

import java.util.Arrays;

public class Pruebas {

    public static void main(String[] args) {
        System.out.println("********** PRUEBAS ARBOL SINTACTICO **********");
        System.out.println("Gramática:\n" +
                "S→SN PV\n" +
                "SN→DET N\n" +
                "PV→V SN\n" +
                "DET→el|la\n" +
                "N→gato|perro|película\n" +
                "V →ve|come\n");

        String [] reglas = {"S->SN PV", "SN->DET N", "DET->el", "N->gato", "PV->V SN",
                "V->ve", "SN->DET N", "DET->la", "N->pelicula"};

        mostrarReglas("Arbol sintactico para la siguiente secuencia de reglas", reglas);
        Arbol a = new Arbol(reglas);
        System.out.println();

        String s = a.generarFrase();
        System.out.println(s);
        System.out.printf("La frase reconstruida del arbol es: %s\n", s);
    }

    private static void mostrarReglas(String mensaje, String [] reglas) {
        System.out.print(mensaje + ": [");
        for (int i = 0; i < reglas.length; i++) {
            System.out.print(reglas[i]);
            if (i != reglas.length-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}

