var ventana_VentanaPrincipal=crearVentana("#000000",1000,1000,"VentanaPrincipal");
var Contenedor1_VentanaPrincipal=ventana_VentanaPrincipal.crearContenedor(500,500,"#ffffff",verdadero,10,10);
Contenedor1_VentanaPrincipal.crearTexto("Arial",14,"#000000",10,10,verdadero,falso,"Haga clic en el siguiente boton para iniciar la evaluacion ");
var btnEvaluacion_Contenedor1_VentanaPrincipal=Contenedor1_VentanaPrincipal.crearboton("ARIAL",20,"#ffffff",60,100,cargar_VentanaAritmetica(),"",50,150);
btnEvaluacion_Contenedor1_VentanaPrincipal.crearTexto("Arial",14,"#000000",10,10,falso,falso,"Iniciar Evaluacion ");

btnEvaluacion_Contenedor1_VentanaPrincipal.alclic(Bienvenido());
btnEvaluacion_Contenedor1_VentanaPrincipal.alclic(cargar_VentanaAritmetica());

funcion cargar_VentanaAritmetica(){
ventana_VentanaAritmetica.alcargar();
}
Contenedor1_VentanaPrincipal.crearTexto("Arial",14,"#000000",10,420,falso,verdadero,"Haga clic en el siguiente boton para iniciar el area de reportes ");
var btnReportes_Contenedor1_VentanaPrincipal=Contenedor1_VentanaPrincipal.crearboton("ARIAL",14,"#ffffff",60,300,cargar_VentanaReportes(),"Iniciar Reportes ",50,150);

btnReportes_Contenedor1_VentanaPrincipal.alclic(BienvenidoReporte());
btnReportes_Contenedor1_VentanaPrincipal.alclic(cargar_VentanaReportes());

funcion cargar_VentanaReportes(){
ventana_VentanaReportes.alcargar();
}
var btnEnviar_Contenedor1_VentanaPrincipal=Contenedor1_VentanaPrincipal.crearboton("ARIAL",14,"#ffffff",60,350,"","General",50,150);
btnEnviar_Contenedor1_VentanaPrincipal.alclic(guardarContenedor1_VentanaPrincipal());
funcion guardarContenedor1_VentanaPrincipal(){
ventana_VentanaPrincipal.creararraydesdearchivo();
}
//btnEnviar_Contenedor1_VentanaPrincipal.alclic(EnviarSinFuncionalidad());
//importar("/FuncionesEvaluacion.fs");
var ventana_VentanaAritmetica=crearVentana("#2E2EFE",1000,1000,"VentanaAritmetica");
var ContenedorAritmeticas_VentanaAritmetica=ventana_VentanaAritmetica.crearContenedor(800,800,"#ffffff",verdadero,10,10);
ContenedorAritmeticas_VentanaAritmetica.crearTexto("times new roman",18,"#000000",0,20,verdadero,verdadero,"Bienvenido a la prueba de Aritmetica , responda las siguientes preguntas ");
ContenedorAritmeticas_VentanaAritmetica.crearTexto("Arial",14,"#000000",10,50,falso,falso,"Ingrese su Nombre : ");
ContenedorAritmeticas_VentanaAritmetica.crearCajaTexto(20,150,"Arial",14,"#000000",100,150,falso,falso,"Ingrese aqui su nombre ","CTNombre");
ContenedorAritmeticas_VentanaAritmetica.crearTexto("Arial",14,"#000000",10,160,falso,falso,"Ingrese la potencia de 5 a la 5 : ");
ContenedorAritmeticas_VentanaAritmetica.crearControlNumerico(50,100,5000,0,150,225,"0","CPotencia");
var btnPotencia_ContenedorAritmeticas_VentanaAritmetica=ContenedorAritmeticas_VentanaAritmetica.crearboton("ARIAL",10,"#ffffff",300,215,"","Ver Respuesta ",50,100);

