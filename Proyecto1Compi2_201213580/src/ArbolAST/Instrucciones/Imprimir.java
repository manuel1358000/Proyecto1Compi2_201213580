/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Componente.NodoGXML;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Expresiones.Expresion;
import Auxiliares.Errores;
import static com.sun.media.BuildInfo.date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import proyecto1compi2_201213580.Principal;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;


/**
 *
 * @author anton
 */
public class Imprimir implements Instruccion{
    Type.PrimitiveType tipo;
    Expresion expresion;
    int linea;
    int columna;
    public Imprimir(Expresion expresion,int linea,int columna){
        this.expresion=expresion;
        this.tipo=Type.PrimitiveType.NULL;
        this.linea=linea;
        this.columna=columna;
    }
    public Imprimir(){
    
    }

    public Type.PrimitiveType getTipo() {
        return tipo;
    }

    public void setTipo(Type.PrimitiveType tipo) {
        this.tipo = tipo;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }
    
    @Override
    public Object execute(Entorno entorno) {
        try{
            Object nuevo=expresion.getValue(entorno);
            if(nuevo!=null){
                if(nuevo instanceof NodoGXML){
                    Errores error=new Errores("SINTACTICO","La variable que quiere imprimir es una instancia de leergxml",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }else{
                    Principal.jTextArea1.setText(Principal.jTextArea1.getText()+"\n CONSOLA>"+nuevo.toString());
                }
            }else{
                Errores error=new Errores("SEMANTICO","imprimir no encontro el valor",this.linea,this.columna);
                Proyecto1Compi2_201213580.errores_fs.add(error);
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion al imprimir un valor");
        }
        
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
