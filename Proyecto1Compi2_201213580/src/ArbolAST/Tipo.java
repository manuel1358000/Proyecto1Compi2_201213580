/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST;

/**
 *
 * @author anton
 */
public class Tipo {
    public Tipo(){
    
    }
    public static enum tipo{
        INTEGER,
        DOUBLE,
        STRING,
        BOOLEAN,
        OBJECT,
        ID,
        FUNCION,
        NULL
    }
}
