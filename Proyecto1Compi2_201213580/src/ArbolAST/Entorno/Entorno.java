/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Entorno;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class Entorno {
    public Entorno padre;
    public Hashtable tabla;
    
    public Entorno(Entorno padre,Hashtable tabla) {
        this.padre = padre;
        this.tabla = tabla;
    }
    public Entorno(Object object) {
        this.padre=(Entorno)object;
        this.tabla=new Hashtable();
    }

    public void Agregar(String s,Simbolo sim){
        Simbolo com=(Simbolo)this.Obtener(s);
        if(com!=null){
        }else{
            this.tabla.put(s,sim);
        }
        
    }
    public void AgregarParametro(String s,Simbolo sim){
        this.tabla.put(s, sim);
    }
    public void Actualizar(String s,Simbolo sim){
            this.tabla.put(s,sim);
    }
    public void Crear(Entorno padre){
        this.padre=padre;
    }
    public Simbolo Obtener(String s){
        for(Entorno e=this;e!=null;e=e.padre){
            Simbolo encontro=(Simbolo)(e.tabla.get(s));
            if(encontro!=null)return encontro;
        }
        return null;
    }
     public Entorno ObtenerUltimo(){
        Entorno respuesta=null;
         for(Entorno e=this;e!=null;e=e.padre){
            respuesta=e;
        }
        return respuesta;
    }
    public void Imprimir(){
       
    }
    public Entorno getPadre() {
        return padre;
    }

    public void entornoPadre(Entorno padre) {
        this.padre = padre;
    }
    public Hashtable getTabla() {
        return tabla;
    }

    public void setTs(Hashtable tabla) {
        this.tabla = tabla;
    }
}