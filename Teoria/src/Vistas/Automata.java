/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.ControlAutomata;
import Controlador.ControlServicios;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import teoria.Gramatica;

/**
 *
 * @author kevin
 */
public class Automata extends javax.swing.JFrame {

    private DefaultTableModel model;
    private ControlAutomata controlA;
    private GestionAutomata gestA;
    private ControlServicios controlS;
   
    
    
   public Automata() {
    initComponents();    
    }
   
   public void setControladores(DefaultTableModel model,ControlAutomata controlA,GestionAutomata gestA,ControlServicios controlS){
      this.model=model;
      this.gestA=gestA;
      this.controlA=controlA;
      this.controlS= controlS;
      this.gestA.setControlAutomata(controlA);
      this.gestA.setControladorServicios(controlS);
   }
   
   public void crearAutomata(String simbolosDeEntrada ){
       ArrayList<String> simbolos = controlS.tokenizarSimbolos(simbolosDeEntrada); 
       this.gestA.crearAutomata(simbolos);
       Object[]cabecera = crearCabecera(simbolos);
       nuevoModelo(cabecera);
       
   }
   
     private void nuevoModelo(Object[] nombreColumnas){
        model = new DefaultTableModel();
        model.setColumnIdentifiers(nombreColumnas);
        this.automataf.setModel(model);
    }
     
   private Object[] crearCabecera(ArrayList<String> simbolos){
        int tamaño = simbolos.size()+2;
        Object[] cabecera = new Object[tamaño];
        cabecera[0] = "Estado";
        cabecera[tamaño-1] = "Aceptacion";
        for(int i=0; i<tamaño-2; i++){
            cabecera[i+1] = simbolos.get(i);
        }return(cabecera);
   
    
   }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gramaticaSimplificada2 = new javax.swing.JTextArea();
        simplificar = new javax.swing.JButton();
        generar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        automataSimplificado = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        automataf = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gramaticaSimplificada2.setColumns(20);
        gramaticaSimplificada2.setRows(5);
        jScrollPane1.setViewportView(gramaticaSimplificada2);

        simplificar.setText("simplificar");

        generar.setText("Generar automata ");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });

        automataSimplificado.setColumns(20);
        automataSimplificado.setRows(5);
        jScrollPane3.setViewportView(automataSimplificado);

        automataf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(automataf);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(generar)
                        .addGap(145, 145, 145)
                        .addComponent(simplificar)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(generar)
                    .addComponent(simplificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
           
    }//GEN-LAST:event_generarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea automataSimplificado;
    private javax.swing.JTable automataf;
    private javax.swing.JButton generar;
    public static javax.swing.JTextArea gramaticaSimplificada2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton simplificar;
    // End of variables declaration//GEN-END:variables
}
