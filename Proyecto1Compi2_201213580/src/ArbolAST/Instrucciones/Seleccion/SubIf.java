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
    Expresion condicion;
    LinkedList<NodoAST> lista_bloques;
    Boolean esElse;
    public SubIf(Expresion condicion,LinkedList<NodoAST>lista_bloques,Boolean esElse) {
        this.condicion=condicion;
        this.lista_bloques=lista_bloques;
        this.esElse=esElse;
    }
    public SubIf(){
        this.condicion=null;
        this.lista_bloques=new LinkedList<>();
        this.esElse=false;
    }
}
