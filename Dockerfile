FROM maven:3.9.8-eclipse-temurin-22-alpine

WORKDIR /app

ARG NAMES_PATH_ARG="data.txt"

COPY . .

RUN mvn install

ENV NAMES_PATH=${NAMES_PATH_ARG}

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]