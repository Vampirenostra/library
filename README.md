# Library

This is a small CRUD project to test my skills in Java.
Frameworks used:
  - Spring boot
  - Spring Data JPA
  - Spring MVC
  - Thymeleaf + bootstrap
 
Buid tool: Gradle
DB: MySQL
# Instalation:
1. Create a librarydb schema on your MySQL Server either using Workbench or just running a SQL script:
```sh
CREATE SCHEMA librarydb;
```
2. Import the project using IDE of your choice.
3. Open and edit application.properties file located at:
```sh
\src\main\resources\application.properties
```
4. Fill in the appropriate database connection details:
```sh
spring.datasource.url=jdbc:mysql://"ip":"port"/librarydb?verifyServerCertificate=false&useSSL=true
spring.datasource.username="username"
spring.datasource.password="password"
```
For local MySQL Server defaults would be:
localhost as ip
3306 as port

5. Select "Run Library application" and push Run.
6. The program will start on integrated Tomcat Server, so go [http:localhost:8080][Pldb].
7. On the index page you have 3 buttons:
- Create tables
- Populate tables
- Clear all Data
Push the first one to create tables in your database, and the second one to fill it with some test data.
# Primary pages description
Use nav-bar to navigate between main pages (Home, Countries, Publishers, Authors, Books) 
Each categorie has an Add botton on the top to add new Entites and a table containing all objects of the corresponding categorie with Edit and Delete buttons next to each entity.
Page Books is provided a filter on the top of the page offering a possibuility to filter books by:
- Search type: Title starts with or Title contains dropdown list
- Input field for the search String
- Order by dropdown list
- Order direction (Accending/dessending)
just choose the ones you need and push the Sear button right under the search bar.
# Create/Edit pages description
Each Create/Edit page contains a from to perform editing or creating a new entity of the corresponding type with a set of input fields and dropdowns, for book create/edit you are provided with a set of check boxes to choose one ore several authors.
Pushing the Save button will save the entity and redirect you to the page listing all the objects of the categorie.
All create/edit pages are checked for constraint violation and will react on wrong or impossible inputs showing a corresponding message under the faulty input.
