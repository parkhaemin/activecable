FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew clean build -x test

# 🔥 핵심: Gradle이 toolchain 쓰지 않게 강제
RUN ./gradlew clean build -x test --no-daemonv

EXPOSE 8080

CMD ["java", "-jar", "build/libs/mallapi-0.0.1-SNAPSHOT.jar"]