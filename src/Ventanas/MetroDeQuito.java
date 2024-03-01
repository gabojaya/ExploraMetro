package Ventanas;
import logica.*;

public class MetroDeQuito {
    public static void main (String[] args){
        CompaniaMetrodeQuito empresaMetropolitana = new CompaniaMetrodeQuito(
                new Boletería(),
                new SimuladorConcurrencia("/baseDeDatos/datosEstaciones.txt")
        );
        
        MenuInicial metroDeQuito = new MenuInicial(empresaMetropolitana);    
    }
    
}
