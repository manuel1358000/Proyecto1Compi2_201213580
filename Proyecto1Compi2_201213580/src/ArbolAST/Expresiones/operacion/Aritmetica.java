/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones.operacion;

import ArbolAST.AST;
import ArbolAST.Expresiones.operacion.Operacion.Operador;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.AccesoArreglo;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Expresiones.Llamada_Funcion;
import ArbolAST.Instrucciones.Funcion;

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
                    Object val=this.expresion1.getValue(entorno);
                    Type.PrimitiveType valor=this.expresion1.getType(entorno);
                    if(this.expresion1 instanceof Llamada_Funcion){
                        Llamada_Funcion llamada=(Llamada_Funcion)this.expresion1;
                        val=llamada.getValue(entorno);
                        valor=llamada.getTipo_respuesta();
                    }
                    this.type=valor;
                    if(this.type==Type.PrimitiveType.INTEGER){
                        if(this.operador==Operador.UNARIO){
                            respuesta=-Integer.parseInt(val.toString());
                        }else if(this.operador==Operador.AUMENTO){
                            respuesta=Integer.parseInt(val.toString())+1;
                        }else if(this.operador==Operador.DECREMENTO){
                            respuesta=Integer.parseInt(val.toString())-1;
                        }
                        
                    }else if(this.type==Type.PrimitiveType.DOUBLE){
                        if(this.operador==Operador.UNARIO){
                            respuesta=-Double.parseDouble(val.toString());
                        }else if(this.operador==Operador.AUMENTO){
                            respuesta=Double.parseDouble(val.toString())+1;
                        }else if(this.operador==Operador.DECREMENTO){
                            respuesta=Double.parseDouble(val.toString())-1;
                        }
                    }else if(this.type==Type.PrimitiveType.ARREGLO){
                        AccesoArreglo acceso=(AccesoArreglo)this.expresion1;
                        Object valor_arreglo=acceso.getValue(entorno);
                        Type.PrimitiveType tipo_arreglo=acceso.getTipo_Respuesta();
                        if(tipo_arreglo==Type.PrimitiveType.INTEGER){
                            this.type=tipo_arreglo;
                            if(this.operador==Operador.UNARIO){
                                respuesta=-Integer.parseInt(valor_arreglo.toString());
                            }else if(this.operador==Operador.AUMENTO){
                                respuesta=Integer.parseInt(valor_arreglo.toString())+1;
                            }else if(this.operador==Operador.DECREMENTO){
                                respuesta=Integer.parseInt(valor_arreglo.toString())-1;
                            }
                        }else if(tipo_arreglo==Type.PrimitiveType.DOUBLE){
                            this.type=tipo_arreglo;
                            if(this.operador==Operador.UNARIO){
                                respuesta=-Double.parseDouble(valor_arreglo.toString());
                            }else if(this.operador==Operador.AUMENTO){
                                respuesta=Double.parseDouble(valor_arreglo.toString())+1;
                            }else if(this.operador==Operador.DECREMENTO){
                                respuesta=Double.parseDouble(valor_arreglo.toString())-1;
                            }
                        }
                    }
                }else{
                    if(this.type==Type.PrimitiveType.ID){
                        Simbolo referencia=entorno.Obtener(this.valor.toString());
                        if(referencia!=null){
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
                Object val1=null;
                Object val2=null;
                Type.PrimitiveType valor3=null;
                Type.PrimitiveType valor4=null;
                if(this.expresion1 instanceof Llamada_Funcion){
                    Llamada_Funcion llamada=(Llamada_Funcion)this.expresion1;
                    val1=llamada.getValue(entorno);
                    valor3=llamada.getTipo_respuesta();
                    System.out.println("");
                }else{
                    val1=this.expresion1.getValue(entorno).toString().replaceAll("\"","");
                    valor3=this.expresion1.getType(entorno);
                }
                if(this.expresion2 instanceof Llamada_Funcion){
                    Llamada_Funcion llamada=(Llamada_Funcion)this.expresion2;
                    val2=llamada.getValue(entorno);
                    valor4=llamada.getTipo_respuesta();
                    System.out.println("");
                }else{
                    val2=this.expresion2.getValue(entorno).toString().replaceAll("\"","");
                    valor4=this.expresion2.getType(entorno);
                }
                
                Type.PrimitiveType tipo=GenerarTipo(valor3,valor4,this.operador); 
                if(this.operador==Operador.SUMA){
                    try{
                        if(tipo==Type.PrimitiveType.STRING){
                            this.type=tipo;
                            respuesta=String.valueOf(val1)+String.valueOf(val2);
                        }else if(tipo==Type.PrimitiveType.BOOLEAN){
                            respuesta= null;
                        }else if(tipo==Type.PrimitiveType.NULL){
                            System.out.println("EL TIPO ES NULO");
                            respuesta=null;
                        }else if(tipo==Type.PrimitiveType.INTEGER){
                            this.type=tipo;
                            respuesta=Double.valueOf(val1.toString())+Double.valueOf(val2.toString());
                            System.out.println("Que lleva respuesta");
                        }else{
                            this.type=tipo;
                            respuesta=Double.valueOf(val1.toString())+Double.valueOf(val2.toString());
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA OPERACION SUMA");
                    }
                }else if(this.operador==Operador.RESTA){
                    try{
                        if(tipo==Type.PrimitiveType.INTEGER){
                            this.type=tipo;
                            respuesta= Double.valueOf(val1.toString())-Double.valueOf(val2.toString());
                        }else if(tipo==Type.PrimitiveType.DOUBLE){
                            this.type=tipo;
                            respuesta= Double.valueOf(val1.toString())-Double.valueOf(val2.toString());
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
                            respuesta=Double.parseDouble(val1.toString())*Double.parseDouble(val2.toString());
                        }else if(tipo==Type.PrimitiveType.DOUBLE){
                            this.type=Type.PrimitiveType.DOUBLE;
                            respuesta= Double.valueOf(val1.toString())*Double.valueOf(val2.toString());
                        }else{
                            //error semantico
                            System.out.println("multiplicacion");
                            respuesta=null;
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA OPERACION MULTIPLICACION");
                    }
                }else if(this.operador==Operador.DIVISION){
                    try{
                        if(tipo==Type.PrimitiveType.DOUBLE){
                            this.type=type.DOUBLE;
                            respuesta= Double.valueOf(val1.toString())/Double.valueOf(val2.toString());
                            if(Double.parseDouble(respuesta.toString())==Double.POSITIVE_INFINITY){
                                respuesta= null;
                            }
                        }else{
                            //error semantico
                            System.out.println("division rara");
                            respuesta=null;
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA OPERACION DIVISION");
                    }
                }else if(this.operador==Operador.POTENCIA){
                    try{
                        if(tipo==Type.PrimitiveType.DOUBLE){
                            this.type=tipo;
                            respuesta= Math.pow(Double.valueOf(val1.toString()),Double.valueOf(val2.toString()));
                        }else if(tipo==Type.PrimitiveType.INTEGER){
                            this.type=tipo;
                            respuesta= Math.pow(Double.valueOf(val1.toString()),Double.valueOf(val2.toString()));
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
                        if(referencia.valor instanceof Expresion){
                            respuesta=((Expresion)referencia.valor).getValue(entorno);
                        }else{
                            
                            respuesta=referencia.valor;
                            this.type=referencia.tipo;
                            
                        }
                    }else{
                        System.out.println("ERROR SEMANTICO: No existe el id "+this.valor);
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
           respuesta=sim.tipo_implicito;
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
