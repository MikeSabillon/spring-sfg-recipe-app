# spring-sfg-recipe-app
[![Build Status](https://travis-ci.org/MikeSabillon/spring-sfg-recipe-app.svg?branch=develop)](https://travis-ci.org/MikeSabillon/spring-sfg-recipe-app)

A project I made for the spring boot beginner to guru course in udemy. The project is about a page that contains and manages recipes. Still a WIP.

## Requirements
For building and running the application you need:

- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Maven 3](https://maven.apache.org)
- [Project Lombok](https://projectlombok.org/)

## Running the application locally
First run the following command on the project container:

	mvn clean install

This will create all the necessary modules needed to execute the project. The web module is dependent of the data module. After that you just need to go to the recipe-app-web module and execute the following command on the terminal:

	mvn spring-boot:run

Alternatively you can just go to the main class on the recipe-app-web module (org.springframework.boot.SpringApplication.Spring5RecipeAppApplication) and run it as a java project.