## libmanager


*All below commands should be executed from root directory of project:<br>*
` e.g.`<br>`C:/Users/HP/IdeaProjects/libmanager`


<br>**Building**<br>
Set patch to source json file location in:<br>
`\src\main\resources\application.properties`<br>
You need to have access to folder containing source file, and it need to be valid json file. <br>
To build the app use following command:<br>
`mvn clean package`<br>

<br>**Running**<br>
After building the app run following command to start it:<br>
`mvn spring-boot:run`

<br>**Access**<br>
After running app below urls will be accessible:
`http://localhost:8080/api/book/{isbn}`
`http://localhost:8080/category/{categoryName}/books`
`http://localhost:8080/api/rating `


<br>**Some design choices and asumptions**<br>
* I've considered use of database, but decided that even h2 would be overkill for this set of requirements (although ratings turned out to be more tricky than expected and would be done easier using SQL query)
* Four classes have unconventional names: ListPrice_Offer, ListPrice_Sale, RetailPrice_Offer and RetailPrice_Sale it's because duplicate names of properties in json file, underscore makes visual identification easier in this particular case, much better than for example RetailPriceFromOffer
* I assume that source file will be valid Json file.


<br>**Technologies**<br>
* Tomcat - embedded in Spring 
* Lombok
* Spring boot
* Jackson
* Junit + MockMvc
* Jsonschema2pojo (to generate source json model)