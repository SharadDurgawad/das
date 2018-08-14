FROM java:8
RUN echo "Current Directory: $PWD"
COPY saving-account/target/saving-account-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "saving-account-0.0.1-SNAPSHOT.jar"]
EXPOSE 8181
