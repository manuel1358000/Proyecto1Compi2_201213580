/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Expresiones.operacion.Operacion.Operador;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.operacion.Operacion;

/**
 *
 * @author anton
 */
public class Asignacion implements Instruccion{
    String id;
    Expresion asigna;
    Operador operador;
    int linea;
    int columna;
    public Asignacion(String id,Expresion asigna,Operador operador,int linea,int columna){
        this.id=id;
        this.asigna=asigna;
        this.operador=operador;
        this.linea=linea;
        this.columna=columna;
    }
    @Override
    public Object execute(Entorno entorno) {
        Object valor=this.asigna.getValue(entorno);
        Type.PrimitiveType tipo_asigna=this.asigna.getType(entorno);
        if(valor!=null){
            if(this.operador==Operador.AUMENTO){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    if(tipo_asigna==Type.PrimitiveType.INTEGER){
                        sim.valor=Integer.parseInt(valor.toString())+1;
                        sim.tipo=tipo_asigna;
                        entorno.Actualizar(this.id, sim);
                    }else if(tipo_asigna==Type.PrimitiveType.DOUBLE){
                        sim.valor=Double.parseDouble(valor.toString())+1;
                        sim.tipo=tipo_asigna;
                        entorno.Actualizar(id, sim);
                    }else{
                        System.out.println("ERROR SEMANTICO: SOLO SE PUEDEN INCREMENTAR VARIABLES DE TIPO INTEGER Y DOUBLE");
                    }   
                }else{
                    System.out.println("NO EXISTE LA VARIABLE A AUMENTAR");
                }
            }else if(this.operador==Operador.DECREMENTO){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    if(tipo_asigna==Type.PrimitiveType.INTEGER){
                        sim.valor=Integer.parseInt(valor.toString())-1;
                        sim.tipo=tipo_asigna;
                        entorno.Actualizar(this.id, sim);
                    }else if(tipo_asigna==Type.PrimitiveType.DOUBLE){
                        sim.valor=Double.parseDouble(valor.toString())-1;
                        sim.tipo=tipo_asigna;
                        entorno.Actualizar(id, sim);
                    }else{
                        System.out.println("ERROR SEMANTICO: SOLO SE PUEDEN INCREMENTAR VARIABLES DE TIPO INTEGER Y DOUBLE");
                    }   
                }else{
                    System.out.println("NO EXISTE LA VARIABLE A AUMENTAR");
                }
            }else if(this.operador==Operador.IGUAL){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    sim.valor=valor;
                    sim.tipo=tipo_asigna;
                    entorno.Actualizar(this.id, sim);
                }else{
                    System.out.println("No existe la variable a asignar");
                }
            }else if(this.operador==Operador.A_SUMA){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    Type.PrimitiveType resultante=GenerarTipo(tipo_asigna,sim.tipo,Operador.SUMA);
                    if(resultante==Type.PrimitiveType.NULL){
                        System.out.println("ERROR SEMANTICO: LOS TIPOS NO SE PUEDEN OPERARAR PARA UNA SUMA");
                    }else{
                        if(resultante==Type.PrimitiveType.INTEGER){
                            sim.valor=Integer.parseInt(sim.valor.toString())+Integer.parseInt(valor.toString());
                            sim.tipo=resultante;
                            entorno.Actualizar(this.id, sim);
                        }else if(resultante==Type.PrimitiveType.DOUBLE){
                            sim.valor=Double.parseDouble(sim.valor.toString())+Double.parseDouble(valor.toString());
                            sim.tipo=resultante;
                            entorno.Actualizar(this.id, sim);
                        }else if(resultante==Type.PrimitiveType.STRING){
                            sim.valor="\""+String.valueOf(sim.valor.toString().replaceAll("\"",""))+String.valueOf(valor.toString().replaceAll("\"",""))+"\"";
                            sim.tipo=resultante;
                            entorno.Actualizar(this.id, sim);
                        }else{
                            System.out.println("ERROR SEMANTICO: TIPOS DIFERENTES EN LA OPERACION +=");
                        }
                    }
                }else{
                    System.out.println("No existe la variable a asignar");
                }
            }else if(this.operador==Operador.A_RESTA){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    Type.PrimitiveType resultante=GenerarTipo(tipo_asigna,sim.tipo,Operador.RESTA);
                    if(resultante==Type.PrimitiveType.NULL){
                        System.out.println("ERROR SEMANTICO: LOS TIPOS NO SE PUEDEN OPERARAR PARA UNA SUMA");
                    }else{
                        if(resultante==Type.PrimitiveType.INTEGER){
                            sim.valor=Integer.parseInt(sim.valor.toString())-Integer.parseInt(valor.toString());
                            sim.tipo=resultante;
                            entorno.Actualizar(this.id, sim);
                        }else if(resultante==Type.PrimitiveType.DOUBLE){
                            sim.valor=Double.parseDouble(sim.valor.toString())-Double.parseDouble(valor.toString());
                            sim.tipo=resultante;
                            entorno.Actualizar(this.id, sim);
                        }else{
                            System.out.println("ERROR SEMANTICO: TIPOS DIFERENTES EN LA OPERACION -=");
                        }
                        
                    }
                }else{
                    System.out.println("No existe la variable a asignar");
                }
            }else if(this.operador==Operador.A_MULT){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    Type.PrimitiveType resultante=GenerarTipo(tipo_asigna,sim.tipo,Operador.MULTIPLICACION);
                    if(resultante==Type.PrimitiveType.NULL){
                        System.out.println("ERROR SEMANTICO: LOS TIPOS NO SE PUEDEN OPERARAR PARA UNA SUMA");
                    }else{
                        if(resultante==Type.PrimitiveType.INTEGER){
                            sim.valor=Integer.parseInt(sim.valor.toString())*Integer.parseInt(valor.toString());
                            sim.tipo=resultante;
                            entorno.Actualizar(this.id, sim);
                        }else if(resultante==Type.PrimitiveType.DOUBLE){
                            sim.valor=Double.parseDouble(sim.valor.toString())*Double.parseDouble(valor.toString());
                            sim.tipo=resultante;
                            entorno.Actualizar(this.id, sim);
                        }else{
                            System.out.println("ERROR SEMANTICO: TIPOS DIFERENTES EN LA OPERACION *=");
                        }
                        
                    }
                }else{
                    System.out.println("No existe la variable a asignar");
                }
            }else if(this.operador==Operador.A_DIV){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    Type.PrimitiveType resultante=GenerarTipo(tipo_asigna,sim.tipo,Operador.DIVISION);
                    if(resultante==Type.PrimitiveType.NULL){
                        System.out.println("ERROR SEMANTICO: LOS TIPOS NO SE PUEDEN OPERARAR PARA UNA SUMA");
                    }else{
                        if(resultante==Type.PrimitiveType.INTEGER){
                            int val=Integer.parseInt(sim.valor.toString())/Integer.parseInt(valor.toString());
                            if(val==Integer.MAX_VALUE){
                                System.out.println("ERROR: RESULTADO INFINITO DIVISION POR CERO");
                            }else{
                                sim.valor=val;
                                sim.tipo=resultante;
                                entorno.Actualizar(this.id, sim);
                            }
                        }else if(resultante==Type.PrimitiveType.DOUBLE){
                            double val=Double.parseDouble(sim.valor.toString())/Double.parseDouble(valor.toString());
                            if(val==Double.POSITIVE_INFINITY||val==Double.NEGATIVE_INFINITY){
                                System.out.println("ERROR DIVISION POR CERO, RESULTADO INFINITO \n NO SE REALIZARA LA OPERACION");
                            }else{
                                sim.valor=val;
                                sim.tipo=resultante;
                                entorno.Actualizar(this.id, sim);
                            }
                            
                        }else{
                            System.out.println("ERROR SEMANTICO: TIPOS DIFERENTES EN LA OPERACION /=");
                        }
                        
                    }
                }else{
                    System.out.println("No existe la variable a asignar");
                }
            }else{
                System.out.println("ERROR SEMANTICO: OPERADOR NO ENCONTRADO, ASIGNACION LINEA:"+this.linea+" Columna:"+this.columna);
            }
        }else{
            System.out.println("ERROR SEMANTICO: LA EXPRESION QUE DESEA ASIGNAR NO EXISTE O ES NULA");
        }return null;
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
    
    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
