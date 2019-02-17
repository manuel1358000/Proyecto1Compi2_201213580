/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.util.LinkedList;
/**
 *
 * @author anton
 */
public class NodoGXML {
    public int index;//sirve como identificador del nodo en el arbol
    public String tipo_etiqueta;//este es el tipo de etiqueta que se tiene, el nombre de la etiqueta ventana importar etc
    public Object valor;//guarda el valor que tiene dentro una etiqueta si fuera necesario, como en importar
    public String id;//identificador del nodo o nombre
    //definicion de los elementos de las etiquetas
    public LinkedList<NodoElemento>elementos;
    public LinkedList<NodoGXML>nodos;
    
    
    
    
    public NodoGXML() {
        this.index = -2;
        this.tipo_etiqueta ="";
        this.valor = "";
        this.id="";
        this.elementos=new LinkedList<NodoElemento>();
        this.nodos = new LinkedList<NodoGXML>();
    }

    public NodoGXML(int index, String tipo_etiqueta, String id, LinkedList<NodoElemento> elementos) {
        this.index = index;
        this.tipo_etiqueta = tipo_etiqueta;
        this.id = id;
        this.elementos = elementos;
    }
    
    public void AgregarNodos(LinkedList<NodoGXML>entrada){
        for(int i=0;i<entrada.size();i++){
            this.nodos.add(entrada.get(i));
        }
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTipo_etiqueta() {
        return tipo_etiqueta;
    }

    public void setTipo_etiqueta(String tipo_etiqueta) {
        this.tipo_etiqueta = tipo_etiqueta;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public LinkedList<NodoElemento> getElementos() {
        return elementos;
    }

    public void setElementos(LinkedList<NodoElemento> elementos) {
        this.elementos = elementos;
    }

    public LinkedList<NodoGXML> getNodos() {
        return nodos;
    }

    public void setNodos(LinkedList<NodoGXML> nodos) {
        this.nodos = nodos;
    }
    public String elementosVentana(LinkedList<NodoElemento>entrada){
        String respuesta="";
        int id=0;
        int tipo=0;
        for(int i=0;i<entrada.size();i++){
            if(entrada.get(i).getNombre().equals("id")){
                id++;
            }else if(entrada.get(i).getNombre().equals("tipo")){
                tipo++;
            }
        }
        if(id!=1||tipo!=1){
            respuesta="Error Sintactico: El numero de elementos obligatorios de la ETIQUETA VENTANA son incorrectos, porfavor verificar si hace falta o sobra alguno";
        }
        return respuesta;
    }
    public String elementosContenedor(LinkedList<NodoElemento>entrada){
        String respuesta="";
        int id=0;
        int x=0;
        int y=0;
        for(int i=0;i<entrada.size();i++){
            if(entrada.get(i).getNombre().equals("id")){
                id++;
            }else if(entrada.get(i).getNombre().equals("x")){
                x++;
            }else if(entrada.get(i).getNombre().equals("y")){
                y++;
            }
        }
        if(id!=1||x!=1|y!=1){
            respuesta="Error Sintactico: El numero de elementos obligatorios de la ETIQUETA CONTENEDOR son incorrectos, porfavor verificar si hace falta o sobra alguno";
        }
        return respuesta;
    }
}