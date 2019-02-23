/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Instrucciones.Declaracion;
import ArbolAST.Instrucciones.Imprimir;
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class AST {
    public static LinkedList<NodoAST>nodes;
    public AST(LinkedList<NodoAST> nodes) {
        this.nodes = nodes;
    }
    public void execute(){
        Entorno global=new Entorno(null);
        for(NodoAST node: nodes){
            if(node instanceof Declaracion){
                Declaracion declaracion=(Declaracion) node;
                declaracion.execute(global);
            }
        }
    }
}