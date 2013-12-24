package algoritmos.gpschallenge.modelo.juego;

import algoritmos.gpschallenge.modelo.obstaculo.*;
import algoritmos.gpschallenge.modelo.sorpresa.*;


	public class GeneradorDeMapas {

	//private Esquina [][] mEsquinasMapa;	
	

	public Mapa generarMapaFacil() {

		//CREACION DEL MAPA
		
		Mapa mapaFacil = new Mapa();
		
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
		mapaFacil.mEsquinasMapa[0][1].addElementoEnEsquina(pozo);
		mapaFacil.mEsquinasMapa[3][1].addElementoEnEsquina(pozo);
		mapaFacil.mEsquinasMapa[6][5].addElementoEnEsquina(pozo);
		mapaFacil.mEsquinasMapa[7][0].addElementoEnEsquina(pozo);
		mapaFacil.mEsquinasMapa[7][8].addElementoEnEsquina(pozo);
		mapaFacil.mEsquinasMapa[8][3].addElementoEnEsquina(pozo);
		mapaFacil.mEsquinasMapa[9][9].addElementoEnEsquina(pozo);
		mapaFacil.mEsquinasMapa[10][3].addElementoEnEsquina(pozo);
				
		//8 Piquetes 
		mapaFacil.mEsquinasMapa[1][10].addElementoEnEsquina(piquete);
		mapaFacil.mEsquinasMapa[2][3].addElementoEnEsquina(piquete);
		mapaFacil.mEsquinasMapa[6][6].addElementoEnEsquina(piquete);
		mapaFacil.mEsquinasMapa[7][11].addElementoEnEsquina(piquete);
		mapaFacil.mEsquinasMapa[8][1].addElementoEnEsquina(piquete);
		mapaFacil.mEsquinasMapa[9][14].addElementoEnEsquina(piquete);
		mapaFacil.mEsquinasMapa[10][4].addElementoEnEsquina(piquete);
		mapaFacil.mEsquinasMapa[12][9].addElementoEnEsquina(piquete);
				
		//8 Controles Policiales 
		mapaFacil.mEsquinasMapa[3][12].addElementoEnEsquina(controlPolicial);
		mapaFacil.mEsquinasMapa[4][7].addElementoEnEsquina(controlPolicial);
		mapaFacil.mEsquinasMapa[5][3].addElementoEnEsquina(controlPolicial);
		mapaFacil.mEsquinasMapa[6][9].addElementoEnEsquina(controlPolicial);
		mapaFacil.mEsquinasMapa[9][6].addElementoEnEsquina(controlPolicial);
		mapaFacil.mEsquinasMapa[10][13].addElementoEnEsquina(controlPolicial);
		mapaFacil.mEsquinasMapa[13][2].addElementoEnEsquina(controlPolicial);
		mapaFacil.mEsquinasMapa[13][10].addElementoEnEsquina(controlPolicial);
			
		//10 Sorpresas Favorables
		mapaFacil.mEsquinasMapa[0][7].addElementoEnEsquina(sorpresaFavorable);
		mapaFacil.mEsquinasMapa[0][14].addElementoEnEsquina(sorpresaFavorable);
		mapaFacil.mEsquinasMapa[4][9].addElementoEnEsquina(sorpresaFavorable);
		mapaFacil.mEsquinasMapa[5][5].addElementoEnEsquina(sorpresaFavorable);
		mapaFacil.mEsquinasMapa[5][11].addElementoEnEsquina(sorpresaFavorable);
		mapaFacil.mEsquinasMapa[10][2].addElementoEnEsquina(sorpresaFavorable);
		mapaFacil.mEsquinasMapa[11][0].addElementoEnEsquina(sorpresaFavorable);
		mapaFacil.mEsquinasMapa[13][4].addElementoEnEsquina(sorpresaFavorable);
		mapaFacil.mEsquinasMapa[14][8].addElementoEnEsquina(sorpresaFavorable);
		mapaFacil.mEsquinasMapa[14][12].addElementoEnEsquina(sorpresaFavorable);
				
		//8 Sorpresas Desfavorables
		mapaFacil.mEsquinasMapa[3][5].addElementoEnEsquina(sorpresaDesfavorable);
		mapaFacil.mEsquinasMapa[4][2].addElementoEnEsquina(sorpresaDesfavorable);
		mapaFacil.mEsquinasMapa[4][14].addElementoEnEsquina(sorpresaDesfavorable);
		mapaFacil.mEsquinasMapa[6][2].addElementoEnEsquina(sorpresaDesfavorable);
		mapaFacil.mEsquinasMapa[9][11].addElementoEnEsquina(sorpresaDesfavorable);
		mapaFacil.mEsquinasMapa[11][7].addElementoEnEsquina(sorpresaDesfavorable);
		mapaFacil.mEsquinasMapa[12][1].addElementoEnEsquina(sorpresaDesfavorable);
		mapaFacil.mEsquinasMapa[12][14].addElementoEnEsquina(sorpresaDesfavorable);
		
		//8 Sorpresas Cambio Vehiculo
		mapaFacil.mEsquinasMapa[1][1].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaFacil.mEsquinasMapa[2][6].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaFacil.mEsquinasMapa[3][11].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaFacil.mEsquinasMapa[5][1].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaFacil.mEsquinasMapa[6][4].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaFacil.mEsquinasMapa[6][13].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaFacil.mEsquinasMapa[12][12].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaFacil.mEsquinasMapa[13][5].addElementoEnEsquina(sorpresaCambioVehiculo);
		
		//Ubicación de la meta		
			
		mapaFacil.mEsquinasMapa[10][14].addElementoEnEsquina(meta);
		
		
		return mapaFacil;
	}
	
	public Mapa generarMapaModerado() {
			
		//CREACION DEL MAPA
		
		Mapa mapaModerado = new Mapa();
		
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
		mapaModerado.mEsquinasMapa[0][5].addElementoEnEsquina(pozo);
		mapaModerado.mEsquinasMapa[1][3].addElementoEnEsquina(pozo);
		mapaModerado.mEsquinasMapa[7][5].addElementoEnEsquina(pozo);
		mapaModerado.mEsquinasMapa[7][12].addElementoEnEsquina(pozo);
		mapaModerado.mEsquinasMapa[7][13].addElementoEnEsquina(pozo);
		mapaModerado.mEsquinasMapa[8][9].addElementoEnEsquina(pozo);
		mapaModerado.mEsquinasMapa[9][0].addElementoEnEsquina(pozo);
		mapaModerado.mEsquinasMapa[11][1].addElementoEnEsquina(pozo);
		mapaModerado.mEsquinasMapa[12][11].addElementoEnEsquina(pozo);
		mapaModerado.mEsquinasMapa[13][1].addElementoEnEsquina(pozo);
				
		//10 Piquetes 
		mapaModerado.mEsquinasMapa[2][11].addElementoEnEsquina(piquete);
		mapaModerado.mEsquinasMapa[3][3].addElementoEnEsquina(piquete);
		mapaModerado.mEsquinasMapa[4][6].addElementoEnEsquina(piquete);
		mapaModerado.mEsquinasMapa[5][5].addElementoEnEsquina(piquete);
		mapaModerado.mEsquinasMapa[6][8].addElementoEnEsquina(piquete);
		mapaModerado.mEsquinasMapa[6][11].addElementoEnEsquina(piquete);
		mapaModerado.mEsquinasMapa[8][3].addElementoEnEsquina(piquete);
		mapaModerado.mEsquinasMapa[9][14].addElementoEnEsquina(piquete);
		mapaModerado.mEsquinasMapa[10][7].addElementoEnEsquina(piquete);
		mapaModerado.mEsquinasMapa[13][3].addElementoEnEsquina(piquete);
				
		//10 Controles Policiales 
		mapaModerado.mEsquinasMapa[1][2].addElementoEnEsquina(controlPolicial);
		mapaModerado.mEsquinasMapa[1][7].addElementoEnEsquina(controlPolicial);
		mapaModerado.mEsquinasMapa[3][14].addElementoEnEsquina(controlPolicial);
		mapaModerado.mEsquinasMapa[4][1].addElementoEnEsquina(controlPolicial);
		mapaModerado.mEsquinasMapa[4][9].addElementoEnEsquina(controlPolicial);
		mapaModerado.mEsquinasMapa[6][0].addElementoEnEsquina(controlPolicial);
		mapaModerado.mEsquinasMapa[6][13].addElementoEnEsquina(controlPolicial);
		mapaModerado.mEsquinasMapa[10][11].addElementoEnEsquina(controlPolicial);
		mapaModerado.mEsquinasMapa[12][9].addElementoEnEsquina(controlPolicial);
		mapaModerado.mEsquinasMapa[13][14].addElementoEnEsquina(controlPolicial);
			
		//10 Sorpresas Favorables
		mapaModerado.mEsquinasMapa[0][3].addElementoEnEsquina(sorpresaFavorable);
		mapaModerado.mEsquinasMapa[1][13].addElementoEnEsquina(sorpresaFavorable);
		mapaModerado.mEsquinasMapa[2][8].addElementoEnEsquina(sorpresaFavorable);
		mapaModerado.mEsquinasMapa[5][7].addElementoEnEsquina(sorpresaFavorable);
		mapaModerado.mEsquinasMapa[5][12].addElementoEnEsquina(sorpresaFavorable);
		mapaModerado.mEsquinasMapa[8][7].addElementoEnEsquina(sorpresaFavorable);
		mapaModerado.mEsquinasMapa[11][0].addElementoEnEsquina(sorpresaFavorable);
		mapaModerado.mEsquinasMapa[11][8].addElementoEnEsquina(sorpresaFavorable);
		mapaModerado.mEsquinasMapa[12][12].addElementoEnEsquina(sorpresaFavorable);
		mapaModerado.mEsquinasMapa[14][9].addElementoEnEsquina(sorpresaFavorable);
				
		//10 Sorpresas Desfavorables
		mapaModerado.mEsquinasMapa[2][9].addElementoEnEsquina(sorpresaDesfavorable);
		mapaModerado.mEsquinasMapa[3][5].addElementoEnEsquina(sorpresaDesfavorable);
		mapaModerado.mEsquinasMapa[4][13].addElementoEnEsquina(sorpresaDesfavorable);
		mapaModerado.mEsquinasMapa[5][10].addElementoEnEsquina(sorpresaDesfavorable);
		mapaModerado.mEsquinasMapa[8][1].addElementoEnEsquina(sorpresaDesfavorable);
		mapaModerado.mEsquinasMapa[9][10].addElementoEnEsquina(sorpresaDesfavorable);
		mapaModerado.mEsquinasMapa[10][2].addElementoEnEsquina(sorpresaDesfavorable);
		mapaModerado.mEsquinasMapa[10][13].addElementoEnEsquina(sorpresaDesfavorable);
		mapaModerado.mEsquinasMapa[12][6].addElementoEnEsquina(sorpresaDesfavorable);
		mapaModerado.mEsquinasMapa[13][4].addElementoEnEsquina(sorpresaDesfavorable);
								
		//10 Sorpresas Cambio Vehiculo
		mapaModerado.mEsquinasMapa[0][10].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaModerado.mEsquinasMapa[2][1].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaModerado.mEsquinasMapa[4][8].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaModerado.mEsquinasMapa[6][3].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaModerado.mEsquinasMapa[9][6].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaModerado.mEsquinasMapa[9][13].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaModerado.mEsquinasMapa[11][3].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaModerado.mEsquinasMapa[13][13].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaModerado.mEsquinasMapa[14][7].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaModerado.mEsquinasMapa[14][11].addElementoEnEsquina(sorpresaCambioVehiculo);
		
			
		//Ubicación de la meta		
			
		mapaModerado.mEsquinasMapa[6][14].addElementoEnEsquina(meta);
		
		
		return mapaModerado;
	}

	
	public Mapa generarMapaDificil() {
		
		//CREACION DEL MAPA
		
		Mapa mapaDificil = new Mapa();
				
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
		mapaDificil.mEsquinasMapa[0][1].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[1][13].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[2][7].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[3][0].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[3][3].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[3][9].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[4][12].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[5][10].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[6][1].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[9][5].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[9][6].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[11][5].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[11][14].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[12][8].addElementoEnEsquina(pozo);
		mapaDificil.mEsquinasMapa[13][0].addElementoEnEsquina(pozo);
		
		//17 Piquetes 
		mapaDificil.mEsquinasMapa[0][13].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[1][10].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[2][4].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[2][12].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[5][5].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[6][4].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[6][14].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[7][11].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[8][8].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[9][2].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[9][12].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[11][13].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[13][1].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[13][7].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[13][11].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[14][3].addElementoEnEsquina(piquete);
		mapaDificil.mEsquinasMapa[14][13].addElementoEnEsquina(piquete);
		
		
		//17 Controles Policiales 
		mapaDificil.mEsquinasMapa[0][7].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[0][11].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[1][1].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[3][14].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[4][2].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[5][3].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[5][8].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[6][12].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[8][1].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[8][4].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[8][10].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[8][13].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[11][8].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[11][11].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[13][14].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[14][7].addElementoEnEsquina(controlPolicial);
		mapaDificil.mEsquinasMapa[14][10].addElementoEnEsquina(controlPolicial);
				
		
		//12 Sorpresas Favorables
		mapaDificil.mEsquinasMapa[1][0].addElementoEnEsquina(sorpresaFavorable);
		mapaDificil.mEsquinasMapa[1][9].addElementoEnEsquina(sorpresaFavorable);
		mapaDificil.mEsquinasMapa[2][6].addElementoEnEsquina(sorpresaFavorable);
		mapaDificil.mEsquinasMapa[4][4].addElementoEnEsquina(sorpresaFavorable);
		mapaDificil.mEsquinasMapa[4][10].addElementoEnEsquina(sorpresaFavorable);
		mapaDificil.mEsquinasMapa[6][6].addElementoEnEsquina(sorpresaFavorable);
		mapaDificil.mEsquinasMapa[10][9].addElementoEnEsquina(sorpresaFavorable);
		mapaDificil.mEsquinasMapa[12][3].addElementoEnEsquina(sorpresaFavorable);
		mapaDificil.mEsquinasMapa[12][6].addElementoEnEsquina(sorpresaFavorable);
		mapaDificil.mEsquinasMapa[12][9].addElementoEnEsquina(sorpresaFavorable);
		mapaDificil.mEsquinasMapa[14][8].addElementoEnEsquina(sorpresaFavorable);
		mapaDificil.mEsquinasMapa[14][11].addElementoEnEsquina(sorpresaFavorable);
		
		
		//15 Sorpresas Desfavorables
		mapaDificil.mEsquinasMapa[0][5].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[1][3].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[2][10].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[5][13].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[6][7].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[7][3].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[7][9].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[8][3].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[9][0].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[9][8].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[9][14].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[10][6].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[10][12].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[12][12].addElementoEnEsquina(sorpresaDesfavorable);
		mapaDificil.mEsquinasMapa[14][5].addElementoEnEsquina(sorpresaDesfavorable);
		
				
		//13 Sorpresas Cambio Vehiculo
		mapaDificil.mEsquinasMapa[0][4].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[2][3].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[3][3].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[3][7].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[4][1].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[6][9].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[7][0].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[8][6].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[9][11].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[10][4].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[11][0].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[11][2].addElementoEnEsquina(sorpresaCambioVehiculo);
		mapaDificil.mEsquinasMapa[13][3].addElementoEnEsquina(sorpresaCambioVehiculo);
		
		
		//Ubicación de la meta		
	
		mapaDificil.mEsquinasMapa[14][14].addElementoEnEsquina(meta);
		
		
		return mapaDificil;
	}
	
}
