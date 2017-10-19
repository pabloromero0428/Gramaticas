/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.ArchivoGramatica.ArchivodeGramatica;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import teoria.Gramatica;

/**
 *
 * @author JuanPablo
 */
public class Principalgramaticas extends javax.swing.JFrame {

    /**
     * Creates new form Principalgramaticas
     */
    
    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    ArchivodeGramatica archivog = new ArchivodeGramatica();
    
    public Principalgramaticas() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
        
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principalgramaticas().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtgramatica = new javax.swing.JTextArea();
        btncargargramatica = new javax.swing.JButton();
        btnsimplificar = new javax.swing.JButton();
        btnguardargramatica = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Gramaticasimplificada = new javax.swing.JTextArea();
        txtMuertos = new javax.swing.JTextField();
        txtInalcanzables = new javax.swing.JTextField();
        txtVivos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtgramatica.setColumns(20);
        txtgramatica.setRows(5);
        txtgramatica.setEnabled(false);
        jScrollPane1.setViewportView(txtgramatica);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 347, 277));

        btncargargramatica.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btncargargramatica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Files-Folder-icon.png"))); // NOI18N
        btncargargramatica.setText("Cargar Gramatica");
        btncargargramatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargargramaticaActionPerformed(evt);
            }
        });
        getContentPane().add(btncargargramatica, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, 63));

        btnsimplificar.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btnsimplificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Simplificar.png"))); // NOI18N
        btnsimplificar.setText("Simplificar ");
        btnsimplificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimplificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnsimplificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 180, 63));

        btnguardargramatica.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btnguardargramatica.setText("Guardar gramatica");
        btnguardargramatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardargramaticaActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardargramatica, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 180, 60));

        btnmodificar.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 200, 60));

        Gramaticasimplificada.setColumns(20);
        Gramaticasimplificada.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Gramaticasimplificada.setRows(5);
        Gramaticasimplificada.setEnabled(false);
        jScrollPane2.setViewportView(Gramaticasimplificada);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 334, 277));

        txtMuertos.setEnabled(false);
        getContentPane().add(txtMuertos, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 176, 33));

        txtInalcanzables.setEnabled(false);
        getContentPane().add(txtInalcanzables, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 176, 33));

        txtVivos.setEnabled(false);
        getContentPane().add(txtVivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 176, 33));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gramatica Original");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No terminales vivos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("No terminales Muertos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("No terminales inalcanzables");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gramatica simplificada");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, -1));

        jButton1.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jButton1.setText("Guardar modificacion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 200, 60));

        jButton2.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jButton2.setText("Automata ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 529, 170, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        Gramaticasimplificada.setEnabled(true);
        txtgramatica.setEnabled(true);
        
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btnsimplificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimplificarActionPerformed
        Gramatica g = new Gramatica();
        String[] gram = g.Gramatica(txtgramatica.getText());
        txtVivos.setText(g.Vivos(gram));
        txtMuertos.setText(g.Muertos(txtVivos.getText(), gram));
        txtInalcanzables.setText(g.inalcanzables(gram));
        Gramaticasimplificada.setText(g.impresion(g.posArray,g.posAlcanzablesArray,gram));
        

    }//GEN-LAST:event_btnsimplificarActionPerformed

    private void btncargargramaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargargramaticaActionPerformed
        if(seleccionado.showDialog(null, "ABRIR ARCHIVO") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt")){
                    String contenido = archivog.AbrirArchivoTxtGramatica(archivo);
                    txtgramatica.setText(contenido);
                }else{
                    JOptionPane.showMessageDialog(null, "Por favor seleccione un archivo de texto o de imagen.");
                }
            }
        }
    }//GEN-LAST:event_btncargargramaticaActionPerformed

    private void btnguardargramaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardargramaticaActionPerformed
         if(seleccionado.showDialog(null, "GUARDAR TEXTO") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String contenido = Gramaticasimplificada.getText();
                String respuesta = archivog.GuardarATexto(archivo, contenido);
                if(respuesta!=null){
                    JOptionPane.showMessageDialog(null, respuesta);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar texto.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "El texto se debe guardar en un formato de texto.");
            }
        }
    }//GEN-LAST:event_btnguardargramaticaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Gramaticasimplificada.setEnabled(false);
        txtgramatica.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Automata a = new Automata();
    Gramatica g = new Gramatica();
    
        String[] gram = g.Gramatica(txtgramatica.getText());
        txtVivos.setText(g.Vivos(gram));
        txtMuertos.setText(g.Muertos(txtVivos.getText(), gram));
        txtInalcanzables.setText(g.inalcanzables(gram));
    a.setVisible(true);
    super.dispose();
    a.gramaticaSimplificada2.setText(g.impresion(g.posArray,g.posAlcanzablesArray,gram));
    g.generarAF(g.impresion(g.posArray,g.posAlcanzablesArray,gram));
    g.pares(g.generarAF(g.impresion(g.posArray,g.posAlcanzablesArray,gram)));
    g.impares(g.generarAF(g.impresion(g.posArray,g.posAlcanzablesArray,gram)));
    g.matriz(g.pares(g.generarAF(g.impresion(g.posArray,g.posAlcanzablesArray,gram))),g.impares(g.generarAF(g.impresion(g.posArray,g.posAlcanzablesArray,gram))));
    g.agregarComa();
    Automata s = new Automata();

    }//GEN-LAST:event_jButton2ActionPerformed

    /**u
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Principalgramaticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Principalgramaticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Principalgramaticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Principalgramaticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Principalgramaticas().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Gramaticasimplificada;
    private javax.swing.JButton btncargargramatica;
    private javax.swing.JButton btnguardargramatica;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnsimplificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtInalcanzables;
    private javax.swing.JTextField txtMuertos;
    private javax.swing.JTextField txtVivos;
    public static transient javax.swing.JTextArea txtgramatica;
    // End of variables declaration//GEN-END:variables
}
