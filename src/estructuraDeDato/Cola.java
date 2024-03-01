package estructuraDeDato;

import logica.Persona;

import java.util.Arrays;

public class Cola {
    private int tamañoMax;
    private int frente;
    private int finale;
    private Persona[] colaDeUsuarios;

    public Cola(int tamañoDeLaCola) {
        this.tamañoMax = tamañoDeLaCola;
        this.frente = -1;
        this.finale = -1;
        this.colaDeUsuarios = new Persona[tamañoMax];
    }

    public void encolar(Persona persona) {
        if (estaLleno()) {
            System.out.println("sobrecargado");
            return;
        }
        if (esPrimerElemento()) {
            frente = 0;
            finale = 0;
            colaDeUsuarios[finale] = persona;
            return;
        }
        finale += 1;
        colaDeUsuarios[finale] = persona;
    }

    private boolean esPrimerElemento() {
        return frente == -1 && finale == -1;
    }

    private boolean estaLleno() {
        return frente == 0 && finale == tamañoMax - 1;
    }

    public Persona atender() {
        if (estaVacio()) {
            System.out.println("Underflow");
            return null;
        }
        Persona personaAtendida = colaDeUsuarios[frente];
        if (esUltimoElemento()) {
            colaDeUsuarios[frente] = null;
            frente = -1;
            finale = -1;
            return personaAtendida;
        }
        modificarCola();
        finale--;
        return personaAtendida;
    }

    private boolean esUltimoElemento() {
        return frente == finale;
    }

    private boolean estaVacio() {
        return frente == -1 && finale == -1;
    }

    private void modificarCola() {
        //add auxiliar value that keeps value of front
        int auxValor = frente;
        //loop that runs until it reaches the rear
        while (auxValor < finale) {
            //extract the next element
            Persona usuario = colaDeUsuarios[auxValor + 1];
            //change the place
            colaDeUsuarios[auxValor + 1] = null;
            //add at empty space
            colaDeUsuarios[auxValor] = usuario;
            auxValor++;
        }
    }

    @Override
    public String toString() {
        return "Cola{" +
                "tamañoMax=" + tamañoMax +
                ", frente=" + frente +
                ", finale=" + finale +
                    ", colaDeUsuarios=" + Arrays.toString(colaDeUsuarios) +
                '}';
    }
}
