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
import Auxiliares.Errores;
import java.util.Collections;
import java.util.LinkedList;
import javax.lang.model.type.TypeKind;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class Funciones_Arreglos implements Expresion{
    int linea;
    int columna;
    Type.PrimitiveType tipo;
    String id;
    LinkedList<Componente_Funcion_Arreglo>funciones_arreglo;
    Type.PrimitiveType tipo_respuesta;
    public Funciones_Arreglos(String id,LinkedList<Componente_Funcion_Arreglo>funciones_arreglo,int linea,int columna){
        this.id=id;
        this.linea=linea;
        this.columna=columna;
        this.funciones_arreglo=funciones_arreglo;
        this.tipo=Type.PrimitiveType.NULL;
        this.tipo_respuesta=Type.PrimitiveType.NULL;
    }
    
    public LinkedList<Integer> simplificarInteger(LinkedList<Aritmetica>entrada,Entorno entorno){
        LinkedList<Integer> respuesta=new LinkedList<>();
        try{
            for(int i=0;i<entrada.size();i++){
                respuesta.add((Double.valueOf(entrada.get(i).getValue(entorno).toString())).intValue());
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion simplificar integer");
        }
        return respuesta;
    }
    public LinkedList<String> simplificarString(LinkedList<Aritmetica>entrada,Entorno entorno){
        LinkedList<String> respuesta=new LinkedList<>();
        try{
            for(int i=0;i<entrada.size();i++){
                respuesta.add(entrada.get(i).getValue(entorno).toString());
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion simplificarstring");
        }
        return respuesta;
    }
    public LinkedList<Double> simplificarDouble(LinkedList<Aritmetica>entrada,Entorno entorno){
        LinkedList<Double> respuesta=new LinkedList<>();
        try{
            for(int i=0;i<entrada.size();i++){
                respuesta.add(Double.parseDouble(entrada.get(i).getValue(entorno).toString()));
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion simplificadadouble");
        }
        return respuesta;
    }
    public LinkedList<Aritmetica> inversaInteger(LinkedList<Integer> entrada){
        LinkedList<Aritmetica> respuesta=new LinkedList<Aritmetica>();
        try{
            for(int i=0;i<entrada.size();i++){
                respuesta.add(new Aritmetica(entrada.get(i),Type.PrimitiveType.INTEGER,this.linea,this.columna));
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion inversainteger");
        }
        return respuesta;
    }
    public LinkedList<Aritmetica> inversaString(LinkedList<String> entrada){
        LinkedList<Aritmetica> respuesta=new LinkedList<Aritmetica>();
        try{
            for(int i=0;i<entrada.size();i++){
                respuesta.add(new Aritmetica(entrada.get(i),Type.PrimitiveType.INTEGER,this.linea,this.columna));
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion inversaString");
        }
        return respuesta;
    }
    public LinkedList<Aritmetica> inversaDouble(LinkedList<Double> entrada){
        LinkedList<Aritmetica> respuesta=new LinkedList<Aritmetica>();
        try{
            for(int i=0;i<entrada.size();i++){
                respuesta.add(new Aritmetica(entrada.get(i),Type.PrimitiveType.INTEGER,this.linea,this.columna));
            }
        }catch(Exception e){
            
                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion inversadouble");
        }
        return respuesta;
    }
    public Type.PrimitiveType verificarHomogeneo(LinkedList<Aritmetica>lista,Entorno entorno){
        Type.PrimitiveType respuesta=Type.PrimitiveType.NULL;
        try{
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
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion verificarhomogeneo");
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
                            try{
                                LinkedList<String> simplificada=simplificarString(lista, entorno);
                                Collections.sort(simplificada);
                                LinkedList<Aritmetica> regreso=inversaString(simplificada);
                                if(recursiva){
                                    respuesta=regreso;
                                }else{
                                    sim.valor=regreso;
                                    entorno.Actualizar(id, sim);
                                }
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion descendente string");
                            }
                        }else if(homogeneo==Type.PrimitiveType.INTEGER){
                            try{
                                LinkedList<Integer> simplificada=simplificarInteger(lista, entorno);
                                Collections.sort(simplificada);
                                LinkedList<Aritmetica> regreso=inversaInteger(simplificada);
                                if(recursiva){
                                    respuesta=regreso;
                                }else{
                                    sim.valor=regreso;
                                    entorno.Actualizar(id, sim);
                                }
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion descendente integer");
                            }
                        }else if(homogeneo==Type.PrimitiveType.DOUBLE){
                            try{
                                LinkedList<Double> simplificada=simplificarDouble(lista, entorno);
                                Collections.sort(simplificada);
                                LinkedList<Aritmetica> regreso=inversaDouble(simplificada);
                                if(recursiva){
                                    respuesta=regreso;
                                }else{
                                    sim.valor=regreso;
                                    entorno.Actualizar(id, sim);
                                }
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion descendente double");
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","no se puede realizar la operacion descendente en arreglo",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else if(componente.id=="ascendente"){
                        if(homogeneo==Type.PrimitiveType.STRING){
                            try{
                                LinkedList<String> simplificada=simplificarString(lista, entorno);
                                Collections.sort(simplificada,Collections.reverseOrder());
                                LinkedList<Aritmetica> regreso=inversaString(simplificada);
                                if(recursiva){
                                    respuesta=regreso;
                                }else{
                                    sim.valor=regreso;
                                    entorno.Actualizar(id, sim);
                                }
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion ascendente string");
                            }
                        }else if(homogeneo==Type.PrimitiveType.INTEGER){
                            try{
                                LinkedList<Integer> simplificada=simplificarInteger(lista, entorno);
                                Collections.sort(simplificada,Collections.reverseOrder());
                                LinkedList<Aritmetica> regreso=inversaInteger(simplificada);
                                if(recursiva){
                                    respuesta=regreso;
                                }else{
                                    sim.valor=regreso;
                                    entorno.Actualizar(id, sim);
                                }
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion ascendente integer");
                            }
                        }else if(homogeneo==Type.PrimitiveType.DOUBLE){
                            try{
                                LinkedList<Double> simplificada=simplificarDouble(lista, entorno);
                                Collections.sort(simplificada,Collections.reverseOrder());
                                LinkedList<Aritmetica> regreso=inversaDouble(simplificada);
                                if(recursiva){
                                    respuesta=regreso;
                                }else{
                                    sim.valor=regreso;
                                    entorno.Actualizar(id, sim);
                                }
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion ascendente double");
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","no se puede realizar la operacion ascendente en arreglo",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else if(componente.id=="invertir"){
                        //NO NECESITA SER HOMOGENEO
                        if(homogeneo==Type.PrimitiveType.STRING){
                            try{
                                LinkedList<String> simplificada=simplificarString(lista, entorno);
                                Collections.reverse(simplificada);
                                LinkedList<Aritmetica> regreso=inversaString(simplificada);
                                if(recursiva){
                                    respuesta=regreso;
                                }else{
                                    sim.valor=regreso;
                                    entorno.Actualizar(id, sim);
                                }
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion invertir string");
                            }
                        }else if(homogeneo==Type.PrimitiveType.INTEGER){
                            try{
                                LinkedList<Integer> simplificada=simplificarInteger(lista, entorno);
                                Collections.reverse(simplificada);
                                LinkedList<Aritmetica> regreso=inversaInteger(simplificada);
                                if(recursiva){
                                    respuesta=regreso;
                                }else{
                                    sim.valor=regreso;
                                    entorno.Actualizar(id, sim);
                                }
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion invertir integer");
                            }
                        }else if(homogeneo==Type.PrimitiveType.DOUBLE){
                            try{
                                LinkedList<Double> simplificada=simplificarDouble(lista, entorno);
                                Collections.reverse(simplificada);
                                LinkedList<Aritmetica> regreso=inversaDouble(simplificada);
                                if(recursiva){
                                    respuesta=regreso;
                                }else{
                                    sim.valor=regreso;
                                    entorno.Actualizar(id, sim);
                                }
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion invertir duoble");
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","no se puede realizar la operacion invertir en arreglo",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else if(componente.id=="maximo"){
                        //NECESITA SER HOMOGENEO
                        //NO NECESITA SER HOMOGENEO
                        if(homogeneo==Type.PrimitiveType.STRING){
                            try{
                                LinkedList<String> simplificada=simplificarString(lista, entorno);
                                respuesta=Collections.max(simplificada);
                                this.tipo=homogeneo;
                                this.tipo_respuesta=homogeneo;
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion maximo string");
                            }
                        }else if(homogeneo==Type.PrimitiveType.INTEGER){
                            try{
                                LinkedList<Integer> simplificada=simplificarInteger(lista, entorno);
                                respuesta=Collections.max(simplificada);
                                this.tipo=homogeneo;
                                this.tipo_respuesta=homogeneo;
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion maximo integer");
                            }
                        }else if(homogeneo==Type.PrimitiveType.DOUBLE){
                            try{
                                LinkedList<Double> simplificada=simplificarDouble(lista, entorno);
                                respuesta=Collections.max(simplificada);
                                this.tipo=homogeneo;
                                this.tipo_respuesta=homogeneo;
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion maximo double");
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","no se puede realizar la funcion descendente en arreglo",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else if(componente.id=="minimo"){
                        //NECESITA SER HOMOGENEO
                        if(homogeneo==Type.PrimitiveType.STRING){
                            try{
                                LinkedList<String> simplificada=simplificarString(lista, entorno);
                                respuesta=Collections.min(simplificada);
                                this.tipo=homogeneo;
                                this.tipo_respuesta=homogeneo;
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion funcion minimo string");
                            }
                        }else if(homogeneo==Type.PrimitiveType.INTEGER){
                            try{
                                LinkedList<Integer> simplificada=simplificarInteger(lista, entorno);
                                respuesta=Collections.min(simplificada);
                                this.tipo=homogeneo;
                                this.tipo_respuesta=homogeneo;
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la funcion minimo integer");
                            }
                        }else if(homogeneo==Type.PrimitiveType.DOUBLE){
                            try{
                                LinkedList<Double> simplificada=simplificarDouble(lista, entorno);
                                respuesta=Collections.min(simplificada);
                                this.tipo=homogeneo;
                                this.tipo_respuesta=homogeneo;
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la funcion minimo double");
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","no se puede realizar la operacion descendente en arreglo",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else if(componente.id=="filtrar"){
                        //NECESITA SER HOMOGENEO
                        if(homogeneo!=Type.PrimitiveType.NULL){
                            Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toString().toLowerCase()+"_"+1);
                            if(fun!=null){
                                try{
                                    LinkedList<Aritmetica> aux_respuesta=new LinkedList<Aritmetica>();
                                    for(Aritmetica aux_arit:lista){
                                        LinkedList<NodoAST> lista_parametros=new LinkedList<>();
                                        lista_parametros.add(aux_arit);
                                        Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro,lista_parametros,this.linea,this.columna);
                                        Object valor=llamada.getValue(entorno);
                                        if(llamada.getTipo_respuesta()==Type.PrimitiveType.BOOLEAN){
                                            if(Boolean.valueOf(valor.toString())){
                                                aux_respuesta.add(new Aritmetica(aux_arit.getValue(entorno),aux_arit.getType(entorno),this.linea,this.columna));
                                            }
                                        }else{
                                            Errores error=new Errores("SEMANTICO","la funcion filtrar solo puede llamar a funciones que devuelvan un booleano",this.linea,this.columna);
                                            Proyecto1Compi2_201213580.errores_fs.add(error);
                                        }
                                    }
                                    respuesta=aux_respuesta;
                                    this.tipo=Type.PrimitiveType.ARREGLO;
                                    this.tipo_respuesta=Type.PrimitiveType.ARREGLO;
                                }catch(Exception e){
                                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la funcion filtrar");
                                }
                            }else{
                                Errores error=new Errores("SEMANTICO","filtrar no enconro la funcion",this.linea,this.columna);
                                Proyecto1Compi2_201213580.errores_fs.add(error);
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","no se puede realizar la funcion fultrar en un arreglo que no es homogeneo",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else if(componente.id=="buscar"){
                        if(homogeneo!=Type.PrimitiveType.NULL){
                            Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toLowerCase()+"_"+1);
                            if(fun!=null){
                                try{
                                    for(Aritmetica aux_arit:lista){
                                        LinkedList<NodoAST>lista_parametros=new LinkedList<>();
                                        lista_parametros.add(aux_arit);
                                        Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro, lista_parametros,this.linea,this.columna);
                                        Object valor=llamada.getValue(entorno);
                                        if(llamada.getTipo_respuesta()==Type.PrimitiveType.BOOLEAN){
                                            if(Boolean.valueOf(valor.toString())){
                                                respuesta=new Aritmetica(aux_arit.getValue(entorno),aux_arit.getType(entorno),this.linea,this.columna);
                                                this.tipo=aux_arit.getTipo_Respuesta();
                                                this.tipo_respuesta=aux_arit.getTipo_Respuesta();
                                                recursiva=false;
                                                break;
                                            }
                                        }else{
                                            Errores error=new Errores("SEMANTICO","la funcion buscar solo puede mandar a llamar funciones que devuelvan un booleano",this.linea,this.columna);
                                            Proyecto1Compi2_201213580.errores_fs.add(error);
                                        }
                                    }
                                }catch(Exception e){
                                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la funcion buscar");
                                }
                            }else{
                                Errores error=new Errores("SEMANTICO","buscar no encontro la funcion",this.linea,this.columna);
                                Proyecto1Compi2_201213580.errores_fs.add(error);
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","no se puede realizar la funcion buscar en un arreglo que no sea homogeneo",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else if(componente.id=="map"){
                        if(homogeneo!=Type.PrimitiveType.NULL){
                            Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toLowerCase()+"_"+1);
                            if(fun!=null){
                                try{
                                    LinkedList<Aritmetica> aux_respuesta=new LinkedList<Aritmetica>();
                                    for(Aritmetica aux_ari:lista){
                                        LinkedList<NodoAST>lista_parametros=new LinkedList<>();
                                        lista_parametros.add(aux_ari);
                                        Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro,lista_parametros,this.linea,this.columna);
                                        Object valor=llamada.getValue(entorno);
                                        Type.PrimitiveType aux_tipo=llamada.getTipo_respuesta();
                                        aux_respuesta.add(new Aritmetica(valor,aux_tipo,this.linea,this.columna));
                                    }
                                    respuesta=aux_respuesta;
                                    this.tipo=Type.PrimitiveType.ARREGLO;
                                    this.tipo_respuesta=Type.PrimitiveType.ARREGLO;
                                }catch(Exception e){
                                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en funcion map");
                                }
                            }else{
                                Errores error=new Errores("SEMANTICO","map no encontro la funcion",this.linea,this.columna);
                                Proyecto1Compi2_201213580.errores_fs.add(error);
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","no se puede realizar la funcion map en un arreglo que no es homogeneo",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else if(componente.id=="reduce"){
                        Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toLowerCase()+"_"+2);
                        if(fun!=null){
                            try{
                                Aritmetica acumulador=null;
                                LinkedList<NodoAST>lista_parametros=new LinkedList<>();
                                if(homogeneo!=Type.PrimitiveType.NULL){
                                    for(Aritmetica aux_ari:lista){
                                        if(acumulador==null){
                                            acumulador=aux_ari;
                                        }else{
                                            lista_parametros.add(acumulador);
                                            lista_parametros.add(aux_ari);
                                            Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro,lista_parametros,this.linea,this.columna);
                                            Object valor=llamada.getValue(entorno);
                                            Type.PrimitiveType aux_tipo=llamada.getTipo_respuesta();
                                            acumulador=new Aritmetica(valor,aux_tipo,this.linea,this.columna);
                                            lista_parametros.clear();
                                        }
                                        respuesta=acumulador;
                                        this.tipo=acumulador.getTipo_Respuesta();
                                        this.tipo_respuesta=acumulador.getTipo_Respuesta();
                                        recursiva=false;
                                    }
                                }else{
                                    Errores error=new Errores("SEMANTICO","no se puede realizar la operacion reduce el arreglo no es homogeneo",this.linea,this.columna);
                                    Proyecto1Compi2_201213580.errores_fs.add(error);
                                }
                            }catch(Exception e){
                                javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en el metodo reduce");
                                System.out.println("ERROR EN REDUCE");
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","reduce no encontro la funcion",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else if(componente.id=="todos"){
                        if(homogeneo!=Type.PrimitiveType.NULL){
                            Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toLowerCase()+"_"+1);
                            if(fun!=null){
                                try{
                                    boolean control=false;
                                    for(Aritmetica aux_arit:lista){
                                        LinkedList<NodoAST> lista_parametros=new LinkedList<>();
                                        lista_parametros.add(aux_arit);
                                        Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro,lista_parametros,this.linea,this.columna);
                                        Object valor=llamada.getValue(entorno);
                                        if(llamada.getTipo_respuesta()==Type.PrimitiveType.BOOLEAN){
                                            if(Boolean.valueOf(valor.toString())){
                                                control=true;
                                            }else{
                                                control=false;
                                            }
                                        }else{
                                            Errores error=new Errores("SEMANTICO","la funcion filtrar solo puede mandar a llamar funciones que devuelvan un booleano",this.linea,this.columna);
                                            Proyecto1Compi2_201213580.errores_fs.add(error);
                                        }
                                    }
                                    respuesta=control;
                                    this.tipo=Type.PrimitiveType.BOOLEAN;
                                    this.tipo_respuesta=Type.PrimitiveType.BOOLEAN;
                                }catch(Exception e){
                                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la funcion todos");
                                }
                            }else{
                                Errores error=new Errores("SEMANTICO","todos no encontro la funcion, puede que no exista o que no tenga la cantidad de parametros necesarios",this.linea,this.columna);
                                Proyecto1Compi2_201213580.errores_fs.add(error);
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","no se puede realizar la operacion buscar en un arreglo que no es homogeneo",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else if(componente.id=="alguno"){
                        if(homogeneo!=Type.PrimitiveType.NULL){
                            Simbolo fun=(Simbolo)entorno.Obtener(componente.parametro.toLowerCase()+"_"+1);
                            if(fun!=null){
                                try{
                                    boolean control=false;
                                    for(Aritmetica aux_arit:lista){
                                        LinkedList<NodoAST> lista_parametros=new LinkedList<>();
                                        lista_parametros.add(aux_arit);
                                        Llamada_Funcion llamada=new Llamada_Funcion(Type.PrimitiveType.ARREGLO,componente.parametro,lista_parametros,this.linea,this.columna);
                                        Object valor=llamada.getValue(entorno);
                                        if(llamada.getTipo_respuesta()==Type.PrimitiveType.BOOLEAN){
                                            if(Boolean.valueOf(valor.toString())){
                                                control=true;
                                                break;
                                            }
                                        }else{
                                            Errores error=new Errores("SEMANTICO","la funcion filtrar solo puede mandar a llamadar funciones que devuelvan un booleano",this.linea,this.columna);
                                            Proyecto1Compi2_201213580.errores_fs.add(error);
                                        }
                                    }
                                    respuesta=control;
                                    this.tipo=Type.PrimitiveType.BOOLEAN;
                                    this.tipo_respuesta=Type.PrimitiveType.BOOLEAN;
                                }catch(Exception e){
                                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en el metodo alguno");
                                }
                            }else{
                                Errores error=new Errores("SEMANTICO","alguno no se encontro la funcion, hacen falta =/sobran parametros",this.linea,this.columna);
                                Proyecto1Compi2_201213580.errores_fs.add(error);
                            }
                        }else{
                            Errores error=new Errores("SEMANTICO","no se puede realizar la operacion arreglo en un no homogeneo",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else{
                        Errores error=new Errores("SEMANTICO","la operacion no se puede realizar para un arreglo",this.linea,this.columna);
                        Proyecto1Compi2_201213580.errores_fs.add(error);
                    }
                    entorno.Actualizar(this.id,sim);
                }
            }else{
                
                Errores error=new Errores("SEMANTICO","la variable no es un arreglo",this.linea,this.columna);
                Proyecto1Compi2_201213580.errores_fs.add(error);
            }
        }else{
            Errores error=new Errores("SEMANTICO","la variable no esta declarada en el entorno",this.linea,this.columna);
            Proyecto1Compi2_201213580.errores_fs.add(error);
            respuesta=null;
        }
        return respuesta;
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        return this.tipo;
    }
    
}
