/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria;

import java.util.ArrayList;

/**
 *
 * @author JuanPablo
 */
public class Gramatica {

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
    }

    public void Vivos(String[] gramatica) {
        ArrayList<String> TV = new ArrayList<>();
        ArrayList<String> NVivos = new ArrayList<>();
        ArrayList<Integer> posArray = new ArrayList<Integer>();
        String Nvivos = "";
        boolean hayVivos = false;

        for (int i = 0; i < gramatica.length; i++) {
            if (i % 2 != 0) {
                String posicion = gramatica[i];
                int encontrado = posicion.indexOf("<");
                if (encontrado == -1) {
                    TV.add(posicion);
                    String Nviv = gramatica[i - 1];
                    NVivos.add(Nviv);
                    posArray.add(i - 1);
                    Nvivos = Nvivos.concat(Nviv);
                    hayVivos = true;
                }

            }
        }

        String[] NoVivos = NVivos.stream().toArray(String[]::new);
        while (hayVivos == true) {
            int conteo = 0;

            for (int i = 0; i < gramatica.length; i++) {
                if (i % 2 != 0) {
                    boolean continuar = true;
                    String posicion = gramatica[i];
                    String[] porpos = posicion.split(">");
                    if (continuar == true) {
                        for (int j = 0; j < porpos.length - 1; j++) {
                            if (continuar != false) {

                                String ps = porpos[j];

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
                        for (int j = 0; j < NoVivos.length; j++) {
                            if (NoVivos[j].equals(Nviv)) {
                                esta = true;
                            }
                            else {
                                hayVivos=false;
                            }
                        }
                        if (esta == false) {
                            TV.add(posicion);
                            NVivos.add(Nviv);
                            posArray.add(i - 1);
                            Nvivos = Nvivos.concat(Nviv);
                            hayVivos = true;
                        }

                    } else {
                        hayVivos = false;
                    }

                }
            }
        }

    }

}
