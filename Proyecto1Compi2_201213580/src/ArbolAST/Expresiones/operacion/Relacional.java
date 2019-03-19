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
import ArbolAST.Expresiones.AccesoObjetos;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Expresiones.Llamada_Funcion;
import Auxiliares.Errores;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;
/**
 *
 * @author anton
 */
public class Relacional extends Operacion implements Expresion{
    public Relacional(Expresion expresion1, Expresion expresion2, Operacion.Operador operador,int linea,int columna) {
        super(expresion1, expresion2, operador,linea,columna);
    }
    public Relacional(Expresion expresion1, boolean valor, Operador operador,int linea,int columna) {
        super(expresion1, valor, operador,linea,columna);
    }
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        if(this.expresion1!=null&&this.expresion2!=null){
            Object val1=this.expresion1.getValue(entorno);
            Object val2=this.expresion2.getValue(entorno);
            Type.PrimitiveType tipo1=this.expresion1.getType(entorno);
            Type.PrimitiveType tipo2=this.expresion2.getType(entorno);
            if(this.expresion1 instanceof AccesoObjetos){
                AccesoObjetos acceso=(AccesoObjetos)this.expresion1;
                tipo1=acceso.getType(entorno);
            }
            if(this.expresion2 instanceof AccesoObjetos){
                AccesoObjetos acceso=(AccesoObjetos)this.expresion2;
                tipo1=acceso.getType(entorno);
            }
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
            if(this.operador==Operador.MAYORQ){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=val1.toString().compareTo(val2.toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice>0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion mayorq con el tipo string");
                    }
                    
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(val1.toString())>Integer.parseInt(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion mayorque con el tipo integer");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(val1.toString())>Double.parseDouble(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion mayorque con el tipo double");
                    }
                }else{
                    respuesta=null;
                    Errores error=new Errores("SEMANTICO","error de tipos en operacion mayorq",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }else if(this.operador==Operador.MENORQ){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=val1.toString().compareTo(val2.toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice<0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion menorque con el tipo string");
                    }
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(val1.toString())<Integer.parseInt(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion menor que con el tipo integer");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(val1.toString())<Double.parseDouble(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion menor que con el tipo double");
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","error de tipos menorq",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                    respuesta=null;
                }
            }else if(this.operador==Operador.MAYORIGUALQ){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=val1.toString().compareTo(val2.toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice>=0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion mayorigual q con el tipo string");
                    }
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(val2.toString())>=Integer.parseInt(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion mayorigualq con el tipo integer");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(val1.toString())>=Double.parseDouble(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion mayorigualq con el tipo double");
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","error de tipos en operacion mayorigualq",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                    respuesta=null;
                }
            }else if(this.operador==Operador.MENORIGUALQ){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=val1.toString().compareTo(val2.toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice<=0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion menorigualq con el tipo string");
                    }
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(val1.toString())<=Integer.parseInt(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion menorigualq con el tipo integer");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(val1.toString())<=Double.parseDouble(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion menorigualq con el tipo double");
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","error de tipos en operacion menorigualq",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                    respuesta=null;
                }
            }else if(this.operador==Operador.DIFERENTE){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=val1.toString().compareTo(val2.toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice!=0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion diferente con el tipo string");
                    }
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(val1.toString())!=Integer.parseInt(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion diferente con el tipo integer");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(val1.toString())!=Double.parseDouble(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion diferente con el tipo double");
                    }
                }else if(tipo==Type.PrimitiveType.BOOLEAN){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        String valor1;
                        String valor2;
                        if(val1==null){
                            valor1="nulo";
                        }else{
                            valor1=val1.toString();
                        }
                        if(val2==null){
                            valor2="nulo";
                        }else{
                            valor2=val2.toString();
                        }
                        if(valor1.equals("nulo")||valor2.equals("nulo")){
                            respuesta=!(valor1.equals(valor2));
                        }else{
                            boolean va1=false;
                            boolean va2=false;
                            if(valor1.equals("true")){
                                va1=true;
                            }
                            if(valor2.equals("true")){
                                va2=true;
                            }
                            respuesta=va1!=va2;
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion igualigual con el tipo boolean");
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","error de tipos en operacion diferente",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                    respuesta=null;
                }
            }else if(this.operador==Operador.IGUALIGUAL){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=val1.toString().compareTo(val2.toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice==0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion igual igual con el tipo string");
                    }
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(val1.toString())==Integer.parseInt(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion igualigual con el tipo integer");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(val1.toString())==Double.parseDouble(val2.toString());
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion igual igual con el tipo double");
                    }
                }else if(tipo==Type.PrimitiveType.BOOLEAN){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        String valor1;
                        String valor2;
                        if(val1==null){
                            valor1="nulo";
                        }else{
                            valor1=val1.toString();
                        }
                        if(val2==null){
                            valor2="nulo";
                        }else{
                            valor2=val2.toString();
                        }
                        if(valor1.equals("nulo")||valor2.equals("nulo")){
                            respuesta=valor1.equals(valor2);
                        }else{
                            boolean va1=false;
                            boolean va2=false;
                            if(valor1.equals("true")){
                                va1=true;
                            }
                            if(valor2.equals("true")){
                                va2=true;
                            }
                            respuesta=va1==va2;
                        }
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la operacion igual igual con el tipo boolean");
                    }
                }else{
                    Errores error=new Errores("SEMANTICO","error de tipos en operacion igualigual",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                    respuesta=null;
                }
            }else {
                Errores error=new Errores("SEMANTICO","La operacion no pertenece a las relacionales",this.linea,this.columna);
                Proyecto1Compi2_201213580.errores_fs.add(error);
                respuesta=null;
            }
        }else{
            if(this.type==Type.PrimitiveType.ID){
                try{
                    Simbolo referencia=entorno.Obtener(this.valor.toString());
                    if(referencia!=null){
                        if(referencia.valor instanceof Expresion){
                            respuesta=((Expresion)referencia.valor).getValue(entorno);
                        }else{
                            this.type=referencia.tipo;
                            respuesta=referencia.valor;
                        }
                    }else{
                        Errores error=new Errores("SEMANTICO","no existe el id "+this.valor,this.linea,this.columna);
                        Proyecto1Compi2_201213580.errores_fs.add(error);
                        respuesta=null;
                    }
                }catch(Exception e){
                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en el momento de traer el valor del id en relacional");
                }
            }else{
                try{
                    respuesta=this.valor;
                }catch(Exception e){
                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en obtener valor del id relacional");
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
        Type.PrimitiveType respuesta=null;
        try{
            if(primero==Type.PrimitiveType.NULO||segundo==Type.PrimitiveType.NULO){
                respuesta=Type.PrimitiveType.BOOLEAN;
            }else if(primero==Type.PrimitiveType.STRING&&segundo==Type.PrimitiveType.STRING){
                respuesta=Type.PrimitiveType.STRING;
            }else if((primero==Type.PrimitiveType.INTEGER||primero==Type.PrimitiveType.DOUBLE)&&(segundo==Type.PrimitiveType.INTEGER||segundo==Type.PrimitiveType.DOUBLE)){
                respuesta=Type.PrimitiveType.DOUBLE;
            }else if(primero==Type.PrimitiveType.BOOLEAN&&segundo==Type.PrimitiveType.BOOLEAN){
                respuesta=Type.PrimitiveType.BOOLEAN;
            }else{
                respuesta=null;
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en obtener el tipo de relacional");
        }
        return respuesta;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
