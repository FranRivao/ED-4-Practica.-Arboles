package arbolbinario;

import java.util.Stack;

public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(String dato) {
        raiz = new NodoArbol(dato);
    }

    public Arbol(String dato, Arbol izquierdo, Arbol derecho) {
        NodoArbol nodoIzq = null;
        NodoArbol nodoDer = null;
        if (izquierdo != null) {
            nodoIzq = izquierdo.raiz;
        }
        if (derecho != null) {
            nodoDer = derecho.raiz;
        }
        raiz = new NodoArbol(dato, nodoIzq, nodoDer);
    }

    /**
     * Recorrido en preorden
     */
    public void preOrden() {
        System.out.print("Preorden: ");
        this.preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + "  ");
            this.preOrdenRec(nodo.getIzquierdo());
            this.preOrdenRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en orden central
     */
    public void ordenCentral() {
        System.out.print("Orden Central: ");
        this.ordenCentralRec(raiz);
        System.out.println();
    }

    private void ordenCentralRec(NodoArbol nodo) {
        if (nodo != null) {
            this.ordenCentralRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + "  ");
            this.ordenCentralRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en postorden
     */
    public void postOrden() {
        System.out.print("Postorden: ");
        this.postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            this.postOrdenRec(nodo.getIzquierdo());
            this.postOrdenRec(nodo.getDerecho());
            System.out.print(nodo.getDato() + "  ");
        }
    }

    /**
     * Recorrido en amplitud con una cola de nodos del árbol
     */
    public void amplitud() {
        Cola cola = new Cola();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.encolar(raiz);
            while (!cola.vacia()) {
                NodoArbol nodo = cola.desencolar();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.encolar(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.encolar(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    // ------------------------------------------------------------------------
    // TODO 2.3
    public Arbol(String[] reglas) {
        raiz = new NodoArbol("S");
        Cola colAux = new Cola();
        colAux.encolar(raiz);

        int contadorRegla = 0;
        while(contadorRegla < reglas.length && raiz != null) {
            String parteIzq = Utilidades.getParteIzquierda(reglas[contadorRegla]),
                    parteDer = Utilidades.getParteDerecha(reglas[contadorRegla]);

            boolean aplicada = false; int contador = 0;
            while(contador < colAux.getNumElementos() && !aplicada) {
                NodoArbol nodo = colAux.desencolar();
                if (nodo.getDato().equals(parteIzq)) {
                    aplicada = true;

                    if (Utilidades.esReglaIntermedia(reglas[contadorRegla])) {
                        aplicarReglaIntermedia(parteDer, colAux, nodo);
                    } else {
                        aplicarReglaFinal(parteDer, nodo);
                    }
                } else {
                    colAux.encolar(nodo);
                }
                contador++;
            }

            if (!aplicada) {
                System.out.println("No se ha podido aplicar la regla: " + reglas[contadorRegla]);
                raiz = null;
            }

            contadorRegla++;
        }

        if (!colAux.vacia()) {
            System.out.println("No se han podido aplicar todas las reglas");
            raiz = null;
        }
    }

    private void aplicarReglaIntermedia(String parteDer, Cola colAux, NodoArbol nodo) {
        NodoArbol izquierdo, derecho;

        String[] simbolosNoTerm = parteDer.split(" ");
        izquierdo = new NodoArbol(simbolosNoTerm[0]);
        derecho = new NodoArbol(simbolosNoTerm[1]);

        nodo.setIzquierdo(izquierdo);
        colAux.encolar(izquierdo);

        nodo.setDerecho(derecho);
        colAux.encolar(derecho);
    }

    private void aplicarReglaFinal(String parteDer, NodoArbol nodo) {
        nodo.setIzquierdo(new NodoArbol(parteDer));
        nodo.setDerecho(null);
    }

    // ------------------------------------------------------------------------
    // TODO 2.4
    public String[] generarDerivaciones() {
        System.out.print("La frase reconstruida del arbol es: ");
        this.generarDerivacionesRec(raiz);
        return null;
    }

    private void generarDerivacionesRec(NodoArbol nodo) {
    }

    // ------------------------------------------------------------------------
    // TODO 2.5
    public String generarFrase() {
        return this.generarFraseRec(raiz);
    }

    private String generarFraseRec(NodoArbol nodo) {
        String s = "";
        if (nodo != null) {
            if (Utilidades.esSimboloTerminal(nodo.getDato()))
                s += nodo.getDato() + " ";
            this.generarFraseRec(nodo.getIzquierdo());
            this.generarFraseRec(nodo.getDerecho());
        }
        return s;
    }

}
