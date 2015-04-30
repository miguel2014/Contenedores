package diapositivas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.plaf.FileChooserUI;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class JScrollPaneDemo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JScrollPaneDemo window = new JScrollPaneDemo();
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
	public JScrollPaneDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFileChooser fileChooser=new JFileChooser();
		
		
		JTextArea textAreaIzquierda = new JTextArea();
		//Otra forma de añadir el scollpane al textarea
		//JScrollPane scrollpane=new JScrollPane(textArea);
		JScrollPane scrollPanelIzquierda=new JScrollPane();
		//Para que siempre nos muestre la barra de scroll
		scrollPanelIzquierda.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanelIzquierda.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPanelIzquierda.setViewportView(textAreaIzquierda);
		
		
		JTextArea textAreaDerecha = new JTextArea();
		JScrollPane scrollPanelDerecha=new JScrollPane();
		scrollPanelDerecha.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanelDerecha.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPanelDerecha.setViewportView(textAreaDerecha);
		
		//Creamos el JSPlitPane que contendra a scrollpanelIzquierda y scrollpanelDerecha
		JSplitPane splitPaneSuperior=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPanelIzquierda,scrollPanelDerecha);
		splitPaneSuperior.setResizeWeight(0.5); //Para situar en el centro
		splitPaneSuperior.setContinuousLayout(true); //Para evitar que pinte mientras arrastramos
		splitPaneSuperior.setOneTouchExpandable(true);//Añade iconos en el divisor para expandir o replegar
		splitPaneSuperior.setDividerSize(10); //Establecer el tamaño del divisor
		
		
		
		
		JTextArea textAreaInferior=new JTextArea();
		
		JScrollPane scrollPanelInferior=new JScrollPane(textAreaInferior);
		scrollPanelInferior.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanelInferior.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JSplitPane splitpaneInferior=new JSplitPane(JSplitPane.VERTICAL_SPLIT,splitPaneSuperior,scrollPanelInferior);
		
		splitpaneInferior.setResizeWeight(0.5); //Para situar en el centro
		splitpaneInferior.setContinuousLayout(true); //Para evitar que pinte mientras arrastramos
		splitpaneInferior.setOneTouchExpandable(true);//Añade iconos en el divisor para expandir o replegar
		splitpaneInferior.setDividerSize(10); //Establecer el tamaño del divisor
		
		frame.getContentPane().add(splitpaneInferior, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmAbrirFicheroA = new JMenuItem("Abrir fichero a la izquierda");
		mntmAbrirFicheroA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnval=fileChooser.showOpenDialog(frame);
				if(returnval==JFileChooser.APPROVE_OPTION){
					File fileSelected=fileChooser.getSelectedFile();
					addArchivo f1=new addArchivo(fileSelected);
					textAreaIzquierda.setText(f1.getArchivo());
					
				}
			}
		});
		mnArchivo.add(mntmAbrirFicheroA);
		
		JMenuItem mntmAbrirFicheroA_1 = new JMenuItem("Abrir fichero a la derecha");
		mntmAbrirFicheroA_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnval=fileChooser.showOpenDialog(frame);
				if(returnval==JFileChooser.APPROVE_OPTION){
					File fileSelected=fileChooser.getSelectedFile();
					addArchivo f1=new addArchivo(fileSelected);
					textAreaDerecha.setText(f1.getArchivo());
					
				}
			}
		});
		mnArchivo.add(mntmAbrirFicheroA_1);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAccion = new JMenu("Accion");
		menuBar.add(mnAccion);
		
		JMenuItem mntmComparar = new JMenuItem("Comparar");
		mntmComparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnAccion.add(mntmComparar);
		
		
	}

}
