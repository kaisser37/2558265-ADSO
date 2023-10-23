/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package principal;

import appparqueadero.ConsumoAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.swing.JButton;

/**
 *
 * @author SENA
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();

        setLocationRelativeTo(null);
        setVisible(true);

        pantallaCarga();
        consumoApi();

    }

    private void consumoApi() {
        ConsumoAPI consumo = new ConsumoAPI();
        String respuesta = consumo.consumoGET("https://pokeapi.co/api/v2/pokemon");

        if (respuesta != null) {
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(respuesta).getAsJsonObject();

            JsonArray results = object.getAsJsonArray("results");

            cargarInterfaz(results);
        } else {
            pantallaConexion();
        }

    }

    private void cargarInterfaz(JsonArray results) {
        panel_principal.removeAll();

        Interfaz interfaz = new Interfaz(results);
        interfaz.setSize(panel_principal.getSize());
        panel_principal.add(interfaz);

        repaint();
        revalidate();
    }

    private void pantallaCarga() {
        panel_principal.removeAll();

        PantallaCarga loader = new PantallaCarga();
        loader.setSize(panel_principal.getSize());
        panel_principal.add(loader);

        repaint();
        validate();
    }

    private void pantallaConexion() {
        panel_principal.removeAll();

        Conexion pantalla = new Conexion();
        pantalla.setSize(panel_principal.getSize());
        panel_principal.add(pantalla);

        repaint();
        validate();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        panel_principal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel_principal;
    // End of variables declaration//GEN-END:variables
}
