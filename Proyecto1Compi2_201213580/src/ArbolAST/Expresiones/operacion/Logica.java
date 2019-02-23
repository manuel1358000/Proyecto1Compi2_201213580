/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones.operacion;

import ArbolAST.Expresiones.operacion.Operacion.Operador;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;

/**
 *
 * @author anton
 */
public class Logica extends Operacion implements Expresion{
    
    public Logica(Expresion expresion1, Expresion expresion2, Operador operador) {
        super(expresion1, expresion2, operador);
    }
    public Logica(Object valor,Type.PrimitiveType type) {
        super(valor,type);
    }
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        return respuesta;
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {        
        return this.type;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
