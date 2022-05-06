package entidades;

public abstract class Persona {
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private float sueldoBase;
	
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	public Persona(int dni, String nombre, String apellido, String email)
	{
		this.setDni(dni);
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setEmail(email);
	}

	
	
	public Persona(){
		this(0,"Sin datos","Sin datos","Sin datos");
	}
	public Persona(int dni) {
		this.dni= dni;
	}
	
	
	
}
