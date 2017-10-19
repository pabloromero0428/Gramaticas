/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.ArchivoGramatica.AutomataFinito;
import Modelo.ArchivoGramatica.Estado;
import Modelo.ArchivoGramatica.ServiciosAF;
import Modelo.ArchivoGramatica.Transicion;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

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
       
       public String[][] dataParaModelo(){
        ArrayList simbolos = automata.getSimbolosDeEntrada();
        Hashtable dataAutomata = automata.getEstados();
        int totalColumnas = simbolos.size()+2, posicion;
        String[][] data = new String[dataAutomata.size()][totalColumnas];
        Estado est;
        Transicion transicion;
        String estadoDestino;
        char simbolo;
        Enumeration<Estado> estados = dataAutomata.keys();
        ArrayList<Transicion> transiciones;
        ArrayList<Estado> estadosOrdenados = serviciosAf.ordenarEstados(automata, estados);
        serviciosAf.completarSort(estadosOrdenados);
        int posicionSimbolo, i = 0; 
        for(int j=0; j<estadosOrdenados.size(); j++){
            est = estadosOrdenados.get(j);
            transiciones = (ArrayList<Transicion>)dataAutomata.get(est);
            data[i][0] = est.getId();
            if(est.esEstadoDeAceptacion())
                data[i][totalColumnas-1] = "1";
            else
                data[i][totalColumnas-1] = "0";
            transiciones = (ArrayList<Transicion>)dataAutomata.get(est);
            for(int k=0; k < transiciones.size(); k++){
                transicion = transiciones.get(k);
                simbolo = transicion.getSimbolo();
                posicion = (simbolos.indexOf(simbolo))+1;
                if(transicion.getDestino() == null)
                    estadoDestino = "";
                else
                    estadoDestino = transicion.getDestino().getId();
                if(data[i][posicion] == null)
                    data[i][posicion] = estadoDestino;
                else{
                    data[i][posicion] = data[i][posicion]+","+estadoDestino;
                }
            }i++;
        }
        return(data);
    }
}
