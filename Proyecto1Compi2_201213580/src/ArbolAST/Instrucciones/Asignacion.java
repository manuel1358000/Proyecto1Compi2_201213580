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
import Auxiliares.Errores;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

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
                    try{
                        if(tipo_asigna==Type.PrimitiveType.INTEGER){
                            sim.valor=Integer.parseInt(valor.toString())+1;
                            sim.tipo=tipo_asigna;
                            entorno.Actualizar(this.id, sim);
                        }else if(tipo_asigna==Type.PrimitiveType.DOUBLE){
                            sim.valor=Double.parseDouble(valor.toString())+1;
                            sim.tipo=tipo_asigna;
                            entorno.Actualizar(id, sim);
                        }else{
                            Errores error=new Errores("SEMANTICO","error de tipos en la operacion aumento",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion aumento");
                    }   
                }else{
                    Errores error=new Errores("SEMANTICO","no existe el id en el entorno para realizar el aumento",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }else if(this.operador==Operador.DECREMENTO){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    try{
                        if(tipo_asigna==Type.PrimitiveType.INTEGER){
                            sim.valor=Integer.parseInt(valor.toString())-1;
                            sim.tipo=tipo_asigna;
                            entorno.Actualizar(this.id, sim);
                        }else if(tipo_asigna==Type.PrimitiveType.DOUBLE){
                            sim.valor=Double.parseDouble(valor.toString())-1;
                            sim.tipo=tipo_asigna;
                            entorno.Actualizar(id, sim);
                        }else{
                            Errores error=new Errores("SEMANTICO","error de tipos para la operacion decremento",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion decremento");
                    }   
                }else{
                    Errores error=new Errores("SEMANTICO","no existe el id para realizar la operacion decremento en el entorno",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }else if(this.operador==Operador.IGUAL){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    try{
                        sim.valor=valor;
                        sim.tipo=tipo_asigna;
                        entorno.Actualizar(this.id, sim);
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion asignar");
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","no existe el id en el entorno para poder realizar la asignacion",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }else if(this.operador==Operador.A_SUMA){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    try{
                        Type.PrimitiveType resultante=GenerarTipo(tipo_asigna,sim.tipo,Operador.SUMA);
                        if(resultante==Type.PrimitiveType.NULL){
                            Errores error=new Errores("SEMANTICO","error de tipos en la operacion suma y asignacion",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
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
                                Errores error=new Errores("SEMANTICO","error de tipos para la operacion suma igual",this.linea,this.columna);
                                Proyecto1Compi2_201213580.errores_fs.add(error);
                            }
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion suma igual");
                        System.out.println("");
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","no existe la variable en el entorno para realizar la operacion suma igual",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }else if(this.operador==Operador.A_RESTA){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    try{
                        Type.PrimitiveType resultante=GenerarTipo(tipo_asigna,sim.tipo,Operador.RESTA);
                        if(resultante==Type.PrimitiveType.NULL){
                            Errores error=new Errores("SEMANTICO","error de tipos para la resta igual",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
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
                                Errores error=new Errores("SEMANTICO","error de tipos para la operacion resta igual",this.linea,this.columna);
                                Proyecto1Compi2_201213580.errores_fs.add(error);
                            }

                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion resta igual");
                        System.out.println("ERROR ASIGNACION RESTA");
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","no se encuentra el id en el entorno para la operacion resta igual",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }else if(this.operador==Operador.A_MULT){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    try{
                        Type.PrimitiveType resultante=GenerarTipo(tipo_asigna,sim.tipo,Operador.MULTIPLICACION);
                        if(resultante==Type.PrimitiveType.NULL){
                            Errores error=new Errores("SEMANTICO","error de tipos para la operacion multiplicacion igual",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
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
                                Errores error=new Errores("SEMANTICO","error de tipos para la operacion multiplicacion igual",this.linea,this.columna);
                                Proyecto1Compi2_201213580.errores_fs.add(error);
                            }

                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion multiplicacion igual");
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","no existe la variable a asignar en la operacion multiplicacion igual",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }else if(this.operador==Operador.A_DIV){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    try{
                        Type.PrimitiveType resultante=GenerarTipo(tipo_asigna,sim.tipo,Operador.DIVISION);
                        if(resultante==Type.PrimitiveType.NULL){
                            Errores error=new Errores("SEMANTICO","error de tipos para la operacion division igual",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }else{
                            if(resultante==Type.PrimitiveType.INTEGER){
                                int val=Integer.parseInt(sim.valor.toString())/Integer.parseInt(valor.toString());
                                if(val==Integer.MAX_VALUE){
                                    Errores error=new Errores("SEMANTICO","error division por cero",this.linea,this.columna);
                                    Proyecto1Compi2_201213580.errores_fs.add(error);
                                }else{
                                    sim.valor=val;
                                    sim.tipo=resultante;
                                    entorno.Actualizar(this.id, sim);
                                }
                            }else if(resultante==Type.PrimitiveType.DOUBLE){
                                double val=Double.parseDouble(sim.valor.toString())/Double.parseDouble(valor.toString());
                                if(val==Double.POSITIVE_INFINITY||val==Double.NEGATIVE_INFINITY){
                                    Errores error=new Errores("SEMANTICO","error division por cero",this.linea,this.columna);
                                    Proyecto1Compi2_201213580.errores_fs.add(error);
                                }else{
                                    sim.valor=val;
                                    sim.tipo=resultante;
                                    entorno.Actualizar(this.id, sim);
                                }
                            }else{
                                Errores error=new Errores("SEMANTICO","error de tipos en la operacion division igual",this.linea,this.columna);
                                Proyecto1Compi2_201213580.errores_fs.add(error);
                            }
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion division igual");
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","no se encontro el id en el entorno para realizar la operacion division igual",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }else{
                Errores error=new Errores("SEMANTICO","no se encontro el operador para la asignacion",this.linea,this.columna);
                Proyecto1Compi2_201213580.errores_fs.add(error);
            }
        }else{
            Errores error=new Errores("SEMANTICO","la expresion que se desea asignar no existe en el entorno o es nula",this.linea,this.columna);
            Proyecto1Compi2_201213580.errores_fs.add(error);
        }
        return null;
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
                Errores error=new Errores("SEMANTICO","error de tipos para la operacion",this.linea,this.columna);
                Proyecto1Compi2_201213580.errores_fs.add(error);
                respuesta= Type.PrimitiveType.NULL;
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la generacion de tipos para asignacion");
        }
        return respuesta;
    }
    
    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
