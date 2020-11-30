import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class Listener_TipoBasico extends GParserBaseListener {

    Stack<String> s = new Stack<String>();

    @Override 
    public void enterEveryRule(ParserRuleContext ctx) { 
        s.push(GParser.ruleNames[ctx.getRuleIndex()]);
        for (int i=0; i<s.size();i++)
        {
            System.out.print('/'+s.get(i));
        }
        System.out.println();
    }

    @Override 
    public void exitEveryRule(ParserRuleContext ctx) {
        s.pop();
     }

    @Override 
    public void visitTerminal(TerminalNode node) {
        s.push(GLexer.VOCABULARY.getSymbolicName(node.getSymbol().getType())+":"+node.getText());

        for (int i=0; i<s.size(); i++)
        {
            System.out.print('/'+s.get(i));
        }
        System.out.println();
        s.pop();
    }
}