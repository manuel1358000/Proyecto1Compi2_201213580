/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;

/**
 *
 * @author anton
 */
public class Funcion_Nueva extends Simbolo implements Instruccion{
    
    @Override
    public Object execute(Entorno entorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
