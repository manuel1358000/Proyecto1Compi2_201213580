funcion ackerman(var m,var n){
	si(m==0){
		retornar (n+1);
	}sino si(n==0){
		retornar (ackerman(m-1,1));
	}sino{
		retornar (ackerman(m-1,Ackerman(m,n-1)));
	}
}


imprimir(ackerman(3,8));











