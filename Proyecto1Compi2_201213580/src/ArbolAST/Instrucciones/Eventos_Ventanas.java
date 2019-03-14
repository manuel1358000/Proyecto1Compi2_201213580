/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Instrucciones;

import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Expresiones.Expresion;
import ElementosUI.Ventana_UI;

/**
 *
 * @author anton
 */
public class Eventos_Ventanas implements Instruccion {
    String id;
    Expresion llamada;
    String tipo;
    public Eventos_Ventanas(String id,Expresion llamada,String tipo){
        this.id=id;
        this.llamada=llamada;
        this.tipo=tipo;
    }
    @Override
    public Object execute(Entorno entorno) {
        try{
        }catch(Exception e){
            System.out.println("ERROR EN LA ASIGNACION DE EVENTOS CARGAR/CERRAR EN VENTANAS");
        }
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
                System.out.println("ERROR SEMANTICO: NO EXISTE LA VENTANA "+this.id);
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
                System.out.println("ERROR SEMANTICO: NO EXISTE LA VENTANA "+this.id);
            }
        }
        return null;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
