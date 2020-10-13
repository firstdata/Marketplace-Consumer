# Marketplace-Consumer

Demo on consuming '_leads status API_' and '_push notification of Lead History details to end point_'.

## What is Marketplace-Consumer

Marketpalce-Consumer is sample code to describe usage of two of Inbranch APIs from consumer perspective. 

For each of these APIs have provided sample rest services in **Spring-Boot** (consumer-java project) and **Python** (consumer-python). 

For '_push notification of Lead History details to end point_' can support No Authorization, OAUTH, HMAC protocals to trigger end points as required.
So have provided sample code to describe with three different rest end points each in Spring-Boot and Python.

## How do I get started?

This application has Spring-Boot and Python projects packages, So, these projects needs to be just downloaded from git hub and import 
as projects into any of corresponidng IDE(s) that you are using. 

We have used below tools to test this through.
1. IntelliJ for Spring-Boot
2. PyCharm for Python
3. Postman for rest services. 
 

Once projects are imported and server is ready, Spring-Boot application will be available at http://localhost:9000 and 
Python rest services will be available at http://127.0.0.1:5000.


### Rest Service URLs to test from Postman:

**Lead Status**:   
http://host:port/api/referral/v1/consumer/trigger/leads/status  

**Lead History:**   
http://host:port/v1/trigger/lead/history/endpoint    
http://host:port/v1/trigger/oauth/lead/history/endpoint    
http://host:port/v1/trigger/hmac/lead/history/endpoint    