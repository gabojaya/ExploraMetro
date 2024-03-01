package estructuraDeDato;

import logica.Estacion;

import java.io.FileWriter;
import java.io.IOException;

public class ListaEnlazadaEstaciones {
    private NodoEstacion head;

    public ListaEnlazadaEstaciones() {
        this.head = null;
    }

    public void insertar(Estacion estacion) {
        if(estacion==null){
            return;
        }
        if (head == null) {
            this.head = new NodoEstacion(estacion);
            return;
        }
        if (!existeEstacion(estacion)) {
            NodoEstacion nodoAux = new NodoEstacion(estacion);
            NodoEstacion headAux = head;
            while (headAux.getSiguienteNodo() != null) {
                headAux = headAux.getSiguienteNodo();
            }
            headAux.setSiguienteNodo(nodoAux);
        }


    }

    private boolean existeEstacion(Estacion estacion) {
        NodoEstacion nodoAux = head;
        while (nodoAux != null) {
            if (nodoAux.esIgual(estacion)) {
                return true;
            }
            nodoAux = nodoAux.getSiguienteNodo();
        }
        return false;
    }

    public boolean existeCapacidadEnLaEstacion(Estacion estacion) {
        return buscarCapacidadDeBoletos(estacion) > 0;
    }

    private int buscarCapacidadDeBoletos(Estacion estacion) {
        NodoEstacion nodoActual = this.head;
        if(nodoActual== null){
            return 0;
        }
        while (nodoActual != null) {
            if (nodoActual.esIgual(estacion)) {
                return nodoActual.getCapacidad();  // La estación ya existe en algún nodo
            }
            nodoActual = nodoActual.getSiguienteNodo();
        }
        return 0;
    }

    public void actualizarDatos(double valorCobrar, Estacion estacion) {
        NodoEstacion nodoAux = head;
        while (nodoAux != null) {
            if (nodoAux.esIgual(estacion)) {
                nodoAux.actualizarDatoDeEstacion(valorCobrar);
                return;
            }
            nodoAux = nodoAux.getSiguienteNodo();
        }
    }

    @Override
    public String toString() {
        return "ListaEnlazadaEstaciones{" +
                "head=" + head +
                '}';
    }

    public void recorrer(FileWriter escritor) throws IOException {
        NodoEstacion nodoAux = this.head;
        while(nodoAux != null){
            escritor.write(nodoAux.getInfoEstacion() + "\n");
            nodoAux = nodoAux.getSiguienteNodo();
        }
        escritor.close();
    }
}
