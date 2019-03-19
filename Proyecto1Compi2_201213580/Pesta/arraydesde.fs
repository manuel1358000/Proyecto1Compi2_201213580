funcion ReporteAritmetico(){
	var contenido = CrearArrayDesdeArchivo("VentanaAritmetica.gdato");
	var TodoCorrecto = contenido.filtrar(RevisionAritmetica).map(nombresAritmeticos).ascendente();
	//TodoCorrecto.Ascendente();
	Imprimir("Los estudiantes que ganaron la evaluacion aritmetica son:");
	Imprimir("Verificar que esten ordenados alfabeticamente");
	TodoCorrecto.map(ImprimirGanadores);
	Imprimir("Verificar que esten ordenados alfabeticamente invertido");
	TodoCorrecto.Invertir();
	TodoCorrecto.map(ImprimirGanadores);
	imprimir("reporte aritmetica");

}
funcion RevisionAritmetica(var item){
	retornar item.CPotencia == 3125 && item.CFactorial == 5040 && item.CInvertido == 743032153 && item.CFibonacci == 4181;
}
funcion nombresAritmeticos(var item){
	retornar item.CTNombre;
}
funcion ImprimirGanadores(var item){
	Imprimir(item);
}

ReporteAritmetico();







































































