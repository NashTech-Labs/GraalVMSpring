```mvn -DskipTests=true clean package
export META=src/main/resources/META-INF
mkdir -p $META 
java -agentlib:native-image-agent=config-output-dir=${META}/native-image -jar target/YOUR_APP.jar

## Check if the application is working correctly: http://localhost:8080
## then hit CTRL + C to stop the running application.

mvn -Pgraal clean package```