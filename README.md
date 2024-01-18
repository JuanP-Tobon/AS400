# **AS400**

## Introduction
In this automation we want to make the connection with AS400 and execute the automation both through the user interface
and by hitting the database directly.

## Pre requirements 
- Java version 11, JDK (environment variables configured).
- Eclipse IDE or IntelliJ IDEA (version 2018.3 or higher).
- Gradle version 8.2.1 or higher (environment variables configured).
- Cucumber for Java Plugin (updated version).
- Gherkin Plugin (updated version).
- Devco Library connection.

## Installation 
- To clone this repository locally, the following command must be run: 
```git clone https://github.com/JuanP-Tobon/AS400.git``` 
- Import the project from Eclipse or IntelliJ IDE under the structure of an existing Gradle project. 
- Configure JRE System Library with JavaSE-11.

## Compile the project and generate Wrapper 
- To build the project you must run the command:
```gradle clean build -x test```
- To generate the project wrapper files, you must run the command:
```gradle wrapper --gradle-distribution-url https\://services.gradle.org/distributions/gradle-8.2-bin.zip```

## Api testing 
Automation runs through the Serenity Rest library

## Project structure 

The project is based on the Web application, in the repo we will find the automations of the page:
- FATCA & CRS

Within each automation project is the folder structure like this:

* ```src/main/java/```
``` 


+ interactions
    Classes that perform low-level actions, such as change tab in browser, reload browser, among others.

+ questions
    Classes with which values are obtained and then verified in the StepDefinitions (asserts).

+ tasks
    Classes that perform high-level actions, such as login in the application, enter data into a form, etc.

```

* ```src/test/java/```
```
+ runners
    Classes to run the automations with the scenarios indicated in the equivalents Features.

+ stepdefinitions
    Classes that allow the translation of the Gherkin language used in the Features into machine language, thus they make possible the execution of automation.
    There is a general Step Definitions class that contains the configuration and steps that are repeated in the other Step Definitions, therefore the General inherits to the others.
 ```

* ```src/test/resources```
```
+ features
    The project features are found.

+ serenity.conf
    File, which uses the Typesafe Config notation. used to configure the project.

```

## Building 
Automation was developed with:
 - BDD - Development strategy
 - Screenplay pattern - Design pattern that applies SOLID principles
 - Gradle - Dependency manager
 - Cucumber - Framework to automate BDD tests
 - Serenity BDD - Framework, Open source library for report generation
 - Gherkin - Business-readable domain specific language (DSL)

## Versioning 
Git was used for version control.

## Command for execution 
The project can be executed from the console with the following command:
```gradle clean test --info```

