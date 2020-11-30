# WeatherDataComparator
"WeatherDataComparator" compares temprature and humidity difference between NDTV website and API response.

# Description
Created a comparator which could compare various weather condition 
  - From 2 different data source
  - For API source, response was extracted using REST-ASSURED
  

# Scope/Assumptions

* User has to enter valid city name to extract weather condition data from website and API

# Development Approach
* Automated NDTV website with Selenium Webdriver using Java language
* Extracted value of temperature and humidity from HTML element with XPath and string manipulation operation
* Extracted value of temperature and humidity from openweather api response with REST-ASSURED

# Instructions
1. Execute the program from CLI using command "mvn exec:java" 
2. Enter city name 
3. Program will fetch temperature and humidity details from NDTV website and OpenWeather API.
4. Enter temperature variance and humidity variance.
5. Program will print output in console and show if there is a match for temperature and for humidity.

# Installation

Eclipse
Maven
TestNG
Maven Build

# Execute project from Command Prompt
Execute project from command prompt  - "mvn exec:java"
