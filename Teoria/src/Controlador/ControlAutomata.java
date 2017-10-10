/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.ArchivoGramatica.AutomataFinito;
import Modelo.ArchivoGramatica.ServiciosAF;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class ControlAutomata {
    
     private AutomataFinito automata;
     private ServiciosAF serviciosAf;
     
      public void setServiciosAf(ServiciosAF servicios){
        this.serviciosAf = servicios;
    }
    
     public void crearAutomata(ArrayList<Character> simbolosDeEntrada){
         
        automata = new AutomataFinito(simbolosDeEntrada);
    }
    
       public String[] cabeceraParaModelo(){
        ArrayList simbolos = automata.getSimbolosDeEntrada();
        int totalSimbolos = simbolos.size();
        String[] cabecera = new String[totalSimbolos+2];
        cabecera[0] = "Estado";
        cabecera[totalSimbolos+1] = "Aceptacion";
        int i=1;
        for(Object simbolo: simbolos){
            cabecera[i] = simbolo.toString();
            i++;
        }return(cabecera);
    }
}
