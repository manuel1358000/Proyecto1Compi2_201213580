funcion modulo(var n, var p){
    retornar n < p ? n : modulo( n - p, p);
}

funcion sacar_mcd(var a, var b) {
    retornar b == 0 ? a : sacar_mcd(b, modulo(a , b));
}

funcion VerMCD(var num, var p){
    Imprimir("El numero MCD de " + num + " a la " + p + " es " + sacar_mcd(num, p));
}

vermcd(10,40);














