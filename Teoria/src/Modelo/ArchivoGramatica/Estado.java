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
public class Estado {
    
    private String id;
    private boolean estadoDeAceptacion;
    private boolean estadoUnificado;

     public Estado(String nombre, boolean estAceptacion){
         
        this.id = nombre;
        this.estadoDeAceptacion = estAceptacion;
        this.estadoUnificado = false;
    }
    
     public String getId() {
        return id;
    }
        public boolean esEstadoDeAceptacion() {
        return estadoDeAceptacion;
    }
}
