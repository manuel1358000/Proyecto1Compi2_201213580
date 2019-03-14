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
import ArbolAST.NodoAST;
import ElementosUI.Area_UI;
import ElementosUI.Boton_UI;
import ElementosUI.Caja_UI;
import ElementosUI.Desplegable_UI;
import ElementosUI.Imagen_UI;
import ElementosUI.Numerico_UI;
import ElementosUI.Panel_UI;
import ElementosUI.Texto_UI;
import ElementosUI.Ventana_UI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author anton
 */
public class Declaracion_UI implements Expresion{
    String id;
    String id_padre;
    Type.PrimitiveType tipo;
    LinkedList<NodoAST>lista_parametros;
    public Declaracion_UI(String id,String id_padre,Type.PrimitiveType tipo,LinkedList<NodoAST> lista_parametros){
        this.id=id;
        this.id_padre=id_padre;
        this.tipo=tipo;
        this.lista_parametros=lista_parametros;
    }
    public Declaracion_UI(Type.PrimitiveType tipo,LinkedList<NodoAST>lista_parametros){
        this.tipo=tipo;
        this.lista_parametros=lista_parametros;
        this.id="";
        this.id_padre="";
    }
    public String getId() {
        return id;
    }
    public void AsignarID(){
        
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getId_padre() {
        return id_padre;
    }

    public void setId_padre(String id_padre) {
        this.id_padre = id_padre;
    }

    public Type.PrimitiveType getTipo() {
        return tipo;
    }

    public void setTipo(Type.PrimitiveType tipo) {
        this.tipo = tipo;
    }

    public LinkedList<NodoAST> getLista_parametros() {
        return lista_parametros;
    }

    public void setLista_parametros(LinkedList<NodoAST> lista_parametros) {
        this.lista_parametros = lista_parametros;
    }
    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        if(this.tipo==Type.PrimitiveType.IMAGEN||this.tipo==Type.PrimitiveType.AUDIO||this.tipo==Type.PrimitiveType.VIDEO){
            if(tipo==Type.PrimitiveType.VIDEO){
                try{
                    if(this.lista_parametros.size()==2){
                        Simbolo aux_padre=(Simbolo)entorno.Obtener(this.id_padre.toLowerCase());
                        if(aux_padre!=null){


                        }else{
                            System.out.println("ERROR SEMANTICO: NO EXISTE EL CONTENEDOR ASOCIADO A LA CAJA DE TEXTO");
                        }
                    }else{
                        System.out.println("ERROR SEMANTICO: HACEN FALTA ELEMENTOS EN LA DEFINICION CAJA TEXTO");
                    }
                }catch(Exception e){
                    System.out.println("OCURRIO UN ERROR EN LA CREACION DE UN VIDEO");
                }

            }else if(tipo==Type.PrimitiveType.AUDIO){
                try{
                    if(this.lista_parametros.size()==2){
                        Simbolo aux_padre=(Simbolo)entorno.Obtener(this.id_padre.toLowerCase());
                        if(aux_padre!=null){
                        }else{
                            System.out.println("ERROR SEMANTICO: NO EXISTE EL CONTENEDOR ASOCIADO A LA CAJA DE TEXTO");
                        }
                    }else{
                        System.out.println("ERROR SEMANTICO: HACEN FALTA ELEMENTOS EN LA DEFINICION CAJA TEXTO");
                    }
                }catch(Exception e){
                    System.out.println("OCURRIO UN ERROR EN LA CREACION DE UN AUDIO");
                }
            }else if(tipo==Type.PrimitiveType.IMAGEN){
                try{
                    if(this.lista_parametros.size()==5){
                        Simbolo aux_padre=(Simbolo)entorno.Obtener(this.id_padre.toLowerCase());
                        if(aux_padre!=null){
                            String ruta=((Aritmetica)this.lista_parametros.get(0)).getValue(entorno).toString().replaceAll("\"","");
                            String x=((Aritmetica)this.lista_parametros.get(1)).getValue(entorno).toString().replaceAll("\"","");
                            String y=((Aritmetica)this.lista_parametros.get(2)).getValue(entorno).toString().replaceAll("\"","");
                            String alto=((Aritmetica)this.lista_parametros.get(3)).getValue(entorno).toString().replaceAll("\"","");
                            String ancho=((Aritmetica)this.lista_parametros.get(4)).getValue(entorno).toString().replaceAll("\"","");
                            Imagen_UI imagen=new Imagen_UI(this.id,ruta,x,y,alto,ancho);
                            imagen.setId_padre(this.id_padre);
                            Simbolo simbol=new Simbolo(false,false,this.tipo,this.id,new LinkedList<>(),imagen);
                            entorno.Agregar(this.id, simbol);
                            NodoAST nodd=(NodoAST)aux_padre.valor;
                            if(nodd instanceof Panel_UI){
                                Panel_UI aux_conte=(Panel_UI)aux_padre.valor;
                                aux_conte.Agregar_Componente(imagen);
                                aux_padre.valor=aux_conte;
                                entorno.Actualizar(aux_padre.getId(),aux_padre);
                            }else{
                                System.out.println("ERROR SEMANTICO: EL COMPONENTE AREATEXTO NO PUEDE ESTAR FUERA DE UN CONTENEDOR");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: NO EXISTE EL CONTENEDOR ASOCIADO A LA CAJA DE TEXTO");
                        }
                    }else{
                        System.out.println("ERROR SEMANTICO: HACEN FALTA ELEMENTOS EN LA DEFINICION CAJA TEXTO");
                    }
                }catch(Exception e){
                    System.out.println("OCURRIO UN ERROR EN LA CREACION DE UNA IMAGEN");
                }

            }
        }else{
            Simbolo sim=(Simbolo)entorno.Obtener(this.id);
            
            if(sim==null){
                if(tipo==Type.PrimitiveType.VENTANA){
                    try{
                        if(this.lista_parametros.size()==4){
                            try{
                                String color=((Aritmetica)this.lista_parametros.get(0)).getValue(entorno).toString();
                                String alto=((Aritmetica)this.lista_parametros.get(1)).getValue(entorno).toString();
                                String ancho=((Aritmetica)this.lista_parametros.get(2)).getValue(entorno).toString();
                                String id_ui=((Aritmetica)this.lista_parametros.get(3)).getValue(entorno).toString().toLowerCase();
                                Ventana_UI ventana=new Ventana_UI(this.id,color,alto,ancho,id_ui);
                                ventana.setVisible(false);
                                Simbolo simbol=new Simbolo(false,false,this.tipo,this.id,new LinkedList<>(),ventana);
                                entorno.Agregar(this.id.toLowerCase(), simbol);
                                respuesta=ventana;
                            }catch(Exception e){
                                System.out.println("ERROR SEMANTICO: EN LA CREACION DE LA VENTANA");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: HACEN FALTA ELEMENTOS EN LA DEFINICION CREARVENTANA");
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA CREACION DE UNA VENTANA");
                    }
                }else if(tipo==Type.PrimitiveType.CONTENEDOR){
                    try{
                        if(this.lista_parametros.size()==6){
                            try{
                                Simbolo ven_sim=(Simbolo)entorno.Obtener(this.id_padre.toLowerCase());
                                if(ven_sim!=null){
                                    String alto=((Aritmetica)this.lista_parametros.get(0)).getValue(entorno).toString();
                                    String ancho=((Aritmetica)this.lista_parametros.get(1)).getValue(entorno).toString();
                                    String color=((Aritmetica)this.lista_parametros.get(2)).getValue(entorno).toString();
                                    String borde=((Aritmetica)this.lista_parametros.get(3)).getValue(entorno).toString();
                                    String x=((Aritmetica)this.lista_parametros.get(4)).getValue(entorno).toString();
                                    String y=((Aritmetica)this.lista_parametros.get(5)).getValue(entorno).toString();
                                    Panel_UI panel=new Panel_UI(this.id, x, y, alto, ancho, color, borde);
                                    panel.setPreferredSize(new Dimension(1500,1500));
                                    Simbolo simbol=new Simbolo(false,false,this.tipo,this.id,new LinkedList<>(),panel);
                                    entorno.Agregar(id, simbol);
                                    Ventana_UI aux_ven=(Ventana_UI)ven_sim.valor;
                                    JScrollPane scroll=new JScrollPane(panel);
                                    scroll.setBounds(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(ancho),Integer.parseInt(alto));
                                    scroll.setViewportView(panel);
                                    aux_ven.Agregar_Panel_Scroll(scroll);
                                    aux_ven.Agregar_Panel_Normal(panel);
                                    ven_sim.valor=aux_ven;
                                    entorno.Actualizar(ven_sim.getId(),ven_sim);
                                }else{
                                    System.out.println("NO EXISTE LA VENTANA "+this.id_padre+" QUE VA A CREAR EL CONTENEDOR "+this.id);
                                }
                            }catch(Exception e){
                                System.out.println("ERROR SEMANTICO: EN LA CREACION DEL CONTENEDOR");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: HACEN FALTA ELEMENTOS EN LA DEFINICION CREARCONTENEDOR");
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA CREACION DE UN CONTENEDOR");
                    }
                }else if(tipo==Type.PrimitiveType.BOTON){
                    try{
                        if(this.lista_parametros.size()==9){
                            Simbolo conte_sim=(Simbolo)entorno.Obtener(this.id_padre.toLowerCase());
                            if(conte_sim!=null){
                                String fuente=((Aritmetica)this.lista_parametros.get(0)).getValue(entorno).toString().replaceAll("\"","");
                                String tam=((Aritmetica)this.lista_parametros.get(1)).getValue(entorno).toString().replaceAll("\"","");
                                String color=((Aritmetica)this.lista_parametros.get(2)).getValue(entorno).toString().replaceAll("\"","");
                                String x=((Aritmetica)this.lista_parametros.get(3)).getValue(entorno).toString().replaceAll("\"","");
                                String y=((Aritmetica)this.lista_parametros.get(4)).getValue(entorno).toString().replaceAll("\"","");
                                Llamada_Funcion referencia=null;
                                Expresion ref_aux=((Expresion)this.lista_parametros.get(5));
                                if(ref_aux instanceof Llamada_Funcion){
                                    referencia=(Llamada_Funcion)ref_aux;
                                }
                                String valor=((Aritmetica)this.lista_parametros.get(6)).getValue(entorno).toString().replaceAll("\"","");
                                String alto=((Aritmetica)this.lista_parametros.get(7)).getValue(entorno).toString().replaceAll("\"","");
                                String ancho=((Aritmetica)this.lista_parametros.get(8)).getValue(entorno).toString().replaceAll("\"","");
                                Boton_UI boton=new Boton_UI(this.id,fuente,tam,color,x,y,referencia,valor,alto,ancho);
                                boton.setId_padre(this.id_padre);
                                Simbolo simbol=new Simbolo(false,false,this.tipo,this.id,new LinkedList<>(),boton);
                                entorno.Agregar(id, simbol);
                                Panel_UI aux_conte=(Panel_UI)conte_sim.valor;
                                aux_conte.Agregar_Componente(boton);
                                conte_sim.valor=aux_conte;
                                entorno.Actualizar(conte_sim.getId(),conte_sim);
                            }else{
                                System.out.println("ERROR SEMANTICO: EL CONTENEDOR "+this.id_padre+" QUE HACE REFERENCIA NO EXISTE");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: HACEN FALTA ELEMENTOS EN LA DEFINICION CREARCONTENEDOR");
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA CREACION DE UNA BOTON");
                    }
                }else if(tipo==Type.PrimitiveType.TEXTO){
                    try{
                        if(this.lista_parametros.size()==8){
                            Simbolo aux_padre=(Simbolo)entorno.Obtener(this.id_padre.toLowerCase());
                            if(aux_padre!=null){
                                String fuente=((Aritmetica)this.lista_parametros.get(0)).getValue(entorno).toString().replaceAll("\"","");
                                String tam=((Aritmetica)this.lista_parametros.get(1)).getValue(entorno).toString().replaceAll("\"","");
                                String color=((Aritmetica)this.lista_parametros.get(2)).getValue(entorno).toString().replaceAll("\"","");
                                String x=((Aritmetica)this.lista_parametros.get(3)).getValue(entorno).toString().replaceAll("\"","");
                                String y=((Aritmetica)this.lista_parametros.get(4)).getValue(entorno).toString().replaceAll("\"","");
                                String negrita=((Aritmetica)this.lista_parametros.get(5)).getValue(entorno).toString().replaceAll("\"","");
                                String cursiva=((Aritmetica)this.lista_parametros.get(6)).getValue(entorno).toString().replaceAll("\"","");
                                String valor=((Aritmetica)this.lista_parametros.get(7)).getValue(entorno).toString().replaceAll("\"","");
                                Texto_UI texto=new Texto_UI(color, x, y, fuente, tam, color, negrita, cursiva, valor);
                                texto.setId_padre(this.id_padre);
                                //Simbolo simbol=new Simbolo(false,false,this.tipo,valor,new LinkedList<>(),texto);
                                //entorno.Agregar(valor, simbol);
                                NodoAST nodd=(NodoAST)aux_padre.valor;
                                if(nodd instanceof Panel_UI){
                                    Panel_UI aux_conte=(Panel_UI)aux_padre.valor;
                                    aux_conte.Agregar_Componente(texto);
                                    aux_padre.valor=aux_conte;
                                    entorno.Actualizar(aux_padre.getId(),aux_padre);
                                }else if(nodd instanceof Boton_UI){
                                    Boton_UI aux_conte=(Boton_UI)aux_padre.valor;
                                    aux_conte.agregarComponente(texto);
                                    aux_padre.valor=aux_conte;
                                    entorno.Actualizar(aux_padre.getId(),aux_padre);
                                }
                            }else{
                                System.out.println("ERROR SEMANTICO: NO EXISTE EL CONTENEDOR/BOTON ASOCIADO AL TEXTO");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: HACEN FALTA ELEMENTOS EN LA DEFINICION CREARTEXTO");
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA CREACION DE UN TEXTO");
                    }
                }else if(tipo==Type.PrimitiveType.AREATEXTO){
                    try{
                        if(this.lista_parametros.size()==11){
                            Simbolo aux_padre=(Simbolo)entorno.Obtener(this.id_padre.toLowerCase());
                            if(aux_padre!=null){
                                String alto=((Aritmetica)this.lista_parametros.get(0)).getValue(entorno).toString().replaceAll("\"","");
                                String ancho=((Aritmetica)this.lista_parametros.get(1)).getValue(entorno).toString().replaceAll("\"","");
                                String fuente=((Aritmetica)this.lista_parametros.get(2)).getValue(entorno).toString().replaceAll("\"","");
                                String tam=((Aritmetica)this.lista_parametros.get(3)).getValue(entorno).toString().replaceAll("\"","");
                                String color=((Aritmetica)this.lista_parametros.get(4)).getValue(entorno).toString().replaceAll("\"","");
                                String x=((Aritmetica)this.lista_parametros.get(5)).getValue(entorno).toString().replaceAll("\"","");
                                String y=((Aritmetica)this.lista_parametros.get(6)).getValue(entorno).toString().replaceAll("\"","");
                                String negrita=((Aritmetica)this.lista_parametros.get(7)).getValue(entorno).toString().replaceAll("\"","");
                                String cursiva=((Aritmetica)this.lista_parametros.get(8)).getValue(entorno).toString().replaceAll("\"","");
                                String defecto=((Aritmetica)this.lista_parametros.get(9)).getValue(entorno).toString().replaceAll("\"","");
                                String nombre=((Aritmetica)this.lista_parametros.get(10)).getValue(entorno).toString().replaceAll("\"","");
                                Area_UI area_texto=new Area_UI(alto,ancho,fuente,tam,color,x,y,negrita,cursiva,defecto,nombre);
                                area_texto.setId_padre(this.id_padre);
                                Simbolo simbol=new Simbolo(false,false,this.tipo,nombre+defecto,new LinkedList<>(),area_texto);
                                entorno.Agregar(nombre+defecto, simbol);
                                NodoAST nodd=(NodoAST)aux_padre.valor;
                                if(nodd instanceof Panel_UI){
                                    Panel_UI aux_conte=(Panel_UI)aux_padre.valor;
                                    aux_conte.Agregar_Componente(area_texto);
                                    aux_padre.valor=aux_conte;
                                    entorno.Actualizar(aux_padre.getId(),aux_padre);
                                }else{
                                    System.out.println("ERROR SEMANTICO: EL COMPONENTE AREATEXTO NO PUEDE ESTAR FUERA DE UN CONTENEDOR");
                                }

                            }else{
                                System.out.println("ERROR SEMANTICO: NO EXISTE EL CONTENEDOR ASOCIADO AL AREA DE TEXTO");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: HACE FALTAN ELEMENTOS EN LA DEFINICION AREA TEXTO");
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA CREACION DE UNA AREA TEXTO");
                    }
                }else if(tipo==Type.PrimitiveType.CAJATEXTO){
                    try{
                        if(this.lista_parametros.size()==11){
                            Simbolo aux_padre=(Simbolo)entorno.Obtener(this.id_padre.toLowerCase());
                            if(aux_padre!=null){
                                String alto=((Aritmetica)this.lista_parametros.get(0)).getValue(entorno).toString().replaceAll("\"","");
                                String ancho=((Aritmetica)this.lista_parametros.get(1)).getValue(entorno).toString().replaceAll("\"","");
                                String fuente=((Aritmetica)this.lista_parametros.get(2)).getValue(entorno).toString().replaceAll("\"","");
                                String tam=((Aritmetica)this.lista_parametros.get(3)).getValue(entorno).toString().replaceAll("\"","");
                                String color=((Aritmetica)this.lista_parametros.get(4)).getValue(entorno).toString().replaceAll("\"","");
                                String x=((Aritmetica)this.lista_parametros.get(5)).getValue(entorno).toString().replaceAll("\"","");
                                String y=((Aritmetica)this.lista_parametros.get(6)).getValue(entorno).toString().replaceAll("\"","");
                                String negrita=((Aritmetica)this.lista_parametros.get(7)).getValue(entorno).toString().replaceAll("\"","");
                                String cursiva=((Aritmetica)this.lista_parametros.get(8)).getValue(entorno).toString().replaceAll("\"","");
                                String defecto=((Aritmetica)this.lista_parametros.get(9)).getValue(entorno).toString().replaceAll("\"","");
                                String nombre=((Aritmetica)this.lista_parametros.get(10)).getValue(entorno).toString().replaceAll("\"","");
                                Caja_UI caja=new Caja_UI(alto,ancho,fuente,tam,color,x,y,negrita,cursiva,defecto,nombre);
                                caja.setId_padre(this.id_padre);
                                Simbolo simbol=new Simbolo(false,false,this.tipo,nombre+defecto,new LinkedList<>(),caja);
                                entorno.Agregar(nombre+defecto, simbol);
                                NodoAST nodd=(NodoAST)aux_padre.valor;
                                if(nodd instanceof Panel_UI){
                                    Panel_UI aux_conte=(Panel_UI)aux_padre.valor;
                                    aux_conte.Agregar_Componente(caja);
                                    aux_padre.valor=aux_conte;
                                    entorno.Actualizar(aux_padre.getId(),aux_padre);
                                }else{
                                    System.out.println("ERROR SEMANTICO: EL COMPONENTE AREATEXTO NO PUEDE ESTAR FUERA DE UN CONTENEDOR");
                                }


                            }else{
                                System.out.println("ERROR SEMANTICO: NO EXISTE EL CONTENEDOR ASOCIADO A LA CAJA DE TEXTO");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: HACEN FALTA ELEMENTOS EN LA DEFINICION CAJA TEXTO");
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA CREACION DE UNA CAJA TEXTO");
                    }
                }else if(tipo==Type.PrimitiveType.NUMERICO){
                    try{
                        if(this.lista_parametros.size()==8){
                            Simbolo aux_padre=(Simbolo)entorno.Obtener(this.id_padre.toLowerCase());
                            if(aux_padre!=null){
                                String alto=((Aritmetica)this.lista_parametros.get(0)).getValue(entorno).toString().replaceAll("\"","");
                                String ancho=((Aritmetica)this.lista_parametros.get(1)).getValue(entorno).toString().replaceAll("\"","");
                                String maximo=((Aritmetica)this.lista_parametros.get(2)).getValue(entorno).toString().replaceAll("\"","");
                                String minimo=((Aritmetica)this.lista_parametros.get(3)).getValue(entorno).toString().replaceAll("\"","");
                                String x=((Aritmetica)this.lista_parametros.get(4)).getValue(entorno).toString().replaceAll("\"","");
                                String y=((Aritmetica)this.lista_parametros.get(5)).getValue(entorno).toString().replaceAll("\"","");
                                String defecto=((Aritmetica)this.lista_parametros.get(6)).getValue(entorno).toString().replaceAll("\"","");
                                String nombre=((Aritmetica)this.lista_parametros.get(7)).getValue(entorno).toString().replaceAll("\"","");
                                Numerico_UI numerico=new Numerico_UI(alto,ancho,maximo,minimo,x,y,defecto,nombre);
                                numerico.setId_padre(this.id_padre);
                                Simbolo simbol=new Simbolo(false,false,this.tipo,nombre,new LinkedList<>(),numerico);
                                entorno.Agregar(nombre, simbol);
                                NodoAST nodd=(NodoAST)aux_padre.valor;
                                if(nodd instanceof Panel_UI){
                                    Panel_UI aux_conte=(Panel_UI)aux_padre.valor;
                                    aux_conte.Agregar_Componente(numerico);
                                    aux_padre.valor=aux_conte;
                                    entorno.Actualizar(aux_padre.getId(),aux_padre);
                                }else{
                                    System.out.println("ERROR SEMANTICO: EL COMPONENTE AREATEXTO NO PUEDE ESTAR FUERA DE UN CONTENEDOR");
                                }

                            }else{
                                System.out.println("ERROR SEMANTICO: NO EXISTE EL CONTENEDOR ASOCIADO A LA CAJA DE TEXTO");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: HACEN FALTA ELEMENTOS EN LA DEFINICION CAJA TEXTO");
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA CREACION DE UN NUMERICO");
                    }
                }else if(tipo==Type.PrimitiveType.DESPLEGABLE){
                    try{
                        if(this.lista_parametros.size()==7){
                            Simbolo aux_padre=(Simbolo)entorno.Obtener(this.id_padre.toLowerCase());
                            if(aux_padre!=null){
                                String alto=((Aritmetica)this.lista_parametros.get(0)).getValue(entorno).toString().replaceAll("\"","");
                                String ancho=((Aritmetica)this.lista_parametros.get(1)).getValue(entorno).toString().replaceAll("\"","");
                                String lista=((Aritmetica)this.lista_parametros.get(2)).getValue(entorno).toString();
                                String x=((Aritmetica)this.lista_parametros.get(3)).getValue(entorno).toString().replaceAll("\"","");
                                String y=((Aritmetica)this.lista_parametros.get(4)).getValue(entorno).toString().replaceAll("\"","");
                                String defecto=((Aritmetica)this.lista_parametros.get(5)).getValue(entorno).toString().replaceAll("\"","");
                                String nombre=((Aritmetica)this.lista_parametros.get(6)).getValue(entorno).toString().replaceAll("\"","");
                                Desplegable_UI desplegable=new Desplegable_UI(alto, ancho, lista, x, y, defecto, nombre);
                                desplegable.setId_padre(this.id_padre);
                                Simbolo simbol=new Simbolo(false,false,this.tipo,nombre+defecto,new LinkedList<>(),desplegable);
                                entorno.Agregar(nombre+defecto, simbol);
                                NodoAST nodd=(NodoAST)aux_padre.valor;
                                if(nodd instanceof Panel_UI){
                                    Panel_UI aux_conte=(Panel_UI)aux_padre.valor;
                                    aux_conte.Agregar_Componente(desplegable);
                                    aux_padre.valor=aux_conte;
                                    entorno.Actualizar(aux_padre.getId(),aux_padre);
                                }else{
                                    System.out.println("ERROR SEMANTICO: EL COMPONENTE AREATEXTO NO PUEDE ESTAR FUERA DE UN CONTENEDOR");
                                }
                            }else{
                                System.out.println("ERROR SEMANTICO: NO EXISTE EL CONTENEDOR ASOCIADO A LA CAJA DE TEXTO");
                            }
                        }else{
                            System.out.println("ERROR SEMANTICO: HACEN FALTA ELEMENTOS EN LA DEFINICION CAJA TEXTO");
                        }
                    }catch(Exception e){
                        System.out.println("OCURRIO UN ERROR EN LA CREACION DE UN DESPLEGABLE");
                    }

                }else{
                    System.out.println("COMPONENTE NO ESPECIFICADO");
                }
            }else{
                System.out.println("ERROR SEMANTICO: YA EXISTE UNA VARIABLE CON EL NOMBRE "+this.id);
                System.out.println("asdasdjhaskdjhaskjdhaskjdhaskd putos"+this.tipo);
            }
        }
        return respuesta;
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
