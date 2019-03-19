/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones;

import ArbolAST.Componente.NodoGXML;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import Auxiliares.Errores;
import java.util.LinkedList;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class AccesoArreglo implements Expresion{
    int linea;
    int columna;
    String id;
    Expresion posicion;
    Type.PrimitiveType tipo;
    Type.PrimitiveType tipo_respuesta;
    public AccesoArreglo(String id,Expresion posicion,int linea,int columna){
        this.linea=linea;
        this.columna=columna;
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
            try{
                LinkedList<Expresion> aux=(LinkedList)sim.valor;
                if(pos<aux.size()){
                    Object aux_venta=aux.get(pos).getValue(entorno);
                    if(aux_venta instanceof NodoGXML){
                        System.out.println("que hay aqui");
                        respuesta=aux_venta;
                        this.tipo_respuesta=aux.get(pos).getType(entorno);
                    }else{
                        respuesta=aux_venta.toString();
                        this.tipo_respuesta=aux.get(pos).getType(entorno);
                    }
                    
                }else{
                    Errores error=new Errores("SEMANTICO","La posicion que quiere acceder al id esta fuera de rango",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }catch(Exception e){
                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion al momento de acceder al arreglo");
            }
        }else{
            Errores error=new Errores("SEMANTICO","No existe el id en el entorno",this.linea,this.columna);
            Proyecto1Compi2_201213580.errores_fs.add(error);
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
