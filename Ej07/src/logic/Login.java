package logic;

import java.security.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;

import data.*;
import entities.*;


public class Login {
	private DataPersona dp;
	private DataRol dr;
	
	public Login() {
		dp=new DataPersona();
		dr= new DataRol();
	}
	
	public Persona validate(Persona p) {

		p.setPassword(convertirSHA256(p.getPassword()));
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
	public Persona newPersona(Persona per)
	{	
		per.setPassword(convertirSHA256(per.getPassword()));
		per= dp.add(per);
		dp.addRoles(per);
		return per;
		
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

	public void deleteRoles(Persona p) {
		
		dp.deleteRoles(p);
		
	}
	public void addRoles(Persona p) {
		dp.addRoles(p);
	}
	public String convertirSHA256(String password) {
		MessageDigest md= null;
		try {
			md= MessageDigest.getInstance("SHA-256");
		}
		catch(NoSuchAlgorithmException e) {
		 	e.printStackTrace();
		}
		
		byte[] hash =md.digest(password.getBytes());
		StringBuffer sb= new StringBuffer();
		
		for(byte b: hash) {
			sb.append(String.format("%02x", b));
		}
	return sb.toString();
	}
}
