/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria;

import Vistas.Automata;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JuanPablo
 */
public class Gramatica {

    public ArrayList<Integer> posArray = new ArrayList<Integer>();
    public ArrayList<Integer> posAlcanzablesArray = new ArrayList<Integer>();
    String[] vectordepares;
    String[] vectordeimpares;

    public String NVivos;
    public String NMuertos;
    public String NInalcanzables;
    public String Nuevaimpresion;
    ArrayList<String> paresSinR = new ArrayList<>();
    ArrayList<String> imparesSinR = new ArrayList<>();
    ArrayList<String> nuevaConvertida = new ArrayList<>();
    int paresR = 0;
    int imparesR = 0;
    String[] Agregar;

    public Gramatica() {
    }

    /**
     * METODO EL CUAL CREA UN ARREGLO CON LOS ELEMENTOS DE LA GRAMATICA
     *
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

        return (Gramaticatokenizada);
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
        if (NVivos.equals("")) {
            return (null);
        }
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
                } else if (!Ninalcanzables.contains(palabrai)) {
                    Ninalcanzables = Ninalcanzables.concat(palabrai);
                    Inalcanzables.add(palabrai);
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
        } else if (posVivos.isEmpty() == true) {
            for (int i = 0; i < posicionAcanzables.length; i++) {
                Integer dos = posicionAcanzables[i];
                int y = dos.intValue();
                String palabraprocesada = "";
                palabraprocesada = palabraprocesada.concat(gramatica[y]).concat("=").concat(gramatica[y + 1]).concat("\n");
            }
        } else {

        }
        return (Ngramatica);
    }

    public boolean LinealporDerecha(String[] Gramatica) {
        boolean T = true;
        for (int i = 0; i < Gramatica.length; i++) {
            int contador = 0;
            int contadorLanda = 0;
            if (i % 2 != 0) {
                String posicionado = Gramatica[i];
                String[] AR = posicionado.split("<");
                for (int j = 0; j < AR.length; j++) {
                    String ARactual = AR[j];
                    if (ARactual.equals("?")) {
                        contadorLanda = contadorLanda + 1;
                    } else {
                        int encontrado = ARactual.indexOf(">");
                        if (encontrado != -1) {
                            contador = contador + 1;

                        }

                        if (encontrado == -1 && contador > 1) {
                            T = false;
                        }

                    }

                }
                if (T == false) {
                    System.out.println("No es lineal por exceso de T");
                    return (false);
                }

                if (contador == 0) {
                    if (contadorLanda != 1) {
                        System.out.println("No es lineal por landa");
                        return (false);
                    }
                } else if (contador != 1) {
                    System.out.println("No es lineal por N");
                    return (false);
                }
            }
        }
        System.out.println("LinealPorDerecha");
        return (true);
    }

    public boolean FormaEspecial(String[] Gramatica) {
        for (int i = 0; i < Gramatica.length; i++) {

            int contador = 0;
            int contadorLanda = 0;
            if (i % 2 != 0) {
                String posicionado = Gramatica[i];
                String[] AR = posicionado.split("<");
                for (int j = 0; j < AR.length; j++) {
                    String ARactual = AR[j];
                    if (ARactual.equals("?")) {
                        contadorLanda = contadorLanda + 1;
                    } else {
                        int encontrado = ARactual.indexOf(">");
                        if (encontrado != -1) {
                            contador = contador + 1;
                        }
                        if (encontrado == -1) {
                            if (j != 0) {
                                System.out.println("No es especial por J");
                                return (false);
                            }
                        }
                    }

                }
                if (contador == 0) {
                    if (contadorLanda != 1) {
                        System.out.println("No es lineal por landa");
                        return (false);
                    }
                } else if (contador != 1) {
                    System.out.println("No es Especial por N");
                    return (false);
                }
            }
        }
        System.out.println("Especial");
        return (true);
    }

    public String[] generarAF(String NString) {
        String variable1 = "";
        String[] tokens = NString.split("\n");
        String[] tokens2 = null;
        String[] tokens3 = null;
        ArrayList<String> arreglo = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
            String variable = tokens[i];
            tokens2 = variable.split("=");

            for (int j = 0; j < tokens2.length; j++) {
                System.out.println(tokens2[j]);
                //variable1 = tokens2[j];
                arreglo.add(tokens2[j]);
            }
        }
        String[] Gramaticatokenizada1 = arreglo.stream().toArray(String[]::new);
        return (Gramaticatokenizada1);
    }

    public String[] pares(String[] gramatica) {

        String variable1 = "";
        String variable2 = "";
        String[] pares = null;
        String[] copia = null;
        String[] original = null;
        ArrayList<String> arreglo3 = new ArrayList<>();
        ArrayList<String> arreglo4 = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < gramatica.length; i++) {
            variable1 = gramatica[i];
            arreglo3.add(variable1);
        }
        original = arreglo3.stream().toArray(String[]::new);
        copia = arreglo3.stream().toArray(String[]::new);
        for (int j = 0; j < copia.length; j++) {
            if (j % 2 == 0) {
                variable2 = copia[j];
                arreglo4.add(variable2);
            }
        }
        pares = arreglo4.stream().toArray(String[]::new);

        return (pares);
    }

    public String[] impares(String[] gramatica) {

        String variable1 = "";
        String variable2 = "";
        String[] impares = null;
        String[] copia = null;
        ArrayList<String> arreglo4 = new ArrayList<>();
        ArrayList<String> arreglo5 = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < gramatica.length; i++) {
            variable1 = gramatica[i];
            arreglo4.add(variable1);
        }
        copia = arreglo4.stream().toArray(String[]::new);
        for (int j = 0; j < copia.length; j++) {
            if (j % 2 != 0) {
                variable2 = copia[j];
                arreglo5.add(variable2);
            }
        }
        impares = arreglo5.stream().toArray(String[]::new);

        return (impares);
    }

    public String[][] matriz(String[] gramatica, JTable w) {

        String primeraFila = "";
        String primeraColumna = "";
        String pares[] = pares(gramatica);
        String impares[] = impares(gramatica);
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
            if (!palabraActual.equals("?")) {
                if (!primeraFila.contains(palabraActual)) {
                    primeraFila = primeraFila.concat(palabraActual);
                    imparesSinR.add(palabraActual);
                }
            }
        }
        String[] vectorParesSin = paresSinR.stream().toArray(String[]::new);
        String[] vectorImparesSin = imparesSinR.stream().toArray(String[]::new);

        String[][] Matrix = new String[vectorParesSin.length + 1][vectorImparesSin.length + 1];
        paresR = vectorParesSin.length + 1;
        imparesR = vectorImparesSin.length + 1;
        vectordeimpares = vectorImparesSin;
        vectordepares = vectorParesSin;

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
            if (!palabraACI.equals("?")) {
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

                        actual = Matrix[y+1][x+1];
                        if (actual == null) {
                            Matrix[y+1][x+1] = palabraACI.substring(1, palabraACI.length());

                        } else {
                            String palabraMatrix = Matrix[y+1][x+1];
                            Matrix[y+1][x+1] = palabraMatrix.concat(",").concat(palabraACI.substring(1, palabraACI.length()));
                        }
                    } else {
                        actual = Matrix[y + 1][x + 1];
                        if (actual == null) {
                            Matrix[y + 1][x + 1] = palabraACI.substring(1, palabraACI.length());

                        } else {
                            String palabraMatrix = Matrix[y][x];
                            Matrix[y + 1][x + 1] = palabraMatrix.concat(",").concat(palabraACI.substring(1, palabraACI.length()));
                        }
                    }

                }

            }
        }
        for (int i = 0; i < vectorParesSin.length + 1; i++) {
            for (int j = 0; j < vectorImparesSin.length + 1; j++) {
                if (Matrix[i][j] == null) {
                    Matrix[i][j] = "Error";
                }
            }
        }
        Matrix[0][0] = "Estados";

        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Estados");
        for (int i = 0; i < vectorImparesSin.length; i++) {
            String nuevo = vectorImparesSin[i];
            tb.addColumn(nuevo);
        }

        for (int i = 1; i < vectorParesSin.length + 1; i++) {
            ArrayList<String> fila = new ArrayList<String>();
            for (int j = 0; j < vectorImparesSin.length + 1; j++) {
                fila.add(Matrix[i][j]);

                String[] filita = fila.stream().toArray(String[]::new);
                Agregar = filita;
            }
            tb.addRow(Agregar);

        }
        tb.addColumn("Aceptacion");
        w.setModel(tb);

        return (Matrix);
    }

    public boolean Deterministico(String[][] Matrix) {
        boolean Esdeterministico = true;
        for (int i = 1; i < vectordepares.length + 1; i++) {
            for (int j = 0; j < vectordeimpares.length + 1; j++) {
                String palabraactual = Matrix[i][j];
                int x = palabraactual.indexOf(",");
                if (x != -1) {
                    return (false);
                }
            }
        }
        return (Esdeterministico);
    }

//    public String[][] noDeterministico(String[][] Matrix, boolean deterministico){
//        if(deterministico == false){
//            
//        } 
//    }
    public String agregarComa() {

        String[] vectorImparesSin2 = imparesSinR.stream().toArray(String[]::new);
        for (int i = 0; i < vectorImparesSin2.length; i++) {
            System.out.println("entre");
            System.out.println(vectorImparesSin2[i]);
        }
        for (int i = 0; i < vectorImparesSin2.length - 1; i++) {
            vectorImparesSin2[i] = vectorImparesSin2[i].concat(",");
        }
        String a = "";
        for (int i = 0; i < vectorImparesSin2.length; i++) {
            a = a.concat(vectorImparesSin2[i]);
        }
        System.out.println("esooooo");
        System.out.println(a);
        return (a);

    }

}
