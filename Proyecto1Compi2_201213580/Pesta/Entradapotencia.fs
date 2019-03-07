funcion VerPotencia(var num, var pot){
    Imprimir("La potencia de " + num + " a la " + pot + " es " + potencia(num, pot));
}
funcion potencia(var base, var exp) {
    retornar exp == 0 ? 1 : (base * potencia(base, exp - 1));
}

verpotencia(3,8);

