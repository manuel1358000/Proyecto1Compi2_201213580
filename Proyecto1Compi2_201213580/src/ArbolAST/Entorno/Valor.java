/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolAST.Entorno;

import java.util.Hashtable;

/**
 *
 * @author anton
 */
public class Valor {
    Hashtable valor=new Hashtable();
    public Valor(){
    }
    public void put(Object key,Double valor){
        this.valor.put(key, valor);
    }
    
    public Double get(Object key){
        return (Double)this.valor.get(key);
    }
    
}
