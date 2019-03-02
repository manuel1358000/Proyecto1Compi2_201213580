/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Entorno;

import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class Simbolo {
    public boolean parametro;
    public boolean parametroInicializado;
    public Type.PrimitiveType tipo;
    public String id;
    public LinkedList<Integer>tamaniosDImensiones;
    public Object valor;
    public String visibilidad;

    public Simbolo(boolean parametro, boolean parametroInicializado, Type.PrimitiveType tipo, String id, LinkedList<Integer> tamaniosDImensiones, Object valor, String visibilidad) {
        this.parametro = parametro;
        this.parametroInicializado = parametroInicializado;
        this.tipo = tipo;
        this.id = id;
        this.tamaniosDImensiones = tamaniosDImensiones;
        this.valor = valor;
        this.visibilidad = visibilidad;
    }
    
    public Simbolo() {
        this.parametro = false;
        this.parametroInicializado = false;
        this.tipo = Type.PrimitiveType.NULL;
        this.id = "";
        this.tamaniosDImensiones = new LinkedList<Integer>();
        this.valor = "";
        this.visibilidad = "";
    }
    public Simbolo(String id,Type.PrimitiveType tipo) {
        this.parametro = false;
        this.parametroInicializado = false;
        this.tipo = tipo;
        this.id = id;
        this.tamaniosDImensiones = new LinkedList<Integer>();
        this.valor = "";
        this.visibilidad = "";
    }
    public boolean isParametro() {
        return parametro;
    }

    public void setParametro(boolean parametro) {
        this.parametro = parametro;
    }

    public boolean isParametroInicializado() {
        return parametroInicializado;
    }

    public void setParametroInicializado(boolean parametroInicializado) {
        this.parametroInicializado = parametroInicializado;
    }

    public Type.PrimitiveType getTipo() {
        return tipo;
    }

    public void setTipo(Type.PrimitiveType tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedList<Integer> getTamaniosDImensiones() {
        return tamaniosDImensiones;
    }

    public void setTamaniosDImensiones(LinkedList<Integer> tamaniosDImensiones) {
        this.tamaniosDImensiones = tamaniosDImensiones;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }
    
    public enum Rol{
        FUNCION,
        ARRAY,
        CLASE,
        OBJETO,
        NULL
    } 

    
    
}
