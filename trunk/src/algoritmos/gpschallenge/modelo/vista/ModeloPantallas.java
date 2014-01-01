package algoritmos.gpschallenge.modelo.vista;

import algoritmos.gpschallenge.control.ControladorVistaMapa;
import algoritmos.gpschallenge.modelo.juego.ModeloJuego;
import algoritmos.gpschallenge.vista.pantallas.*;

public class ModeloPantallas {

        private PantallaGPSChallenge ventanaActiva;
        String nombreJugador;  //se utiliza como referencia r�pida para las pantallas donde se muestra el nombre.
        
        public ModeloPantallas(){
                this.ventanaActiva = PantallaBienvenida.getInstance();       
        }

        public void setNombreJugador(String nombre) {
                this.nombreJugador = nombre;
        }
        
        public String getNombreJugador() {
                return this.nombreJugador;
        }
        
        public void abrirPantallaJugadorExistente(ModeloJuego modelo) {
                this.ventanaActiva.dispose();
                this.ventanaActiva = new PantallaJugadorExistente(modelo);
                this.ventanaActiva.setVisible(true);
        }

        public void abrirPantallaJugadorNuevo() {
        	this.ventanaActiva.dispose();
        	this.ventanaActiva = PantallaJugadorNuevo.getInstance();
        	this.ventanaActiva.setVisible(true);
        }

        public void abrirPantallaBienvenida() {
        	this.ventanaActiva.dispose();
        	this.ventanaActiva = PantallaBienvenida.getInstance();
        	this.ventanaActiva.setVisible(true);
        }

        public void abrirPantallaOpciones() {
        	this.ventanaActiva.dispose();
        	this.ventanaActiva = PantallaOpciones.getInstance();
        	this.ventanaActiva.setFieldNombre(nombreJugador);
        	this.ventanaActiva.setVisible(true);
        }

        public void abrirPantallaNuevaPartida() {
        	this.ventanaActiva.dispose();
        	this.ventanaActiva = PantallaNuevaPartida.getInstance();
        	this.ventanaActiva.setFieldNombre(nombreJugador);
        	this.ventanaActiva.setVisible(true);
        }

        public void abrirPantallaPuntajes(ModeloJuego modelo) {
        	this.ventanaActiva.dispose();
        	this.ventanaActiva = new PantallaPuntajes(modelo);
        	this.ventanaActiva.setFieldNombre(nombreJugador);
        	this.ventanaActiva.setVisible(true);
        }

        public void abrirPantallaMapa(ModeloJuego modelo, ControladorVistaMapa controlador, String imagenMapa, String imagenVehiculo) {
        	this.ventanaActiva.dispose();
                PantallaMapa pantallaMapa = new PantallaMapa(modelo, controlador, imagenMapa, imagenVehiculo);
                pantallaMapa.setVisible(true);
        }
                
        public void setVentanaActiva(PantallaGPSChallenge pantalla){
        	this.ventanaActiva = pantalla;
        }

        public void abrirPantallaGanador() {
        	this.ventanaActiva.dispose();
        	this.ventanaActiva = PantallaGanador.getInstance();
        	this.ventanaActiva.setFieldNombre(nombreJugador);
        	this.ventanaActiva.setVisible(true);
        }

        public void abrirPantallaPerdedor() {
        	this.ventanaActiva.dispose();
        	this.ventanaActiva = PantallaPerdedor.getInstance();
        	this.ventanaActiva.setFieldNombre(nombreJugador);
        	this.ventanaActiva.setVisible(true);
        }
}