package diapositivas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Toolkit;

public class JFrameDemo {
private JFrame ventana;

public JFrameDemo(){
	ventana=new JFrame("Ventana de pruebas");
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ventana.setIconImage(new ImageIcon("/home/matinal/workspace/Contenedores/src/diapositivas/descarga.jpg").getImage());
	JButton boton1=new JButton("Boton");
	JButton boton2=new JButton("Boton");
	
	FlowLayout miFlowLayout=new FlowLayout(FlowLayout.LEFT,10,10);
	ventana.getContentPane().add(boton1);
	ventana.getContentPane().add(boton2);
	ventana.getContentPane().setLayout(miFlowLayout);
	ventana.setVisible(true);
	//ventana.setSize(200, 150);
	//X,y,tamaño,ancho
	ventana.setBounds(450, 100, 450, 250);
	ventana.pack();
	ventana.setLocationRelativeTo(null);
	
}
public static void main(String[] args) {
	new JFrameDemo();
	
}
}
