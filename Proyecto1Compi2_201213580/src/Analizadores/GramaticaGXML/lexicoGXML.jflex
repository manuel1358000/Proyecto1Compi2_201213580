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
%char 
%ignorecase
%eofval{
	return null;
%eofval}
SIMBOLOS=(["."]|["@"]|["#"]|["$"]|["%"])
NUMERO=[0-9]
NUMERO_COMPLETO=(["-"])?({NUMERO})({NUMERO})*
LETRA=[a-zA-Z]
ID=({LETRA})({LETRA}|{NUMERO}|["_"])*
COMENTARIO_SIMPLE =("##".*\r\n)|("##".*\n)|("##".*\r)
COMENTARIO_MULTIPLE ="#$""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"$#"
PATH={LETRA}[":"]["\\"]({ID}|["\\"])*["."]["g"]["x"]["m"]["l"]
PATH2=["/"]({ID}|["\\"])*["."]["g"]["x"]["m"]["l"] 
CADENA="\""~"\""
%%
//DEFINICION DE ETIQUETAS LENGUAJE GXML
<YYINITIAL> "importar" { return new Symbol(simbolo.e_importar, yyline, yycolumn,yytext());}
<YYINITIAL> "ventana" { return new Symbol(simbolo.e_ventana, yyline, yycolumn,yytext());}
<YYINITIAL> "contenedor" { return new Symbol(simbolo.e_contenedor, yyline, yycolumn,yytext());}
<YYINITIAL> "texto" { return new Symbol(simbolo.e_texto, yyline, yycolumn,yytext());}
<YYINITIAL> "control" { return new Symbol(simbolo.e_control, yyline, yycolumn,yytext());}
<YYINITIAL> "defecto" { return new Symbol(simbolo.e_defecto, yyline, yycolumn,yytext());}
<YYINITIAL> "listadatos" { return new Symbol(simbolo.e_listadatos, yyline, yycolumn,yytext());}
<YYINITIAL> "dato" { return new Symbol(simbolo.e_dato, yyline, yycolumn,yytext());}
<YYINITIAL> "multimedia" { return new Symbol(simbolo.e_multimedia, yyline, yycolumn,yytext());}
<YYINITIAL> "boton" { return new Symbol(simbolo.e_boton, yyline, yycolumn,yytext());}
<YYINITIAL> "enviar" { return new Symbol(simbolo.e_enviar, yyline, yycolumn,yytext());}



//ELEMENTOS DE LAS ETIQUETAS GXML

<YYINITIAL> "id" { return new Symbol(simbolo.id, yyline, yycolumn,yytext());}
<YYINITIAL> "tipo" { return new Symbol(simbolo.tipo, yyline, yycolumn,yytext());}
<YYINITIAL> "color" { return new Symbol(simbolo.color, yyline, yycolumn,yytext());}
<YYINITIAL> "x" { return new Symbol(simbolo.x, yyline, yycolumn,yytext());}
<YYINITIAL> "y" { return new Symbol(simbolo.y, yyline, yycolumn,yytext());}
<YYINITIAL> "alto" { return new Symbol(simbolo.alto, yyline, yycolumn,yytext());}
<YYINITIAL> "ancho" { return new Symbol(simbolo.ancho, yyline, yycolumn,yytext());}
<YYINITIAL> "borde" { return new Symbol(simbolo.borde, yyline, yycolumn,yytext());}
<YYINITIAL> "nombre" { return new Symbol(simbolo.nombre, yyline, yycolumn,yytext());}
<YYINITIAL> "fuente" { return new Symbol(simbolo.fuente, yyline, yycolumn,yytext());}
<YYINITIAL> "tam" { return new Symbol(simbolo.tam, yyline, yycolumn,yytext());}
<YYINITIAL> "negrita" { return new Symbol(simbolo.negrita, yyline, yycolumn,yytext());}
<YYINITIAL> "cursiva" { return new Symbol(simbolo.cursiva, yyline, yycolumn,yytext());}
<YYINITIAL> "maximo" { return new Symbol(simbolo.maximo, yyline, yycolumn,yytext());}
<YYINITIAL> "minimo" { return new Symbol(simbolo.minimo, yyline, yycolumn,yytext());}
<YYINITIAL> "path" { return new Symbol(simbolo.path, yyline, yycolumn,yytext());}
<YYINITIAL> "auto-reproduccion" { return new Symbol(simbolo.auto_reproduccion, yyline, yycolumn,yytext());}
<YYINITIAL> "principal" { return new Symbol(simbolo.principal, yyline, yycolumn,yytext());}
<YYINITIAL> "secundaria" { return new Symbol(simbolo.secundaria, yyline, yycolumn,yytext());}
<YYINITIAL> "accion" { return new Symbol(simbolo.accion, yyline, yycolumn,yytext());}
<YYINITIAL> "accioninicial" { return new Symbol(simbolo.accioninicial, yyline, yycolumn,yytext());}
<YYINITIAL> "accionfinal" { return new Symbol(simbolo.accionfinal, yyline, yycolumn,yytext());}
<YYINITIAL> "referencia" { return new Symbol(simbolo.referencia, yyline, yycolumn,yytext());}
<YYINITIAL> "musica" { return new Symbol(simbolo.musica, yyline, yycolumn,yytext());}
<YYINITIAL> "video" { return new Symbol(simbolo.video, yyline, yycolumn,yytext());}
<YYINITIAL> "imagen" { return new Symbol(simbolo.imagen, yyline, yycolumn,yytext());}

