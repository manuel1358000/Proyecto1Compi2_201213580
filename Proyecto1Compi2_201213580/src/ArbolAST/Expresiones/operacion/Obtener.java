/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones.operacion;

import ArbolAST.Componente.NodoGXML;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class Obtener implements Expresion{
    String id;
    Type.PrimitiveType tipo;
    Expresion parametro;
    Expresion parametro2;

    public Obtener(String id,Type.PrimitiveType tipo,Expresion parametro,Expresion parametro2){
        this.id=id;
        this.tipo=tipo;
        this.parametro=parametro;
        this.parametro2=parametro2;
    }
    public Obtener(String id,Type.PrimitiveType tipo,Expresion parametro){
        this.id=id;
        this.tipo=tipo;
        this.parametro=parametro;
        this.parametro2=null;
    }
    public Obtener() {
    }
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        if(tipo==Type.PrimitiveType.PORETIQUETA){
            System.out.println("poretiqueta");
            //aca vamos a crear un arreglo de objetos ventana o objetos
            String id_obtener=parametro.getValue(entorno).toString();
            Type.PrimitiveType tipo_obtener=parametro.getType(entorno);
            if(tipo_obtener==Type.PrimitiveType.STRING){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    if(sim.tipo==Type.PrimitiveType.GXML){
                        if(sim.valor instanceof NodoGXML){
                            respuesta=recorrerArbolEtiqueta(id_obtener,(NodoGXML)sim.valor);
                            System.out.println("La respuesta debe de ser una linkedlist de objetos de tipo NodoGXML");
                        }else{
                            System.out.println("Error semantico el nodo no es gxml para realizar la operacion por nombre");
                        }
                    }else{
                        System.out.println("Error semantico el nodo no es gxml para realizar la operacion por etiqueta");
                    }
                }else{
                    System.out.println("Error semantico la variable "+this.id+" No existe en el entorno");
                }
            }else{
                System.out.println("Error semantico, el parametro para evaluar obtener por etiqueta tiene que ser una cadena de texto");
            }
        }else if(tipo==Type.PrimitiveType.PORID){
            String id_obtener=parametro.getValue(entorno).toString();
            Type.PrimitiveType tipo_obtener=parametro.getType(entorno);
            if(tipo_obtener==Type.PrimitiveType.STRING){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    if(sim.tipo==Type.PrimitiveType.GXML){
                        if(sim.valor instanceof NodoGXML){
                            respuesta=recorrerArbol(id_obtener.toLowerCase().replaceAll("\"",""),(NodoGXML)sim.valor);
                            if(respuesta==null){
                                System.out.println("no existe en la estructura algun elemento con el id "+id_obtener);
                            }
                        }else{
                            System.out.println("Error semantico el nodo no es gxml para realizar la operacion por id");
                        }
                    }else{
                        System.out.println("Error semantico error de tipos para analizar el nodo gxml en la operacion por id");
                    }
                }else{
                    System.out.println("Error semantico la variable "+this.id+" No existe en el entorno");
                }
            }else{
                System.out.println("Error semantico, el parametro para evaluar obtener por id tiene que ser una cadena de texto");
            }
        }else if(tipo==Type.PrimitiveType.PORNOMBRE){
            String id_obtener=parametro.getValue(entorno).toString();
            Type.PrimitiveType tipo_obtener=parametro.getType(entorno);
            if(tipo_obtener==Type.PrimitiveType.STRING){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    if(sim.tipo==Type.PrimitiveType.GXML){
                        if(sim.valor instanceof NodoGXML){
                            if(parametro2!=null){
                                String ventana_obtener=parametro2.getValue(entorno).toString();
                                Object aux_respuesta=recorrerArbol(ventana_obtener.replaceAll("\"","").toLowerCase(),(NodoGXML)sim.valor);
                                if(aux_respuesta!=null){
                                    respuesta=recorrerArbolNombre(id_obtener.toLowerCase().replaceAll("\"",""),(NodoGXML)aux_respuesta);
                                    if(respuesta==null){
                                        System.out.println("no existe en la estructura algun elemento con el id "+id_obtener);
                                    }
                                }else{
                                    System.out.println("La ventana no existe para buscar por nombre");
                                }
                            }else{
                                System.out.println("El id de la ventana no esta cargado para buscar por nombre");
                            }
                        }else{
                            System.out.println("Error semantico el nodo no es gxml para realizar la operacion por nombre");
                        }
                    }else{
                        System.out.println("Error semantico error de tipos para analizar el nodo gxml en la operacion por nombre");
                    }
                }else{
                    System.out.println("Error semantico la variable "+this.id+" No existe en el entorno");
                }
            }else{
                System.out.println("Error semantico, el parametro para evaluar obtener por nombre tiene que ser una cadena de texto");
            }
        }else{
            System.out.println("La operacion no existe para las funciones obtener");
        }
        return respuesta;
    }
    public LinkedList<Expresion> recorrerArbolEtiqueta(String id_obtener,NodoGXML nodo){
        LinkedList<Expresion>respuesta=new LinkedList<>();
            if(nodo.tipo_etiqueta.toLowerCase().replaceAll("\"","").equals(id_obtener.toLowerCase().replaceAll("\"",""))){
                respuesta.add(new Aritmetica(nodo,Type.PrimitiveType.GXML,0,0));
            }
            for(int i=0;i<nodo.nodos.size();i++){
                LinkedList<Expresion> aux=recorrerArbolEtiqueta(id_obtener,nodo.nodos.get(i));
                if(aux.size()>0){
                    respuesta.addAll(aux);
                }
            }
        return respuesta;
    }
    
    
    public NodoGXML recorrerArbolNombre(String id_obtener,NodoGXML nodo){
        NodoGXML respuesta=null;
        for(int j=0;j<nodo.elementos.size();j++){
            if(nodo.elementos.get(j).nombre.equals(id_obtener)){
                respuesta=nodo;
            }
        }
        if(respuesta==null){
            for(int i=0;i<nodo.nodos.size();i++){
                respuesta=recorrerArbol(id_obtener, nodo.nodos.get(i));
                if(respuesta!=null){
                    switch(respuesta.tipo_etiqueta.toLowerCase()){
                        case "control":{
                            this.tipo=Type.PrimitiveType.CONTROL;
                            break;
                        }
                        case "boton":{
                            this.tipo=Type.PrimitiveType.BOTON;
                            break;
                        }
                        case "texto":{
                            this.tipo=Type.PrimitiveType.TEXTO;
                            break;
                        }
                        case "multimedia":{
                            this.tipo=Type.PrimitiveType.MULTIMEDIA;
                            break;
                        }
                    }
                    
                    break;
                }
            }
        }
        return respuesta;
    }
    public NodoGXML recorrerArbol(String id_obtener,NodoGXML nodo){
        NodoGXML respuesta=null;
        if(nodo.elemento_id.toLowerCase().replaceAll("\"","").equals(id_obtener)){
            respuesta=nodo;
        }else{
            for(int i=0;i<nodo.nodos.size();i++){
                respuesta=recorrerArbol(id_obtener, nodo.nodos.get(i));
                if(respuesta!=null){
                    switch(respuesta.tipo_etiqueta.toLowerCase()){
                        case "ventana":{
                            this.tipo=Type.PrimitiveType.VENTANA;
                            break;
                        }
                        case "contenedor":{
                            this.tipo=Type.PrimitiveType.CONTENEDOR;
                            break;
                        }
                    }
                    
                    break;
                }
            }
        }
        return respuesta;
    }
    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        return this.tipo;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
