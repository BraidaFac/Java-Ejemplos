package utils;

public abstract class Sort {
	
	static public void ordenaLista(Ordenable[] lista) {
		for(int i=0; i<lista.length-1; i++) {
			for(int j=i+1; j < lista.length; j++) {
				if (lista[i].compare(lista[j])>0){
					Ordenable temp = lista[i];
					lista[i]= lista [j];
					lista[j]= temp;
					
				}
			}
		}
	}
}
