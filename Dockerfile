FROM openjdk:17
EXPOSE 8080
ADD target/user.jar user.jar
ENTRYPOINT [ "java","-jar" ,"user.jar" ]