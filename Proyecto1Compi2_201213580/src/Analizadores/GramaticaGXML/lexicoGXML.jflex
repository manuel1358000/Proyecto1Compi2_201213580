package Analizadores.GramaticaGXML;
import java.util.LinkedList;
import java_cup.runtime.*;
%%
%{
%}
//victor con don alejandro catalan
%public
%class lexicoGXML
%unicode
%line
%column
%apiprivate
%cup
%caseless
%eofval{
	return null;
%eofval}
NUMERO=[0-9]
NUMERO_COMPLETO=({NUMERO})({NUMERO})*
LETRA=[a-zA-Z]
ID=({LETRA})({LETRA}|{NUMERO})*
%%
{ID}
{ return new Symbol(simbolo.id, yyline, yycolumn,yytext());}

[ \t\r\n\f EOF]
{ /* ignore white space. */ }
.   {
    System.out.println("Linea: " + (yyline+1) + " Columna: " + (yycolumn+1) + " - Error Lexico en: " + yytext());}