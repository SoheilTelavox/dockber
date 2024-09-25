FROM maven:3.9.8-eclipse-temurin-22-alpine

WORKDIR /app

COPY . .

RUN mvn install

EXPOSE 8080

CMD mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.datasource.url=${DB_URL} -Dspring.datasource.username=${DB_USERNAME} -Dspring.datasource.password=${DB_PASSWORD} -Dspring.profiles.active=${PROFILE}"