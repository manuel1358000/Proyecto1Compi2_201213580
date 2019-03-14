/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;

import ArbolAST.NodoAST;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author anton
 */
public class Texto_UI extends JLabel implements NodoAST{
    public static String nombre;
    public static String x;
    public static String y;
    public static String fuente;
    public static String tam;
    public static String color;
    public static String negrita;
    public static String cursiva;
    public static String valor;
    public static String id_padre;
    public Texto_UI(String nombre,String x,String y,String fuente,String tam,String color,String negrita,String cursiva,String valor){
        this.nombre=nombre;
        this.x=x;
        this.y=y;
        this.fuente=fuente;
        this.tam=tam;
        this.color=color;
        this.negrita=negrita;
        this.cursiva=cursiva;
        this.valor=valor;
        this.id_padre="";
        asignarValores();
    }

    public static String getId_padre() {
        return id_padre;
    }

    public static void setId_padre(String id_padre) {
        Texto_UI.id_padre = id_padre;
    }
    
    public void asignarValores(){
        try{
            setName(this.nombre);
            setBounds(Integer.parseInt(this.x),Integer.parseInt(this.y),1000,100);
            if(this.negrita.equals("true")&&this.cursiva.equals("true")){
                Font font=new Font(this.fuente, Font.ITALIC+Font.BOLD,Integer.parseInt(this.tam));
                setFont(font);
            }else if(this.negrita.equals("false")&&this.cursiva.equals("true")){
                Font font=new Font(this.fuente, Font.PLAIN+Font.ITALIC,Integer.parseInt(this.tam));
                setFont(font);
            }else if(this.negrita.equals("true")&&this.cursiva.equals("false")){
                Font font=new Font(this.fuente, Font.BOLD+Font.PLAIN,Integer.parseInt(this.tam));
                setFont(font);
            }else{
                Font font=new Font(this.fuente, Font.PLAIN,Integer.parseInt(this.tam));
                setFont(font);
            }
            setText(this.valor);
            Color col=Color.decode(this.color.toString());
            setForeground(col);
        }catch(Exception e){
            System.out.println("Ocurrio un error al momento de crear el texto "+this.nombre);
        }
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
