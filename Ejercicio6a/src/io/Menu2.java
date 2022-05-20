package io;
import db.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import entities.*;


	public class Menu2 {
		DataProducto dp= new DataProducto();
		Product p=null;
		private String dateFormat="dd/MM/yyyy";
		private String timeFormat="HH:mm:ss";
		private String dateTimeFormat=dateFormat+" "+timeFormat;
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
				Product prod= new Product();
				prod.setId(ingresoID());
				 p= dp.getByID(prod);
				if (p != null)
				JOptionPane.showMessageDialog(null, "Encuentra un producto  "+ p);
				else 
				JOptionPane.showMessageDialog(null,"No se encontro el producto","Alerta",0);   
				break;
			case 2:
				 p=dp.add(nuevoProd());
				 JOptionPane.showMessageDialog(null,"El producto se cargo con exito \n"+p);
				break;
			case 3:
				prod= new Product();
				prod.setId(ingresoID());
				p= dp.getByID(prod);
				JOptionPane.showMessageDialog(null,"El producto a actualizar es:: \n"+p);
				dp.actualizar(updateProd(p));
				break;
			case 4:
				prod= new Product();
				prod.setId(ingresoID());
				dp.delete(prod);
				JOptionPane.showMessageDialog(null,"El producto se elimino","Alerta",JOptionPane.WARNING_MESSAGE);
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
			p.setShippingIncluded((JOptionPane.showConfirmDialog(null, "¿Incluye envio?"))==0);
//			if(op==1 | op==2) shippingIncluded = false;
			DateTimeFormatter dtFormat =DateTimeFormatter.ofPattern(dateTimeFormat);
			DateTimeFormatter tFormat= DateTimeFormatter.ofPattern(timeFormat);
			DateTimeFormatter dFormat= DateTimeFormatter.ofPattern(dateFormat);
			p.setDisabledOn(LocalDateTime.parse(JOptionPane.showInputDialog("Ingrese la fecha y hora"),dtFormat));
			p.setDisabledDate(LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha "),dFormat));
			p.setDisabledTime(LocalTime.parse(JOptionPane.showInputDialog("Ingrese la hora"),tFormat));
			p.setDisabledOnZoned(ZonedDateTime.parse(JOptionPane.showInputDialog("Ingrese fecha y hora"),dtFormat.withZone(ZoneId.of("UTC-3"))));

			
			return p;
		}
	public  Product updateProd(Product p) {
		p.setName(JOptionPane.showInputDialog("Ingrese el nombre"));
		p.setDescripcion(JOptionPane.showInputDialog("Ingrese la descripcion"));
		p.setStock( Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto")));
		p.setPrice(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el stock del producto")));
		p.setShippingIncluded((JOptionPane.showConfirmDialog(null, "¿Incluye envio?"))==0);
//		if(op==1 | op==2) shippingIncluded = false;
		DateTimeFormatter dtFormat =DateTimeFormatter.ofPattern(dateTimeFormat);
		DateTimeFormatter tFormat= DateTimeFormatter.ofPattern(timeFormat);
		DateTimeFormatter dFormat= DateTimeFormatter.ofPattern(dateFormat);
		p.setDisabledOn(LocalDateTime.parse(JOptionPane.showInputDialog("Ingrese la fecha y hora"),dtFormat));
		p.setDisabledDate(LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha "),dFormat));
		p.setDisabledTime(LocalTime.parse(JOptionPane.showInputDialog("Ingrese la hora"),tFormat));
		p.setDisabledOnZoned(ZonedDateTime.parse(JOptionPane.showInputDialog("Ingrese fecha y hora"),dtFormat.withZone(ZoneId.of("UTC-3"))));
		return p;
	}

		
	}

	