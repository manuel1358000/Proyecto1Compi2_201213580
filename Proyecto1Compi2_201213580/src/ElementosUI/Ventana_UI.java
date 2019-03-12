/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;

import ArbolAST.Entorno.Simbolo;
import ArbolAST.NodoAST;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 *
 * @author anton
 */
public class Ventana_UI extends JFrame implements NodoAST{
    //aqui se van a almacenar los paneles
    public static LinkedList<Component> lista_paneles;
    public static String id;
    public static String color;
    public static String alto;
    public static String ancho;
    public static String id_real;
    public Ventana_UI(String id,String color,String alto,String ancho,String id_real){
        this.id=id;
        this.color=color;        
        this.alto=alto;
        this.ancho=ancho;
        this.id_real=id_real;
        this.lista_paneles=new LinkedList<>();
        AsignarElementos();
    }    
    public void AsignarElementos(){
        try{
            setBounds(0,0,Integer.parseInt(this.ancho),Integer.parseInt(this.alto));
            Color col=Color.decode(this.color.toString().replaceAll("\"",""));
            this.getContentPane().setBackground(col);
            this.setLayout(null);
            this.setVisible(true);
            setName(this.id);
        }catch(Exception e){
            System.out.println("Ocurrio un error en la creacion de la ventana con id "+ this.id);
        }
        
    }
    public void Agregar_Panel(Component componente){
        try{
            this.lista_paneles.add(componente);
            this.add(componente);
            this.setLocationRelativeTo(componente);
        }catch(Exception e){
            System.out.println("Ocurrio un error al agregar un componente a la ventana "+id);
        }
    }
    public static LinkedList<Component> getLista_paneles() {
        return lista_paneles;
    }

    public static void setLista_paneles(LinkedList<Component> lista_paneles) {
        Ventana_UI.lista_paneles = lista_paneles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}