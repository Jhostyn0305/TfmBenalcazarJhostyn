#!/bin/bash

# Directorio de salida para compilados
OUT_DIR="output"
EAR_DIR="ear_content"

# Limpiar directorios de compilación anteriores
rm -rf $OUT_DIR $EAR_DIR
mkdir -p $OUT_DIR $EAR_DIR

# Compilar archivos Java
javac -d $OUT_DIR -cp "lib/*" $(find TFM/src -name "*.java")
javac -d $OUT_DIR -cp "lib/*" $(find TFMEJB/src -name "*.java")
javac -d $OUT_DIR -cp "lib/*" $(find TFMWeb/src -name "*.java")

# Copiar archivos compilados a los directorios correspondientes del EAR
cp -r $OUT_DIR/* $EAR_DIR/

# Crear el archivo .ear
jar -cvf TFMApp.ear -C $EAR_DIR .

echo "Compilación y empaquetado completados."