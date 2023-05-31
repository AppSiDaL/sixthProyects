import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}


Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
/* Identificador */
Lletras=[a-zA-Z_]+
Lnumeros=[0-9]+
Loperadores=[+,-,/,%,*]+
espacio=[ ,\t,\r,\n]+
Identificador = {Letra}({Letra}|{Digito})*


/* Número */
Numero = 0 | [1-9][0-9]*
%%
"(" { return token(yytext(), "ParentesisA", yyline, yycolumn); }
")" { return token(yytext(), "ParentesisC", yyline, yycolumn); }
"{" { return token(yytext(), "LlaveA", yyline, yycolumn); }
"}" { return token(yytext(), "LlaveC", yyline, yycolumn); }
"[" { return token(yytext(), "CorcheteA", yyline, yycolumn); }
"]" { return token(yytext(), "CorcheteC", yyline, yycolumn); }
"=" { return token(yytext(), "Igual", yyline, yycolumn); }

/* Colores */
#[{Letra}{Digito}]{6} { return token(yytext(), "COLOR", yyline, yycolumn); }

/* Operadores de agrupación */

/* Signos de puntuación */
"," { return token(yytext(), "COMA", yyline, yycolumn); }
";" { return token(yytext(), "PUNTO_COMA", yyline, yycolumn); }

"mentre" { return token(yytext(), "MENTRE", yyline, yycolumn); }
"per" { return token(yytext(), "PER", yyline, yycolumn); }
"ripetere"  { return token(yytext(), "RIPETERE", yyline, yycolumn); }
//Sentencias selectivas
"se"  { return token(yytext(), "SE", yyline, yycolumn); }
"interruttore" { return token(yytext(), "INTERRUTORE", yyline, yycolumn); }
"+"|"-"|"/"|"%"|"*"|"^" { return token(yytext(), "OPERACIONES", yyline, yycolumn); }
"scansione" { return token(yytext(), "SCANSIONE", yyline, yycolumn); }
"vero"|"falso" { return token(yytext(), "BOOLEANOS", yyline, yycolumn); }
"=="|"<="|">="|"!="|"<"|">" { return token(yytext(), "COMPARADORES", yyline, yycolumn); }
"intero"|"carattere"|"corda"|"dopplo"|"booleano" { return token(yytext(), "TIPO_DATO", yyline, yycolumn); }
"stampa" { return token(yytext(), "STAMPA", yyline, yycolumn); }
"++"|"--" { return token(yytext(), "INCREMENTO_DECREMENTO", yyline, yycolumn); }
"&&"|"||" { return token(yytext(), "LOGICOS", yyline, yycolumn); }
/* Operadores lógicos */
"&" |
"|" { return token(yytext(), "OP_LOGICO", yyline, yycolumn); }

/* Final */

/* Errores */
// Número erróneo
0 {Numero}+ { return token(yytext(), "ERROR_1", yyline, yycolumn); }
// Identificador sin $
{Identificador} { return token(yytext(), "ERROR_2", yyline, yycolumn); }
. { return token(yytext(), "ERROR", yyline, yycolumn); }