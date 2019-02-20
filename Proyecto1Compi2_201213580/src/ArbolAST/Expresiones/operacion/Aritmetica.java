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
    public Aritmetica(Object valor,Type.PrimitiveType type) {
        super(valor,type);
    }
   
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        if(this.expresion1!=null&&this.expresion2!=null){
            Object valor1=this.expresion1.getValue(entorno);
            Object valor2=this.expresion2.getValue(entorno);
            Type.PrimitiveType tipo=GenerarTipo(this.expresion1.getType(entorno),this.expresion2.getType(entorno),this.operador);    
            if(this.operador==Operador.SUMA){
                if(tipo==Type.PrimitiveType.INTEGER){
                    respuesta=Integer.parseInt(valor1.toString())+Integer.parseInt(valor2.toString());
                    this.type=tipo;
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    respuesta=Double.parseDouble(valor1.toString())+Double.parseDouble(valor2.toString());
                    this.type=tipo;
                }
            }else if(this.operador==Operador.RESTA){
                if(tipo==Type.PrimitiveType.INTEGER){
                    respuesta=Integer.parseInt(valor1.toString())-Integer.parseInt(valor2.toString());
                    this.type=tipo;
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    respuesta=Double.parseDouble(valor1.toString())-Double.parseDouble(valor2.toString());
                    this.type=tipo;
                }
            }else if(this.operador==Operador.MULTIPLICACION){
                if(tipo==Type.PrimitiveType.INTEGER){
                    respuesta=Integer.parseInt(valor1.toString())*Integer.parseInt(valor2.toString());
                    this.type=tipo;
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    respuesta=Double.parseDouble(valor1.toString())*Double.parseDouble(valor2.toString());
                    this.type=tipo;
                }
            }else if(this.operador==Operador.DIVISION){
                if(tipo==Type.PrimitiveType.INTEGER){
                    respuesta=Integer.parseInt(valor1.toString())/Integer.parseInt(valor2.toString());
                    if(Integer.parseInt(String.valueOf(respuesta))==Integer.MAX_VALUE){
                        //Es una operacion 
                        respuesta=0;
                        System.out.println("Error Division por cero");
                    }
                    this.type=tipo;
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    respuesta=Double.parseDouble(valor1.toString())/Double.parseDouble(valor2.toString());
                    if(Double.parseDouble(String.valueOf(respuesta))==Double.POSITIVE_INFINITY){
                        //Es una operacion 
                        System.out.println("Error division por cero");
                        respuesta=0;
                    }
                    this.type=tipo;
                }
            }else{
                System.out.println("Operacion no definida");
            }
        }else{
            if(this.type==Type.PrimitiveType.ID){
                Simbolo referencia=entorno.Obtener(this.valor.toString());
                if(referencia!=null){
                    respuesta=referencia.valor;
                    this.type=referencia.tipo;
                }else{
                    System.out.println("No existe el id " + this.valor.toString());
                }
                
            }else{
                respuesta=this.valor;
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
        if(primero==Type.PrimitiveType.INTEGER&&segundo==Type.PrimitiveType.INTEGER){
            if(operador==Operador.SUMA||operador==Operador.RESTA||operador==Operador.MULTIPLICACION){
                return Type.PrimitiveType.INTEGER;
            }else{
                return Type.PrimitiveType.DOUBLE;
            }
        }else if(primero==Type.PrimitiveType.INTEGER&&segundo==Type.PrimitiveType.DOUBLE){
            return Type.PrimitiveType.DOUBLE;
        }else if(primero==Type.PrimitiveType.DOUBLE&&segundo==Type.PrimitiveType.INTEGER){
            return Type.PrimitiveType.DOUBLE;
        }else if(primero==Type.PrimitiveType.DOUBLE&&segundo==Type.PrimitiveType.DOUBLE){
            return Type.PrimitiveType.DOUBLE;
        }else{
            return null;
        }
    }
}
