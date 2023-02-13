/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenInterfacespt2;



/**
 *
 * @author Mirela
 */
public class Principal {
    
    
         Frase miFrase;
	VentanaFrase ventanaPrincipal;

	public Principal() {
		ventanaPrincipal = new VentanaFrase();
		miFrase = new Frase();
		

	}

	public static void main(String[] args) {
		// TODO code application logic here
		Principal ventana = new Principal();

		ventana.ventanaPrincipal.setVisible(true);
	}
}
    

