/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementosUI;
import ArbolAST.NodoAST;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JFrame;
import javax.swing.JPanel;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;
/**
 *
 * @author anton
 */
public class Audio_UI extends JPanel implements NodoAST{
    public static String nombre;
    public static String ruta;
    public static String x;
    public static String y;
    public static String auto;
    public static String alto;
    public static String ancho;
    public static Player player;
    public static Component video;
    public static Component controles;
    
    public Audio_UI(String nombre,String ruta,String x,String y,String auto,String alto,String ancho){
        this.nombre=nombre;
        this.ruta=ruta;
        this.x=x;//
        this.y=y;//
        this.auto=auto;//
        this.alto=alto;//
        this.ancho=ancho;//
        asignarElementos();
        setVisible(true);
        init();
        addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            //Hacer lo que yo quiero
            player.stop();
        }
 });
    }
     public void asignarElementos(){
        
        try {
            setBounds(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(ancho),Integer.parseInt(alto));
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
    private void init() {
            //panel principal
            try {
                player = Manager.createRealizedPlayer(new MediaLocator("file:///"+Proyecto1Compi2_201213580.ruta_proyecto+"\\"+ruta));
                video = player.getControlPanelComponent();
                video.setSize(400,500);
                video.setVisible(true);
                if(video != null)
                    add("Center",video);
                controles = player.getControlPanelComponent();
                controles.setSize(400,100);
                controles.setVisible(true);
                if(controles != null)
                    this.add("South",controles);
                //player.start();
            
            } catch (Exception ex) {
                System.out.println("Error en el reproductor de audio");
            }
            
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
