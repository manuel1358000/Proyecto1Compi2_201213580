/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones.operacion;

import ArbolAST.Expresiones.operacion.Operacion.Operador;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.AccesoArreglo;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Expresiones.Llamada_Funcion;
import Auxiliares.Errores;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class Logica extends Operacion implements Expresion{
    
    public Logica(Expresion expresion1, Expresion expresion2, Operador operador,int linea,int columna) {
        super(expresion1, expresion2, operador,linea,columna);
    }
    public Logica(Expresion expresion1, boolean valor, Operador operador,int linea,int columna) {
        super(expresion1, valor, operador,linea,columna);
    }
    public Logica(Object valor,Type.PrimitiveType type,int linea,int columna) {
        super(valor,type,linea,columna);
    }
       
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        if(this.negacion){
            //aqui esta el operador not
            if(this.expresion1!=null){
                try{
                    Type.PrimitiveType tipo=Type.PrimitiveType.BOOLEAN;
                    if(this.operador==Operador.NOT){
                        this.type=tipo;
                        boolean var1=false;
                        String va1=this.expresion1.getValue(entorno).toString();
                        if(va1.equals("true")){
                            var1=true;
                        }
                        respuesta=!var1;
                    }else{
                        Errores error=new Errores("SEMANTICO","error de operador en not",this.linea,this.columna);
                        Proyecto1Compi2_201213580.errores_fs.add(error);
                        respuesta=null;
                    }
                }catch(Exception e){
                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion not");
                }
                
            }else{
                try{
                    if(this.type==Type.PrimitiveType.ID){
                        Simbolo referencia=entorno.Obtener(this.valor.toString());
                        if(referencia!=null){
                            this.type=referencia.tipo;
                            respuesta=referencia.valor;
                        }else{
                            Errores error=new Errores("SEMANTICO","Error no existe el id "+this.valor.toString(),this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                            respuesta=null;
                        }
                    }else{
                        respuesta=this.valor;
                    }
                }catch(Exception e){
                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la busqueda de id logica");
                }
            }
        }else{
            if(this.expresion1!=null&&this.expresion2!=null){
                try{
                    Object val1=this.expresion1.getValue(entorno);
                    Object val2=this.expresion2.getValue(entorno);
                    Type.PrimitiveType tipo1=this.expresion1.getType(entorno);
                    Type.PrimitiveType tipo2=this.expresion2.getType(entorno);
                    if(this.expresion1 instanceof AccesoArreglo){
                        AccesoArreglo acceso=(AccesoArreglo)this.expresion1;
                        tipo1=acceso.getTipo_Respuesta();
                    }
                    if(this.expresion2 instanceof AccesoArreglo){
                        AccesoArreglo acceso=(AccesoArreglo)this.expresion2;
                        tipo2=acceso.getTipo_Respuesta();
                    }
                    if(this.expresion1 instanceof Llamada_Funcion){
                        Llamada_Funcion llamada=(Llamada_Funcion)this.expresion1;
                        val1=llamada.getValue(entorno);
                        tipo1=llamada.getTipo_respuesta();
                    }
                    if(this.expresion2 instanceof Llamada_Funcion){
                        Llamada_Funcion llamada=(Llamada_Funcion)this.expresion2;
                        val2=llamada.getValue(entorno);
                        tipo2=llamada.getTipo_respuesta();
                    }
                    Type.PrimitiveType tipo=GenerarTipo(tipo1,tipo2);
                    if(this.operador==Operador.AND){
                        this.type=tipo;
                        respuesta=Boolean.valueOf(val1.toString())&&Boolean.valueOf(val2.toString());
                    }else if(this.operador==Operador.OR){
                        this.type=tipo;
                        respuesta=Boolean.valueOf(val1.toString())||Boolean.valueOf(val2.toString());

                    }else{

                                Errores error=new Errores("SEMANTICO","Error en operador logico",this.linea,this.columna);
                                Proyecto1Compi2_201213580.errores_fs.add(error);
                        respuesta=null;
                    }
                }catch(Exception e){
                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en las operaciones and or");
                }
                
            }else{
                try{
                    if(this.type==Type.PrimitiveType.ID){
                        Simbolo referencia=entorno.Obtener(this.valor.toString());
                        if(referencia!=null){
                            if(referencia.valor instanceof Expresion){
                                respuesta=((Expresion)referencia.valor).getValue(entorno);
                            }else{
                                respuesta=referencia.valor;
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","no existe en el entorno el id "+this.valor.toString(),this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                            respuesta=null;
                        }
                    }else{
                        respuesta=this.valor;
                    }
                }catch(Exception e){
                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en obtener el valor de id en logicas");
                }
            }
        }
        return respuesta;
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {        
        Type.PrimitiveType respuesta=this.type;
        if(this.type==Type.PrimitiveType.ID){
           Simbolo sim=(Simbolo)entorno.Obtener(this.valor.toString());
           respuesta=sim.tipo;
        }
        return respuesta;
    }
    public Type.PrimitiveType GenerarTipo(Type.PrimitiveType primero,Type.PrimitiveType segundo){
        Type.PrimitiveType respuesta=Type.PrimitiveType.NULL;
        if(primero==Type.PrimitiveType.BOOLEAN&&segundo==Type.PrimitiveType.BOOLEAN){
            respuesta=Type.PrimitiveType.BOOLEAN;
        }else{
            respuesta=Type.PrimitiveType.NULL;
        }
        return respuesta;
    }
    
    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
