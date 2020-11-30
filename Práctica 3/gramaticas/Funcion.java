import java.io.IOException;
import java.util.*;

//COMENTARIO: Esta clase se encarga de todo lo relacionado con la clase funcion, tanto sus puntos como los bucles bifurcaciones y llamadas que realiza en su ejecución.

public class Funcion
{

    private String nombre = "";
    private int complejidadCiclomatica =0;
    private String parametros ="";
    private String retorno ="";
    private int puntosParametros = 0;
    private int puntosBifurcaciones = 0;
    private ArrayList<String> parametrosFuncion = new ArrayList<String>();
    private int lineasCodigo = 0;
    GeneradorGrafo grafo;
    private int puntosDeclaracionVariable = 0;
    private Integer contadorNodos = new Integer (1);
    private int puntosBucles = 0;
    private int puntosLlamadaFuncion = 0;
    private int puntosOperacionesSimples = 0;
    private int puntosParametrosLlamadaFuncion = 0;
    private ArrayList<String> funcionesLlamadas = new ArrayList<String>();
    private Stack<String> controlLlamadasFuncion = new Stack<String>();
    private HashMap <Integer,Bifurcacion> bifurcaciones = new HashMap <Integer,Bifurcacion>() ;
    private HashMap <Integer, Bucle> bucles = new HashMap <Integer, Bucle> ();
    private int puntosTotales = 0;

    public Funcion()
    {       
    }

    public void addNombreLlamada(String nombre)
    {
        funcionesLlamadas.add(nombre);
    }

    public ArrayList<String> getFuncionesLlamadas()
    {
        return this.funcionesLlamadas;
    }

    public void appendParametro(String p)
    {
        this.parametrosFuncion.add(p);
        this.parametros ="";
        for(int i =0;i<parametrosFuncion.size();i++)
        {
            if(i == parametrosFuncion.size()-1)
            {
                parametros+=parametrosFuncion.get(i);
            }else{
                parametros += parametrosFuncion.get(i)+",";
            }
        }
    }
    public String getParametros()
    {
        return this.parametros;
    }

    public void appendReturn(String r)
    {
        this.retorno += r;
    }

    public String getRetorno()
    {
        return  this.retorno;
    }
    public int getPuntos ()
    {
        return this.puntosTotales;
    }

    public void addPuntosOperacionesSimples(int p)
    {
        this.puntosOperacionesSimples += p;
        this.actualizarPuntosTotales();
    }

    public void sacarPuntosBifurcaciones()
    {
        this.puntosBifurcaciones = 0;
        for(Bifurcacion i: this.bifurcaciones.values())
        {
            this.puntosBifurcaciones += i.getPuntosBifurcacion();
        }
        this.actualizarPuntosTotales();
    }

    public void addBifurcacion(Bifurcacion b)
    {
        this.bifurcaciones.put(this.contadorNodos,b);
        this.actualizarContadorNodos();
        sacarPuntosBifurcaciones();
    }

    public void actualizarContadorNodos()
    {
        this.contadorNodos = new Integer(this.contadorNodos.intValue() + 1);
    }

    public void addPuntosLlamadaFuncion(int p)
    {
        this.puntosLlamadaFuncion += p;
        actualizarContadorNodos();
        this.actualizarPuntosTotales();
    }

    public void addPuntosParametrosLlamadaFuncion(int p)
    {
        this.puntosParametrosLlamadaFuncion += p;
        this.actualizarPuntosTotales();
    }
    public void addPuntosParametro(int p)
    {
        this.puntosParametros += p;
        actualizarPuntosTotales();
    }

    public void addPuntosDeclaracionVariable(int p)
    {
        this.puntosDeclaracionVariable +=p;
        actualizarPuntosTotales();
    }

    public void actualizarPuntosTotales()
    {
        this.puntosTotales = this.puntosParametros + this.puntosDeclaracionVariable +    
                                this.puntosLlamadaFuncion + this.puntosParametrosLlamadaFuncion + this.puntosBucles 
                                + this.puntosBifurcaciones + this.puntosOperacionesSimples;
    }

    public int getComplejidadCiclomatica()
    {
        return this.complejidadCiclomatica;
    }
    public void setNombre (String n)
    {
        this.nombre = n;
    }

    public void addLineaCodigoEfectiva(int l)
    {
        this.lineasCodigo+=l;
    }
    
    public void sacarPuntosBucles()
    {
        this.puntosBucles = 0;
        for(Bucle i: this.bucles.values())
        {
            this.puntosBucles += i.getPuntosBucle();
        }
        actualizarPuntosTotales();
    }
    public void addBucle( Bucle b)
    {
        this.bucles.put(this.contadorNodos,b);
        actualizarContadorNodos();
        sacarPuntosBucles();
    }
    public String getNombre ()
    {
        return this.nombre;
    }
    public int getNumeroFuncionesLlamadas()
    {
        return this.puntosLlamadaFuncion/2;
    }

    public int getVariablesDeclaradas()
    {
        return this.puntosDeclaracionVariable;
    }
    public int getNumeroParametros()
    {
        return this.puntosParametros;
    }
    public void generarGrafoFuncion(String nombre)throws IOException
    {
        this.grafo = new GeneradorGrafo(nombre);
        getNodosFuncion();
        grafo.generarGrafo();
        this.complejidadCiclomatica=grafo.getComplejidadCiclomatica();
    }
    public void getNodosFuncion() throws IOException
    {  
        
        Integer contador = new Integer(1);
        this.grafo.addNodo("InicioFuncion");
        while (contador < contadorNodos)
        {
            if(bucles.containsKey(contador))
            {
                this.grafo.addNodo("Bucle");
                this.bucles.get(contador).getNodosBucle(this.grafo);
            }else if(bifurcaciones.containsKey(contador))
            {
                if(this.bifurcaciones.get(contador).esCompleta())
                {
                    this.grafo.addNodo("BifurcacionCompleta");
                    this.bifurcaciones.get(contador).getNodosBifurcacion(grafo);
                }else{
                    this.grafo.addNodo("BifurcacionIncompleta");
                    this.bifurcaciones.get(contador).getNodosBifurcacion(grafo);
                }
                
            }
            contador = new Integer(contador.intValue() + 1);
        }
        this.grafo.addNodo("FinFuncion");
    }
    public Integer getContadorNodos()
    {
        return this.contadorNodos;
    }

    public HashMap<Integer,Bucle> getBucles()
    {
        return this.bucles;
    }

    public HashMap<Integer,Bifurcacion> getBifurcaciones()
    {
        return this.bifurcaciones;
    }

    public int getLineasCodigo()
    {
        return this.lineasCodigo;
    }
}