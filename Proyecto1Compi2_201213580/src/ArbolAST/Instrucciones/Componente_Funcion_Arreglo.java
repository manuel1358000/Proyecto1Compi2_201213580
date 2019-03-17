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
    String parametro;
    int linea;
    int columna;
    public Componente_Funcion_Arreglo(String id, String parametro,int linea,int columna) {
        this.id = id;
        this.parametro = parametro;
        this.linea=linea;
        this.columna=columna;
    }
    
    public Componente_Funcion_Arreglo(String id,int linea,int columna){
        this.id=id;
        this.parametro=null;
        this.linea=linea;
        this.columna=columna;
    }
}
