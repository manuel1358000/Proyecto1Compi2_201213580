/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones.Seleccion;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Expresiones.operacion.Retornar;
import ArbolAST.Instrucciones.Detener;
import ArbolAST.Instrucciones.Instruccion;
import ArbolAST.NodoAST;
import java.util.LinkedList;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class If implements Instruccion{
    Expresion condicion;
    //lista de ifs
    LinkedList<SubIf> lista_if;
    LinkedList<NodoAST> sentencias_if;
    boolean flag=false;
    SubIf def_else;
    public If(Expresion condicion,LinkedList<NodoAST> sentencias_if,LinkedList<SubIf>lista_if,SubIf def_else){
        this.condicion=condicion;
        this.lista_if=lista_if;
        this.def_else=def_else;
        this.sentencias_if=sentencias_if;
    }
    @Override
    public Object execute(Entorno entorno) {
        Entorno local=new Entorno(entorno);
        Object condi=this.condicion.getValue(local);
        if(this.condicion.getType(local)==Type.PrimitiveType.BOOLEAN){
            if(Boolean.valueOf(condi.toString())==true){
                flag=true;
                for(NodoAST node:this.sentencias_if){
                    if(node instanceof Instruccion){
                        if(node instanceof Detener){
                            return null;
                        }else{
                            Instruccion instruccion=(Instruccion)node;
                            instruccion.execute(local);
                        }
                    }else if(node instanceof Expresion){
                        if(node instanceof Retornar){
                            Retornar retorno=(Retornar)node;
                            return retorno.getValue(local);
                        }else{
                            Expresion expresion=(Expresion)node;
                            return expresion.getValue(entorno);
                        }
                    }else{
                        return null;
                    }
                }
            }
        }else{
            flag=false;
            System.out.println("ERROR SEMANTICO: LA SENTENCIA IF EN SU CONDICION SOLO PUEDE VERIFICAR VALORES BOOLEANOS");
        }        
        if(!flag){
            for(SubIf subif:this.lista_if){
                Object condi2=subif.condicion.getValue(local);
                if(subif.condicion.getType(local)==Type.PrimitiveType.BOOLEAN){
                    if(Boolean.valueOf(condi2.toString())==true){
                        flag=true;
                        for(NodoAST node:subif.lista_bloques){
                            if(node instanceof Instruccion){
                                if(node instanceof Detener){
                                    return null;
                                }else{
                                    Instruccion instruccion=(Instruccion)node;
                                    instruccion.execute(local);
                                }
                            }else if(node instanceof Expresion){
                                if(node instanceof Retornar){
                                    Retornar retorno=(Retornar)node;
                                    return retorno.getValue(local);
                                }else{
                                    Expresion expresion=(Expresion)node;
                                    return expresion.getValue(entorno);
                                }
                            }else{
                                return null;
                            }
                        }
                        break;
                    }
                }
            }
        }
        
        if(!flag){
            //se manda a ejecutar al else
            //tenemos que verificar primero si el else es nulo
            if(def_else!=null){
                for(NodoAST node:def_else.lista_bloques){
                    if(node instanceof Instruccion){
                        if(node instanceof Detener){
                            if(Proyecto1Compi2_201213580.control_break<=0){
                                System.out.println("Error Semantico: Se encontro una instruccion break donde no corresponde");
                            }else{
                                Proyecto1Compi2_201213580.control_break--;
                            }
                            return null;
                        }else{
                            Instruccion instruccion=(Instruccion)node;
                            instruccion.execute(local);
                        }
                    }else if(node instanceof Expresion){
                        if(node instanceof Retornar){
                            Retornar retorno=(Retornar)node;
                            return retorno.getValue(local);
                        }else{
                            Expresion expresion=(Expresion)node;
                            return expresion.getValue(entorno);
                        }
                    }else{
                        return null;
                    }
                }
            }else{
                return null;
            }
        }
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
