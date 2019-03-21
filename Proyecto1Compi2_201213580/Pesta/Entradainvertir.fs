funcion invertido (var n){
	si(n<10){
		retornar n;
	}sino{
		retornar modulo(n,10)+invertido(n/10)*10;
	}
}
funcion VerInvertido(var num){
    Imprimir("El numero invertido de " + num + " es " + invertido(num));
}
funcion modulo(var n, var p){
    retornar n < p ? n : modulo( n - p, p);
}


verinvertido(20);







