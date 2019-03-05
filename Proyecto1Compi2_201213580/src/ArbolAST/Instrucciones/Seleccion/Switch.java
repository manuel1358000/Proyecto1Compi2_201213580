/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones.Seleccion;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Instrucciones.Detener;
import ArbolAST.Expresiones.operacion.Retornar;
import ArbolAST.Instrucciones.Instruccion;
import ArbolAST.NodoAST;
import java.util.LinkedList;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class Switch implements Instruccion{
    Type.PrimitiveType tipo;
    Expresion condicion;
    LinkedList<Caso> lista_casos;
    boolean flag=false;
    Caso def;
    public Switch(Expresion condicion,LinkedList<Caso>lista_casos,Caso def){
        this.condicion=condicion;
        this.lista_casos=lista_casos;
        this.def=def;
        this.tipo=Type.PrimitiveType.NULL;
    }
    @Override
    public Object execute(Entorno entorno) {
        Entorno local=new Entorno(entorno);
        proyecto1compi2_201213580.Proyecto1Compi2_201213580.control_break++;
        Object var_control=condicion.getValue(local);
        //recorrido previo para saber si los casos son correctos
        for(Caso c:this.lista_casos){
            //aqui se tiene que comparar los tipos
            if(condicion.getType(local)!=c.condicion.getType(local)){
                System.out.println("Error semantico no son de tipos iguales");
            }
        }
        for(Caso c:this.lista_casos){   
            if(c.condicion.getValue(local).equals(var_control)||flag){
                flag=true;
                for(NodoAST  node:c.lista_bloques){
                    if(node instanceof Instruccion){
                        Instruccion instruccion=(Instruccion)node;
                        if(instruccion instanceof Detener){
                           if(Proyecto1Compi2_201213580.control_break<=0){
                               System.out.println("ERROR SEMANTICO: LA SENTENCIA BREAK NO DEBERIA DE VENIR AQUI");
                           }else{
                               proyecto1compi2_201213580.Proyecto1Compi2_201213580.control_break--;
                               return null;
                           }
                        }else{
                            instruccion.execute(local);
                        }
                        
                    }else if(node instanceof Expresion){
                        if(node instanceof Retornar){
                            Retornar retorno=(Retornar)node;
                            this.tipo=retorno.getType(local);
                            return retorno.getValue(local);
                        }else {
                            Expresion expresion=(Expresion)node;
                            this.tipo=expresion.getType(local);
                            return expresion.getValue(local);
                        }
                    }else{
                        return null;
                    }
                }
                
            }
        }
        //aqui vamos a ejecutar el default
        if(!flag&&this.def!=null){
            for(NodoAST  node:def.lista_bloques){
                if(node instanceof Instruccion){
                    Instruccion instruccion=(Instruccion)node;
                    if(instruccion instanceof Detener){
                        if(Proyecto1Compi2_201213580.control_break<=0){
                               System.out.println("ERROR SEMANTICO: LA SENTENCIA BREAK NO DEBERIA DE VENIR AQUI");
                        }else{
                            proyecto1compi2_201213580.Proyecto1Compi2_201213580.control_break--;
                            return null;
                        }
                    }
                    instruccion.execute(local);
                }else if(node instanceof Expresion){
                    if(node instanceof Retornar){
                        Retornar retorno=(Retornar)node;
                        this.tipo=retorno.getType(local);
                        return retorno.getValue(local);
                    }else {
                        Expresion expresion=(Expresion)node;
                        return expresion.getValue(local);
                    }
                }else{
                    return null;
                }
            }   
        }
        
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
