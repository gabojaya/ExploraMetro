package estructuraDeDato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class TablaHash {
    
    private HashMap<Integer, Integer> tablaValoresYClaves;
    private ArrayList<Integer>[] arregloDeValores;


    public TablaHash() {
        this.tablaValoresYClaves = new HashMap<>();
        arregloDeValores = new ArrayList[20];
    }

    public void agregarATabla(int numeroEstacion, int numeroPersonas) {
        int claveDelValor = tranformacionClavesModulo(numeroEstacion);
        if (!existeColision(claveDelValor)) {
            this.tablaValoresYClaves.put(claveDelValor, numeroEstacion);
            this.arregloDeValores[claveDelValor] = new ArrayList<>();
            this.arregloDeValores[claveDelValor].add(numeroPersonas);
            return;
        }
        //existeColision
        this.arregloDeValores[claveDelValor].add(numeroPersonas); //Encadenamiento

    }

    private int tranformacionClavesModulo(int numeroEstacion) {
        return (numeroEstacion % arregloDeValores.length) + 1;
    }

    private boolean existeColision(int claveDelValor) {
        Set<Integer> clavesEstaciones = this.tablaValoresYClaves.keySet();
        for (Integer clave : clavesEstaciones) {
            if (clave == claveDelValor) {
                return true;
            }
        }
        return false;

    }

    public void incrementarDatos(int numeroEstacionTabla, int numeroDePersona) {
        int clave = tranformacionClavesModulo(numeroEstacionTabla);
        this.arregloDeValores[clave].add(numeroDePersona);
    }

    public int seEncuentraEnTabla(int numeroEstacionReferencia) {
        for (Integer numeroEstacion : this.tablaValoresYClaves.values()) {
            if (numeroEstacion == numeroEstacionReferencia) {
                return 1;

            }
        }
        return -1;
    }

    public String getValores() {
        return Arrays.toString(this.arregloDeValores);
    }

    @Override
    public String toString() {
        return "TablaHash{" +
                "tablaValoresYClaves=" + tablaValoresYClaves +
                ", arregloDeValores=" + Arrays.toString(arregloDeValores) +
                '}';
    }

    public int getTamaño() {
        return this.arregloDeValores.length;
    }

    public String obtenerValor(int keyEnHashMap) {
        return " " + this.arregloDeValores[keyEnHashMap];
    }
}
