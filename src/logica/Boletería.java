package logica;

import Ventanas.*;
import estructuraDeDato.Cola;
import estructuraDeDato.ListaEnlazadaEstaciones;
import java.util.ArrayList;

public class Boletería extends Servicio {
    
    public static final double PRECIO_VOLETO = 0.40;
    public static final double PRECIO_DESCUENTO = 0.25;
    private Cola colaUsuarios;
    private ListaEnlazadaEstaciones estaciones;
    private ArchivoManager archivo;
    private int numeroDeUsuarios;
    private int numeroVentanas;
    private ArrayList<InterfazSeleccionDeTickets> datosInterfacesTickets;

    public Boletería() {
        this.numeroVentanas = 0;
        this.numeroDeUsuarios = 0;
        this.datosInterfacesTickets = new ArrayList();
        this.estaciones = new ListaEnlazadaEstaciones();
        this.colaUsuarios = new Cola(20);

    }

    public void ingresarDatosUsuario(int numero) {
        if (numeroVentanas < numero) {
            InterfazSeleccionDeTickets ticket = new InterfazSeleccionDeTickets(this);
            ticket.setVisible(true);
        }
        
    }

    public void guardarDatos(String edadSeleccionada, String estacionSeleccionada) {
        Estacion estacionUser = Estacion.valueOf(estacionSeleccionada);
        int edad = obtenerEdad(edadSeleccionada);
        Persona persona = new Persona(edad , estacionUser);
        this.colaUsuarios.encolar(persona);
                System.out.print(colaUsuarios);

        numeroVentanas++;
    }

    @Override
    public void iniciar() {
        Persona persona = colaUsuarios.atender();
        if (persona != null) {
            this.estaciones.insertar(persona.getEstacion());
            generarBoleto(persona);
            System.out.println(colaUsuarios);
        }
        this.archivo = new ArchivoManager(estaciones);
        System.out.println(colaUsuarios);
    }

    private void generarBoleto(Persona persona) {
        if (!estaciones.existeCapacidadEnLaEstacion(persona.getEstacion())) {
            System.out.println("No hay boletos disponibles en la estación");
            return;
        }
        double valorCobrar = calcularCobro(persona);
        estaciones.actualizarDatos(valorCobrar, persona.getEstacion());
        imprimirBoleto(valorCobrar, persona);
    }

    private void imprimirBoleto(double valorCobrar, Persona persona) {
        InterfazBoleto boleto = new InterfazBoleto(valorCobrar,persona);
        boleto.setVisible(true);
    }

    private double calcularCobro(Persona persona) {
        return persona.esAptoParaDescuento() ? PRECIO_DESCUENTO : PRECIO_VOLETO;
    }

    public void agregarNumeroDePersonas(String textoIngresado) {
        int numeroPersona = Integer.parseInt(textoIngresado);
    }

    private boolean cambiarEstadoDeAtencion(boolean estadoAtencion) {
        System.out.println("DESEA ATENDER A LA OTRA PERSONA");
        String respuesta = "si";
        return respuesta.equals("si");
    }

    public void setNumeroDeUsuarios(int numeroDeUsuarios) {
        this.numeroDeUsuarios = numeroDeUsuarios;
    }

    private int obtenerEdad(String edadSeleccionada) {
        switch (edadSeleccionada) {
            case "Niño":
                return 12;
            case "Adulto":
                return 25;
            case "Estudiante":
                return 12;
            case "Adulto Mayor":
                return 70;
            default:
                return 15;
        }

    }
}
