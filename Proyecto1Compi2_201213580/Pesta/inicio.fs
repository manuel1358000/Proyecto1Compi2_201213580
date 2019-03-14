var ventana_Inicio=crearVentana("#FFFFFF",100,100,"Inicio");
var ContBtn_Inicio=ventana_Inicio.crearContenedor(100,200,"#ffffff",falso,10,220);
ContBtn_Inicio.crearDesplegable(150,100,["hola ","15 "],150,150,"","numerico");
ContBtn_Inicio.crearCajaTexto(150,100,"Arial",14,"#ffffff",150,150,falso,falso,"hola como estan ","CHanoi1");
ContBtn_Inicio.crearTexto("times new roman",18,"#000000",450,20,verdadero,verdadero,"Bienvenido a la prueba de Logica , responda las siguientes preguntas ");
ContBtn_Inicio.crearTexto("Arial",14,"#000000",10,20,falso,falso,"Ingrese su Nombre : ");
var btnIngresar_ContBtn_Inicio=ContBtn_Inicio.crearboton("ARIAL",5,"#ffffff",25,30,cargar_hola(),"",70,50);
btnIngresar_ContBtn_Inicio.crearTexto("Arial",14,"#000000",10,50,falso,falso,"Ingreso ");
btnIngresar_ContBtn_Inicio.alclic(guardarContBtn_Inicio());

funcion cargar_hola(){
ven_hola.alcargar();
}
funcion guardarContBtn_Inicio(){
ventana_Inicio.creararraydesdearchivo();
}
btnIngresar_ContBtn_Inicio.alclic(nuevo());
btnIngresar_ContBtn_Inicio.alclic(cargar_hola());
var btnRegistrar_ContBtn_Inicio=ContBtn_Inicio.crearboton("ARIAL",5,"#ffffff",125,30,cargar_Registrar(),"",70,50);
btnRegistrar_ContBtn_Inicio.crearTexto("Arial",14,"#000000",10,50,falso,falso,"Correo ");
btnRegistrar_ContBtn_Inicio.alclic(cargar_Registrar());

funcion cargar_Registrar(){
ven_Registrar.alcargar();
}

ventana_Inicio.alcargar(hola());

ventana_Inicio.alcerrar(MensajeDespedida("Julio"+" Arango"));




