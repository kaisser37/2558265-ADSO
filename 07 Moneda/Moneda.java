import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Moneda {
    public static void main(String[] args) {

        JFrame ventana = new JFrame();
        ventana.setTitle("Formato Moneda");
        ventana.setSize(750, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        contenedor.setBorder(new EmptyBorder(15, 15, 15, 15));

        GridBagLayout gbl = new GridBagLayout();
        contenedor.setLayout(gbl);

        GridBagConstraints gcon = new GridBagConstraints();
        gcon.weightx = 1;
        gcon.weighty = 1;
        gcon.fill = GridBagConstraints.BOTH;

        JLabel cantidad = new JLabel("CANTIDAD: ");
        gcon.gridy = 0;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weightx = 15;
        gcon.weighty = 5;
        gbl.setConstraints(cantidad, gcon);

        JTextField campo_moneda = new JTextField();
        gcon.insets = new Insets(5, 0, 5, 15);
        gcon.gridy = 0;
        gcon.gridx = 1;
        gcon.gridwidth = 1;
        gcon.weightx = 70;
        gcon.weighty = 5;
        gbl.setConstraints(campo_moneda, gcon);

        JButton ejecutar = new JButton("EJECUTAR");
        gcon.insets = new Insets(5, 5, 5, 5);
        gcon.gridy = 0;
        gcon.gridx = 2;
        gcon.gridwidth = 1;
        gcon.weightx = 15;
        gcon.weighty = 5;
        gbl.setConstraints(ejecutar, gcon);

        JLabel etq_texto = new JLabel(" ------------------- ");
        gcon.gridx = 0;
        gcon.gridy = 1;
        gcon.gridwidth = 3;
        gcon.weightx = 100;
        gcon.weighty = 95;
        gcon.fill = GridBagConstraints.CENTER;
        etq_texto.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(etq_texto, gcon);

        contenedor.add(cantidad);
        contenedor.add(campo_moneda);
        contenedor.add(ejecutar);
        contenedor.add(etq_texto);

        ventana.add(contenedor);
        ventana.setVisible(true);

        // Acción del botón "EJECUTAR"
        ejecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = campo_moneda.getText().trim();
                if (!texto.isEmpty()) {
                    try {
                        long numero = Long.parseLong(texto.replace(".", ""));
                        DecimalFormat decimalFormat = new DecimalFormat("#,###");
                        String numeroFormateado = decimalFormat.format(numero);
                        numeroFormateado = "$ " + numeroFormateado;
                        etq_texto.setText(numeroFormateado);
                    } catch (NumberFormatException ex) {
                        etq_texto.setText("Error: Ingresa un número válido");
                    }
                }
            }
        });
    }
}
