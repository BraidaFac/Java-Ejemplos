package io;

import db.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entities.*;


	public class Menu2 {
		DataProducto dp= new DataProducto();
		Product p=null;
		public void start() {
			Integer option= -1;
			Object[] comand = {"listar","encuentra","nuevo","editar","eliminar","Salir"};
			
			
			do {
				option= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, comand, comand[0]);
				executeCommand(option);
				
				
			}while (option!=5);
			
		}

		private void executeCommand(Integer option) {
			switch (option) {
			case 0:
				JOptionPane.showMessageDialog(null,"Lista de productos"+dp.getAll());
				break;
			case 1:
				p= dp.getByID(ingresoID());
				if (p != null)
				JOptionPane.showMessageDialog(null, "Encuentra un producto  "+ p.toString2());
				else 
				JOptionPane.showMessageDialog(null,"No se encontro el producto","Alerta",JOptionPane.WARNING_MESSAGE);   
				break;
			case 2:
				p=null;
				 p=dp.add(nuevoProd());
				 if (!(p==null))
				 JOptionPane.showMessageDialog(null,"El producto se cargo con exito \n"+p.toString2());
				 else JOptionPane.showMessageDialog(null,"No se cargo el producto","Alerta",JOptionPane.WARNING_MESSAGE);
				break;
			case 3:
				
				 p= dp.getByID(ingresoID());
				JOptionPane.showMessageDialog(null,"El producto a actualizar es:: \n"+p.toString2());
				dp.actualizar(updateProd(p));
				break;
			case 4:
				dp.delete(ingresoID());
				break;
			default:
				break;
			}
		}

		
		private Integer ingresoID() {
			Integer id=(Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID")));
			return id ;
			
		}
		
	public  Product nuevoProd() {
			Product p=new Product();
			p.setName(JOptionPane.showInputDialog("Ingrese el nombre"));
			p.setDescripcion(JOptionPane.showInputDialog("Ingrese la descripcion"));
			p.setStock( Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto")));
			p.setPrice(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto")));
			Integer op=JOptionPane.showConfirmDialog(null, "¿Incluye envio?");
			p.setShippingIncluded(op==0);

//			if(op==1 | op==2) shippingIncluded = false;
			
			return p;
		}
	public  Product updateProd(Product p) {
		p.setName(JOptionPane.showInputDialog("Ingrese el nombre"));
		p.setDescripcion(JOptionPane.showInputDialog("Ingrese la descripcion"));
		p.setStock( Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto")));
		p.setPrice(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el stock del producto")));
		Integer op=JOptionPane.showConfirmDialog(null, "¿Incluye envio?");
		p.setShippingIncluded(op==0);
		
		return p;
	}

		
	}

	