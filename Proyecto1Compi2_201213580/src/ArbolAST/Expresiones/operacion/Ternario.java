/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones.operacion;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import Auxiliares.Errores;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class Ternario implements Expresion {
    int linea;
    int columna;
    Type.PrimitiveType tipo;
    Expresion condicion;
    Expresion isVerdadero;
    Expresion isFalso;
    public Ternario(Expresion condicion,Expresion isVerdadero,Expresion isFalso,int linea,int columna){
        this.linea=linea;
        this.columna=columna;
        this.condicion=condicion;
        if((condicion instanceof Relacional)||(condicion instanceof Logica)){
            this.isVerdadero=isVerdadero;
            this.isFalso=isFalso;
        }else{
            Errores error=new Errores("SEMANTICO","error en la conficion del ternario",this.linea,this.columna);
            Proyecto1Compi2_201213580.errores_fs.add(error);
        }
    }

   
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        try{
            Object v_condicion=condicion.getValue(entorno);
            if(Boolean.parseBoolean(v_condicion.toString())){
                respuesta=isVerdadero.getValue(entorno);
                this.tipo=isVerdadero.getType(entorno);
            }else{
                respuesta=isFalso.getValue(entorno);
                this.tipo=isFalso.getType(entorno);
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion al momento de obtener el valor del ternario");
        }
        return respuesta;
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        return this.tipo;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
