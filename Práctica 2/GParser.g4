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

palabra_reservada:  pr_function
                |   pr_begin    
                |   pr_end
                |   pr_include
                |   pr_while
                ;

op_menor: MENOR_QUE;
op_mayor: MAYOR_QUE;
op_igual: IGUAL_QUE;
op_distinto: DISTINTO_QUE;

condicion_logica: TRUE
                | FALSE
                ;

comparacion: op_menor
           | op_mayor
           | op_igual
           | op_distinto
           ;

operador: op_asignacion
        | op_suma
        | condicion_logica
        | comparacion
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

signo_puntuacion: parentesis_izquierdo
                | parentesis_derecho
                | fin
                | coma
                | dos_puntos
                ;

//distintos tipos de parametros: declaraciones de funciones, llamadas a funciones y en bucles
parametros_bucle: (condicion_logica|(var comparacion var));
parametros_DF: (tipodedatos var (coma tipodedatos var)*)+;
parametros_LF: ((var (coma var)*)|concatenacion)+;

parametros: parametros_bucle
        |   parametros_DF
        |   parametros_LF
        ;

//include
include: pr_include libreria fin;
libreria: identificador;

//function: cabecera, cuerpo, declaracion de una funcion y llamada a una funcion
funcion:  cabecerafuncion cuerpofuncion;
cabecerafuncion: pr_function declaracionfuncion;
cuerpofuncion: pr_begin (asignacion|llamadafuncion|concatenacion|bucle)* pr_end;
declaracionfuncion: nombrefuncion parentesis_izquierdo parametros_DF? parentesis_derecho dos_puntos tipodedatos;
llamadafuncion: nombrefuncion parentesis_izquierdo parametros_LF parentesis_derecho fin?;
nombrefuncion: identificador;

tipodedatos:  NUMERO
            | VOID
            | CADENA
            ;

//asignacion y concatenacion de variables
asignacion: tipodedatos? var op_asignacion (concatenacion|num|var) fin?;
concatenacion: var (op_suma var)+ fin?;

//Bucle while
bucle: cabecerawhile cuerpowhile;
cabecerawhile: pr_while parentesis_izquierdo parametros_bucle parentesis_derecho;
cuerpowhile: pr_begin (asignacion|llamadafuncion|concatenacion)* pr_end;

//Variable
var:    identificador
    |   CADENA_CARACTERES
    |   llamadafuncion
    ;