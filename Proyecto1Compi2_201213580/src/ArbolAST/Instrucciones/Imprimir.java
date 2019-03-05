/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;


/**
 *
 * @author anton
 */
public class Imprimir implements Instruccion{
    Type.PrimitiveType tipo;
    Expresion expresion;
    public Imprimir(Expresion expresion){
        this.expresion=expresion;
        this.tipo=Type.PrimitiveType.NULL;
    }
    public Imprimir(){
    
    }

    public Type.PrimitiveType getTipo() {
        return tipo;
    }

    public void setTipo(Type.PrimitiveType tipo) {
        this.tipo = tipo;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }
    
    @Override
    public Object execute(Entorno entorno) {
        Object nuevo=expresion.getValue(entorno);
        if(nuevo!=null){
            System.out.println("SALIDA CONSOLA>"+nuevo.toString());
        }else{
            System.out.println("ERROR SEMANTICO: IMPRIMIR NO ENCONTRO EL VALOR");
        }
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
