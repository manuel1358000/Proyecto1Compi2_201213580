/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones;

import Analizadores.GramaticaGXML.lexicoGXML;
import Analizadores.GramaticaGXML.sintacticoGXML;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class LeerGXML implements Expresion{
    Type.PrimitiveType tipo;
    String ruta;
    int linea;
    int columna;
    public LeerGXML(String ruta,int linea,int columna){
        this.ruta=ruta;
        this.linea=linea;
        this.columna=columna;
        this.tipo=Type.PrimitiveType.NULL;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    public String LeerArchivo(File file){
        String respuesta="";
        File archivo = file;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                respuesta+=linea+"\n";
            }
        }catch(Exception e){
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                fr.close();     
                }                  
            }catch (Exception e2){ 
                System.out.println("otro error");
                e2.printStackTrace();
            }
        }
        return respuesta;
    }
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        String ruta2=Proyecto1Compi2_201213580.ruta_proyecto+"\\"+this.ruta.replaceAll("\"","");
        File nuevo=new File(ruta2);
        if(nuevo.exists()){
            try {
                InputStreamReader ir = new InputStreamReader(new FileInputStream(nuevo));
                lexicoGXML analizador_lexico=new lexicoGXML(ir);
                sintacticoGXML parser=new sintacticoGXML(analizador_lexico);
                parser.parse();
                respuesta=parser.root;
                this.tipo=Type.PrimitiveType.GXML;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LeerGXML.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(LeerGXML.class.getName()).log(Level.SEVERE, null, ex);
            }                       
        }else{
            System.out.println("Error semantico no existe el archivo a cargar en la funcion leergxml");
        }
        
        return respuesta;
    }

    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        return this.tipo;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
