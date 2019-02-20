/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones;

import ArbolAST.NodoAST;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Instrucciones.Instruccion;

/**
 *
 * @author anton
 */
public interface Expresion extends NodoAST{
    
    Object getValue(Entorno entorno);
    Type.PrimitiveType getType(Entorno entorno);
}