# Etapa de construcción
FROM maven:3.9.9-amazoncorretto-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY . .
RUN mvn clean install -Dmaven.test.skip=true

# Etapa final
FROM amazoncorretto:17-alpine-jdk	
WORKDIR /app
COPY --from=builder /app/target/familibro-*.jar ./familibro.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "familibro.jar"]
