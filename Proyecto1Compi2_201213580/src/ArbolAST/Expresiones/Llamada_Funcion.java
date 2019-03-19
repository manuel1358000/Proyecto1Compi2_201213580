/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones;

import Analizadores.GramaticaGXML.simbolo;
import ArbolAST.AST;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.operacion.Aritmetica;
import ArbolAST.Expresiones.operacion.Logica;
import ArbolAST.Expresiones.operacion.Relacional;
import ArbolAST.Instrucciones.Declaracion;
import ArbolAST.Instrucciones.Funcion;
import ArbolAST.NodoAST;
import Auxiliares.Errores;
import java.util.LinkedList;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class Llamada_Funcion implements Expresion{
    int linea;
    int columna;
    String id;
    LinkedList<NodoAST>parametros_entrada;
    Type.PrimitiveType tipo_respuesta;
    Type.PrimitiveType tipo;
    public Llamada_Funcion(Type.PrimitiveType tipo,String id,LinkedList<NodoAST>parametros_entrada,int linea,int columna){
        this.id=id;
        this.parametros_entrada=parametros_entrada;
        this.tipo_respuesta=Type.PrimitiveType.NULL;
        this.tipo=tipo;
        this.linea=linea;
        this.columna=columna;
    }
    
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        String nombre_funcion=this.id+"_"+this.parametros_entrada.size();
        Simbolo sim=(Simbolo)entorno.Obtener(nombre_funcion);
        if(sim!=null){
            try{
                Funcion funcion=(Funcion)sim.valor;
                LinkedList<NodoAST>lista_nueva=new LinkedList<>();
                for(NodoAST nodo: this.parametros_entrada){
                    if(nodo instanceof Aritmetica){
                        Aritmetica aritmetica=(Aritmetica)nodo;
                        Object valor_v=aritmetica.getValue(entorno);
                        Type.PrimitiveType tipo_v=aritmetica.getType(entorno);
                        Aritmetica entrada=new Aritmetica(valor_v,tipo_v,this.linea,this.columna);
                        lista_nueva.add(entrada);
                        //como aca ya tengo el valor implicito lo tengo que agregar al valor de los parametros por medio de un add a la linedklist
                    }else if(nodo instanceof Relacional){
                        Relacional relacional=(Relacional)nodo;
                    }else if(nodo instanceof Logica){
                        Logica logica=(Logica)nodo;
                    }else if(nodo instanceof AccesoArreglo){
                        AccesoArreglo acceso=(AccesoArreglo)nodo;
                        Object valor_v=acceso.getValue(entorno);
                        Type.PrimitiveType tipo_v=acceso.getTipo_Respuesta();
                        Aritmetica entrada=new Aritmetica(valor_v,tipo_v,this.linea,this.columna);
                        lista_nueva.add(entrada);
                    }else if(nodo instanceof Llamada_Funcion){
                        Llamada_Funcion llamada=(Llamada_Funcion)nodo;
                        Object valor_v=llamada.getValue(entorno);
                        Type.PrimitiveType tipo_v=llamada.getTipo_respuesta();
                        Aritmetica entrada=new Aritmetica(valor_v,tipo_v,this.linea,this.columna);
                        lista_nueva.add(entrada);
                    }else{
                        System.out.println("operacion rara");
                    }
                }
                funcion.setParametros_entrada(lista_nueva);
                //aqui es donde se le tiene que mandar solo los parametros globales pero esperemos a verificar
                respuesta=funcion.execute(AST.global);
                this.tipo_respuesta=funcion.getTipo();
            }catch(Exception e){
                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la llamada a la funcion");
            }
        }else{
            Errores error=new Errores("SEMANTICO","La funcion"+this.id+" No existe, o el numero de parametros es incorrecto",this.linea,this.columna);
            Proyecto1Compi2_201213580.errores_fs.add(error);
        }
        return respuesta;
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        return this.tipo;
    }

    public Type.PrimitiveType getTipo_respuesta() {
        return tipo_respuesta;
    }

    public void setTipo_respuesta(Type.PrimitiveType tipo_respuesta) {
        this.tipo_respuesta = tipo_respuesta;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
