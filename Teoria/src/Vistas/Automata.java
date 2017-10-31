/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;


import static Vistas.Principalgramaticas.txtgramatica;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import teoria.ControladorAutomata;
import teoria.Gramatica;

/**
 *
 * @author kevin
 */
public class Automata extends javax.swing.JFrame {
      
    
     JFileChooser seleccionado = new JFileChooser();
      File archivo;
      DefaultTableModel dft;
      ControladorAutomata AD;
    public Automata() {
        initComponents();
        setLocationRelativeTo(null);
        dft = new DefaultTableModel(5, 4);
        for (int i = 0; i < dft.getRowCount(); i++) {
            for (int j = 0; j < dft.getColumnCount(); j++) {
                dft.setValueAt("", i, j);
            }
            tabla.setModel(dft);
            tabla.getCellEditor(0,0).stopCellEditing();
//            tabla.addMouseListener((MouseListener) this); 
            AD= new ControladorAutomata();     
        }
    }

  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gramaticaSimplificada2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        matrix = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        estados = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        mostrarResultados = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        simplificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        hilera = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 640));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gramaticaSimplificada2.setColumns(20);
        gramaticaSimplificada2.setRows(5);
        jScrollPane1.setViewportView(gramaticaSimplificada2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 36, 280, 147));

        matrix.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(matrix);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 36, -1, 147));

        jLabel1.setBackground(new java.awt.Color(249, 249, 249));
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(251, 241, 241));
        jLabel1.setText("GRAMATICA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 7, -1, -1));

        jLabel2.setBackground(new java.awt.Color(249, 249, 249));
        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(251, 241, 241));
        jLabel2.setText("AUTOMATA DE GRAMATICA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 7, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabla);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 356, 103));

        estados.setText("Agregar estados");
        estados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadosActionPerformed(evt);
            }
        });
        getContentPane().add(estados, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 232, -1, -1));

        jButton2.setText("Agregar simbolo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 232, -1, -1));

        mostrarResultados.setColumns(20);
        mostrarResultados.setRows(5);
        jScrollPane4.setViewportView(mostrarResultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 506, -1, -1));

        jLabel3.setBackground(new java.awt.Color(249, 249, 249));
        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(251, 241, 241));
        jLabel3.setText("                                                                         PARTE INTERACTIVA");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 195, 661, -1));

        jButton1.setText("Comprobar Determinicidad");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 274, -1));

        jButton3.setText("Estados Extraños");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 304, -1, -1));

        jButton4.setText("Convertir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 304, -1, -1));

        jButton5.setText("Eliminar estado");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 279, 170, -1));

        jButton6.setText("Eliminar simbolo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 170, -1));

        simplificar.setText("Simplificar");
        simplificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simplificarActionPerformed(evt);
            }
        });
        getContentPane().add(simplificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 371, -1, -1));

        jLabel4.setBackground(new java.awt.Color(249, 249, 249));
        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(251, 241, 241));
        jLabel4.setText("Ingrese la hilera a evaluar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 423, -1, -1));
        getContentPane().add(hilera, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 418, 144, -1));

        jButton7.setText("Evaluar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 457, -1, -1));

        jButton8.setText("Guardar gramatica en txt");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo 3.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Boton que agrega estados
 * @param evt 
 */
    private void estadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadosActionPerformed
    dft.addRow(new Object[]{});
    }//GEN-LAST:event_estadosActionPerformed
/**
 * Boton que agrega simbolos
 * @param evt 
 */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    comprobarEdicionCelda();
    int ultimaColumna = dft.getColumnCount();        
        dft.addColumn("");        
        Object o;
        for (int i = 0; i < dft.getRowCount(); i++) {
            o = dft.getValueAt(i, ultimaColumna-1);
            dft.setValueAt("", i, ultimaColumna-1);
            dft.setValueAt(o, i, ultimaColumna);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
/**
 * Boton que elimina estado
 * @param evt 
 */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try{        
            dft.removeRow(tabla.getSelectedRow());
            dft.setRowCount(tabla.getRowCount());
        }catch(Exception e){
            mostrarEnArea("Seleccione la celda correspondiente a la fila a eliminar.");
        }
    }//GEN-LAST:event_jButton5ActionPerformed
