import javax.swing.*;
import java.awt.*; 
import javax.swing.border.EmptyBorder; 
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatoMoneda extends JFrame{

    //Atributos
    JTextField campo_numero;
    JLabel resultado;

    public FormatoMoneda(){
        initComponents();
    }

    public void initComponents(){
        setTitle("FORMATO MONEDA");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Image icono = getToolkit().createImage( ClassLoader.getSystemResource("imagenes/icono_moneda.png") );
        setIconImage(icono);

        JPanel contenedor = new JPanel();
        contenedor.setBorder(new EmptyBorder(20,20,20,20));
        contenedor.setLayout(new GridBagLayout());

        GridBagConstraints restriccion = new GridBagConstraints();
        JLabel cantidad = new JLabel("Cantidad");
        restriccion.gridy = 0;
        restriccion.gridx = 0;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 15;
        restriccion.weighty = 5;
        restriccion.fill = GridBagConstraints.BOTH; 
        contenedor.add(cantidad, restriccion);

        campo_numero = new JTextField();
        restriccion.insets = new Insets(10,10,10,10);
        restriccion.gridy = 0;
        restriccion.gridx = 1;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 70;
        restriccion.weighty = 5;
        restriccion.fill = GridBagConstraints.BOTH; 
        contenedor.add(campo_numero, restriccion);

        JButton enviar = new JButton("Enviar");
        restriccion.gridy = 0;
        restriccion.gridx = 2;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weightx = 15;
        restriccion.weighty = 5;
        restriccion.fill = GridBagConstraints.BOTH; 
        contenedor.add(enviar, restriccion);

        resultado = new JLabel("----");
        resultado.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        /* resultado.setHorizontalAligment(JLabel.CENTER); */
        restriccion.gridy = 1;
        restriccion.gridx = 0;
        restriccion.gridwidth = 3;
        restriccion.gridheight = 1;
        restriccion.weightx = 100;
        restriccion.weighty = 95;
        restriccion.fill = GridBagConstraints.CENTER; 
        contenedor.add(resultado, restriccion);



        add(contenedor);
        revalidate();

        ActionListener eventoEjecutar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String numero = campo_numero.getText();
                try{
                if(numero.equals("")  ){
                    resultado.setText("No Entiendo");
                    campo_numero.setText("");
                    campo_numero.requestFocus();
                }else{
                Double numeroDoble = Double.parseDouble(numero);
                NumberFormat numeroFormateado = NumberFormat.getCurrencyInstance(Locale.getDefault());
                numeroFormateado.setMaximumFractionDigits(0);
                numero= numeroFormateado.format(numeroDoble);

                resultado.setText(numero + " COP");
                campo_numero.setText("");
                campo_numero.requestFocus();
                }
            }catch(Exception E){
                resultado.setText("No Entiendo");
                campo_numero.setText("");
                campo_numero.requestFocus();
            }
            }
        };
        enviar.addActionListener(eventoEjecutar);
        setVisible(true);

    }

}