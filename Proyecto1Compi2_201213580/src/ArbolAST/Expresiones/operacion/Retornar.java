/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones.operacion;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;

/**
 *
 * @author anton
 */
public class Retornar implements Expresion{
    Expresion retorno;
    
    public Retornar(Expresion retorno){
        this.retorno=retorno;
    }
    @Override
    public Object getValue(Entorno entorno) {
        return this.retorno.getValue(entorno);
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        return this.retorno.getType(entorno);
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
