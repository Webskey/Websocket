FROM java:8  
COPY WebsocketChat-0.0.1-SNAPSHOT.war WebsocketChat-0.0.1-SNAPSHOT.war
WORKDIR /  
EXPOSE 8090
CMD ["java", "-jar", "WebsocketChat-0.0.1-SNAPSHOT.war"]