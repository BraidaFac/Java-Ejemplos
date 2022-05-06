package entidades;

public class Auto extends Producto{
	private int cantPuertas;
	private boolean baul;
	private int caballosFuerza;
	
	//CONSTRUCTOR
	
	public Auto(String patente, String marca, String color, int modelo, int cantPuertas, boolean baul, int caballosFuerza)
	{
		super(patente, marca, color, modelo);
		this.setCantPuertas(cantPuertas);
		this.setCaballosFuerza(caballosFuerza);
		this.setBaul(baul);
		
	}
	//GETTERS AND SETTERS
	public int getCantPuertas() {
		return cantPuertas;
	}
	public void setCantPuertas(int cantPuertas) {
		this.cantPuertas = cantPuertas;
	}
	public boolean isBaul() {
		return baul;
	}
	public void setBaul(boolean baul) {
		this.baul = baul;
	}
	public int getCaballosFuerza() {
		return caballosFuerza;
	}
	public void setCaballosFuerza(int caballosFuerza) {
		this.caballosFuerza = caballosFuerza;
	}
	
	
}
