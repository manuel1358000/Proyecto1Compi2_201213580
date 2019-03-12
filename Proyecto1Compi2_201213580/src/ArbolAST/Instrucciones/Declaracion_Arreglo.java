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
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class Declaracion_Arreglo extends Declaracion implements Instruccion{
    boolean homogeneo;
    LinkedList<Expresion> valor;
    public Declaracion_Arreglo(Type.PrimitiveType type, String id, Expresion expresion, boolean inicializado, int linea,LinkedList<Expresion>valor) {
        super(type, id,null, inicializado, linea);
        this.valor=valor;
        this.homogeneo=false;
    }
    @Override
    public Object execute(Entorno entorno) {
        LinkedList<Expresion>lista=new LinkedList<>();
        for(Expresion nodo:this.valor){
            Object respuesta=nodo.getValue(entorno);
            Type.PrimitiveType aux_tipo=nodo.getType(entorno);
            lista.add(new Aritmetica(respuesta, aux_tipo));
        }
        LinkedList<Integer>dimen=new LinkedList<>();
        dimen.add(lista.size());
        
        Simbolo simbolo=new Simbolo(false,false,Type.PrimitiveType.ARREGLO,this.id,new LinkedList<>(),lista);
        Simbolo aux=(Simbolo)entorno.Obtener(id);
        if(aux==null){
            entorno.Agregar(id, simbolo);
        }else{
            System.out.println("ERROR SEMANTICO: YA EXISTE UNA VARIABLE DECLARADA CON EL NOMBRE "+id);
        }
        entorno.Agregar(id, simbolo);
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
