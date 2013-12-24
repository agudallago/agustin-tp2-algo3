package algoritmos.gpschallenge.modelo.juego;

import algoritmos.gpschallenge.modelo.direccion.Direccion;
import algoritmos.gpschallenge.modelo.direccion.Este;
import algoritmos.gpschallenge.modelo.direccion.Norte;
import algoritmos.gpschallenge.modelo.direccion.Oeste;
import algoritmos.gpschallenge.modelo.direccion.Sur;
import algoritmos.gpschallenge.modelo.obstaculo.*;
import algoritmos.gpschallenge.modelo.sorpresa.*;


public class GeneradorDeMapas {

	private Esquina [][] mEsquinasMapa;	

	public GeneradorDeMapas(int numeroDeMapa) {
		mEsquinasMapa = new Esquina [15][15];
		this.crearConexionesEnMapa();
		
		switch (numeroDeMapa) {	
			case 1:
				this.generarMapaFacil();
				break;
			case 2:
				this.generarMapaModerado();
				break;
			case 3:
				this.generarMapaDificil();
				break;
		}
	}

	private void crearConexionesEnMapa() {
		
		Direccion norte = new Norte();
		Direccion sur = new Sur();
		Direccion este = new Este();
		Direccion oeste = new Oeste();
		
		//Conexiones en la parte interna del mapa
		
		for (int fila = 1; fila < 14; fila++)
		{
			for (int col=1; col<14; col++)
			{
				this.mEsquinasMapa[fila][col].setEsquinaAl(norte, this.mEsquinasMapa[fila-1][col]);
				this.mEsquinasMapa[fila][col].setEsquinaAl(sur, this.mEsquinasMapa[fila+1][col]);
				this.mEsquinasMapa[fila][col].setEsquinaAl(este, this.mEsquinasMapa[fila][col+1]);
				this.mEsquinasMapa[fila][col].setEsquinaAl(oeste, this.mEsquinasMapa[fila][col-1]);
				
			}
		}
	
		//Conexion de la primera fila
		
		this.mEsquinasMapa[0][0].setEsquinaAl(sur, this.mEsquinasMapa[1][0]);
		this.mEsquinasMapa[0][0].setEsquinaAl(este, this.mEsquinasMapa[0][1]);
		
		for (int col = 1; col < 14; col++)
		{
			
				this.mEsquinasMapa[0][col].setEsquinaAl(sur, this.mEsquinasMapa[1][col]);
				this.mEsquinasMapa[0][col].setEsquinaAl(este, this.mEsquinasMapa[0][col+1]);
				this.mEsquinasMapa[0][col].setEsquinaAl(oeste, this.mEsquinasMapa[0][col-1]);
						
		}
		
		this.mEsquinasMapa[0][14].setEsquinaAl(sur, this.mEsquinasMapa[1][14]);
		this.mEsquinasMapa[0][14].setEsquinaAl(oeste, this.mEsquinasMapa[0][13]);
		
		
		//Conexion de la ultima fila
		
		this.mEsquinasMapa[14][0].setEsquinaAl(norte, this.mEsquinasMapa[13][0]);
		this.mEsquinasMapa[14][0].setEsquinaAl(este, this.mEsquinasMapa[14][1]);
		
		for (int col = 1; col < 14; col++)
		{
			
				this.mEsquinasMapa[14][col].setEsquinaAl(norte, this.mEsquinasMapa[13][col]);
				this.mEsquinasMapa[14][col].setEsquinaAl(este, this.mEsquinasMapa[14][col+1]);
				this.mEsquinasMapa[14][col].setEsquinaAl(oeste, this.mEsquinasMapa[14][col-1]);
						
		}
		
		this.mEsquinasMapa[14][14].setEsquinaAl(norte, this.mEsquinasMapa[13][14]);
		this.mEsquinasMapa[14][14].setEsquinaAl(oeste, this.mEsquinasMapa[14][13]);
		
		
		//Conexion de la primera columna
		
		for (int fila = 1; fila < 14; fila++)
		{
			
				this.mEsquinasMapa[fila][0].setEsquinaAl(norte, this.mEsquinasMapa[fila-1][0]);
				this.mEsquinasMapa[fila][0].setEsquinaAl(sur, this.mEsquinasMapa[fila+1][0]);
				this.mEsquinasMapa[fila][0].setEsquinaAl(este, this.mEsquinasMapa[fila][1]);
						
		}
		
		
		//Conexion de la ultima columna
		
		for (int fila = 1; fila < 14; fila++)
		{
			
				this.mEsquinasMapa[fila][14].setEsquinaAl(norte, this.mEsquinasMapa[fila-1][14]);
				this.mEsquinasMapa[fila][14].setEsquinaAl(sur, this.mEsquinasMapa[fila+1][14]);
				this.mEsquinasMapa[fila][14].setEsquinaAl(oeste, this.mEsquinasMapa[fila][13]);
						
		}
		
	}

