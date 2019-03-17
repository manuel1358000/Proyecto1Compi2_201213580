/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones.operacion;

import ArbolAST.AST;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Expresiones.Llamada_Funcion;

/**
 *
 * @author anton
 */
public class Retornar implements Expresion{
    int linea;
    int columna;
    Expresion retorno;
    Type.PrimitiveType tipo_retorno;
    public Retornar(Expresion retorno,int linea,int columna){
        this.retorno=retorno;
        this.linea=linea;
        this.columna=columna;
    }
    public Retornar(int linea,int columna){
        this.linea=linea;
        this.columna=columna;
    }
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        if(this.retorno instanceof Llamada_Funcion){
            respuesta=this.retorno.getValue(entorno);
        }else{
            respuesta=this.retorno.getValue(entorno);
        }
        return respuesta;
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        Type.PrimitiveType re=this.retorno.getType(entorno);
        return re; 
    }

    public Expresion getRetorno() {
        return retorno;
    }

    public void setRetorno(Expresion retorno) {
        this.retorno = retorno;
    }

    public Type.PrimitiveType getTipo_retorno() {
        return tipo_retorno;
    }

    public void setTipo_retorno(Type.PrimitiveType tipo_retorno) {
        this.tipo_retorno = tipo_retorno;
    }
    
    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
