package estructuraDeDato;

import logica.Estacion;

public class NodoEstacion {
    private NodoEstacion nodo;
    private Estacion estacion;

    public NodoEstacion(){
        this.nodo = null;
        this.estacion = null;
    }
    public NodoEstacion(Estacion estacion) {
        this.nodo = null;
        this.estacion = estacion;
    }


    public NodoEstacion getSiguienteNodo() {
        return nodo;
    }

    public void setSiguienteNodo(NodoEstacion nodoAux) {
        this.nodo = nodoAux;
    }

    public boolean esIgual(Estacion estacion) {
        return estacion.equals(estacion);
    }

    public int getCapacidad() {
        return estacion.getBoletos();
    }

    public void actualizarDatoDeEstacion(double valorCobrar) {
        estacion.actualizarDatos(valorCobrar);
    }

    public String getInfoEstacion() {
        return estacion.getNumeroEstacion() + "-" + estacion.getConcurrencia();
    }
}
