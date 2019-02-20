/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Expresiones.Expresion;


/**
 *
 * @author anton
 */
public class Imprimir implements Instruccion{
    Expresion expresion;
    public Imprimir(Expresion expresion){
        this.expresion=expresion;
    }
    public Imprimir(){
    
    }
    @Override
    public Object execute(Entorno entorno) {
        Object nuevo=expresion.getValue(entorno);
        if(nuevo!=null){
            System.out.println(nuevo.toString());
        }
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
