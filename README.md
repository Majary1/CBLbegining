# Readme

## Requirements

You need a JDK to run the project. 
It uses an instance `main` method, so use **JDK 25** (the version the project was built with). 
The SQLite library (`sqlite-jdbc-3.53.4.0.jar`) is included in `src/AddFiles` and must be on the classpath. 
No other installation is needed.

## How to run

**Important:** start the application from the project root folder, the folder that contains `src`. The images and the database are loaded through relative paths 
such as `src/AddFiles/assets/room.png`, so starting from another folder makes the app fail to find them.

In IntelliJ IDEA, open the project folder, add `src/AddFiles/sqlite-jdbc-3.53.4.0.jar` as a library (File > Project Structure > Libraries) if it is not there yet, and run `src/Main.java`. 
The working directory of the run configuration must be the project root, which is the default.

**Important:** if the database does not work accurately it might be due to windows blocking the driver on the device in this case to run the application 
the smart app control should be turned off. After that the app should work as intended. 
