package io;

import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entidades.*;
import java.lang.Class;

public class Principal {

	public static void main(String[] args) {
		Persona[] personas= new Persona[20];
		Scanner lector = new Scanner(System.in);
		int tipoPersona;
		for (int i = 0; i<1 ; i++) {
			tipoPersona = Integer.parseInt(JOptionPane.showInputDialog("Cargar Empleados:: 1 para Administrativo o 2 para Vendedor"));
			if (tipoPersona==1) {
				personas[i]= (Persona) new Admin(
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni")) , 
						JOptionPane.showInputDialog("Ingrese nombre"),
						JOptionPane.showInputDialog("Ingrese Apellido"),
						JOptionPane.showInputDialog("Ingrese email"),
						Float.parseFloat(JOptionPane.showInputDialog("Ingrese sueldo Base")),
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese horas extras")),
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese horas por mes")));
				
			}
			if (tipoPersona==2) {
				personas[i]= (Persona) new Vendedor(
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni")) , 
						JOptionPane.showInputDialog("Ingrese nombre"),
						JOptionPane.showInputDialog("Ingrese Apellido"),
						JOptionPane.showInputDialog("Ingrese email"),
						Float.parseFloat(JOptionPane.showInputDialog("Ingrese sueldo Base")),
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese porcentaje Comisión")),
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese total ventas")));
						}
//				else {
//					System.out.println("Ingreso mal caracter");
				
			
				
		}
		for(int i=0; i<1; i ++) {
			
			System.out.print(personas[i].getDni()+ " ");
			System.out.print(personas[i].getApellido()+ " ");
			System.out.print(personas[i].getNombre()+ " ");
			System.out.print(personas[i].getEmail()+ " ");
			System.out.print(personas[i].getSueldoBase()+ " ");
			if (personas[i].getClass().getSimpleName().equals("Admin")) {
			System.out.print(((Admin)personas[i]).sueldoTotal());
		}
			else {
			System.out.print(((Vendedor)personas[i]).sueldoTotal());
			}
	
		lector.close();
		
		

	}
	}
}
