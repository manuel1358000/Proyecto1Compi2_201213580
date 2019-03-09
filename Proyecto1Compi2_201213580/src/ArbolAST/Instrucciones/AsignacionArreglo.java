/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Expresiones.Llamada_Funcion;
import ArbolAST.Expresiones.operacion.Aritmetica;
import ArbolAST.Expresiones.operacion.Operacion;
import ArbolAST.Expresiones.operacion.Operacion.Operador;
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class AsignacionArreglo implements Instruccion{
    String id;//este es el nombre de la variable que es un arreglo
    Expresion asigna; //
    Expresion posicion;
    Operador operador;

    public AsignacionArreglo(String id,Expresion asigna,Expresion posicion,Operador operador){
        this.id=id;
        this.asigna=asigna;
        this.posicion=posicion;
        this.operador=operador;
    }
    
    
    
    @Override
    public Object execute(Entorno entorno) {
        Object valor=this.asigna.getValue(entorno);
        Type.PrimitiveType tipo=this.asigna.getType(entorno);
        int pos=Integer.parseInt(this.posicion.getValue(entorno).toString());
        Simbolo sim=entorno.Obtener(this.id);
        LinkedList<Aritmetica> aux=(LinkedList)sim.valor;
        if(sim!=null){
            if(valor!=null){           
                if(pos<aux.size()-1){
                    if(this.operador==Operador.IGUAL){
                        if(this.asigna instanceof Llamada_Funcion){
                            Llamada_Funcion llama=(Llamada_Funcion)this.asigna;
                            Aritmetica nuevo=new Aritmetica(llama.getValue(entorno),llama.getTipo_respuesta());
                            aux.remove(pos);
                            aux.add(pos, nuevo);
                        }else{
                            Aritmetica nuevo=new Aritmetica(this.asigna.getValue(entorno),this.asigna.getType(entorno));
                            aux.remove(pos);
                            aux.add(pos, nuevo);
                        }
                    }else if(this.operador==Operador.A_SUMA){
                        if(this.asigna instanceof Llamada_Funcion){
                            Llamada_Funcion llama=(Llamada_Funcion)this.asigna;
                            Aritmetica control=new Aritmetica(aux.get(pos),llama,Operador.SUMA);
                            Object aux_valor=control.getValue(entorno);
                            Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                            Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo);
                            aux.remove(pos);
                            aux.add(pos,nuevo);
                        }else{
                            Aritmetica control=new Aritmetica(aux.get(pos),this.asigna,Operador.SUMA);
                            Object aux_valor=control.getValue(entorno);
                            if(aux_valor!=null){
                                Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo);
                                aux.remove(pos);
                                aux.add(pos,nuevo);
                            }else{
                                System.out.println("ERROR SEMANTICO: NO SE PUDO REALIZAR LA OPERACION += CON EL ARREGLO "+this.id);
                            }                    
                        }
                    }else if(this.operador==Operador.A_RESTA){
                        if(this.asigna instanceof Llamada_Funcion){
                            Llamada_Funcion llama=(Llamada_Funcion)this.asigna;
                            Aritmetica control=new Aritmetica(aux.get(pos),llama,Operador.RESTA);
                            Object aux_valor=control.getValue(entorno);
                            Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                            Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo);
                            aux.remove(pos);
                            aux.add(pos,nuevo);
                        }else{
                            Aritmetica control=new Aritmetica(aux.get(pos),this.asigna,Operador.RESTA);
                            Object aux_valor=control.getValue(entorno);
                            if(aux_valor!=null){
                                Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo);
                                aux.remove(pos);
                                aux.add(pos,nuevo);
                            }else{
                                System.out.println("ERROR SEMANTICO: NO SE PUDO REALIZAR LA OPERACION += CON EL ARREGLO "+this.id);
                            }
                            
                        }
                    }else if(this.operador==Operador.A_MULT){
                        if(this.asigna instanceof Llamada_Funcion){
                            Llamada_Funcion llama=(Llamada_Funcion)this.asigna;
                            Aritmetica control=new Aritmetica(aux.get(pos),llama,Operador.MULTIPLICACION);
                            Object aux_valor=control.getValue(entorno);
                            Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                            Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo);
                            aux.remove(pos);
                            aux.add(pos,nuevo);
                        }else{
                            Aritmetica control=new Aritmetica(aux.get(pos),this.asigna,Operador.MULTIPLICACION);
                            Object aux_valor=control.getValue(entorno);
                            if(aux_valor!=null){
                                Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo);
                                aux.remove(pos);
                                aux.add(pos,nuevo);
                            }else{
                                System.out.println("ERROR SEMANTICO: NO SE PUDO REALIZAR LA OPERACION += CON EL ARREGLO "+this.id);
                            }
                            
                        }
                    }else if(this.operador==Operador.A_DIV){
                        if(this.asigna instanceof Llamada_Funcion){
                            Llamada_Funcion llama=(Llamada_Funcion)this.asigna;
                            Aritmetica control=new Aritmetica(aux.get(pos),llama,Operador.DIVISION);
                            Object aux_valor=control.getValue(entorno);
                            Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                            Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo);
                            aux.remove(pos);
                            aux.add(pos,nuevo);
                        }else{
                            Aritmetica control=new Aritmetica(aux.get(pos),this.asigna,Operador.DIVISION);
                            Object aux_valor=control.getValue(entorno);
                            if(aux_valor!=null){
                                Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo);
                                aux.remove(pos);
                                aux.add(pos,nuevo);
                            }else{
                                System.out.println("ERROR SEMANTICO: NO SE PUDO REALIZAR LA OPERACION += CON EL ARREGLO "+this.id);
                            }
                        }
                    }else{
                        System.out.println("ERROR SEMANTICO: OPERADOR INCORRECTO PARA REALIZAR LA ASIGNACION A UN ARREGLO");
                    }
                }else{
                    System.out.println("ERROR SEMANTICO: LA POSICION QUE QUIERE ACCEDER ES MAYOR AL TAMA;O DEL ARREGLO "+this.id);
                }
                
            }else{
                System.out.println("ERROR SEMANTICO: No tiene valor a asignar");
            }
        }else{
            System.out.println("ERROR SEMANTICO: NO EXISTE EL ID "+this.id+" EN ESTE ENTORNO");
        }
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}