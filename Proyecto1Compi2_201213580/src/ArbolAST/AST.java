/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Llamada_Funcion;
import ArbolAST.Expresiones.operacion.Aritmetica;
import ArbolAST.Expresiones.operacion.Retornar;
import ArbolAST.Instrucciones.Asignacion;
import ArbolAST.Instrucciones.AsignacionArreglo;
import ArbolAST.Instrucciones.Declaracion;
import ArbolAST.Instrucciones.Declaracion_Arreglo;
import ArbolAST.Instrucciones.Detener;
import ArbolAST.Instrucciones.Funcion;
import ArbolAST.Instrucciones.Importar;
import ArbolAST.Instrucciones.Imprimir;
import ArbolAST.Instrucciones.Seleccion.If;
import ArbolAST.Instrucciones.Seleccion.Switch;
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class AST {
    public LinkedList<NodoAST>nodes;
    public static Entorno global;
    public AST(LinkedList<NodoAST> nodes) {
        this.nodes = nodes;
    }
    public void execute(){
        try{
            global=new Entorno(null);
            //PRIMERA PASADA
            for(NodoAST node:nodes){
                if(node instanceof Funcion){
                    Funcion funcion=(Funcion)node;
                    Simbolo sim=new Simbolo(false,false,Type.PrimitiveType.FUNCION,funcion.getId(),null,funcion);
                    Simbolo verificar=(Simbolo)global.Obtener(funcion.getId());
                    if(verificar==null){
                        global.Agregar(funcion.getId(), sim);
                    }else{
                        System.out.println("ERROR SEMANTICO: YA EXISTE UNA FUNCION " + funcion.getId() + " DECLARADA CON EL MISMO NOMBRE E IGUAL NUMERO DE PARAMETROS");
                    }
                }
            }
            //SEGUNDA PASADA
            for(NodoAST node:nodes){
                if(node instanceof Importar){
                    System.out.println("Importar");
                }
            }
            for(NodoAST node: nodes){
                if(node instanceof Declaracion){
                    if(node instanceof Declaracion_Arreglo){
                        Declaracion_Arreglo declaracion_arreglo=(Declaracion_Arreglo)node;
                        declaracion_arreglo.execute(global);
                    }else{
                        Declaracion declaracion=(Declaracion) node;
                        declaracion.execute(global);
                    }
                }else if(node instanceof Imprimir){
                    Imprimir imprimir=(Imprimir)node;
                    imprimir.execute(global);
                }else if(node instanceof If){
                    If si=(If)node;
                    si.execute(global);
                }else if(node instanceof Switch){
                    Switch e_switch=(Switch)node;
                    e_switch.execute(global);
                }else if(node instanceof Asignacion){
                    Asignacion asigna=(Asignacion)node;
                    asigna.execute(global);
                }else if(node instanceof AsignacionArreglo){
                    AsignacionArreglo asigna=(AsignacionArreglo)node;
                    asigna.execute(global);
                }else if(node instanceof Detener){
                    System.out.println("ERROR SEMANTICO: LA INSTRUCCION DETENER NO DEBERIA DE APARECER FUERA DE UN SWITCH");
                }else if(node instanceof Retornar){
                    System.out.println("ERROR SEMANTICO: LA INSTRUCCION RETORNAR NO DEBERIA DE APARECER FUERA DE UNA FUNCION");
                }else if(node instanceof Funcion){
                    //se cargaron las funciones en la primera pasada
                }else if(node instanceof Importar){
                    //se cargaron las funciones en la segunda pasada
                }else if(node instanceof Llamada_Funcion){
                    Llamada_Funcion llamada=(Llamada_Funcion)node;
                    llamada.getValue(global);
                }else{
                    System.out.println("INSTRUCCION RARA");
                }
            }
        }catch(Exception e){
            System.out.println("ERROR EN LA EJECUCION DE AST");
        }
        
    }
    public String generarNombre(String id,LinkedList<NodoAST>parametros){
        String respuesta="";
        respuesta+=id;
        for(NodoAST nodo:parametros){
            if(nodo instanceof Declaracion){
                Declaracion declaracion=(Declaracion)nodo;
                respuesta+=declaracion.tipo.toString();
            }else{
                //ver que otros tipos puede ingresar aqui un objeto, un array ver que es lo que lleva
            }
        }
        return respuesta;
    }
    
}