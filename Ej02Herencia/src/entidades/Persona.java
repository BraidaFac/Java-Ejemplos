package entidades;

public class Persona {
	 private	int dni;
	 private	String apellido;
	 private	String nombre;
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Persona() //constructor por defecto sin parametros.
	{
		this(0,"nadie", "sabe");
		}
	public Persona(int dni, String apellido, String nombre)//constructor con parametros. es muy immportante para al instanciar un objeto cargarle los campos de la clase.
	{
		this.setDni(dni);
		this.setApellido(apellido);
		this.setNombre(nombre);// el this sse usa paraa indicar q es un metodo de instancia. si no lo ponemos no pasa nada.
	}
	public String getDetalle() {
		return this.getDetalle(false);
	}
	public String getDetalle (boolean mostrarDatosSencible) {
		String detalle = "Persona - ";
		if (mostrarDatosSencible) {
			detalle+=this.getDni()+": ";
		}
		detalle += this.getApellido() +" "+ this.getNombre() ;
		return detalle;
	}
	//tener dos metodos que se llaman iguales, pero con uno sin parametro y otro con, o con distintos parametros se llama metodo sobrecargado. o sobrecarga.
}
