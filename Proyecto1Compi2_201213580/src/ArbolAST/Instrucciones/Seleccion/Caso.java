/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones.Seleccion;

import ArbolAST.Expresiones.Expresion;
import ArbolAST.NodoAST;
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class Caso {
    int linea;
    int columna;
    Expresion condicion;
    LinkedList<NodoAST> lista_bloques;
    boolean defecto;
    public Caso(Expresion condicion, LinkedList<NodoAST> lista_bloques,int linea,int columna) {
        this.linea=linea;
        this.columna=columna;
        this.condicion = condicion;
        this.lista_bloques = lista_bloques;
    }
    public Caso(LinkedList<NodoAST> lista_bloques,int linea,int columna) {
        this.lista_bloques = lista_bloques;
        this.linea=linea;
        this.columna=columna;
    }
}