btnPotencia_ContenedorAritmeticas_VentanaAritmetica.alclic(VerPotencia(5,5));
ContenedorAritmeticas_VentanaAritmetica.crearTexto("Arial",14,"#000000",10,300,falso,falso,"Ingrese el Factorial de 7 : ");
ContenedorAritmeticas_VentanaAritmetica.crearControlNumerico(50,100,6000,0,150,375,"0","CFactorial");
var btnFactorial_ContenedorAritmeticas_VentanaAritmetica=ContenedorAritmeticas_VentanaAritmetica.crearboton("ARIAL",10,"#ffffff",300,360,"","Ver Respuesta ",50,100);

btnFactorial_ContenedorAritmeticas_VentanaAritmetica.alclic(VerFactorial(7));
ContenedorAritmeticas_VentanaAritmetica.crearTexto("Arial",14,"#000000",10,450,falso,falso,"Ingrese el numero invertido de 351230347 : ");
ContenedorAritmeticas_VentanaAritmetica.crearControlNumerico(50,100,100,0,150,550,"0","CInvertido");
var btnInvertido_ContenedorAritmeticas_VentanaAritmetica=ContenedorAritmeticas_VentanaAritmetica.crearboton("ARIAL",10,"#ffffff",300,540,"","Ver Respuesta ",50,100);

btnInvertido_ContenedorAritmeticas_VentanaAritmetica.alclic(VerInvertido(351230347));
ContenedorAritmeticas_VentanaAritmetica.crearTexto("Arial",14,"#000000",10,570,falso,falso,"Ingrese el mcd de 240 , 506 con 10 : ");
ContenedorAritmeticas_VentanaAritmetica.crearControlNumerico(50,100,100,0,150,640,"0","CMCD");
var btnMCD_ContenedorAritmeticas_VentanaAritmetica=ContenedorAritmeticas_VentanaAritmetica.crearboton("ARIAL",10,"#ffffff",300,635,"","Ver Respuesta ",50,100);

btnMCD_ContenedorAritmeticas_VentanaAritmetica.alclic(VerMCD(240,506,10));
ContenedorAritmeticas_VentanaAritmetica.crearTexto("Arial",14,"#000000",10,660,falso,falso,"Ingrese el Fibonacci de 19 : ");
ContenedorAritmeticas_VentanaAritmetica.crearControlNumerico(50,100,6000,0,150,725,"0","CFibonacci");
var btnFibonacci_ContenedorAritmeticas_VentanaAritmetica=ContenedorAritmeticas_VentanaAritmetica.crearboton("ARIAL",10,"#ffffff",300,725,"","Ver Respuesta ",50,100);

btnFibonacci_ContenedorAritmeticas_VentanaAritmetica.alclic(VerFibonacci(19));
var ContEnviarAritmetica_VentanaAritmetica=ventana_VentanaAritmetica.crearContenedor(60,160,"#ADADAD",falso,100,850);
var btnEnviar_ContEnviarAritmetica_VentanaAritmetica=ContEnviarAritmetica_VentanaAritmetica.crearboton("ARIAL",20,"#ffffff",0,0,cargar_VentanaHistoria(),"Contestar ",50,150);
btnEnviar_ContEnviarAritmetica_VentanaAritmetica.alclic(guardarContEnviarAritmetica_VentanaAritmetica());

