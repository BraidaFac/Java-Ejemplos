package entidades;
// extends es para subclases. Es decir Aluumno hereda de Persona.
public class Alumno extends Persona  {
	private int legajo;
	
	
		public int getLegajo() {
		return legajo;
	}


	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}


		public Alumno() {
				this.setLegajo(12345);					
						}
		public Alumno(int legajo, int dni, String nombre, String apellido)
		{
			super(dni, nombre, apellido);
			this.setLegajo(legajo);			
		}
		@Override
		public String getDetalle(boolean mostrarDatosSencible) {
			return super.getDetalle(mostrarDatosSencible) + "legajo: "+ this.getLegajo();
			
		}
}