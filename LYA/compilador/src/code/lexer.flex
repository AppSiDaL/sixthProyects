package code;
import static code.Tokens.*;
%%
%class Lexer
%type Tokens
Lletras=[a-zA-Z_]+
Lnumeros=[0-9]+
Loperadores=[+,-,/,%,*]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"(" {lexeme=yytext(); return parentesisA;}
")" {lexeme=yytext(); return parentesisB;}
"{" {lexeme=yytext(); return llaveA;}
"}" {lexeme=yytext(); return llaveB;}
"[" {lexeme=yytext(); return corcheteA;}
"]" {lexeme=yytext(); return corcheteB;}
//Ciclos
"mentre"  {lexeme=yytext(); return mentre;}
"per"  {lexeme=yytext(); return per;}
"ripetere"  {lexeme=yytext(); return ripetere;}
//Sentencias selectivas
"se"  {lexeme=yytext(); return se;}
"interruttore"  {lexeme=yytext(); return interruttore;}
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

{Lletras}({Lletras}|{Lnumeros}|"_")* {lexeme=yytext(); return Variable;}
"-"?{Lnumeros}+("."{Lnumeros}+)? {lexeme=yytext(); return Numero;}
({Lletras}({Lletras}|{Lnumeros}|"_")*)"="(("-"?{Lnumeros}+("."{Lnumeros}+)?)|({Lletras}({Lletras}|{Lnumeros}|"_")*))(("+"|"-"|"/"|"%"|"*"|"^")(("-"?{Lnumeros}+("."{Lnumeros}+)?)|({Lletras}({Lletras}|{Lnumeros}|"_")*)))* {lexeme=yytext(); return Loperaciones;}
 . {return ERROR;}