	private void generarMapaFacil() {

		//CREACION DE LAS SORPRESAS, LOS OBSTACULOS Y LA META
		
		ControlPolicial controlPolicial = new ControlPolicial();
		Piquete piquete = new Piquete();
		Pozo pozo = new Pozo();
			
		SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
		SorpresaCambioVehiculo sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
			
		Meta meta = new Meta();
				
				
		//ASOCIACION DE ELEMENTOS CON LAS ESQUINAS DEL MAPA
						
		//8 Pozos 
		this.mEsquinasMapa[0][1].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[3][1].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[6][5].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[7][0].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[7][8].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[8][3].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[9][9].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[10][3].addElementoEnEsquina(pozo);
				
		//8 Piquetes 
		this.mEsquinasMapa[1][10].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[2][3].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[6][6].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[7][11].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[8][1].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[9][14].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[10][4].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[12][9].addElementoEnEsquina(piquete);
				
		//8 Controles Policiales 
		this.mEsquinasMapa[3][12].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[4][7].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[5][3].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[6][9].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[9][6].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[10][13].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[13][2].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[13][10].addElementoEnEsquina(controlPolicial);
			
		//10 Sorpresas Favorables
		this.mEsquinasMapa[0][7].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[0][14].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[4][9].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[5][5].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[5][11].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[10][2].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[11][0].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[13][4].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[14][8].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[14][12].addElementoEnEsquina(sorpresaFavorable);
				
		//8 Sorpresas Desfavorables
		this.mEsquinasMapa[3][5].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[4][2].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[4][14].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[6][2].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[9][11].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[11][7].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[12][1].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[12][14].addElementoEnEsquina(sorpresaDesfavorable);
		
		//8 Sorpresas Cambio Vehiculo
		this.mEsquinasMapa[1][1].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[2][6].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[3][11].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[5][1].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[6][4].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[6][13].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[12][12].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[13][5].addElementoEnEsquina(sorpresaCambioVehiculo);
		
		//Ubicación de la meta		
			
		this.mEsquinasMapa[10][14].addElementoEnEsquina(meta);
		
	}
	
