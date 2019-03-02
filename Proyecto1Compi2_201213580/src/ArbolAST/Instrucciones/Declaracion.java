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
        public Type.PrimitiveType tipo;
        public String id;
        public Expresion intValue;
        public int line;
        public Declaracion(Type.PrimitiveType type,String id,Expresion expresion,int linea){
            this.tipo=type;
            this.id=id;
            this.intValue=expresion;
            this.line=line;
        }           
    @Override
    public Object execute(Entorno entorno) {
        //aqui vamos a declarar todas las variables
        try{
            Object valor=intValue.getValue(entorno);
            Object tipo=intValue.getType(entorno);
            if(valor!=null){
                Simbolo simbolo=new Simbolo(false,false, (Type.PrimitiveType) tipo,id,null,valor,"");
                entorno.Agregar(id, simbolo);
            }else{
                System.out.println("Error Semantico: Error de tipos no se puede operar el tipo de la declaracion "+id + " Linea: "+line);
            }
        }catch(Exception e){
            System.out.println("ERROR SEMANTICO: Ocurrio un error en la declaracion");
        }
        
        return null;
    }
    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   

    public  Type.PrimitiveType getTipo() {
        return tipo;
    }

    public void setTipo(Type.PrimitiveType tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Expresion getIntValue() {
        return intValue;
    }

    public void setIntValue(Expresion intValue) {
        this.intValue = intValue;
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
