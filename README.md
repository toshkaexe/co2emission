# co2 emission calculator

There is a console application in JAVA returns the amount of CO2-equivalent that will be caused when traveling between two cities using a given transportation method.
https://github.com/toshkaexe/co2emission
In the folder staging, you will find co2-calculator.jar  This application uses rest calls to collect coordinates of 2 cities and to create a distance in km between two cities. The is important to save a token for doing rest calls for authorization at the page https://openrouteservice.org/ The API token is stored and read from an environment variable called ORS_TOKEN.
GET request from: https://openrouteservice.org/dev/#/api-docs/geocode/search/get
POST request from:https://openrouteservice.org/dev/#/api-docs/v2/matrix/{profile}/post

In the folder *staging* you will find co2-calculator.jar  You need to have ORN_TOKEN.

Example: how to run the software
java -jar co2-calculator.jar --start "Hamburg" --end "Kassel" --transportation-method=bus

I have accepted the following rules: 
•	--start, --end, --transportation-method are mandatory
•	We can have  between --transportation-method and type  of transport an equal sign or an empty symbol
•	if the city is composed of two words, put the city name in quotation marks

Example of my solution:

       AntonZ@TTTTTTT C:\Users\antonz\git_workspace\emission\staging
       $ java -jar co2-calculator.jar --start "Hamburg" --end "Kassel" --transportation-method=bus
       Your trip caused: 8409,0kg of CO2-equivalent

       AntonZ@TTTTTTT C:\Users\antonz\git_workspace\emission\staging
       $ java -jar co2-calculator.jar --start Berlin --end Kassel --transportation-method=train
       Your trip caused: 2462,9kg of CO2-equivalent

       AntonZ@TTTTTTT C:\Users\antonz\git_workspace\emission\staging
       $ java -jar co2-calculator.jar --start "Los Angeles" --end "New York" --transportation-method small-diesel-car
       Your trip caused: 640313,9kg of CO2-equivalent
       
       AntonZ@TTTTTTT C:\Users\antonz\git_workspace\emission\staging
       $ java -jar co2-calculator.jar --start "Los Angeles" --end "New York" --transportation-method=large-diesel-car
       Your trip caused: 942433,8kg of CO2-equivalent

