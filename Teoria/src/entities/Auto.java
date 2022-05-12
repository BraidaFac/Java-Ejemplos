package entities;

import utils.Ordenable;

public class Auto implements Ordenable{
	
	private int tama�oBaul;
	
	
	public int getTama�oBaul() {
		return tama�oBaul;
	}


	public void setTama�oBaul(int tama�oBaul) {
		this.tama�oBaul = tama�oBaul;
	}


	public int compare(Object auto2) {
		
		return ((Auto)auto2).getTama�oBaul()-this.getTama�oBaul();
		//devuelve positivo si auto2 (el de parametro)tiene el baul mas grande
		// devuelve 0 si son iguales
		//devuelve negativo si el auto que llama al compare tiene el baul mas grande seria el this.
		
	}
	@Override	
	public String toString() {
		return "baul::" + tama�oBaul;
	}
	
	
}
