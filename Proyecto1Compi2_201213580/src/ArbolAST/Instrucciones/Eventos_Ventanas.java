/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Expresiones.Expresion;
import Auxiliares.Errores;
import ElementosUI.Ventana_UI;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;

/**
 *
 * @author anton
 */
public class Eventos_Ventanas implements Instruccion {
    String id;
    Expresion llamada;
    String tipo;
    int linea;
    int columna;
    public Eventos_Ventanas(String id,Expresion llamada,String tipo,int linea,int columna){
        this.id=id;
        this.llamada=llamada;
        this.tipo=tipo;
        this.linea=linea;
        this.columna=columna;
    }
    @Override
    public Object execute(Entorno entorno) {
        try{
            if(tipo.equals("cargar")){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id.toLowerCase());
                if(sim!=null){
                    if(llamada!=null){
                        llamada.getValue(entorno);
                    }
                    Ventana_UI ventana=(Ventana_UI)sim.valor;
                    ventana.setVisible(true);
                    ventana.show();

                }else{
                    Errores error=new Errores("SEMANTICO","no existe la ventana en el entorno, para asignar la accion cargar",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }else if(tipo.equals("cerrar")){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id.toLowerCase());
                if(sim!=null){
                    if(llamada!=null){
                        Ventana_UI ventana=(Ventana_UI)sim.valor;
                        ventana.agregarEventos(llamada);
                        sim.valor=ventana;
                    }
                    entorno.Actualizar(id.toLowerCase(), sim);  
                }else{
                        Errores error=new Errores("SEMANTICO","no existe la ventana en el entorno",this.linea,this.columna);
                        Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en la asignacion de eventos cargar/cerrar en ventanas");
        }
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
