package logica;

import estructuraDeDato.TablaHash;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SimuladorConcurrencia extends Servicio{
    
    private String nombreDeBaseDeDatos;
    private TablaHash tablaEstaciones;
    
    public SimuladorConcurrencia(String nombreDeBaseDeDatos){
        this.nombreDeBaseDeDatos = nombreDeBaseDeDatos;
        cargarDatosALogica();
    }

    private void cargarDatosALogica(){
        try {
            InputStream inputStream = getClass().getResourceAsStream(nombreDeBaseDeDatos);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            ArrayList<String> filasDelArchivo = new ArrayList<>();
            String linea;
            do{
                linea = bufferedReader.readLine();
                if(linea != null){
                    filasDelArchivo.add(linea);
                }
            }while(linea != null);
            crearTablaHash(filasDelArchivo);

        }catch (IOException exception){
            throw new RuntimeException(exception);
        }

    }

    private void crearTablaHash(ArrayList<String> filasDelArchivo) {
        try {
            this.tablaEstaciones = new TablaHash();
            int rangoDeEstaciones = filasDelArchivo.size();
            for (int i = 0; i < rangoDeEstaciones ; i++) {
                String[] datos = filasDelArchivo.get(i).split("-");
                int referenciaEstacion = Integer.parseInt(datos[0]);
                int numeroDePersona = Integer.parseInt(datos[1]);
                if(!estanIngresados(referenciaEstacion)){
                    tablaEstaciones.agregarATabla(referenciaEstacion, numeroDePersona);
                    continue;
                }
                incrementeLosUsuariosenEstacion(referenciaEstacion, numeroDePersona);
            }
        }catch (NullPointerException exception){
            throw new RuntimeException(exception);
        }
    }

    private void incrementeLosUsuariosenEstacion(int numeroEstacion, int numeroDePersona) {
        int estadoBusqueda = this.tablaEstaciones.seEncuentraEnTabla(numeroEstacion);
        if(estadoBusqueda == -1){
            return;
        }
        this.tablaEstaciones.incrementarDatos(numeroEstacion, numeroDePersona);
    }

    private boolean estanIngresados(int numeroEstacion) {
        return this.tablaEstaciones.seEncuentraEnTabla(numeroEstacion) == 1;
    }

    @Override
    public void iniciar() {
        System.out.println(tablaEstaciones);
        System.out.println(tablaEstaciones.getValores());
        
    }

    public String getNumeroDePersonas(int clave) {
        int keyEnHashMap = (clave % tablaEstaciones.getTamaño())+ 1;
                System.out.println(tablaEstaciones.getValores());

        return tablaEstaciones.obtenerValor(keyEnHashMap);
    }
}
