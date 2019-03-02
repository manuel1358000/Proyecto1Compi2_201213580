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
            try{
                if(this.expresion1!=null){
                    Object valor=this.expresion1.getValue(entorno);
                    Type.PrimitiveType tipo=this.expresion1.getType(entorno);
                    this.type=tipo;
                    respuesta=-Integer.parseInt(this.expresion1.getValue(entorno).toString().replaceAll("\"",""));
                }else{
                    if(this.type==Type.PrimitiveType.ID){
                        Simbolo referencia=entorno.Obtener(this.valor.toString());
                        if(referencia!=null){
                            this.type=referencia.tipo;
                            respuesta=referencia.valor;
                        }else{
                            System.out.println("ERROR SEMANTICO: No existe el id " + this.valor.toString());
                            respuesta=null;
                        }
                    }else{
                        respuesta=this.valor;
                    }
                }
            }catch(Exception e){
                System.out.println("OCURRIO UN ERROR EN LA OPERACION UNARIA");
            }
        }else{
            if(this.expresion1!=null&&this.expresion2!=null){
                
                Type.PrimitiveType valor3=this.expresion1.getType(entorno);
                Type.PrimitiveType valor4=this.expresion2.getType(entorno);
                Type.PrimitiveType tipo=GenerarTipo(valor3,valor4,this.operador);  
                if(this.operador==Operador.SUMA){
                    try{
                        if(tipo==Type.PrimitiveType.STRING){
                            this.type=tipo;
                            respuesta=String.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"",""))+String.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"",""));
                        }else if(tipo==Type.PrimitiveType.BOOLEAN){
                            respuesta= null;
                        }else if(tipo==Type.PrimitiveType.NULL){
                            respuesta=null;
                        }else if(tipo==Type.PrimitiveType.INTEGER){
                            this.type=tipo;
                            respuesta=Integer.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"",""))+Integer.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"",""));
                        }else{
                            this.type=tipo;
                            respuesta=Double.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"",""))+Double.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"",""));
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA OPERACION SUMA");
                    }
                }else if(this.operador==Operador.RESTA){
                    try{
                        if(tipo==Type.PrimitiveType.INTEGER){
                            this.type=tipo;
                            respuesta= Integer.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"",""))-Integer.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"",""));
                        }else if(tipo==Type.PrimitiveType.DOUBLE){
                            this.type=tipo;
                            respuesta= Double.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"",""))-Double.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"",""));
                        }else{
                            respuesta=null;
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA OPERACION RESTA");
                    }
                }else if(this.operador==Operador.MULTIPLICACION){
                    try{
                        if(tipo==Type.PrimitiveType.INTEGER){
                            this.type=tipo;
                            respuesta= Integer.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"",""))*Integer.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"",""));
                        }else if(tipo==Type.PrimitiveType.DOUBLE){
                            this.type=tipo;
                            respuesta= Double.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"",""))*Double.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"",""));
                        }else{
                            //error semantico
                            respuesta=null;
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA OPERACION MULTIPLICACION");
                    }
                }else if(this.operador==Operador.DIVISION){
                    try{
                        if(tipo==Type.PrimitiveType.DOUBLE){
                            this.type=tipo;
                            respuesta= Double.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"",""))/Double.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"",""));
                            if(Double.parseDouble(respuesta.toString())==Double.POSITIVE_INFINITY){
                                respuesta= null;
                            }
                        }else{
                            //error semantico
                            respuesta=null;
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA OPERACION DIVISION");
                    }
                }else if(this.operador==Operador.POTENCIA){
                    try{
                        if(tipo==Type.PrimitiveType.DOUBLE){
                            this.type=tipo;
                            respuesta= Math.pow(Double.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"","")),Double.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"","")));
                        }else if(tipo==Type.PrimitiveType.INTEGER){
                            this.type=tipo;
                            respuesta= Math.pow(Integer.valueOf(this.expresion1.getValue(entorno).toString().replaceAll("\"","")),Integer.valueOf(this.expresion2.getValue(entorno).toString().replaceAll("\"","")));
                        }else{
                            respuesta=null;
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA OPERACION POTENCIA");
                    }
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
                        System.out.println("ERROR SEMANTICO: No existe el id "+this.line);
                        respuesta=null;
                    }
                }else{
                    try{
                        respuesta=this.valor;
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICO: OCURRIO UN ERROR AL MOMENTO DE RETORNAR EL VALOR EN ARITMETICA");
                    }
                    
                }
            }
        }
        return respuesta;
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        Type.PrimitiveType respuesta=this.type;
        if(this.type==Type.PrimitiveType.ID){
           Simbolo sim=(Simbolo)entorno.Obtener(this.valor.toString());
           respuesta=sim.tipo;
        }
        return respuesta;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Type.PrimitiveType GenerarTipo(Type.PrimitiveType primero,Type.PrimitiveType segundo,Operacion.Operador operador){
        Type.PrimitiveType respuesta=Type.PrimitiveType.NULL;
        try{
            if(primero==Type.PrimitiveType.STRING||segundo==Type.PrimitiveType.STRING){
                if(operador==Operador.SUMA){
                    respuesta= Type.PrimitiveType.STRING;
                }else{
                    respuesta= Type.PrimitiveType.NULL;
                }
            }else if(primero==Type.PrimitiveType.DOUBLE||segundo==Type.PrimitiveType.DOUBLE){
                if((operador==Operador.RESTA||operador==Operador.SUMA||operador==Operador.MULTIPLICACION||operador==Operador.DIVISION||operador==Operador.POTENCIA)&&(primero==Type.PrimitiveType.BOOLEAN||segundo==Type.PrimitiveType.BOOLEAN)){
                    respuesta= Type.PrimitiveType.NULL;
                }else{
                    respuesta=Type.PrimitiveType.DOUBLE;
                } 
            }else if(primero==Type.PrimitiveType.INTEGER||segundo==Type.PrimitiveType.INTEGER){
                if((operador==Operador.RESTA||operador==Operador.SUMA||operador==Operador.MULTIPLICACION||operador==Operador.POTENCIA)&&(primero==Type.PrimitiveType.BOOLEAN||segundo==Type.PrimitiveType.BOOLEAN)){
                    respuesta= Type.PrimitiveType.NULL;
                }else{
                    respuesta=Type.PrimitiveType.INTEGER;
                } 
                if(operador==Operador.DIVISION){
                    if(primero==Type.PrimitiveType.BOOLEAN||segundo==Type.PrimitiveType.BOOLEAN){
                        respuesta= Type.PrimitiveType.NULL;
                    }else{
                        respuesta= Type.PrimitiveType.DOUBLE;
                    }
                }
            }else{
                respuesta= Type.PrimitiveType.NULL;
            }
        }catch(Exception e){
            System.out.println("OCURRIO UN ERROR AL MOMENTO DE GENERAR TIPOS EN ARITMETICA");
        }
        return respuesta;
    }
    
}
