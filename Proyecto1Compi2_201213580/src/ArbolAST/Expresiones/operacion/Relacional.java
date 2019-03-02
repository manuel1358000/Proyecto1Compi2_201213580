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
import ArbolAST.Expresiones.Expresion;
/**
 *
 * @author anton
 */
public class Relacional extends Operacion implements Expresion{
    public Relacional(Expresion expresion1, Expresion expresion2, Operacion.Operador operador) {
        super(expresion1, expresion2, operador);
    }
    public Relacional(Expresion expresion1, boolean valor, Operador operador) {
        super(expresion1, valor, operador);
    }
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        if(this.expresion1!=null&&this.expresion2!=null){
            Type.PrimitiveType tipo1=this.expresion1.getType(entorno);
            Type.PrimitiveType tipo2=this.expresion2.getType(entorno);
            Type.PrimitiveType tipo=GenerarTipo(tipo1,tipo2);
            if(this.operador==Operador.MAYORQ){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=this.expresion1.getValue(entorno).toString().compareTo(this.expresion2.getValue(entorno).toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice>0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MAYORQ CON EL TIPO STRING");
                    }
                    
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(this.expresion1.getValue(entorno).toString())>Integer.parseInt(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MAYORQ CON EL TIPO INTEGER");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(this.expresion1.getValue(entorno).toString())>Double.parseDouble(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MAYORQ CON EL TIPO DOUBLE");
                    }
                }else{
                    respuesta=null;
                }
            }else if(this.operador==Operador.MENORQ){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=this.expresion1.getValue(entorno).toString().compareTo(this.expresion2.getValue(entorno).toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice<0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MENORQ CON EL TIPO STRING");
                    }
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(this.expresion1.getValue(entorno).toString())<Integer.parseInt(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MENORQ CON EL TIPO INTEGER");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(this.expresion1.getValue(entorno).toString())<Double.parseDouble(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MENORQ CON EL TIPO DOUBLE");
                    }
                }else{
                    respuesta=null;
                }
            }else if(this.operador==Operador.MAYORIGUALQ){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=this.expresion1.getValue(entorno).toString().compareTo(this.expresion2.getValue(entorno).toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice>=0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MAYORIGUALQ CON EL TIPO STRING");
                    }
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(this.expresion1.getValue(entorno).toString())>=Integer.parseInt(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MAYORIGUALQ CON EL TIPO INTEGER");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(this.expresion1.getValue(entorno).toString())>=Double.parseDouble(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MAYORIGUALQ CON EL TIPO DOUBLE");
                    }
                }else{
                    respuesta=null;
                }
            }else if(this.operador==Operador.MENORIGUALQ){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=this.expresion1.getValue(entorno).toString().compareTo(this.expresion2.getValue(entorno).toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice<=0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MENORIGUALQ CON EL TIPO STRING");
                    }
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(this.expresion1.getValue(entorno).toString())<=Integer.parseInt(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MENORIGUALQ CON EL TIPO INTEGER");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(this.expresion1.getValue(entorno).toString())<=Double.parseDouble(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR MENORIGUALQ CON EL TIPO DOUBLE");
                    }
                }else{
                    respuesta=null;
                }
            }else if(this.operador==Operador.DIFERENTE){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=this.expresion1.getValue(entorno).toString().compareTo(this.expresion2.getValue(entorno).toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice!=0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR DIFERENTE CON EL TIPO STRING");
                    }
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(this.expresion1.getValue(entorno).toString())!=Integer.parseInt(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR DIFERENTE CON EL TIPO INTEGER");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(this.expresion1.getValue(entorno).toString())!=Double.parseDouble(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR DIFERENTE CON EL TIPO DOUBLE");
                    }
                }else if(tipo==Type.PrimitiveType.BOOLEAN){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        String valor1=this.expresion1.getValue(entorno).toString();
                        String valor2=this.expresion2.getValue(entorno).toString();
                        boolean va1=false;
                        boolean va2=false;
                        if(valor1.equals("verdadero")){
                            va1=true;
                        }
                        if(valor2.equals("verdadero")){
                            va2=true;
                        }
                        respuesta=va1!=va2;
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR IGUALIGUAL CON EL TIPO BOOLEAN");
                    }
                }else{
                    respuesta=null;
                }
            }else if(this.operador==Operador.IGUALIGUAL){
                if(tipo==Type.PrimitiveType.STRING){
                    try{
                        int indice=this.expresion1.getValue(entorno).toString().compareTo(this.expresion2.getValue(entorno).toString());
                        this.type=Type.PrimitiveType.BOOLEAN;
                        if(indice==0){
                            respuesta=true;
                        }else{
                            respuesta=false;
                        }
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR IGUALIGUAL CON EL TIPO STRING");
                    }
                }else if(tipo==Type.PrimitiveType.INTEGER){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Integer.parseInt(this.expresion1.getValue(entorno).toString())==Integer.parseInt(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR IGUALIGUAL CON EL TIPO INTEGER");
                    }
                }else if(tipo==Type.PrimitiveType.DOUBLE){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        respuesta=Double.parseDouble(this.expresion1.getValue(entorno).toString())==Double.parseDouble(this.expresion2.getValue(entorno).toString());
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR IGUALIGUAL CON EL TIPO DOUBLE");
                    }
                }else if(tipo==Type.PrimitiveType.BOOLEAN){
                    try{
                        this.type=Type.PrimitiveType.BOOLEAN;
                        String valor1=this.expresion1.getValue(entorno).toString();
                        String valor2=this.expresion2.getValue(entorno).toString();
                        boolean va1=false;
                        boolean va2=false;
                        if(valor1.equals("verdadero")){
                            va1=true;
                        }
                        if(valor2.equals("verdadero")){
                            va2=true;
                        }
                        respuesta=va1==va2;
                    }catch(Exception e){
                        System.out.println("ERROR SEMANTICOS AL OPERAR IGUALIGUAL CON EL TIPO BOOLEAN");
                    }
                }else{
                    respuesta=null;
                }
            }else {
                System.out.println("ERROR SEMANTICO: EL TIPO DE OPERACION " + this.operador+"NO PERTENECE A LAS RELACIONALES");
                respuesta=null;
            }
        }else{
            if(this.type==Type.PrimitiveType.ID){
                Simbolo referencia=entorno.Obtener(this.valor.toString());
                if(referencia!=null){
                    this.type=referencia.tipo;
                    respuesta=referencia.valor;
                }else{
                    System.out.println("No existe el id " + this.valor.toString());
                    respuesta=null;
                }
            }else{
                try{
                    respuesta=this.valor;
                }catch(Exception e){
                    System.out.println("ERROR SEMANTICO: ERROR AL MOMENTO DE OBTENER EL VALOR");
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
            if(primero==Type.PrimitiveType.STRING&&segundo==Type.PrimitiveType.STRING){
                respuesta=Type.PrimitiveType.STRING;
            }else if((primero==Type.PrimitiveType.INTEGER||primero==Type.PrimitiveType.DOUBLE)&&(segundo==Type.PrimitiveType.INTEGER||segundo==Type.PrimitiveType.DOUBLE)){
                respuesta=Type.PrimitiveType.DOUBLE;
            }else if(primero==Type.PrimitiveType.BOOLEAN&&segundo==Type.PrimitiveType.BOOLEAN){
                respuesta=Type.PrimitiveType.BOOLEAN;
            }else{
                respuesta=null;
            }
        }catch(Exception e){
            System.out.println("ERROR SEMANTICO: OCURRIO UN ERROR AL MOMENTO DE GENERAR EL TIPO EN RELACIONALES");
        }
        
        return respuesta;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
