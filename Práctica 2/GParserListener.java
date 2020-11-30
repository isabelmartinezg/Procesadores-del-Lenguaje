// Generated from GParser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GParser}.
 */
public interface GParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#pr_function}.
	 * @param ctx the parse tree
	 */
	void enterPr_function(GParser.Pr_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#pr_function}.
	 * @param ctx the parse tree
	 */
	void exitPr_function(GParser.Pr_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#pr_begin}.
	 * @param ctx the parse tree
	 */
	void enterPr_begin(GParser.Pr_beginContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#pr_begin}.
	 * @param ctx the parse tree
	 */
	void exitPr_begin(GParser.Pr_beginContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#pr_end}.
	 * @param ctx the parse tree
	 */
	void enterPr_end(GParser.Pr_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#pr_end}.
	 * @param ctx the parse tree
	 */
	void exitPr_end(GParser.Pr_endContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#pr_include}.
	 * @param ctx the parse tree
	 */
	void enterPr_include(GParser.Pr_includeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#pr_include}.
	 * @param ctx the parse tree
	 */
	void exitPr_include(GParser.Pr_includeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#pr_while}.
	 * @param ctx the parse tree
	 */
	void enterPr_while(GParser.Pr_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#pr_while}.
	 * @param ctx the parse tree
	 */
	void exitPr_while(GParser.Pr_whileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#palabra_reservada}.
	 * @param ctx the parse tree
	 */
	void enterPalabra_reservada(GParser.Palabra_reservadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#palabra_reservada}.
	 * @param ctx the parse tree
	 */
	void exitPalabra_reservada(GParser.Palabra_reservadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#op_menor}.
	 * @param ctx the parse tree
	 */
	void enterOp_menor(GParser.Op_menorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#op_menor}.
	 * @param ctx the parse tree
	 */
	void exitOp_menor(GParser.Op_menorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#op_mayor}.
	 * @param ctx the parse tree
	 */
	void enterOp_mayor(GParser.Op_mayorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#op_mayor}.
	 * @param ctx the parse tree
	 */
	void exitOp_mayor(GParser.Op_mayorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#op_igual}.
	 * @param ctx the parse tree
	 */
	void enterOp_igual(GParser.Op_igualContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#op_igual}.
	 * @param ctx the parse tree
	 */
	void exitOp_igual(GParser.Op_igualContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#op_distinto}.
	 * @param ctx the parse tree
	 */
	void enterOp_distinto(GParser.Op_distintoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#op_distinto}.
	 * @param ctx the parse tree
	 */
	void exitOp_distinto(GParser.Op_distintoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#condicion_logica}.
	 * @param ctx the parse tree
	 */
	void enterCondicion_logica(GParser.Condicion_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#condicion_logica}.
	 * @param ctx the parse tree
	 */
	void exitCondicion_logica(GParser.Condicion_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#comparacion}.
	 * @param ctx the parse tree
	 */
	void enterComparacion(GParser.ComparacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#comparacion}.
	 * @param ctx the parse tree
	 */
	void exitComparacion(GParser.ComparacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#operador}.
	 * @param ctx the parse tree
	 */
	void enterOperador(GParser.OperadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#operador}.
	 * @param ctx the parse tree
	 */
	void exitOperador(GParser.OperadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(GParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(GParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(GParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(GParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#fin}.
	 * @param ctx the parse tree
	 */
	void enterFin(GParser.FinContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#fin}.
	 * @param ctx the parse tree
	 */
	void exitFin(GParser.FinContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#coma}.
	 * @param ctx the parse tree
	 */
	void enterComa(GParser.ComaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#coma}.
	 * @param ctx the parse tree
	 */
	void exitComa(GParser.ComaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#dos_puntos}.
	 * @param ctx the parse tree
	 */
	void enterDos_puntos(GParser.Dos_puntosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#dos_puntos}.
	 * @param ctx the parse tree
	 */
	void exitDos_puntos(GParser.Dos_puntosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#parentesis_izquierdo}.
	 * @param ctx the parse tree
	 */
	void enterParentesis_izquierdo(GParser.Parentesis_izquierdoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#parentesis_izquierdo}.
	 * @param ctx the parse tree
	 */
	void exitParentesis_izquierdo(GParser.Parentesis_izquierdoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#parentesis_derecho}.
	 * @param ctx the parse tree
	 */
	void enterParentesis_derecho(GParser.Parentesis_derechoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#parentesis_derecho}.
	 * @param ctx the parse tree
	 */
	void exitParentesis_derecho(GParser.Parentesis_derechoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#op_asignacion}.
	 * @param ctx the parse tree
	 */
	void enterOp_asignacion(GParser.Op_asignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#op_asignacion}.
	 * @param ctx the parse tree
	 */
	void exitOp_asignacion(GParser.Op_asignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#op_suma}.
	 * @param ctx the parse tree
	 */
	void enterOp_suma(GParser.Op_sumaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#op_suma}.
	 * @param ctx the parse tree
	 */
	void exitOp_suma(GParser.Op_sumaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#signo_puntuacion}.
	 * @param ctx the parse tree
	 */
	void enterSigno_puntuacion(GParser.Signo_puntuacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#signo_puntuacion}.
	 * @param ctx the parse tree
	 */
	void exitSigno_puntuacion(GParser.Signo_puntuacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#parametros_bucle}.
	 * @param ctx the parse tree
	 */
	void enterParametros_bucle(GParser.Parametros_bucleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#parametros_bucle}.
	 * @param ctx the parse tree
	 */
	void exitParametros_bucle(GParser.Parametros_bucleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#parametros_DF}.
	 * @param ctx the parse tree
	 */
	void enterParametros_DF(GParser.Parametros_DFContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#parametros_DF}.
	 * @param ctx the parse tree
	 */
	void exitParametros_DF(GParser.Parametros_DFContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#parametros_LF}.
	 * @param ctx the parse tree
	 */
	void enterParametros_LF(GParser.Parametros_LFContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#parametros_LF}.
	 * @param ctx the parse tree
	 */
	void exitParametros_LF(GParser.Parametros_LFContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(GParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(GParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(GParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(GParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#libreria}.
	 * @param ctx the parse tree
	 */
	void enterLibreria(GParser.LibreriaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#libreria}.
	 * @param ctx the parse tree
	 */
	void exitLibreria(GParser.LibreriaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(GParser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(GParser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#cabecerafuncion}.
	 * @param ctx the parse tree
	 */
	void enterCabecerafuncion(GParser.CabecerafuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#cabecerafuncion}.
	 * @param ctx the parse tree
	 */
	void exitCabecerafuncion(GParser.CabecerafuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#cuerpofuncion}.
	 * @param ctx the parse tree
	 */
	void enterCuerpofuncion(GParser.CuerpofuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#cuerpofuncion}.
	 * @param ctx the parse tree
	 */
	void exitCuerpofuncion(GParser.CuerpofuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#declaracionfuncion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionfuncion(GParser.DeclaracionfuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#declaracionfuncion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionfuncion(GParser.DeclaracionfuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#llamadafuncion}.
	 * @param ctx the parse tree
	 */
	void enterLlamadafuncion(GParser.LlamadafuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#llamadafuncion}.
	 * @param ctx the parse tree
	 */
	void exitLlamadafuncion(GParser.LlamadafuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#nombrefuncion}.
	 * @param ctx the parse tree
	 */
	void enterNombrefuncion(GParser.NombrefuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#nombrefuncion}.
	 * @param ctx the parse tree
	 */
	void exitNombrefuncion(GParser.NombrefuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#tipodedatos}.
	 * @param ctx the parse tree
	 */
	void enterTipodedatos(GParser.TipodedatosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#tipodedatos}.
	 * @param ctx the parse tree
	 */
	void exitTipodedatos(GParser.TipodedatosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(GParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(GParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#concatenacion}.
	 * @param ctx the parse tree
	 */
	void enterConcatenacion(GParser.ConcatenacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#concatenacion}.
	 * @param ctx the parse tree
	 */
	void exitConcatenacion(GParser.ConcatenacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#bucle}.
	 * @param ctx the parse tree
	 */
	void enterBucle(GParser.BucleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#bucle}.
	 * @param ctx the parse tree
	 */
	void exitBucle(GParser.BucleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#cabecerawhile}.
	 * @param ctx the parse tree
	 */
	void enterCabecerawhile(GParser.CabecerawhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#cabecerawhile}.
	 * @param ctx the parse tree
	 */
	void exitCabecerawhile(GParser.CabecerawhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#cuerpowhile}.
	 * @param ctx the parse tree
	 */
	void enterCuerpowhile(GParser.CuerpowhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#cuerpowhile}.
	 * @param ctx the parse tree
	 */
	void exitCuerpowhile(GParser.CuerpowhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(GParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(GParser.VarContext ctx);
}