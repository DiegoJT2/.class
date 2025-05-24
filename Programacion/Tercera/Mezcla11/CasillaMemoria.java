package Tercera.Mezcla11;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CasillaMemoria implements ActionListener {
    private int numero;
    private Button boton;
    private MemoriaNumerica juego;
    private boolean activa = true;

    public CasillaMemoria(int numero, MemoriaNumerica juego) {
        this.numero = numero;
        this.juego = juego;
        boton = new Button("?");
        boton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        juego.casillaSeleccionada(this);
    }

    public void mostrarNumero() {
        boton.setLabel("" + numero);
    }

    public void ocultarNumero() {
        boton.setLabel("?");
    }

    public void deshabilitar() {
        boton.setEnabled(false);
        activa = false;
    }

    public void habilitar() {
        boton.setEnabled(true);
        activa = true;
    }

    public boolean estaActiva() {
        return activa;
    }

    public int getNumero() {
        return numero;
    }

    public Button getButton() {
        return boton;
    }
}