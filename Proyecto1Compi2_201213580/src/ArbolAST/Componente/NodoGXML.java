/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Componente;

import ArbolAST.Componente.NodoElemento;
import Auxiliares.Errores;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;
/**
 *
 * @author anton
 */
public class NodoGXML {
    public int index;//sirve como identificador del nodo en el arbol
    public String tipo_etiqueta;//este es el tipo de etiqueta que se tiene, el nombre de la etiqueta ventana importar etc
    public Object valor;//guarda el valor que tiene dentro una etiqueta si fuera necesario, como en importar
    public String id;//identificador del nodo o nombre
    public String elemento_id;
    //definicion de los elementos de las etiquetas
    public LinkedList<NodoElemento>elementos;
    public LinkedList<NodoGXML>nodos;
    public boolean general;
    
    
    
    public NodoGXML() {
        this.index = -2;
        this.tipo_etiqueta ="";
        this.valor = "";
        this.id="";
        this.elemento_id="";
        this.elementos=new LinkedList<NodoElemento>();
        this.nodos = new LinkedList<NodoGXML>();
        this.general=false;
    }
    public NodoGXML(boolean general) {
        this.index = -2;
        this.tipo_etiqueta ="";
        this.valor = "";
        this.id="";
        this.elemento_id="";
        this.elementos=new LinkedList<NodoElemento>();
        this.nodos = new LinkedList<NodoGXML>();
        this.general=general;
    }

    public NodoGXML(int index, String tipo_etiqueta, String id, LinkedList<NodoElemento> elementos) {
        this.index = index;
        this.tipo_etiqueta = tipo_etiqueta;
        this.id = id;
        this.elemento_id="";
        this.elementos = elementos;
        this.nodos=new LinkedList<NodoGXML>();
        this.valor="";
    }
    
