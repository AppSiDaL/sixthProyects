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
"("|")"|"{"|"}"|"["|"]" {return limitesBloques;}
"mentre"|"per"|"ripetere" {lexeme=yytext(); return ciclos;}
"se"|"interruttore" {lexeme=yytext(); return sentenciasSelectivas;}
"+"|"-"|"/"|"%"|"*"|"^" {return Loperadores;}
"scansione" {lexeme=yytext(); return Lentrada;}
"0"|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9" {return Lnumeros;}
"vero"|"falso" {lexeme=yytext(); return Lbooleanos;}
"=="|"<="|">="|"!="|"<"|">" {lexeme=yytext(); return Lcomparadores;}
"intero"|"carattere"|"corda"|"dopplo"|"booleano" {lexeme=yytext(); return LtipoDato;}
"stampa" {lexeme=yytext(); return Lsalida;}
"++"|"--" {return Linde;}
"&&"|"||" {return Land;}

{Lletras}({Lletras}|{Lnumeros}|"_")* {lexeme=yytext(); return Variable;}
"-"?{Lnumeros}+("."{Lnumeros}+)? {lexeme=yytext(); return Numero;}
({Lletras}({Lletras}|{Lnumeros}|"_")*)"="(("-"?{Lnumeros}+("."{Lnumeros}+)?)|({Lletras}({Lletras}|{Lnumeros}|"_")*))(("+"|"-"|"/"|"%"|"*"|"^")(("-"?{Lnumeros}+("."{Lnumeros}+)?)|({Lletras}({Lletras}|{Lnumeros}|"_")*)))* {lexeme=yytext(); return Loperaciones;}
 . {return ERROR;}
