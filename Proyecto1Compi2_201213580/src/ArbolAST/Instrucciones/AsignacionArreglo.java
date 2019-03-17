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
import Auxiliares.Errores;
import java.util.LinkedList;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class AsignacionArreglo implements Instruccion{
    int linea;
    int columna;
    String id;//este es el nombre de la variable que es un arreglo
    Expresion asigna; //
    Expresion posicion;
    Operador operador;

    public AsignacionArreglo(String id,Expresion asigna,Expresion posicion,Operador operador,int linea,int columna){
        this.id=id;
        this.asigna=asigna;
        this.posicion=posicion;
        this.operador=operador;
        this.linea=linea;
        this.columna=columna;
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
                        try{
                            if(this.asigna instanceof Llamada_Funcion){
                                Llamada_Funcion llama=(Llamada_Funcion)this.asigna;
                                Aritmetica nuevo=new Aritmetica(llama.getValue(entorno),llama.getTipo_respuesta(),this.linea,this.columna);
                                aux.remove(pos);
                                aux.add(pos, nuevo);
                            }else{
                                Aritmetica nuevo=new Aritmetica(this.asigna.getValue(entorno),this.asigna.getType(entorno),this.linea,this.columna);
                                aux.remove(pos);
                                aux.add(pos, nuevo);
                            }
                        }catch(Exception e){
                            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion igual con arreglo");
                        }
                    }else if(this.operador==Operador.A_SUMA){
                        try{
                            if(this.asigna instanceof Llamada_Funcion){
                                Llamada_Funcion llama=(Llamada_Funcion)this.asigna;
                                Aritmetica control=new Aritmetica(aux.get(pos),llama,Operador.SUMA,this.linea,this.columna);
                                Object aux_valor=control.getValue(entorno);
                                Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo,this.linea,this.columna);
                                aux.remove(pos);
                                aux.add(pos,nuevo);
                            }else{
                                Aritmetica control=new Aritmetica(aux.get(pos),this.asigna,Operador.SUMA,this.linea,this.columna);
                                Object aux_valor=control.getValue(entorno);
                                if(aux_valor!=null){
                                    Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                    Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo,this.linea,this.columna);
                                    aux.remove(pos);
                                    aux.add(pos,nuevo);
                                }else{
                                    Errores error=new Errores("SEMANTICO","no se pudo realizar la operacion suma igual con arreglo",this.linea,this.columna);
                                    Proyecto1Compi2_201213580.errores_fs.add(error);
                                }                    
                            }
                        }catch(Exception e){
                            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion suma igual para arreglo");
                        }
                    }else if(this.operador==Operador.A_RESTA){
                        try{
                            if(this.asigna instanceof Llamada_Funcion){
                                Llamada_Funcion llama=(Llamada_Funcion)this.asigna;
                                Aritmetica control=new Aritmetica(aux.get(pos),llama,Operador.RESTA,this.linea,this.columna);
                                Object aux_valor=control.getValue(entorno);
                                Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo,this.linea,this.columna);
                                aux.remove(pos);
                                aux.add(pos,nuevo);
                            }else{
                                Aritmetica control=new Aritmetica(aux.get(pos),this.asigna,Operador.RESTA,this.linea,this.columna);
                                Object aux_valor=control.getValue(entorno);
                                if(aux_valor!=null){
                                    Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                    Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo,this.linea,this.columna);
                                    aux.remove(pos);
                                    aux.add(pos,nuevo);
                                }else{
                                    Errores error=new Errores("SEMANTICO","no se pudo realizar la operacion resta igual con arreglos",this.linea,this.columna);
                                    Proyecto1Compi2_201213580.errores_fs.add(error);
                                }
                            }
                        }catch(Exception e){
                            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion resta igual con arreglo");
                        }
                    }else if(this.operador==Operador.A_MULT){
                        try{
                            if(this.asigna instanceof Llamada_Funcion){
                                Llamada_Funcion llama=(Llamada_Funcion)this.asigna;
                                Aritmetica control=new Aritmetica(aux.get(pos),llama,Operador.MULTIPLICACION,this.linea,this.columna);
                                Object aux_valor=control.getValue(entorno);
                                Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo,this.linea,this.columna);
                                aux.remove(pos);
                                aux.add(pos,nuevo);
                            }else{
                                Aritmetica control=new Aritmetica(aux.get(pos),this.asigna,Operador.MULTIPLICACION,this.linea,this.columna);
                                Object aux_valor=control.getValue(entorno);
                                if(aux_valor!=null){
                                    Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                    Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo,this.linea,this.columna);
                                    aux.remove(pos);
                                    aux.add(pos,nuevo);
                                }else{
                                    Errores error=new Errores("SEMANTICO","no se pudo realizar la operacion multiplicacion igual con el arreglo",this.linea,this.columna);
                                    Proyecto1Compi2_201213580.errores_fs.add(error);
                                }   
                            }
                        }catch(Exception e){
                            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion multiplicacion igual con arreglo");
                        }
                    }else if(this.operador==Operador.A_DIV){
                        try{
                            if(this.asigna instanceof Llamada_Funcion){
                                Llamada_Funcion llama=(Llamada_Funcion)this.asigna;
                                Aritmetica control=new Aritmetica(aux.get(pos),llama,Operador.DIVISION,this.linea,this.columna);
                                Object aux_valor=control.getValue(entorno);
                                Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo,this.linea,this.columna);
                                aux.remove(pos);
                                aux.add(pos,nuevo);
                            }else{
                                Aritmetica control=new Aritmetica(aux.get(pos),this.asigna,Operador.DIVISION,this.linea,this.columna);
                                Object aux_valor=control.getValue(entorno);
                                if(aux_valor!=null){
                                    Type.PrimitiveType aux_tipo=control.getTipo_Respuesta();
                                    Aritmetica nuevo=new Aritmetica(aux_valor,aux_tipo,this.linea,this.columna);
                                    aux.remove(pos);
                                    aux.add(pos,nuevo);
                                }else{
                                    Errores error=new Errores("SEMANTICO","no se pudo realizar la operacion division igual con arreglo",this.linea,this.columna);
                                    Proyecto1Compi2_201213580.errores_fs.add(error);
                                }
                            }
                        }catch(Exception e){
                            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion de asignacion en division");
                        }
                    }else{
                        Errores error=new Errores("SEMANTICO","operador incorrecto para realizar la asignacion a un arreglo",this.linea,this.columna);
                        Proyecto1Compi2_201213580.errores_fs.add(error);
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","la posicion que quiere acceder es mayor al tama;o del arreglo",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
                
            }else{
                Errores error=new Errores("SEMANTICO","no tiene valor para asignar",this.linea,this.columna);
                Proyecto1Compi2_201213580.errores_fs.add(error);
            }
        }else{
            Errores error=new Errores("SEMANTICO","no existe el id en el entorno",this.linea,this.columna);
            Proyecto1Compi2_201213580.errores_fs.add(error);
        }
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
