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
    String id_padre;
    public Desplegable_UI(String alto, String ancho, String lista, String x, String y, String defecto, String nombre) {
        this.alto = alto;
        this.ancho = ancho;
        this.lista = lista;
        this.x = x;
        this.y = y;
        this.defecto = defecto;
        this.nombre = nombre;
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
        setName(this.nombre);
        setBounds(Integer.parseInt(this.x),Integer.parseInt(this.y),Integer.parseInt(this.ancho),Integer.parseInt(this.alto));
        addItem(this.defecto);
        String []listado=this.lista.split(",");
        for(int i=0;i<listado.length;i++){
            addItem(listado[i]);
        }
    }
}
