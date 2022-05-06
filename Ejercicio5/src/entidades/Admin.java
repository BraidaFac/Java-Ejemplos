package entidades;

public class Admin extends Persona {
	private int hsExtra;
	private int hsMEs;
	
	public int getHsExtra() {
		return hsExtra;
	}
	public void setHsExtra(int hsExtra) {
		this.hsExtra = hsExtra;
	}
	public int getHsMEs() {
		return hsMEs;
	}
	public void setHsMEs(int hsMEs) {
		this.hsMEs = hsMEs;
	}

	
	public Admin(int dni, String apellido, String nombre, String email, float sueldoBase, int hsExtra, int hsMes) {
		super(dni, apellido, nombre, email);
		this.setHsExtra(hsExtra);
		this.setHsMEs(hsMes);
		this.setSueldoBase(sueldoBase);
		
	}
	public float sueldoTotal() {
		return  (float) (this.getSueldoBase() * ((this.getHsExtra() * 1.5)+ this.getHsMEs()) / this.getHsMEs()) ;
	}
	@Override
	public String toString() {
		
		return "\n Dni:: "+ this.getDni()+" Apellido:: "+ this.getApellido()+ " "+"Nombre:: "+this.getNombre()+ " "+
		"Email:: "+this.getEmail()+ " "+"SueldoBase::$"+ this.getSueldoBase()+ " "+"Sueldo final:: $"+this.sueldoTotal();
	}
}
