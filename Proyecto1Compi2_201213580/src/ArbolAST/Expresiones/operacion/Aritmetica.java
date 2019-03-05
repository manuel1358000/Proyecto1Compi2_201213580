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
                System.out.println(this.type);
                if(this.expresion1!=null){
                    Type.PrimitiveType valor=this.expresion1.getType(entorno);
                    Object val=null;
                    if(this.expresion1 instanceof Llamada_Funcion){
                        Llamada_Funcion llamada=(Llamada_Funcion)this.expresion1;
                        val=llamada.getValue(entorno);
                        valor=llamada.getTipo_respuesta();
                    }else{
                        valor=this.expresion1.getType(entorno);
                    }
                    this.type=valor;
                    respuesta=-Integer.parseInt(val.toString());
                }else{
                    System.out.println(this.type);
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
            System.out.println(this.type);
            if(this.expresion1!=null&&this.expresion2!=null){
                Type.PrimitiveType valor3=this.expresion1.getType(entorno);
                Type.PrimitiveType valor4=this.expresion2.getType(entorno);
                Object val1=null;
                Object val2=null;
                if(this.expresion1 instanceof Llamada_Funcion){
                    Llamada_Funcion llamada=(Llamada_Funcion)this.expresion1;
                    val1=llamada.getValue(entorno);
                    valor3=llamada.getTipo_respuesta();
                }else{
                    valor3=this.expresion1.getType(entorno);
                }
                
                if(this.expresion2 instanceof Llamada_Funcion){
                    Llamada_Funcion llamada=(Llamada_Funcion)this.expresion2;
                    val2=llamada.getValue(entorno);
                    valor4=llamada.getTipo_respuesta();
                }else{
                    valor4=this.expresion2.getType(entorno);
                }
                Type.PrimitiveType tipo=GenerarTipo(valor3,valor4,this.operador); 
                if(this.operador==Operador.SUMA){
                    try{
                        if(tipo==Type.PrimitiveType.STRING){
                            this.type=tipo;
                            if(val1==null){
                                val1=this.expresion1.getValue(entorno).toString().replaceAll("\"","");
                            }
                            if(val2==null){
                                val2=this.expresion2.getValue(entorno).toString().replaceAll("\"","");
                            }
                            respuesta=String.valueOf(val1)+String.valueOf(val2);
                        }else if(tipo==Type.PrimitiveType.BOOLEAN){
                            respuesta= null;
                        }else if(tipo==Type.PrimitiveType.NULL){
                            System.out.println("EL TIPO ES NULO");
                            respuesta=null;
                        }else if(tipo==Type.PrimitiveType.INTEGER){
                            this.type=tipo;
                            if(val1==null){
                                val1=this.expresion1.getValue(entorno).toString().replaceAll("\"","");
                            }
                            if(val2==null){
                                val2=this.expresion2.getValue(entorno).toString().replaceAll("\"","");
                            }
                            respuesta=Integer.valueOf(val1.toString())+Integer.valueOf(val2.toString());
                        }else{
                            this.type=tipo;
                            if(val1==null){
                                val1=this.expresion1.getValue(entorno).toString().replaceAll("\"","");
                            }
                            if(val2==null){
                                val2=this.expresion2.getValue(entorno).toString().replaceAll("\"","");
                            }
                            respuesta=Double.valueOf(val1.toString())+Double.valueOf(val2.toString());
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
                        if(referencia.valor instanceof Expresion){
                            respuesta=((Expresion)referencia.valor).getValue(entorno);
                        }else{
                            this.type=referencia.tipo;
                            respuesta=referencia.valor;
                        }
                    }else{
                        System.out.println("ERROR SEMANTICO: No existe el id "+this.valor);
                        respuesta=null;
                    }
                }else if(this.type==Type.PrimitiveType.FUNCION){
                    System.out.println("ESTA INGRESANDO AQUI");
                    
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
