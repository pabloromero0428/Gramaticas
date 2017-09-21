/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author JuanPablo
 */
public class Gramatica {

    public ArrayList<Integer> posArray = new ArrayList<Integer>();
    public ArrayList<Integer> posAlcanzablesArray = new ArrayList<Integer>();
    public String NVivos;
    public String NMuertos;
    public String NInalcanzables;
    public String Nuevaimpresion;

    public Gramatica() {
    }

   /**
    * METODO EL CUAL CREA UN ARREGLO CON LOS ELEMENTOS DE LA GRAMATICA
    * @param archivo
    * @return 
    */
    public String[] Gramatica(String archivo) {

        String[] primertoken = archivo.split("\n");//arreglo con cada reglos del texto(el cual tiene la gramatica)
        String[] tokenfinal = null;// arreglo que tendra de cada renglon el string antes y despues del =
        ArrayList<String> arreglotokenizado = new ArrayList<>(); //arraylist para almacenar todos os elementos separados      
        for (int i = 0; i < primertoken.length; i++) { 
            String palabra = primertoken[i]; //String que almacena la palabra i del primer arreglo
            tokenfinal = palabra.split("="); 
            for (int j = 0; j < tokenfinal.length; j++) {
                String palabra1 = tokenfinal[j]; //String que almacena la palabra j del segundo arreglo
                arreglotokenizado.add(palabra1);
            }
        }
        String[] Gramaticatokenizada = arreglotokenizado.stream().toArray(String[]::new);       

        return(Gramaticatokenizada);
    }

    /**
     *
     * @param gramatica
     * @return
     */
    public String Vivos(String[] gramatica) {

        ArrayList<String> TV = new ArrayList<>();
        ArrayList<String> NVivos = new ArrayList<>();
        ArrayList<Integer> actual = new ArrayList<Integer>();
        String Nvivos = "";
        boolean hayVivos = false;

        for (int i = 0; i < gramatica.length; i++) {
            if (i % 2 != 0) {
                String posicion = gramatica[i];
                posicion = posicion.trim();
                int encontrado = posicion.indexOf("<");
                if (encontrado == -1) {
                    TV.add(posicion);
                    String Nviv = gramatica[i - 1];
                    actual.add(i);
                    NVivos.add(Nviv);
                    posArray.add(i - 1);
                    Nvivos = Nvivos.concat(Nviv);
                    hayVivos = true;
                }
            }
        }

        if (hayVivos == false) {
            JOptionPane.showMessageDialog(null, "NO HAY VIVOS NI MUERTOS");
        }

        while (hayVivos == true) {
            int conteo = 0;
            hayVivos = false;
            for (int i = 0; i < gramatica.length; i++) {
                if (i % 2 != 0 && !actual.contains(i)) {
                    boolean continuar = true;
                    String posicion = gramatica[i];
                    String[] porpos = posicion.split(">");
                    if (continuar == true) {
                        for (int j = 0; j < porpos.length - 1; j++) {
                            if (continuar != false) {

                                String ps = porpos[j];
                                ps = ps.trim();
                                int signo = ps.indexOf("<");
                                ps = ps.substring(signo, ps.length());
                                int encontrado = Nvivos.indexOf(ps);
                                if (encontrado == -1) {
                                    continuar = false;

                                }

                            }
                        }
                    }
                    if (continuar == true) {
                        String Nviv = gramatica[i - 1];
                        boolean esta = false;
                        actual.add(i);
                        TV.add(posicion);
                        NVivos.add(Nviv);
                        posArray.add(i - 1);
                        if (!Nvivos.contains(Nviv)) {
                            Nvivos = Nvivos.concat(Nviv);
                            hayVivos = true;
                        }
                    }
                }
            }
        }

        return (Nvivos);
    }

    /**
     *
     * @param NVivos
     * @param gramatica
     * @return
     */
    public String Muertos(String NVivos, String[] gramatica) {
        ArrayList<String> Nmuertos = new ArrayList<>();
        String Ntmuertos = "";
        for (int i = 0; i < gramatica.length; i++) {
            if (i % 2 == 0) {
                String palabra = gramatica[i];
                int encontrado = NVivos.indexOf(palabra);
                if (encontrado == -1) {
                    if (!Ntmuertos.contains(palabra)) {
                        Nmuertos.add(palabra);
                        Ntmuertos = Ntmuertos.concat(palabra);
                    }
                }
            }

        }

        return (Ntmuertos);
    }

    /**
     *
     * @param gramatica
     * @return
     */
    public String inalcanzables(String[] gramatica) {
        ArrayList<String> Alcanzables = new ArrayList<>();
        ArrayList<String> Inalcanzables = new ArrayList<>();
        String Ninalcanzables = "";
        String Nalcanzables = "";

        for (int i = 0; i < gramatica.length; i++) {
            if (i % 2 != 0) {
                String posicion = gramatica[i];
                String[] porpos = posicion.split(">");
                for (int j = 0; j < porpos.length - 1; j++) {
                    String ps = porpos[j];
                    ps = ps.trim();
                    int signo = ps.indexOf("<");
                    ps = ps.substring(signo, ps.length());
                    int encontrado = Nalcanzables.indexOf(ps);
                    if (encontrado == -1) {
                        Nalcanzables = Nalcanzables.concat(ps).concat(">");

                    }
                }
            }
        }

        for (int i = 0; i < gramatica.length; i++) {
            if (i % 2 == 0) {
                String palabrai = gramatica[i];
                if (Nalcanzables.contains(palabrai)) {
                    Alcanzables.add(palabrai);
                    posAlcanzablesArray.add(i);
                } else {
                    if (!Ninalcanzables.contains(palabrai)) {
                        Ninalcanzables = Ninalcanzables.concat(palabrai);
                        Inalcanzables.add(palabrai);
                    }

                }
            }
        }

        return (Ninalcanzables);

    }

    /**
     *
     * @param posVivos
     * @param posAlcanzables
     * @param gramatica
     * @return
     */
    public String impresion(ArrayList posVivos, ArrayList posAlcanzables, String[] gramatica) {
        String Ngramatica = "";
        Collections.sort(posVivos);
        Collections.sort(posAlcanzables);
        Integer[] posicionVivos = (Integer[]) posVivos.stream().toArray(Integer[]::new);
        Integer[] posicionAcanzables = (Integer[]) posVivos.stream().toArray(Integer[]::new);

        if (posVivos.isEmpty() == false) {
            for (int i = 0; i < posicionVivos.length; i++) {
                Integer uno = posicionVivos[i];
                int x = uno.intValue();
                for (int j = 0; j < posicionAcanzables.length; j++) {
                    Integer dos = posicionAcanzables[j];
                    int y = dos.intValue();
                    String palabraprocesada = "";
                    palabraprocesada = palabraprocesada.concat(gramatica[x]).concat("=").concat(gramatica[x + 1]).concat("\n");
                    if (y == x && !Ngramatica.contains(palabraprocesada)) {
                        Ngramatica = Ngramatica.concat(palabraprocesada);
                    }
                }
            }

            System.out.println(Ngramatica);
        } else {
            for (int i = 0; i < posicionAcanzables.length; i++) {
                Integer dos = posicionAcanzables[i];
                int y = dos.intValue();
                String palabraprocesada = "";
                palabraprocesada = palabraprocesada.concat(gramatica[y]).concat("=").concat(gramatica[y + 1]).concat("\n");
            }
        }
        return (Ngramatica);
    }

}
