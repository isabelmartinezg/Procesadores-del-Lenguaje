lexer grammar GLexer;

//keywords
KEYWORD_FUNCTION: 'function';
KEYWORD_BEGIN: 'begin';
KEYWORD_END: 'end';
KEYWORD_WHILE: 'while';
KEYWORD_INCLUDE: 'include';
KEYWORD_IF: 'if';
KEYWORD_ELSE:'else';
KEYWORD_THEN: 'then';
KEYWORD_ENDIF: 'endif';
KEYWORD_FOR: 'for';
KEYWORD_FROM: 'from';
KEYWORD_TO: 'to';
KEYWORD_DO: 'do';
KEYWORD_ENDDO: 'enddo';
KEYWORD_STEP: 'step';
KEYWORD_RETURN: 'return';
TRUE: 'true';
FALSE: 'false';

//tipo de datos
VOID: 'void';
NUMERO: 'numero';
CADENA: 'cadena';
BOOLEANO: 'booleano';

//tipos primitivos de datos
ENTERO: DIGITO+ 
      | (MENOS DIGITO+);
FLOTANTE: DIGITO '.' DIGITO+;
IDENTIFICADOR: CARACTER (GUIONBAJO|CARACTER|DIGITO)*;
fragment CARACTER: [a-zA-Z];
fragment DIGITO: [0-9]+;
fragment MENOS: '-';

//signos de puntuacion
PI: '(';
PD: ')';
FIN: ';';
COMA: ',';
DOS_PUNTOS: ':';
CD: ']';
CI: '[';

//operadores
ASIGNACION: ':=';
MENOR_QUE: '<';
MAYOR_QUE:'>';
IGUAL_QUE:'==';
DISTINTO_QUE: '!=';
SUMA: '+';
GUIONBAJO: '_';
AND: '&&';
OR: '||';
NOT: '!';
MULT: '*';



//comentarios
COMENTARIO_LINEA: '//' .*? '\n' ->skip;
COMENTARIO_BLOQUE: (('/*' .*? '*/')|('/**' .*? '**/')|('/***' .*? '***/')|('/****' .*? '****/')) ->skip;

//cadenas de caracteres
CADENA_CARACTERES: ('"' (ESC|.)*? '"'); 
fragment ESC: '\\'[btnr"\\]; // \b \t \n \r \" \\;

//espacios en blanco, tabuladores...
WS:[ \t\n\r]+ ->skip; //tiene que ser la ultima regla