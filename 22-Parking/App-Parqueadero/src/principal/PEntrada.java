package principal;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color; 
import java.awt.Image; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map; 
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class PEntrada extends javax.swing.JPanel {

    ConsumoAPI conexion = new ConsumoAPI();
    String id_p;
    String placa;
    JButton btnConfirmar;
    JButton btnCancelar;
    JPanel panelBtn1;
    JPanel panelBtn2;
    boolean insert;

    public PEntrada(String id_parqueadero) {
        initComponents();
        this.id_p = id_parqueadero;
        this.insert = false;
        this.panelBtn1 = new JPanel();
        this.panelBtn2 = new JPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_content = new javax.swing.JPanel();
        etq_titulo = new javax.swing.JLabel();
        campo_placa = new javax.swing.JTextField();
        etq_placa = new javax.swing.JLabel();
        btn_buscar_placa = new javax.swing.JButton();
        etq_titulo_ticket = new javax.swing.JLabel();
        etq_placa_carro = new javax.swing.JLabel();
        etq_hora_ingreso = new javax.swing.JLabel();
        etq_propietario = new javax.swing.JLabel();
        panel_botones = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(0, 560));
        setVerifyInputWhenFocusTarget(false);

        panel_content.setBackground(new java.awt.Color(255, 255, 255));

        etq_titulo.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        etq_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_titulo.setText("ENTRADA");
        etq_titulo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 0, 0)));

        campo_placa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        campo_placa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
        campo_placa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_placaKeyPressed(evt);
            }
        });

        etq_placa.setFont(new java.awt.Font("Agency FB", 3, 24)); // NOI18N
        etq_placa.setForeground(new java.awt.Color(255, 0, 51));
        etq_placa.setText("PLACA:");

        btn_buscar_placa.setBackground(new java.awt.Color(255, 0, 0));
        btn_buscar_placa.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        btn_buscar_placa.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar_placa.setText("BUSCAR");
        btn_buscar_placa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar_placa.setFocusable(false);
        btn_buscar_placa.setPreferredSize(new java.awt.Dimension(100, 23));
        btn_buscar_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_placaActionPerformed(evt);
            }
        });

        etq_titulo_ticket.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        etq_titulo_ticket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_titulo_ticket.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 51)));

        etq_placa_carro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_placa_carro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_placa_carro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 51)));

        etq_hora_ingreso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etq_hora_ingreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_hora_ingreso.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 51)));

        etq_propietario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etq_propietario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_propietario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 51)));

        panel_botones.setBackground(new java.awt.Color(255, 255, 255));
        panel_botones.setLayout(new javax.swing.BoxLayout(panel_botones, javax.swing.BoxLayout.X_AXIS));

        javax.swing.GroupLayout panel_contentLayout = new javax.swing.GroupLayout(panel_content);
        panel_content.setLayout(panel_contentLayout);
        panel_contentLayout.setHorizontalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(etq_titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_contentLayout.createSequentialGroup()
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_contentLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(etq_placa))
                            .addComponent(campo_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_contentLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_buscar_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)))
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_propietario, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(etq_hora_ingreso, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(etq_titulo_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addComponent(etq_placa_carro, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(panel_botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );

        panel_contentLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {etq_hora_ingreso, etq_placa_carro, etq_propietario, etq_titulo_ticket});

        panel_contentLayout.setVerticalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(etq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(etq_titulo_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addComponent(etq_placa_carro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(etq_hora_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(etq_propietario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_contentLayout.createSequentialGroup()
                        .addComponent(etq_placa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campo_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscar_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(panel_botones, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_placaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_placaKeyPressed
        if (evt.getKeyChar() == '\n') {
            buscarPlaca();
        }
    }//GEN-LAST:event_campo_placaKeyPressed

    private void btn_buscar_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_placaActionPerformed
        buscarPlaca();
    }//GEN-LAST:event_btn_buscar_placaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar_placa;
    private javax.swing.JTextField campo_placa;
    private javax.swing.JLabel etq_hora_ingreso;
    private javax.swing.JLabel etq_placa;
    private javax.swing.JLabel etq_placa_carro;
    private javax.swing.JLabel etq_propietario;
    private javax.swing.JLabel etq_titulo;
    private javax.swing.JLabel etq_titulo_ticket;
    private javax.swing.JPanel panel_botones;
    private javax.swing.JPanel panel_content;
    // End of variables declaration//GEN-END:variables

    private void buscarPlaca() {
        placa = campo_placa.getText().toUpperCase();

        if (!placa.equals("")) {
            Map<String, String> insertDataFind = new HashMap<>();
            insertDataFind.put("placa", placa);
            String respuestaSelect = conexion.consumoPOST("http://localhost/APIparqueadero/vehiculos/findPlaca.php", insertDataFind);

            if (respuestaSelect != null) {
                JsonParser parser = new JsonParser();
                JsonObject registroFind = parser.parse(respuestaSelect).getAsJsonObject();
                boolean statusFind = registroFind.get("status").getAsBoolean();

                if (statusFind) {
                    insert = true;
                    String propietario = registroFind.getAsJsonObject("registros").get("propietario").getAsString();
                    String tipo = registroFind.getAsJsonObject("registros").get("tipo").getAsString();

                    etq_titulo_ticket.setForeground(Color.black);
                    etq_titulo_ticket.setText("Vehículo encontrado");
                    etq_hora_ingreso.setText(tipo);
                    etq_propietario.setText(propietario);
                    etq_placa_carro.setText(placa);

                    //---------Panel1--------------------
                    panelBtn1.setBackground(Color.white);
                    btnConfirmar = new JButton("CONFIRMAR");
                    btnConfirmar.setBackground(Color.green);
                    btnConfirmar.setForeground(Color.white);
                    btnConfirmar.setFont(new java.awt.Font("Roboto", 1, 12));
                    panelBtn1.add(btnConfirmar);
                    panel_botones.add(panelBtn1);
                    //---------Panel2---------------------
                    panelBtn2.setBackground(Color.white);
                    btnCancelar = new JButton("Cancelar");
                    btnCancelar.setBackground(Color.red);
                    btnCancelar.setForeground(Color.white);
                    btnCancelar.setFont(new java.awt.Font("Roboto", 1, 12));
                    panelBtn2.add(btnCancelar);
                    panel_botones.add(panelBtn2);

                    btnConfirmar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            insertTicket();
                        }
                    });

                    btnCancelar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            limpiarDataTicket();
                            btn_buscar_placa.setEnabled(true);
                            panelBtn1.remove(btnConfirmar);
                            panelBtn2.remove(btnCancelar);
                        }
                    });

                    this.repaint();
                    this.revalidate();
                } else {
                    limpiarDataTicket();
                    btn_buscar_placa.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "No se encontró la placa, debe registrar el vehículo");
                }
                btn_buscar_placa.setEnabled(false);
            } else {
                limpiarDataTicket();
                btn_buscar_placa.setEnabled(true);
                panelBtn1.remove(btnConfirmar);
                panelBtn2.remove(btnCancelar);
                JOptionPane.showMessageDialog(null, "No se encontró la placa, debe registrar el vehículo");
                
            }
        } else {
            limpiarDataTicket();
            btn_buscar_placa.setEnabled(true);
            panelBtn1.remove(btnConfirmar);
            panelBtn2.remove(btnCancelar);
            etq_titulo_ticket.setForeground(Color.red);
            etq_titulo_ticket.setText("Ingrese una placa valida");
        }
    }

    public void limpiarDataTicket() {
        etq_titulo_ticket.setText("");
        etq_titulo_ticket.setForeground(Color.black);
        etq_hora_ingreso.setText("");
        etq_propietario.setText("");
        etq_placa_carro.setText("");
    }

    private void insertTicket() {
            int min = 1; // Valor mínimo (inclusive)
            int max = 10000; // Valor máximo (inclusive)
            int numeroAleatorio = (int) (Math.random() * (max - min + 1)) + min;
            String numRamdon = Integer.toString(numeroAleatorio);
        if (insert) {
            Map<String, String> insertData = new HashMap<>();
            insertData.put("placa", placa);
            insertData.put("id_parqueadero", id_p);
            String respuestaInsert = conexion.consumoPOST("http://localhost/APIparqueadero/tickets/insertTicket.php", insertData);

            JsonParser parser = new JsonParser();
            JsonObject registroInsert = parser.parse(respuestaInsert).getAsJsonObject();
            boolean statusInsert = registroInsert.get("status").getAsBoolean();
            System.out.println(statusInsert);
            if (statusInsert) {
                System.out.println(registroInsert.get("mesagge").getAsString());
                String horaIngreso = registroInsert.getAsJsonObject("registros").get("hora_ingreso").getAsString();
                String propietario = registroInsert.getAsJsonObject("registros").get("propietario").getAsString();
                String placaCarro = registroInsert.getAsJsonObject("registros").get("placa").getAsString();
                String tipoCarro = registroInsert.getAsJsonObject("registros").get("tipo").getAsString();
                String vendedor = registroInsert.getAsJsonObject("registros").get("nombre").getAsString();

                Image logo = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/parqueadero-logo.png"));
                logo = logo.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
      
                etq_titulo_ticket.setForeground(Color.black);
                etq_titulo_ticket.setText("TICKET INGRESO");
                etq_hora_ingreso.setText(horaIngreso);
                etq_propietario.setText(propietario);
                etq_placa_carro.setText(placaCarro.toUpperCase());
                panelBtn1.remove(btnConfirmar);
                panelBtn2.remove(btnCancelar);
                this.repaint();
                this.revalidate();
            } else {
                limpiarDataTicket();
                btn_buscar_placa.setEnabled(true);
                panelBtn1.remove(btnConfirmar);
                panelBtn2.remove(btnCancelar);
                etq_titulo_ticket.setForeground(Color.red);
                etq_titulo_ticket.setText("El Vehiculo Ya Esta Ingresado");
            }
        } else {
            System.out.println("No se puede hacer el insert");
        }
    }
}
