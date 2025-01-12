# Currency Converter Application

This is a Springboot application that provides real-time currency conversion using a public API.

## Prerequisites

**API key**:
- Obatain a valid API key from [EXchangeRatesAPI.io] (https://exhangeratesapi.io).
- Add the API key to the `application.properties` file.


## Setup and Run Locally

## 1. Clone the Repository

- https://github.com/AdilSayed959/CurrencyConverter.git

## API Endpoints

 # 1. GET http://localhost:8080/api/rates?base=EUR 
 - (NOTE - It was mentioned in the challenge that the base should default to USD, but the free trial version of the external API defaults to EUR and doesn't allow to use other bases unless we take their subscription)

 # 2. POST http://localhost:8080/api/convert
 	
 	- Request body  
 		
 			{ 
    		"from": "EUR",
    		"to": "INR",
    		"amount": 500
			}
