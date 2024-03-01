package logica;

public class Persona {
    
    private int edad;
    private Estacion estacion;

    public Persona(int edad, Estacion estacion) {
        this.edad = edad;
        this.estacion = estacion;
    }

    public Estacion getEstacion() {
        return estacion;
    }
    
    public int getEdad(){
        return edad;
    }

    public boolean esAptoParaDescuento() {
        return edad < 19 || edad > 64;
    }

    public String obtenerNombreEstacion() {
        int key = estacion.getNumeroEstacion();
        switch(key){
            case 202301:
                return "QUITUMBE";
            case 202302:
                return "MORANVALVERDE";
            case 202303:
                return "SOLANDA";
            case 202304:
                return "CARDENAL DE LA TORRE";
            case 202305:
                return "RECREO";
            case 202306:
                return "MAGDALENA";
            case 202307:
                return "SANFRANCISCO";
            case 202308:
                return "ALAMEDA";
            case 202309:
                return "EJIDO";
            case 202310:
                return "UNIVERSIDAD CENTRAL";
            case 202311:
                return "PRADERA";
            case 202312:
                return "CAROLINA";
            case 202313:
                return "IÑAQUITO";
            case 202314:
                return "JIPIJAPA";
            case 202315:
                return "LABRADOR";
            default:
                return "Estacion no encontrada";
        }
        

    }

}
