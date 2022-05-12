package entities;

import utils.Ordenable;

public class Auto implements Ordenable{
	
	private int tamañoBaul;
	
	
	public int getTamañoBaul() {
		return tamañoBaul;
	}


	public void setTamañoBaul(int tamañoBaul) {
		this.tamañoBaul = tamañoBaul;
	}


	public int compare(Object auto2) {
		
		return ((Auto)auto2).getTamañoBaul()-this.getTamañoBaul();
		//devuelve positivo si auto2 (el de parametro)tiene el baul mas grande
		// devuelve 0 si son iguales
		//devuelve negativo si el auto que llama al compare tiene el baul mas grande seria el this.
		
	}
	@Override	
	public String toString() {
		return "baul::" + tamañoBaul;
	}
	
	
}
