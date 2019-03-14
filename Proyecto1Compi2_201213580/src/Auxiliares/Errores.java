/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

/**
 *
 * @author anton
 */
public class Errores {
    int index=0;
    String id;
    String archivo;
    String tipo;
    String descripcion;
    String acciones;
    String linea;
    String columna;
    String auxiliar;

    public Errores(String id, String archivo, String tipo, String descripcion, String acciones, String linea, String columna, String auxiliar) {
        this.id = id;
        this.archivo = archivo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.acciones = acciones;
        this.linea = linea;
        this.columna = columna;
        this.auxiliar = auxiliar;
    }
}
