/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstras;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Noe
 */
public class InterfazGrafica extends javax.swing.JFrame {

    /**
     * Creates new form InterfazGrafica
     */
    public int numeroVerticesGrafo = 0;
    int vertices;
    int[][] arreglo;

    public InterfazGrafica() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonEscenario1 = new javax.swing.JButton();
        BotonEscenario2 = new javax.swing.JButton();
        EtiquetaImagen = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaTextodeRespuestaMatriz = new javax.swing.JTextArea();
        BotonEscenario3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaTextodeRespuesta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(10, 80, 300, 300));
        setMinimumSize(new java.awt.Dimension(400, 1000));
        getContentPane().setLayout(null);

        BotonEscenario1.setText("Escenario 1");
        BotonEscenario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEscenario1MouseClicked(evt);
            }
        });
        getContentPane().add(BotonEscenario1);
        BotonEscenario1.setBounds(10, 10, 97, 23);

        BotonEscenario2.setText("Escenario 2");
        BotonEscenario2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEscenario2MouseClicked(evt);
            }
        });
        getContentPane().add(BotonEscenario2);
        BotonEscenario2.setBounds(150, 10, 99, 23);

        EtiquetaImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EtiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dijkstras/Universidad_de_Lima_logo.png"))); // NOI18N
        EtiquetaImagen.setText("");
        EtiquetaImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        EtiquetaImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EtiquetaImagen.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        getContentPane().add(EtiquetaImagen);
        EtiquetaImagen.setBounds(40, 40, 320, 180);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        AreaTextodeRespuestaMatriz.setColumns(20);
        AreaTextodeRespuestaMatriz.setRows(5);
        jScrollPane2.setViewportView(AreaTextodeRespuestaMatriz);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 10, 320, 200);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 270, 380, 220);

        BotonEscenario3.setText("Escenario 3");
        BotonEscenario3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEscenario3MouseClicked(evt);
            }
        });
        getContentPane().add(BotonEscenario3);
        BotonEscenario3.setBounds(280, 10, 99, 23);

        AreaTextodeRespuesta.setEditable(false);
        AreaTextodeRespuesta.setColumns(20);
        AreaTextodeRespuesta.setRows(5);
        AreaTextodeRespuesta.setMinimumSize(new java.awt.Dimension(4, 50));
        AreaTextodeRespuesta.setPreferredSize(new java.awt.Dimension(164, 200));
        jScrollPane1.setViewportView(AreaTextodeRespuesta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 510, 370, 320);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEscenario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEscenario1MouseClicked
        long startTime = System.currentTimeMillis();
        String cadena = "";
        String cadenaux = "";
        String cadenaux2 = "";
        String matriz = "La matriz ingresada es: ";

        int[][] grafo1 = new int[0][0];

        int tamaño = 0;
        int origen = 0;

        int aux = 0;
        int aux2 = 0;

        try {//primero: definimos la ubicación del archivo en una variable 
            //ademas, leemos el archivo, con la clase BufferReader
            FileReader ubicacion = new FileReader("C:\\Users\\USER\\Desktop\\2020-2\\Redes\\Trabajo\\prueba1.txt");
            BufferedReader lector = new BufferedReader(ubicacion);

            while ((cadena = lector.readLine()) != null) {
                for (int i = 0; i < cadena.length(); i++) {
                    cadenaux = cadenaux + String.valueOf(cadena.charAt(i));
                }
                if (aux == 14) {
                    tamaño = Integer.parseInt(cadenaux);
                    //creamos el grafo de tamaño que extraigamos del txt
                    grafo1 = new int[tamaño][tamaño];

                    for (int i = 0; i < tamaño; i++) {
                        for (int j = 0; j < tamaño; j++) {

                            grafo1[i][j] = 0;

                        }
                    }
                    //----------------------------------------------------
                    //a partir de la linea 12, comienza a leer los pesos de los caminos
                } else if (aux == 15) {

                    origen = Integer.parseInt(cadenaux);

                } else if (aux > 15) {
                    int aux3 = 0;
                    for (int k = 0; k < cadena.length(); k++) {
                        if (cadena.charAt(k) != 46) {
                            cadenaux2 = cadenaux2 + String.valueOf(cadena.charAt(k));

                        } else if (cadena.charAt(k) == 46) {
                            // System.out.print(cadenaux2);
                            grafo1[aux2][aux3] = Integer.parseInt(cadenaux2);
                            aux3++;
                            cadenaux2 = "";

                        }

                    }
                    aux2++;

                }

                aux++;
                cadenaux = "";

            }
            //System.out.println(aux);

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < tamaño; i++) {
            matriz = matriz + "\n";
            for (int j = 0; j < tamaño; j++) {
                matriz = matriz + grafo1[i][j] + ", ";
            }
        }
        //int dimensiones = this.getContentPane().getSize().width / 2 - this.Imagen.getSize().width / 2;
        //  JOptionPane.showMessageDialog(null, dimensiones);
        //  JOptionPane.showMessageDialog(null, Imagen.getSize().width);
        CaminoMasCorto t = new CaminoMasCorto();

        this.AreaTextodeRespuesta.setText(t.ImprimirVectorCaminoMasCorto(t.Algoritmo_Dijkstra(grafo1, origen, tamaño), tamaño));
        long endTime = System.currentTimeMillis() - startTime;
        matriz = matriz + "\ntiempo de procesamiento: " + endTime;
        this.AreaTextodeRespuestaMatriz.setText(matriz);
        ImageIcon ImagenAux = new ImageIcon("Escenario1.png");

        EtiquetaImagen.setIcon(
                new javax.swing.ImageIcon(ImagenAux.getImage().getScaledInstance(this.EtiquetaImagen.getWidth(), this.EtiquetaImagen.getHeight(), Image.SCALE_SMOOTH)));
    }//GEN-LAST:event_BotonEscenario1MouseClicked

    private void BotonEscenario2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEscenario2MouseClicked
        long startTime = System.currentTimeMillis();
        String cadena = "";
        String cadenaux = "";
        String cadenaux2 = "";
        String matriz = "La matriz ingresada es: ";

        int[][] grafo2 = new int[0][0];

        int tamaño = 0;
        int origen = 0;

        int aux = 0;
        int aux2 = 0;

        try {//primero: definimos la ubicación del archivo en una variable 
            //ademas, leemos el archivo, con la clase BufferReader
            FileReader ubicacion = new FileReader("C:\\Users\\USER\\Desktop\\2020-2\\Redes\\Trabajo\\prueba2.txt");
            BufferedReader lector = new BufferedReader(ubicacion);

            while ((cadena = lector.readLine()) != null) {
                for (int i = 0; i < cadena.length(); i++) {
                    cadenaux = cadenaux + String.valueOf(cadena.charAt(i));
                }
                if (aux == 14) {
                    tamaño = Integer.parseInt(cadenaux);
                    //creamos el grafo de tamaño que extraigamos del txt
                    grafo2 = new int[tamaño][tamaño];

                    for (int i = 0; i < tamaño; i++) {
                        for (int j = 0; j < tamaño; j++) {

                            grafo2[i][j] = 0;

                        }
                    }
                    //----------------------------------------------------
                    //a partir de la linea 12, comienza a leer los pesos de los caminos
                } else if (aux == 15) {

                    origen = Integer.parseInt(cadenaux);

                } else if (aux > 15) {
                    int aux3 = 0;
                    for (int k = 0; k < cadena.length(); k++) {
                        if (cadena.charAt(k) != 46) {
                            cadenaux2 = cadenaux2 + String.valueOf(cadena.charAt(k));

                        } else if (cadena.charAt(k) == 46) {
                            // System.out.print(cadenaux2);
                            grafo2[aux2][aux3] = Integer.parseInt(cadenaux2);
                            aux3++;
                            cadenaux2 = "";

                        }

                    }
                    aux2++;

                }

                aux++;
                cadenaux = "";

            }
            //System.out.println(aux);

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < tamaño; i++) {
            matriz = matriz + "\n";
            for (int j = 0; j < tamaño; j++) {
                matriz = matriz + grafo2[i][j] + ", ";
            }
        }
        //int dimensiones = this.getContentPane().getSize().width / 2 - this.Imagen.getSize().width / 2;
        //  JOptionPane.showMessageDialog(null, dimensiones);
        //  JOptionPane.showMessageDialog(null, Imagen.getSize().width);
        CaminoMasCorto t = new CaminoMasCorto();

        this.AreaTextodeRespuesta.setText(t.ImprimirVectorCaminoMasCorto(t.Algoritmo_Dijkstra(grafo2, origen, tamaño), tamaño));
        long endTime = System.currentTimeMillis() - startTime;
        matriz = matriz + "\ntiempo de procesamiento: " + endTime;
        this.AreaTextodeRespuestaMatriz.setText(matriz);
        ImageIcon ImagenAux = new ImageIcon("Escenario2.png");

        EtiquetaImagen.setIcon(
                new javax.swing.ImageIcon(ImagenAux.getImage().getScaledInstance(this.EtiquetaImagen.getWidth(), this.EtiquetaImagen.getHeight(), Image.SCALE_SMOOTH)));
    }//GEN-LAST:event_BotonEscenario2MouseClicked

    private void BotonEscenario3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEscenario3MouseClicked
        long startTime = System.currentTimeMillis();
        String cadena = "";
        String cadenaux = "";
        String cadenaux2 = "";
        String matriz = "La matriz ingresada es: ";

        int[][] grafo3 = new int[0][0];

        int tamaño = 0;
        int origen = 0;

        int aux = 0;
        int aux2 = 0;

        try {//primero: definimos la ubicación del archivo en una variable 
            //ademas, leemos el archivo, con la clase BufferReader
            FileReader ubicacion = new FileReader("C:\\Users\\USER\\Desktop\\2020-2\\Redes\\Trabajo\\prueba3.txt");
            BufferedReader lector = new BufferedReader(ubicacion);

            while ((cadena = lector.readLine()) != null) {
                for (int i = 0; i < cadena.length(); i++) {
                    cadenaux = cadenaux + String.valueOf(cadena.charAt(i));
                }
                if (aux == 14) {
                    tamaño = Integer.parseInt(cadenaux);
                    //creamos el grafo de tamaño que extraigamos del txt
                    grafo3 = new int[tamaño][tamaño];

                    for (int i = 0; i < tamaño; i++) {
                        for (int j = 0; j < tamaño; j++) {

                            grafo3[i][j] = 0;

                        }
                    }
                    //----------------------------------------------------
                    //a partir de la linea 12, comienza a leer los pesos de los caminos
                } else if (aux == 15) {

                    origen = Integer.parseInt(cadenaux);

                } else if (aux > 15) {
                    int aux3 = 0;
                    for (int k = 0; k < cadena.length(); k++) {
                        if (cadena.charAt(k) != 46) {
                            cadenaux2 = cadenaux2 + String.valueOf(cadena.charAt(k));

                        } else if (cadena.charAt(k) == 46) {
                            // System.out.print(cadenaux2);
                            grafo3[aux2][aux3] = Integer.parseInt(cadenaux2);
                            aux3++;
                            cadenaux2 = "";

                        }

                    }
                    aux2++;

                }

                aux++;
                cadenaux = "";

            }
            //System.out.println(aux);

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < tamaño; i++) {
            matriz = matriz + "\n";
            for (int j = 0; j < tamaño; j++) {
                matriz = matriz + grafo3[i][j] + ", ";
            }
        }
        //int dimensiones = this.getContentPane().getSize().width / 2 - this.Imagen.getSize().width / 2;
        //  JOptionPane.showMessageDialog(null, dimensiones);
        //  JOptionPane.showMessageDialog(null, Imagen.getSize().width);
        CaminoMasCorto t = new CaminoMasCorto();

        this.AreaTextodeRespuesta.setText(t.ImprimirVectorCaminoMasCorto(t.Algoritmo_Dijkstra(grafo3, origen, tamaño), tamaño));
        long endTime = System.currentTimeMillis() - startTime;
        matriz = matriz + "\ntiempo de procesamiento: " + endTime;
        this.AreaTextodeRespuestaMatriz.setText(matriz);
        ImageIcon ImagenAux = new ImageIcon("Escenario3.png");

        EtiquetaImagen.setIcon(
                new javax.swing.ImageIcon(ImagenAux.getImage().getScaledInstance(this.EtiquetaImagen.getWidth(), this.EtiquetaImagen.getHeight(), Image.SCALE_SMOOTH)));
    }//GEN-LAST:event_BotonEscenario3MouseClicked

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaTextodeRespuesta;
    private javax.swing.JTextArea AreaTextodeRespuestaMatriz;
    private javax.swing.JButton BotonEscenario1;
    private javax.swing.JButton BotonEscenario2;
    private javax.swing.JButton BotonEscenario3;
    private javax.swing.JLabel EtiquetaImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
