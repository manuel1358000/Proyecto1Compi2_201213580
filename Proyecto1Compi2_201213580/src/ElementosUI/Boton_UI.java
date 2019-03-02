/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;

import static ElementosUI.Ventana_UI.id;
import java.awt.Component;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.JButton;

/**
 *
 * @author anton
 */
public class Boton_UI extends JButton{
    public static String nombre;
    public static String fuente;
    public static String tam;
    public static String color;
    public static String x;
    public static String y;
    public static String valor;
    public static String alto;
    public static String ancho;
    public static LinkedList<Component> lista_textos;
    
    public Boton_UI(String nombre,String fuente,String tam,String color,String x,String y,String valor,String alto,String ancho){
        this.nombre=nombre;//
        this.fuente=fuente;
        this.tam=tam;
        this.color=color;
        this.x=x;//
        this.y=y;//
        this.valor=valor;//
        this.alto=alto;//
        this.ancho=ancho;//
        this.lista_textos=new LinkedList<>();
        asignarElementos();
    }
    public void asignarElementos(){
        setNombre(this.nombre);
        setBounds(Integer.parseInt(this.x),Integer.parseInt(this.y),Integer.parseInt(this.alto),Integer.parseInt(this.ancho));
        setText(this.valor);
        Font font=new Font(this.fuente, Font.PLAIN,Integer.parseInt(this.tam));
        setFont(font);
    }
    public void agregarComponente(Component componente){
        try{
            this.lista_textos.add(componente);
            this.add(componente);
        }catch(Exception e){
            System.out.println("Ocurrio un error al agregar un componente a la ventana "+id);
        }
    }
    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Boton_UI.nombre = nombre;
    }

    public static String getFuente() {
        return fuente;
    }

    public static void setFuente(String fuente) {
        Boton_UI.fuente = fuente;
    }

    public static String getTam() {
        return tam;
    }

    public static void setTam(String tam) {
        Boton_UI.tam = tam;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        Boton_UI.color = color;
    }


    public static void setX(String x) {
        Boton_UI.x = x;
    }

    public static void setY(String y) {
        Boton_UI.y = y;
    }

    public static String getValor() {
        return valor;
    }

    public static void setValor(String valor) {
        Boton_UI.valor = valor;
    }

    public static String getAlto() {
        return alto;
    }

    public static void setAlto(String alto) {
        Boton_UI.alto = alto;
    }

    public static String getAncho() {
        return ancho;
    }

    public static void setAncho(String ancho) {
        Boton_UI.ancho = ancho;
    }
    
}
