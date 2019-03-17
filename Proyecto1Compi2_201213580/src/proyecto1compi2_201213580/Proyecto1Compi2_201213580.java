/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1compi2_201213580;

import ArbolAST.Entorno.Valor;
import Auxiliares.Errores;
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
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author anton
 */
public class Proyecto1Compi2_201213580 {
    public static int control_break=0;
    public static String ruta_proyecto=new File ("").getAbsolutePath();
    public static LinkedList<Errores>errores_fs=new LinkedList<>();
    public static LinkedList<Errores>errores_gxml=new LinkedList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal principal=new Principal();
        principal.setVisible(true);
        principal.show();
    }
}
