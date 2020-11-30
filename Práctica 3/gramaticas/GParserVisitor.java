// Generated from GParser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(GParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_function(GParser.Pr_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_begin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_begin(GParser.Pr_beginContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_end(GParser.Pr_endContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_include}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_include(GParser.Pr_includeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_while(GParser.Pr_whileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_if(GParser.Pr_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_else(GParser.Pr_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_then}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_then(GParser.Pr_thenContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_endif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_endif(GParser.Pr_endifContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_for(GParser.Pr_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_from(GParser.Pr_fromContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_to}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_to(GParser.Pr_toContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_do}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_do(GParser.Pr_doContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_enddo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_enddo(GParser.Pr_enddoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#pr_step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_step(GParser.Pr_stepContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#palabra_reservada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPalabra_reservada(GParser.Palabra_reservadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#op_menor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_menor(GParser.Op_menorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#op_mayor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_mayor(GParser.Op_mayorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#op_igual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_igual(GParser.Op_igualContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#op_distinto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_distinto(GParser.Op_distintoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(GParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(GParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(GParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#condicion_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicion_logica(GParser.Condicion_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#comparacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparacion(GParser.ComparacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#operador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperador(GParser.OperadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(GParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(GParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#fin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFin(GParser.FinContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#coma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComa(GParser.ComaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#dos_puntos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDos_puntos(GParser.Dos_puntosContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#parentesis_izquierdo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentesis_izquierdo(GParser.Parentesis_izquierdoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#parentesis_derecho}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentesis_derecho(GParser.Parentesis_derechoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#op_asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_asignacion(GParser.Op_asignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#op_suma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_suma(GParser.Op_sumaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#signo_puntuacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigno_puntuacion(GParser.Signo_puntuacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#parametros_bucle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros_bucle(GParser.Parametros_bucleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#parametros_DF}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros_DF(GParser.Parametros_DFContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#parametros_LF}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros_LF(GParser.Parametros_LFContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(GParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#include}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(GParser.IncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#libreria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLibreria(GParser.LibreriaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#if_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_else(GParser.If_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#cabecera_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCabecera_if(GParser.Cabecera_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#cuerpo_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpo_if(GParser.Cuerpo_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#cabecera_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCabecera_else(GParser.Cabecera_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#cuerpo_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpo_else(GParser.Cuerpo_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(GParser.FuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#cabecerafuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCabecerafuncion(GParser.CabecerafuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#cuerpofuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpofuncion(GParser.CuerpofuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#declaracionfuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionfuncion(GParser.DeclaracionfuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#llamadafuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamadafuncion(GParser.LlamadafuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#nombrefuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNombrefuncion(GParser.NombrefuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#tipodedatos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipodedatos(GParser.TipodedatosContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#declaracionVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionVariable(GParser.DeclaracionVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(GParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#concatenacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenacion(GParser.ConcatenacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#bucle_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBucle_while(GParser.Bucle_whileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#cabecerawhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCabecerawhile(GParser.CabecerawhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#cuerpowhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpowhile(GParser.CuerpowhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#bucle_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBucle_for(GParser.Bucle_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#for_cabecera}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_cabecera(GParser.For_cabeceraContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#for_cuerpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_cuerpo(GParser.For_cuerpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(GParser.VarContext ctx);
}