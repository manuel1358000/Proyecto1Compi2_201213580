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
import ArbolAST.Expresiones.operacion.Aritmetica;
import ArbolAST.Expresiones.operacion.Logica;
import ArbolAST.Expresiones.operacion.Operacion;
import ArbolAST.Expresiones.operacion.Relacional;
import ArbolAST.NodoAST;
import Auxiliares.Errores;
import java.util.LinkedList;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class Declaracion_Arreglo extends Declaracion implements Instruccion{
    int linea;
    int columna;
    boolean homogeneo;
    LinkedList<Expresion> valor;
    public Declaracion_Arreglo(Type.PrimitiveType type, String id, Expresion expresion, boolean inicializado,LinkedList<Expresion>valor,int linea,int columna) {
        super(type, id,null, inicializado, linea,columna);
        this.valor=valor;
        this.homogeneo=false;
        this.linea=linea;
        this.columna=columna;
    }
    @Override
    public Object execute(Entorno entorno) {
        try{
            LinkedList<Expresion>lista=new LinkedList<>();
            for(Expresion nodo:this.valor){
                Object respuesta=nodo.getValue(entorno);
                Type.PrimitiveType aux_tipo=nodo.getType(entorno);
                lista.add(new Aritmetica(respuesta, aux_tipo,this.linea,this.columna));
            }
            LinkedList<Integer>dimen=new LinkedList<>();
            dimen.add(lista.size());
            Simbolo simbolo=new Simbolo(false,false,Type.PrimitiveType.ARREGLO,this.id,new LinkedList<>(),lista);
            Simbolo aux=(Simbolo)entorno.Obtener(id);
            if(aux==null){
                entorno.Agregar(id, simbolo);
            }else{
                Errores error=new Errores("SEMANTICO","ya existe una variable declarada con el nombre "+this.id,this.linea,this.columna);
                Proyecto1Compi2_201213580.errores_fs.add(error);
            }
            entorno.Agregar(id, simbolo);
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la declaracion del arreglo");
        }
        
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
