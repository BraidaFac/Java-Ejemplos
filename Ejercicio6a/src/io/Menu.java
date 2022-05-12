package io;

import db.*;
import java.util.Scanner;
import entities.*;


	public class Menu {
		Scanner s=null;
		DataProducto dp= new DataProducto();

		public void start() {
			s = new Scanner(System.in);		
			String command;
			do {
				command=getCommand();
				executeCommand(command);
				System.out.println();
				
			}while(!command.equalsIgnoreCase("salir"));
			
			s.close();
		}

		private void executeCommand(String command) {
			switch (command) {
			case "listar":
				System.out.println(dp.getAll());
				break;
			case "encuentra":
				System.out.println(dp.getByID(ingresoID()));	
				break;
			case "nuevo":
				dp.add(nuevoProd());
				break;
			case "editar":
				Product p= dp.getByID(ingresoID());
				System.out.println(p.toString2());
				dp.actualizar(updateProd(p));
				if(actualizo())
					System.out.println("Se actualizo el producto:: " + p.toString2());
				else System.out.println("No se pudo actualizar");
				break;
			case "eliminar":
				dp.delete(ingresoID());
				break;
			default:
				break;
			}
		}

		private String getCommand() {
			System.out.println("Ingrese el comando según la opción que desee realizar");
			System.out.println("listar\t\t listar todos");
			System.out.println("encuentra\t\tbuscar producto por ID"); //solo debe devolver 1
			System.out.println("nuevo\t\tcrear un nuevo producto");
			System.out.println("editar\t\tbusca por tipo y nro de documento y actualiza todos los datos");
			System.out.println("eliminar\t\tborra por tipo y nro de documento");
			System.out.println();
			System.out.print("comando: ");
			return s.nextLine();
			
		}
		
		private Integer ingresoID() {
			System.out.print("ID: ");
			Integer id=(Integer.parseInt(s.nextLine()));
			return id ;
			
		}
		
	public  Product nuevoProd() {
			System.out.println("Ingrese el nombre");
			String	nombre=s.nextLine();
			System.out.println("Ingrese la descripcion del producto");
			String descripcion= s.nextLine();
			System.out.println("Ingrese el stock del producto");
			int stock= Integer.parseInt(s.nextLine());
			System.out.println("Ingrese el precio del producto");
			Double precio =Double.parseDouble(s.nextLine());
			System.out.println("Ingrese 'si' si incluye envio");
			boolean shippingIncluded=s.nextLine().equalsIgnoreCase("si");
				
			System.out.println();
			Product p=new Product();
			return p;
		}
	public  Product updateProd(Product p) {
		System.out.println("Ingrese el nombre");
		p.setName(s.nextLine());
		System.out.println("Ingrese la descripcion del producto");
		p.setDescripcion( s.nextLine());
		System.out.println("Ingrese el stock del producto");
		p.setStock(Integer.parseInt(s.nextLine()));
		System.out.println("Ingrese el precio del producto");
		p.setPrice(Double.parseDouble(s.nextLine()));
		System.out.println("Ingrese 'si' si incluye envio");
		p.setShippingIncluded(s.nextLine().equalsIgnoreCase("si"));
		return p;
	}
	public boolean actualizo() {
		return true;
		
	}
	}
