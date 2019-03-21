funcion invertirNumero (var n){
    retornar n < 10 ? n : modulo(n, 10) + invertirNumero (n / 10) * 10;
}

funcion modulo(var n, var p){
    retornar n < p ? n : modulo( n - p, p);
}


imprimir(invertirnumero(400));
