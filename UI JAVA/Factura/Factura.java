import javax.swing.*;
import java.awt.*; 
import javax.swing.border.EmptyBorder; 
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Factura extends JFrame {

    public Factura(){
        initComponents();
    }

    public void initComponents() {
        setTitle("Factura");
        setSize(650,1200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Image icono = getToolkit().createImage( ClassLoader.getSystemResource("imagenes/icono_factura.png") );
        setIconImage(icono);

        JPanel contenedor = new JPanel();
        contenedor.setBorder(new EmptyBorder(20,20,20,20));
        contenedor.setLayout(new GridBagLayout());

        GridBagConstraints restriccion = new GridBagConstraints();
        JLabel cantidad = new JLabel("Datos Cliente");
        restriccion.gridy = 0;
        restriccion.gridx = 0;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 40;
        restriccion.weighty = 5;
        restriccion.fill = GridBagConstraints.BOTH; 
        contenedor.add(cantidad, restriccion);

        JLabel resultado = new JLabel("Cedula");
        resultado.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        /* resultado.setHorizontalAligment(JLabel.CENTER); */
        restriccion.gridy = 1;
        restriccion.gridx = 0;
        restriccion.gridwidth = 3;
        restriccion.gridheight = 1;
        restriccion.weightx = 10;
        restriccion.weighty = 5;
        restriccion.fill = GridBagConstraints.CENTER; 
        contenedor.add(resultado, restriccion);
    }

        JTextField campo_numero = new JTextField();
        restriccion.insets = new Insets(10,10,10,10);
        restriccion.gridy = 1;
        restriccion.gridx = 1;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 80;
        restriccion.weighty = 5;
        restriccion.fill = GridBagConstraints.BOTH; 
        contenedor.add(campo_numero, restriccion);

        JButton enviar = new JButton("Buscar");
        restriccion.gridy = 1;
        restriccion.gridx = 1;
        restriccion.gridwidth = 2;
        restriccion.gridheight = 1;
        restriccion.weightx = 10;
        restriccion.weighty = 5;
        restriccion.fill = GridBagConstraints.BOTH; 
        contenedor.add(enviar, restriccion);

        
}
