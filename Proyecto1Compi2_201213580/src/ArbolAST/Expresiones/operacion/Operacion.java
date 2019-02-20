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
public class Operacion implements Expresion{
    Expresion expresion1;
    Expresion expresion2;
    Operador operador;
    int line;
    boolean unario;
    Type.PrimitiveType type;
    Object valor;
    
    public Operacion(Expresion expresion1,Expresion expresion2,Operador operador){
        this.expresion1=expresion1;
        this.expresion2=expresion2;
        this.operador=operador;
    }
    public Operacion(Object valor,Type.PrimitiveType type){
        this.valor=valor;
        this.type=type;
    }
    @Override
    public Object getValue(Entorno entorno) {
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
    
    
    public enum Operador{
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION
    }  
    
}
