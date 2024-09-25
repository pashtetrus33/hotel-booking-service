FROM maven:3.8.1-openjdk-17-slim AS build

# Установите рабочую директорию
WORKDIR /app

# Копируйте pom.xml и src
COPY pom.xml ./
COPY src ./src

# Соберите проект
RUN mvn clean package -DskipTests=true

# Теперь используем OpenJDK для конечного образа
FROM openjdk:17-jdk-slim

WORKDIR /app

# Копируем jar файл из этапа сборки
COPY --from=build /app/target/hotel-booking-service-0.0.1-SNAPSHOT.jar app.jar

# Запустите приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
