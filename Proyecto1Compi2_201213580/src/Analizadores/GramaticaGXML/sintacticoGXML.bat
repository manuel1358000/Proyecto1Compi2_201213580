SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_121\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd "C:\Users\anton\Desktop\U\PrimerSemestre2019\Laboratorio\Proyecto1Compi2_201213580\Proyecto1Compi2_201213580\src\Analizadores\GramaticaGXML"
java -jar c:\Fuentes\java-cup-11a.jar -parser sintacticoGXML -symbols simbolo sintacticoGXML.cup
pause