/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoGramatica.ServiciosTecnicos;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class ControlServicios {
    
      private ServiciosTecnicos servicios;
    
     public ArrayList<String> tokenizarSimbolos(String cadena){
        return(servicios.tokenizar(cadena, ","));
    }
     public ArrayList<Character> convertirSimbolosDeEntrada(ArrayList<String> simbolos){
        return (servicios.arrayStringToChar(simbolos));
    }
}
