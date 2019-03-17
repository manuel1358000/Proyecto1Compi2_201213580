/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Expresiones.Llamada_Funcion;
import Auxiliares.Errores;
import ElementosUI.Area_UI;
import ElementosUI.Boton_UI;
import ElementosUI.Caja_UI;
import ElementosUI.Desplegable_UI;
import ElementosUI.Numerico_UI;
import ElementosUI.Panel_UI;
import ElementosUI.Ventana_UI;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import proyecto1compi2_201213580.Principal;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class Eventos_Botones implements Instruccion {
    String id;
    Expresion llamada;
    String tipo;
    int linea;
    int columna;
    public Eventos_Botones(String id,Expresion llamada,int linea,int columna){
        this.id=id;
        this.llamada=llamada;
        this.tipo="";
        this.linea=linea;
        this.columna=columna;
    }
    public Eventos_Botones(String id,String tipo,int linea,int columna){
        this.id=id;
        this.llamada=null;
        this.tipo=tipo;
        this.linea=linea;
        this.columna=columna;
    }
    public void EscribirArchivo(String nombre, String contenido){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter(nombre);
            pw = new PrintWriter(fichero);
            pw.println(contenido);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    public String LeerArchivo(String path){
        String respuesta="";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File (path);
            if(archivo.exists()){
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);
                String linea;
                while((linea=br.readLine())!=null){
                    respuesta+=linea+"\n";
                }
            }
            
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion al momento de leer gdato");
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                fr.close();     
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
        respuesta=respuesta.replace("<lista>","");
        respuesta=respuesta.replace("</lista>","");
        return respuesta;
    }
    
    @Override
    public Object execute(Entorno entorno) {
        try{
            Simbolo sim=(Simbolo)entorno.Obtener(id.toLowerCase());
            String respuesta="";
            if(sim!=null){
                if(tipo.equals("crear")){
                    if(llamada!=null){
                        Ventana_UI ventana=(Ventana_UI)sim.valor;
                        respuesta=LeerArchivo(this.id+".gdato");
                        respuesta+="<principal>\n";
                        for(Component componente:ventana.getLista_paneles()){
                            if(componente instanceof Panel_UI){
                                Panel_UI panel=(Panel_UI)componente;
                                for(Component compo:panel.getLista_componentes()){
                                    if(compo instanceof Numerico_UI){
                                        Numerico_UI numerico=(Numerico_UI)compo;
                                        respuesta+="<"+numerico.getName().toLowerCase()+">";
                                        respuesta+="\""+numerico.getValue().toString().replaceAll("\"","")+"\"";
                                        respuesta+="</"+numerico.getName().toLowerCase()+">\n";
                                    }else if(compo instanceof Area_UI){
                                        Area_UI area=(Area_UI)compo;
                                        respuesta+="<"+area.getName().toLowerCase()+">";
                                        respuesta+="\""+area.getText().toString().replaceAll("\"","")+"\"";
                                        respuesta+="</"+area.getName().toLowerCase()+">\n";
                                    }else if(compo instanceof Caja_UI){
                                        Caja_UI caja=(Caja_UI)compo;
                                        respuesta+="<"+caja.getName().toLowerCase()+">";
                                        respuesta+="\""+caja.getText().toString().replaceAll("\"","")+"\"";
                                        respuesta+="</"+caja.getName().toLowerCase()+">\n";
                                    }else if(compo instanceof Desplegable_UI){
                                        Desplegable_UI desple=(Desplegable_UI)compo;
                                        respuesta+="<"+desple.getName().toLowerCase()+">";
                                        respuesta+="\""+desple.getSelectedItem().toString().replaceAll("\"","")+"\"";
                                        respuesta+="</"+desple.getName().toLowerCase()+">\n";
                                    }else{
                                        //AQUI NO VAMOS A REALIZAR NADA
                                    }
                                }
                            }
                        }
                        respuesta+="</principal>\n";
                        respuesta="<lista>\n"+respuesta+"</lista>\n";
                        EscribirArchivo(this.id+".gdato",respuesta);
                        Principal.jTextArea1.setText(Principal.jTextArea1.getText()+"\n CONSOLA>Se creo el archivo "+this.id+".gdato");
                    }
                }else{
                    Boton_UI boton=(Boton_UI)sim.valor;
                    boton.agregarAlclic(llamada);
                    entorno.Actualizar(id, sim);
                }
            }else{
                Errores error=new Errores("SEMANTICO","el componente al que se le quiere agregar la accion alclic no existe en el entorno",this.linea,this.columna);
                Proyecto1Compi2_201213580.errores_fs.add(error);
            }
        }catch(Exception e){
            
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion al cargar los eventos de los botones");
        }
        return null;
    }
    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
