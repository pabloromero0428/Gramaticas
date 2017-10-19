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
        this.automataF.setModel(model);
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
   private void cargarAutomataVista(){
       model=gestA.cargarAutomataEnVista();
       automataF.setModel(model);
       
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
        jScrollPane2 = new javax.swing.JScrollPane();
        automataF = new javax.swing.JTable();

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

        automataF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(automataF);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(generar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simplificar)
                .addGap(248, 248, 248))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(generar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(simplificar)
                        .addGap(142, 142, 142))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        Gramatica a = new Gramatica();
        String simbolos =  a.agregarComa();
        this.crearAutomata(simbolos);
    }//GEN-LAST:event_generarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable automataF;
    private javax.swing.JTextArea automataSimplificado;
    private javax.swing.JButton generar;
    public static javax.swing.JTextArea gramaticaSimplificada2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton simplificar;
    // End of variables declaration//GEN-END:variables
}
