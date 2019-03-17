/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;

import ArbolAST.Expresiones.operacion.Aritmetica;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author anton
 */
public class Numerico_UI extends JSpinner{
    String alto;
    String ancho;
    String maximo;
    String minimo;
    String x;
    String y;
    String defecto;
    String nombre;
    String id_padre;
    public Numerico_UI(String alto,String ancho,String maximo,String minimo,String x,String y,String defecto,String nombre){
        this.alto=alto;
        this.ancho=ancho;
        this.maximo=maximo;
        this.minimo=minimo;
        this.x=x;
        this.y=y;
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
            setBounds(Integer.parseInt(this.x),Integer.parseInt(this.y),Integer.parseInt(this.ancho),Integer.parseInt(this.alto));
            setName(nombre);
            SpinnerModel model=new SpinnerNumberModel(Integer.parseInt(this.defecto),Integer.parseInt(this.minimo),Integer.parseInt(this.maximo),1);
            setModel(model);
        }catch(Exception e){
            System.out.println("ERROR SEMANTICO: EL VALOR DEFECTO PARA EL COTROLADOR NUMERICO DEBE DE SER UN NUMERO");
        }
    }
}
