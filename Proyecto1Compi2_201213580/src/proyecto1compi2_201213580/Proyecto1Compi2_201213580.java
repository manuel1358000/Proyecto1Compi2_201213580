/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1compi2_201213580;

import ArbolAST.Entorno.Valor;
import ElementosUI.Audio_UI;
import ElementosUI.Boton_UI;
import ElementosUI.Imagen_UI;
import ElementosUI.Panel_UI;
import ElementosUI.Texto_UI;
import ElementosUI.Ventana;
import ElementosUI.Ventana_UI;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author anton
 */
public class Proyecto1Compi2_201213580 {
    public static int control_break=0;
    public static String ruta_proyecto=new File ("").getAbsolutePath();
    public static Valor almacen=new Valor();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal principal=new Principal();
        principal.setVisible(true);
        principal.show();
//        System.out.println(ruta_proyecto);
//        Ventana audio=new Ventana("imagen1","\\angeles.mp3","100","400","verdadero","250","50"); 
//        Imagen_UI imagen=new Imagen_UI("imagen1","\\logo.png","0","0","verdadero","200","200");
//        Texto_UI texto2=new Texto_UI("Texto","0","0","Arial","15","#CDAFFF","verdadero","verdadero","TEXTO DE PRUEBA");
//        Boton_UI boton=new Boton_UI("btn_ventana","Arial","15","#000000","400","100","","100","50");
//        boton.add(texto2);
//        Texto_UI texto=new Texto_UI("Texto","0","0","Arial","40","#CDAFFF","verdadero","verdadero","TEXTO DE PRUEBA");
//        Panel_UI panel=new Panel_UI("panel_inicio","100","100","700","700","#ffffff","verdadero");
//        panel.Agregar_Componente(texto);
//        panel.Agregar_Componente(boton);
//        panel.Agregar_Componente(imagen);
//        panel.Agregar_Componente(audio);
//        Ventana_UI ventana=new Ventana_UI("vent_inicio","#ffffff","1000","1000");
//        ventana.Agregar_Panel(panel);
//        ventana.show();
//        audio.player.stop();
    }
}
