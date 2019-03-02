/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Entorno.Simbolos;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Instrucciones.Detener;
import ArbolAST.Expresiones.operacion.Retornar;
import ArbolAST.Instrucciones.Instruccion;
import ArbolAST.NodoAST;

/**
 *
 * @author anton
 */
public class Funcion extends Simbolo implements Instruccion{
    @Override
    public Object execute(Entorno entorno) {
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
