var ventana_VentanaReportes=crearVentana("#000000",755,740,"VentanaReportes");
var ContenedorReportes_VentanaReportes=ventana_VentanaReportes.crearContenedor(700,700,"#ffffff",verdadero,10,10);
var btnEvaluacion1_ContenedorReportes_VentanaReportes=ContenedorReportes_VentanaReportes.crearboton("ARIAL",14,"#ffffff",100,40,"","",75,150);
btnEvaluacion1_ContenedorReportes_VentanaReportes.crearTexto("Arial",14,"#000000",10,10,falso,falso,"Reporte Aritmeticos ");

btnEvaluacion1_ContenedorReportes_VentanaReportes.alclic(ReporteAritmetico());
var btnEvaluacion2_ContenedorReportes_VentanaReportes=ContenedorReportes_VentanaReportes.crearboton("ARIAL",14,"#ffffff",100,140,"","",75,150);
btnEvaluacion2_ContenedorReportes_VentanaReportes.crearTexto("Arial",14,"#000000",10,10,falso,falso,"Reporte Historicos ");

btnEvaluacion2_ContenedorReportes_VentanaReportes.alclic(ReporteHistorico());
var btnEvaluacion3_ContenedorReportes_VentanaReportes=ContenedorReportes_VentanaReportes.crearboton("ARIAL",14,"#ffffff",100,240,"","",75,150);
btnEvaluacion3_ContenedorReportes_VentanaReportes.crearTexto("Arial",14,"#000000",10,10,falso,falso,"Reporte Ingles ");

btnEvaluacion3_ContenedorReportes_VentanaReportes.alclic(ReporteIngles());
var btnEvaluacion4_ContenedorReportes_VentanaReportes=ContenedorReportes_VentanaReportes.crearboton("ARIAL",14,"#ffffff",100,340,"","",75,150);
btnEvaluacion4_ContenedorReportes_VentanaReportes.crearTexto("Arial",14,"#000000",10,10,falso,falso,"Reporte Logicos ");

btnEvaluacion4_ContenedorReportes_VentanaReportes.alclic(ReporteLogico());
var btnEnviar_ContenedorReportes_VentanaReportes=ContenedorReportes_VentanaReportes.crearboton("ARIAL",14,"#0000FF",100,440,"","Sin funcionalidad ",75,150);
btnEnviar_ContenedorReportes_VentanaReportes.alclic(guardarContenedorReportes_VentanaReportes());
funcion guardarContenedorReportes_VentanaReportes(){
ventana_VentanaReportes.creararraydesdearchivo();
}
btnEnviar_ContenedorReportes_VentanaReportes.alclic(EnviarSinFuncionalidad());


ventana_ventanareportes.alcargar();
