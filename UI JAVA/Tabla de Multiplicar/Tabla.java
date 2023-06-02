
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.html.HTML;

import java.awt.*;
import java.awt.event.*;

public class Tabla{
    public static void main(String[] args) {
        
        JFrame ventana = new JFrame();
        ventana.setTitle("TABLITAS");
        ventana.setSize(500, 400);
        ventana.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        JPanel contenedor = new JPanel();
		contenedor.setLayout( new BoxLayout(contenedor, BoxLayout.Y_AXIS) );
		contenedor.setBorder( new EmptyBorder(15,15,15,15) );

		Font fuenteInputs = new Font("Comic Sans MS", Font.PLAIN, 20);
		Font fuenteLabels = new Font("Comic Sans MS", Font.PLAIN, 18);
		EmptyBorder borderLabel = new EmptyBorder(15,0,0,0);

		JLabel etq_titulo = new JLabel("Generador de Tablas");
		etq_titulo.setFont( new Font("Comic Sans", Font.BOLD, 30) );
		etq_titulo.setForeground( Color.decode("#FBC265") );
		etq_titulo.setBackground( Color.WHITE );
		etq_titulo.setOpaque(true);
		etq_titulo.setBorder( new EmptyBorder(0,25,0,25) );

		JLabel num = new JLabel("Numero: ");
		num.setFont( fuenteLabels );
		num.setBorder( borderLabel );
		JTextField campo_num = new JTextField();
		campo_num.setFont( fuenteInputs );

		JLabel hasta = new JLabel("Multiplicado hasta: ");
		hasta.setFont( fuenteLabels );
		hasta.setBorder( borderLabel );
		JTextField campo_hasta = new JTextField();
		campo_hasta.setFont( fuenteInputs );

        JButton btnMultiplicar = new JButton ("Generar");

        JLabel resultad = new JLabel(" * x * = x ");
		resultad.setFont( new Font("Comic Sans MS", Font.BOLD, 25) );
		resultad.setBorder( new EmptyBorder(20,0,20,0) );

        contenedor.add(etq_titulo);
        contenedor.add(num);
        contenedor.add(campo_num);
        contenedor.add(hasta);
        contenedor.add(campo_hasta);
        contenedor.add(btnMultiplicar);
        contenedor.add( resultad);

        ventana.add(contenedor);

        

        ActionListener eventoMulti = new ActionListener() {
            public void actionPerformed (ActionEvent aChikita){
                int numero = Integer.parseInt(campo_num.getText());
                int hasta = Integer.parseInt(campo_hasta.getText());
                int resultado=0;
                String temp = " ";
                for(int i=0; i <= hasta;  i++){
                    resultado = numero * i;
                    temp += numero + " x " + i + " = " +  resultado + "<br>";
                    
                }
                resultad.setText( "<html>" + temp + "</html>"); 

                campo_num.setText("");
                campo_hasta.setText("");
                campo_num.requestFocus();
            }
        };
        btnMultiplicar.addActionListener(eventoMulti);

        ventana.setVisible(true);
		ventana.pack();
    }
    
}