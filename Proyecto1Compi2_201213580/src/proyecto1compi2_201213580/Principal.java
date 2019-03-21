/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1compi2_201213580;

import Analizadores.GramaticaFS.lexicoFS;
import Analizadores.GramaticaFS.simbolofs;
import Analizadores.GramaticaFS.sintacticoFS;
import Analizadores.GramaticaGXML.lexicoGXML;
import Analizadores.GramaticaGXML.sintacticoGXML;
import ArbolAST.AST;
import ArbolAST.Componente.EjecutarGXML;
import ArbolAST.Componente.NodoGXML;
import Auxiliares.Errores;
import ElementosUI.Reproductor;
import Elementos_Interfaz.Pesta;
import java.awt.Component;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author anton
 */
public class Principal extends javax.swing.JFrame {
    public static NodoGXML raiz;
    public static Pesta nueva;
    public int contador_pesta=0;
    RSyntaxTextArea textArea;
    public static ArrayList<JTextArea> listAreas = new ArrayList<JTextArea>();
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("COMPILAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("LIMPIAR CONSOLA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu1.setText("ARCHIVO");

        jMenuItem1.setText("ABRIR PESTAÑA");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("GUARDAR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("GUARDAR COMO");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("PESTAÑAS");

        jMenuItem4.setText("NUEVA PESTAÑA");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("CERRAR PESTAÑA");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("ERRORES");

        jMenuItem6.setText("LIMPIAR ERRORES");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("ERRORES FS");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("ERRORES GXML");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("ERRORES GDATO");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 162, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(contador_pesta>0){
            System.out.println(this.jTabbedPane1.getSelectedIndex());
            Pesta pesta=(Pesta)this.jTabbedPane1.getComponentAt(this.jTabbedPane1.getSelectedIndex());
            for(Component cmp2:pesta.getComponents()){
                if(cmp2.getName()=="scroll"){
                    RTextScrollPane scroll=(RTextScrollPane)cmp2;
                    String [] direccion=pesta.path.split("\\.");
                    if(direccion.length==2){
                        if(direccion[1].toLowerCase().equals("fs")){
                            Escribir_Archivo(scroll.getTextArea().getText(),pesta.path);
                            JOptionPane.showMessageDialog(null,"SE GUARDO LA PESTAÑA A EJECUTAR");
                            File archivo=new File(pesta.path);
                            if(archivo.exists()){
                                try {
                                    InputStreamReader ir = new InputStreamReader(new FileInputStream(archivo));
                                    lexicoFS analizador_lexico=new lexicoFS(ir);
                                     sintacticoFS parser=new sintacticoFS(analizador_lexico);
                                    parser.parse();
                                    
                                    AST nodoRaiz=parser.root;
                                    if(nodoRaiz!=null){
                                        nodoRaiz.execute();
                                        System.out.println("TODO CORRECTO");
                                    }else{
                                    }
                                    
                                    System.out.println("Finalizo la ejecucion de FS");
                                } catch (Exception ex) {
                                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }else{
                                javax.swing.JOptionPane.showMessageDialog(null,"No se pudo cargar el archivo. Intente nuevamente");
                            }
                        }else if(direccion[1].toLowerCase().equals("gxml")){
                            Escribir_Archivo(scroll.getTextArea().getText(),pesta.path);
                            JOptionPane.showMessageDialog(null,"SE GUARDO LA PESTAÑA A EJECUTAR");
                            File archivo=new File(pesta.path);
                            if(archivo.exists()){
                                try {
                                    InputStreamReader ir = new InputStreamReader(new FileInputStream(archivo));
                                    lexicoGXML analizador_lexico=new lexicoGXML(ir);
                                    sintacticoGXML parser=new sintacticoGXML(analizador_lexico);
                                    parser.parse();
                                    EjecutarGXML nodoEjecutar=new EjecutarGXML(parser.root);
                                    if(nodoEjecutar!=null){
                                        nodoEjecutar.OrdenarPrincipal();
                                        nodoEjecutar.Importaciones(parser.root);
                                        nodoEjecutar.setBand(true);
                                        String respuesta=nodoEjecutar.Ejecutar(parser.root,"");
                                        //System.out.println("RESPUESTA \n" + respuesta);
                                        String direc=direccion[0].toString()+".fs";
                                        Escribir_Archivo(respuesta,direc);
                                        String mensaje="\nCONSOLA>Finalizo el analisis del archivo GXML,\n se creo el nuevo archivo en "+direc;
                                        Principal.jTextArea1.setText(Principal.jTextArea1.getText()+mensaje);
                                    }else{
                                        javax.swing.JOptionPane.showMessageDialog(null,"Error sintactico, verifique los errores");
                                    }
                                    
                                } catch (Exception ex) {
                                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }else{
                                javax.swing.JOptionPane.showMessageDialog(null,"No se pudo cargar el archivo. Intente nuevamente");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"LA PESTAÑA QUE QUIERE ANALIZAR NO TIENE UNA EXTENSION VALIDA");
                        }
                        
                    }else{
                        JOptionPane.showMessageDialog(null,"La pestaña que quiere analizar no tiene una extension valida");
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "NO HAY PESTAÑAS PARA COMPILAR");
        }        
//        String ruta=Proyecto1Compi2_201213580.ruta_proyecto+"\\src\\Auxiliares\\entrada.txt";
//        Escribir_Archivo(jTextArea1.getText().toString(),ruta);
//        File archivo=new File(ruta);
//        if(archivo.exists()){
//            try {
//                InputStreamReader ir = new InputStreamReader(new FileInputStream(archivo));
//                lexicoGXML analizador_lexico=new lexicoGXML(ir);
//                sintacticoGXML parser=new sintacticoGXML(analizador_lexico);
//                parser.parse();
//                EjecutarGXML nodoEjecutar=new EjecutarGXML(parser.root);
//                String respuesta=nodoEjecutar.Ejecutar(parser.root,"");
//                System.out.println("RESPUESTA \n" + respuesta);
//                try{
//                    InputStreamReader ir = new InputStreamReader(new FileInputStream(archivo));
//                    lexicoFS analizador_lexico=new lexicoFS(ir);
//                    sintacticoFS parser=new sintacticoFS(analizador_lexico);
//                    parser.parse();
//                    AST nodoRaiz=parser.root;
//                    nodoRaiz.execute();
//                    System.out.println("Se finalizo correctamente EL ANALISIS DE FS");
//                }catch(Exception e){
//                    System.out.println("ERROR EN LA EJECUCION");
//                }
//                
//                
//            } catch (Exception ex) {
//                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else{
//            javax.swing.JOptionPane.showMessageDialog(null,"No se pudo cargar el archivo. Intente nuevamente");
//        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try{
            JFrame parentFrame = new JFrame();
            JFileChooser fileChooser = new JFileChooser(Proyecto1Compi2_201213580.ruta_proyecto);
            fileChooser.setDialogTitle("Specify a file to save");   
            int userSelection = fileChooser.showSaveDialog(parentFrame); 
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String[] ruta=fileToSave.getAbsoluteFile().toString().split("\\.");
                if(ruta.length==2){
                    if(ruta[1].toLowerCase().equals("fs")){
                        GenerarPesta("",fileToSave.getName(),fileToSave.getAbsolutePath(),"fs");
                    }else if(ruta[1].toLowerCase().equals("gxml")){
                        GenerarPesta("",fileToSave.getName(),fileToSave.getAbsolutePath(),"gxml");
                    }else{
                        JOptionPane.showMessageDialog(null,"ERROR EXTENSION INCORRECTA, SOLO SE PUEDEN ANALIZAR ARCHIVOS CON EXTENSION .FS Y .GXML");
                    }
                    if(Crear_Archivo(fileToSave.getAbsolutePath())){
                        
                    }else{
                        JOptionPane.showMessageDialog(null,"OCURRIO UN ERROR EN LA CREACION DEL ARCHIVO");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"ERROR EXTENSION INCORRECTA, EL ARCHIVO NO TIENE UNA EXTENSION VALIDA");
                }
                
            }
        }catch(Exception e){
            
        }
        
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        try{
            if(contador_pesta>0){
                this.jTabbedPane1.remove(this.jTabbedPane1.getSelectedIndex());
                contador_pesta--;
            }else{
                JOptionPane.showMessageDialog(null, "No hay pestañas para cerrar");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +e.toString());
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(contador_pesta>0){
            System.out.println(this.jTabbedPane1.getSelectedIndex());
            Pesta pesta=(Pesta)this.jTabbedPane1.getComponentAt(this.jTabbedPane1.getSelectedIndex());
            for(Component cmp2:pesta.getComponents()){
                if(cmp2.getName()=="scroll"){
                    RTextScrollPane scroll=(RTextScrollPane)cmp2;
                    System.out.println(scroll.getTextArea().getText());
                    EscribirArchivo(pesta.path,scroll.getTextArea().getText());
                    JOptionPane.showMessageDialog(null, "Se guardo con exito la pestaña");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay pestañas para guardar");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try{
            JFrame parentFrame = new JFrame();
            JFileChooser fileChooser = new JFileChooser(Proyecto1Compi2_201213580.ruta_proyecto);
            fileChooser.setDialogTitle("Specify a file to Open");   
            int userSelection = fileChooser.showSaveDialog(parentFrame); 
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();                
                String[] ruta=fileToSave.getAbsoluteFile().toString().split("\\.");
                if(ruta.length==2){
                    if(ruta[1].toLowerCase().equals("fs")){
                        GenerarPesta(LeerArchivo(fileToSave.getAbsolutePath()),fileToSave.getName(),fileToSave.getAbsolutePath(),"fs");
                    }else if(ruta[1].toLowerCase().equals("gxml")){
                        GenerarPesta(LeerArchivo(fileToSave.getAbsolutePath()),fileToSave.getName(),fileToSave.getAbsolutePath(),"gxml");
                    }else{
                        JOptionPane.showMessageDialog(null,"ERROR EXTENSION INCORRECTA, SOLO SE PUEDEN ANALIZAR ARCHIVOS CON EXTENSION .FS Y .GXML");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"ERROR EXTENSION INCORRECTA, EL ARCHIVO NO TIENE UNA EXTENSION VALIDA");
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +e.toString());
        }
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        try{
            JFrame parentFrame = new JFrame();
            JFileChooser fileChooser = new JFileChooser(Proyecto1Compi2_201213580.ruta_proyecto);
            fileChooser.setDialogTitle("Specify a file to save");   
            int userSelection = fileChooser.showSaveDialog(parentFrame); 
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                if(contador_pesta>0){
                    System.out.println(this.jTabbedPane1.getSelectedIndex());
                    Pesta pesta=(Pesta)this.jTabbedPane1.getComponentAt(this.jTabbedPane1.getSelectedIndex());
                    for(Component cmp2:pesta.getComponents()){
                        if(cmp2.getName()=="scroll"){
                            RTextScrollPane scroll=(RTextScrollPane)cmp2;
                            System.out.println(scroll.getTextArea().getText());
                            EscribirArchivo(fileToSave.getAbsolutePath(),scroll.getTextArea().getText());
                            JOptionPane.showMessageDialog(null, "Se guardo con exito la pestaña");
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No hay pestañas para guardar");
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +e.toString());
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Proyecto1Compi2_201213580.errores_fs.clear();
        Proyecto1Compi2_201213580.errores_gxml.clear();
        Proyecto1Compi2_201213580.errores_gdato.clear();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        //ACA VAN LOS ERRORES DE FS
        String contenido="<html>";
        contenido+="<h1> REPORTE DE ERRORES LEXICOS, SINTACTICOS Y SEMANTICOS PARA EL LENGUAJE FUNCION SCRIPT</h1><br>";
        contenido+="<table>\n<tr>";
        contenido+="<th>TIPO</th>";
        contenido+="<th>DESCRIPCION</th>";
        contenido+="<th>FILA</th>";
        contenido+="<th>COLUMNA</th>\n</tr>";
        
        for(int i=0;i<Proyecto1Compi2_201213580.errores_fs.size();i++){
            Errores error=(Errores)Proyecto1Compi2_201213580.errores_fs.get(i);
            contenido+="<tr>";
            contenido+="<th>"+error.getTipo()+"</th>";
            contenido+="<th>"+error.getDescripcion()+"</th>";
            contenido+="<th>"+error.getFila()+"</th>";
            contenido+="<th>"+error.getColumna()+"</th>";
            contenido+="</tr>";
        }
        contenido+="</table>";
        contenido+="</html>";
        String ruta=Proyecto1Compi2_201213580.ruta_proyecto+"\\reportefs.html";
        Escribir_Archivo(contenido,ruta);
        try {
            File objetofile = new File (ruta);
            Desktop.getDesktop().open(objetofile);
        }catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Ocurrio un error abriendo el archivo en la ruta "+ruta);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        //ACA VAN LOS ERRORES DE GXML
        String contenido="<html>";
        contenido+="<h1> REPORTE DE ERRORES LEXICOS, SINTACTICOS Y SEMANTICOS PARA EL LENGUAJE Generic XML</h1><br>";
        contenido+="<table>\n<tr>";
        contenido+="<th>TIPO</th>";
        contenido+="<th>DESCRIPCION</th>";
        contenido+="<th>FILA</th>";
        contenido+="<th>COLUMNA</th>\n</tr>";
        
        for(int i=0;i<Proyecto1Compi2_201213580.errores_gxml.size();i++){
            Errores error=(Errores)Proyecto1Compi2_201213580.errores_gxml.get(i);
            contenido+="<tr>";
            contenido+="<th>"+error.getTipo()+"</th>";
            contenido+="<th>"+error.getDescripcion()+"</th>";
            contenido+="<th>"+error.getFila()+"</th>";
            contenido+="<th>"+error.getColumna()+"</th>";
            contenido+="</tr>";
        }
        contenido+="</table>";
        contenido+="</html>";
        String ruta=Proyecto1Compi2_201213580.ruta_proyecto+"\\reportegxml.html";
        Escribir_Archivo(contenido,ruta);
        try {
            File objetofile = new File (ruta);
            Desktop.getDesktop().open(objetofile);
        }catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Ocurrio un error abriendo el archivo en la ruta "+ruta);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.jTextArea1.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:Ç
        String contenido="<html>";
        contenido+="<h1> REPORTE DE ERRORES LEXICOS, SINTACTICOS Y SEMANTICOS PARA EL LENGUAJE GDATO</h1><br>";
        contenido+="<table>\n<tr>";
        contenido+="<th>TIPO</th>";
        contenido+="<th>DESCRIPCION</th>";
        contenido+="<th>FILA</th>";
        contenido+="<th>COLUMNA</th>\n</tr>";
        
        for(int i=0;i<Proyecto1Compi2_201213580.errores_gdato.size();i++){
            Errores error=(Errores)Proyecto1Compi2_201213580.errores_gdato.get(i);
            contenido+="<tr>";
            contenido+="<th>"+error.getTipo()+"</th>";
            contenido+="<th>"+error.getDescripcion()+"</th>";
            contenido+="<th>"+error.getFila()+"</th>";
            contenido+="<th>"+error.getColumna()+"</th>";
            contenido+="</tr>";
        }
        contenido+="</table>";
        contenido+="</html>";
        String ruta=Proyecto1Compi2_201213580.ruta_proyecto+"\\reportegdato.html";
        Escribir_Archivo(contenido,ruta);
        try {
            File objetofile = new File (ruta);
            Desktop.getDesktop().open(objetofile);
        }catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Ocurrio un error abriendo el archivo en la ruta "+ruta);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed
    public String LeerArchivo(String path){
        String respuesta="";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File (path);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                respuesta+=linea+"\n";
            }
        }catch(Exception e){
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                fr.close();     
                }                  
            }catch (Exception e2){ 
                System.out.println("otro error");
                e2.printStackTrace();
            }
        }
        return respuesta;
    }
    public void EscribirArchivo(String nombre, String contenido){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter(nombre);
            pw = new PrintWriter(fichero);
            pw.println(contenido);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    public boolean Crear_Archivo(String ruta){
        boolean respuesta=false;
        try{
            File archivo = new File(ruta);
            BufferedWriter bw=null;
            if(archivo.exists()) {
                JOptionPane.showMessageDialog(null, "Ya existe un archivo con ese nombre");
            }else {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write("");
                respuesta=true;
            }
            bw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +e.toString());
        }
        return respuesta;
    }
    public void GenerarPesta(String entrada,String nombre,String path,String tipo){
        try{
            if((this.jTabbedPane1.getTabCount()-1)==this.jTabbedPane1.getSelectedIndex()){
                nueva=new Pesta(path,tipo);
                nueva.setContenido(entrada);
                //x,y,ancho,alto
                nueva.setName(nombre);
                this.jTabbedPane1.add(nueva,nombre,this.jTabbedPane1.getTabCount());
                this.jTabbedPane1.setSelectedIndex(this.jTabbedPane1.getTabCount()-1);
                contador_pesta++;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " +e.toString());
        }
    }
    
    
    public void Escribir_Archivo(String contenido,String ruta){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);
            pw.println(contenido);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
