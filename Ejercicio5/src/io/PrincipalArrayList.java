package io;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import entidades.*;
import productos.*;

public class PrincipalArrayList {

	public static void main(String[] args) {
			
		 ArrayList<Persona> personas = new ArrayList<>();
		 ArrayList<Producto> productos= new ArrayList<>();
		 
		 
		 agregarEmpleado(personas);
		 listarEmple(personas); }



	private static void listarEmple(ArrayList<Persona> personas) 
	{
		for(int i=0; (i<=personas.size()-1); i ++) 
		{
			 	System.out.println(personas.get(i));
		}
	}

	private static void agregarEmpleado(ArrayList<Persona> personas)
	{	
		int op=1;
		String[] options = {"Salir", "Vendedor", "Administrador","Cliente" };
		while(op!=0)
		{
				op= JOptionPane.showOptionDialog(null,"Cargar Empleados o Cliente ","Seleccione una opción ",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				// 0= Salir 1= Vendedor 2= ADMIN 3= CLIENTE
				if (op==1) {
				
							personas.add(new Admin(
									Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni")) , 
									JOptionPane.showInputDialog("Ingrese nombre"),
									JOptionPane.showInputDialog("Ingrese Apellido"),
									JOptionPane.showInputDialog("Ingrese email"),
									Float.parseFloat(JOptionPane.showInputDialog("Ingrese sueldo Base")),
									Integer.parseInt(JOptionPane.showInputDialog("Ingrese horas extras")),
									Integer.parseInt(JOptionPane.showInputDialog("Ingrese horas por mes"))));

							}
				else if (op==2)
				{
								
						personas.add(new Vendedor(Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni")) , 
					
								JOptionPane.showInputDialog("Ingrese nombre"),
								JOptionPane.showInputDialog("Ingrese Apellido"),
								JOptionPane.showInputDialog("Ingrese email"),
								Float.parseFloat(JOptionPane.showInputDialog("Ingrese sueldo Base")),
								Integer.parseInt(JOptionPane.showInputDialog("Ingrese porcentaje Comision ")),
								Integer.parseInt(JOptionPane.showInputDialog("Ingrese total ventas "))));
				}
				else if(op==3) 
				{
					personas.add(new Cliente(
							Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni")),
							JOptionPane.showInputDialog("Ingrese nombre"),
							JOptionPane.showInputDialog("Ingrese Apellido"),
							JOptionPane.showInputDialog("Ingrese email"),
							Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero Cliente")),
							JOptionPane.showInputDialog("Ingrese Direccion "),
							Integer.parseInt(JOptionPane.showInputDialog("Ingrese telefono "))));
					
				}
		}
	}
	
	static void agregarProductos(ArrayList<Producto> productos)
	{	
		//VARIABLES TEMPORALES
		 String patente;
		 String marca;
		 String color;
		 int modelo;
		 int cantPuertas;
		 boolean baul;
		 int caballosFuerza;
		 int rodado;
		 int cilindrada;
		 String clase;
	
		 String [] options = {"Salir", "Auto", "Moto"}; 
		 
	//INICIALIZACIONN DE SALIDA
		 int op =1;
	
	{
		while(op != 0)
		{	
			op= JOptionPane.showOptionDialog(null, "Cargar Vehiculo", "Seleccione una opcion",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			// 0= Salir 1= AUTO 2= MOTO
			if(op==1)
			{	
				patente= JOptionPane.showInputDialog("Ingrese modelo");
				marca= JOptionPane.showInputDialog("Ingrse la marca del auto");
				color= JOptionPane.showInputDialog("Ingrese color del auto");
				modelo= Integer.parseInt(JOptionPane.showInputDialog("Ingrese modelo"));
				cantPuertas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de puertas"));
				int a=JOptionPane.showConfirmDialog(null, "¿Tiene Baul?", "Conteste", JOptionPane.YES_NO_CANCEL_OPTION);    
				if(a==JOptionPane.YES_OPTION) 
				    baul=true;
				else 
					baul=false;
				caballosFuerza=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad caballos de fuerza"));
				productos.add(new Auto(patente, marca,color, modelo, cantPuertas, baul, caballosFuerza));
			}
			else if(op==2)
			{
				patente= JOptionPane.showInputDialog("Ingrese modelo");
				marca= JOptionPane.showInputDialog("Ingrse la marca del auto");
				color= JOptionPane.showInputDialog("Ingrese color del auto");
				modelo= Integer.parseInt(JOptionPane.showInputDialog("Ingrese modelo"));
				rodado= Integer.parseInt(JOptionPane.showInputDialog("Ingrese rodado de la cubierta"));
				cilindrada= Integer.parseInt(JOptionPane.showInputDialog("Ingrese cilindrada"));
				clase= JOptionPane.showInputDialog("Ingrese la clase de la moto");
				productos.add(new Moto(patente,marca,color,modelo,rodado,cilindrada,clase));
			}
			
		
		}
	}
	
	}
}
