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
public class Ternario implements Expresion {

    Expresion condicion;
    Expresion isVerdadero;
    Expresion isFalso;
    public Ternario(Expresion condicion,Expresion isVerdadero,Expresion isFalso){
        this.condicion=condicion;
        if((condicion instanceof Relacional)||(condicion instanceof Logica)){
            this.isVerdadero=isVerdadero;
            this.isFalso=isFalso;
        }else{
            System.out.println("Error Semantico");
        }
    }

   
    @Override
    public Object getValue(Entorno entorno) {
        return (boolean)condicion.getValue(entorno)?isVerdadero.getValue(entorno):isFalso.getValue(entorno);
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        return (boolean)condicion.getValue(entorno)?isVerdadero.getType(entorno):isFalso.getType(entorno);
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
