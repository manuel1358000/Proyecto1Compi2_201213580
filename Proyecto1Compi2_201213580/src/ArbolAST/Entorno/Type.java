package ArbolAST.Entorno;

import ElementosUI.Ventana;

/**
 *
 * @author anton
 */
public class Type {
    String class_id;
    PrimitiveType primitive_type;
    
    public Type(String class_id){
        this.class_id=class_id;
    }
    public enum PrimitiveType{
        INTEGER,
        DOUBLE,
        STRING,
        BOOLEAN,
        OBJECT,
        ID,
        FUNCION,
        NULL,
        ARREGLO,
        VENTANA,
        CONTENEDOR,
        BOTON,
        TEXTO,
        CAJATEXTO,
        AREATEXTO,
        VIDEO,
        AUDIO,
        IMAGEN,
        DESPLEGABLE,
        NUMERICO
    }    
    public boolean esNumero(){
        return primitive_type==Type.PrimitiveType.INTEGER;
    }
    public boolean esDecimal(){
        return primitive_type==Type.PrimitiveType.DOUBLE;
    }
    public boolean esCadena(){
        return primitive_type==Type.PrimitiveType.STRING;
    }
    public boolean esBooleano(){
        return primitive_type==Type.PrimitiveType.BOOLEAN;
    }
    public boolean esNulo(){
        return primitive_type==Type.PrimitiveType.NULL;
    }
    public boolean esObjeto(){
        return primitive_type==Type.PrimitiveType.OBJECT;
    }
    public boolean esId(){
        return primitive_type==Type.PrimitiveType.ID;
    }
    public boolean esFuncion(){
        return primitive_type==Type.PrimitiveType.FUNCION;
    }
}