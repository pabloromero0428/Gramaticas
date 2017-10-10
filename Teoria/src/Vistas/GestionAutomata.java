/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.ControlAutomata;
import Controlador.ControlServicios;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class GestionAutomata {
    
    private ControlAutomata controlA;
    private ControlServicios controlS;
    
     public void setControlAutomata(ControlAutomata control){
        this.controlA = control;
    }
     public void setControladorServicios(ControlServicios controlS){
        this.controlS = controlS;
    }
      public void crearAutomata(ArrayList<String> simbolos){
        ArrayList<Character> simbolosDeEntrada = controlS.convertirSimbolosDeEntrada(simbolos);
        controlA.crearAutomata(simbolosDeEntrada);
    }
    
}
