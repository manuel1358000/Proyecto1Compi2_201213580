/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Entorno.Type;

/**
 *
 * @author anton
 */
public class NodoArreglo {
    Type.PrimitiveType tipo;
    Object valor;
    public NodoArreglo(Object valor,Type.PrimitiveType tipo){
        this.valor=valor;
        this.tipo=tipo;
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
