## libmanager



<br>**Prerequisites**<br>
jdk 8<br> 
 Maven



<br>**Building**<br>
*All below commands should be executed from root directory of project:<br>*
` e.g.`<br>`C:\Users\HP\IdeaProjects\libmanager`
<br>
<br>
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

*In case of using source json: `src/test/resources/testSource.json` you can check above endpoints using prepared postman* 
*[collection](../master/src/test/resources/LibManagerTestRequests.postman_collection.json)* 
(`\src\test\resources\LibManagerTestRequests.postman_collection.json`)<br>
*Swagger is also enabled and can be reached under link:* *[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)*



<br>**Some design choices and assumptions**<br>
* I assume that source file will be valid Json file.
* I've considered use of database, but decided that even h2 would be overkill for this set of requirements (although ratings turned out to be more tricky than expected and would be done easier using SQL query).
* Whole logic is tested, low percentage of coverage is caused by methods generated by lombok. LibraryManager methods are mainly tested in controller tests.
* Unix timestamp can't be used for PublishedDate as - there are dates before 1970, and this format seems quit unfitting for publication date. String will be used instead due to various precisions and formats of dates in source file.
* In case: item in source json have both valid ISBN and id when using (/api/book/{isbn}) book won't be found by id. Reason is only one identifier is used for books, and ISDN_13 is priority one.

<br>**Technology stack**<br>
* Tomcat - embedded in Spring 
* Spring boot
* Lombok
* Swagger
* Jackson
* Junit + MockMvc
* Jsonschema2pojo (to generate source json model)