package iu;


import entidades.*;// el asterisco hace que busque las clases que estan dentro de entidades. no es bueno usarlo cuando dentro de un packege hay mcuhas clases.


public class Principal {

	public static void main(String[] args) {
		
	Persona p1= new Persona(); 
	p1.setDni(40966748);
	p1.setApellido("Braida");
	p1.setNombre("Facundo");

	System.out.println(p1.getDetalle(true));
	Alumno p2= new Alumno();
	System.out.println("alumno " + p2.getDetalle()  );
	Alumno a2= new Alumno(465, 40953, "franco", "maggi");
	System.out.println("alumno " + a2.getDetalle()  );

	}

}
