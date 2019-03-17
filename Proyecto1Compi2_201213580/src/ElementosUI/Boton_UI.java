/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;

import ArbolAST.AST;
import ArbolAST.Expresiones.Expresion;
import ArbolAST.Expresiones.Llamada_Funcion;
import ArbolAST.NodoAST;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
/**
 *
 * @author anton
 */
public class Boton_UI extends JButton implements NodoAST{
    String id;
    String fuente;
    String tam;
    String color;
    String x;
    String y;
    String valor;
    String alto;
    String ancho;
    LinkedList<Component> lista_textos;
    Llamada_Funcion referencia;
    String id_padre;
    LinkedList<Expresion>lista_alclick;
    public Boton_UI(String id,String fuente,String tam,String color,String x,String y,Llamada_Funcion referencia,String valor,String alto,String ancho){
        this.id=id;//
        this.fuente=fuente;
        this.tam=tam;
        this.color=color;
        this.x=x;//
        this.y=y;//
        this.referencia=referencia;
        this.valor=valor;//
        this.alto=alto;//
        this.ancho=ancho;//
        this.lista_alclick=new LinkedList<>();
        this.lista_textos=new LinkedList<>();
        asignarElementos();
    }
    public String getId_padre() {
        return id_padre;
    }

    public void setId_padre(String id_padre) {
        this.id_padre = id_padre;
    }
    public void agregarAlclic(Expresion alclic){
        this.lista_alclick.add(alclic);
    }
    public void asignarElementos(){
        try{
            setNombre(this.id);
            setBounds(Integer.parseInt(this.x),Integer.parseInt(this.y),Integer.parseInt(this.ancho),Integer.parseInt(this.alto));
            setText(this.valor);
            Font font=new Font(this.fuente, Font.PLAIN,Integer.parseInt(this.tam));
            setFont(font);
            Color col=Color.decode(this.color.toString().replaceAll("\"",""));
            this.setBackground(col);
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        for(int i=0;i<lista_alclick.size();i++){
                            lista_alclick.get(i).getValue(AST.global);
                        }
                    }catch(Exception t){
                        System.out.println("ERROR AL MOMENTO DE EJECUTAR ALCLIC BOTON_UI");
                    }
                }
            });
        }catch(Exception e){
            System.out.println("ERROR AL MOMENTO DE ASIGNAR ELEMENTOS DE BOTON_UI");
        }
        
    }
    public void agregarComponente(Component componente){
        try{
            this.lista_textos.add(componente);
            this.add(componente);
        }catch(Exception e){
            System.out.println("Ocurrio un error al agregar un componente a la ventana "+id);
        }
    }
    public String getNombre() {
        return id;
    }

    public void setNombre(String nombre) {
        this.id = nombre;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
