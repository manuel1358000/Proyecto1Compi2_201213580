/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;

import ArbolAST.NodoAST;
import static ElementosUI.Ventana_UI.id;
import java.awt.Color;
import java.awt.Component;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author anton
 */
public class Panel_UI extends JPanel implements NodoAST {
    public static LinkedList<Component>lista_componentes;
    public String id;
    public String x;
    public String y;
    public String alto;
    public String ancho;
    public String color;
    public String borde;
    
    
    public Panel_UI(String id,String x,String y,String alto,String ancho,String color,String borde){
        this.id=id;
        this.x=x;
        this.y=y;
        this.alto=alto;
        this.ancho=ancho;
        this.color=color;
        this.borde=borde;
        this.lista_componentes=new LinkedList<>();
        asignarElementos();
    }
    
    public void asignarElementos(){
        try{
            setBounds(Integer.parseInt(this.x),Integer.parseInt(this.y),Integer.parseInt(this.ancho),Integer.parseInt(this.alto));
            Color col=Color.decode(this.color.toString().replaceAll("\"",""));
            this.setBackground(col);
            if(this.borde.equals("verdadero")){
               this.setBorder(BorderFactory.createTitledBorder("Contenedor "+this.id));
            }
            this.setLayout(null);
            this.setVisible(true);
            setName(this.id);
        }catch(Exception e){
            System.out.println("Ocurrio un error creando el panel con id "+ this.id);
        }
    
    }
    public void Agregar_Componente(Component componente){
        try{
            this.lista_componentes.add(componente);
            this.add(componente);
        }catch(Exception e){
            System.out.println("Ocurrio un error al agregar un componente a la ventana "+id);
        }
    }

    public static LinkedList<Component> getLista_componentes() {
        return lista_componentes;
    }

    public static void setLista_componentes(LinkedList<Component> lista_componentes) {
        Panel_UI.lista_componentes = lista_componentes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBorde() {
        return borde;
    }

    public void setBorde(String borde) {
        this.borde = borde;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
