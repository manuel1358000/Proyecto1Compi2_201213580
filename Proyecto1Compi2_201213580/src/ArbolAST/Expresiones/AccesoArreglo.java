/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class AccesoArreglo implements Expresion{
    String id;
    Expresion posicion;
    Type.PrimitiveType tipo;
    Type.PrimitiveType tipo_respuesta;
    public AccesoArreglo(String id,Expresion posicion){
        this.id=id;
        this.posicion=posicion;
        this.tipo=Type.PrimitiveType.ARREGLO;
        this.tipo_respuesta=Type.PrimitiveType.NULL;
    }
    
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        int pos=Integer.parseInt(posicion.getValue(entorno).toString());
        Simbolo sim=(Simbolo)entorno.Obtener(this.id);
        if(sim!=null){
            LinkedList<Expresion> aux=(LinkedList)sim.valor;
            if(pos<aux.size()){
                respuesta=aux.get(pos).getValue(entorno).toString().replaceAll("\"","");
                this.tipo_respuesta=aux.get(pos).getType(entorno);
            }else{
                System.out.println("ERROR SEMANTICO: LA POSICION QUE QUIERE ACCEDER AL ID "+this.id+" ESTA FUERA DE RANGO");
            }
            
        }else{
            System.out.println("ERROR SEMANTICO: NO EXISTE EL ID "+this.id+" EN ESTE ENTORNO");
        }
        return respuesta;
    }
    
    
    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        return tipo;
    }
    public Type.PrimitiveType getTipo_Respuesta(){
        return tipo_respuesta;
    }
    
    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
