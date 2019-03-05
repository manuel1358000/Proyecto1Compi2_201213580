/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.AST;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Expresiones.Llamada_Funcion;
import ArbolAST.Expresiones.operacion.Retornar;
import ArbolAST.Instrucciones.Seleccion.If;
import ArbolAST.Instrucciones.Seleccion.Switch;
import ArbolAST.NodoAST;
import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class Funcion implements Instruccion{
    Type.PrimitiveType tipo;
    String id;
    LinkedList<NodoAST> parametros;
    LinkedList<NodoAST> parametros_entrada;
    LinkedList<NodoAST> lista_bloques;
    //si recibe parametros
    public Funcion(String id,LinkedList<NodoAST>parametros,LinkedList<NodoAST>lista_bloques){
        this.parametros=parametros;
        this.lista_bloques=lista_bloques;
        this.id=generarNombre(id);
        this.tipo=Type.PrimitiveType.NULL;
        this.parametros_entrada=new LinkedList<>();
    }
    //no recibe parametros
    public Funcion(String id,LinkedList<NodoAST>lista_bloques){
        this.parametros=new LinkedList<>();
        this.lista_bloques=lista_bloques;
        this.id=generarNombre(id);
        this.tipo=Type.PrimitiveType.NULL;
        this.parametros_entrada=new LinkedList<>();
    }
    public String generarNombre(String id){
        String respuesta="";
        int indice=0;
        respuesta+=id;
        for(NodoAST nodo:this.parametros){
            if(nodo instanceof Declaracion){
                Declaracion declaracion=(Declaracion)nodo;
                indice++;
            }else{
                //ver que otros tipos puede ingresar aqui un objeto, un array ver que es lo que lleva
            }
        }
        respuesta+="_"+indice;
        return respuesta;
    }
    
    @Override
    public Object execute(Entorno entorno) {
        Object respuesta=null;
        Entorno local=new Entorno(entorno);
        if(this.parametros.size()==this.parametros_entrada.size()){
            for(int i=0;i<this.parametros.size();i++){
                Declaracion declaracion=(Declaracion)this.parametros.get(i);
                Expresion expresion=(Expresion)this.parametros_entrada.get(i);
                declaracion.intValue=expresion;
                if(declaracion.tipo_implicito==Type.PrimitiveType.NULL){
                    declaracion.tipo_implicito=expresion.getType(local);
                }
                Simbolo sim=new Simbolo(true,true,declaracion.tipo,declaracion.getId(),new LinkedList<>(),declaracion.intValue);
                sim.setTipo_implicito(declaracion.tipo_implicito);
                local.AgregarParametro(declaracion.getId(), sim);             
                
            }
            //ya se agregaron los parametros
            for(NodoAST nodo:this.lista_bloques){
                if(nodo instanceof Imprimir){
                    Imprimir imprimir=(Imprimir)nodo;
                    imprimir.execute(local);
                }else if(nodo instanceof Llamada_Funcion){
                    Llamada_Funcion llamada=(Llamada_Funcion)nodo;
                    respuesta=llamada.getValue(local);
                    if(respuesta==null){
                            System.out.println("asdasdas");
                            System.out.println("asdasdas");
                            System.out.println("asdasdas");
                            System.out.println("asdasdas");
                            System.out.println("asdasdas");
                            System.out.println("asdasdas");
                        }
                }else if(nodo instanceof Declaracion){
                    Declaracion declaracion=(Declaracion)nodo;
                    respuesta=declaracion.execute(local);
                }else if(nodo instanceof Asignacion){
                    Asignacion asignacion=(Asignacion)nodo;
                    respuesta=asignacion.execute(local);
                }else if(nodo instanceof If){
                    If i_if=(If)nodo;
                    respuesta=i_if.execute(local);
                    this.tipo=i_if.getTipo();
                }else if(nodo instanceof Switch){
                   Switch i_switch =(Switch)nodo;
                   respuesta=i_switch.execute(local);
                }else if(nodo instanceof Detener){
                    Detener detener=(Detener)nodo;
                    respuesta=detener.execute(local);
                }else if(nodo instanceof Retornar){
                    Retornar retornar=(Retornar)nodo;
                    if(respuesta==null){
                        respuesta= retornar.getValue(local).toString();             
                        this.tipo=retornar.getType(local);
                    }
                    
                }else{
                    System.out.println("ERROR SEMANTICO: ESTA OPERACION ES INVALIDA DENTRO DE UNA FUNCION");
                }
            }
        }else{
            System.out.println("ERROR SEMANTICO: HAY PARAMETROS EXTRAS O HAY PARAMETROS FALTANTES EN LA EJECUCION DE LA FUNCION "+this.getId());
        }
        return respuesta;
    }

    public Type.PrimitiveType getTipo() {
        return tipo;
    }

    public void setTipo(Type.PrimitiveType tipo) {
        this.tipo = tipo;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedList<NodoAST> getParametros() {
        return parametros;
    }

    public void setParametros(LinkedList<NodoAST> parametros) {
        this.parametros = parametros;
    }

    public LinkedList<NodoAST> getParametros_entrada() {
        return parametros_entrada;
    }

    public void setParametros_entrada(LinkedList<NodoAST> parametros_entrada) {
        this.parametros_entrada = parametros_entrada;
    }

    public LinkedList<NodoAST> getLista_bloques() {
        return lista_bloques;
    }

    public void setLista_bloques(LinkedList<NodoAST> lista_bloques) {
        this.lista_bloques = lista_bloques;
    }
    
}
