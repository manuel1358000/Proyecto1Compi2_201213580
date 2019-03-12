/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;



/**
 *
 * @author anton
 */
public class Desplegable_UI extends JComboBox{
    String alto;
    String ancho;
    String lista;
    String x;
    String y;
    String defecto;
    String nombre;

    public Desplegable_UI(String alto, String ancho, String lista, String x, String y, String defecto, String nombre) {
        this.alto = alto;
        this.ancho = ancho;
        this.lista = lista;
        this.x = x;
        this.y = y;
        this.defecto = defecto;
        this.nombre = nombre;
        asignarValores();
    }
    public void asignarValores(){
        setBounds(Integer.parseInt(this.x),Integer.parseInt(this.y),Integer.parseInt(this.ancho),Integer.parseInt(this.alto));
        addItem(this.defecto);
        String []listado=this.lista.split(",");
        for(int i=0;i<listado.length;i++){
            addItem(listado[i]);
        }
    }
}
