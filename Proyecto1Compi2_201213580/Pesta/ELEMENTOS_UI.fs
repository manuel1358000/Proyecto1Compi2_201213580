var ventana_Inicio=crearVentana("#ffffff",800,800,"Inicio");
var ContBtn_Inicio=ventana_Inicio.crearContenedor(800,800,"#ff12da",falso,0,0);
ContBtn_Inicio.crearCajaTexto(30,400,"Arial",14,"#000000",0,400,falso,falso,"hola como estan ","CHanoi1");
ContBtn_Inicio.crearTexto("times new roman",18,"#000000",450,20,verdadero,verdadero,"Bienvenido a la prueba de Logica , responda las siguientes preguntas ");
ContBtn_Inicio.crearTexto("Arial",14,"#000000",10,20,falso,falso,"Ingrese su Nombre : ");
var btnIngresar_ContBtn_Inicio=ContBtn_Inicio.crearboton("ARIAL",5,"#ffffff",25,30,cargar_hola(),"",70,50);
btnIngresar_ContBtn_Inicio.crearTexto("Arial",14,"#000000",10,50,falso,falso,"Ingreso ");
ContBtn_Inicio.crearControlNumerico(150,100,100,0,150,150,10,"numerico");
ContBtn_Inicio.crearDesplegable(25,200,["hola ","15 "],0,100,"","numerico");




































