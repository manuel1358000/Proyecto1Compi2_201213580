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
public class Obtener implements Expresion{
    String id;
    Type.PrimitiveType tipo;
    Expresion parametro;
    Expresion parametro2;

    public Obtener(String id,Type.PrimitiveType tipo,Expresion parametro,Expresion parametro2){
        this.id=id;
        this.tipo=tipo;
        this.parametro=parametro;
        this.parametro2=parametro2;
    }
    public Obtener(String id,Type.PrimitiveType tipo,Expresion parametro){
        this.id=id;
        this.tipo=tipo;
        this.parametro=parametro;
        this.parametro2=null;
    }
    public Obtener() {
    }
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        if(tipo==Type.PrimitiveType.PORETIQUETA){
        }else if(tipo==Type.PrimitiveType.PORID){
        }else if(tipo==Type.PrimitiveType.PORNOMBRE){
        }
        return respuesta;
    }
    public void recorrerArbol(){
        
    }
    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        return this.tipo;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
