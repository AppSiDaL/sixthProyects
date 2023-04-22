package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
int |
if |
else |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"("|")"|"{"|"}"|"["|"]" {return limitesBloques;}
"mentre"|"per"|"ripetere" {return ciclos;}
"se"|"interruttore" {return sentenciasSelectivas;}
"+"|"-"|"/"|"%"|"*"|"^" {return Loperadores;}
"scansione" {return Lentrada;}
"0"|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9" {return Lnumeros;}
"vero"|"falso" {return Lbooleanos;}
"=="|"<="|">="|"!="|"<"|">" {return Lcomparadores;}
"intero"|"carattere"|"corda"|"dopplo"|"booleano" {return LtipoDato;}
"stampa" {return Lsalida;}
"++"|"--" {return Linde;}
"&&"|"||" {return Land;}

"=" {return Igual;}
"+" {return Suma;}
"-" {return Resta;}
"*" {return Multiplicacion;}
"/" {return Division;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
