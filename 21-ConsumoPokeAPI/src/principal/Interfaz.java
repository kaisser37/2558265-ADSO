/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package principal;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SENA
 */
public class Interfaz extends javax.swing.JPanel {

    JsonArray results;
    JsonObject pokemonInicio;

    public Interfaz(JsonArray results) {
        this.results = results;

        initComponents();

        construirBotones();
        getInformacion(pokemonInicio);
    }

    private void construirBotones() {
        JButton botones[] = new JButton[results.size()];

        for (int i = 0; i < results.size(); i++) {
            JsonObject pokemon = results.get(i).getAsJsonObject();
            String nombre = pokemon.get("name").getAsString();

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JButton boton = new JButton(nombre);
            boton.setBackground(Color.WHITE);
            boton.setFocusable(false);
            panel.add(boton, BorderLayout.CENTER);
            panel_botones.add(panel);

            botones[i] = boton;

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // CAMBIAR COLOR BOTON PRESIONADO
                    for (int j = 0; j < botones.length; j++) {
                        JButton botonPresionado = (JButton) e.getSource();
                        if (botonPresionado == botones[j]) {
                            botones[j].setForeground(Color.WHITE);
                            botones[j].setBackground(Color.BLUE);
                        } else {
                            botones[j].setForeground(Color.BLACK);
                            botones[j].setBackground(Color.WHITE);
                        }
                    }
                    // [ END ]

                    getInformacion(pokemon);
                }
            });
            // pokemon inicio default
            if (i == 0) {
                pokemonInicio = pokemon;
                botones[i].setForeground(Color.WHITE);
                botones[i].setBackground(Color.BLUE);
            }
        }
        repaint();
        revalidate();
    }

    private void getInformacion(JsonObject pokemon) {
        System.out.println("info Pokemon " + pokemon.get("name").getAsString());

        String nombre = pokemon.get("name").getAsString();
        etq_nombre.setText(nombre.toUpperCase());

        String url = pokemon.get("url").getAsString();
        JsonObject detallesPokemon = getDetallesPokemon(url);

        String url_imagen = detallesPokemon.getAsJsonObject("sprites")
                .getAsJsonObject("other")
                .getAsJsonObject("home")
                .get("front_default")
                .getAsString();

        System.out.println(url_imagen);

        try {
            URL new_url = new URL(url_imagen);
            Image imagen = ImageIO.read(new_url);

            int newWidth = 150;   // Reemplaza WIDTH con el ancho deseado
            int newHeight = 150; // Reemplaza HEIGHT con la altura deseada

            imagen = imagen.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            etq_img.setIcon(new ImageIcon(imagen));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // habilides del pokemon
        JsonArray habilidades = detallesPokemon.getAsJsonArray("abilities");
        getHabilidades(habilidades);

        repaint();
        revalidate();
    }

    private JsonObject getDetallesPokemon(String url) {
        ConsumoAPI consumo = new ConsumoAPI();
        String respuesta = consumo.consumoGET(url);

        JsonObject object = null;
        if (respuesta != null) {
            JsonParser parser = new JsonParser();
            object = parser.parse(respuesta).getAsJsonObject();
        }

        return object;
    }

    private void getHabilidades(JsonArray habilidades) {
        DefaultTableModel tableModel = (DefaultTableModel) tablaHabilidades.getModel();
        tableModel.setNumRows(0);

        for (int i = 0; i < habilidades.size(); i++) {

            JsonObject habilidad = (JsonObject) habilidades.get(i);

            String nombre_habilidad = habilidad.getAsJsonObject("ability").get("name").getAsString();
            String url_habilidad = habilidad.getAsJsonObject("ability").get("url").getAsString();
            int indice = i + 1;

            Object[] temporal = new Object[]{
                indice,
                nombre_habilidad,
                url_habilidad
            };
            tableModel.addRow(temporal);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_botones = new javax.swing.JPanel();
        etq_nombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        etq_img = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHabilidades = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("POKEDEX");

        panel_botones.setBackground(new java.awt.Color(255, 255, 255));
        panel_botones.setLayout(new javax.swing.BoxLayout(panel_botones, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(panel_botones);

        etq_nombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        etq_img.setBackground(new java.awt.Color(255, 255, 255));
        etq_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_img.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etq_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etq_img, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
        );

        tablaHabilidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N", "Habilidad", "Url"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaHabilidades);
        if (tablaHabilidades.getColumnModel().getColumnCount() > 0) {
            tablaHabilidades.getColumnModel().getColumn(0).setResizable(false);
            tablaHabilidades.getColumnModel().getColumn(0).setPreferredWidth(10);
            tablaHabilidades.getColumnModel().getColumn(1).setResizable(false);
            tablaHabilidades.getColumnModel().getColumn(1).setPreferredWidth(50);
            tablaHabilidades.getColumnModel().getColumn(2).setResizable(false);
            tablaHabilidades.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etq_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etq_img;
    private javax.swing.JLabel etq_nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_botones;
    private javax.swing.JTable tablaHabilidades;
    // End of variables declaration//GEN-END:variables
}
