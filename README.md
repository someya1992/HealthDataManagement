HealthDataManagement

Decisions taken :
-- gson for parsing the json so that entire json is not loaded to avoid OutOfMemoryException. 
-- queue for procession the records
-- datasource as user id
-- or now parsed the data assuming that datasource is arraylist with 1 element


Improvements
reponse and request must be in json(better approach)

APIs
POST - /userData/{path} :- This API consumes the DynamicDataEpoch i.e the json , path is path of json file

Request :

`localhost:8080/epoch/classpath:backend_data.json`

Response

`HTTP Status 202 is received`

GET - heartrate/{userId} :- This API return the average heartRate of a given person.

Response :

`76.70652173913044`

Building and running the project
mvn clean and mvn install

In the target folder executable jar is created, Run as java -jar <jar_name>.jar

In Postman or any other REST client hit the APIs mentioned above :- http://localhost:8080/{request}