import java.util.HashMap;

//COMENTARIO: Esta clase se corresponde con la tabla de símbolos, que en este caso es un HashMap que almacena la clase función con su nombre String como clave
public class TablaSimbolos
{
    private HashMap<String, Funcion> funciones = new HashMap<String, Funcion>();

    public TablaSimbolos(){}

    public void addFuncion( String nombre, Funcion f)
    {
        this.funciones.put(nombre, f);
    }

    public HashMap<String, Funcion> getFunciones ()
    {
        return this.funciones;
    }
}