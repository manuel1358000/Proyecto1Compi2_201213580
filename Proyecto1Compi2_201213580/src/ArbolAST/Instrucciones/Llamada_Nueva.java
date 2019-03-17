/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;

/**
 *
 * @author anton
 */
public class Llamada_Nueva implements Expresion{
    String id;
    int linea;
    int columna;
    public Llamada_Nueva(int linea,int columna){
        this.linea=linea;
        this.columna=columna;
    }
    @Override
    public Object getValue(Entorno entorno) {
        Simbolo sim=(Simbolo)entorno.Obtener(id);
        if(sim!=null){
            
            return sim.getTipo();
        }else{
            return null;
        }
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        Simbolo sim=(Simbolo)entorno.Obtener(id);
        if(sim!=null){
            return sim.getTipo();
        }else{
            return Type.PrimitiveType.NULL;
        }
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