funcion cargar_VentanaHistoria(){
ventana_VentanaHistoria.alcargar();
}
funcion guardarContEnviarAritmetica_VentanaAritmetica(){
ventana_VentanaAritmetica.creararraydesdearchivo();
}
btnEnviar_ContEnviarAritmetica_VentanaAritmetica.alclic(cargar_VentanaHistoria());
var ventana_VentanaHistoria=crearVentana("#2E2EFE",1000,1000,"VentanaHistoria");
var ContenedorHistoria_VentanaHistoria=ventana_VentanaHistoria.crearContenedor(1000,1000,"#ffffff",verdadero,10,10);
ContenedorHistoria_VentanaHistoria.crearTexto("times new roman",18,"#000000",450,20,verdadero,verdadero,"Bienvenido a la prueba de Historia , responda las siguientes preguntas ");
ContenedorHistoria_VentanaHistoria.crearTexto("Arial",14,"#000000",10,20,falso,falso,"Ingrese su Nombre : ");
ContenedorHistoria_VentanaHistoria.crearCajaTexto(10,100,"Arial",14,"#ffffff",100,20,falso,falso,"Ingrese aqui su nombre ","CTNombre");
ContenedorHistoria_VentanaHistoria.crearTexto("Arial",14,"#000000",10,250,falso,falso,"Ingrese el paisaje de la foto ");
ContenedorHistoria_VentanaHistoria.crearDesplegable(50,100,["Playa ","Luna ","Selva ","Desierto ","Oceano "],150,250,"","CDPaisaje1");
ContenedorHistoria_VentanaHistoria.crearImagen("playa.jpg",300,250,400,400);
var btnPlaya_ContenedorHistoria_VentanaHistoria=ContenedorHistoria_VentanaHistoria.crearboton("ARIAL",5,"#ffffff",500,250,"","Ver Respuesta ",50,100);

btnPlaya_ContenedorHistoria_VentanaHistoria.alclic(Paisaje(10));
ContenedorHistoria_VentanaHistoria.crearTexto("Arial",14,"#000000",10,400,falso,falso,"Ingrese el paisaje de la foto ");
ContenedorHistoria_VentanaHistoria.crearDesplegable(50,100,["Playa ","Luna ","Selva ","Desierto ","Oceano "],150,400,"","CDPaisaje2");
ContenedorHistoria_VentanaHistoria.crearImagen("playa.jpg",300,400,100,100);
var btnLuna_ContenedorHistoria_VentanaHistoria=ContenedorHistoria_VentanaHistoria.crearboton("ARIAL",5,"#ffffff",500,400,"","Ver Respuesta ",50,100);

btnLuna_ContenedorHistoria_VentanaHistoria.alclic(Paisaje(20));
ContenedorHistoria_VentanaHistoria.crearTexto("Arial",14,"#000000",10,550,falso,falso,"Ingrese el paisaje de la foto ");
ContenedorHistoria_VentanaHistoria.crearDesplegable(50,100,["Playa ","Luna ","Selva ","Desierto ","Oceano "],150,550,"","CDPaisaje3");
ContenedorHistoria_VentanaHistoria.crearImagen("playa.jpg",300,550,100,100);
var btnSelva_ContenedorHistoria_VentanaHistoria=ContenedorHistoria_VentanaHistoria.crearboton("ARIAL",5,"#ffffff",500,550,"","Ver Respuesta ",50,100);

btnSelva_ContenedorHistoria_VentanaHistoria.alclic(Paisaje(30));
ContenedorHistoria_VentanaHistoria.crearTexto("Arial",14,"#000000",10,700,falso,falso,"Ingrese el paisaje de la foto ");
ContenedorHistoria_VentanaHistoria.crearDesplegable(50,100,["Playa ","Luna ","Selva ","Desierto ","Oceano "],150,700,"","CDPaisaje4");
ContenedorHistoria_VentanaHistoria.crearImagen("playa.jpg",300,700,100,100);
var btnDesierto_ContenedorHistoria_VentanaHistoria=ContenedorHistoria_VentanaHistoria.crearboton("ARIAL",5,"#ffffff",500,700,"","Ver Respuesta ",50,100);

btnDesierto_ContenedorHistoria_VentanaHistoria.alclic(Paisaje(40));
ContenedorHistoria_VentanaHistoria.crearTexto("Arial",14,"#000000",10,850,falso,falso,"Ingrese el paisaje de la foto ");
ContenedorHistoria_VentanaHistoria.crearDesplegable(50,100,["Playa ","Luna ","Selva ","Desierto ","Oceano "],150,850,"","CDPaisaje5");
ContenedorHistoria_VentanaHistoria.crearImagen("playa.jpg",300,850,100,100);
var btnOceano_ContenedorHistoria_VentanaHistoria=ContenedorHistoria_VentanaHistoria.crearboton("ARIAL",5,"#ffffff",500,850,"","Ver Respuesta ",50,100);