//DEFINICION DE SIGNOS DEL LENGUAJE GXML
<YYINITIAL> "<" { return new Symbol(simbolo.abre, yyline, yycolumn,yytext());}
<YYINITIAL> ">" { return new Symbol(simbolo.cierra, yyline, yycolumn,yytext());}
<YYINITIAL> "/" { return new Symbol(simbolo.div, yyline, yycolumn,yytext());}
<YYINITIAL> "=" { return new Symbol(simbolo.igual, yyline, yycolumn,yytext());}
<YYINITIAL> "\"" { return new Symbol(simbolo.comilladoble, yyline, yycolumn,yytext());}
<YYINITIAL> "{" { return new Symbol(simbolo.llavea, yyline, yycolumn,yytext());}
<YYINITIAL> "}" { return new Symbol(simbolo.llavec, yyline, yycolumn,yytext());}
<YYINITIAL> "(" { return new Symbol(simbolo.parena, yyline, yycolumn,yytext());}
<YYINITIAL> ")" { return new Symbol(simbolo.parenc, yyline, yycolumn,yytext());}
<YYINITIAL> "," { return new Symbol(simbolo.coma, yyline, yycolumn,yytext());}
<YYINITIAL> "+" { return new Symbol(simbolo.mas, yyline, yycolumn,yytext());}
<YYINITIAL> "-" { return new Symbol(simbolo.menos, yyline, yycolumn,yytext());}
<YYINITIAL> "*" { return new Symbol(simbolo.por, yyline, yycolumn,yytext());}
<YYINITIAL> "^" { return new Symbol(simbolo.potencia, yyline, yycolumn,yytext());}
<YYINITIAL> ">=" { return new Symbol(simbolo.mayorigualq, yyline, yycolumn,yytext());}
<YYINITIAL> "<=" { return new Symbol(simbolo.menorigualq, yyline, yycolumn,yytext());}
<YYINITIAL> "==" { return new Symbol(simbolo.igualigual, yyline, yycolumn,yytext());}
<YYINITIAL> "!=" { return new Symbol(simbolo.diferente, yyline, yycolumn,yytext());}
<YYINITIAL> "||" { return new Symbol(simbolo.or, yyline, yycolumn,yytext());}
<YYINITIAL> "&&" { return new Symbol(simbolo.and, yyline, yycolumn,yytext());}
<YYINITIAL> "!" { return new Symbol(simbolo.not, yyline, yycolumn,yytext());}



//DEFINICION VALORES IMPLICITOS

<YYINITIAL> "verdadero" { return new Symbol(simbolo.valor_verdadero, yyline, yycolumn,yytext());}
<YYINITIAL> "falso" { return new Symbol(simbolo.valor_falso, yyline, yycolumn,yytext());}
<YYINITIAL> {NUMERO_COMPLETO} { return new Symbol(simbolo.valor_numero_completo, yyline, yycolumn,yytext());}
<YYINITIAL> {ID} { return new Symbol(simbolo.valor_id, yyline, yycolumn,yytext());}
<YYINITIAL> {PATH} { return new Symbol(simbolo.valor_path, yyline, yycolumn,yytext());}
<YYINITIAL> {PATH2} { return new Symbol(simbolo.valor_path2, yyline, yycolumn,yytext());}
<YYINITIAL> {CADENA} { return new Symbol(simbolo.valor_cadena, yyline, yycolumn,yytext());}
<YYINITIAL> {SIMBOLOS} { return new Symbol(simbolo.valor_simbolo, yyline, yycolumn,yytext());}
//DEFINICION DE COMENTARIOS
{COMENTARIO_MULTIPLE}
{ }
{COMENTARIO_SIMPLE}
{ }

[ \t\r\n\f EOF]
{ /* ignore white space. */ }
.   {
    System.out.println("Linea: " + (yyline+1) + " Columna: " + (yycolumn+1) + " - Error Lexico en: " + yytext());}