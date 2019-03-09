/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones.Seleccion;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Expresiones.Llamada_Funcion;
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
    Type.PrimitiveType tipo;
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
        this.tipo=Type.PrimitiveType.NULL;
    }
    @Override
    public Object execute(Entorno entorno) {
        Object respuesta=null;
        Entorno local=new Entorno(entorno);
        Object condi=this.condicion.getValue(local);
        Type.PrimitiveType tipo_verificar=this.condicion.getType(local);
        if(tipo_verificar==Type.PrimitiveType.BOOLEAN){
            Object con=condi.toString();
            if(Boolean.valueOf(con.toString())==true){
                flag=true;
                for(NodoAST node:this.sentencias_if){
                    if(node instanceof Instruccion){
                        if(node instanceof Detener){
                            respuesta=null;
                        }else{
                            Instruccion instruccion=(Instruccion)node;
                            instruccion.execute(local);
                        }
                    }else if(node instanceof Expresion){
                        if(node instanceof Retornar){
                            Retornar retorno=(Retornar)node;
                            respuesta=retorno.getValue(local);
                            this.tipo=retorno.getType(local);
                        }else{
                            Expresion expresion=(Expresion)node;
                            respuesta=expresion.getValue(local);
                            this.tipo=expresion.getType(local);
                        }
                    }else{
                        respuesta=null;
                    }
                }
            }else{
                flag=false;
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
                                    respuesta= null;
                                }else{
                                    Instruccion instruccion=(Instruccion)node;
                                    instruccion.execute(local);
                                }
                            }else if(node instanceof Expresion){
                                if(node instanceof Retornar){
                                    Retornar retorno=(Retornar)node;
                                    respuesta=retorno.getValue(local);
                                    this.tipo=retorno.getType(local);
                                }else if(node instanceof Llamada_Funcion){
                                    System.out.println("putos");
                                }else{
                                    Expresion expresion=(Expresion)node;
                                    respuesta=expresion.getValue(local);
                                    this.tipo=expresion.getType(local);
                                }
                            }else{
                                respuesta=null;
                            }
                        }
                        break;
                    }else{
                        flag=false;
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
                            respuesta=null;
                        }else{
                            Instruccion instruccion=(Instruccion)node;
                            instruccion.execute(local);
                        }
                    }else if(node instanceof Expresion){
                        if(node instanceof Retornar){
                            Retornar retorno=(Retornar)node;
                            respuesta=retorno.getValue(local);
                            this.tipo=retorno.getType(local);
                        }else{
                            Expresion expresion=(Expresion)node;
                            respuesta=expresion.getValue(local);
                            this.tipo=expresion.getType(local);
                        }
                    }else{
                        respuesta=null;
                    }
                }
            }else{
                respuesta=null;
            }
        }
        return respuesta;
    }

    public Type.PrimitiveType getTipo() {
        return tipo;
    }

    public void setTipo(Type.PrimitiveType tipo) {
        this.tipo = tipo;
    }

    public Expresion getCondicion() {
        return condicion;
    }

    public void setCondicion(Expresion condicion) {
        this.condicion = condicion;
    }

    public LinkedList<SubIf> getLista_if() {
        return lista_if;
    }

    public void setLista_if(LinkedList<SubIf> lista_if) {
        this.lista_if = lista_if;
    }

    public LinkedList<NodoAST> getSentencias_if() {
        return sentencias_if;
    }

    public void setSentencias_if(LinkedList<NodoAST> sentencias_if) {
        this.sentencias_if = sentencias_if;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public SubIf getDef_else() {
        return def_else;
    }

    public void setDef_else(SubIf def_else) {
        this.def_else = def_else;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
