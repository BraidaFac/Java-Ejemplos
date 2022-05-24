package logic;

import java.util.ArrayList;
import java.util.LinkedList;

import data.*;
import entities.*;
import ui.Menu;

public class Login {
	private DataPersona dp;
	private DataRol dr;
	
	public Login() {
		dp=new DataPersona();
		dr= new DataRol();
	}
	
	public Persona validate(Persona p) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dp.getByUser(p);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}

	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
		
	}
	
	public ArrayList<Persona> getByApellido(Persona p){
		return dp.getByApellido(p);
	}
	public Persona newPersona(Persona per, Rol r)
	{
		return dp.add(per,r);
		
	}
	
	public Rol getRolByDesc(Rol r)
	{
		return dr.getByDesc(r);
	}
	public LinkedList<Rol> getAllRoles ()
	{
		return dr.getAll();
		
	}
	public void edit(Persona p)
	{
		 dp.edit(p);
	}
	public void delete(Persona p) {
		dp.delete(p);
	}
}
