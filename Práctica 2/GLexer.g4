lexer grammar GLexer;

//keywords
KEYWORD_FUNCTION: 'function';
KEYWORD_BEGIN: 'begin';
KEYWORD_END: 'end';
KEYWORD_WHILE: 'while';
KEYWORD_INCLUDE: 'include';
TRUE: 'true';
FALSE: 'false';

//tipo de datos
VOID: 'void';
NUMERO: 'numero';
CADENA: 'cadena';

//tipos primitivos de datos
ENTERO: DIGITO+;
FLOTANTE: DIGITO '.' DIGITO+;
IDENTIFICADOR: CARACTER (CARACTER|DIGITO)*;
fragment CARACTER: [a-zA-Z];
fragment DIGITO: [0-9]+;

//signos de puntuacion
PI: '(';
PD: ')';
FIN: ';';
COMA: ',';
DOS_PUNTOS: ':';

//operadores
ASIGNACION: ':=';
MENOR_QUE: '<';
MAYOR_QUE:'>';
IGUAL_QUE:'==';
DISTINTO_QUE: '!=';
SUMA: '+';

//comentarios
COMENTARIO_LINEA: '//' .*? '\n' ->skip;
COMENTARIO_BLOQUE: (('/*' .*? '*/')|('/**' .*? '**/')|('/***' .*? '***/')) ->skip;

//cadenas de caracteres
CADENA_CARACTERES: ('"' (ESC|.)*? '"'); 
fragment ESC: '\\'[btnr"\\]; // \b \t \n \r \" \\;

//espacios en blanco, tabuladores...
WS:[ \t\n\r]+ ->skip; //tiene que ser la ultima regla