//fichero ejecutable
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

public class Testear{
    public static void main (String[] args) throws Exception{

        String inputFile=null;
        if (args.length>0) inputFile=args[0];

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
        Listener_TipoBasico TB = new Listener_TipoBasico();
        ParseTreeWalker walker = new ParseTreeWalker();

        //Recorremos el arbol
        walker.walk(TB, tree);
    }
}