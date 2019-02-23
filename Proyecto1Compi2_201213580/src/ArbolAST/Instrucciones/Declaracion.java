/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.NodoAST;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
/**
 *
 * @author anton
 */
public class Declaracion implements Instruccion {
        public static Type.PrimitiveType tipo;
        public static String id;
        public static Expresion intValue;
        public static int line;
        public Declaracion(Type.PrimitiveType type,String id,Expresion expresion,int linea){
            this.tipo=type;
            this.id=id;
            this.intValue=expresion;
            this.line=line;
        }           
    @Override
    public Object execute(Entorno entorno) {
        //aqui vamos a declarar todas las variables
        Object valor=intValue.getValue(entorno);
        Object tipo=intValue.getType(entorno);
        if(valor!=null){
            Simbolo simbolo=new Simbolo(false,false, (Type.PrimitiveType) tipo,id,null,valor,"");
            System.out.println("el valor de la operacion es el siguiente " + valor.toString());
            System.out.println("El tipo de la operacion es " + tipo.toString());
            entorno.tabla.put(id, simbolo);
        }else{
            System.out.println("Error Semantico: Error de tipos");
        }
        return null;
    }
    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   

    public static Type.PrimitiveType getTipo() {
        return tipo;
    }

    public static void setTipo(Type.PrimitiveType tipo) {
        Declaracion.tipo = tipo;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Declaracion.id = id;
    }

    public static Expresion getIntValue() {
        return intValue;
    }

    public static void setIntValue(Expresion intValue) {
        Declaracion.intValue = intValue;
    }
    
}

//                en el rrntoeno actual existe el identificador
//                Error si ya existe
//                sise puede declarar
//        se crear un nuevo simbolo
//        el tipo y el identificador
//        al nuevo simbolo se le da su direccion base y se obtiene el puntero actual
//        donde yo puedo guardar un valor
//        expresion inicializacion
//        Si es un string se tiene que dar su nuevo tama;o
//        luego se agrega al datapointer
//        Todas las estructuras que sirven para el segundo proyecto son en decimal
//        si es un char se guarda el ascii
