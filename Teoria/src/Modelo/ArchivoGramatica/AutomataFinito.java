/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ArchivoGramatica;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author kevin
 */
public class AutomataFinito {
    
    private final ArrayList<Character> simbolosDeEntrada;
    private Hashtable<Estado, ArrayList<Transicion>> estados;
    private Estado estadoInicial;
    private boolean esDeterministico;
    private boolean automataSimplificado;
            
    private ServiciosAF serviciosAf;
    
      public AutomataFinito(ArrayList<Character> simbolosDeEntrada){
        this.simbolosDeEntrada = simbolosDeEntrada;
        estados = new Hashtable();
        activarServiciosAf();
    }
      private void activarServiciosAf(){
      serviciosAf = new ServiciosAF();
    }
      public ArrayList getSimbolosDeEntrada(){
      return (simbolosDeEntrada);
    }
    
}
