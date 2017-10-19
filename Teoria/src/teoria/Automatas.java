/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import teoria.Gramatica;
import Vistas.Automata;

/**
 *
 * @author JuanPablo
 */
public class Automatas {
    
    
    Gramatica g = new Gramatica();
    Automata a;
    public String[][] matriz(String[] pares, String[] impares) {

        ArrayList<String> paresSinR = new ArrayList<>();
        ArrayList<String> imparesSinR = new ArrayList<>();
        String primeraFila = "";
        String primeraColumna = "";

        for (int i = 0; i < pares.length; i++) {
            String palabraA = pares[i];
            if (!primeraColumna.contains(palabraA)) {
                primeraColumna = primeraColumna.concat(palabraA);
                paresSinR.add(palabraA);
            }
        }
        for (int j = 0; j < impares.length; j++) {
            String[] actual = impares[j].split("<");
            String palabraActual = actual[0];
            palabraActual = palabraActual.trim();
            if (!primeraFila.contains(palabraActual)) {
                primeraFila = primeraFila.concat(palabraActual);
                imparesSinR.add(palabraActual);
            }
        }
        String[] vectorParesSin = paresSinR.stream().toArray(String[]::new);
        String[] vectorImparesSin = imparesSinR.stream().toArray(String[]::new);

        String[][] Matrix = new String[vectorParesSin.length + 1][vectorImparesSin.length + 1];
        g.paresR = vectorParesSin.length + 1;
        g.imparesR = vectorImparesSin.length + 1;

        for (int k = 0; k < vectorParesSin.length; k++) {
            String palabraAG = vectorParesSin[k];
            Matrix[k + 1][0] = palabraAG;
        }

        for (int l = 0; l < vectorImparesSin.length; l++) {
            String palabraAG = vectorImparesSin[l];
            Matrix[0][l + 1] = palabraAG;
        }

        for (int m = 0; m < impares.length; m++) {
            String palabraACI = impares[m];
            if (palabraACI.substring(1, 2).equals("<")) {

                String a = palabraACI.substring(0, 1);
                int x = primeraFila.indexOf(palabraACI.substring(0, 1));
                String palabraACP = pares[m];
                int y = 0;
                for (int n = 0; n < vectorParesSin.length; n++) {
                    String palabra = vectorParesSin[n];
                    if (palabra.equals(palabraACP)) {
                        y = n;
                    }

                }

                String actual = "";
                if (x == vectorImparesSin.length - 1 && y == vectorParesSin.length - 1) {

                    actual = Matrix[g.paresR-1][y];
                    if (actual == null) {
                        Matrix[g.paresR-1][y] = palabraACI.substring(1, palabraACI.length());

                    } else {
                        String palabraMatrix = Matrix[x][y];
                        Matrix[g.paresR-1][y] = palabraMatrix.concat(",").concat(palabraACI.substring(1, palabraACI.length()));
                    }
                }
                else {
                    actual = Matrix[x + 1][y + 1];
                    if (actual == null) {
                        Matrix[x + 1][y + 1] = palabraACI.substring(1, palabraACI.length());

                    } else {
                        String palabraMatrix = Matrix[x][y];
                        Matrix[x + 1][y + 1] = palabraMatrix.concat(",").concat(palabraACI.substring(1, palabraACI.length()));
                    }
                }

            }

        }

        return (Matrix);
    }
    
     public void TablaAutomata(String Matriz[][]){
        DefaultTableModel model = (DefaultTableModel) a.automataF.getModel();
        model.setRowCount(g.paresR+2);
        model.setColumnCount(g.imparesR+2);
         for (int i = 0; i < g.paresR+1; i++) {
             for (int j = 0; j < g.imparesR+1; j++) {
                 a.automataF.setValueAt(Matriz[i][j], i, j);
             }
         }
         

        
       
    }
              
   
   
}
