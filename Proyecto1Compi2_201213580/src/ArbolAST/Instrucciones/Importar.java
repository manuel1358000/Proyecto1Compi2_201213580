/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import Analizadores.GramaticaFS.lexicoFS;
import Analizadores.GramaticaFS.sintacticoFS;
import ArbolAST.AST;
import static ArbolAST.AST.global;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Entorno.Type;
import ArbolAST.NodoAST;
import Auxiliares.Errores;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto1compi2_201213580.Principal;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class Importar implements Instruccion {
    String ruta;
    String id;
    int linea;
    int columna;
    public Importar(String id,String ruta,int linea,int columna){
        this.id=id;
        this.ruta=ruta;
        this.linea=linea;
        this.columna=columna;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public Object execute(Entorno entorno) {
        String completa=proyecto1compi2_201213580.Proyecto1Compi2_201213580.ruta_proyecto+"\\"+this.ruta.replaceAll("\"","");
        File archivo=new File(completa);
        try{
            if(archivo.exists()){
                try {
                    InputStreamReader ir = new InputStreamReader(new FileInputStream(archivo));
                    lexicoFS analizador_lexico=new lexicoFS(ir);
                    sintacticoFS parser=new sintacticoFS(analizador_lexico);
                    parser.parse();
                    AST nodoRaiz=parser.root;
                    for(NodoAST node:nodoRaiz.nodes){
                        if(node instanceof Funcion){
                            Funcion fun=(Funcion)node;
                            Simbolo verificar=(Simbolo)entorno.Obtener(fun.getId());
                            if(verificar==null){
                                Simbolo sim=new Simbolo(false,false,Type.PrimitiveType.FUNCION,fun.getId(),null,fun);
                                entorno.Agregar(fun.getId(), sim);
                            }
                        }
                    }
                    for(NodoAST node:nodoRaiz.nodes){
                        if(node instanceof Importar){
                            Importar importar=(Importar)node;
                            importar.execute(entorno);
                        }
                    }
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la importacion de archivo");
                }
            }else{
                Errores error=new Errores("SEMANTICO","no se pudo cargar el archivo a importar",this.linea,this.columna);
                Proyecto1Compi2_201213580.errores_fs.add(error);
            }
        }catch(Exception f){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion al cargar el archivo a importar");
        }
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
