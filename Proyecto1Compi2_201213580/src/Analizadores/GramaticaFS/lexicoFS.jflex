package Analizadores.GramaticaFS;
import java.util.LinkedList;
import java_cup.runtime.*;
%%
%{
%}
//victor con don alejandro catalan
%public
%class lexicoFS
%unicode
%line
%column
%apiprivate
%cup
%caseless
%char 
%ignorecase
%eofval{
	return null;
%eofval}
SIMBOLOS=(["."]|["@"]|["#"]|["$"]|["%"])
NUMERO=[0-9]
NUMERO_COMPLETO=(["-"])?({NUMERO})({NUMERO})*
NUMERO_DECIMAL=(["-"])?({NUMERO})({NUMERO})*["."]({NUMERO})({NUMERO})
LETRA=[a-zA-Z]
ID=({LETRA}|["_"])({LETRA}|{NUMERO}|["_"])*
COMENTARIO_SIMPLE =("//".*\r\n)|("//".*\n)|("//".*\r)
COMENTARIO_MULTIPLE ="/*""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"*/"
PATH={LETRA}[":"]["\\"]({ID}|["\\"])*["."]["g"]["x"]["m"]["l"]
PATH2=["/"]({ID}|["\\"])*["."]["g"]["x"]["m"]["l"] 
CADENA="\""~"\""
%%
//definicion de simbolos del lenguaje
<YYINITIAL> "(" { return new Symbol(simbolofs.parena, yyline, yycolumn,yytext());}
<YYINITIAL> ")" { return new Symbol(simbolofs.parenc, yyline, yycolumn,yytext());}
<YYINITIAL> "{" { return new Symbol(simbolofs.llavea, yyline, yycolumn,yytext());}
<YYINITIAL> "}" { return new Symbol(simbolofs.llavec, yyline, yycolumn,yytext());}
<YYINITIAL> "=" { return new Symbol(simbolofs.igual, yyline, yycolumn,yytext());}
<YYINITIAL> "+" { return new Symbol(simbolofs.mas, yyline, yycolumn,yytext());}
<YYINITIAL> "-" { return new Symbol(simbolofs.menos, yyline, yycolumn,yytext());}
<YYINITIAL> "*" { return new Symbol(simbolofs.por, yyline, yycolumn,yytext());}
<YYINITIAL> "/" { return new Symbol(simbolofs.div, yyline, yycolumn,yytext());}
<YYINITIAL> "^" { return new Symbol(simbolofs.pot, yyline, yycolumn,yytext());}
<YYINITIAL> "++" { return new Symbol(simbolofs.incremento, yyline, yycolumn,yytext());}
<YYINITIAL> "--" { return new Symbol(simbolofs.decremento, yyline, yycolumn,yytext());}
<YYINITIAL> ">" { return new Symbol(simbolofs.mayorq, yyline, yycolumn,yytext());}
<YYINITIAL> "<" { return new Symbol(simbolofs.menorq, yyline, yycolumn,yytext());}
<YYINITIAL> ">=" { return new Symbol(simbolofs.mayorigualq, yyline, yycolumn,yytext());}
<YYINITIAL> "<=" { return new Symbol(simbolofs.menorigualq, yyline, yycolumn,yytext());}
<YYINITIAL> "==" { return new Symbol(simbolofs.igualigual, yyline, yycolumn,yytext());}
<YYINITIAL> "!=" { return new Symbol(simbolofs.diferente, yyline, yycolumn,yytext());}
<YYINITIAL> "&&" { return new Symbol(simbolofs.and, yyline, yycolumn,yytext());}
<YYINITIAL> "||" { return new Symbol(simbolofs.or, yyline, yycolumn,yytext());}
<YYINITIAL> "!" { return new Symbol(simbolofs.not, yyline, yycolumn,yytext());}



//DEFINICION VALORES IMPLICITOS
<YYINITIAL> "nulo" { return new Symbol(simbolofs.valor_nulo, yyline, yycolumn,yytext());}
<YYINITIAL> {NUMERO_DECIMAL} { return new Symbol(simbolofs.valor_numero_decimal, yyline, yycolumn,yytext());}
<YYINITIAL> {NUMERO_COMPLETO} { return new Symbol(simbolofs.valor_numero_completo, yyline, yycolumn,yytext());}
<YYINITIAL> {ID} { return new Symbol(simbolofs.valor_id, yyline, yycolumn,yytext());}
<YYINITIAL> {PATH} { return new Symbol(simbolofs.valor_path, yyline, yycolumn,yytext());}
<YYINITIAL> {PATH2} { return new Symbol(simbolofs.valor_path2, yyline, yycolumn,yytext());}
<YYINITIAL> {CADENA} { return new Symbol(simbolofs.valor_cadena, yyline, yycolumn,yytext());}
<YYINITIAL> {SIMBOLOS} { return new Symbol(simbolofs.valor_simbolo, yyline, yycolumn,yytext());}

//DEFINICION DE COMENTARIOS
{COMENTARIO_MULTIPLE}
{ }
{COMENTARIO_SIMPLE}
{ }

[ \t\r\n\f EOF]
{ /* ignore white space. */ }
.   {
    System.out.println("Linea: " + (yyline+1) + " Columna: " + (yycolumn+1) + " - Error Lexico en: " + yytext());}