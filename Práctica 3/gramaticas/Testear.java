//fichero ejecutable
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;
import javax.sound.sampled.SourceDataLine;

//COMENTARIO: Esta es la clase principal de nuestro programa.

public class Testear{
    public static void main (String[] args) throws Exception{
        String inputFile=null;
        String ficheroHTML = null;
        String funcionPrincipal = null;

        if (args.length>0)
        {
            inputFile= args[0];
            ficheroHTML = args[2];
            funcionPrincipal = args[1];
        } 

        InputStream is = System.in;
        if (inputFile!=null){
            is = new FileInputStream(inputFile);
        }

        CharStream input = CharStreams.fromStream(is);
        GLexer lexer = new GLexer (input);
        CommonTokenStream tokens = new CommonTokenStream (lexer);
        GParser parser = new GParser (tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.prog();

        //Configuramos el listener
        miListener mL = new miListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        //Recorremos el arbol
        walker.walk(mL, tree);
        TablaSimbolos miTabla = mL.getTablaSimbolos();

        for(String i : miTabla.getFunciones().keySet())
        {
            miTabla.getFunciones().get(i).generarGrafoFuncion(i);
        }

        GeneradorGrafoLlamadas llamadas = new GeneradorGrafoLlamadas(miTabla.getFunciones());
        llamadas.addNodos();
        llamadas.generarGrafo();

        GrafoCiclomaticaTotal ciclomaticaTotal = new GrafoCiclomaticaTotal(miTabla.getFunciones(), funcionPrincipal);
        HTMLConverter miHTML = new HTMLConverter(miTabla.getFunciones(),ficheroHTML);

        for(String i : miTabla.getFunciones().keySet())
        {        
            miHTML.escribirHTML(i);
        }
        miHTML.endHTML();
    }
}