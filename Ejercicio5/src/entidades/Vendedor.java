package entidades;

public class Vendedor extends Persona {
	private int porcentComision;
	private int totalVentas;
	
	
	public int getPorcentComision() {
		return porcentComision;
	}
	public void setPorcentComision(int porcentComision) {
		this.porcentComision = porcentComision;
	}
	public int getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(int totalVentas) {
		this.totalVentas = totalVentas;
	}
	public Vendedor(int dni, String apellido, String nombre, String email, float sueldoBase, int porcentComision, int totalVentas) {
		super(dni, apellido, nombre, email);
		this.setPorcentComision(porcentComision);
		this.setTotalVentas(totalVentas);
		this.setSueldoBase(sueldoBase);
	}
	public float sueldoTotal() {
		return (this.getSueldoBase() + (this.getPorcentComision()*this.getTotalVentas() / 100) );
	}
		
	
	
	@Override
	public String toString() {
	
	return "\n Dni:: "+ this.getDni()+" Apellido:: "+ this.getApellido()+ " "+"Nombre:: "+this.getNombre()+ " "+
	"Email:: "+this.getEmail()+ " "+"SueldoBase::$"+ this.getSueldoBase()+ " "+"Sueldo final:: $"+this.sueldoTotal();
}}
