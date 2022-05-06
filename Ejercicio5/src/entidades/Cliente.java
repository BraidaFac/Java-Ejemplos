package entidades;

public class Cliente extends Persona	 {
	
	private int numeroCliente;
	private String direccion;
	private int telefono;
	
	
	
	
	public int getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	public Cliente(int dni,String apellido, String nombre,String email, int numeroCliente, String direccion, int telefono)
	{
	super(dni, apellido, nombre, email);
	this.setDireccion(direccion);
	this.setTelefono(telefono);
	this.setNumeroCliente(numeroCliente);
	}
	
	

	
		
}
