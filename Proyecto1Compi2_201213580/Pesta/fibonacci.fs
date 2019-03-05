funcion fibonacci (var n)
{
	si(n<0){
		imprimir("Debes ingresar un tamaño mayor o igual a 0");
		retornar -1;
	}sino si(n == 0){
		retornar 0;
	}sino si(n == 1){
		retornar 1;
	}sino{
		retornar fibonacci(n-1) + fibonacci(n-2);
	}
}
imprimir("El fibonacci de 10 es "+fibonacci(20));
