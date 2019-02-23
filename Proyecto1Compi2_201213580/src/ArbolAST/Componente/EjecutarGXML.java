/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Componente;

import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class EjecutarGXML {
    public static NodoGXML nodoRaiz;
    public boolean bandera=false;
    public EjecutarGXML(NodoGXML nodoRaiz){
        this.nodoRaiz=nodoRaiz;
    }
    
    public String Ejecutar(NodoGXML raiz,String arriba){
        String respuesta="";
        
        if(raiz.tipo_etiqueta.equals("importar")){
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),"");
            }
        }else if(raiz.tipo_etiqueta.equals("ventana")){
            String id=obtenerValor(raiz.elementos,"id");
            String pendiente="var ventana_"+id+"=crearVentana(";
            String color=obtenerValor(raiz.elementos,"color");
            String alto=obtenerValor(raiz.elementos,"alto");
            String ancho=obtenerValor(raiz.elementos,"ancho");
            String elementos="";
            if(color.equals("")){
                elementos+="\"#FFFFFF\",";
            }else{
                elementos+="\"" + color + "\",";
            }
            if(alto.equals("")){
                elementos+="100,";
            }else{
                elementos+=alto+",";
            }
            if(ancho.equals("")){
                elementos+="100";
            }else{
                elementos+=alto+",";
            }
            pendiente+=elementos+");\n";
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),id);
            }
            respuesta+=pendiente;
        }else if(raiz.tipo_etiqueta.equals("contenedor")){
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),"");
            }
        }else if(raiz.tipo_etiqueta.equals("texto")){
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),"");
            }
        }else if(raiz.tipo_etiqueta.equals("control")){
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),"");
            }
        }else if(raiz.tipo_etiqueta.equals("dato")){
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),"");
            }
        }else if(raiz.tipo_etiqueta.equals("listadatos")){
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),"");
            }
        }else if(raiz.tipo_etiqueta.equals("multimedia")){
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),"");
            }
        }else if(raiz.tipo_etiqueta.equals("boton")){
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),"");
            }
        }else if(raiz.tipo_etiqueta.equals("enviar")){
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),"");
            }
        }else{
            VerificarId(raiz.nodos);
            for(int i=0;i<raiz.nodos.size();i++){
                respuesta+=Ejecutar(raiz.nodos.get(i),arriba);
            }
            
        }
        return respuesta;
    }
    public String obtenerValor(LinkedList<NodoElemento> elemento,String id){
        String respuesta="";
        for(int i=0;i<elemento.size();i++){
            if(elemento.get(i).nombre.equals(id)){
                respuesta=elemento.get(i).valor.toString();
            }
        }
        return respuesta;
    }
    //este metodo elimina los nodos que tiene el id repetido, asi se realiza una generacion mas limpia del codigo Funcional Script
    public void VerificarId(LinkedList<NodoGXML>arbol){
        for(int i=0;i<arbol.size();i++){
            for(int f=0;f<arbol.size();f++){
                if(arbol.get(i).elemento_id.equals(arbol.get(f).elemento_id)&&i!=f){
                    System.out.println("Error Sintactico: ID repetidos, se conservo unicamente el primer elemento con el id repetido " + arbol.get(f).elemento_id);
                    arbol.remove(f);
                }
            }
        }
    }
}
