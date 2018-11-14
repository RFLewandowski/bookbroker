*All below commands should be executed from root directory of project:<br>*
` e.g.`<br>`C:\Users\HP\IdeaProjects\libmanager`


<br>**Building**<br>
Set path to source json file location in:<br>
`\src\main\resources\application.properties`<br>
You need to have access to folder containing source file, and it need to be valid json file. <br>
To build the app use following command:<br>
`mvn clean package`<br>

<br>**Running**<br>
After building the app run following command to start it:<br>
`mvn spring-boot:run`

<br>**Access**<br>
After running app below urls will be accessible:<br>
`http://localhost:8080/api/book/{isbn}`<br>
`http://localhost:8080/category/{categoryName}/books`<br>
`http://localhost:8080/api/rating `<br>

*You can check above endpoints using prepared postman*
*[collection](../master/src/test/resources/LibManagerTestRequests.postman_collection.json)*
(`\src\test\resources\LibManagerTestRequests.postman_collection.json`)<br>
*Swagger is also enabled and can be reached under link:* *[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)*

*For more details please check* *[README](../master/README.md)*