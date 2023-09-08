import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BuscaMinas extends JFrame {
    JPanel contenedor, f2_campo;
    JLabel f1_contador_bombas, f1_tiempo;
    JButton f1_imagen;
    JButton botones[][];

    private static final int FILAS = 9;
    private static final int COLUMNAS = 9;
    private static final int BOMBAS = 20;

    private boolean[][] bombas;
    private boolean[][] mostrados;

    public BuscaMinas() {
        componentes();
        generarBombas();
        mostrarBombasEnConsola();
        enlazarBotones();
    }

    public void componentes() {
        setTitle("Busca Minas");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        contenedor.setBorder(new EmptyBorder(15, 15, 15, 15));

        GridBagLayout gbl = new GridBagLayout();
        contenedor.setLayout(gbl);

        GridBagConstraints gcon = new GridBagConstraints();
        gcon.weightx = 1;
        gcon.weighty = 1;
        gcon.fill = GridBagConstraints.BOTH;

        //------------------PRIMERA FILA
        f1_contador_bombas = new JLabel("020");
        gcon.gridy = 0;
        gcon.gridx = 0;
        gcon.gridwidth = 1;
        gcon.weighty = 3;
        gcon.weightx = 33;
        f1_contador_bombas.setBorder(new EmptyBorder(10, 10, 10, 10));
        f1_contador_bombas.setOpaque(true);
        f1_contador_bombas.setForeground(Color.RED);
        f1_contador_bombas.setBackground(Color.BLACK);
        f1_contador_bombas.setHorizontalAlignment(SwingConstants.CENTER);
        f1_contador_bombas.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(f1_contador_bombas, gcon);

        f1_imagen = new JButton(":D");
        gcon.gridy = 0;
        gcon.gridx = 1;
        gcon.gridwidth = 1;
        gcon.weighty = 3;
        gcon.weightx = 33;
        f1_imagen.setBorder(new EmptyBorder(10, 10, 10, 10));
        f1_imagen.setOpaque(true);
        f1_imagen.setHorizontalAlignment(SwingConstants.CENTER);
        f1_imagen.setFont(new Font("Arial", Font.BOLD, 18));
        Dimension buttonSize = new Dimension(5, 5); // Establece el tamaño deseado del botón
        f1_imagen.setPreferredSize(buttonSize);
        f1_imagen.setMinimumSize(buttonSize);
        gbl.setConstraints(f1_imagen, gcon);

        f1_tiempo = new JLabel("000");
        gcon.gridy = 0;
        gcon.gridx = 2;
        gcon.gridwidth = 1;
        gcon.weighty = 3;
        gcon.weightx = 33;
        f1_tiempo.setBorder(new EmptyBorder(10, 10, 10, 10));
        f1_tiempo.setOpaque(true);
        f1_tiempo.setForeground(Color.RED);
        f1_tiempo.setBackground(Color.BLACK);
        f1_tiempo.setHorizontalAlignment(SwingConstants.CENTER);
        f1_tiempo.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(f1_tiempo, gcon);

        //------------------SEGUNDA FILA
        f2_campo = new JPanel(new GridLayout(FILAS, COLUMNAS));
        gcon.gridy = 1;
        gcon.gridx = 0;
        gcon.gridwidth = 3;
        gcon.weighty = 100;
        gcon.weightx = 100;
        f2_campo.setBorder(new EmptyBorder(0, 0, 0, 0));
        f2_campo.setOpaque(true);
        f2_campo.setForeground(Color.RED);
        f2_campo.setBackground(Color.WHITE);
        f2_campo.setFont(new Font("Arial", Font.BOLD, 18));
        gbl.setConstraints(f2_campo, gcon);

        botones = new JButton[FILAS][COLUMNAS];
        mostrados = new boolean[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                JButton boton = new JButton();
                boton.setMargin(new Insets(0, 0, 0, 0));
                f2_campo.add(boton);
                botones[i][j] = boton;
            }
        }

        //------------------PRIMERA FILA
        contenedor.add(f1_contador_bombas);
        contenedor.add(f1_imagen);
        contenedor.add(f1_tiempo);
        //------------------SEGUNDA FILA
        contenedor.add(f2_campo);

        add(contenedor);
        setVisible(true);
    }

    private void generarBombas() {
        bombas = new boolean[FILAS][COLUMNAS];
        Random random = new Random();

        int bombasGeneradas = 0;
        while (bombasGeneradas < BOMBAS) {
            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);

            if (!bombas[fila][columna]) {
                bombas[fila][columna] = true;
                bombasGeneradas++;
            }
        }
    }

    private void mostrarBombasEnConsola() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (bombas[i][j]) {
                    System.out.print("X ");
                } else {
                    System.out.print(contarBombasAlrededor(i, j) + " ");
                }
            }
            System.out.println();
        }
    }

    private int contarBombasAlrededor(int fila, int columna) {
        int contador = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i < FILAS && j >= 0 && j < COLUMNAS && bombas[i][j]) {
                    contador++;
                }
            }
        }
        return contador;
    }

    private void enlazarBotones() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                JButton boton = botones[i][j];
                final int fila = i;
                final int columna = j;
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boton.setEnabled(false);
                        mostrados[fila][columna] = true;

                        if (bombas[fila][columna]) {
                            mostrarTableroCompleto();
                            f1_imagen.setText("D:");
                            System.out.println("¡Has perdido! Has encontrado una bomba en la posición [" + fila + "][" + columna + "]");
                        } else {
                            int bombasAlrededor = contarBombasAlrededor(fila, columna);
                            boton.setText(String.valueOf(bombasAlrededor));
                            if (bombasAlrededor == 0) {
                                mostrarEspaciosCercanos(fila, columna);
                            }
                        }
                    }
                });
            }
        }
    }

    private void mostrarTableroCompleto() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (bombas[i][j]) {
                    botones[i][j].setText("X");
                } else {
                    int bombasAlrededor = contarBombasAlrededor(i, j);
                    botones[i][j].setText(String.valueOf(bombasAlrededor));
                }
                botones[i][j].setEnabled(false);
            }
        }
    }

    private void mostrarEspaciosCercanos(int fila, int columna) {
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i < FILAS && j >= 0 && j < COLUMNAS && !mostrados[i][j]) {
                    mostrados[i][j] = true;

                    int bombasAlrededor = contarBombasAlrededor(i, j);
                    botones[i][j].setText(String.valueOf(bombasAlrededor));
                    botones[i][j].setEnabled(false);

                    if (bombasAlrededor == 0) {
                        mostrarEspaciosCercanos(i, j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BuscaMinas();
            }
        });
    }
}
