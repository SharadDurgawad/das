FROM java:8
COPY /var/lib/jenkins/workspace/BuildMavenTest/saving-account/target/saving-account-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "test-0.0.1-SNAPSHOT.jar"]