    public void AgregarNodos(LinkedList<NodoGXML>entrada){
        for(int i=0;i<entrada.size();i++){
            this.nodos.add(entrada.get(i));
        }
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTipo_etiqueta() {
        return tipo_etiqueta;
    }

    public void setTipo_etiqueta(String tipo_etiqueta) {
        this.tipo_etiqueta = tipo_etiqueta;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public LinkedList<NodoElemento> getElementos() {
        return elementos;
    }

    public void setElementos(LinkedList<NodoElemento> elementos) {
        this.elementos = elementos;
    }

    public LinkedList<NodoGXML> getNodos() {
        return nodos;
    }

    public void setNodos(LinkedList<NodoGXML> nodos) {
        this.nodos = nodos;
    }
    public String elementosVentana(LinkedList<NodoElemento>entrada){
        String respuesta="";
        try{
            int id=0;
            int tipo=0;
            for(int i=0;i<entrada.size();i++){
                if(entrada.get(i).getNombre().equals("id")){
                    id++;
                }else if(entrada.get(i).getNombre().equals("tipo")){
                    tipo++;
                }
            }
            if(id!=1||tipo!=1){
                Errores error=new Errores("SINTACTICO","El numero de elementos obligatorios de la ETIQUETA VENTANA son incorrectos, porfavor verificar si hace falta o sobra alguno",0,0);
                Proyecto1Compi2_201213580.errores_gxml.add(error);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR FUNCION ELEMENTOS VENTANA");
        }
        
        return respuesta;
    }
    public String obtenerID(){
        String respuesta="";
        try{
            for(int i=0;i<this.elementos.size();i++){
                if(this.elementos.get(i).nombre.equals("id")){
                    respuesta=this.elementos.get(i).valor.toString();
                    break;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR FUNCION OBTENER ID");
        }
        return respuesta;
    }
    public String obtenerNombre(){
        String respuesta="";
        try{
            for(int i=0;i<this.elementos.size();i++){
                if(this.elementos.get(i).nombre.equals("nombre")){
                    respuesta=this.elementos.get(i).valor.toString();
                    break;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR FUNCION OBTENER NOMBRE");
        }
        return respuesta;
    }
    public String elementosContenedor(LinkedList<NodoElemento>entrada){
        String respuesta="";
        try{
            int id=0;
            int x=0;
            int y=0;
            for(int i=0;i<entrada.size();i++){
                if(entrada.get(i).getNombre().equals("id")){
                    id++;
                }else if(entrada.get(i).getNombre().equals("x")){
                    x++;
                }else if(entrada.get(i).getNombre().equals("y")){
                    y++;
                }
            }
            if(id!=1||x!=1|y!=1){
                Errores error=new Errores("SINTACTICO","El numero de elementos obligatorios de la ETIQUETA CONTENEDOR son incorrectos, porfavor verificar si hace falta o sobra alguno",0,0);
                Proyecto1Compi2_201213580.errores_gxml.add(error);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR FUNCION ELEMENTOS CONTENEDOR");
        }
        return respuesta;
    }
    public String elementosTexto(LinkedList<NodoElemento>entrada){
        String respuesta="";
        try{
            int nombre=0;
            int x=0;
            int y=0;
            for(int i=0;i<entrada.size();i++){
                if(entrada.get(i).getNombre().equals("nombre")){
                    nombre++;
                }else if(entrada.get(i).getNombre().equals("x")){
                    x++;
                }else if(entrada.get(i).getNombre().equals("y")){
                    y++;
                }
            }
            if(nombre!=1||x!=1|y!=1){
                Errores error=new Errores("SINTACTICO","El numero de elementos obligatorios de la ETIQUETA TEXTO son incorrectos, porfavor verificar si hace falta o sobra alguno",0,0);
                Proyecto1Compi2_201213580.errores_gxml.add(error);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR FUNCION ELEMENTOS TEXTO");
        }
        return respuesta;
    }
    public String elementosControl(LinkedList<NodoElemento>entrada){
        String respuesta="";
        try{
            int tipo=0;
            String tipo_="";
            int nombre=0;
            int x=0;
            int y=0;
            int fuente=0;
            int tam=0;
            int color=0;
            int negrita=0;
            int cursiva=0;
            int maximo=0;
            int minimo=0;
            for(int i=0;i<entrada.size();i++){
                if(entrada.get(i).getNombre().equals("tipo")){
                    tipo++;
                    tipo_=entrada.get(i).valor.toString();
                }else if(entrada.get(i).getNombre().equals("nombre")){
                    nombre++;
                }else if(entrada.get(i).getNombre().equals("x")){
                    x++;
                }else if(entrada.get(i).getNombre().equals("y")){
                    y++;
                }else if(entrada.get(i).getNombre().equals("fuente")){
                    fuente++;
                }else if(entrada.get(i).getNombre().equals("tam")){
                    tam++;
                }else if(entrada.get(i).getNombre().equals("color")){
                    color++;
                }else if(entrada.get(i).getNombre().equals("negrita")){
                    negrita++;
                }else if(entrada.get(i).getNombre().equals("cursiva")){
                    cursiva++;
                }else if(entrada.get(i).getNombre().equals("maximo")){
                    maximo++;
                }else if(entrada.get(i).getNombre().equals("minimo")){
                    minimo++;
                }
            }
            if(tipo!=1|nombre!=1||x!=1|y!=1){
                Errores error=new Errores("SINTACTICO","El numero de elementos obligatorios de la ETIQUETA CONTROL son incorrectos, porfavor verificar si hace falta o sobra alguno",0,0);
                Proyecto1Compi2_201213580.errores_gxml.add(error);
            }else{
                if(fuente==1|tam==1|color==1|negrita==1|cursiva==1){
                    if(tipo_.equals("texto")|tipo_.equals("textoarea")){
                    }else{
                        Errores error=new Errores("SINTACTICO","Se agregaron elementos incorrector al tipo " + tipo_ + " Se recomienda eliminar elementos",0,0);
                        Proyecto1Compi2_201213580.errores_gxml.add(error);
                    }
                }else if(maximo==1|minimo==1){
                    if(tipo_.equals("numerico")){
                    }else{
                        Errores error=new Errores("SINTACTICO","Se agregaron elementos incorrector al tipo " + tipo_ + " Se recomienda eliminar elementos",0,0);
                        Proyecto1Compi2_201213580.errores_gxml.add(error);
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR FUNCION ELEMENTOS CONTROL");
        }
        return respuesta;
    }
    public String elementosEnviar(LinkedList<NodoElemento>entrada){
        String respuesta="";
        try{
            int nombre=0;
            int x=0;
            int y=0;
            for(int i=0;i<entrada.size();i++){
                if(entrada.get(i).getNombre().equals("nombre")){
                    nombre++;
                }else if(entrada.get(i).getNombre().equals("x")){
                    x++;
                }else if(entrada.get(i).getNombre().equals("y")){
                    y++;
                }
            }
            if(nombre!=1||x!=1|y!=1){
                Errores error=new Errores("SINTACTICO","El numero de elementos obligatorios de la ETIQUETA ENVIAR son incorrectos, porfavor verificar si hace falta o sobra alguno",0,0);
                Proyecto1Compi2_201213580.errores_gxml.add(error);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR FUNCION ELEMENTOS ENVIAR");
        }
        return respuesta;
    }
    public String elementosBoton(LinkedList<NodoElemento>entrada,boolean bandera){
        String respuesta="";
        try{
            int nombre=0;
            int x=0;
            int y=0;
            for(int i=0;i<entrada.size();i++){
                if(entrada.get(i).getNombre().equals("nombre")){
                    nombre++;
                }else if(entrada.get(i).getNombre().equals("x")){
                    x++;
                }else if(entrada.get(i).getNombre().equals("y")){
                    y++;
                }
            }
            if(bandera){
                if(nombre!=1){
                Errores error=new Errores("SINTACTICO","El numero de elementos obligatorios de la ETIQUETA BOTON son incorrectos, porfavor verificar si hace falta o sobra alguno",0,0);
                Proyecto1Compi2_201213580.errores_gxml.add(error);
                }
            }else{
                if(nombre!=1||x!=1|y!=1){
                Errores error=new Errores("SINTACTICO","",0,0);
                Proyecto1Compi2_201213580.errores_gxml.add(error);
                    respuesta="Error Sintactico: El numero de elementos obligatorios de la ETIQUETA BOTON son incorrectos, porfavor verificar si hace falta o sobra alguno";
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR FUNCION ELEMENTOS BOTON");
        }
        return respuesta;
    }
    public String elementosMultimedia(LinkedList<NodoElemento>entrada){
        String respuesta="";
        try{
            int nombre=0;
            int path=0;
            int tipo=0;
            int x=0;
            int y=0;
            for(int i=0;i<entrada.size();i++){
                if(entrada.get(i).getNombre().equals("path")){
                    path++;
                }else if(entrada.get(i).getNombre().equals("tipo")){
                    tipo++;
                }else if(entrada.get(i).getNombre().equals("nombre")){
                    nombre++;
                }else if(entrada.get(i).getNombre().equals("x")){
                    x++;
                }else if(entrada.get(i).getNombre().equals("y")){
                    y++;
                }
            }
            if(path!=1|tipo!=1|nombre!=1||x!=1|y!=1){
                Errores error=new Errores("SINTACTICO","El numero de elementos obligatorios de la ETIQUETA MULTIMEDIA son incorrectos, porfavor verificar si hace falta o sobra alguno",0,0);
                Proyecto1Compi2_201213580.errores_gxml.add(error);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR FUNCION ELEMENTOS MULTIMEDIA");
        }
        return respuesta;
    }
}