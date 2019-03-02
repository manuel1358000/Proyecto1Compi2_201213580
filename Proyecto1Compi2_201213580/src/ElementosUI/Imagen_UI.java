/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author anton
 */
public class Imagen_UI extends JLabel{
    public static String nombre;
    public static String ruta;
    public static String x;
    public static String y;
    public static String auto;
    public static String alto;
    public static String ancho;
    public Imagen_UI(String nombre,String ruta,String x,String y,String auto,String alto,String ancho){
        this.nombre=nombre;
        this.ruta=ruta;
        this.x=x;//
        this.y=y;//
        this.auto=auto;//
        this.alto=alto;//
        this.ancho=ancho;//
        asignarElementos();
    }
    public void asignarElementos(){
        try{
            setName(this.nombre);
            setBounds(Integer.parseInt(this.x),Integer.parseInt(this.y),Integer.parseInt(this.alto),Integer.parseInt(this.ancho));
            ImageIcon image = new ImageIcon(proyecto1compi2_201213580.Proyecto1Compi2_201213580.ruta_proyecto+this.ruta);  
            setIcon(image);
        }catch(Exception e){
            System.out.println("Ocurrio un error al momento de crear la imagen "+nombre);
        }
    }
}
