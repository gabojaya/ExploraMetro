package logica;

public enum Estacion {
    
    QUITUMBE(202301, 35, 0),
    MORANVALVERDE(202302, 35, 0),
    SOLANDA(202303, 35, 0),
    CARDENALDELATORRE(202304, 35, 0),
    RECREO(202305, 35, 0),
    MAGDALENA(202306, 35, 0),
    SANFRANCISCO(202307, 35, 0),
    ALADEMA(202308, 35, 0),
    EJIDO(202309, 35, 0),
    UNIVERSIDADCENTRAL(202310, 35, 0),
    PRADERA(202311, 35, 0),
    CAROLINA(202312, 35, 0),
    IÑAQUITO(202313, 35, 0),
    JIPIJAPA(202314, 35, 0),
    LABRADOR(202315, 35, 0);

    private int NUMEROBOLETOSENESTACION = 35;
    private int numeroDeEstación;
    private int numeroDeBoletosDisponibles;
    private int saldo;

    Estacion(int numeroDeEstación, int numeroDeBoletosDisponibles, int saldo) {
        this.numeroDeEstación = numeroDeEstación;
        this.numeroDeBoletosDisponibles = numeroDeBoletosDisponibles;
        this.saldo = saldo;
    }

    public int getBoletos() {
        return numeroDeBoletosDisponibles;
    }

    public void actualizarDatos(double valorCobrar) {
        this.numeroDeBoletosDisponibles--;
        this.saldo += valorCobrar;

    }

    public int getNumeroEstacion() {
        return this.numeroDeEstación;
    }

    public int getConcurrencia() {
        return NUMEROBOLETOSENESTACION - this.numeroDeBoletosDisponibles;
    }
}
