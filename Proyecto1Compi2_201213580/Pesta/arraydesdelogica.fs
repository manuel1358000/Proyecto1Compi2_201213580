funcion ReporteLogico(){
	var contenido = CrearArrayDesdeArchivo("VentanaLogica.gdato");
	Imprimir("Imprimiendo nombres de los estudiantes que saben par e impar"); 
	var concatenacion = contenido.map(EstudiantesParidad).Reduce(ObtencionParidad);
	imprimir(concatenacion);
	imprimir("reporte logico");
}
funcion EstudiantesParidad(var item){
	Si(item.CTPar == "Par" && item.CTImpar == "Impar"){
		retornar item.CTNombre + "  ";
	}sino{
		retornar "";
	}
	imprimir("reporte estudiantes paridad");
}
funcion ObtencionParidad(var concatenado, var item){
	retornar concatenado + item;
}

reportelogico();
















