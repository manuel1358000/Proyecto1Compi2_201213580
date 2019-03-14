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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto1compi2_201213580.Principal;

/**
 *
 * @author anton
 */
public class Importar implements Instruccion {
    String ruta;
    String id;
    public Importar(String id,String ruta){
        this.id=id;
        this.ruta=ruta;
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
        if(archivo.exists()){
            System.out.println("SI EXISTE EL ARCHIVO A IMPORTAR");
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
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            javax.swing.JOptionPane.showMessageDialog(null,"No se pudo cargar el archivo a importar "+this.ruta.replaceAll("\"","")+". Intente nuevamente");
        }
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
