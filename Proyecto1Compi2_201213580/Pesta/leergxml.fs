
funcion principal(){
	var ne;
	si(1==1){
		var hola;
		hola=leergxml("/inicio.gxml");
		var nuevo=hola.obtenerporetiqueta("ventana");
		var tipo=nuevo[0];
		ne=tipo.id;
	}
	
	retornar ne;	
}
imprimir(principal());












































