btnOceano_ContenedorHistoria_VentanaHistoria.alclic(Paisaje(50));
var ContEnviarHistoria_VentanaHistoria=ventana_VentanaHistoria.crearContenedor(200,200,"#ffffff",falso,10,1010);
var btnEnviar_ContEnviarHistoria_VentanaHistoria=ContEnviarHistoria_VentanaHistoria.crearboton("ARIAL",5,"#ffffff",75,30,cargar_VentanaIngles(),"Contestar ",70,40);
btnEnviar_ContEnviarHistoria_VentanaHistoria.alclic(guardarContEnviarHistoria_VentanaHistoria());

funcion cargar_VentanaIngles(){
ventana_VentanaIngles.alcargar();
}
funcion guardarContEnviarHistoria_VentanaHistoria(){
ventana_VentanaHistoria.creararraydesdearchivo();
}btnEnviar_ContEnviarHistoria_VentanaHistoria.alclic(cargar_VentanaIngles());
var ventana_VentanaIngles=crearVentana("#2E2EFE",100,100,"VentanaIngles");
var ContenedorIngles_VentanaIngles=ventana_VentanaIngles.crearContenedor(1000,1000,"#ffffff",verdadero,10,10);
ContenedorIngles_VentanaIngles.crearTexto("times new roman",18,"#000000",450,20,verdadero,verdadero,"Bienvenido a la prueba de Ingles , responda las siguientes preguntas ");
ContenedorIngles_VentanaIngles.crearTexto("Arial",14,"#000000",10,20,falso,falso,"Ingrese su Nombre : ");
ContenedorIngles_VentanaIngles.crearCajaTexto(10,100,"Arial",14,"#ffffff",100,20,falso,falso,"Ingrese aqui su nombre ","CTNombre");
//ContenedorIngles_VentanaIngles.crearReproductor("Ackermann.mp3",450,50,falso,50,100,);
ContenedorIngles_VentanaIngles.crearTexto("Arial",14,"#000000",10,250,falso,falso,"What algorithm is the audio talking about ? ");
ContenedorIngles_VentanaIngles.crearCajaTexto(50,150,"Arial",14,"#ffffff",100,250,falso,falso,"Ingrese aqui su respuesta ","CTPregunta");
var btnPregunta_ContenedorIngles_VentanaIngles=ContenedorIngles_VentanaIngles.crearboton("ARIAL",5,"#ffffff",300,250,"","Ver Respuesta ",50,100);

btnPregunta_ContenedorIngles_VentanaIngles.alclic(Pregunta("Tipo"));
ContenedorIngles_VentanaIngles.crearTexto("Arial",14,"#000000",10,350,falso,falso,"Ingrese el ackerman de 3 , 11 : ");
ContenedorIngles_VentanaIngles.crearControlNumerico(50,100,100,0,150,350,"0","CAckerman");
var btnAckerman_ContenedorIngles_VentanaIngles=ContenedorIngles_VentanaIngles.crearboton("ARIAL",5,"#ffffff",300,350,"","Ver Respuesta ",50,100);

btnAckerman_ContenedorIngles_VentanaIngles.alclic(Pregunta("Resultado"));
var ContEnviarIngles_VentanaIngles=ventana_VentanaIngles.crearContenedor(100,200,"#ffffff",falso,10,1010);
var btnEnviar_ContEnviarIngles_VentanaIngles=ContEnviarIngles_VentanaIngles.crearboton("ARIAL",5,"#ffffff",75,30,cargar_VentanaLogica(),"Contestar ",70,40);
btnEnviar_ContEnviarIngles_VentanaIngles.alclic(guardarContEnviarIngles_VentanaIngles());

