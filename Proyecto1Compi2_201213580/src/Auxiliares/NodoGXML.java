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
    public String tipo_etiqueta;//este es el tipo de etiqueta que se tiene
    public Object valor;//guarda el valor que tiene dentro una etiqueta si fuera necesario
    //definicion de los elementos de las etiquetas
    public String id;
    public String tipo;
    public String color;
    public int x;
    public int y;
    public int alto;
    public int ancho;
    public boolean borde;
    public String nombre;
    public String fuente;
    public int tam;
    public boolean negrita;
    public boolean cursiva;
    public int maximo;
    public int minimo;
    public String path;
    public boolean auto_reproduccion;
    public LinkedList<NodoGXML>nodos;

    public NodoGXML() {
        this.index = -2;
        this.tipo_etiqueta ="";
        this.valor = "";
        this.id = "";
        this.tipo = "";
        this.color = "";
        this.x = -1;
        this.y = -1;
        this.alto = -1;
        this.ancho = -1;
        this.borde = false;
        this.nombre = "";
        this.fuente = "";
        this.tam = -1;
        this.negrita = false;
        this.cursiva = false;
        this.maximo = -1;
        this.minimo = -1;
        this.path = "";
        this.auto_reproduccion = false;
        this.nodos = new LinkedList<NodoGXML>();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public boolean isBorde() {
        return borde;
    }

    public void setBorde(boolean borde) {
        this.borde = borde;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public boolean isNegrita() {
        return negrita;
    }

    public void setNegrita(boolean negrita) {
        this.negrita = negrita;
    }

    public boolean isCursiva() {
        return cursiva;
    }

    public void setCursiva(boolean cursiva) {
        this.cursiva = cursiva;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isAuto_reproduccion() {
        return auto_reproduccion;
    }

    public void setAuto_reproduccion(boolean auto_reproduccion) {
        this.auto_reproduccion = auto_reproduccion;
    }

    public LinkedList<NodoGXML> getNodos() {
        return nodos;
    }

    public void setNodos(LinkedList<NodoGXML> nodos) {
        this.nodos = nodos;
    }
    
    
    
    
    
    
}