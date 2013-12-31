package algoritmos.gpschallenge.modelo.vista;

import algoritmos.gpschallenge.control.ControladorVistaMapa;
import algoritmos.gpschallenge.modelo.juego.ModeloJuego;
import algoritmos.gpschallenge.vista.pantallas.*;

public class ModeloPantallas {

        private PantallaGPSChallenge ventanaActiva;
        String nombreJugador;  //se utiliza como referencia rápida para las pantallas donde se muestra el nombre.
        
        public ModeloPantallas(){
                ventanaActiva = PantallaBienvenida.getInstance();       
        }

        public void setNombreJugador(String nombre) {
                this.nombreJugador = nombre;
        }
        
        public String getNombreJugador() {
                return this.nombreJugador;
        }
        
        
        public void abrirPantallaJugadorExistente(ModeloJuego modelo) {
                ventanaActiva.dispose();
                ventanaActiva = new PantallaJugadorExistente(modelo);
                ventanaActiva.setVisible(true);
        }

        public void abrirPantallaJugadorNuevo() {
                ventanaActiva.dispose();
                ventanaActiva = PantallaJugadorNuevo.getInstance();
                ventanaActiva.setVisible(true);
        }

        public void abrirPantallaBienvenida() {
                ventanaActiva.dispose();
                ventanaActiva = PantallaBienvenida.getInstance();
                ventanaActiva.setVisible(true);
        }

        public void abrirPantallaOpciones() {
                ventanaActiva.dispose();
                ventanaActiva = PantallaOpciones.getInstance();
                ventanaActiva.setFieldNombre(nombreJugador);
                ventanaActiva.setVisible(true);
        }

        public void abrirPantallaNuevaPartida() {
                ventanaActiva.dispose();
                ventanaActiva = PantallaNuevaPartida.getInstance();
                ventanaActiva.setFieldNombre(nombreJugador);
                ventanaActiva.setVisible(true);
        }

        public void abrirPantallaPuntajes(ModeloJuego modelo) {
                ventanaActiva.dispose();
                ventanaActiva = new PantallaPuntajes(modelo);
                ventanaActiva.setFieldNombre(nombreJugador);
                ventanaActiva.setVisible(true);
        }

        public void abrirPantallaMapa(ModeloJuego modelo, ControladorVistaMapa controlador, String imagenMapa, String imagenVehiculo) {
                ventanaActiva.dispose();
                PantallaMapa pantallaMapa = new PantallaMapa(modelo, controlador, imagenMapa, imagenVehiculo);
                pantallaMapa.setVisible(true);
        }
                
        public void setVentanaActiva(PantallaGPSChallenge pantalla){
                ventanaActiva = pantalla;
        }

        public void abrirPantallaGanador() {
                ventanaActiva.dispose();
                ventanaActiva = PantallaGanador.getInstance();
                ventanaActiva.setFieldNombre(nombreJugador);
                ventanaActiva.setVisible(true);
        }

        public void abrirPantallaPerdedor() {
                ventanaActiva.dispose();
                ventanaActiva = PantallaPerdedor.getInstance();
                ventanaActiva.setFieldNombre(nombreJugador);
                ventanaActiva.setVisible(true);
        }
        

        
}