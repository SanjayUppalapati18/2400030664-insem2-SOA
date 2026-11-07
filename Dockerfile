FROM eclipse-temurin:25-jdk AS build
WORKDIR /app
RUN apt-get update \
    && apt-get install -y --no-install-recommends maven \
    && rm -rf /var/lib/apt/lists/*
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/microservice-1.0.0.jar app.jar
CMD ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]
