package entidades;

public class Producto {
	
	private String patente;
	private String marca;
	private String color;
	private int modelo;
	
	
	//CONSTRUCTORES
	
	public Producto(String patente, String marca, String color, int modelo)
	{
		this.setPatente(patente);
		this.setModelo(modelo);
		this.setColor(color);
		this.setMarca(marca);
	}
	
	public Producto()
	{
		this("","","",0);
	}
	
	//GETERS AND SETTERS
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getModelo() {
		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

}
