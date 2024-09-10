#!/bin/bash

# Directorios de salida para compilados
OUT_DIR="output"
EAR_DIR="EarContent"
WEB_OUT_DIR="$OUT_DIR/web"
EJB_OUT_DIR="$OUT_DIR/ejb"
META_INF_DIR="$EAR_DIR/META-INF"

# Limpiar directorios de compilación anteriores
rm -rf $OUT_DIR $EAR_DIR
mkdir -p $WEB_OUT_DIR $EJB_OUT_DIR $META_INF_DIR

# Compilar archivos Java del módulo EJB
echo "Compilando módulo EJB..."
javac -d $EJB_OUT_DIR -cp "lib/*" $(find TFMEJB/src -name "*.java")

# Crear el archivo JAR del módulo EJB
echo "Empaquetando EJB en JAR..."
jar -cvf $EAR_DIR/TFMEJB.jar -C $EJB_OUT_DIR .

# Compilar archivos Java del módulo Web
echo "Compilando módulo Web..."
javac -d $WEB_OUT_DIR/WEB-INF/classes -cp "lib/*" $(find TFMWeb/src -name "*.java")

# Copiar recursos web al directorio de salida
echo "Copiando archivos Web..."
cp -r TFMWeb/src/main/webapp/* $WEB_OUT_DIR/

# Crear el archivo WAR del módulo Web
echo "Empaquetando módulo Web en WAR..."
jar -cvf $EAR_DIR/TFMWeb.war -C $WEB_OUT_DIR .

# Copiar el descriptor de despliegue si existe
if [ -f TFM/META-INF/application.xml ]; then
    echo "Copiando descriptor de despliegue..."
    cp TFM/META-INF/application.xml $META_INF_DIR/
fi

# Empaquetar los módulos EJB y Web en el archivo EAR
echo "Creando archivo EAR..."
jar -cvf TFMApp.ear -C $EAR_DIR .

echo "Compilación y empaquetado completados."
