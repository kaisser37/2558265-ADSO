package principal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon; 

public class Parqueadero extends javax.swing.JFrame {

    JsonObject usuario;
    ConsumoAPI conexion = new ConsumoAPI();
    JsonObject datosParqueadero;
    Gson gson = new Gson();
    String nombre;
    public Parqueadero(JsonObject usuario ) {
        String cedula = usuario.get("documento").getAsString();
        this.datosParqueadero = getDatosParqueadero(cedula);
        this.usuario = usuario;
        initComponents();
        initComponentsAltern();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        etq_cerrar_sesion = new javax.swing.JLabel();
        etq_inicio = new javax.swing.JLabel();
        panel_botones = new javax.swing.JPanel();
        btnBuscarVehiculo = new javax.swing.JButton();
        btnCosto = new javax.swing.JButton();
        btnTickets = new javax.swing.JButton();
        definirTarifas = new javax.swing.JButton();
        listaTi = new javax.swing.JButton();
        infoParq = new javax.swing.JButton();
        panel_contenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 50));

        etq_cerrar_sesion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etq_cerrar_sesion.setForeground(new java.awt.Color(255, 255, 255));
        etq_cerrar_sesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_cerrar_sesion.setText("CERRRAR SESION");
        etq_cerrar_sesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etq_cerrar_sesion.setPreferredSize(new java.awt.Dimension(158, 50));
        etq_cerrar_sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                etq_cerrar_sesionMousePressed(evt);
            }
        });

        etq_inicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etq_inicio.setForeground(new java.awt.Color(255, 255, 255));
        etq_inicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_inicio.setText("INICIO");
        etq_inicio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        etq_inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etq_inicio.setPreferredSize(new java.awt.Dimension(158, 50));
        etq_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                etq_inicioMousePressed(evt);
            }
        });

        panel_botones.setBackground(new java.awt.Color(255, 0, 0));
        panel_botones.setPreferredSize(new java.awt.Dimension(800, 200));

        btnBuscarVehiculo.setBackground(new java.awt.Color(255, 153, 153));
        btnBuscarVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscarVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarVehiculo.setBorder(null);
        btnBuscarVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarVehiculo.setFocusable(false);
        btnBuscarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVehiculoActionPerformed(evt);
            }
        });

        btnCosto.setBackground(new java.awt.Color(255, 153, 153));
        btnCosto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCosto.setForeground(new java.awt.Color(255, 255, 255));
        btnCosto.setBorder(null);
        btnCosto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCosto.setFocusable(false);
        btnCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCostoActionPerformed(evt);
            }
        });

        btnTickets.setBackground(new java.awt.Color(255, 153, 153));
        btnTickets.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTickets.setForeground(new java.awt.Color(255, 255, 255));
        btnTickets.setBorder(null);
        btnTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTickets.setFocusable(false);
        btnTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketsActionPerformed(evt);
            }
        });

        definirTarifas.setBackground(new java.awt.Color(255, 153, 153));
        definirTarifas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        definirTarifas.setForeground(new java.awt.Color(255, 255, 255));
        definirTarifas.setBorder(null);
        definirTarifas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        definirTarifas.setFocusable(false);
        definirTarifas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                definirTarifasActionPerformed(evt);
            }
        });

        listaTi.setBackground(new java.awt.Color(255, 153, 153));
        listaTi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        listaTi.setForeground(new java.awt.Color(255, 255, 255));
        listaTi.setBorder(null);
        listaTi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listaTi.setFocusable(false);
        listaTi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaTiActionPerformed(evt);
            }
        });

        infoParq.setBackground(new java.awt.Color(255, 153, 153));
        infoParq.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        infoParq.setForeground(new java.awt.Color(255, 255, 255));
        infoParq.setBorder(null);
        infoParq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoParq.setFocusable(false);
        infoParq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoParqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_botonesLayout = new javax.swing.GroupLayout(panel_botones);
        panel_botones.setLayout(panel_botonesLayout);
        panel_botonesLayout.setHorizontalGroup(
            panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_botonesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(infoParq, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(definirTarifas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarVehiculo)
                .addGap(12, 12, 12)
                .addComponent(listaTi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        panel_botonesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBuscarVehiculo, btnCosto, btnTickets, definirTarifas, infoParq, listaTi});

        panel_botonesLayout.setVerticalGroup(
            panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(definirTarifas, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btnTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCosto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaTi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoParq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_botones, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(etq_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_cerrar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_botones, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etq_cerrar_sesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etq_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_contenidoLayout = new javax.swing.GroupLayout(panel_contenido);
        panel_contenido.setLayout(panel_contenidoLayout);
        panel_contenidoLayout.setHorizontalGroup(
            panel_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        panel_contenidoLayout.setVerticalGroup(
            panel_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(panel_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(panel_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void etq_cerrar_sesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etq_cerrar_sesionMousePressed
        cerrarSesion();
    }//GEN-LAST:event_etq_cerrar_sesionMousePressed

    private void etq_inicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etq_inicioMousePressed
       panel_contenido.removeAll();

        String id_parqueadero = datosParqueadero.getAsJsonObject("registros").get("id_parqueadero").getAsString();
        JsonObject datosActuales = getParkin(id_parqueadero);
        InfoParqueadero infoParking = new InfoParqueadero(datosActuales);
        infoParking.setSize(panel_contenido.getSize());
        panel_contenido.add(infoParking);
        repaint();
        revalidate();
        
                
    }//GEN-LAST:event_etq_inicioMousePressed

    private void btnBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoActionPerformed
        panel_contenido.removeAll();
        PbuscarVehiculo buscarVehiculo = new PbuscarVehiculo();
        buscarVehiculo.setSize(panel_contenido.getSize());
        panel_contenido.add(buscarVehiculo);
        repaint();
        revalidate();
    }//GEN-LAST:event_btnBuscarVehiculoActionPerformed

    private void btnCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCostoActionPerformed
        panel_contenido.removeAll();
        String parqueadero = datosParqueadero.getAsJsonObject("registros").get("id_parqueadero").getAsString();
        PSalida salida = new PSalida(parqueadero);
        salida.setSize(panel_contenido.getSize());
        panel_contenido.add(salida);
        repaint();
        revalidate();
    }//GEN-LAST:event_btnCostoActionPerformed

    private void btnTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketsActionPerformed
        panel_contenido.removeAll();
        String parqueadero = datosParqueadero.getAsJsonObject("registros").get("id_parqueadero").getAsString();
        PEntrada entrada = new PEntrada(parqueadero);
        entrada.setSize(panel_contenido.getSize());
        panel_contenido.add(entrada);
        repaint();
        revalidate();
    }//GEN-LAST:event_btnTicketsActionPerformed

    private void definirTarifasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_definirTarifasActionPerformed
        panel_contenido.removeAll();
        DefinirTarifas tarifas = new DefinirTarifas(datosParqueadero);
        tarifas.setSize(panel_contenido.getSize());
        panel_contenido.add(tarifas);
        repaint();
        revalidate();
    }//GEN-LAST:event_definirTarifasActionPerformed

    private void listaTiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaTiActionPerformed
        String parqueadero = datosParqueadero.getAsJsonObject("registros").get("id_parqueadero").getAsString();
        panel_contenido.removeAll();
        ListaTi panelListar = new ListaTi(parqueadero);
        panelListar.setSize(panel_contenido.getSize());
        panel_contenido.add(panelListar);

        repaint();
        revalidate();
    }//GEN-LAST:event_listaTiActionPerformed

    private void infoParqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoParqActionPerformed

        panel_contenido.removeAll();

        String id_parqueadero = datosParqueadero.getAsJsonObject("registros").get("id_parqueadero").getAsString();
        JsonObject datosActuales = getParkin(id_parqueadero);
        InfoParqueadero infoParking = new InfoParqueadero(datosActuales);
        infoParking.setSize(panel_contenido.getSize());
        panel_contenido.add(infoParking);
        repaint();
        revalidate();
    }//GEN-LAST:event_infoParqActionPerformed

    private void initComponentsAltern() {
         // ICONO DE INFORMACION PARQUEADERO
        
        try {
            Image icon_09 = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icon_09.png"));
            java.awt.Image img = new ImageIcon(icon_09).getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoAjustado = new ImageIcon(img);
            infoParq.setIcon(iconoAjustado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // ICONO DE TARIFAS DEL PARQUEADERO
        try {
            Image icon_10 = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icon_10.png"));
            java.awt.Image img = new ImageIcon(icon_10).getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoAjustado = new ImageIcon(img);
            definirTarifas.setIcon(iconoAjustado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // ICONO DE EMITIR TICKET
        try {
            Image icon_12 = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icon_12.png"));
            java.awt.Image img = new ImageIcon(icon_12).getImage().getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoAjustado = new ImageIcon(img);
            btnTickets.setIcon(iconoAjustado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // ICONO DE COSTOS 
        try {
            Image icon_13 = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icon_13.png"));
            java.awt.Image img = new ImageIcon(icon_13).getImage().getScaledInstance(23, 23, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoAjustado = new ImageIcon(img);
            btnCosto.setIcon(iconoAjustado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Image icon_03 = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icon_03.png"));
            java.awt.Image img = new ImageIcon(icon_03).getImage().getScaledInstance(20, 25, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoAjustado = new ImageIcon(img);
            listaTi.setIcon(iconoAjustado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // ICONO DE BUSCAR
        try {
            Image icon_14 = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icon_14.png"));
            java.awt.Image img = new ImageIcon(icon_14).getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconoAjustado = new ImageIcon(img);
            btnBuscarVehiculo.setIcon(iconoAjustado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        nombre = this.usuario.get("nombre").getAsString().toUpperCase();
        panel_contenido.removeAll();

        String id_parqueadero = datosParqueadero.getAsJsonObject("registros").get("id_parqueadero").getAsString();
        JsonObject datosActuales = getParkin(id_parqueadero);
        InfoParqueadero infoParking = new InfoParqueadero(datosActuales);
        infoParking.setSize(panel_contenido.getSize());
        panel_contenido.add(infoParking);
        repaint();
        revalidate();
        

        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/parqueadero-logo.png")));

      

        String nombreParqueadero = "";
        String rol = this.usuario.get("rol").getAsString();
        String estado = this.usuario.get("estado").getAsString();
        String cedula = this.usuario.get("documento").getAsString();

        setTitle("Parqueadero");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JsonObject getDatosParqueadero(String id_usuario) {
        JsonObject parqueadero = null;

        Map<String, String> data = new HashMap<>();
        data.put("id_usuario", id_usuario);

        try {

            String temporal = conexion.ConsumoGET("http://localhost/APIparqueadero/parqueaderos/getParqueaderoVend.php", data);

            JsonObject jsonObject = gson.fromJson(temporal, JsonObject.class);
            parqueadero = jsonObject;
        } catch (Exception e) {
            System.out.println("Error en getDatosParqueadero");
        }
        return parqueadero;
    }
    public JsonObject getParkin(String id_parqueadero) {
        JsonObject parqueadero = null;

        Map<String, String> data = new HashMap<>();
        data.put("id_parqueadero", id_parqueadero);

        try {

            String temporal = conexion.ConsumoGET("http://localhost/APIparqueadero/parqueaderos/getParking.php", data);

            JsonObject jsonObject = gson.fromJson(temporal, JsonObject.class);
            parqueadero = jsonObject;
        } catch (Exception e) {
            System.out.println("Error en getDatosParqueadero");
        }
        return parqueadero;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarVehiculo;
    public javax.swing.JButton btnCosto;
    public javax.swing.JButton btnTickets;
    public javax.swing.JButton definirTarifas;
    private javax.swing.JLabel etq_cerrar_sesion;
    private javax.swing.JLabel etq_inicio;
    public javax.swing.JButton infoParq;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JButton listaTi;
    private javax.swing.JPanel panel_botones;
    private javax.swing.JPanel panel_contenido;
    // End of variables declaration//GEN-END:variables

    private void cerrarSesion() {
        System.out.println("Cerrando sesión");
        Login ventanaLogin = new Login();
        dispose();
    }
    
    
}
