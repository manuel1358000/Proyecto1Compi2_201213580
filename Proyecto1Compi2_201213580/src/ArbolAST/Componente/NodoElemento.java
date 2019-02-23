/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Componente;

/**
 *
 * @author anton
 */
public class NodoElemento{
    public String nombre;
    public String tipo;
    public Object valor;

    public NodoElemento(String tipo, Object valor,String nombre) {
        this.tipo = tipo;
        this.valor = valor;
        this.nombre=nombre;
    }
    public NodoElemento() {
        this.tipo = "";
        this.valor = "";
        this.nombre="";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
