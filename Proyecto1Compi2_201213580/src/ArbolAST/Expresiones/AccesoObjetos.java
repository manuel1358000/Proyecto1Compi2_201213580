/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Expresiones;

import ArbolAST.Componente.NodoGDATO;
import ArbolAST.Componente.NodoGXML;
import ArbolAST.Entorno.Entorno;
import ArbolAST.Entorno.Type;
import ArbolAST.Entorno.Simbolo;
import ArbolAST.Expresiones.operacion.Aritmetica;
import Auxiliares.Errores;
import java.util.LinkedList;
import proyecto1compi2_201213580.Proyecto1Compi2_201213580;
/**
 *
 * @author anton
 */
public class AccesoObjetos implements Expresion{
    String id;
    String atributo;
    Type.PrimitiveType tipo;
    int linea;
    int columna;
    public AccesoObjetos(String id,String atributos,int linea, int columna){
        this.id=id;
        this.atributo=atributos;
        this.tipo=Type.PrimitiveType.NULL;
        this.linea=linea;
        this.columna=columna;
    }
    @Override
    public Object getValue(Entorno entorno) {
        Object respuesta=null;
        try{
            if(verificarAtributo(this.atributo)!=Type.PrimitiveType.NULL){
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    if(sim.valor instanceof NodoGXML){
                        NodoGXML nodo=(NodoGXML)sim.valor;
                        for(int i=0;i<nodo.elementos.size();i++){
                            if(nodo.elementos.get(i).nombre.equals(this.atributo)){
                                respuesta=nodo.elementos.get(i).valor;
                                break;
                            }                        
                        }
                        if(respuesta==null){
                            Errores error=new Errores("SINTACTICO","No existe el atributo en al objeto que quiere acceder",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else if(sim.valor instanceof Aritmetica){
                        Aritmetica ari=(Aritmetica)sim.valor;
                        NodoGXML nodo=(NodoGXML)ari.getValue(entorno);
                        for(int i=0;i<nodo.elementos.size();i++){
                            if(nodo.elementos.get(i).nombre.equals(this.atributo)){
                                respuesta=nodo.elementos.get(i).valor;
                                break;
                            }                        
                        }
                        if(respuesta==null){
                            Errores error=new Errores("SINTACTICO","No existe el atributo en al objeto que quiere acceder",this.linea,this.columna);
                            Proyecto1Compi2_201213580.errores_fs.add(error);
                        }
                    }else{
                        Errores error=new Errores("SINTACTICO","No es un objeto que tenga atributos",this.linea,this.columna);
                        Proyecto1Compi2_201213580.errores_fs.add(error);
                    }


                }else{
                    Errores error=new Errores("SINTACTICO","la variable que quiere acceder no existe en el entorno",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
            }else{
                //puede que sea un atributo de un objeto
                Simbolo sim=(Simbolo)entorno.Obtener(this.id);
                if(sim!=null){
                    if(sim.valor instanceof Aritmetica){
                        Aritmetica ari=(Aritmetica)sim.valor;
                        for(NodoGDATO nodog:(LinkedList<NodoGDATO>)ari.getValue(entorno)){
                            if(nodog.getEtiqueta().toLowerCase().equals(this.atributo.toLowerCase())){
                                respuesta=nodog.getValor();
                                this.tipo=nodog.getTipo_dato();
                            }
                        }
                    }
                    System.out.println("");
                }else{
                    Errores error=new Errores("SINTACTICO","la variable que quiere acceder no existe en el entorno",this.linea,this.columna);
                    Proyecto1Compi2_201213580.errores_fs.add(error);
                }
                
                
                
//                Errores error=new Errores("SINTACTICO","El atributo que quiere acceder no existe",this.linea,this.columna);
//                Proyecto1Compi2_201213580.errores_fs.add(error);

            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Excepcion en acceder atributos de los objetos");
        }
        return respuesta;
    }
    public Type.PrimitiveType verificarAtributo(String atributo){
        this.tipo=Type.PrimitiveType.NULL;
        atributo=atributo.toLowerCase().replaceAll("\"","");
        if(atributo.equals("alto")){
            this.tipo=Type.PrimitiveType.INTEGER;
        }else if(atributo.equals("ancho")){
            this.tipo=Type.PrimitiveType.INTEGER;
        }else if(atributo.equals("x")){
            this.tipo=Type.PrimitiveType.INTEGER;
        }else if(atributo.equals("y")){
            this.tipo=Type.PrimitiveType.INTEGER;
        }else if(atributo.equals("id")){
            this.tipo=Type.PrimitiveType.STRING;
        }else if(atributo.equals("tipo")){
            this.tipo=Type.PrimitiveType.STRING;
        }else if(atributo.equals("fuente")){
            this.tipo=Type.PrimitiveType.STRING;
        }else if(atributo.equals("tam")){
            this.tipo=Type.PrimitiveType.INTEGER;
        }else if(atributo.equals("color")){
            this.tipo=Type.PrimitiveType.STRING;
        }else if(atributo.equals("negrita")){
            this.tipo=Type.PrimitiveType.BOOLEAN;
        }else if(atributo.equals("cursiva")){
            this.tipo=Type.PrimitiveType.BOOLEAN;
        }else if(atributo.equals("maximo")){
            this.tipo=Type.PrimitiveType.INTEGER;
        }else if(atributo.equals("minimo")){
            this.tipo=Type.PrimitiveType.INTEGER;
        }else if(atributo.equals("path")){
            this.tipo=Type.PrimitiveType.STRING;
        }else if(atributo.equals("nombre")){
            this.tipo=Type.PrimitiveType.STRING;
        }else if(atributo.equals("id")){
            this.tipo=Type.PrimitiveType.STRING;
        }else{
            this.tipo=Type.PrimitiveType.NULL;
        }
        return this.tipo;
    }
    @Override
    public Type.PrimitiveType getType(Entorno entorno) {
        return this.tipo;
    }

    @Override
    public int getLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
