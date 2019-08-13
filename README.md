Employee Time Tracker
A Web based application to track employee time log activities

Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
See deployment for notes on how to deploy the project on a live system.

Prerequisites
What things you need to install the software and how to install them.

IDE - Eclipse,VS Studio Code,Spring Tool Suit,IntelliJ IDEA. 

Language- Java.

Frameworks- Spring Boot,thymeleaf.

Logging- Spring Boot SLF4j Logback.

It will sue for caputring and archiving the generated logs.

Tools- Git.

Git is a version controlling tool. 

open terminal and use below  command to clone the repository from gitgub.

git clone https://github.com/balaji-singh/employee-time-tracker.git.

Open your favorite IDE then import existed maven projects into workspace. 

        (or)

Open Your favorite IDE configure Egit then clone the repository and import this project into to workspace.


Build management- Maven.

Maven is  Dependency and Build Management.

Please check the pom.xml file various dependencies used for this application.

by using terminal mvn clean install for including testcase or mvn clean install 

mvn clean install -Dmaven.test.skip=true for skipping test.

-X for debug mode and -U for update the dependencies and -P for profiling

Containerization- Docker.

First of install Docker desktop into your machine.

If you want to pull the docker image for this application use

docker pull balajiabgs/employee-timetracker:1

TO create a Docker image you have to use docker build command by Dockerfile.

docker build -t balajiabgs/employee-timetracker:1 .

to run created Docker image with different port use -P with docker run.
and use -d for background process.

docker run -d  -p 8081:8080 balajiabgs/employee-timetracker:1


Author
Bala S Singh

