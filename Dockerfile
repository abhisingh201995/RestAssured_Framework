FROM FROM openjdk:8
COPY AutomationFramework-1.0-SNAPSHOT.jar /home/AutomationFramework-1.0-SNAPSHOT.jar
COPY testng.xml /home/testng.xml
RUN java -jar /home/AutomationFramework-1.0-SNAPSHOT.jar org.testng.TestNG testng.xml