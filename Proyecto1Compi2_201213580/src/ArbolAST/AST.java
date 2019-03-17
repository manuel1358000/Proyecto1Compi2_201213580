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
import ArbolAST.Instrucciones.Declaracion_UI;
import ArbolAST.Instrucciones.Detener;
import ArbolAST.Instrucciones.Eventos_Botones;
import ArbolAST.Instrucciones.Eventos_Ventanas;
import ArbolAST.Instrucciones.Funcion;
import ArbolAST.Instrucciones.Funciones_Arreglos;
import ArbolAST.Instrucciones.Importar;
import ArbolAST.Instrucciones.Imprimir;
import ArbolAST.Instrucciones.Seleccion.If;
import ArbolAST.Instrucciones.Seleccion.Switch;
import Auxiliares.Errores;
import java.util.LinkedList;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;
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
                        Errores error=new Errores("SEMANTICO","ya existe una funcion "+funcion.getId()+" declarada con el mismo nombre e igual numero de parametros",0,0);
                        Proyecto1Compi2_201213580.errores_fs.add(error);
                    }
                }
            }
            //SEGUNDA PASADA
            for(NodoAST node:nodes){
                if(node instanceof Importar){
                    Importar importar=(Importar)node;
                    importar.execute(global);
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
                }else if(node instanceof Funciones_Arreglos){
                    //aqui vamos a hacer la ejecucion de todo
                    Funciones_Arreglos funciones=(Funciones_Arreglos)node;
                    funciones.getValue(global);
                }else if(node instanceof Declaracion_UI){
                    Declaracion_UI decla_ui=(Declaracion_UI)node;
                    Object respuesta=decla_ui.getValue(global);
                    Type.PrimitiveType tipo=decla_ui.getTipo();
                }else if(node instanceof Eventos_Botones){
                    Eventos_Botones eve_boton=(Eventos_Botones)node;
                    eve_boton.execute(global);
                }else if(node instanceof Eventos_Ventanas){
                    Eventos_Ventanas eve_ventana=(Eventos_Ventanas)node;
                    eve_ventana.execute(global);
                }else{
                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion es una instruccion rara en ast");
                }
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la ejecucion del ast");
        }
        
    }
    public String generarNombre(String id,LinkedList<NodoAST>parametros){
        String respuesta="";
        try{
            respuesta+=id;
            for(NodoAST nodo:parametros){
                if(nodo instanceof Declaracion){
                    Declaracion declaracion=(Declaracion)nodo;
                    respuesta+=declaracion.tipo.toString();
                }else{
                    //ver que otros tipos puede ingresar aqui un objeto, un array ver que es lo que lleva
                }
            }
        }catch(Exception e){
            
            System.out.println("ERROR EN METODO GENERAR NOMBRE AST");
        }
        return respuesta;
    }
}