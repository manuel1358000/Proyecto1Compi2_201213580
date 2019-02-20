package ArbolAST.Entorno;
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
        ID,
        DOUBLE,
        NULL
    }    
}