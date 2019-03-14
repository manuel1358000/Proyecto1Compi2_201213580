var ventana_recuperar=crearVentana("#b20909",400,800,"recuperar");
var ventana_Inicio=crearVentana("#b20909",800,800,"Inicio");
var ContBtn_Inicio=ventana_Inicio.crearContenedor(700,600,"#1e710e",falso,0,0);
ContBtn_Inicio.crearDesplegable(50,100,["hola ","15 "],100,220,"","numerico");
ContBtn_Inicio.crearCajaTexto(100,300,"Arial",14,"#000000",20,100,falso,falso,"hola como estan ","CHanoi1");
ContBtn_Inicio.crearTexto("times new roman",18,"#000000",0,0,verdadero,verdadero,"Bienvenido a la prueba de Logica , responda las siguientes preguntas ");
ContBtn_Inicio.crearTexto("Arial",14,"#000000",10,20,falso,falso,"Ingrese su Nombre : ");
var btnIngresar_ContBtn_Inicio=ContBtn_Inicio.crearboton("ARIAL",5,"#ffffff",200,300,cargar_hola(),"",50,100);
btnIngresar_ContBtn_Inicio.crearTexto("Arial",14,"#000000",100,50,falso,falso,"Ingreso ");
btnIngresar_ContBtn_Inicio.alclic(guardarContBtn_Inicio());


funcion cargar_hola(){
	imprimir("cargar_hola");
	//ven_hola.alcargar();
}

funcion guardarContBtn_Inicio(){
	imprimir("creararraydesdearchivo");
	//ventana_Inicio.creararraydesdearchivo();
}

btnIngresar_ContBtn_Inicio.alclic(nuevo());
btnIngresar_ContBtn_Inicio.alclic(cargar_hola());
var btnRegistrar_ContBtn_Inicio=ContBtn_Inicio.crearboton("ARIAL",5,"#ffffff",20,300,cargar_Registrar(),"",50,100);
btnRegistrar_ContBtn_Inicio.crearTexto("Arial",14,"#000000",10,50,falso,falso,"Correo ");
btnRegistrar_ContBtn_Inicio.alclic(cargar_Registrar());

funcion cargar_Registrar(){
	imprimir("cargar_registrar");
	//ven_Registrar.alcargar();
}

ventana_Inicio.alcargar(hola());

ventana_Inicio.alcerrar(MensajeDespedida("Julio"+" Arango"));


funcion hola(){
	imprimir("hola");
}
funcion nuevo(){
	imprimir("soy la funcion nuevo");
}





















