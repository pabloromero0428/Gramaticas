/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author JuanPablo
 */
public class Gramatica {

    ArrayList<Integer> posArray = new ArrayList<Integer>();

    public Gramatica() {
    }

    public Gramatica(String archivo) {

        String[] primertoken = archivo.split("\n");
        String[] tokenfinal = null;
        ArrayList<String> arreglotokenizado = new ArrayList<>();

        int var = 0;
        for (int i = 0; i < primertoken.length; i++) {
            String palabra = primertoken[i];
            tokenfinal = palabra.split("=");
            for (int j = 0; j < tokenfinal.length; j++) {
                String palabra1 = tokenfinal[j];
                arreglotokenizado.add(palabra1);
            }

        }

        String[] Gramaticatokenizada = arreglotokenizado.stream().toArray(String[]::new);

//        for (int i = 0; i < Gramaticatokenizada.length; i++) {
//            System.out.println("Posicion: " +i + "caracater: " + Gramaticatokenizada[i]);
//        }
        Vivos(Gramaticatokenizada);
        Muertos(Vivos(Gramaticatokenizada), Gramaticatokenizada);
    }

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
                        if (!Nvivos.contains(Nviv)) {
                            actual.add(i);
                            TV.add(posicion);
                            NVivos.add(Nviv);
                            posArray.add(i - 1);
                            Nvivos = Nvivos.concat(Nviv);
                            hayVivos = true;
                        }

                    }

                }
            }
        }
        Iterator<String> nombreIterator = NVivos.iterator();
//        while (nombreIterator.hasNext()) {
//            String elemento = nombreIterator.next();
//            System.out.print(elemento + " / ");
//        }

        return (Nvivos);

    }

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
        Iterator<String> nombreIterator = Nmuertos.iterator();
        while (nombreIterator.hasNext()) {
            String elemento = nombreIterator.next();
            System.out.print(elemento + " / ");
        }

        return (Ntmuertos);
    }

}
