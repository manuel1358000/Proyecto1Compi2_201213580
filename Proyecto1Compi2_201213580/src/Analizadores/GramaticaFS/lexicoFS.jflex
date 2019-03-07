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
NUMERO_COMPLETO=({NUMERO})({NUMERO})*
NUMERO_DECIMAL=({NUMERO})({NUMERO})*["."]({NUMERO})({NUMERO})*
LETRA=[a-zA-Z]
ID=({LETRA}|["_"])({LETRA}|{NUMERO}|["_"])*
COMENTARIO_SIMPLE =("//".*\r\n)|("//".*\n)|("//".*\r)
COMENTARIO_MULTIPLE ="/*""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"*/"
PATH=["\""]{LETRA}[":"]["\\"]({ID}|["\\"])*["."]["f"]["s"]["\""]
PATH2=["\""](["/"]({ID}|["\\"])*["."]["f"]["s"])["\""] 
CADENA="\""~"\""
PUNTO=["."]
%%
//definicion de simbolos del lenguaje
<YYINITIAL> "." { return new Symbol(simbolofs.pto, yyline, yycolumn,yytext());}
<YYINITIAL> ":" { return new Symbol(simbolofs.dospuntos, yyline, yycolumn,yytext());}
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
<YYINITIAL> ">" { return new Symbol(simbolofs.mayorq, yyline, yycolumn,yytext());}
<YYINITIAL> "<" { return new Symbol(simbolofs.menorq, yyline, yycolumn,yytext());}
<YYINITIAL> ">=" { return new Symbol(simbolofs.mayorigualq, yyline, yycolumn,yytext());}
<YYINITIAL> "<=" { return new Symbol(simbolofs.menorigualq, yyline, yycolumn,yytext());}
<YYINITIAL> "==" { return new Symbol(simbolofs.igualigual, yyline, yycolumn,yytext());}
<YYINITIAL> "!=" { return new Symbol(simbolofs.diferente, yyline, yycolumn,yytext());}
<YYINITIAL> "&&" { return new Symbol(simbolofs.and, yyline, yycolumn,yytext());}
<YYINITIAL> "||" { return new Symbol(simbolofs.or, yyline, yycolumn,yytext());}
<YYINITIAL> "!" { return new Symbol(simbolofs.not, yyline, yycolumn,yytext());}
<YYINITIAL> "," { return new Symbol(simbolofs.coma, yyline, yycolumn,yytext());}
<YYINITIAL> ";" { return new Symbol(simbolofs.pyc, yyline, yycolumn,yytext());}
<YYINITIAL> "[" { return new Symbol(simbolofs.corchea, yyline, yycolumn,yytext());}
<YYINITIAL> "]" { return new Symbol(simbolofs.corchec, yyline, yycolumn,yytext());}
<YYINITIAL> "--" { return new Symbol(simbolofs.decremental, yyline, yycolumn,yytext());}
<YYINITIAL> "++" { return new Symbol(simbolofs.incremental, yyline, yycolumn,yytext());}

//DEFINICION DE PALABRAS RESERVADAS
<YYINITIAL> "var" { return new Symbol(simbolofs.var, yyline, yycolumn,yytext());}
<YYINITIAL> "descendente" { return new Symbol(simbolofs.descendente, yyline, yycolumn,yytext());}
<YYINITIAL> "ascendente" { return new Symbol(simbolofs.ascendente, yyline, yycolumn,yytext());}
<YYINITIAL> "invertir" { return new Symbol(simbolofs.invertir, yyline, yycolumn,yytext());}
<YYINITIAL> "maximo" { return new Symbol(simbolofs.maximo, yyline, yycolumn,yytext());}
<YYINITIAL> "minimo" { return new Symbol(simbolofs.minimo, yyline, yycolumn,yytext());}
<YYINITIAL> "filtrar" { return new Symbol(simbolofs.filtrar, yyline, yycolumn,yytext());}
<YYINITIAL> "buscar" { return new Symbol(simbolofs.buscar, yyline, yycolumn,yytext());}
<YYINITIAL> "map" { return new Symbol(simbolofs.map, yyline, yycolumn,yytext());}
<YYINITIAL> "reduce" { return new Symbol(simbolofs.reduce, yyline, yycolumn,yytext());}
<YYINITIAL> "todos" { return new Symbol(simbolofs.todos, yyline, yycolumn,yytext());}
<YYINITIAL> "alguno" { return new Symbol(simbolofs.alguno, yyline, yycolumn,yytext());}
<YYINITIAL> "imprimir" { return new Symbol(simbolofs.imprimir, yyline, yycolumn,yytext());}
<YYINITIAL> "importar" { return new Symbol(simbolofs.importar, yyline, yycolumn,yytext());}
<YYINITIAL> "selecciona" { return new Symbol(simbolofs.selecciona, yyline, yycolumn,yytext());}
<YYINITIAL> "caso" { return new Symbol(simbolofs.caso, yyline, yycolumn,yytext());}
<YYINITIAL> "defecto" { return new Symbol(simbolofs.defecto, yyline, yycolumn,yytext());}
<YYINITIAL> "detener" { return new Symbol(simbolofs.detener, yyline, yycolumn,yytext());}
<YYINITIAL> "retornar" { return new Symbol(simbolofs.retornar, yyline, yycolumn,yytext());}
<YYINITIAL> "?" { return new Symbol(simbolofs.signoi, yyline, yycolumn,yytext());}
<YYINITIAL> "si" { return new Symbol(simbolofs.si, yyline, yycolumn,yytext());}
<YYINITIAL> "sino" { return new Symbol(simbolofs.sino, yyline, yycolumn,yytext());}
<YYINITIAL> "funcion" { return new Symbol(simbolofs.funcion, yyline, yycolumn,yytext());}




//DEFINICION VALORES IMPLICITOS
<YYINITIAL> "nulo" { return new Symbol(simbolofs.valor_nulo, yyline, yycolumn,yytext());}
<YYINITIAL> "verdadero" { return new Symbol(simbolofs.valor_verdadero, yyline, yycolumn,yytext());}
<YYINITIAL> "falso" { return new Symbol(simbolofs.valor_falso, yyline, yycolumn,yytext());}
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