import java.io.IOException;
import java.util.*;
import javax.lang.model.util.ElementScanner6;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;



public class miListener extends GParserBaseListener
{
    private String llamadafuncion = "";
    private TablaSimbolos miTabla = new TablaSimbolos();
    private Funcion funcionActual;
    private String parametrosFuncion="";
    private String retornoFuncion = "";
    private ArrayList <Bucle> controlBucles = new ArrayList<Bucle> ();
    private ArrayList <Bifurcacion> controlBifurcaciones = new ArrayList<Bifurcacion>();
    private Bucle bucleActual;
    private Bifurcacion bifurcacionActual;
    private String nombreFuncion = "";

    public miListener(){}

    @Override
    public void enterPr_if(GParser.Pr_ifContext ctx) {
        this.bifurcacionActual = new Bifurcacion();
        this.controlBifurcaciones.add(this.bifurcacionActual);
    }

    @Override
    public void enterPr_function(GParser.Pr_functionContext ctx) {
        this.funcionActual = new Funcion();
    }    

    @Override
    public void enterOp_asignacion(GParser.Op_asignacionContext ctx) {
        this.funcionActual.addLineaCodigoEfectiva(1);
    }

    @Override
    public void enterDeclaracionfuncion(GParser.DeclaracionfuncionContext ctx)
    {
        this.nombreFuncion = "Necesito un nombre de la funcion";
    }

   @Override
    public void enterPr_while(GParser.Pr_whileContext ctx) {
        this.bucleActual = new Bucle ();
        this.controlBucles.add (this.bucleActual);
    }

    @Override
    public void exitBucle_while(GParser.Bucle_whileContext ctx) {

        if(this.controlBucles.size() > 1 )
        {
            this.controlBucles.get(this.controlBucles.size() - 2).addBucle(this.controlBucles.get(this.controlBucles.size() - 1));
            this.controlBucles.remove(this.controlBucles.size()-1);
            this.bucleActual = this.controlBucles.get(this.controlBucles.size()-1);
        }else
        {
            this.funcionActual.addBucle(this.controlBucles.get(this.controlBucles.size() - 1));   
            this.controlBucles.remove(this.controlBucles.size()-1); 
            this.bucleActual = null;
        }
    }

    @Override
    public void enterPr_for(GParser.Pr_forContext ctx) 
    {
        this.bucleActual = new Bucle ();
        this.controlBucles.add (this.bucleActual);
    }

    @Override
    public void enterPr_endif(GParser.Pr_endifContext ctx) 
    {
        if(this.controlBifurcaciones.size() > 1 )
        {
            this.controlBifurcaciones.get(this.controlBifurcaciones.size() - 2).addBifurcacion(this.controlBifurcaciones.get(this.controlBifurcaciones.size() - 1));
            this.controlBifurcaciones.get(this.controlBifurcaciones.size() -2).actualizarContadorNodos();
            this.controlBifurcaciones.remove(this.controlBifurcaciones.size()-1);
            this.bifurcacionActual = this.controlBifurcaciones.get(this.controlBifurcaciones.size()-1);
        }else if(this.controlBucles.size() > 0)
        {
            this.controlBucles.get(this.controlBucles.size()-1).addBifurcacion(this.controlBifurcaciones.get(this.controlBifurcaciones.size() - 1));
           // this.controlBucles.get(this.controlBucles.size() -1).actualizarContadorNodos();
            this.controlBifurcaciones.remove(this.controlBifurcaciones.size()-1); 
            this.bifurcacionActual = null;
        }else
        {
            this.funcionActual.addBifurcacion(this.controlBifurcaciones.get(this.controlBifurcaciones.size() - 1));     
            this.controlBifurcaciones.remove(this.controlBifurcaciones.size()-1); 
            this.bifurcacionActual = null;
        }
    }

    @Override
    public void enterPr_else(GParser.Pr_elseContext ctx) {
        this.controlBifurcaciones.get(this.controlBifurcaciones.size()-1).setContadorElse();
    }

    @Override
    public void enterPr_enddo(GParser.Pr_enddoContext ctx) 
    {    
        if(this.controlBucles.size() > 1 )
        {
            this.controlBucles.get(this.controlBucles.size() - 2).addBucle(this.controlBucles.get(this.controlBucles.size() - 1));
            this.controlBucles.remove(this.controlBucles.size()-1);
            this.bucleActual = this.controlBucles.get(this.controlBucles.size()-1);
        }else
        {
            this.funcionActual.addBucle(this.controlBucles.get(this.controlBucles.size() - 1));
            this.controlBucles.remove(this.controlBucles.size()-1); 
            this.bucleActual = null;
        }
    }

    @Override
    public void exitIdentificador(GParser.IdentificadorContext ctx)
    {
        this.nombreFuncion = "";
    }

    @Override
    public void enterIdentificador(GParser.IdentificadorContext ctx) 
    {
        if(this.nombreFuncion.equals("Necesito un nombre de la funcion"))
        {
            this.funcionActual.setNombre(ctx.IDENTIFICADOR().getText());
            this.nombreFuncion="";
        }else if(this.parametrosFuncion.equals("Necesito un parámetro de funcion"))
        {
            this.funcionActual.appendParametro(ctx.IDENTIFICADOR().getText());
        }else if(this.llamadafuncion.equals("Necesito un nombre de llamada"))
        {
                if(this.controlBifurcaciones.size() > 1 )
                {
                    this.controlBifurcaciones.get(this.controlBifurcaciones.size()-1).addNombreLlamada(ctx.IDENTIFICADOR().getText());
                }else if(this.controlBucles.size() > 0)
                {
                    this.controlBucles.get(this.controlBucles.size()-1).addNombreLlamada(ctx.IDENTIFICADOR().getText());
                }else
                {
                    this.funcionActual.addNombreLlamada(ctx.IDENTIFICADOR().getText());
                }
            this.llamadafuncion ="";
        }
    }

