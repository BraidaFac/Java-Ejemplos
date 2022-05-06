package entidades;

public class Moto extends Producto{
	private int rodado;
	private int cilindrada;
	private String clase;
	
	//CONSTRUCTOR
	
	public Moto(String patente, String marca, String color, int modelo, int rodado, int cilindrada, String clase)
	{
		super(patente,marca,color,modelo);
		this.setCilindrada(cilindrada);
		this.setClase(clase);
		this.setRodado(rodado);
	}
	
	
	//GETTERS AND SETTERS
	public int getRodado() {
		return rodado;
	}
	public void setRodado(int rodado) {
		this.rodado = rodado;
	}
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	
	
	
	
}
