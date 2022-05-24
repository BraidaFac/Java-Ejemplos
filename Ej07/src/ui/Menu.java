package ui;


import java.util.ArrayList;
import java.util.Scanner;

import entities.*;
import logic.Login;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Persona p=login();
		System.out.println("Bienvenido "+p.getNombre()+" "+p.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			System.out.println(find());
			break;
		case "search":
			System.out.println(search());
			break;
		case "new":
			System.out.println(newPersona());
			break;
		case "edit":
			System.out.println("La persona quedó actualizada:: "+ edit());
			break;
		case "delete":
			delete();
			
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando segunn la opción que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("delete\t\tborra por tipo y nro de documento");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private Persona login() {
		Persona p=new Persona();
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("password: ");
		p.setPassword(s.nextLine());
		
		p=ctrlLogin.validate(p);
		
		return p;
		
	}
	
	private Persona find() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		return ctrlLogin.getByDocumento(p);
	}
	private ArrayList<Persona> search() {
		Persona p= new Persona();
		System.out.println("Ingrese Apellido");
		p.setApellido(s.nextLine());
		
		return ctrlLogin.getByApellido(p);
	}
	
	private Persona newPersona() 
	{
		System.out.println("Agregar persona");
		Persona p = new Persona();
		loadDoc(p);
		loadData(p);
		Rol r= loadRol(p);
		
		return ctrlLogin.newPersona(p,r);	
	}
	
	private Persona edit() 
	{	
		Persona p=new Persona();
		p= find();
		System.out.println(p);
		loadData(p);
		ctrlLogin.edit(p);
		return p;
	}
	private void delete() //PREGUNTAR SI ES NECESARIO BUSCAR LA PERSONA EN LA DB
	{
		
		Persona p= new Persona();
		p= find();
		System.out.println("Eliminaras a la persona:: "+ p);
		System.out.println("Desea confirmar=? YES/NO");
		if(s.nextLine().trim().equalsIgnoreCase("YES"))
		ctrlLogin.delete(p);
	}
		

	private void loadData(Persona p) {		
		System.out.println("Ingrese Nombre");
		p.setNombre(s.nextLine());
		System.out.println("Ingrese Apellido");
		p.setApellido(s.nextLine());
		System.out.print("Email: ");
		p.setEmail(s.nextLine());
		System.out.println("Ingrese telefono");
		p.setTel(s.nextLine());
		System.out.println("Esta hablitiado? YES/NO");
		p.setHabilitado(s.nextLine().trim().equalsIgnoreCase("YES"));
		System.out.print("password: ");
		p.setPassword(s.nextLine());
				
	}

	public void loadDoc(Persona p) {
		Documento d= new Documento();
		p.setDocumento(d);
		
		System.out.println("Ingrese tipo documento");
		d.setTipo(s.nextLine());
		System.out.println("Ingrese el numero de documento");
		d.setNro(s.nextLine());
	}
	

	private Rol loadRol(Persona p) 
	{	
		Rol r = new Rol();
		System.out.println(ctrlLogin.getAllRoles());
		System.out.println("Ingrese descripcion del rol");
		r.setDescripcion(s.nextLine());
		r= ctrlLogin.getRolByDesc(r);
		p.addRol(r);
		return r;
			
	}


}
