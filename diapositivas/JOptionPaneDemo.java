package diapositivas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JOptionPaneDemo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneDemo window = new JOptionPaneDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JOptionPaneDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JOptionPaneDemo");
		JPanel mipanel=new JPanel();
		frame.getContentPane().add(mipanel,BorderLayout.CENTER);
		JButton boton1=new JButton("Dialogo 1");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto="Hola Mundo";
				StringBuilder sBuilder=new StringBuilder();
				sBuilder.append(texto);
				sBuilder=sBuilder.reverse();
				JOptionPane.showMessageDialog(frame, sBuilder, "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		mipanel.add(boton1);
		JButton boton2=new JButton("Dialogo 2");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options={"Opcion1","Opcion2","Opcion3"};
				int respuesta=JOptionPane.showOptionDialog(frame, "Selecciona un boton", "Titulo", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null, options[0]);
				if (respuesta==JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(frame,"Le diste");
				}
			}
		});
		
		mipanel.add(boton2);
		
		JButton boton3=new JButton("Dialogo 3");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options={"Jaen","Zaragoza","Madrid"};
				
				String ciudad=(String) JOptionPane.showInputDialog(frame, "Ciudad", "Titulo", JOptionPane.PLAIN_MESSAGE, null, options,options[1]);
				if (ciudad.length()<=0){}
				else
				JOptionPane.showMessageDialog(frame, ciudad);
			}
		});
		
		mipanel.add(boton3);
		JButton boton4=new JButton("Recoge el dialogo y lo muestra en una ventana nueva");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options={"Jaen","Zaragoza","Madrid"};
				
				String ciudad=(String) JOptionPane.showInputDialog(frame, "Ciudad", "Titulo", JOptionPane.PLAIN_MESSAGE);
				if (ciudad.length()<=0){}
				else
				JOptionPane.showMessageDialog(frame, ciudad);
			}
		});
		
		mipanel.add(boton4);
		JButton boton5=new JButton("Dialogo personalizado");
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialogDemo miDialogo=new JDialogDemo(frame);
			}
		});
		
		mipanel.add(boton5);
		
	}

}
