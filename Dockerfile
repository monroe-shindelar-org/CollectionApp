FROM eclipse-temurin:21
LABEL authors="Monroe Shindelar (Monroeshindelar@proton.me)"
VOLUME /main-app
ADD build/libs/*.jar service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/service.jar"]