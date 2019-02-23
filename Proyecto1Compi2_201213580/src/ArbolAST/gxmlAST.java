/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Instrucciones.Declaracion;
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class gxmlAST {
    public static LinkedList<NodoAST>nodos;
    public gxmlAST(LinkedList<NodoAST> nodos) {
        this.nodos = nodos;
    }
    public void execute(){
        //aqui tengo que hacer la ejecucion
    }
}
