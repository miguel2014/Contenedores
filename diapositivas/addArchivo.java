package diapositivas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class addArchivo {
	private File archivo;
	
	/**
	 * @param archivo
	 * 
	 */
	public addArchivo(File archivo) {
		this.archivo = archivo;
	}
	public String getArchivo(){
		String valorLeido="";
		int contador=1;
		try (Scanner in = new Scanner(archivo);){
				while(in.hasNext()){
					valorLeido+=in.nextLine()+" ";
					//Cada 10 lineas leidas a�ade una nueva linea
					if (contador%10==0) {
						valorLeido+="\n";
					}
					contador++;
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return valorLeido;
	}
	
}