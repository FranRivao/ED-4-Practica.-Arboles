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

        String [] reglas1 = {"S->SN PV", "SN->DET N", "DET->el", "N->gato", "PV->V SN",
                "V->ve", "SN->DET N", "DET->la", "N->pelicula"};

        mostrarReglas("Arbol sintactico para la siguiente secuencia de reglas", reglas1);
        Arbol a1 = new Arbol(reglas1);
        mostrarReglas("Derivaciones en PreOrden: ", a1.generarDerivaciones());
        System.out.printf("La frase reconstruida del arbol es: %s\n", a1.generarFrase());
        System.out.println();

        String [] reglas2 = {"S->SN PV", "PV->V SN", "V->come", "SN->DET N", "DET->el", "N->perro"};
        mostrarReglas("Arbol sintactico para la siguiente secuencia de reglas", reglas2);
        Arbol a2 = new Arbol(reglas2);
        System.out.println();

        String [] reglas3 = {"S->SN PV", "N->perro"};
        mostrarReglas("Arbol sintactico para la siguiente secuencia de reglas", reglas3);
        Arbol a3 = new Arbol(reglas3);
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

