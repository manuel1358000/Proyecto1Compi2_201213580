/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1compi2_201213580;

import ArbolAST.Entorno.Valor;
import java.io.File;

/**
 *
 * @author anton
 */
public class Proyecto1Compi2_201213580 {
    public static String ruta_proyecto=new File ("").getAbsolutePath();
    public static Valor almacen=new Valor();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Principal principal=new Principal();
        principal.setVisible(true);
        principal.show();
    }
    
}
