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
import ArbolAST.Expresiones.Llamada_Funcion;
import Auxiliares.Errores;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;
/**
 *
 * @author anton
 */
public class Declaracion implements Instruccion {
        public Type.PrimitiveType tipo_implicito;
        public Type.PrimitiveType tipo;
        public String id;
        public Expresion intValue;
        public int linea;
        public int columna;
        public boolean inicializado;
        public Declaracion(Type.PrimitiveType type,String id,Expresion expresion,boolean inicializado,int linea,int columna){
            this.tipo=type;
            this.id=id;
            this.intValue=expresion;
            this.linea=linea;
            this.columna=columna;
            this.inicializado=inicializado;
            this.tipo_implicito=Type.PrimitiveType.NULL;
        }           
    @Override
    public Object execute(Entorno entorno) {
        //aqui vamos a declarar todas las variables
        try{
            if(inicializado==true){
                Object valor=intValue.getValue(entorno);
                Object tipo_v=null;
                if(intValue instanceof Llamada_Funcion){
                    Llamada_Funcion llamada=(Llamada_Funcion)intValue;
                    tipo_v=llamada.getTipo_respuesta();
                }else{
                    tipo_v=intValue.getType(entorno);
                }
                if(valor!=null){
                    Simbolo aux=(Simbolo)entorno.Obtener(id);
                    Simbolo simbolo=new Simbolo(false,false, (Type.PrimitiveType) tipo_v,id,null,valor);
                    if(aux==null){
                        entorno.Agregar(id, simbolo);
                    }else{
                        Errores error=new Errores("SEMANTICO","ya existe una variable declarada con el nombre "+this.id,this.linea,this.columna);
                        Proyecto1Compi2_201213580.errores_fs.add(error);
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","error de tipos no se puede realizar la operacion declaracion",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }else{
                Simbolo simbolo=new Simbolo(false,false,Type.PrimitiveType.NULL,id,null,null);
                Simbolo aux=(Simbolo)entorno.Obtener(id);
                if(aux==null){
                    entorno.Agregar(id, simbolo);
                }else{
                    Errores error=new Errores("SEMANTICO","ya existe una variable declarada con el nombre "+this.id,this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la declaracion");
        }
        
        return null;
    }
    @Override
    public int getLine() {
        return this.linea; //To change body of generated methods, choose Tools | Templates.
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

    public boolean isInicializado() {
        return inicializado;
    }

    public void setInicializado(boolean inicializado) {
        this.inicializado = inicializado;
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
