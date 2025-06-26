FROM amazoncorretto:17

WORKDIR /app

# Copiar el JAR
COPY target/*.jar backend.jar

# Copiar también los datos
COPY data/datos.json data/datos.json


EXPOSE 8080

ENTRYPOINT ["java", "-jar", "backend.jar"]
