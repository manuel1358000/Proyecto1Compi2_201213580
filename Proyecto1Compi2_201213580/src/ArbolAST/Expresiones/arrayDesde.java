/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones;

import Analizadores.GramaticaFS.lexicoFS;
import Analizadores.GramaticaFS.sintacticoFS;
import Analizadores.GramaticaGDATO.lexicoGDATO;
import Analizadores.GramaticaGDATO.sintacticoGDATO;
import ArbolAST.AST;
import ArbolAST.Componente.NodoGDATO;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.operacion.Aritmetica;
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
public class arrayDesde implements Expresion{
    int linea;
    int columna;
    String path;
    Type.PrimitiveType tipo;

    public arrayDesde(String path, Type.PrimitiveType tipo,int linea, int columna) {
        this.linea = linea;
        this.columna = columna;
        this.path = path;
        this.tipo = tipo;
    }
    
    @Override
    public Object getValue(Entorno entorno) {
        LinkedList<Aritmetica> respuesta =leerGDATO();
        System.out.println("que lleva aqui");
        return respuesta;
    }
    public LinkedList<Aritmetica> leerGDATO(){
        LinkedList<Aritmetica> respuesta=null;
        File archivo=new File(proyecto1compi2_201213580.Proyecto1Compi2_201213580.ruta_proyecto+"\\"+this.path.replaceAll("\"",""));
        if(archivo.exists()){
            try {
                InputStreamReader ir = new InputStreamReader(new FileInputStream(archivo));
                lexicoGDATO analizador_lexico=new lexicoGDATO(ir);
                sintacticoGDATO parser=new sintacticoGDATO(analizador_lexico);
                parser.parse();
                respuesta=parser.root;
                
                this.tipo=Type.PrimitiveType.GDATO;    
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            javax.swing.JOptionPane.showMessageDialog(null,"No se pudo cargar el archivo. Intente nuevamente");
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
