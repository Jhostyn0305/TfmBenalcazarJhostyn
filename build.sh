#!/bin/bash

# Directorios de salida para compilados
OUT_DIR="output"
EAR_DIR="EarContent"
META_INF_DIR="$EAR_DIR/META-INF"

# Limpiar directorios de compilación anteriores
rm -rf $OUT_DIR $EAR_DIR
mkdir -p $OUT_DIR/ejb $OUT_DIR/web $META_INF_DIR

# Compilar archivos Java del módulo EJB
echo "Compilando módulo EJB..."
javac -d $OUT_DIR/ejb -cp "lib/*" $(find TFMEJB/src -name "*.java")

# Crear el archivo JAR del módulo EJB
echo "Empaquetando EJB en JAR..."
jar -cvf $EAR_DIR/TFMEJB.jar -C $OUT_DIR/ejb .

# Compilar archivos Java del módulo Web
echo "Compilando módulo Web..."
javac -d $OUT_DIR/web -cp "lib/*" $(find TFMWeb/src -name "*.java")

# Copiar recursos web al directorio de salida
echo "Copiando archivos Web..."
cp -r TFMWeb/WebContent/* $OUT_DIR/web/

# Crear el archivo WAR del módulo Web
echo "Empaquetando módulo Web en WAR..."
jar -cvf $EAR_DIR/TFMWeb.war -C $OUT_DIR/web .

# Copiar el descriptor de despliegue si existe
if [ -f TFM/META-INF/application.xml ]; then
    echo "Copiando descriptor de despliegue..."
    cp TFM/META-INF/application.xml $META_INF_DIR/
fi

# Empaquetar los módulos EJB y Web en el archivo EAR
echo "Creando archivo EAR..."
jar -cvf TFMApp.ear -C $EAR_DIR .

echo "Compilación y empaquetado completados."
