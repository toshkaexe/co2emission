# co2 emission calculator
There is an application returns the amount of CO2-equivalent that will be caused when traveling between two cities using
a given transportation method.

I have done this task in Java. In the folder *staging* you will find co2-calculator.jar  You need to have ORN_TOKEN.
Example: how to run the software
java -jar co2-calculator.jar --start "Hamburg" --end "Kassel" --transportation-method=bus

I have accepted the following rules: 
•	--start, --end, --transportation-method are mandatory
•	We can have  between --transportation-method and type  of transport an equal sign or an empty symbol
•	if the city is composed of two words, put the city name in quotation marks

Example of my program

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

