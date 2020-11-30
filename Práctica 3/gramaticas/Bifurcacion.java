import java.io.IOException;
import java.util.*;

//COMENTARIO: Esta clase se encarga de todo lo relacionado con las bifurcaciones, los puntos y lo que contengan en su interior.

public class Bifurcacion
{
    private int puntosDeclaracionVariable = 0;
    private int puntosBifurcaciones = 0;
    private Integer contadorElse = 0;
    ArrayList<String> funcionesLlamadas = new ArrayList<String>();
    private Integer contadorNodos = 1;
    private int puntosLlamadaFuncion = 0;
    private int puntosOperacionesSimples = 0;
    private HashMap <Integer, Bifurcacion> bifurcaciones = new HashMap<Integer,Bifurcacion> () ;
    private int puntosParametrosLlamadaFuncion = 0;
    private int puntosTotales = 0;
    public Bifurcacion(){}

    public int getPuntosBifurcacion ()
    {
        return (this.puntosTotales) * ( this.puntosTotales);
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

    public void actualizarContadorNodos()
    {
        this.contadorNodos ++;
    }
    public void addPuntosLlamadaFuncion(int p)
    {
        this.puntosLlamadaFuncion += p;
        this.actualizarPuntosTotales();
    }


    public void setContadorElse()
    {
        this.contadorElse = contadorNodos;
    }
    public void addPuntosOperacionesSimples(int p)
    {
        this.puntosOperacionesSimples += p;
        this.actualizarPuntosTotales();
    }

    public void addBifurcacion(Bifurcacion b)
    {
        this.bifurcaciones.put(contadorNodos, b);
        actualizarContadorNodos();
        sacarPuntosBifurcaciones();
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
                                this.puntosLlamadaFuncion + this.puntosParametrosLlamadaFuncion + this.puntosBifurcaciones
                                + this.puntosOperacionesSimples;
    }

    public boolean esCompleta()
    {
        if(contadorElse.intValue() == 0)
        {
            return false;
        }else{
            return true;
        }
    }
    public void addNombreLlamada(String nombre)
    {
        funcionesLlamadas.add(nombre);
    }

    public ArrayList<String> getFuncionesLlamadas()
    {
        return this.funcionesLlamadas;
    }

    public HashMap<Integer,Bifurcacion> getBifurcaciones()
    {
        return this.bifurcaciones;
    }
    public Integer getContadorNodos()
    {
        return this.contadorNodos;
    }

    public void getNodosBifurcacion(GeneradorGrafo grafo) throws IOException
    {
        Integer contador = new Integer(1);

        if(esCompleta())
        {
            if(contadorNodos.intValue() == 1)
            {   
                grafo.addNodo("CuerpoIf");
                grafo.addNodo("CuerpoElse");
            }else
            {
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
                    }
                    contador++;
                }
                grafo.addNodo("CuerpoElse");
            }
            grafo.addNodo("FinBifurcacion"); 
        }else
        {
            if(contadorNodos.intValue() == 1)
            {   
                grafo.addNodo("CuerpoIf");
            }else
            {
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
                    }
                    contador++;
                }
            }
            grafo.addNodo("FinBifurcacionIncompleta"); 
        }  
             
    }
    
}