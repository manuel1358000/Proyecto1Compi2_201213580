/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;

import ArbolAST.Expresiones.operacion.Aritmetica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author anton
 */
public class Caja_UI extends JTextField{
    String alto;
    String ancho;
    String fuente;
    String tam;
    String color;
    String x;
    String y;
    String negrita;
    String cursiva;
    String defecto;
    String nombre;
    String id_padre;
    public Caja_UI(String alto,String ancho,String fuente,String tam,String color,String x,String y,String negrita,String cursiva,String defecto,String nombre){
        this.alto=alto;
        this.ancho=ancho;
        this.fuente=fuente;
        this.tam=tam;
        this.color=color;
        this.x=x;
        this.y=y;
        this.negrita=negrita;
        this.cursiva=cursiva;
        this.defecto=defecto;
        this.nombre=nombre;
        this.id_padre="";
        asignarValores();
    }

    public String getId_padre() {
        return id_padre;
    }

    public void setId_padre(String id_padre) {
        this.id_padre = id_padre;
    }
    
    public void asignarValores(){
        try{
            setName(this.nombre);
            setBounds(Integer.parseInt(this.x), Integer.parseInt(this.y),Integer.parseInt(this.ancho),Integer.parseInt(this.alto));
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
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            setText(this.defecto);
            Color col=Color.decode(this.color.toString());
            setForeground(col);
        }catch(Exception e){
            System.out.println("OCURRIO UN ERROR AL MOMENTO DE CARGAR LOS VALORES DE LA CAJA_UI");
        }
    
    }
}