/**
 * Boton que elimina simbolo
 * @param evt 
 */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try{         
            
            tabla.removeColumn(tabla.getColumnModel().getColumn(tabla.getSelectedColumn()));
            dft = (DefaultTableModel) tabla.getModel();
            String o;
            int ultimaColumna = dft.getColumnCount();  
            for (int i = 0; i < dft.getRowCount(); i++) {
                o = dft.getValueAt(i, ultimaColumna-1).toString();
                dft.setValueAt("", i, ultimaColumna-1);
                dft.setValueAt(o, i, ultimaColumna-2);
            }
            dft.setColumnCount(tabla.getColumnCount());            
        }catch(Exception e){
            mostrarEnArea("Seleccione la celda correspondiente a la columna a eliminar.");
        }
    }//GEN-LAST:event_jButton6ActionPerformed
/**
 * Boton que comprueba si es deterministico
 * @param evt 
 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      comprobarEdicionCelda();
      AD.setTabla(tabla);
        mostrarEnArea(AD.comprobarDeterministico());
    }//GEN-LAST:event_jButton1ActionPerformed
/**
 * Boton que me muestra los etsados extraños
 * @param evt 
 */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      comprobarEdicionCelda();        
        AD.setTabla(tabla);
        AD.buscarEstadosExtraños();
        dft = AD.modelo();
        tabla.setModel(dft);
    }//GEN-LAST:event_jButton3ActionPerformed
/**
 * Boton que convierte el estado de no deterministico a deterministico
 * @param evt 
 */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int ent;
        comprobarEdicionCelda();
        AD.setTabla(tabla);         
        ent=AD.pasarADeterminitico();
        AD.ordenar();
        AD.setTabla(tabla);    
        if (ent==1)
        {
            AD.buscarEstadosExtraños();
           
        }
       
        dft = AD.modelo();
        tabla.setModel(dft); 
    }//GEN-LAST:event_jButton4ActionPerformed
/**
 * Boton que simplifica el automata
 * @param evt 
 */
    private void simplificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simplificarActionPerformed
    simplificar.setEnabled(false);
        comprobarEdicionCelda();        
        AD.setTabla(tabla);
        AD.buscarEstadosExtraños();
        if(AD.comprobarDeterministico2()==1){
            AD.simplificar();            
            dft = AD.modelo();
            tabla.setModel(dft);
            AD.buscarEstadosExtraños();
        }else if(AD.comprobarDeterministico2()==0){
            mostrarEnArea("El automata es no deterministico, conviertalo a deterministico.");
        }
        else{
            mostrarEnArea("Faltan datos en la tabla.");
        }
    }//GEN-LAST:event_simplificarActionPerformed
/**
 * Boton que evalua la hilera
 * @param evt 
 */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        comprobarEdicionCelda();
        AD.setTabla(tabla);
        String a= hilera.getText();
        a = AD.seguimiento(a);
        try{
            int comprueHilera = Integer.parseInt(a);
            if(comprueHilera == 1){
                mostrarEnArea("Hilera aceptada.");
            }
            else{
                mostrarEnArea("Hilera rechazada.");
            }
        }catch(Exception e){
            mostrarEnArea(a);
        }
    }//GEN-LAST:event_jButton7ActionPerformed
/**
 * Boton que guarda el automata
 * @param evt 
 */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            FileWriter fw = new FileWriter("Tabla automata.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i = 0; i < tabla.getRowCount(); i++){//rows
                for(int j = 0; j < tabla.getColumnCount(); j++){//columns
                    bw.write(tabla.getValueAt(i, j).toString()+" ");
                }
                bw.newLine();
            }
            
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "Guardado");
        } catch (IOException ex) {        
              ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed
      
    private void comprobarEdicionCelda(){
        if(tabla.isEditing()){
            tabla.getCellEditor().stopCellEditing();            
        }
    }
    
     private void mostrarEnArea(String s){
        mostrarResultados.setText(mostrarResultados.getText()+s+"\n");
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton estados;
    public static javax.swing.JTextArea gramaticaSimplificada2;
    private javax.swing.JTextField hilera;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable matrix;
    private javax.swing.JTextArea mostrarResultados;
    private javax.swing.JButton simplificar;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
