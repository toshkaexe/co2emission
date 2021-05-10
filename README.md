# co2 emission calculator
There is rest api application, that calls coordinates of 2 cities in form of latitude and longitude.
Console apprication:       
       AntonZ@B09WX52 C:\Users\antonz\git_workspace\emission\staging
      $ java -jar co2-calculator.jar --start "Hamburg" --end "Berlin" --transportation-method medium-diesel-car
      Your trip caused: 48246,3kg of CO2-equivalent

      AntonZ@B09WX52 C:\Users\antonz\git_workspace\emission\staging
      $ java -jar co2-calculator.jar --start "Hamburg" --end "Kassel" --transportation-method=bus
      Your trip caused: 8409,0kg of CO2-equivalent

      AntonZ@B09WX52 C:\Users\antonz\git_workspace\emission\staging
      $ java -jar co2-calculator.jar --start Berlin --end Kassel --transportation-method=train
      Your trip caused: 2462,9kg of CO2-equivalent

      AntonZ@B09WX52 C:\Users\antonz\git_workspace\emission\staging
      $ java -jar co2-calculator.jar --start "Los Angeles" --end "New York" --transportation-method small-diesel-car
      Your trip caused: 640313,9kg of CO2-equivalent

      AntonZ@B09WX52 C:\Users\antonz\git_workspace\emission\staging
      $ java -jar co2-calculator.jar --start "Los Angeles" --end "New York" --transportation-method=large-diesel-car
      Your trip caused: 942433,8kg of CO2-equivalent
