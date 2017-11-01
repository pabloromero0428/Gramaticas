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
 * @author JuanPabloRomeroLaverde
 * Kevin Esteban Gutierres
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
    String[] vectorParesSin;
    String[] vectorImparesSin;
    int paresR = 0;
    int imparesR = 0;
    String[] Agregar;

    public Gramatica() {
    }

    /**
     * METODO EL CUAL CREA UN ARREGLO CON LOS ELEMENTOS DE LA GRAMATICA     *
     * @param archivo
     * @return un vector con la gramatica 
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
     *Este metodo utiliza la gramatica ingresada, la descompone tokenizadamente y realiza interacciones 
     *recorriendo toda la gramatica creada y guardada en vectores para asi encontrar cuales son los N vivos
     * @param gramatica
     * @return un string con los N vivos
     */
    public String Vivos(String[] gramatica) {

        ArrayList<String> TV = new ArrayList<>();
        ArrayList<String> NVivos = new ArrayList<>();
        ArrayList<Integer> actual = new ArrayList<Integer>();
        String Nvivos = "";
        boolean hayVivos = false;//iniciamos con 0 ingresos de vivos 

        for (int i = 0; i < gramatica.length; i++) {
            if (i % 2 != 0) {
                String posicion = gramatica[i];
                posicion = posicion.trim();
                int encontrado = posicion.indexOf("<");
                if (encontrado == -1) {//si no encuentra el N quiere decir que encontro un T y hay vivos 
                    TV.add(posicion);
                    String Nviv = gramatica[i - 1];
                    actual.add(i);
                    NVivos.add(Nviv);
                    posArray.add(i - 1);
                    Nvivos = Nvivos.concat(Nviv);
                    hayVivos = true;// cambia la variable a verdadero indicando que se entro un vivo
                }
            }
        }

        if (hayVivos == false) {// si en la primera pasa no encuentra vivos la variable no cambia y no hay vivos ni muertos 
            JOptionPane.showMessageDialog(null, "NO HAY VIVOS NI MUERTOS");
        }

        while (hayVivos == true) {//si encontro un T hay vivos e ingresa
            int conteo = 0;
            hayVivos = false;// iniciamos de nuevo la variable en falso para saber si agregaremos un nuevo vivo
            for (int i = 0; i < gramatica.length; i++) {
                if (i % 2 != 0 && !actual.contains(i)) {
                    boolean continuar = true; // utilizamos esta variable para saber si debemos continuar avanzando por la gramatica
                    String posicion = gramatica[i];
                    String[] porpos = posicion.split(">");// realizamos particiones para buscar N y T vivos 
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
                    if (continuar == true) {// su continuar es true quiere decir que debemos agregar un nuevo vivo
                        String Nviv = gramatica[i - 1];
                        boolean esta = false;
                        actual.add(i);
                        TV.add(posicion);
                        NVivos.add(Nviv);
                        posArray.add(i - 1);
                        if (!Nvivos.contains(Nviv)) {// si Ya ese N vivo esta agregado no hay mas que agregar 
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
     *Este metodo toma lo N vivos para buscar recorriendo la gramatica cuales N terminales esta muertos 
     * @param NVivos
     * @param gramatica
     * @return un strinf con los N muertos
     */
    public String Muertos(String NVivos, String[] gramatica) {
        ArrayList<String> Nmuertos = new ArrayList<>();
        String Ntmuertos = "";
        if (NVivos.equals("")) {//si N vivos esta en blanco quiere decir que no hay muertos 
            return (null);
        }
        for (int i = 0; i < gramatica.length; i++) {// buscamos en las posisciones pares de toda la gramatica 
            if (i % 2 == 0) {
                String palabra = gramatica[i];
                int encontrado = NVivos.indexOf(palabra);
                if (encontrado == -1) {// si la poicion en la que estoy no esta contenida en los vivos enotnces es un muertoy lo agregamos al nuevo vector
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
     *Este metodo buscar ir poscion por posicion de la grmatica desde las partes impares del vector 
     * @param gramatica
     * @return un string con lo N inalcanzables
     */
    public String inalcanzables(String[] gramatica) {
        ArrayList<String> Alcanzables = new ArrayList<>();
        ArrayList<String> Inalcanzables = new ArrayList<>();
        String Ninalcanzables = "";
        String Nalcanzables = "";

        for (int i = 0; i < gramatica.length; i++) {// En este for encontrarems todos lo N de la gramatica en el lado derecho 
            if (i % 2 != 0) {
                String posicion = gramatica[i];
                String[] porpos = posicion.split(">");
                for (int j = 0; j < porpos.length - 1; j++) {
                    String ps = porpos[j];
                    ps = ps.trim();
                    int signo = ps.indexOf("<");
                    ps = ps.substring(signo, ps.length());
                    int encontrado = Nalcanzables.indexOf(ps);
                    if (encontrado == -1) {// si el N no esta en nuestros alcanzables  lo agregamos 
                        Nalcanzables = Nalcanzables.concat(ps).concat(">");

                    }
                }
            }
        }

        for (int i = 0; i < gramatica.length; i++) {// Buscamos en el lado izquierdo de la gramatica cuales son los que no entan en nuestros alcanzables y los agregamos a nuestros inalcanzables
            if (i % 2 == 0) {
                String palabrai = gramatica[i];
                if (Nalcanzables.contains(palabrai)) {
                    Alcanzables.add(palabrai);
                    posAlcanzablesArray.add(i);
                } else if (!Ninalcanzables.contains(palabrai)) {// si nuestro vector de inalcanzables no tiene la posicion actual inalcanzable la agregamos a nuestos vectos
                    Ninalcanzables = Ninalcanzables.concat(palabrai);
                    Inalcanzables.add(palabrai);
                }
            }
        }

        return (Ninalcanzables);

    }

    /**
     *Este metodo imprime la nueva gramatica eliminando los muestro y los inalcanzables
     * teniendo en cuenta las posiciones
     * @param posVivos
     * @param posAlcanzables
     * @param gramatica
     * @return la gramatica en forma de string
     */
    public String impresion(ArrayList posVivos, ArrayList posAlcanzables, String[] gramatica) {
        String Ngramatica = "";
        Collections.sort(posVivos);
        Collections.sort(posAlcanzables);
        Integer[] posicionVivos = (Integer[]) posVivos.stream().toArray(Integer[]::new);
        Integer[] posicionAcanzables = (Integer[]) posVivos.stream().toArray(Integer[]::new);

        if (posVivos.isEmpty() == false) {//si la poscion de los vivos esta vacio quiere decir que no hay vivos
            for (int i = 0; i < posicionVivos.length; i++) {
                Integer uno = posicionVivos[i];
                int x = uno.intValue();
                for (int j = 0; j < posicionAcanzables.length; j++) {// vamos poscion por posicion comparad con  las posicones de los alcanzabeles y lso vivos y agregramos al estrig 
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
        } else if (posVivos.isEmpty() == true) {// si vivos esta vacio solo agregos los alcanzables 
            for (int i = 0; i < posicionAcanzables.length; i++) {
                Integer dos = posicionAcanzables[i];
                int y = dos.intValue();
                String palabraprocesada = "";
                palabraprocesada = palabraprocesada.concat(gramatica[y]).concat("=").concat(gramatica[y + 1]).concat("\n");
            }
        } 
        return (Ngramatica);
    }
/**
 * Este metodo me comprueba si la gramtica es lineal por la derecha es decir de la forma correcta
 * @param Gramatica
 * @return  verdadero o falso si es lineal por la derecha
 */
    public boolean LinealporDerecha(String[] Gramatica) {
        boolean T = true;
        for (int i = 0; i < Gramatica.length; i++) {// recorremos la gramtica por la parte derecha es decir las posiciones impares 
            int contador = 0;
            int contadorLanda = 0;
            if (i % 2 != 0) {// vamos a separar tokenizadamente  las posiciones impares 
                String posicionado = Gramatica[i];
                String[] AR = posicionado.split("<");
                for (int j = 0; j < AR.length; j++) {
                    String ARactual = AR[j];
                    if (ARactual.equals("?")) {
                        contadorLanda = contadorLanda + 1;
                    } else {
                        int encontrado = ARactual.indexOf(">");//contaremos cuentas veces aparece un simpbolo para saber cuantos N hay 
                        if (encontrado != -1) {
                            contador = contador + 1;

                        }

                        if (encontrado == -1 && contador > 1) {// si lo no lo encuentra y contador es mayor que uno quiere decir que no es lineal puesto hay mas N
                            T = false;
                        }

                    }

                }
                if (T == false) {
                    System.out.println("No es lineal por exceso de T");
                    return (false);
                }

                if (contador == 0) {// Si el contador es igual a 0 es porque entoncetro un T solo si es landa avanzara si no, no es lineal por derecha
                    if (contadorLanda != 1) {
                        System.out.println("No es lineal por landa");
                        return (false);
                    }
                } else if (contador != 1) {// Si hay mas de un N tampoco es lineal por la derecha
                    System.out.println("No es lineal por N");
                    return (false);
                }
            }
        }
        System.out.println("LinealPorDerecha");
        return (true);
    }
/**
 * Este metodo me buscar en la parte derecha de la gramtica la forma
 * @param Gramatica
 * @return verdadero o falso si es de la forma especial
 */
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
    
/**
 * Metodo el cual recibe el String que contiene la gramatica , este metodo retorna un vector el cual va guardar
 * lo que esta antes del igual y lo que esta despues del igual, el vector resultando contendra en ciertas posiciones 
 * lo que esta antes del igual y en ciertas posiciones lo que esta despues del igual
 * @param NString
 * @return  un vector con posicion de la gramatica tokenizada
 */
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
                
                arreglo.add(tokens2[j]);
            }
        }
        String[] Gramaticatokenizada1 = arreglo.stream().toArray(String[]::new);
        return (Gramaticatokenizada1);
    }
/**
 * El metodo pares buscara en el vector generado anteriormente(generarAf) las posiciones pares 
 * las cuales deben contener el lado izquierdo de la gramatica 
 * @param gramatica
 * @return  un vector con las posicion de la izquierda o pares segun vector de la gramatica
 */
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
    
/**
 * El metodo impares buscara en el vector generado anteriormente(generarAF) las posiciones impares 
 * las cuales deben contener el lado derecho de la gramatica 
 * @param gramatica
 * @return  un vector con el lado derecho o posiciones impares segun el vector de la gramatica
 */
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
/**
 * Con base en la gramatica simplificada este metodo toma el vector generado lo parte y agrega en las filas y las columnas de una matriz todos los datos correspondientes
 * @param gramatica
 * @param w
 * @return  una matriz con el automata creado
 */
    public String[][] matriz(String[] gramatica, JTable w) {

        String primeraFila = "";
        String primeraColumna = "";
        String pares[] = pares(gramatica);
        String impares[] = impares(gramatica);
        // Agrega las refecias de cada columna a un vector
        for (int i = 0; i < pares.length; i++) {
            String palabraA = pares[i];
            if (!primeraColumna.contains(palabraA)) {
                primeraColumna = primeraColumna.concat(palabraA);
                paresSinR.add(palabraA);
            }
        }
        //Agrega las referencias de cada fila  a un vector
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
        //se convierten Arreaylist a Vectores para su utilizacion
        vectorParesSin = paresSinR.stream().toArray(String[]::new);
        vectorImparesSin = imparesSinR.stream().toArray(String[]::new);
//Se crean variables para la distribucion de los datos en la matriz
        String[][] Matrix = new String[vectorParesSin.length + 1][vectorImparesSin.length + 2];
        paresR = vectorParesSin.length + 1;
        imparesR = vectorImparesSin.length + 1;
        vectordeimpares = vectorImparesSin;
        vectordepares = vectorParesSin;
// Agrega los primeros datos a las columnas de la matriz
        for (int k = 0; k < vectorParesSin.length; k++) {
            String palabraAG = vectorParesSin[k];
            Matrix[k + 1][0] = palabraAG;
        }
// agrega primeros datos a las filas de la matriz
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
                    // busca la posicion en la que se debe agregar
                    if (x == vectorImparesSin.length - 1 && y == vectorParesSin.length - 1) {

                        actual = Matrix[y + 1][x + 1];
                        if (actual == null) {
                            Matrix[y + 1][x + 1] = palabraACI.substring(1, palabraACI.length());

                        } else {
                            String palabraMatrix = Matrix[y + 1][x + 1];
                            Matrix[y + 1][x + 1] = palabraMatrix.concat(",").concat(palabraACI.substring(1, palabraACI.length()));
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
        // Llena los espacion null con error generando un estado de error
        for (int i = 0; i < vectorParesSin.length + 1; i++) {
            for (int j = 0; j < vectorImparesSin.length + 1; j++) {
                if (Matrix[i][j] == null) {
                    Matrix[i][j] = "Error";
                }
            }
        }
// precisa los estados de aceptacion en 0
        for (int i = 1; i < vectorImparesSin.length; i++) {
            Matrix[i][vectorImparesSin.length + 1] = "0";
        }
//cambia el estado 0 por un estado de aceptacion 1
        for (int i = 0; i < gramatica.length; i++) {
            if (i % 2 != 0) {
                String posicionld = gramatica[i];
                if (posicionld.equals("?")) {
                    for (int j = 0; j < vectorParesSin.length; j++) {
                        String N = gramatica[i - 1];
                        String ac = vectorParesSin[j];
                        if (ac.equals(N)) {
                            Matrix[j + 1][vectorImparesSin.length + 1] = "1";
                        }
                    }
                    System.out.println("");
                }
            }
        }

        // Pasa la matriz a la tabla 
        Matrix[0][0] = "Estados";

        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Estados");

        for (int i = 0; i < vectorImparesSin.length; i++) {
            String nuevo = vectorImparesSin[i];
            tb.addColumn(nuevo);
        }
        tb.addColumn("Aceptacion");
        for (int i = 1; i < vectorParesSin.length + 1; i++) {
            ArrayList<String> fila = new ArrayList<String>();
            for (int j = 0; j < vectorImparesSin.length + 2; j++) {
                fila.add(Matrix[i][j]);

                String[] filita = fila.stream().toArray(String[]::new);
                Agregar = filita;
            }
            tb.addRow(Agregar);

        }

        w.setModel(tb);

        return (Matrix);
    }
/**
 * metodo que retorna un String separado por coma
 * @return  un string con los T de la gramatica separados por comas
 */
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
