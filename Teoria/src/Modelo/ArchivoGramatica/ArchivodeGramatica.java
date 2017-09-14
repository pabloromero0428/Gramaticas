/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ArchivoGramatica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author JuanPablo
 */
public class ArchivodeGramatica {
    
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;

    public ArchivodeGramatica() {
        
    }
    
    /**
     * Este Metodo abre el archivo de texto en el cual se encuentra la gramatica
     * @param archivo
     * @return 
     */
    public String AbrirArchivoTxtGramatica(File archivo){
        String contenido="";
        try {
            entrada = new FileInputStream(archivo);
            int txtgram;
            while((txtgram = entrada.read())!= -1){
                char carcater = (char)txtgram;
                contenido += carcater;
            }
        } catch (Exception e) {
        }
        return contenido;
    }
    
    
}