funcion cargar_VentanaLogica(){
ventana_VentanaLogica.alcargar();
}
funcion guardarContEnviarIngles_VentanaIngles(){
ventana_VentanaIngles.creararraydesdearchivo();
}btnEnviar_ContEnviarIngles_VentanaIngles.alclic(cargar_VentanaLogica());
var ventana_VentanaLogica=crearVentana("#2E2EFE",100,100,"VentanaLogica");
var ContenedorLogica_VentanaLogica=ventana_VentanaLogica.crearContenedor(1000,1000,"#ffffff",verdadero,10,10);
ContenedorLogica_VentanaLogica.crearTexto("times new roman",18,"#000000",450,20,verdadero,verdadero,"Bienvenido a la prueba de Logica , responda las siguientes preguntas ");
ContenedorLogica_VentanaLogica.crearTexto("Arial",14,"#000000",10,20,falso,falso,"Ingrese su Nombre : ");
ContenedorLogica_VentanaLogica.crearCajaTexto(10,100,"Arial",14,"#ffffff",100,20,falso,falso,"Ingrese aqui su nombre ","CTNombre");
ContenedorLogica_VentanaLogica.crearTexto("Arial",14,"#000000",10,150,falso,falso,"Resuelva las torres de Hanoi con 3 discos , origen 1 , destino 3 y auxiliar 2 ");
ContenedorLogica_VentanaLogica.crearAreaTexto(150,100,"Arial",14,"#ffffff",150,150,falso,falso,"","CHanoi");
var btnHanoi_ContenedorLogica_VentanaLogica=ContenedorLogica_VentanaLogica.crearboton("ARIAL",5,"#ffffff",300,150,"","Ver Respuesta ",50,100);

btnHanoi_ContenedorLogica_VentanaLogica.alclic(hanoi(3,1,2,3));
ContenedorLogica_VentanaLogica.crearTexto("Arial",14,"#000000",10,350,falso,falso,"Ingrese el Hofstader Femenina 10 : ");
ContenedorLogica_VentanaLogica.crearCajaTexto(50,100,"Arial",14,"#ffffff",150,350,falso,falso,"","CTHF");
var btnHF_ContenedorLogica_VentanaLogica=ContenedorLogica_VentanaLogica.crearboton("ARIAL",5,"#ffffff",300,350,"","Ver Respuesta ",50,100);

btnHF_ContenedorLogica_VentanaLogica.alclic(VerFemenina());
ContenedorLogica_VentanaLogica.crearTexto("Arial",14,"#000000",10,450,falso,falso,"Ingrese el Hofstader Maculino 10 : ");
ContenedorLogica_VentanaLogica.crearCajaTexto(50,100,"Arial",14,"#ffffff",150,450,falso,falso,"","CTHM");
var btnHM_ContenedorLogica_VentanaLogica=ContenedorLogica_VentanaLogica.crearboton("ARIAL",5,"#ffffff",300,450,"","Ver Respuesta ",50,100);

btnHM_ContenedorLogica_VentanaLogica.alclic(VerMasculino());
ContenedorLogica_VentanaLogica.crearTexto("Arial",14,"#000000",10,550,falso,falso,"Ingrese si 26 es par o impar ");
ContenedorLogica_VentanaLogica.crearCajaTexto(50,100,"Arial",14,"#ffffff",150,550,falso,falso,"","CTPar");
var btnPar_ContenedorLogica_VentanaLogica=ContenedorLogica_VentanaLogica.crearboton("ARIAL",5,"#ffffff",300,550,"","Ver Respuesta ",50,100);

btnPar_ContenedorLogica_VentanaLogica.alclic(VerPar(26));
ContenedorLogica_VentanaLogica.crearTexto("Arial",14,"#000000",10,650,falso,falso,"Ingrese si 27 es par o impar ");
ContenedorLogica_VentanaLogica.crearCajaTexto(50,100,"Arial",14,"#ffffff",150,650,falso,falso,"","CTImpar");
var btnImpar_ContenedorLogica_VentanaLogica=ContenedorLogica_VentanaLogica.crearboton("ARIAL",5,"#ffffff",300,650,"","Ver Respuesta ",50,100);

