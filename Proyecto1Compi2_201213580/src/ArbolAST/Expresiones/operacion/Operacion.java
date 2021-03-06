/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones.operacion;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Instrucciones.Componente_Funcion_Arreglo;
import java.util.LinkedList;
/**
 *
 * @author anton
 */
public class Operacion implements Expresion{
    Expresion expresion1;
    Expresion expresion2;
    Operador operador;
    int linea;
    int columna;
    boolean unario;
    Type.PrimitiveType type;
    Object valor;
    boolean negacion;
    Type.PrimitiveType tipo_respuesta;
    public Operacion(Expresion expresion1,Expresion expresion2,Operador operador,int linea,int columna){
        this.expresion1=expresion1;
        this.expresion2=expresion2;
        this.operador=operador;
        this.linea=linea;
        this.columna=columna;
    }
    public Operacion(String id,LinkedList<Componente_Funcion_Arreglo>funciones_arreglo){
    }
    public Operacion(Expresion expresion1,boolean valor,Operador operador,int linea,int columna){
        this.expresion1=expresion1;
        this.unario=valor;
        this.negacion=valor;
        this.operador=operador;
        this.linea=linea;
        this.columna=columna;
    }
    public Operacion(Object valor,Type.PrimitiveType type,int linea,int columna){
        this.valor=valor;
        this.type=type;
        this.linea=linea;
        this.columna=columna;
    }
    @Override
    public Object getValue(Entorno entorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Type.PrimitiveType getTipo_Respuesta(){
        return this.tipo_respuesta;
    }
    
    public enum Operador{
        UNARIO,
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        POTENCIA,
        AUMENTO,
        DECREMENTO,
        IGUALIGUAL,
        DIFERENTE,
        MAYORQ,
        MENORQ,
        MAYORIGUALQ,
        MENORIGUALQ,
        NOT,
        OR,
        AND,
        IGUAL,
        A_SUMA,
        A_RESTA,
        A_MULT,
        A_DIV
    }  
    
}
