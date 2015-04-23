package diapositivas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JinternalFrameDemo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JinternalFrameDemo window = new JinternalFrameDemo();
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
	public JinternalFrameDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JDesktopPane escritorio=new JDesktopPane();
		frame.getContentPane().add(escritorio,BorderLayout.CENTER);
		//Creamos una ventana interna
		
		
		JInternalFrame v1=new JInternalFrame("Ventana Interna 1");
		//Ampliar
		v1.setResizable(true);
		//Cerrar
		v1.setClosable(true);
		//Minimizar
		v1.setIconifiable(true);
		v1.setVisible(true);
		v1.setBounds(36, 117, 149, 143);
		escritorio.add(v1);
		JButton boton1=new JButton("boton");
		v1.getContentPane().add(boton1,BorderLayout.CENTER);
		JInternalFrame v2=new JInternalFrame("Ventana interna 2");
		//Ampliar
		v2.setResizable(true);
		//Cerrar
		v2.setClosable(true);
		//Minimizar
		v2.setIconifiable(true);
		v2.setVisible(true);
		v2.setBounds(214, 75, 159, 155);
		v2.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
		escritorio.add(v2);
		
		JPanel panel = new JPanel();
		v2.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(85, 52, 117, 25);
		escritorio.add(btnNewButton);
		v2.addInternalFrameListener(new InternalFrameListener() {
			
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				int returnval=JOptionPane.showConfirmDialog(v2, "No me cierres");
				if(returnval==JOptionPane.OK_OPTION){
					e.getInternalFrame().setVisible(false);
					e.getInternalFrame().dispose();
				}
			}
			
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
	frame.addWindowListener(new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			int returnval=JOptionPane.showConfirmDialog(frame, "No me cierres");
			if(returnval==JOptionPane.OK_OPTION){
				System.exit(0);
			}
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	}
}