    @Override
    public void exitParametros_DF(GParser.Parametros_DFContext ctx) {
        this.parametrosFuncion ="";
    }

    @Override
    public void enterRetornoFuncion(GParser.RetornoFuncionContext ctx) {
        this.retornoFuncion = "Necesito un retorno de funcion";
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        if(this.retornoFuncion.equals("Necesito un retorno de funcion"))
        {
            this.funcionActual.appendReturn(node.getText());
            this.retornoFuncion ="";
        }
    }

    @Override
    public void enterParametros_DF(GParser.Parametros_DFContext ctx) 
    {
        this.funcionActual.addPuntosParametro(2 * ctx.tipodedatos().size());
        this.parametrosFuncion = "Necesito un parámetro de funcion";
    }

    @Override
    public void enterDeclaracionVariable(GParser.DeclaracionVariableContext ctx) {
        if(this.controlBucles.size() > 0)
        {
            if(this.controlBifurcaciones.size() > 0)
            {
                this.controlBifurcaciones.get(this.controlBifurcaciones.size()-1).addPuntosDeclaracionVariable(1 * ctx.identificador().size()); 
            }else
            {
                this.controlBucles.get(this.controlBucles.size()-1).addPuntosDeclaracionVariable(1 * ctx.identificador().size()); 
            }                  
        }else
        {
            if(this.controlBifurcaciones.size() > 0)
            {
                this.controlBifurcaciones.get(controlBifurcaciones.size()-1).addPuntosDeclaracionVariable(1 * ctx.identificador().size());
            }else
            {
                this.funcionActual.addPuntosDeclaracionVariable(1 * ctx.identificador().size());
            }       
        }
        this.funcionActual.addLineaCodigoEfectiva(ctx.identificador().size());        
    }

    @Override
    public void enterLlamadafuncion(GParser.LlamadafuncionContext ctx) {
        this.llamadafuncion = "Necesito un nombre de llamada";
        if(this.controlBifurcaciones.size() > 0)
        {
            this.controlBifurcaciones.get(this.controlBifurcaciones.size()-1).addPuntosLlamadaFuncion(2);
        }else if(this.controlBucles.size() > 0)
        {   
            this.controlBucles.get(this.controlBucles.size()-1).addPuntosLlamadaFuncion(2);
        }else 
        {
            this.funcionActual.addPuntosLlamadaFuncion(2);
        }
        this.funcionActual.addLineaCodigoEfectiva(1);       
    }

    @Override
    public void enterParametros_LF(GParser.Parametros_LFContext ctx) {
        if(this.controlBucles.size() > 0)
        {
            if(this.controlBifurcaciones.size() > 0)
            {
                this.controlBifurcaciones.get(this.controlBifurcaciones.size()-1).addPuntosParametrosLlamadaFuncion(1 * (ctx.coma().size()+1));
            }else
            {
                this.controlBucles.get(this.controlBucles.size()-1).addPuntosParametrosLlamadaFuncion(1 * (ctx.coma().size()+1));
            }        
        }else
        {
            if(this.controlBifurcaciones.size() > 0)
            {
                this.controlBifurcaciones.get(this.controlBifurcaciones.size()-1).addPuntosParametrosLlamadaFuncion(1 * (ctx.coma().size()+1));
            }else
            {
                this.funcionActual.addPuntosParametrosLlamadaFuncion(1 * (ctx.coma().size()+1));
            }
        }
    }

    @Override
    public void enterComparacion(GParser.ComparacionContext ctx) {
        this.funcionActual.addLineaCodigoEfectiva(1);
    }

    @Override
    public void enterOp_mult(GParser.Op_multContext ctx) {
        this.funcionActual.addPuntosOperacionesSimples(1);
    }

    @Override
    public void enterOp_suma(GParser.Op_sumaContext ctx) {
        if(this.controlBucles.size() > 0)
        {
            if(this.controlBifurcaciones.size() > 0)
            {
                this.controlBifurcaciones.get(this.controlBifurcaciones.size()-1).addPuntosOperacionesSimples(1);
            }else
            {
                this.controlBucles.get(this.controlBucles.size()-1).addPuntosOperacionesSimples(1);
            }        
        }else
        {
            if(this.controlBifurcaciones.size() > 0)
            {
                this.controlBifurcaciones.get(this.controlBifurcaciones.size()-1).addPuntosOperacionesSimples(1);
            }else
            {
                this.funcionActual.addPuntosOperacionesSimples(1);
            }
        }
        this.funcionActual.addLineaCodigoEfectiva(1);
    }

    @Override
    public void exitFuncion(GParser.FuncionContext ctx)
    {
        this.miTabla.addFuncion(funcionActual.getNombre(), funcionActual);
        controlBucles.clear();
        controlBifurcaciones.clear(); 
    }

    public TablaSimbolos getTablaSimbolos ()
    {
        return this.miTabla;
    }
}