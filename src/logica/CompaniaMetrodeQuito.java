package logica;

public class CompaniaMetrodeQuito {

    private Servicio[] servicios;

    public CompaniaMetrodeQuito(Servicio boleteria, Servicio concurrencia) {
        this.servicios = new Servicio[]{boleteria, concurrencia};
    }
    
    public void iniciarServicio(int indiceServicio) {
        servicios[indiceServicio-1].iniciar();
    }

    public Servicio getBoleteria() {
        return this.servicios[0];
    }
    
    public Servicio getSimuladorConcurrencia(){
        return this.servicios[1];
    }
}
