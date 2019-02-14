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
COMENTARIO_SIMPLE =("##".*\r\n)|("//".*\n)|("//".*\r)
COMENTARIO_MULTIPLE ="#$""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"$#"
PATH=["C"][":"]["\\"]({ID}|["\\"])*["."]["g"]["x"]["m"]["l"]
%%
//DEFINICION DE ETIQUETAS LENGUAJE GXML
"importar"
{ return new Symbol(simbolo.e_importar, yyline, yycolumn,yytext());}
"ventana"
{ return new Symbol(simbolo.e_ventana, yyline, yycolumn,yytext());}
"contenedor"
{ return new Symbol(simbolo.e_contenedor, yyline, yycolumn,yytext());}
"texto"
{ return new Symbol(simbolo.e_texto, yyline, yycolumn,yytext());}
"control"
{ return new Symbol(simbolo.e_control, yyline, yycolumn,yytext());}
"defecto"
{ return new Symbol(simbolo.e_defecto, yyline, yycolumn,yytext());}
"listadatos"
{ return new Symbol(simbolo.e_listadatos, yyline, yycolumn,yytext());}
"dato"
{ return new Symbol(simbolo.e_dato, yyline, yycolumn,yytext());}
"multimedia"
{ return new Symbol(simbolo.e_multimedia, yyline, yycolumn,yytext());}
"boton"
{ return new Symbol(simbolo.e_boton, yyline, yycolumn,yytext());}
"enviar"
{ return new Symbol(simbolo.e_enviar, yyline, yycolumn,yytext());}

//ELEMENTOS DE LAS ETIQUETAS GXML

"id"
{ return new Symbol(simbolo.id, yyline, yycolumn,yytext());}
"tipo"
{ return new Symbol(simbolo.tipo, yyline, yycolumn,yytext());}
"color"
{ return new Symbol(simbolo.color, yyline, yycolumn,yytext());}
"x"
{ return new Symbol(simbolo.x, yyline, yycolumn,yytext());}
"y"
{ return new Symbol(simbolo.y, yyline, yycolumn,yytext());}
"alto"
{ return new Symbol(simbolo.alto, yyline, yycolumn,yytext());}
"ancho"
{ return new Symbol(simbolo.ancho, yyline, yycolumn,yytext());}
"borde"
{ return new Symbol(simbolo.borde, yyline, yycolumn,yytext());}
"nombre"
{ return new Symbol(simbolo.nombre, yyline, yycolumn,yytext());}
"fuente"
{ return new Symbol(simbolo.fuente, yyline, yycolumn,yytext());}
"tam"
{ return new Symbol(simbolo.tam, yyline, yycolumn,yytext());}
"negrita"
{ return new Symbol(simbolo.negrita, yyline, yycolumn,yytext());}
"cursiva"
{ return new Symbol(simbolo.cursiva, yyline, yycolumn,yytext());}
"maximo"
{ return new Symbol(simbolo.maximo, yyline, yycolumn,yytext());}
"minimo"
{ return new Symbol(simbolo.minimo, yyline, yycolumn,yytext());}
"path"
{ return new Symbol(simbolo.path, yyline, yycolumn,yytext());}
"auto-reproduccion"
{ return new Symbol(simbolo.auto_reproduccion, yyline, yycolumn,yytext());}

//DEFINICION DE SIGNOS DEL LENGUAJE GXML
"<"
{ return new Symbol(simbolo.menorq, yyline, yycolumn,yytext());}
">"
{ return new Symbol(simbolo.mayorq, yyline, yycolumn,yytext());}
"/"
{ return new Symbol(simbolo.div, yyline, yycolumn,yytext());}
"="
{ return new Symbol(simbolo.igual, yyline, yycolumn,yytext());}
"\""
{ return new Symbol(simbolo.comilladoble, yyline, yycolumn,yytext());}





//DEFINICION VALORES IMPLICITOS
{NUMERO_COMPLETO}
{ return new Symbol(simbolo.valor_numero_completo, yyline, yycolumn,yytext());}
{ID}
{ return new Symbol(simbolo.valor_id, yyline, yycolumn,yytext());}
{PATH}
{ return new Symbol(simbolo.valor_path, yyline, yycolumn,yytext());}


//DEFINICION DE COMENTARIOS
{COMENTARIO_SIMPLE}
{ return new Symbol(simbolo.comentario_simple, yyline, yycolumn,yytext());}
{COMENTARIO_MULTIPLE}
{ return new Symbol(simbolo.comentario_multiple, yyline, yycolumn,yytext());}

[ \t\r\n\f EOF]
{ /* ignore white space. */ }
.   {
    System.out.println("Linea: " + (yyline+1) + " Columna: " + (yycolumn+1) + " - Error Lexico en: " + yytext());}