	private void generarMapaModerado() {
				
		//CREACION DE LAS SORPRESAS, LOS OBSTACULOS Y LA META
	
		ControlPolicial controlPolicial = new ControlPolicial();
		Piquete piquete = new Piquete();
		Pozo pozo = new Pozo();
		
		SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
		SorpresaCambioVehiculo sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
		
		Meta meta = new Meta();
			
				
		//ASOCIACION DE ELEMENTOS CON LAS ESQUINAS DEL MAPA
						
		//10 Pozos 
		this.mEsquinasMapa[0][5].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[1][3].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[7][5].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[7][12].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[7][13].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[8][9].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[9][0].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[11][1].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[12][11].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[13][1].addElementoEnEsquina(pozo);
				
		//10 Piquetes 
		this.mEsquinasMapa[2][11].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[3][3].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[4][6].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[5][5].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[6][8].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[6][11].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[8][3].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[9][14].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[10][7].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[13][3].addElementoEnEsquina(piquete);
				
		//10 Controles Policiales 
		this.mEsquinasMapa[1][2].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[1][7].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[3][14].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[4][1].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[4][9].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[6][0].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[6][13].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[10][11].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[12][9].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[13][14].addElementoEnEsquina(controlPolicial);
			
		//10 Sorpresas Favorables
		this.mEsquinasMapa[0][3].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[1][13].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[2][8].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[5][7].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[5][12].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[8][7].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[11][0].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[11][8].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[12][12].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[14][9].addElementoEnEsquina(sorpresaFavorable);
				
		//10 Sorpresas Desfavorables
		this.mEsquinasMapa[2][9].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[3][5].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[4][13].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[5][10].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[8][1].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[9][10].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[10][2].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[10][13].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[12][6].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[13][4].addElementoEnEsquina(sorpresaDesfavorable);
								
		//10 Sorpresas Cambio Vehiculo
		this.mEsquinasMapa[0][10].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[2][1].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[4][8].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[6][3].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[9][6].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[9][13].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[11][3].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[13][13].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[14][7].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[14][11].addElementoEnEsquina(sorpresaCambioVehiculo);
		
			
		//Ubicación de la meta		
			
		this.mEsquinasMapa[6][14].addElementoEnEsquina(meta);
		
	}

	
	private void generarMapaDificil() {
		
		//CREACION DE LAS SORPRESAS, LOS OBSTACULOS Y LA META
		
		ControlPolicial controlPolicial = new ControlPolicial();
		Piquete piquete = new Piquete();
		Pozo pozo = new Pozo();
		
		SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
		SorpresaCambioVehiculo sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
		
		Meta meta = new Meta();
		
		
		//ASOCIACION DE ELEMENTOS CON LAS ESQUINAS DEL MAPA
				
		//15 Pozos 
		this.mEsquinasMapa[0][1].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[1][13].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[2][7].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[3][0].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[3][3].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[3][9].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[4][12].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[5][10].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[6][1].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[9][5].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[9][6].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[11][5].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[11][14].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[12][8].addElementoEnEsquina(pozo);
		this.mEsquinasMapa[13][0].addElementoEnEsquina(pozo);
		
		//17 Piquetes 
		this.mEsquinasMapa[0][13].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[1][10].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[2][4].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[2][12].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[5][5].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[6][4].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[6][14].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[7][11].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[8][8].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[9][2].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[9][12].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[11][13].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[13][1].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[13][7].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[13][11].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[14][3].addElementoEnEsquina(piquete);
		this.mEsquinasMapa[14][13].addElementoEnEsquina(piquete);
		
		
		//17 Controles Policiales 
		this.mEsquinasMapa[0][7].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[0][11].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[1][1].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[3][14].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[4][2].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[5][3].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[5][8].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[6][12].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[8][1].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[8][4].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[8][10].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[8][13].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[11][8].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[11][11].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[13][14].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[14][7].addElementoEnEsquina(controlPolicial);
		this.mEsquinasMapa[14][10].addElementoEnEsquina(controlPolicial);
				
		
		//12 Sorpresas Favorables
		this.mEsquinasMapa[1][0].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[1][9].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[2][6].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[4][4].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[4][10].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[6][6].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[10][9].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[12][3].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[12][6].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[12][9].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[14][8].addElementoEnEsquina(sorpresaFavorable);
		this.mEsquinasMapa[14][11].addElementoEnEsquina(sorpresaFavorable);
		
		
		//15 Sorpresas Desfavorables
		this.mEsquinasMapa[0][5].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[1][3].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[2][10].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[5][13].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[6][7].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[7][3].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[7][9].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[8][3].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[9][0].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[9][8].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[9][14].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[10][6].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[10][12].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[12][12].addElementoEnEsquina(sorpresaDesfavorable);
		this.mEsquinasMapa[14][5].addElementoEnEsquina(sorpresaDesfavorable);
		
				
		//13 Sorpresas Cambio Vehiculo
		this.mEsquinasMapa[0][4].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[2][3].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[3][3].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[3][7].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[4][1].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[6][9].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[7][0].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[8][6].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[9][11].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[10][4].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[11][0].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[11][2].addElementoEnEsquina(sorpresaCambioVehiculo);
		this.mEsquinasMapa[13][3].addElementoEnEsquina(sorpresaCambioVehiculo);
		
		
		//Ubicación de la meta		
	
		this.mEsquinasMapa[14][14].addElementoEnEsquina(meta);
						
	}
	
}
