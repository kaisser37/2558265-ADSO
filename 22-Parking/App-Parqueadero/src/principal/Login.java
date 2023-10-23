package principal;

import com.google.gson.Gson; 
import com.google.gson.JsonObject;
import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map; 
import javax.swing.ImageIcon;
import javax.swing.JOptionPane; 
import javax.swing.JPanel;

public class Login extends javax.swing.JFrame {

    ImagenFondo imgFondo = new ImagenFondo();
    ConsumoAPI conexion = new ConsumoAPI();
    Gson gson = new Gson();

    public Login() {
        this.setContentPane(imgFondo);
        initComponents();
        initComponentsAltern();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etq_img = new javax.swing.JLabel();
        panel_formulario = new javax.swing.JPanel();
        etq_email = new javax.swing.JLabel();
        campo_email = new javax.swing.JTextField();
        etq_contrasenia = new javax.swing.JLabel();
        campo_contrasenia = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel_formulario.setBackground(new java.awt.Color(255, 153, 153));
        panel_formulario.setOpaque(false);

        etq_email.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        etq_email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_email.setText("Correo");

        campo_email.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        campo_email.setText("admin@root.com");
        campo_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#318ade")));
        campo_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_emailActionPerformed(evt);
            }
        });

        etq_contrasenia.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        etq_contrasenia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_contrasenia.setText("Contraseña:");

        campo_contrasenia.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        campo_contrasenia.setText("clave");
        campo_contrasenia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#318ade")));
        campo_contrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_contraseniaActionPerformed(evt);
            }
        });
        campo_contrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campo_contraseniaKeyReleased(evt);
            }
        });

        btn_login.setBackground(new java.awt.Color(255, 51, 51));
        btn_login.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("ENVIAR");
        btn_login.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(153, 153, 153)));
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_login.setFocusable(false);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_formularioLayout = new javax.swing.GroupLayout(panel_formulario);
        panel_formulario.setLayout(panel_formularioLayout);
        panel_formularioLayout.setHorizontalGroup(
            panel_formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_formularioLayout.createSequentialGroup()
                .addGroup(panel_formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_formularioLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(panel_formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_email, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campo_contrasenia)
                                .addComponent(etq_contrasenia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campo_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))))
                    .addGroup(panel_formularioLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        panel_formularioLayout.setVerticalGroup(
            panel_formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_formularioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(etq_email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campo_email, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(etq_contrasenia)
                .addGap(28, 28, 28)
                .addComponent(campo_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panel_formulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panel_formulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        Loginfuncion();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void campo_contraseniaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_contraseniaKeyReleased
        if (evt.getKeyChar() == '\n') {

            Loginfuncion();
        }
    }//GEN-LAST:event_campo_contraseniaKeyReleased

    private void campo_contraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_contraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_contraseniaActionPerformed

    private void campo_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_emailActionPerformed

    public void Loginfuncion() {
        String correo = campo_email.getText();
        String contrasenia = String.valueOf(campo_contrasenia.getPassword());

        if (correo.length() > 0 && contrasenia.length() > 0) {
            Map<String, String> ingresarData = new HashMap<>();
            ingresarData.put("correo", correo);
            ingresarData.put("contrasenia", contrasenia);

            try {
                String temporal = conexion.ConsumoGET("http://localhost/APIparqueadero/usuarios/LoginGet.php", ingresarData);
                System.out.println("aiuda");
                JsonObject jsonObject = gson.fromJson(temporal, JsonObject.class);

                if (jsonObject.has("usuario")) {
                    JsonObject registro = jsonObject.getAsJsonObject("usuario");
                    String estados = registro.get("estado").getAsString();
                    if(estados.equals("0")){
                        JOptionPane.showMessageDialog(null, "El usuario esta deshabilitado");
                    }else{
                        Parqueadero ventanaParqueadero = new Parqueadero(registro);
                        dispose();
                    }
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro al Usuario");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Intentalo de nuevo");
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");
        }

    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JPasswordField campo_contrasenia;
    private javax.swing.JTextField campo_email;
    private javax.swing.JLabel etq_contrasenia;
    private javax.swing.JLabel etq_email;
    private javax.swing.JLabel etq_img;
    private javax.swing.JPanel panel_formulario;
    // End of variables declaration//GEN-END:variables

    private void initComponentsAltern() {
        
        this.setTitle("Login");
        
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        campo_contrasenia.setText("");
    }
    class ImagenFondo extends JPanel {

        Image imagen;
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/fondo-login.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
 
}
