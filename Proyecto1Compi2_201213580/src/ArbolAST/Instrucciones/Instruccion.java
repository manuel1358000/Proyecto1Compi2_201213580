/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.NodoAST;
import ArbolAST.Entorno.Entorno;
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public interface Instruccion extends NodoAST{
        Object execute(Entorno entorno);
}
