package io;

import entities.Auto;
import utils.Sort;

public class Test {

	public static void main(String[] args) {
		Auto auto1= new Auto();
		Auto auto2= new Auto();
		auto1.setTamaņoBaul(10);
		auto2.setTamaņoBaul(15);
		
		
		Auto[] losAutos= {auto1,auto2};
		
	Sort.ordenaLista(losAutos);
	System.out.println(losAutos);
//	for(int i =0; i<losAutos.length; i++) {
//		System.out.println(losAutos[i]);
//	}

	 
	}

}
