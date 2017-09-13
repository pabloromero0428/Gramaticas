/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria;

import java.util.ArrayList;



/**
 *
 * @author JuanPablo
 */
public class Gramatica {

    public Gramatica(String archivo) {
        
       
        String[] primertoken = archivo.split(" " );
        String[]  tokenfinal= null;
        ArrayList<String> arreglotokenizado = new ArrayList<>();
        
        int var = 0;
        for (int i = 0; i < primertoken.length; i++) {
            String palabra = primertoken[i];
            tokenfinal = palabra.split("=");
            for (int j = 0; j < tokenfinal.length; j++) {
                String palabra1 = tokenfinal[j];
                arreglotokenizado.add(palabra1);                
            }
            
        }                
        String[] Gramaticatokenizada = arreglotokenizado.stream().toArray(String[]::new);
                               
        for (int i = 0; i < Gramaticatokenizada.length; i++) {
            System.out.println("Posicion: " +i + "caracater: " + Gramaticatokenizada[i]);
        }
        
    }
    
    
    
    
}
