/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Componente;

import ArbolAST.Entorno.Type;
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class NodoGDATO {
    //es el id que viene en la etiqueta del archivo
    String etiqueta;
    Type.PrimitiveType tipo_dato;
    Type.PrimitiveType tipo;
    public Object valor;
    LinkedList<NodoGDATO>elementos;
    public NodoGDATO(String etiqueta, Type.PrimitiveType tipo_dato, Type.PrimitiveType tipo, Object valor) {
        this.etiqueta = etiqueta;
        this.tipo_dato = tipo_dato;
        this.tipo = tipo;
        this.valor = valor;
        this.elementos=new LinkedList<>();
    }
    public NodoGDATO(Type.PrimitiveType tipo_dato,Object valor) {
        this.tipo_dato = tipo_dato;
        this.valor = valor;
    }
    public NodoGDATO(){
    
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Type.PrimitiveType getTipo_dato() {
        return tipo_dato;
    }

    public void setTipo_dato(Type.PrimitiveType tipo_dato) {
        this.tipo_dato = tipo_dato;
    }

    public Type.PrimitiveType getTipo() {
        return tipo;
    }

    public void setTipo(Type.PrimitiveType tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    
}
