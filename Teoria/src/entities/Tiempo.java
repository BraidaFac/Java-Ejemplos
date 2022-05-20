package entities;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Tiempo {
	public static void main(String[] args) {
		DamelaHora oyente= new DamelaHora();
		Timer mitemporizador = new Timer(2000, oyente);
		mitemporizador.start();
		JOptionPane.showMessageDialog(null,"Presiona para cancelar");
		System.exit(0);
		
		
		
	}
	}
	
	class DamelaHora implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			Date ahora= new Date();	
			System.out.println("La hora es:  " + ahora );
			Toolkit.getDefaultToolkit().beep();			}
	}
	