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
import ArbolAST.Expresiones.Llamada_Funcion;
import ArbolAST.Expresiones.operacion.Aritmetica;
import ArbolAST.Expresiones.operacion.Operacion;
import ArbolAST.NodoAST;
import java.util.Collections;
import java.util.LinkedList;
import javax.lang.model.type.TypeKind;

/**
 *
 * @author anton
 */
public class Funciones_Arreglos implements Expresion{
    Type.PrimitiveType tipo;
    String id;
    LinkedList<Componente_Funcion_Arreglo>funciones_arreglo;
    Type.PrimitiveType tipo_respuesta;
    public Funciones_Arreglos(String id,LinkedList<Componente_Funcion_Arreglo>funciones_arreglo){
        this.id=id;
        this.funciones_arreglo=funciones_arreglo;
        this.tipo=Type.PrimitiveType.NULL;
        this.tipo_respuesta=Type.PrimitiveType.NULL;
    }
    
    public LinkedList<Integer> simplificarInteger(LinkedList<Aritmetica>entrada,Entorno entorno){
        LinkedList<Integer> respuesta=new LinkedList<>();
        for(int i=0;i<entrada.size();i++){
            respuesta.add((Double.valueOf(entrada.get(i).getValue(entorno).toString())).intValue());
        }
        return respuesta;
    }
    public LinkedList<String> simplificarString(LinkedList<Aritmetica>entrada,Entorno entorno){
        LinkedList<String> respuesta=new LinkedList<>();
        for(int i=0;i<entrada.size();i++){
            respuesta.add(entrada.get(i).getValue(entorno).toString());
        }
        return respuesta;
    }
    public LinkedList<Double> simplificarDouble(LinkedList<Aritmetica>entrada,Entorno entorno){
        LinkedList<Double> respuesta=new LinkedList<>();
        for(int i=0;i<entrada.size();i++){
            respuesta.add(Double.parseDouble(entrada.get(i).getValue(entorno).toString()));
        }
        return respuesta;
    }
    public LinkedList<Aritmetica> inversaInteger(LinkedList<Integer> entrada){
        LinkedList<Aritmetica> respuesta=new LinkedList<Aritmetica>();
        for(int i=0;i<entrada.size();i++){
            respuesta.add(new Aritmetica(entrada.get(i),Type.PrimitiveType.INTEGER));
        }
        return respuesta;
    }
    public LinkedList<Aritmetica> inversaString(LinkedList<String> entrada){
        LinkedList<Aritmetica> respuesta=new LinkedList<Aritmetica>();
        for(int i=0;i<entrada.size();i++){
            respuesta.add(new Aritmetica(entrada.get(i),Type.PrimitiveType.INTEGER));
        }
        return respuesta;
    }
    public LinkedList<Aritmetica> inversaDouble(LinkedList<Double> entrada){
        LinkedList<Aritmetica> respuesta=new LinkedList<Aritmetica>();
        for(int i=0;i<entrada.size();i++){
            respuesta.add(new Aritmetica(entrada.get(i),Type.PrimitiveType.INTEGER));
        }
        return respuesta;
    }
    public Type.PrimitiveType verificarHomogeneo(LinkedList<Aritmetica>lista,Entorno entorno){
        Type.PrimitiveType respuesta=Type.PrimitiveType.NULL;
        if(lista.size()>0){
            for(int i=0;i<lista.size();i++){
                if(lista.get(0).getType(entorno)==lista.get(i).getType(entorno)){
                    respuesta=lista.get(i).getType(entorno);
                }else{
                    respuesta=Type.PrimitiveType.NULL;
                    break;
                }
            }
        }
        return respuesta;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        Simbolo sim=(Simbolo)entorno.Obtener(this.id);
        boolean recursiva=false;
        if(sim!=null){
            if(sim.tipo==sim.tipo.ARREGLO){
                for(Componente_Funcion_Arreglo componente:this.funciones_arreglo){
                    LinkedList<Aritmetica> lista=(LinkedList)sim.valor;
                    if(respuesta!=null){
                        if(respuesta instanceof LinkedList){
                            lista=(LinkedList)respuesta;
                            recursiva=true;
                        }else{
                            recursiva=false;
                        }
                    }
                    Type.PrimitiveType homogeneo=verificarHomogeneo(lista, entorno);
                    if(componente.id=="descendente"){
                        if(homogeneo==Type.PrimitiveType.STRING){
                            LinkedList<String> simplificada=simplificarString(lista, entorno);
                            Collections.sort(simplificada);
                            LinkedList<Aritmetica> regreso=inversaString(simplificada);
                            if(recursiva){
                                respuesta=regreso;
                            }else{
                                sim.valor=regreso;
                                entorno.Actualizar(id, sim);
                            }
                        }else if(homogeneo==Type.PrimitiveType.INTEGER){
                            LinkedList<Integer> simplificada=simplificarInteger(lista, entorno);
                            Collections.sort(simplificada);
                            LinkedList<Aritmetica> regreso=inversaInteger(simplificada);
                            if(recursiva){
                                respuesta=regreso;
                            }else{
                                sim.valor=regreso;
                                entorno.Actualizar(id, sim);
                            }
                        }else if(homogeneo==Type.PrimitiveType.DOUBLE){
                            LinkedList<Double> simplificada=simplificarDouble(lista, entorno);
                            Collections.sort(simplificada);
                            LinkedList<Aritmetica> regreso=inversaDouble(simplificada);
                            if(recursiva){
                                respuesta=regreso;
                            }else{
                            }
                            sim.valor=regreso;
                            entorno.Actualizar(id, sim);
                        }else{
                            System.out.println("ERROR SEMANTICO: NO SE PUEDE REALIZAR LA OPERACION DESCENDENTE EN ARREGLO "+sim.id);
                        }
                    }else if(componente.id=="ascendente"){
                        if(homogeneo==Type.PrimitiveType.STRING){
                           LinkedList<String> simplificada=simplificarString(lista, entorno);
                            Collections.sort(simplificada,Collections.reverseOrder());
                            LinkedList<Aritmetica> regreso=inversaString(simplificada);
                            if(recursiva){
                                respuesta=regreso;
                            }else{
                                sim.valor=regreso;
                                entorno.Actualizar(id, sim);
                            }
                        }else if(homogeneo==Type.PrimitiveType.INTEGER){
                            LinkedList<Integer> simplificada=simplificarInteger(lista, entorno);
                            Collections.sort(simplificada,Collections.reverseOrder());
                            LinkedList<Aritmetica> regreso=inversaInteger(simplificada);
                            if(recursiva){
                                respuesta=regreso;
                            }else{
                                sim.valor=regreso;
                                entorno.Actualizar(id, sim);
                            }
                        }else if(homogeneo==Type.PrimitiveType.DOUBLE){
                            LinkedList<Double> simplificada=simplificarDouble(lista, entorno);
                            Collections.sort(simplificada,Collections.reverseOrder());
                            LinkedList<Aritmetica> regreso=inversaDouble(simplificada);
                            if(recursiva){
                                respuesta=regreso;
                            }else{
                                sim.valor=regreso;
                                entorno.Actualizar(id, sim);
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: NO SE PUEDE REALIZAR LA OPERACION DESCENDENTE EN ARREGLO "+sim.id);
                        }
                    }else if(componente.id=="invertir"){
                        //NO NECESITA SER HOMOGENEO
                        if(homogeneo==Type.PrimitiveType.STRING){
                           LinkedList<String> simplificada=simplificarString(lista, entorno);
                            Collections.reverse(simplificada);
                            LinkedList<Aritmetica> regreso=inversaString(simplificada);
                            if(recursiva){
                                respuesta=regreso;
                            }else{
                                sim.valor=regreso;
                                entorno.Actualizar(id, sim);
                            }
                        }else if(homogeneo==Type.PrimitiveType.INTEGER){
                            LinkedList<Integer> simplificada=simplificarInteger(lista, entorno);
                            Collections.reverse(simplificada);
                            LinkedList<Aritmetica> regreso=inversaInteger(simplificada);
                            if(recursiva){
                                respuesta=regreso;
                            }else{
                                sim.valor=regreso;
                                entorno.Actualizar(id, sim);
                            }
                        }else if(homogeneo==Type.PrimitiveType.DOUBLE){
                            LinkedList<Double> simplificada=simplificarDouble(lista, entorno);
                            Collections.reverse(simplificada);
                            LinkedList<Aritmetica> regreso=inversaDouble(simplificada);
                            if(recursiva){
                                respuesta=regreso;
                            }else{
                                sim.valor=regreso;
                                entorno.Actualizar(id, sim);
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: NO SE PUEDE REALIZAR LA OPERACION DESCENDENTE EN ARREGLO "+sim.id);
                        }
                    }else if(componente.id=="maximo"){
                        //NECESITA SER HOMOGENEO
                        //NO NECESITA SER HOMOGENEO
                        if(homogeneo==Type.PrimitiveType.STRING){
                            LinkedList<String> simplificada=simplificarString(lista, entorno);
                            respuesta=Collections.max(simplificada);
                            this.tipo=homogeneo;
                            this.tipo_respuesta=homogeneo;
                        }else if(homogeneo==Type.PrimitiveType.INTEGER){
                            LinkedList<Integer> simplificada=simplificarInteger(lista, entorno);
                            respuesta=Collections.max(simplificada);
                            this.tipo=homogeneo;
                            this.tipo_respuesta=homogeneo;
                        }else if(homogeneo==Type.PrimitiveType.DOUBLE){
                            LinkedList<Double> simplificada=simplificarDouble(lista, entorno);
                            respuesta=Collections.max(simplificada);
                            this.tipo=homogeneo;
                            this.tipo_respuesta=homogeneo;
                        }else{
                            System.out.println("ERROR SEMANTICO: NO SE PUEDE REALIZAR LA OPERACION DESCENDENTE EN ARREGLO "+sim.id);
                        }
                    }else if(componente.id=="minimo"){
                        //NECESITA SER HOMOGENEO
                        if(homogeneo==Type.PrimitiveType.STRING){
                            LinkedList<String> simplificada=simplificarString(lista, entorno);
                            respuesta=Collections.min(simplificada);
                            this.tipo=homogeneo;
                            this.tipo_respuesta=homogeneo;
                        }else if(homogeneo==Type.PrimitiveType.INTEGER){
                            LinkedList<Integer> simplificada=simplificarInteger(lista, entorno);
                            respuesta=Collections.min(simplificada);
                            this.tipo=homogeneo;
                            this.tipo_respuesta=homogeneo;
                        }else if(homogeneo==Type.PrimitiveType.DOUBLE){
                            LinkedList<Double> simplificada=simplificarDouble(lista, entorno);
                            respuesta=Collections.min(simplificada);
                            this.tipo=homogeneo;
                            this.tipo_respuesta=homogeneo;
                        }else{
                            System.out.println("ERROR SEMANTICO: NO SE PUEDE REALIZAR LA OPERACION DESCENDENTE EN ARREGLO "+sim.id);
                        }
                    }else if(componente.id=="filtrar"){
                        //NECESITA SER HOMOGENEO
                        if(homogeneo!=Type.PrimitiveType.NULL){
                            Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toString().toLowerCase()+"_"+1);
                            if(fun!=null){
                                LinkedList<Aritmetica> aux_respuesta=new LinkedList<Aritmetica>();
                                for(Aritmetica aux_arit:lista){
                                    LinkedList<NodoAST> lista_parametros=new LinkedList<>();
                                    lista_parametros.add(aux_arit);
                                    Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro,lista_parametros);
                                    Object valor=llamada.getValue(entorno);
                                    if(llamada.getTipo_respuesta()==Type.PrimitiveType.BOOLEAN){
                                        if(Boolean.valueOf(valor.toString())){
                                            aux_respuesta.add(new Aritmetica(aux_arit.getValue(entorno),aux_arit.getType(entorno)));
                                        }
                                    }else{
                                        System.out.println("ERROR SEMANTICO: LA FUNCION FILTRAR SOLO PUEDE MANDAR A LLAMAR FUNCIONES QUE DEVUELVAN UN BOOLEANO");
                                    }
                                }
                                respuesta=aux_respuesta;
                                this.tipo=Type.PrimitiveType.ARREGLO;
                                this.tipo_respuesta=Type.PrimitiveType.ARREGLO;
                            }else{
                                System.out.println("ERROR SEMANTICO: FILTRAR NO ENCONTRO LA FUNCION "+componente.parametro+", LA FUNCION NO EXISTE O HACEN FALTA/SOBRAN PARAMETROS");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: NO SE PUEDE REALIZAR LA OPERACION FILTRAR EN EL ARREGLO "+sim.id+" NO ES HOMOGENEO");
                        }
                    }else if(componente.id=="buscar"){
                        if(homogeneo!=Type.PrimitiveType.NULL){
                            Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toLowerCase()+"_"+1);
                            if(fun!=null){
                                for(Aritmetica aux_arit:lista){
                                    LinkedList<NodoAST>lista_parametros=new LinkedList<>();
                                    lista_parametros.add(aux_arit);
                                    Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro, lista_parametros);
                                    Object valor=llamada.getValue(entorno);
                                    if(llamada.getTipo_respuesta()==Type.PrimitiveType.BOOLEAN){
                                        if(Boolean.valueOf(valor.toString())){
                                            respuesta=new Aritmetica(aux_arit.getValue(entorno),aux_arit.getType(entorno));
                                            this.tipo=aux_arit.getTipo_Respuesta();
                                            this.tipo_respuesta=aux_arit.getTipo_Respuesta();
                                            recursiva=false;
                                            break;
                                        }
                                    }else{
                                        System.out.println("ERROR SEMANTICO: LA FUNCION BUSCAR SOLO PUEDE MANDAR A LLAMAR FUNCIONES QUE DEVUELVAN UN BOOLEANO");
                                    }
                                }
                            }else{
                                System.out.println("ERROR SEMANTICO: BUSCAR NO ENCONTRO LA FUNCION " +componente.parametro+", LA FUNCION NO EXISTE O HACEN FALTA/SOBRAN PARAMETROS");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: NO SE PUEDE REALIZAR LA OPERACION BUSCAR EN EL ARREGLO "+sim.id+" NO ES HOMOGENEO");
                        }
                    }else if(componente.id=="map"){
                        if(homogeneo!=Type.PrimitiveType.NULL){
                            Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toLowerCase()+"_"+1);
                            if(fun!=null){
                                LinkedList<Aritmetica> aux_respuesta=new LinkedList<Aritmetica>();
                                for(Aritmetica aux_ari:lista){
                                    LinkedList<NodoAST>lista_parametros=new LinkedList<>();
                                    lista_parametros.add(aux_ari);
                                    Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro,lista_parametros);
                                    Object valor=llamada.getValue(entorno);
                                    Type.PrimitiveType aux_tipo=llamada.getTipo_respuesta();
                                    aux_respuesta.add(new Aritmetica(valor,aux_tipo));
                                }
                                respuesta=aux_respuesta;
                                this.tipo=Type.PrimitiveType.ARREGLO;
                                this.tipo_respuesta=Type.PrimitiveType.ARREGLO;
                            }else{
                                System.out.println("ERROR SEMANTICO: BUSCAR NO ENCONTRO LA FUNCION " +componente.parametro+", LA FUNCION NO EXISTE O HACEN FALTA/SOBRAN PARAMETROS");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: NO SE PUEDE REALIZAR LA OPERACION BUSCAR EN EL ARREGLO "+sim.id+" NO ES HOMOGENEO");
                        }
                    }else if(componente.id=="reduce"){
                        Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toLowerCase()+"_"+2);
                        if(fun!=null){
                            Aritmetica acumulador=null;
                            LinkedList<NodoAST>lista_parametros=new LinkedList<>();
                            if(homogeneo!=Type.PrimitiveType.NULL){
                                for(Aritmetica aux_ari:lista){
                                    if(acumulador==null){
                                        acumulador=aux_ari;
                                    }else{
                                        lista_parametros.add(acumulador);
                                        lista_parametros.add(aux_ari);
                                        Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro,lista_parametros);
                                        Object valor=llamada.getValue(entorno);
                                        Type.PrimitiveType aux_tipo=llamada.getTipo_respuesta();
                                        acumulador=new Aritmetica(valor,aux_tipo);
                                        lista_parametros.clear();
                                    }
                                    respuesta=acumulador;
                                    this.tipo=acumulador.getTipo_Respuesta();
                                    this.tipo_respuesta=acumulador.getTipo_Respuesta();
                                    recursiva=false;
                                }
                            }else{
                                System.out.println("ERROR SEMANTICO: NO SE PUEDE REALIZAR LA OPERACION REDUCE EN EL ARREGLO "+sim.id+" NO ES HOMOGENEO");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: BUSCAR NO ENCONTRO LA FUNCION " +componente.parametro+", LA FUNCION NO EXISTE O HACEN FALTA/SOBRAN PARAMETROS");
                        }
                    }else if(componente.id=="todos"){
                        if(homogeneo!=Type.PrimitiveType.NULL){
                            Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toLowerCase()+"_"+1);
                            if(fun!=null){
                                boolean control=false;
                                for(Aritmetica aux_arit:lista){
                                    LinkedList<NodoAST> lista_parametros=new LinkedList<>();
                                    lista_parametros.add(aux_arit);
                                    Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro,lista_parametros);
                                    Object valor=llamada.getValue(entorno);
                                    if(llamada.getTipo_respuesta()==Type.PrimitiveType.BOOLEAN){
                                        if(Boolean.valueOf(valor.toString())){
                                            control=true;
                                        }else{
                                            control=false;
                                        }
                                    }else{
                                        System.out.println("ERROR SEMANTICO: LA FUNCION FILTRAR SOLO PUEDE MANDAR A LLAMAR FUNCIONES QUE DEVUELVAN UN BOOLEANO");
                                    }
                                }
                                respuesta=control;
                                this.tipo=Type.PrimitiveType.BOOLEAN;
                                this.tipo_respuesta=Type.PrimitiveType.BOOLEAN;
                            }else{
                                System.out.println("ERROR SEMANTICO: BUSCAR NO ENCONTRO LA FUNCION " +componente.parametro+", LA FUNCION NO EXISTE O HACEN FALTA/SOBRAN PARAMETROS");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: NO SE PUEDE REALIZAR LA OPERACION BUSCAR EN EL ARREGLO "+sim.id+" NO ES HOMOGENEO");
                        }
                    }else if(componente.id=="alguno"){
                        if(homogeneo!=Type.PrimitiveType.NULL){
                            Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toLowerCase()+"_"+1);
                            if(fun!=null){
                                boolean control=false;
                                for(Aritmetica aux_arit:lista){
                                    LinkedList<NodoAST> lista_parametros=new LinkedList<>();
                                    lista_parametros.add(aux_arit);
                                    Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro,lista_parametros);
                                    Object valor=llamada.getValue(entorno);
                                    if(llamada.getTipo_respuesta()==Type.PrimitiveType.BOOLEAN){
                                        if(Boolean.valueOf(valor.toString())){
                                            control=true;
                                            break;
                                        }
                                    }else{
                                        System.out.println("ERROR SEMANTICO: LA FUNCION FILTRAR SOLO PUEDE MANDAR A LLAMAR FUNCIONES QUE DEVUELVAN UN BOOLEANO");
                                    }
                                }
                                respuesta=control;
                                this.tipo=Type.PrimitiveType.BOOLEAN;
                                this.tipo_respuesta=Type.PrimitiveType.BOOLEAN;
                            }else{
                                System.out.println("ERROR SEMANTICO: BUSCAR NO ENCONTRO LA FUNCION " +componente.parametro+", LA FUNCION NO EXISTE O HACEN FALTA/SOBRAN PARAMETROS");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: NO SE PUEDE REALIZAR LA OPERACION BUSCAR EN EL ARREGLO "+sim.id+" NO ES HOMOGENEO");
                        }
                    }else{
                        System.out.println("ERROR SEMANTICO: LA OPERACION "+componente.id+" NO SE PUEDE REALIZAR PARA UN ARREGLO");
                    }
                    entorno.Actualizar(this.id,sim);
                }
            }else{
                System.out.println("ERROR SEMANTICO: LA VARIABLE "+this.id+" NO ES UN ARREGLO");
            }
        }else{
            System.out.println("ERROR SEMANTICO: LA VARIABLE "+this.id+" NO ESTA DECLARADA EN EL ENTORNO");
            respuesta=null;
        }
        return respuesta;
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        return this.tipo;
    }
    
}
