/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.ControlAutomata;
import Controlador.ControlServicios;
import static Vistas.Principalgramaticas.txtgramatica;
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
        jScrollPane3 = new javax.swing.JScrollPane();
        automataSimplificado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        matrix = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gramaticaSimplificada2.setColumns(20);
        gramaticaSimplificada2.setRows(5);
        jScrollPane1.setViewportView(gramaticaSimplificada2);

        simplificar.setText("simplificar");

        automataSimplificado.setColumns(20);
        automataSimplificado.setRows(5);
        jScrollPane3.setViewportView(automataSimplificado);

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

        jLabel1.setText("GRAMATICA");

        jLabel2.setText("AUTOMATA DE GRAMATICA");

        jLabel3.setText("AUTOMATA SIMPLIFICADO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(simplificar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simplificar)
                        .addGap(181, 181, 181))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea automataSimplificado;
    public static javax.swing.JTextArea gramaticaSimplificada2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable matrix;
    private javax.swing.JButton simplificar;
    // End of variables declaration//GEN-END:variables
}
