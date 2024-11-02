FROM jelastic/maven:3.9.5-openjdk-21 AS build
copy .. 
RUN mvn clean package -DskipTests

From openjdk:21-slim
COPY --from=build /target/SpaceStore-0.0.1-SNAPSHOT.jar SpaceStore.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","SPaceStore.jar"]