package Analizadores.GramaticaGDATO;
import java.util.LinkedList;
import java_cup.runtime.*;
import Auxiliares.Errores;
%%
%{

%}
//victor con don alejandro catalan
%public
%class lexicoGDATO
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
NUMERO=[0-9]
NUMERO_COMPLETO=({NUMERO})({NUMERO})*
NUMERO_DECIMAL=({NUMERO})({NUMERO})*["."]({NUMERO})({NUMERO})*
LETRA=[a-zA-Z]
ID=({LETRA}|["_"])({LETRA}|{NUMERO}|["_"])*
CADENA="\""~"\""
%%
//SIMBOLOS DEL LENGUAJE
<YYINITIAL> "/" { return new Symbol(simbologdato.div, yyline, yycolumn,yytext());}
<YYINITIAL> ">" { return new Symbol(simbologdato.cierra, yyline, yycolumn,yytext());}
<YYINITIAL> "<" { return new Symbol(simbologdato.abre, yyline, yycolumn,yytext());}

//PALABRAS RESERVADAS
<YYINITIAL> "principal" { return new Symbol(simbologdato.principal, yyline, yycolumn,yytext());}
<YYINITIAL> "lista" { return new Symbol(simbologdato.lista, yyline, yycolumn,yytext());}

//DEFINICION VALORES IMPLICITOS
<YYINITIAL> {NUMERO_DECIMAL} { return new Symbol(simbologdato.valor_numero_decimal, yyline, yycolumn,yytext());}
<YYINITIAL> {NUMERO_COMPLETO} { return new Symbol(simbologdato.valor_numero_completo, yyline, yycolumn,yytext());}
<YYINITIAL> {ID} { return new Symbol(simbologdato.valor_id, yyline, yycolumn,yytext());}
<YYINITIAL> {CADENA} { return new Symbol(simbologdato.valor_cadena, yyline, yycolumn,yytext());}


[ \t\r\n\f EOF]
{ /* ignore white space. */ }
.   {
        System.out.println("Linea: " + (yyline+1) + " Columna: " + (yycolumn+1) + " - Error Lexico en: " + yytext());
        //id,archivo,tipo,descripcion,acciones,linea,columna,aux
         Errores errores=new Errores("Lexico","Caracter no reconocido "+yytext(),yyline+1,yycolumn+1);
         proyecto1compi2_201213580.Proyecto1Compi2_201213580.errores_gdato.add(errores);
    }