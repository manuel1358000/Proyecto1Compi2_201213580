/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos_Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

/**
 *
 * @author anton
 */
public class Pesta extends JPanel implements ActionListener{
    
    public String path="";
    public static RSyntaxTextArea textArea= new RSyntaxTextArea();
    public  JTextField searchField;
    public JCheckBox regexCB;
    public JCheckBox matchCaseCB;
    public RTextScrollPane sp;
    public static RSyntaxTextArea getTextArea() {
        return textArea;
    }
    public static void setTextArea(RSyntaxTextArea textArea) {
        Pesta.textArea = textArea;
    }
    public Pesta(String path,String tipo) {
        try{
            this.path=path;
            textArea= new RSyntaxTextArea(23,115);
            textArea.setLocation(100,200);
            AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory)TokenMakerFactory.getDefaultInstance();
            if(true){
            }
            if(tipo.equals("fs")){
                atmf.putMapping("text/mi_lenguaje", "Elementos_Interfaz.colores_FS");
            }else if(tipo.equals("gxml")){
                atmf.putMapping("text/mi_lenguaje", "Elementos_Interfaz.colores_GXML");
            }
            textArea.setSyntaxEditingStyle("text/mi_lenguaje");
            textArea.setName("textArea");
            changeStyleProgrammatically();
            //gutter.setIconRowHeaderEnabled(true);
            sp = new RTextScrollPane(textArea);
            sp.setLineNumbersEnabled(true);
            sp.setIconRowHeaderEnabled(true); 
            sp.setName("scroll");
            this.add(sp);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +e.toString());
        }
        
    }
     private void changeStyleProgrammatically() {
      // Change a few things here and there.
        try{
            SyntaxScheme scheme = textArea.getSyntaxScheme();
            scheme.getStyle(Token.RESERVED_WORD).foreground = Color.BLUE;
            scheme.getStyle(Token.LITERAL_CHAR).foreground = Color.ORANGE;
            scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).foreground = Color.ORANGE;
            scheme.getStyle(Token.LITERAL_NUMBER_DECIMAL_INT).foreground = Color.MAGENTA;
            scheme.getStyle(Token.COMMENT_MULTILINE).foreground = Color.GRAY;
            scheme.getStyle(Token.COMMENT_EOL).foreground = Color.GRAY;
            textArea.revalidate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +e.toString());
        }
   }
   public static void setContenido(String contenido){
        try{
            textArea.setText(contenido);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +e.toString());
        }
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
