/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Entorno.Type.PrimitiveType;

/**
 *
 * @author anton
 */
public class Primitivo implements Expresion {
    Object value;
    PrimitiveType primitivo;
    int linea;
    int columna;
    public Primitivo(Object value, PrimitiveType primitivo, int linea,int columna) {
        this.value = value;
        this.primitivo = primitivo;
        this.linea = linea;
        this.columna=columna;
    }

    @Override
    public Object getValue(Entorno entorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Type.PrimitiveType getPrimitive_type(){
        return this.primitivo;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}