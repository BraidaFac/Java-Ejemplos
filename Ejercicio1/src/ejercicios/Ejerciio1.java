package ejercicios;

import java.util.Iterator;
import java.util.Scanner;

public class Ejerciio1 {
	public static void main(String[] args) {
		String palabra;
		Integer[] numeros= new Integer[5];
		Integer[] mayores= new Integer[5];
		
		
		String[] palabras= new String[3];
		Scanner lector = new Scanner(System.in);
		System.out.print("ingrese el numero");
		Integer num= Integer.parseInt(lector.next());
		
		palabra = lector.nextLine();
		ejercicio4(numeros, num, lector, mayores);
		//Ejerciio1.extracted(palabras, lector);
		//System.out.println(ejercio3(palabras,lector));5
			lector.close();

	}
	
	public static void ejercicio4(Integer[] numeros, int num,Scanner lector, Integer[]mayores) {
		System.out.println("ingrese los 5 numeros");
		for(int i=0; i<5; i++) {
			numeros[i]= Integer.parseInt(lector.nextLine());
		}
		
		for (int i=0; i<5; i++) {
			if(numeros[i]>num) {
				mayores[i]= numeros[i];
				}
			else {
				mayores[i]= null;
			}
			System.out.print("los numeross mayores a " + num + " son:: ") ;
			System.out.println(mayores [i]);
		
		
		
	}}
		
		
	
	
	
	/*public static String ejercio3(String[] palabras, Scanner lector) {
	for (int i=0; i<3; i++) {
		System.out.println("Ingrese la palabra");
		palabras[i]= lector.nextLine();
							}
	System.out.println("ingrese la nueva palabra");
		String nuevapalabra= lector.nextLine();
	for(int i=0; i<3; i++) {
		if (palabras[i].equals(nuevapalabra) ){
			return "la palabra ya ha sido ingresda";
			
										}
							}
	return "la palabra no se repite";

	
	
	}*/
	/*public static void extracted(String[] palabras, Scanner lector) {
		for (int i=0; i<10; i++) {
			System.out.println("Ingrese la palabra");
			palabras[i]= lector.nextLine();
		}
		for(int i=(palabras.length)-1; i>=0; i--) {
			System.out.println("la palabra en la posicion "+ i + " es ::"+palabras[i]);
		}
	}*/

}
