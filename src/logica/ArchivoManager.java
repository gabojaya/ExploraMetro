package logica;

import estructuraDeDato.ListaEnlazadaEstaciones;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoManager {
    
    private ListaEnlazadaEstaciones estaciones;
    private File file;

    public ArchivoManager(ListaEnlazadaEstaciones estaciones) {
        this.estaciones = estaciones;
        crearArchivo();
        leerDatosDeLasEstaciones();
    }

    private void leerDatosDeLasEstaciones() {
        try {
            FileWriter escritura = new FileWriter(this.file);
            this.estaciones.recorrer(escritura);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void crearArchivo() {
        String proyectoPath = System.getProperty("user.dir");
        String archivosGeneradosPath = proyectoPath + "/src/baseDeDatos/";
        String nombreArchivo = "datosEstaciones.txt";
        String rutaCompleta = archivosGeneradosPath + nombreArchivo;

        this.file = new File(rutaCompleta);
        try {
            if(this.file.createNewFile()){
                System.out.println("Archivo creado con exito");
                return;
            }
            System.out.println("Archivo ya creado");
        }catch (IOException exception){
            exception.printStackTrace(System.out);
        }
    }
}
