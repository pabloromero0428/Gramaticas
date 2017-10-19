/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ArchivoGramatica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * @author kevin
 */
public class ServiciosAF {
    
    public ArrayList<Estado> ordenarEstados(AutomataFinito automata, Enumeration<Estado> estados){
        
        ArrayList<Estado> lista = new ArrayList();
        Estado estInicial = automata.getEstadoInicial(), est;
        while(estados.hasMoreElements()){
            est = estados.nextElement();
            if(!est.equals(estInicial)){
                lista.add(est);
            }
        }
        lista.add(estInicial);
        return(lista);
    }
      public void completarSort(ArrayList<Estado> estadosOrdenados) {
        Estado estInicial = estadosOrdenados.get(estadosOrdenados.size()-1);
        for(int i=estadosOrdenados.size()-1; i>0; i--){
            estadosOrdenados.set(i, estadosOrdenados.get(i-1));
        }
        estadosOrdenados.set(0, estInicial);
    }
}
