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
public class SubIf {
    int linea;
    int columna;
    Expresion condicion;
    LinkedList<NodoAST> lista_bloques;
    Boolean esElse;
    public SubIf(Expresion condicion,LinkedList<NodoAST>lista_bloques,Boolean esElse,int linea,int columna) {
        this.linea=linea;
        this.columna=columna;
        this.condicion=condicion;
        this.lista_bloques=lista_bloques;
        this.esElse=esElse;
    }
    public SubIf(int linea,int columna){
        this.condicion=null;
        this.lista_bloques=new LinkedList<>();
        this.esElse=false;
        this.linea=linea;
        this.columna=columna;
    }
}
