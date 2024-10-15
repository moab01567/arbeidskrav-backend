Arbeidskrav
Your assignment is to create a rest api for tracking bicycle inventory using Java and Spring Boot.  The requirements are as follows:

Create a Spring Boot Application using the Spring Web module.

Create a controller for accepting and responding to requests, with a root url of “/api/bicycle”

Create the following endpoints:

Getting a list of all bicycles
Getting a list of in-stock bicycles
Getting a single bicycle by id
Posting a new bicycle
Deleting a bicycle by id
The controller should map incoming payloads to the Bicycle object.

The bicycle object should include an id, a name, color, a model (make up any model format you like here, “BIKE-01” or “PNGG22” or whatever), how many are currently in-stock, and a manufacturer.

The manufacturer should be a class, which includes an id, a website, a phone number, and a name.

There should be sample data for 50 bicycles, created using Java Faker.

The arbeidskrav should be delivered on Canvas as a zip file.  You MUST do “mvn clean install” prior to creating the zip file, the /target directory MUST NOT BE INCLUDED in the zip.

This is an individual arbeidskrav, Due 10.00 on November 1st, 2024

