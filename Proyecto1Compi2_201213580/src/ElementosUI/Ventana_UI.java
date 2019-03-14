/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.NodoAST;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author anton
 */
public class Ventana_UI extends JFrame implements Expresion{
    //aqui se van a almacenar los paneles
    LinkedList<Expresion> lista_cerrar;
    LinkedList<Component> lista_paneles;
    String id;
    String color;
    String alto;
    String ancho;
    String id_real;
    public Ventana_UI(String id,String color,String alto,String ancho,String id_real){
        this.id=id;
        this.color=color;        
        this.alto=alto;
        this.ancho=ancho;
        this.id_real=id_real;
        this.lista_cerrar=new LinkedList<>();
        this.lista_paneles=new LinkedList<>();
        AsignarElementos();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //Hacer lo que yo quiero
                System.out.println("Estoy cerrando "+lista_cerrar.size());
            }
        });
    }    

    public LinkedList<Expresion> getLista_cerrar() {
        return lista_cerrar;
    }

    public void setLista_cerrar(LinkedList<Expresion> lista_cerrar) {
        this.lista_cerrar = lista_cerrar;
    }

    public String getId_real() {
        return id_real;
    }

    public void setId_real(String id_real) {
        this.id_real = id_real;
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
    public void Agregar_Panel_Normal(Component componente){
        try{
            this.lista_paneles.add(componente);
        }catch(Exception e){
            System.out.println("Ocurrio un error al agregar un componente a la ventana "+id);
        }
    }
    
    
    public void Agregar_Panel_Scroll(Component componente){
        try{
            this.add(componente);
            this.setLocationRelativeTo(componente);
        }catch(Exception e){
            System.out.println("Ocurrio un error al agregar un componente a la ventana "+id);
        }
    }
    public void agregarEventos(Expresion llamada){
        this.lista_cerrar.add(llamada);
    
    }
    public LinkedList<Component> getLista_paneles() {
        return lista_paneles;
    }

    public void setLista_paneles(LinkedList<Component> lista_paneles) {
        this.lista_paneles = lista_paneles;
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

    @Override
    public Object getValue(Entorno entorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArbolAST.Entorno.Type.PrimitiveType getType(Entorno entorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}