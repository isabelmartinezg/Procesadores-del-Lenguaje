parser grammar GParser;

options {
    tokenVocab = GLexer;
    language = Java;
}

prog: (include* funcion*);

//palabras reservadas
pr_function: KEYWORD_FUNCTION;
pr_begin: KEYWORD_BEGIN;
pr_end: KEYWORD_END;
pr_include: KEYWORD_INCLUDE;
pr_while: KEYWORD_WHILE;
pr_if: KEYWORD_IF;
pr_else: KEYWORD_ELSE;
pr_then: KEYWORD_THEN;
pr_endif: KEYWORD_ENDIF;
pr_for: KEYWORD_FOR;
pr_from: KEYWORD_FROM;
pr_to: KEYWORD_TO;
pr_do: KEYWORD_DO;
pr_enddo: KEYWORD_ENDDO;
pr_step: KEYWORD_STEP;
pr_return: KEYWORD_RETURN;

palabra_reservada:  pr_function
                |   pr_begin    
                |   pr_end
                |   pr_include
                |   pr_while
                |   pr_if
                |   pr_else
                |   pr_then
                |   pr_endif
                |   pr_for
                |   pr_from
                |   pr_to
                |   pr_do
                |   pr_enddo
                |   pr_step
                |   pr_return
                ;

op_menor: MENOR_QUE;
op_mayor: MAYOR_QUE;
op_igual: IGUAL_QUE;
op_distinto: DISTINTO_QUE;
and: AND;
or: OR;
not: NOT;

condicion_logica: TRUE
                | FALSE
                ;

comparacion: op_menor
           | op_mayor
           | op_igual
           | op_distinto
           | and
           | or
           | not
           ;

operador: op_asignacion
        | op_suma
        | condicion_logica
        | comparacion
        | op_mult
        ;

num: ENTERO | FLOTANTE;
identificador: IDENTIFICADOR;

fin: FIN; 
coma: COMA;
dos_puntos: DOS_PUNTOS;
parentesis_izquierdo: PI;
parentesis_derecho: PD;
op_asignacion: ASIGNACION;
op_suma: SUMA;
op_mult:MULT;
corchete_izquierdo: CI;
corchete_derecho: CD;

signo_puntuacion: parentesis_izquierdo
                | parentesis_derecho
                | fin
                | coma
                | dos_puntos
                | corchete_izquierdo
                | corchete_derecho
                ;

//distintos tipos de parametros: declaraciones de funciones, llamadas a funciones y en bucles
parametros_bucle: (condicion_logica | bucle_while|llamadafuncion | ((var|num) comparacion (var|num))| comparacion)*;
parametros_DF: (tipodedatos var (coma tipodedatos var)*)+;
parametros_LF: (concatenacion | ((var|concatenacion|num) (coma (var|concatenacion|num))* ))+;

parametros: parametros_bucle
        |   parametros_DF
        |   parametros_LF
        ;

//include
include: pr_include libreria fin;
libreria: identificador;

//if-else
if_else: cabecera_if cuerpo_if (cabecera_else cuerpo_else)* pr_endif;
cabecera_if: pr_if parentesis_izquierdo parametros_bucle parentesis_derecho pr_then;
cuerpo_if: (declaracionVariable|asignacion|llamadafuncion|concatenacion|bucle_while|if_else|bucle_for|declaracionArray)+;
cabecera_else: pr_else;
cuerpo_else: (asignacion|llamadafuncion|concatenacion|bucle_while|declaracionArray)+; 

//function: cabecera, cuerpo, declaracion de una funcion y llamada a una funcion
funcion:  cabecerafuncion cuerpofuncion;
cabecerafuncion: pr_function declaracionfuncion;
cuerpofuncion: pr_begin (cuerpofuncion|asignacion|llamadafuncion|bucle_for|concatenacion|bucle_while|if_else|declaracionVariable|op_return|declaracionArray)* pr_end;
declaracionfuncion: nombrefuncion parentesis_izquierdo parametros_DF? parentesis_derecho dos_puntos retornoFuncion fin?;
retornoFuncion:tipodedatos;
llamadafuncion: nombrefuncion parentesis_izquierdo parametros_LF? parentesis_derecho fin?;
nombrefuncion: identificador;

tipodedatos:  NUMERO
            | VOID
            | CADENA
            |BOOLEANO
            ;

declaracionVariable: tipodedatos identificador (coma identificador)* fin;

//asignacion y concatenacion de variables
asignacion: tipodedatos? var op_asignacion (concatenacion|multiplicacion|num|var|array) fin?;
concatenacion: var (op_suma (var|num))+ fin?;
multiplicacion: (var|num) (op_mult (num|var))+ fin?;
op_return: pr_return PI?(var|num|concatenacion|((var|num) comparacion (var|num))|comparacion) PD? fin;

//Bucle while
bucle_while: cabecerawhile cuerpowhile;
cabecerawhile: pr_while parentesis_izquierdo parametros_bucle parentesis_derecho;
cuerpowhile: (pr_begin (asignacion|llamadafuncion|multiplicacion|concatenacion|if_else|bucle_for|bucle_while|declaracionArray)* pr_end) | (asignacion|llamadafuncion|concatenacion|if_else|bucle_for|bucle_while|declaracionArray) ;

//Bucle for
bucle_for: for_cabecera for_cuerpo (pr_enddo|pr_end);
for_cabecera: pr_for identificador pr_from (identificador|num) pr_to (identificador|num) (pr_step (identificador|num))? pr_do;
for_cuerpo: pr_begin* (bucle_for|asignacion|multiplicacion|llamadafuncion|concatenacion|if_else|bucle_while|declaracionArray)* pr_end*;

//Array
array: identificador corchete_izquierdo num corchete_derecho;
cuerpoArray: parentesis_izquierdo ((num|var)coma?)+ parentesis_derecho;
declaracionArray: tipodedatos array op_igual cuerpoArray fin; 

//Variable
var:    identificador
    |   CADENA_CARACTERES
    |   llamadafuncion
    |   declaracionArray
    ;