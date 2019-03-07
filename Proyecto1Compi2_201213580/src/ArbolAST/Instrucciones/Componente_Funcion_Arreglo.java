/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Expresiones.Expresion;

/**
 *
 * @author anton
 */
public class Componente_Funcion_Arreglo {
    String id;
    Expresion parametro;

    public Componente_Funcion_Arreglo(String id, Expresion parametro) {
        this.id = id;
        this.parametro = parametro;
    }
    
    public Componente_Funcion_Arreglo(String id){
        this.id=id;
        this.parametro=null;
    }
}
