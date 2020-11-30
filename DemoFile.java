package Archivos;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import DemostracionFile.DemostracionFile;

public class DemoFile extends JFrame implements ActionListener{
	private String texto, resultado = " ";
	
	private JTextField ruta1;
	private JLabel  texto1;
	private JButton btnComprobar;
	public DemoFile () {
		super ("Ejemplo Archivo File");
		setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        this.setLayout(fl);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        
        texto1 = new JLabel ("Escriba aqui el nombre del archivo o directorio: \n");
        texto1.setForeground(Color.magenta);
        
        ruta1 = new JTextField(45);
        ruta1.setEditable(true);
        
        btnComprobar = new JButton ("COMPROBAR");
        btnComprobar.setBackground(Color.orange);
        
        add(texto1); add(ruta1);
        
        add(btnComprobar);
        btnComprobar.addActionListener(this);
	}
	
	// muestra información acerca del archivo especificado por el usuario
	public void actionPerformed (ActionEvent e) {
        if(e.getSource() == btnComprobar){
            texto = (ruta1.getText().trim());
            this.analizarRuta(texto);
	}
  }
	public void analizarRuta( String ruta ) {
		// crea un objeto File con base en la entrada del usuario
		File nombre = new File( ruta );
		if ( nombre.exists() ) {// si existe el nombre, muestra información sobre él
	      //  JOptionPane.showMessageDialog(null,
			// muestra información del archivo (o directorio)
			JOptionPane.showMessageDialog(null,
			nombre.getName()+  "\n* Existe"+ "\n"+
			( nombre.isFile() ? "* Es un archivo" : "* No es un archivo" )+ "\n"+
			( nombre.isDirectory() ? "* Es un directorio" : "No es un directorio" )+ "\n"+
			( nombre.isAbsolute() ? "* Es ruta absoluta" : "* No es ruta absoluta" )+"\n"+
			"* Ultima modificacion: "+ nombre.lastModified()+"\n"+ "* Tamaño: "+
			nombre.length()+
			"\n"+"* Ruta: "+ nombre.getPath()+ "\n"+ "* Ruta absoluta: "+ nombre.getAbsolutePath()+
			"\n"+ "* Padre: "+ nombre.getParent() );}
		
		if ( nombre.isDirectory() ) { // muestra el listado del directorio
			String directorio[] = nombre.list();
			
			for ( String nombreDirectorio : directorio ) {
				resultado+="\n * "+ nombreDirectorio;
			}
				JOptionPane.showMessageDialog(null, "Contenido del directorio:\n" + resultado );
			} // fin de else
		 // fin de if exterior
		else{ // no es archivo o directorio, muestra mensaje de error
			JOptionPane.showMessageDialog(null, "\n"+ ruta + " no existe." );
		} // fin de else
   } // fin del método analizarRuta
}



