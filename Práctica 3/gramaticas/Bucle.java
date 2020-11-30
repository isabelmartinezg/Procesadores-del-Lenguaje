import java.io.IOException;
import java.util.*;

//COMENTARIO: Esta clase se encarga de todo lo relacionado con los bucles, los puntos y lo que contengan en su interior.

public class Bucle
{
    private int puntosDeclaracionVariable = 0;
    private int puntosBucles = 0;
    private Integer contadorNodos = 1;
    private int puntosOperacionesSimples = 0;
    private int puntosLlamadaFuncion = 0;
    ArrayList<String> funcionesLlamadas = new ArrayList<String>();
    private int puntosBifurcaciones = 0;
    private HashMap <Integer, Bifurcacion> bifurcaciones = new HashMap <Integer, Bifurcacion>  () ;
    private HashMap <Integer, Bucle> bucles = new HashMap <Integer, Bucle>() ;
    private int puntosParametrosLlamadaFuncion = 0;
    private int puntosTotales = 0;

    public Bucle(){}

    public int getPuntosBucle ()
    {
        return (this.puntosTotales) * ( this.puntosTotales);
    }
    
    public void addPuntosOperacionesSimples(int p)
    {
        this.puntosOperacionesSimples += p;
        this.actualizarPuntosTotales();
    }

    public void actualizarContadorNodos()
    {
        this.contadorNodos ++;
    }

    public void sacarPuntosBifurcaciones()
    {
        this.puntosBifurcaciones = 0;
        for(Bifurcacion i: bifurcaciones.values())
        {
            this.puntosBifurcaciones += i.getPuntosBifurcacion();
        }
        this.actualizarPuntosTotales();
    }

    public void addBifurcacion(Bifurcacion b)
    {
        this.bifurcaciones.put(contadorNodos,b);
        actualizarContadorNodos();
        sacarPuntosBifurcaciones();
    }

    public void sacarPuntosBucles()
    {
        this.puntosBucles = 0;
        for(Bucle i: bucles.values())
        {
            this.puntosBucles += i.getPuntosBucle();
        }
        this.actualizarPuntosTotales();
    }

    public void addPuntosLlamadaFuncion(int p)
    {
        this.puntosLlamadaFuncion += p;
        actualizarContadorNodos();
        this.actualizarPuntosTotales();
    }

    public void addBucle(Bucle b)
    {
        this.bucles.put(contadorNodos,b);
        actualizarContadorNodos();
        sacarPuntosBucles();
    }

    public void addPuntosParametrosLlamadaFuncion(int p)
    {
        this.puntosParametrosLlamadaFuncion += p;
        this.actualizarPuntosTotales();
    }

    public void addPuntosDeclaracionVariable(int p)
    {
        this.puntosDeclaracionVariable +=p;
        actualizarPuntosTotales();
    }

    public void actualizarPuntosTotales()
    {
        this.puntosTotales = this.puntosDeclaracionVariable +    
                                this.puntosLlamadaFuncion + this.puntosParametrosLlamadaFuncion + this.puntosBucles + this.puntosBifurcaciones
                                +this.puntosOperacionesSimples;
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

    public void addNombreLlamada(String nombre)
    {
        funcionesLlamadas.add(nombre);
    }

    public ArrayList<String> getFuncionesLlamadas()
    {
        return this.funcionesLlamadas;
    }

    public void getNodosBucle(GeneradorGrafo grafo) throws IOException
    {
        Integer contador = new Integer(1);
        if((contadorNodos.intValue() - funcionesLlamadas.size()) == 1) 
        {
            grafo.addNodo("CuerpoBucle");
        }else{
            while(contador < contadorNodos)
            {
                if(bifurcaciones.containsKey(contador))
                {
                    if(bifurcaciones.get(contador).esCompleta())
                    {
                        grafo.addNodo("BifurcacionCompleta");
                        bifurcaciones.get(contador).getNodosBifurcacion(grafo);
                    }else{
                        grafo.addNodo("BifurcacionIncompleta");
                        bifurcaciones.get(contador).getNodosBifurcacion(grafo);
                    }
                }else if(bucles.containsKey(contador))
                {
                    grafo.addNodo("Bucle");
                    bucles.get(contador).getNodosBucle(grafo);
                }
                contador++;
            }
        }
        grafo.addNodo("FinBucle");
    }
    
}