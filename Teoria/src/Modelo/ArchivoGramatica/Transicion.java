/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ArchivoGramatica;

/**
 *
 * @author kevin
 */
public class Transicion {
        private char simbolo;
    private Estado destino;

    public Transicion(char simbolo, Estado estado){
        this.simbolo = simbolo;
        this.destino = estado;
    }
    
    public char getSimbolo() {
        return simbolo;
    }

    public Estado getDestino() {
        return destino;
    }
    
    public void setDestino(Estado estadoDestino){
        this.destino = estadoDestino;
    }

    
}
