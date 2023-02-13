/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exameninterfacespt1;

/**
 *
 * @author Mirela
 */

    
    
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


class PanelDibujo extends JPanel{
	String texto;
	Color color;
	PanelDibujo(){
		texto=new String();
		color=Color.blue;
	}
	PanelDibujo(String texto,Color color){
		this.texto=texto;
		this.color=color;
	}

	public void setTexto(String texto){
		this.texto=texto;
	}

	public void setColor(Color color){
		this.color=color;
	}


@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		try {
			g.setFont(new Font("Arial",Font.BOLD,24));
			g.setColor(color);
			g.drawString(texto,this.getWidth()/6,this.getHeight()/3);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}






	class PanelCentral extends JPanel {
		JLabel[] etiquetas = new JLabel[5];
		JTextField[] cuadros = new JTextField[5];
	
		private static GridBagConstraints createConstraints(int gridx, int gridy, int gridwidth, int gridheight,
				double weightx, double weighty, int fill, int anchor, Insets insets) {
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = gridx;
			constraints.gridy = gridy;
			constraints.gridwidth = gridwidth;
			constraints.gridheight = gridheight;
			constraints.weightx = weightx;
			constraints.weighty = weighty;
			constraints.fill = fill;
			constraints.anchor = anchor;
			constraints.insets = insets;
			return constraints;
		}
	
		PanelCentral() {
			this.setBorder(BorderFactory.createTitledBorder("Procesar Frase"));
			this.setLayout(new GridBagLayout());
	
			for (int i = 0; i < etiquetas.length; i++) {
				etiquetas[i] = new JLabel();
				
				this.add(etiquetas[i], createConstraints(0, i, 1, 1, 0.0, 1.0,
						GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 5, 10, 4)));
	
				cuadros[i] = new JTextField(40);
				
				Border border = BorderFactory.createRaisedSoftBevelBorder();
	
				cuadros[i].setBorder(border);
				this.add(cuadros[i], createConstraints(1, i, 1, 1, 1.0, 1.0, GridBagConstraints.HORIZONTAL,
						GridBagConstraints.CENTER, new Insets(4, 5, 10, 4)));
	
			}
			etiquetas[0].setText("Numero de letras");
                        cuadros[0].setToolTipText("Muestra el numero de letras de la frase");
                        
			etiquetas[1].setText("Numero de palabras");
                        cuadros[1].setToolTipText("Muestra el numero de palabras de la frase");
			
			etiquetas[2].setText("Invertir frase");
                        cuadros[2].setToolTipText("Muestra la frase al reves");
			
			etiquetas[3].setText("Separar palabras");
                        cuadros[3].setToolTipText("Separa las palabras de la frase");
		
			etiquetas[4].setText("Primera posicion vocal");
                        cuadros[4].setToolTipText("Muestra la posicion de la primera letra de la frase");
		}
	
	}
	

public class VentanaFrase extends JFrame {
	GridBagConstraints gbc = new GridBagConstraints();
	Container contenedor;
	JLabel JlFrase;
	JTextField cuadroFrase;
	JButton botonProcesar, botonSalir, botonLimpiar;
	JButton botonMostrar,botonPintar;
	
	PanelCentral panelCentral;
	PanelDibujo panelDibujo;
        Font fuente=new Font("SansSerif",Font.BOLD,18);

	public VentanaFrase() {

		super("Interface Frase");
		contenedor = this.getContentPane();
                contenedor.setLayout(new GridBagLayout());
                gbc=new GridBagConstraints();
                
                
		
		
		JlFrase = new JLabel("Introduce una frase");
                JlFrase.setFont(fuente);
                JlFrase.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                gbc.gridx=0;
                gbc.gridy=0;
                gbc.weightx=0.0;
                gbc.weighty=1.0;
                gbc.anchor=GridBagConstraints.CENTER;
                gbc.gridheight=1;
                gbc.gridwidth=1;
                gbc.insets=new Insets(10,10,10,4);
                contenedor.add(JlFrase,gbc);
                
		

		cuadroFrase = new JTextField();
                cuadroFrase.setToolTipText("Introduce una frase aqui");
                cuadroFrase.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
                gbc.gridx=1;
                gbc.gridy=0;
                gbc.weightx=1.0;
                gbc.weighty=1.0;
                gbc.fill=GridBagConstraints.HORIZONTAL;
                gbc.anchor=GridBagConstraints.CENTER;
                gbc.gridheight=1;
                gbc.gridwidth=3;
                gbc.insets=new Insets(0,10,10,4);
                contenedor.add(cuadroFrase,gbc);
                
		
		botonProcesar = new JButton("Procesar frase");
                botonProcesar.setMnemonic('P');
                botonProcesar.setFont(fuente);
                gbc.gridx=0;
                gbc.gridy=1;
                gbc.weightx=1.0;
                gbc.weighty=1.0;
                gbc.fill=GridBagConstraints.VERTICAL;
                gbc.anchor=GridBagConstraints.CENTER;
                gbc.gridheight=4;
                gbc.gridwidth=1;
                gbc.insets=new Insets(2,20,20,2);
                contenedor.add(botonProcesar,gbc);
                
                
	

		// Añade el panel de los resultados
		panelCentral = new PanelCentral();
                  gbc.gridx=1;
                gbc.gridy=1;
                gbc.weightx=1.0;
                gbc.weighty=1.0;
                gbc.fill=GridBagConstraints.BOTH;
                gbc.anchor=GridBagConstraints.CENTER;
                gbc.gridheight=3;
                gbc.gridwidth=2;
		contenedor.add(panelCentral,gbc);
                
            
		
		
		botonSalir = new JButton("Salir");
                botonSalir.setFont(fuente);
                botonSalir.setAlignmentX(JButton.CENTER_ALIGNMENT);
                gbc.gridx=0;
                gbc.gridy=5;
                gbc.weightx=1.0;
                gbc.weighty=1.0;
                gbc.fill=GridBagConstraints.HORIZONTAL;
                gbc.anchor=GridBagConstraints.NORTHEAST;
                gbc.gridheight=3;
                gbc.gridwidth=1;
                gbc.insets=new Insets(5,20,5,5);
		contenedor.add(botonSalir,gbc);
                
		
	
		//botonLimpiar = new JButton();
		botonLimpiar = new JButton("Limpiar");
                botonLimpiar.setFont(fuente);
                botonLimpiar.setAlignmentX(JButton.CENTER_ALIGNMENT);
                gbc.gridx=1;
                gbc.gridy=5;
                gbc.weightx=1.0;
                gbc.weighty=1.0;
                gbc.fill=GridBagConstraints.HORIZONTAL;
                gbc.anchor=GridBagConstraints.NORTHWEST;
                gbc.gridheight=3;
                gbc.gridwidth=2;
                gbc.insets=new Insets(5,20,5,5);
		contenedor.add(botonLimpiar,gbc);
                
		
		
                
               
                
                	setSize(new Dimension(1200, 400));
		setMinimumSize(new Dimension(320, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                

}

}