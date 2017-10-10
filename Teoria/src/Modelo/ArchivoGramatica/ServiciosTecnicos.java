/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ArchivoGramatica;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author kevin
 */
public class ServiciosTecnicos {
      public ArrayList<String> tokenizar(String cadena, String separador){
        ArrayList<String> lista = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(cadena, separador);
        while(st.hasMoreElements()){
            lista.add(st.nextToken());
        }return (lista);
    }
       public ArrayList arrayStringToChar(ArrayList<String> lista){
        ArrayList<Character> nuevaLista = new ArrayList<Character>();
        Character simbolo;
        for(int i=0; i < lista.size(); i++){
            simbolo = lista.get(i).charAt(0);
            nuevaLista.add(simbolo);
        }return(nuevaLista);
    }
    
}
