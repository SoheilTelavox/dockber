FROM maven:3.9.8-eclipse-temurin-22-alpine

WORKDIR /app

COPY . .

RUN mvn install

EXPOSE 8080

VOLUME [ "/names" ]

CMD ["mvn", "spring-boot:run"]