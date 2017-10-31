/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class ControladorAutomata {

    JTable jtable;
    DefaultTableModel tabla;
    Object[] estados;
    Object simbolos;
    Object conjutoDeEstados[];

    public ControladorAutomata() {

    }

    public DefaultTableModel modelo() {
        return tabla;
    }
/**
 * metodo que busca los estados a los que el automata nunca podra llegar 
 */
    public void buscarEstadosExtraños() {

        setTabla(jtable);
        int nroSimbolo = tabla.getColumnCount() - 2;
        Object a[] = new Object[tabla.getRowCount() - 1];
        for (int i = 1; i < tabla.getRowCount(); i++) {
            a[i - 1] = tabla.getValueAt(i, 0).toString();
        }
        int estado[] = new int[a.length];
        estado[0] = 1;
        String n;
        String p;

        for (int i = 0; i < estado.length; i++) {
            for (int j = 1; j <= nroSimbolo; j++) {
                n = tabla.getValueAt(i + 1, j).toString();
                for (int k = 0; k < a.length; k++) {
                    p = tabla.getValueAt(i + 1, 0).toString();
                    if (!n.equals(p)) {
                        if (n.equals(a[k])) {
                            estado[k] = 1;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = estado.length - 1; i > 0; i--) {
            if (estado[i] != 1) {
                tabla.removeRow(i + 1);
            }
        }
        setTabla(jtable);
    }
/**
 * Evalúa y determina si la hilera ingresada se acepta o se rechaza 
 * @param a
 * @return 
 */
    public String seguimiento(String a) {
        char ch;
        int columna;
        if (a.equals("")) {
            return "No hay hilera a comprobar.";
        }
        ch = a.charAt(0);
        columna = buscarEnFila(0, ch + "");
        if (columna == -1) {
            return "Simbolo incorrecto.";
        } else if (columna == -2) {
            return "Error en la hilera evaluada";
        }
        String estado = (String) tabla.getValueAt(1, columna);

        int fila = buscarEnColumna(0, estado);
        if (fila == -1) {
            return "Simbolo incorrecto.";
        }
        for (int i = 1; i < a.length(); i++) {
            ch = a.charAt(i);
            columna = buscarEnFila(0, ch + "");
            if (columna == -1) {
                return "Simbolo incorrecto.";
            }
            estado = (String) tabla.getValueAt(fila, columna);
            fila = buscarEnColumna(0, estado);
            if (fila == -1) {
                return "Simbolo incorrecto.";
            }
        }
        estado = (String) tabla.getValueAt(fila, tabla.getColumnCount() - 1);
        return estado;
    }
/**
 * Busca en la respectiva fila si esta el dato
 * @param fila
 * @param a
 * @return 
 */
    private int buscarEnFila(int fila, String a) {
        String c;
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            c = (String) tabla.getValueAt(fila, i);
            if (c == null) {
                continue;
            } else if (c.equals(a)) {
                return i;
            }
        }
        return -1;
    }
/**
 * busca en la columna si esta el dato
 * @param columna
 * @param a
 * @return 
 */
    private int buscarEnColumna(int columna, String a) {
        String c;
        for (int i = 1; i < tabla.getRowCount(); i++) {
            c = (String) tabla.getValueAt(i, columna);
            if (c.equals("")) {
                return -2;
            } else if (c.equals(a)) {
                return i;
            }
        }
        return -1;
    }
/**
 *Agrega estados que no se encuentran en la columna pero que fueron agregados al unir las particiones
 * @param estado
 * @return 
 */
    private boolean agregarEstado(String estado) {
        if (estado.isEmpty() || estado.contains(" ")) {
            return false;
        }
        char d;
        String estados[] = new String[tabla.getColumnCount()];
        estados[0] = estado;
        String recur;
        int n;
        for (int k = 0; k < estado.length(); k++) {

            n = buscarFilaDeEstado(estado.charAt(k) + "");
            if (n != 0) {
                for (int j = 1; j < estados.length; j++) {
                    recur = tabla.getValueAt(n, j).toString();

                    if (j == tabla.getColumnCount() - 1) {
                        if (estados[j].equalsIgnoreCase("")) {
                            estados[j] += recur;
                        } else if (estados[j].compareTo(recur) != 0) {
                            estados[j] = 1 + "";
                        }
                    } else if (!estados[j].contains(recur)) {
                        estados[j] += recur;
                    }
                }
            }

        }
        if (!estados[0].isEmpty() && !estados[0].contains(" ")) {
            tabla.addRow(estados);
        }
        return true;
    }

    private void borrarFilaVacia() {
        for (int j = 1; j < tabla.getRowCount(); j++) {
            if (tabla.getValueAt(j, 0).toString().equalsIgnoreCase("")) {
                tabla.removeRow(j);
            }
        }
    }
/**
 * Realiza la partición de los estados que tienen el mismo estado de aceptación
 * @param estado
 * @return 
 */
    private int retornarConjunto(String estado) {
        int i = 0;
        ArrayList<String> estados;
        while (conjutoDeEstados[i] != null) {
            estados = (ArrayList<String>) conjutoDeEstados[i];
            if (estados.contains(estado)) {
                return i;
            }
            i++;
        }
        return -1;
    }
/**
 * metodo que busca dependiendo del estado a que fila pertenece 
 * @param estado
 * @return 
 */
    private int buscarFilaDeEstado(String estado) {
        for (int i = 1; i < tabla.getRowCount(); i++) {
            if (tabla.getValueAt(i, 0).toString().compareTo(estado) == 0) {
                return i;
            }
        }
        return 0;
    }

    public void setTabla(JTable tabla) {
        jtable = tabla;
        this.tabla = (DefaultTableModel) jtable.getModel();;
        String o;
        estados = new Object[this.tabla.getRowCount()];
        for (int i = 1; i < this.tabla.getRowCount(); i++) {
            o = this.tabla.getValueAt(i, 0).toString();
            if (o != null) {
                estados[i] = o;
            }
        }
    }
/**
 * metodo que comprueba si es determinisitico 
 * @return 
 */
    public String comprobarDeterministico() {

        String copia;
        for (int i = 1; i < tabla.getRowCount(); i++) {
            for (int j = 1; j < tabla.getColumnCount(); j++) {
                copia = (String) tabla.getValueAt(i, j);
                if (copia.contains(",")) {
                    return "El autómata ingresado es no Determinístico";
                }
            }
        }
        return "El autómata ingresado es Determinístico";
    }

    public int comprobarDeterministico2() {
        String copia;
        for (int i = 1; i < tabla.getRowCount(); i++) {
            for (int j = 1; j < tabla.getColumnCount(); j++) {
                copia = (String) tabla.getValueAt(i, j);
                if (copia.contains(",")) {
                    System.out.println("Es no deterministico");
                    return 0;
                }
            }
        }
        System.out.println("Es deterministico");
        return 1;
    }
/**
 * metodo que convierte el automata ND a deterministico
 * @return 
 */
    public int pasarADeterminitico() {
        if (comprobarDeterministico2() == 1) {
            return 0;
        }
        String copia;
        for (int i = 1; i < tabla.getRowCount(); i++) {
            for (int j = 1; j < tabla.getColumnCount() - 1; j++) {
                copia = (String) tabla.getValueAt(i, j);
                if (copia.contains(",")) {
                    System.out.println("lo encontré");
                    ajustaEstados(i, j);
                }
            }
        }
        borrarFilaVacia();
        for (int i = 1; i < tabla.getRowCount(); i++) {
            for (int j = 1; j < tabla.getColumnCount() - 1; j++) {
                copia = tabla.getValueAt(i, j).toString();
                copia = copia.replaceAll(" ", "");
                tabla.setValueAt(copia, i, j);
            }
        }
        return 1;
    }
/**
 * Convierte una transición no determinística a determinística
 * @param fila
 * @param columna 
 */
    private void ajustaEstados(int fila, int columna) {
        
        String aux;
        String auxB = "";
        int cont = 0;
        int c = 0;
        String a;
        aux = tabla.getValueAt(fila, columna).toString();
        for (int i = 0; i < aux.length(); i++) {
            a = aux.charAt(i) + "";
            if (a.equals(",")) {
                cont++;
            }
        }
        String vec[] = new String[cont + 1];
        for (int i = 0; i < aux.length(); i++) {
            a = aux.charAt(i) + "";
            if (!a.equalsIgnoreCase(",")) {
                auxB = auxB + aux.charAt(i) + "";
            } else {
                vec[c] = auxB;
                auxB = "";
                c++;
            }
        }
        vec[c] = auxB;
        auxB = "";
        for (int i = 0; i < vec.length; i++) {
            auxB += vec[i];
        }
        tabla.setValueAt(auxB, fila, columna);
        String vec2[] = new String[tabla.getColumnCount()];
        for (int i = 0; i < vec2.length; i++) {
            vec2[i] = "";
        }
        vec2[0] = auxB;
        int n;
        String recur;
        for (int i = 0; i < vec.length; i++) {
            n = buscarFilaDeEstado(vec[i]);
            for (int j = 1; j < vec2.length; j++) {
                recur = tabla.getValueAt(n, j).toString();
                if (recur.contains(",")) {
                    ajustaEstados(n, j);
                }
                if (j == tabla.getColumnCount() - 1) {
                    if (vec2[j].equalsIgnoreCase("")) {
                        vec2[j] += recur;
                    } else if (vec2[j].compareTo(recur) != 0) {
                        vec2[j] = 1 + "";
                    }
                } else if (!vec2[j].contains(recur)) {
                    vec2[j] += recur;
                }
            }
        }
        tabla.addRow(vec2);
        compruebaTabla();
    }
/**
 * Determina si los dos estados son iguales en cualquier orden
 * @param estado
 * @param estadoN
 * @return 
 */
    private boolean verificaIgual(String estado, String estadoN) {
        int cont = 0;
        if (estado.length() != estadoN.length()) {
            return false;
        }
        for (int i = 0; i < estadoN.length(); i++) {
            if (!estado.contains(estadoN.charAt(i) + "")) {
                return false;
            }
        }
        return true;
    }
/**
 *  Comprueba si el estado ingresado como parámetro está en la tabla
 * @param estado
 * @return 
 */
    public boolean contieneEstado(String estado) {
        String aux;
        int cantF = tabla.getRowCount();
        boolean igual = false;
        String auxB;
        for (int i = 1; i < cantF; i++) {
            aux = tabla.getValueAt(i, 0).toString();
            if (verificaIgual(aux, estado)) {
                return true;
            }
        }
        return false;
    }
/**
 * Crea el nuevo estado y lo ubica en la tabla.
 */
    public void compruebaTabla() {
        int cantCol = tabla.getColumnCount();
        int cantFilas = tabla.getRowCount() - 1;
        boolean sigue = false;

        for (int i = 1; i < cantCol - 1; i++) {
            if (!contieneEstado(tabla.getValueAt(cantFilas, i).toString())) {
                sigue = true;
                String vec2[] = new String[cantCol];
                for (int j = 0; j < vec2.length; j++) {
                    vec2[j] = "";
                }
                vec2[0] = tabla.getValueAt(cantFilas, i).toString();
                String recur;
                int n;
                for (int k = 0; k < vec2[0].length(); k++) {

                    n = buscarFilaDeEstado(vec2[0].charAt(k) + "");
                    if (n != 0) {
                        for (int j = 1; j < vec2.length; j++) {
                            recur = tabla.getValueAt(n, j).toString();

                            if (j == tabla.getColumnCount() - 1) {
                                if (vec2[j].equalsIgnoreCase("")) {
                                    vec2[j] += recur;
                                } else if (vec2[j].compareTo(recur) != 0) {
                                    vec2[j] = 1 + "";
                                }
                            } else if (!vec2[j].contains(recur)) {
                                vec2[j] += recur;
                            }
                        }
                    }

                }
                if (!vec2[0].isEmpty() && !vec2[0].contains(" ")) {
                    tabla.addRow(vec2);
                    if (sigue) {
                        sigue = false;
                        compruebaTabla();
                    }
                }

            }

        }

    }
    
/**
 * Metodo que simplifica
 */
    public void simplificar() {
        conjutoDeEstados = new Object[estados.length];
        for (int i = 0; i < conjutoDeEstados.length; i++) {
            conjutoDeEstados[i] = null;
        }
        conjutoDeEstados[0] = new ArrayList<String>();
        conjutoDeEstados[1] = new ArrayList<String>();

        int columnas = tabla.getColumnCount(); //se obtiene el nuero de columnas de la tabla
        /**
         * En este ciclo se recorre buscando estados de aceptacion iguales(0 o
         * 1) para agregarlos al arraylist en sus respectivas posiciones.
         */
        ArrayList<String> estado;
        for (int i = 1; i < tabla.getRowCount(); i++) {
            if (tabla.getValueAt(i, columnas - 1).toString().compareTo("0") == 0) {
                estado = (ArrayList<String>) conjutoDeEstados[0];
                estado.add(tabla.getValueAt(i, 0).toString());

            } else {
                estado = (ArrayList<String>) conjutoDeEstados[1];
                estado.add(tabla.getValueAt(i, 0).toString());
            }
        }
        estado = new ArrayList<>();
        int filaEstado;
        int i = 0;
        String estadoPosIJ;
        boolean controlNuevaParticion = false;
        int particiones = 2;
        ArrayList<String> nuevaParticion;
        boolean controlComprobarParticiones = false;

        //ciclo para buscar en los conjuntos de particiones        
        while (i < particiones) {
            int c = -1;
            //obtencion delbconjunto i-esimo de estados
            estado = (ArrayList<String>) conjutoDeEstados[i];
            //ciclo que controla los simbolos que hay en la tabla.
            for (int k = 1; k < tabla.getColumnCount() - 1; k++) {

                //ciclo para buscar hacia que particion se hace transicion
                for (int j = 0; j < estado.size(); j++) {
                    filaEstado = buscarFilaDeEstado(estado.get(j));

                    estadoPosIJ = tabla.getValueAt(filaEstado, k).toString();
                    if (c == -1) {
                        //c sera igual a la particion hacia donde hace la transicion el primer estado de la particion i
                        c = retornarConjunto(estadoPosIJ);
                    }
                    if (c != retornarConjunto(estadoPosIJ)) {
                        if (conjutoDeEstados[particiones] == null) {
                            conjutoDeEstados[particiones] = new ArrayList<String>();
                        }
                        nuevaParticion = (ArrayList<String>) conjutoDeEstados[particiones];
                        nuevaParticion.add(estado.get(j));
                        estado.remove(estado.get(j));
                        controlNuevaParticion = true;
                        j--;

                    }

                }
                c = -1;
                if (controlNuevaParticion) {
                    particiones++;

                    controlNuevaParticion = false;
                    controlComprobarParticiones = true;
                }
            }
            i++;
            if (controlComprobarParticiones) {
                controlComprobarParticiones = false;
                i = 0;
            }
        }

        i = 0;

        int filaEstados[];
        while (conjutoDeEstados[i] != null) {
            estado = (ArrayList<String>) conjutoDeEstados[i];
            filaEstados = new int[estado.size()];
            if (estado.size() > 1) {//cuando en una particion hay mas de 1 estado ingresa

                for (int j = 0; j < estado.size(); j++) {
                    //este ciclo obtiene las filas de los estados iguales;
                    filaEstados[j] = buscarFilaDeEstado(estado.get(j).toString());

                }
                String[] columna = new String[tabla.getColumnCount()];
                for (int l = 0; l < columna.length; l++) {
                    columna[l] = "";
                }
                int j = 0;
                while (j < estado.size()) {
                    int k = 0;

                    for (k = 0; k < tabla.getColumnCount(); k++) {

                        if (columna[k].compareTo(tabla.getValueAt(filaEstados[j], k).toString()) != 0) {
                            if (k == tabla.getColumnCount() - 1) {//comparacion ultima columna, la de estados de aceptacion
                                if (columna[tabla.getColumnCount() - 1].compareTo("") != 0) {
                                    String datos = columna[tabla.getColumnCount() - 1];
                                    if (datos.equalsIgnoreCase(tabla.getValueAt(filaEstados[j], k).toString())) {
                                        columna[k] = tabla.getValueAt(filaEstados[j], k).toString();
                                        continue;
                                    } else {
                                        columna[k] = 1 + "";
                                        continue;
                                    }
                                }
                            }
                            String s = tabla.getValueAt(filaEstados[j], k).toString();
                            if (s.length() < 2) {
                                columna[k] += tabla.getValueAt(filaEstados[j], k).toString();
                            } else {
                                char d;
                                for (int l = 0; l < s.length(); l++) {
                                    d = s.charAt(l);
                                    if (!columna[k].contains(d + "")) {
                                        columna[k] += d + "";
                                    }
                                }
                            }

                        }

                    }

                    j++;
                }
                /*for (int k = 1; k < tabla.getRowCount(); k++) {
                    for (int l = 1; l < tabla.getColumnCount()-1; l++) {
                        if (columna[0].contains(tabla.getValueAt(k, l).toString()) && !columna[0].equalsIgnoreCase(tabla.getValueAt(k, l).toString())) {
                            tabla.setValueAt(columna[0], k, l);
                        }
                    }
                }*/
                for (int k = 0; k < columna.length; k++) {
                    columna[k] = sortString(columna[k]);
                }

                tabla.addRow(columna);

            }

            for (int j = 0; j < estado.size(); j++) {

                System.out.println("particion i:" + i + " elemento:" + estado.get(j));
            }
            i++;
        }
        String dato;
        boolean estadoNuevo = false;
        for (int j = 1; j < tabla.getRowCount(); j++) {
            for (int k = 0; k < tabla.getColumnCount() - 1; k++) {
                dato = tabla.getValueAt(j, k).toString();
                dato = sortString(dato);
                tabla.setValueAt(dato, j, k);
                //try{                        
                if (!contieneEstado(dato) && k != 0 && !dato.contains("")) {
                    estadoNuevo = agregarEstado(dato);

                }
                //}catch(Exception e){}

            }
        }
        if (estadoNuevo) {
            simplificar();
        } else {
            i = 0;
            //se eliminan estados iguales
            while (conjutoDeEstados[i] != null) {
                estado = (ArrayList<String>) conjutoDeEstados[i];

                for (int j = 1; j < tabla.getRowCount(); j++) {
                    for (int k = 1; k < tabla.getColumnCount() - 1; k++) {
                        dato = tabla.getValueAt(j, k).toString();
                        if (estado.contains(dato)) {
                            tabla.setValueAt(estado.get(0), j, k);
                        }
                    }
                }
                if (estado.size() > 1) {

                    for (int j = 1; j < estado.size(); j++) {
                        tabla.removeRow(buscarFilaDeEstado(estado.get(j).toString()));
                    }
                }
                i++;
            }
        }

    }
/**
 *  Ordena una hilera de manera descendente
 * @param hilera
 * @return 
 */
    private String sortString(String hilera) {
        int tamañoHilera = hilera.length();
        String hileraOrdenada = hilera;
        if (tamañoHilera > 1) {
            hileraOrdenada = "";
            ArrayList<String> lista = new ArrayList();
            for (int i = 0; i < tamañoHilera; i++) {
                lista.add(String.valueOf(hilera.charAt(i)));
            }
            Collections.sort(lista);
            for (String simbolo : lista) {
                hileraOrdenada = hileraOrdenada + simbolo;
            }
        }
        hileraOrdenada = hileraOrdenada.replaceAll("(.)\\1", "$1");
        return (hileraOrdenada);
    }

    public void ordenar() {
        String dato;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                dato = tabla.getValueAt(i, j).toString();
                dato = sortString(dato);

                tabla.setValueAt(dato, i, j);
            }
        }
    }

}
