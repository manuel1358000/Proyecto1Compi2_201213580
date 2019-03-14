/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;

import ArbolAST.NodoAST;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class Imagen_UI extends JLabel implements NodoAST{
    public String nombre;
    public String ruta;
    public String x;
    public String y;
    public String alto;
    public String ancho;
    public String id_padre;
    public Imagen_UI(String nombre,String ruta,String x,String y,String alto,String ancho){
        this.nombre=nombre;
        this.ruta=Proyecto1Compi2_201213580.ruta_proyecto+"\\"+ruta;
        this.x=x;//
        this.y=y;//
        this.alto=alto;//
        this.ancho=ancho;//
        this.id_padre="";
        asignarElementos();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }


    public void setX(String x) {
        this.x = x;
    }

    

    public void setY(String y) {
        this.y = y;
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

    public String getId_padre() {
        return id_padre;
    }

    public void setId_padre(String id_padre) {
        this.id_padre = id_padre;
    }
   
    public void asignarElementos(){
        try{
            setName(this.nombre);
            setBounds(Integer.parseInt(this.x),Integer.parseInt(this.y),Integer.parseInt(this.ancho),Integer.parseInt(this.alto));
            ImageIcon image = new ImageIcon(this.ruta);  
            setIcon(image);
        }catch(Exception e){
            System.out.println("Ocurrio un error al momento de crear la imagen "+nombre);
        }
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
