FROM java:8
COPY /var/lib/jenkins/workspace/SavingAccountDemo/saving-account/target/saving-account-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "saving-account-0.0.1-SNAPSHOT.jar"]
