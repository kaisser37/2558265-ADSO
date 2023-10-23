/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package principal;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject; 
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols; 


public class DefinirTarifas extends javax.swing.JPanel {

    ConsumoAPI conexion = new ConsumoAPI();
    Gson gson = new Gson();

    JsonObject datosParqueadero;
    public DefinirTarifas(JsonObject datosParqueadero) {
        this.datosParqueadero = datosParqueadero;
        initComponents();
        initComponentsAlter();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        etq_nombre = new javax.swing.JLabel();
        campo_carro = new javax.swing.JTextField();
        etq_direccion = new javax.swing.JLabel();
        campo_moto = new javax.swing.JTextField();
        etq_nombre2 = new javax.swing.JLabel();
        campo_camion = new javax.swing.JTextField();
        etq_direccion1 = new javax.swing.JLabel();
        campo_camioneta = new javax.swing.JTextField();
        btn_definir = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(0, 560));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DEFINIR TARIFAS");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        etq_nombre.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        etq_nombre.setForeground(new java.awt.Color(255, 51, 51));
        etq_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_nombre.setText("CARRO");

        campo_carro.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        campo_carro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campo_carro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));

        etq_direccion.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        etq_direccion.setForeground(new java.awt.Color(255, 51, 51));
        etq_direccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_direccion.setText("MOTO");

        campo_moto.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        campo_moto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campo_moto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));

        etq_nombre2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        etq_nombre2.setForeground(new java.awt.Color(255, 51, 51));
        etq_nombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_nombre2.setText("CAMION");

        campo_camion.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        campo_camion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campo_camion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));

        etq_direccion1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        etq_direccion1.setForeground(new java.awt.Color(255, 51, 51));
        etq_direccion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_direccion1.setText("CAMIONETA");

        campo_camioneta.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        campo_camioneta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campo_camioneta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));

        btn_definir.setBackground(new java.awt.Color(255, 51, 51));
        btn_definir.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_definir.setForeground(new java.awt.Color(255, 255, 255));
        btn_definir.setText("DEFINIR");
        btn_definir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_definir.setFocusable(false);
        btn_definir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_definirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(etq_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etq_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(campo_carro, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(campo_moto, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(campo_camion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campo_camioneta, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(etq_nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etq_direccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(btn_definir, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {etq_direccion, etq_direccion1, etq_nombre, etq_nombre2});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_direccion)
                    .addComponent(etq_nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_carro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_moto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_nombre2)
                    .addComponent(etq_direccion1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_camion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_camioneta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btn_definir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_definirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_definirActionPerformed
        String moto = campo_moto.getText().replaceAll("\\.", "");
        String carro = campo_carro.getText().replaceAll("\\.", "");
        String camioneta = campo_camioneta.getText().replaceAll("\\.", "");
        String camion = campo_camion.getText().replaceAll("\\.", "");
        String id_parqueadero = datosParqueadero.getAsJsonObject("registros").get("id_parqueadero").getAsString();
        
        Map<String, String> datosTarifas = new HashMap<>();
        datosTarifas.put("camioneta", camioneta);
        datosTarifas.put("carro", carro);
        datosTarifas.put("moto", moto);
        datosTarifas.put("camion", camion);
        datosTarifas.put("id_parqueadero", id_parqueadero);

        try {
            conexion.consumoPOST("http://localhost/APIparqueadero/vendedores/definirTarifas.php", datosTarifas);
            JOptionPane.showMessageDialog(null, "Tarifas Actualizadas Con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Intentalo de nuevo");
        }
    }//GEN-LAST:event_btn_definirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_definir;
    private javax.swing.JTextField campo_camion;
    private javax.swing.JTextField campo_camioneta;
    private javax.swing.JTextField campo_carro;
    private javax.swing.JTextField campo_moto;
    private javax.swing.JLabel etq_direccion;
    private javax.swing.JLabel etq_direccion1;
    private javax.swing.JLabel etq_nombre;
    private javax.swing.JLabel etq_nombre2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void initComponentsAlter() {
        soloNumeros(campo_moto);
        soloNumeros(campo_camion);
        soloNumeros(campo_camioneta);
        soloNumeros(campo_carro);
        try {
            String id_parqueadero = datosParqueadero.getAsJsonObject("registros").get("id_parqueadero").getAsString();
            System.out.println(id_parqueadero);
            Map<String, String> datosTarifas = new HashMap<>();
            datosTarifas.put("id", id_parqueadero);
            String tarifas = conexion.ConsumoGET("http://localhost/APIparqueadero/vendedores/getTarifas.php", datosTarifas);
            JsonObject jsonObject = gson.fromJson(tarifas, JsonObject.class);
 
            JsonArray  registros = jsonObject.getAsJsonArray("tarifas");
            JsonObject tarifa = registros.get(0).getAsJsonObject();
            if (tarifa.size() > 0) {
                String camion = formatoMoneda(tarifa.get("camiones").getAsString());
                String carro = formatoMoneda( tarifa.get("carro").getAsString());
                String camioneta = formatoMoneda( tarifa.get("camioneta").getAsString());
                String moto = formatoMoneda(tarifa.get("moto").getAsString());

                campo_camion.setText(camion);
                campo_camioneta.setText(camioneta);
                campo_carro.setText(carro);
                campo_moto.setText(moto);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void soloNumeros(JTextField campo){
        PlainDocument doc = (PlainDocument) campo.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (esNumero(string)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (esNumero(text)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean esNumero(String text) {
                return text.matches("^[0-9]*\\.?[0-9]*$");
            }
        });
    }
    
    public static String formatoMoneda(String numeroString) {
        try {
            // Parsea el valor de la cadena a float
            float numero = Float.parseFloat(numeroString);

            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator('.');
            symbols.setDecimalSeparator(',');
            String pattern = "###,###,###,###.##"; // Patrón para el formato de moneda colombiana

            DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
            return decimalFormat.format(numero);
        } catch (NumberFormatException e) {
            // Manejo de excepciones en caso de que la cadena no sea un número válido
            return "Formato no válido";
        }
    }
}
