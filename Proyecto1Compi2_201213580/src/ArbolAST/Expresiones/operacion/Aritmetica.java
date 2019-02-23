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
public class Aritmetica extends Operacion implements Expresion{

    public Aritmetica(Expresion expresion1, Expresion expresion2, Operador operador) {
        super(expresion1, expresion2, operador);
    }
    public Aritmetica(Expresion expresion1, boolean valor, Operador operador) {
        super(expresion1, valor, operador);
    }
    public Aritmetica(Object valor,Type.PrimitiveType type) {
        super(valor,type);
    }
   
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta = null;
        if(this.unario){
            return null;
        }else{
            if(this.expresion1!=null&&this.expresion2!=null){
                Type.PrimitiveType valor3=this.expresion1.getType(entorno);
                Type.PrimitiveType valor4=this.expresion2.getType(entorno);
                Type.PrimitiveType tipo=GenerarTipo(valor3,valor4,this.operador);  
                if(this.operador==Operador.SUMA){
                    if(tipo==Type.PrimitiveType.STRING){
                        this.type=tipo;
                        respuesta= String.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"",""))+String.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"",""));
                    }else if(tipo==Type.PrimitiveType.BOOLEAN){
                        respuesta= null;
                    }else{
                        this.type=tipo;
                        respuesta=Double.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"",""))+Double.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"",""));
                    }
                }else if(this.operador==Operador.RESTA){
                }else{
                    respuesta=null;
                }
            }else{
                if(this.type==Type.PrimitiveType.ID){
                    Simbolo referencia=entorno.Obtener(this.valor.toString());
                    if(referencia!=null){
                        this.type=referencia.tipo;
                        respuesta=referencia.valor;
                    }else{
                        System.out.println("No existe el id " + this.valor.toString());
                        respuesta=null;
                    }
                }else{
                    respuesta=this.valor;
                }
            }
        }
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
    public Type.PrimitiveType GenerarTipo(Type.PrimitiveType primero,Type.PrimitiveType segundo,Operacion.Operador operador){
        if(primero==Type.PrimitiveType.STRING||segundo==Type.PrimitiveType.STRING){
            return Type.PrimitiveType.STRING;
        }else if(primero==Type.PrimitiveType.DOUBLE||segundo==Type.PrimitiveType.DOUBLE){
            return Type.PrimitiveType.DOUBLE;
        }else if(primero==Type.PrimitiveType.INTEGER||segundo==Type.PrimitiveType.INTEGER){
            if(operador==Operador.DIVISION){
                return Type.PrimitiveType.DOUBLE;
            }else{
                return Type.PrimitiveType.INTEGER;
            }
        }else{
            return Type.PrimitiveType.NULL;
        }
    }
}
