git pull
mvn package -DskipTests
java -jar target/test-0.0.1-SNAPSHOT.war --spring.profiles.active=prod
