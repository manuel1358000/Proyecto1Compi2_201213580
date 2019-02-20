/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;

/**
 *
 * @author anton
 */
public class Identificador implements Expresion{
    String id;
    int linea;

    @Override
    public Object getValue(Entorno entorno) {
        //ir a buscar al entorno si existe
        //ir al entorno y encontrar el simbolo con toda la variable
        //ir a buscar a la memoria los valores
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