btnImpar_ContenedorLogica_VentanaLogica.alclic(VerImpar(27));
var ContEnviarLogicas_VentanaLogica=ventana_VentanaLogica.crearContenedor(100,200,"#ffffff",falso,10,1010);
var btnEnviar_ContEnviarLogicas_VentanaLogica=ContEnviarLogicas_VentanaLogica.crearboton("ARIAL",5,"#ffffff",75,30,cargar_VentanaReportes(),"Contestar ",70,40);
btnEnviar_ContEnviarLogicas_VentanaLogica.alclic(guardarContEnviarLogicas_VentanaLogica());

funcion cargar_VentanaReportes(){
ventana_VentanaReportes.alcargar();
}
funcion guardarContEnviarLogicas_VentanaLogica(){
ventana_VentanaLogica.creararraydesdearchivo();
}btnEnviar_ContEnviarLogicas_VentanaLogica.alclic(cargar_VentanaReportes());
var ventana_VentanaReportes=crearVentana("#000000",100,100,"VentanaReportes");
var ContenedorReportes_VentanaReportes=ventana_VentanaReportes.crearContenedor(800,800,"#ffffff",verdadero,10,10);
var btnEvaluacion1_ContenedorReportes_VentanaReportes=ContenedorReportes_VentanaReportes.crearboton("ARIAL",5,"#ffffff",60,40,"","",50,50);
btnEvaluacion1_ContenedorReportes_VentanaReportes.crearTexto("Arial",14,"#000000",10,10,falso,falso,"Reporte Aritmeticos ");

btnEvaluacion1_ContenedorReportes_VentanaReportes.alclic(ReporteAritmetico());
var btnEvaluacion2_ContenedorReportes_VentanaReportes=ContenedorReportes_VentanaReportes.crearboton("ARIAL",5,"#ffffff",60,40,"","",50,50);
btnEvaluacion2_ContenedorReportes_VentanaReportes.crearTexto("Arial",14,"#000000",10,10,falso,falso,"Reporte Historicos ");

btnEvaluacion2_ContenedorReportes_VentanaReportes.alclic(ReporteHistorico());
var btnEvaluacion3_ContenedorReportes_VentanaReportes=ContenedorReportes_VentanaReportes.crearboton("ARIAL",5,"#ffffff",60,40,"","",50,50);
btnEvaluacion3_ContenedorReportes_VentanaReportes.crearTexto("Arial",14,"#000000",10,10,falso,falso,"Reporte Ingles ");

btnEvaluacion3_ContenedorReportes_VentanaReportes.alclic(ReporteIngles());
var btnEvaluacion4_ContenedorReportes_VentanaReportes=ContenedorReportes_VentanaReportes.crearboton("ARIAL",5,"#ffffff",60,40,"","",50,50);
btnEvaluacion4_ContenedorReportes_VentanaReportes.crearTexto("Arial",14,"#000000",10,10,falso,falso,"Reporte Logicos ");

btnEvaluacion4_ContenedorReportes_VentanaReportes.alclic(ReporteLogico());
var btnEnviar_ContenedorReportes_VentanaReportes=ContenedorReportes_VentanaReportes.crearboton("ARIAL",5,"#ffffff",60,350,"","Sin funcionalidad ",50,50);
btnEnviar_ContenedorReportes_VentanaReportes.alclic(guardarContenedorReportes_VentanaReportes());
funcion guardarContenedorReportes_VentanaReportes(){
ventana_VentanaReportes.creararraydesdearchivo();
}
btnEnviar_ContenedorReportes_VentanaReportes.alclic(EnviarSinFuncionalidad());
ventana_Ventanaprincipal.alcargar();















































