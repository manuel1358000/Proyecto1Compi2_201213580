/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Componente;

import java.util.LinkedList;

/**
 *
 * @author anton
 */
public class EjecutarGXML {
    public static NodoGXML nodoRaiz;
    public boolean bandera=false;
    public EjecutarGXML(NodoGXML nodoRaiz){
        this.nodoRaiz=nodoRaiz;
    }
    
    public String Ejecutar(NodoGXML raiz,String arriba){
        String respuesta="";
        if(raiz.tipo_etiqueta.equals("importar")){
            //voy a leer el archivo y a generar el arbol
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),"");
            }
        }else if(raiz.tipo_etiqueta.equals("ventana")){
            String accioninicial=obtenerAccion(raiz.elementos,"accioninicial");
            String accionfinal=obtenerAccion(raiz.elementos,"accionfinal");
            String id=obtenerValor(raiz.elementos,"id");
            String pendiente="var ventana_"+id+"=crearVentana(";
            String color=obtenerValor(raiz.elementos,"color");
            String alto=obtenerValor(raiz.elementos,"alto");
            String ancho=obtenerValor(raiz.elementos,"ancho");
            String elementos="";
            if(color.equals("vacio")){
                elementos+="\"#FFFFFF\",";
            }else{
                elementos+="\"" + color + "\",";
            }
            if(alto.equals("vacio")){
                elementos+="100,";
            }else{
                elementos+=alto+",";
            }
            if(ancho.equals("vacio")){
                elementos+="100";
            }else{
                elementos+=alto+",";
            }
            pendiente+=elementos+");\n";
            respuesta+=pendiente;
            VerificarId(raiz.nodos);
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),id);
            }
            
            if(accioninicial.equals("")){
            }else{
                if(accioninicial.equals("vacio")){
                    accioninicial="";
                }
                respuesta+="\nventana_"+id+"=alcargar("+accioninicial+");\n";
            }
            if(accionfinal.equals("")){
            }else{
                if(accionfinal.equals("vacio")){
                    accionfinal="";
                }
                respuesta+="\nventana_"+id+"=alcerrar("+accionfinal+");\n";
            }
            
        }else if(raiz.tipo_etiqueta.equals("contenedor")){
            String id=obtenerValor(raiz.elementos,"id");
            String x=obtenerValor(raiz.elementos,"x");
            String y=obtenerValor(raiz.elementos,"y");
            String alto=obtenerValor(raiz.elementos,"alto");
            String ancho=obtenerValor(raiz.elementos,"ancho");
            String color=obtenerValor(raiz.elementos,"color");
            String borde=obtenerValor(raiz.elementos,"borde");
            String elementos="";
            String pendiente="var "+id+"_"+arriba+"=ventana_"+arriba+".crearContenedor(";
            
            if(alto.equals("vacio")){
                elementos+="500,";
            }else{
                elementos+=alto+",";
            }
            if(ancho.equals("vacio")){
                elementos+="500,";
            }else{
                elementos+=ancho+",";
            }
            if(color.equals("vacio")){
                elementos+="\"#ffffff\",";
            }else{
                elementos+="\""+color+"\",";
            }
            if(borde.equals("vacio")){
                elementos+="falso,";
            }else{
                elementos+=borde+",";
            }
            elementos+=x+","+y;
            pendiente+=elementos+");\n";
            
            VerificarNombre(raiz.nodos);
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),id+"_"+arriba);
            }
            respuesta=pendiente+respuesta;
            
        }else if(raiz.tipo_etiqueta.equals("texto")){
            String nombre=obtenerValor(raiz.elementos,"nombre");
            String fuente=obtenerValor(raiz.elementos,"fuente");
            String tam=obtenerValor(raiz.elementos,"tam");
            String color=obtenerValor(raiz.elementos,"color");
            String x=obtenerValor(raiz.elementos,"x");
            String y=obtenerValor(raiz.elementos,"y");
            String negrita=obtenerValor(raiz.elementos,"negrita");
            String cursiva=obtenerValor(raiz.elementos,"cursiva");
            String valor=raiz.valor.toString();
            
            String pendiente=arriba+".crearTexto(";
            if(fuente.equals("vacio")){
                pendiente+="\"Arial\",";
            }else{
                pendiente+="\""+fuente+"\",";
            }
            if(tam.equals("vacio")){
                pendiente+="14,";
            }else{
                pendiente+=tam+",";
            }
            if(color.equals("vacio")){
                pendiente+="\"#000000\",";
            }else{
                pendiente+=color+",";
            }
            if(x.equals("vacio")){
                pendiente+=fuente+",";
            }else{
                pendiente+=x+",";
            }
            if(y.equals("vacio")){
                pendiente+=fuente+",";
            }else{
                pendiente+=y+",";
            }
            if(negrita.equals("vacio")){
                pendiente+="falso,";
            }else{
                pendiente+=negrita+",";
            }
            if(cursiva.equals("vacio")){
                pendiente+="falso,";
            }else{
                pendiente+=cursiva+",";
            }
            if(valor.equals("vacio")){
                pendiente+="\"\"";
            }else{
                pendiente+="\""+valor+"\"";
            }
            pendiente+=");\n";
            respuesta+=pendiente;
        }else if(raiz.tipo_etiqueta.toLowerCase().equals("defecto")){
            respuesta+=raiz.valor.toString();
        }else if(raiz.tipo_etiqueta.equals("control")){
            String tipo=obtenerValor(raiz.elementos,"tipo");
            String nombre=obtenerValor(raiz.elementos,"nombre");
            String x=obtenerValor(raiz.elementos,"x");
            String y=obtenerValor(raiz.elementos,"y");
            String alto=obtenerValor(raiz.elementos,"alto");
            String ancho=obtenerValor(raiz.elementos,"ancho");
            String fuente=obtenerValor(raiz.elementos,"fuente");
            String tam=obtenerValor(raiz.elementos,"tam");
            String color=obtenerValor(raiz.elementos,"color");
            String negrita=obtenerValor(raiz.elementos,"negrita");
            String cursiva=obtenerValor(raiz.elementos,"cursiva");
            String maximo=obtenerValor(raiz.elementos,"maximo");
            String minimo=obtenerValor(raiz.elementos,"minimo");
            String accion=obtenerAccion(raiz.elementos,"accion");
            String valor="";
            VerificarNombre(raiz.nodos);
            for(int i=0;i<raiz.nodos.size();i++){   
                valor=Ejecutar(raiz.nodos.get(i),"");
            }
            
            String pendiente="";
            switch(tipo){
                case "texto":{
                    pendiente+=arriba+".crearCajaTexto(";
                    //fuente,tama;o,color,x,y,negrita,cursiva,valor
                    if(alto.equals("vacio")){
                        pendiente+="100,";
                    }else{
                        pendiente+=alto+",";
                    }
                    if(ancho.equals("vacio")){
                        pendiente+="100,";
                    }else{
                        pendiente+=ancho+",";
                    }
                    if(fuente.equals("vacio")){
                        pendiente+="\"Arial\",";
                    }else{
                        pendiente+="\""+fuente+"\",";
                    }
                    if(tam.equals("vacio")){
                        pendiente+="14,";
                    }else{
                        pendiente+=tam+",";
                    }
                    if(color.equals("vacio")){
                        pendiente+="\"#ffffff\",";
                    }else{
                        pendiente+="\""+color+"\",";
                    }
                    if(x.equals("vacio")){
                        pendiente+="0,";
                    }else{
                        pendiente+=x+",";
                    }
                    if(y.equals("vacio")){
                        pendiente+="0,";
                    }else{
                        pendiente+=y+",";
                    }
                    if(negrita.equals("vacio")){
                        pendiente+="falso,";
                    }else{
                        pendiente+=negrita+",";
                    }
                    if(cursiva.equals("vacio")){
                        pendiente+="falso,";
                    }else{
                        pendiente+=cursiva+",";
                    }
                    if(valor.equals("")){
                        pendiente+="\"\"";
                    }else{
                        pendiente+="\""+valor+"\",";
                    }
                    if(nombre.equals("vacio")){
                        System.out.println("El controlador no tiene nombre");
                        pendiente+="\"\"";
                    }else{
                        pendiente+="\""+nombre+"\"";
                    }
                    pendiente+=");\n";
                    respuesta+=pendiente;
                    break;
                }
                case "textoarea":{
                    pendiente+=arriba+".crearAreaTexto(";
                    if(alto.equals("vacio")){
                        pendiente+="100,";
                    }else{
                        pendiente+=alto+",";
                    }
                    if(ancho.equals("vacio")){
                        pendiente+="100,";
                    }else{
                        pendiente+=ancho+",";
                    }
                    if(fuente.equals("vacio")){
                        pendiente+="\"Arial\",";
                    }else{
                        pendiente+="\""+fuente+"\",";
                    }
                    if(tam.equals("vacio")){
                        pendiente+="14,";
                    }else{
                        pendiente+=tam+",";
                    }
                    if(color.equals("vacio")){
                        pendiente+="\"#ffffff\",";
                    }else{
                        pendiente+="\""+color+"\",";
                    }
                    if(x.equals("vacio")){
                        pendiente+="0,";
                    }else{
                        pendiente+=x+",";
                    }
                    if(y.equals("vacio")){
                        pendiente+="0,";
                    }else{
                        pendiente+=y+",";
                    }
                    if(negrita.equals("vacio")){
                        pendiente+="falso,";
                    }else{
                        pendiente+=negrita+",";
                    }
                    if(cursiva.equals("vacio")){
                        pendiente+="falso,";
                    }else{
                        pendiente+=cursiva+",";
                    }
                    if(valor.equals("")){
                        pendiente+="\"\"";
                    }else{
                        pendiente+="\""+valor+"\",";
                    }
                    if(nombre.equals("vacio")){
                        System.out.println("El controlador no tiene nombre");
                        pendiente+="\"\"";
                    }else{
                        pendiente+="\""+nombre+"\"";
                    }
                    pendiente+=");\n";
                    respuesta+=pendiente;
                    break;
                }
                case "numerico":{
                    pendiente+=arriba+".crearControlNumerico(";
                    if(alto.equals("vacio")){
                        pendiente+="100,";
                    }else{
                        pendiente+=alto+",";
                    }
                    if(ancho.equals("vacio")){
                        pendiente+="100,";
                    }else{
                        pendiente+=ancho+",";
                    }
                    if(maximo.equals("vacio")){
                        pendiente+="100,";
                    }else{
                        pendiente+=maximo+",";
                    }
                    if(minimo.equals("vacio")){
                        pendiente+="0,";
                    }else{
                        pendiente+=minimo+",";
                    }
                    if(x.equals("vacio")){
                        pendiente+="0,";
                    }else{
                        pendiente+=x+",";
                    }
                    if(y.equals("vacio")){
                        pendiente+="0,";
                    }else{
                        pendiente+=y+",";
                    }    
                    if(valor.equals("")){
                        pendiente+="\"0\",";
                    }else{
                        try{
                            Integer.parseInt(valor.replaceAll(" ", ""));
                            pendiente+=valor.replaceAll(" ","")+",";
                        }catch(Exception e){
                            System.out.println("Error semantico: El valor por defecto no es un numero");
                        }
                    }
                    if(nombre.equals("vacio")){
                        System.out.println("El controlador no tiene nombre");
                        pendiente+="\"\"";
                    }else{
                        pendiente+="\""+nombre+"\"";
                    }     
                    pendiente+=");\n";
                    respuesta+=pendiente;
                    break;
                }
                case "desplegable":{
                    valor="";
                    pendiente+=arriba+".crearDesplegable(";
                    String expresion="[";
                    for(int i=0;i<raiz.nodos.size();i++){   
                        if(raiz.nodos.get(i).tipo_etiqueta.toLowerCase().equals("listadatos")){
                            expresion+=Ejecutar(raiz.nodos.get(i),"");
                        }
                    }
                    expresion+="]";
                    if(alto.equals("vacio")){
                        pendiente+="100,";
                    }else{
                        pendiente+=alto+",";
                    }
                    if(ancho.equals("vacio")){
                        pendiente+="100,";
                    }else{
                        pendiente+=ancho+",";
                    }
                    if(x.equals("vacio")){
                        pendiente+="0,";
                    }else{
                        pendiente+=x+",";
                    }
                    if(y.equals("vacio")){
                        pendiente+="0,";
                    }else{
                        pendiente+=y+",";
                    }
                    pendiente+=expresion+",";
                    for(int i=0;i<raiz.nodos.size();i++){   
                        if(raiz.nodos.get(i).tipo_etiqueta.toLowerCase().equals("defecto")){
                            valor+=Ejecutar(raiz.nodos.get(i),"");
                        }
                    }
                    pendiente+="\""+valor+"\",";
                    if(nombre.equals("vacio")){
                        pendiente+="\"\"";
                    }else{
                        pendiente+="\""+nombre+"\"";
                    }
                    pendiente+=");\n";
                    respuesta+=pendiente;
                    break;
                }
                default:
                    System.out.println("ERROR SEMANTICO: el control solo puede tener tipo texto, textoarea, numerico, desplegable. El tipo que se quiere asignar es "+tipo);
                    break;
            
            }
            
        }else if(raiz.tipo_etiqueta.equals("dato")){
            respuesta+=raiz.valor;
        }else if(raiz.tipo_etiqueta.equals("listadatos")){
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=",\""+Ejecutar(raiz.nodos.get(i),"")+"\"";
            }
            respuesta=respuesta.replaceFirst(",","");
        }else if(raiz.tipo_etiqueta.equals("multimedia")){
            String path=obtenerValor(raiz.elementos,"path");
            String tipo=obtenerValor(raiz.elementos,"tipo");
            String nombre=obtenerValor(raiz.elementos,"nombre");
            String x=obtenerValor(raiz.elementos,"x");
            String y=obtenerValor(raiz.elementos,"y");
            String alto=obtenerValor(raiz.elementos,"alto");
            String ancho=obtenerValor(raiz.elementos,"ancho");
            String auto=obtenerValor(raiz.elementos,"auto_reproduccion");
            String pendiente="";
            switch(tipo.toLowerCase()){
                case "musica":{
                    pendiente+=arriba+".crearReproductor(";
                    //ruta x y auto alto ancho
                    if(path.equals("vacio")){
                        System.out.println("Error: Hace falta el atributo path de la etiqueta "+nombre);
                    }else{
                        if(verificarExtension(path,"musica")){
                            pendiente+="\""+path+"\",";
                            if(x.equals("vacio")){
                                pendiente+="10,";
                            }else{
                                pendiente+=x+",";
                            }
                            if(y.equals("vacio")){
                                pendiente+="10,";
                            }else{
                                pendiente+=y+",";
                            }
                            if(auto.equals("vacio")){
                                pendiente+="falso,";
                            }else{
                                pendiente+=auto+",";
                            }
                            if(alto.equals("vacio")){
                                pendiente+="100,";
                            }else{
                                pendiente+=alto+",";
                            }
                            if(ancho.equals("vacio")){
                                pendiente+="200,";
                            }else{
                                pendiente+=ancho+",";
                            }
                            pendiente+=");\n";
                            respuesta+=pendiente;
                        }else{
                            System.out.println("Error formato no aceptado para audio, el path incorrecto es "+path);
                        }
                        
                    }
                    break;
                }
                case "video":{
                    pendiente+=arriba+".crearVideo(";
                    //ruta x y auto alto ancho
                    if(path.equals("vacio")){
                        System.out.println("Error: Hace falta el atributo path de la etiqueta "+nombre);
                    }else{
                        if(verificarExtension(path,"video")){
                             pendiente+="\""+path+"\",";
                            if(x.equals("vacio")){
                                pendiente+="10,";
                            }else{
                                pendiente+=x+",";
                            }
                            if(y.equals("vacio")){
                                pendiente+="10,";
                            }else{
                                pendiente+=y+",";
                            }
                            if(auto.equals("vacio")){
                                pendiente+="falso,";
                            }else{
                                pendiente+=auto+",";
                            }
                            if(alto.equals("vacio")){
                                pendiente+="100,";
                            }else{
                                pendiente+=alto+",";
                            }
                            if(ancho.equals("vacio")){
                                pendiente+="200,";
                            }else{
                                pendiente+=ancho+",";
                            }
                            pendiente+=");\n";
                            respuesta+=pendiente;
                        }else{
                            System.out.println("Error formato no aceptado para videos, el path incorrecto es "+path);
                        }
                    }
                    break;
                }
                case "imagen":{
                    pendiente+=arriba+".crearImagen(";
                    //ruta x y auto alto ancho
                    if(path.equals("vacio")){
                        System.out.println("Error: Hace falta el atributo path de la etiqueta "+nombre);
                    }else{
                        if(verificarExtension(path,"imagen")){
                            pendiente+="\""+path+"\",";
                            if(x.equals("vacio")){
                                pendiente+="10,";
                            }else{
                                pendiente+=x+",";
                            }
                            if(y.equals("vacio")){
                                pendiente+="10,";
                            }else{
                                pendiente+=y+",";
                            }
                            if(auto.equals("vacio")){
                                pendiente+="falso,";
                            }else{
                                pendiente+=auto+",";
                            }
                            if(alto.equals("vacio")){
                                pendiente+="100,";
                            }else{
                                pendiente+=alto+",";
                            }
                            if(ancho.equals("vacio")){
                                pendiente+="200,";
                            }else{
                                pendiente+=ancho+",";
                            }
                            pendiente+=");\n";
                            respuesta+=pendiente;
                        }else{
                            System.out.println("Error formato no aceptado para imagenes, el path incorrecto es "+path);
                        }
                    }
                        
                    break;
                }
                default:{
                    break;
                }
            }
        }else if(raiz.tipo_etiqueta.equals("boton")){
            String accion=obtenerAccion(raiz.elementos,"accion");
            String nombre=obtenerValor(raiz.elementos,"nombre");
            String fuente=obtenerValor(raiz.elementos,"fuente");
            String tam=obtenerValor(raiz.elementos,"tam");
            String color=obtenerValor(raiz.elementos,"color");
            String x=obtenerValor(raiz.elementos,"x");
            String y=obtenerValor(raiz.elementos,"y");
            String referencia=obtenerValor(raiz.elementos,"referencia");
            String valor=raiz.valor.toString();
            if(valor.toLowerCase().equals("etiqueta")){
                valor="";
            }
            String alto=obtenerValor(raiz.elementos,"alto");  
            String ancho=obtenerValor(raiz.elementos,"ancho");    
            String pendiente="var "+nombre+"_"+arriba+"="+arriba+".crearboton(";
            String fin="";
            if(fuente.equals("vacio")){
                pendiente+="\"ARIAL\",";
            }else{
                pendiente+="\""+fuente+"\",";
            }
            if(tam.equals("vacio")){
                pendiente+="5,";
            }else{
                pendiente+=tam+",";
            }
            if(color.equals("vacio")){
                pendiente+="\"#ffffff\",";
            }else{
                pendiente+=color+",";
            }
            if(x.equals("vacio")){
                pendiente+="100,";
            }else{
                pendiente+=x+",";
            }
            if(y.equals("vacio")){
                pendiente+="100,";
            }else{
                pendiente+=y+",";
            }
            if(referencia.equals("vacio")){
                pendiente+="\"\",";
            }else{
                pendiente+="cargar_"+referencia+"(),";
                fin+=nombre+"_"+arriba+".alclic(cargar_"+referencia+"());\n";
                fin+="\nfuncion cargar_"+referencia+"(){\n";
                fin+="ven_"+referencia+".alcargar();\n";
                fin+="}\n";
            }
            if(valor.equals("vacio")){
                pendiente+="\"\",";
            }else{
                pendiente+="\""+valor+"\",";
                
            }
            if(alto.equals("vacio")){
                pendiente+="50,";
            }else{
                pendiente+=alto+",";
            }
            if(ancho.equals("vacio")){
                pendiente+="50";
            }else{
                pendiente+=ancho+"";
            }
            pendiente+=");\n";
            
            VerificarNombre(raiz.nodos);
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),nombre+"_"+arriba);
            }
            if(accion.equals("")){
            }else{
                if(accion.equals("vacio")){
                    accion="";
                }
                respuesta+="\n"+nombre+"_"+arriba+".alclic("+accion+");\n";
            }
            respuesta=pendiente+respuesta+fin;
        }else if(raiz.tipo_etiqueta.equals("enviar")){
            String accion=obtenerAccion(raiz.elementos,"accion");
            String nombre=obtenerValor(raiz.elementos,"nombre");
            String fuente=obtenerValor(raiz.elementos,"fuente");
            String tam=obtenerValor(raiz.elementos,"tam");
            String color=obtenerValor(raiz.elementos,"color");
            String x=obtenerValor(raiz.elementos,"x");
            String y=obtenerValor(raiz.elementos,"y");
            String referencia=obtenerValor(raiz.elementos,"referencia");
            String valor=raiz.valor.toString();
            String llamada="";
            if(valor.toLowerCase().equals("etiqueta")){
                valor="";
            }
            String alto=obtenerValor(raiz.elementos,"alto");  
            String ancho=obtenerValor(raiz.elementos,"ancho");    
            String pendiente="var "+nombre+"_"+arriba+"="+arriba+".crearboton(";
            String fin="";
            if(fuente.equals("vacio")){
                pendiente+="\"ARIAL\",";
            }else{
                pendiente+="\""+fuente+"\",";
            }
            if(tam.equals("vacio")){
                pendiente+="5,";
            }else{
                pendiente+=tam+",";
            }
            if(color.equals("vacio")){
                pendiente+="\"#ffffff\",";
            }else{
                pendiente+=color+",";
            }
            if(x.equals("vacio")){
                pendiente+="100,";
            }else{
                pendiente+=x+",";
            }
            if(y.equals("vacio")){
                pendiente+="100,";
            }else{
                pendiente+=y+",";
            }
            fin+=nombre+"_"+arriba+".alclic(guardarformulario());\n";
            if(referencia.equals("vacio")){
                pendiente+="\"\",";
            }else{
                pendiente+="cargar_"+referencia+"(),";
                llamada+=nombre+"_"+arriba+".alclic(cargar_"+referencia+"());\n";
                fin+="\nfuncion cargar_"+referencia+"(){\n";
                fin+="ven_"+referencia+".alcargar();\n";
                fin+="}\n";
            }
            if(valor.equals("vacio")){
                pendiente+="\"\",";
            }else{
                pendiente+="\""+valor+"\",";
                
            }
            if(alto.equals("vacio")){
                pendiente+="50,";
            }else{
                pendiente+=alto+",";
            }
            if(ancho.equals("vacio")){
                pendiente+="50";
            }else{
                pendiente+=ancho+"";
            }
            pendiente+=");\n";
            VerificarNombre(raiz.nodos);
            for(int i=0;i<raiz.nodos.size();i++){   
                respuesta+=Ejecutar(raiz.nodos.get(i),nombre+"_"+arriba);
            }
            
            respuesta=pendiente+respuesta;
            respuesta+=fin;
            if(accion.equals("")){
            }else{
                if(accion.equals("vacio")){
                    accion="";
                }
                respuesta+="\n"+nombre+"_"+arriba+".alclic("+accion+");\n";
            }
            
            
            respuesta+=llamada;
        }else{
            VerificarId(raiz.nodos);
            for(int i=0;i<raiz.nodos.size();i++){
                respuesta+=Ejecutar(raiz.nodos.get(i),arriba);
            }
            
        }
        return respuesta;
    }
    public boolean verificarExtension(String path,String tipo){
        boolean respuesta=false;
        String [] separados=path.toString().split("\\.");
        if(separados.length==2){
            switch(tipo.toLowerCase()){
                case "musica":{
                    if(separados[1].toLowerCase().equals("wav")||separados[1].toLowerCase().equals("mp3")){
                        respuesta=true;
                    }
                    break;
                }
                case "video":{
                    if(separados[1].toLowerCase().equals("avi")||separados[1].toLowerCase().equals("mp4")||separados[1].toLowerCase().equals("mepg")||separados[1].toLowerCase().equals("rm")||separados[1].toLowerCase().equals("flv")){
                        respuesta=true;
                    }
                    break;
                }
                case "imagen":{
                    if(separados[1].toLowerCase().equals("bmp")||separados[1].toLowerCase().equals("jpg")||separados[1].toLowerCase().equals("tpg")||separados[1].toLowerCase().equals("png")){
                        respuesta=true;
                    }
                    break;
                }
                default:{
                
                    break;
                }    
            }
        }else{
            System.out.println("paso aqui");
        }
        return respuesta;
    }
    public String obtenerValor(LinkedList<NodoElemento> elemento,String id){
        String respuesta="vacio";
        for(int i=0;i<elemento.size();i++){
            if(elemento.get(i).nombre.equals(id)){
                if(elemento.get(i).valor.toString().equals("")){
                    respuesta="";
                }else{
                    respuesta=elemento.get(i).valor.toString();
                }
            }
        }
        return respuesta;
    }
    public String obtenerAccion(LinkedList<NodoElemento> elemento,String id){
        String respuesta="";
        for(int i=0;i<elemento.size();i++){
            if(elemento.get(i).nombre.equals(id)){
                respuesta=elemento.get(i).valor.toString();
            }
        }
        return respuesta;
    }
    
    //este metodo elimina los nodos que tiene el id repetido, asi se realiza una generacion mas limpia del codigo Funcional Script
    public void VerificarId(LinkedList<NodoGXML>arbol){
        for(int i=0;i<arbol.size();i++){
            for(int f=0;f<arbol.size();f++){
                if(arbol.get(i).elemento_id.equals(arbol.get(f).elemento_id)&&i!=f&&!arbol.get(i).elemento_id.equals("")){
                    System.out.println("Error Sintactico: ID repetidos, se conservo unicamente el primer elemento con el id repetido " + arbol.get(f).elemento_id);
                    arbol.remove(f);
                }
            }
        }
    }
    public void VerificarNombre(LinkedList<NodoGXML>arbol){
        for(int i=0;i<arbol.size();i++){
            for(int f=0;f<arbol.size();f++){
                if(arbol.get(i).elemento_id.equals(arbol.get(f).elemento_id)&&i!=f&&!arbol.get(i).elemento_id.equals("")){
                    System.out.println("Error Sintactico: ID repetidos, se conservo unicamente el primer elemento con el id repetido " + arbol.get(f).elemento_id);
                    arbol.remove(f);
                }
            }
        }
    }
}
