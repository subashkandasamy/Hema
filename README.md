# TDD-Freamwork-TomTom Assignment

### TDD Framework  :
•	The TDD Framework was built with Selenium, Java ,TestNG and Required libraries are entered in the Maven POM file.

•	The Page Object Model approach was followed to build the framework. Which help to maintain the code better and helps to write clean code

•	Each pages in the application will have a separate java class under “Page” package under main/java/org/Com/Qa where we can maintain all the Objects/elements  and action as methods related to particular page separately  and this division enhances the maintainability of the test code.

•	Framework provides data driven approch , I have created an excel utilities to get data from excel.

•	Each page class has seprate test class , whichbhelp to run any test independently  

•	Under utils folder we have utilities like excel reader , waiting time utils , By methods class which is used in selenium

•	Framework generates  two reports , default testng report , advanced Extend report with chart  

•	Screenshots are captured for both passed and failed test cases and embed with test report 

•	Framework  is cable of connect to any CI tools like Jenkins 

•	Config file help config any properties and get help to get it on run time.

•	Tag option is enabled so can segregate the test scenarios for regression , sanity , smoke testing 
 
### Browser :
Tested with Firefox 67.0 

And framework is cable of run on multiple browser based on the configuration of browser value in config file

### Framework Architecture

#### under main/java/org/Com/Qa

we have following folder 

Base - contains a Test Base java class which has comman methods like initialize driver , loding properties , taking screen shot , create a class instance ect

configration - a properties file with run time loding configration details 

Pages - Each page in application will have a java class with all elements and actions 

utils - contains comman utils like excel reader , By action methods , time utils , logger ects

listeners - Test report listeners are maintained here  

#### under test/java/org/Com/Qa

PageTest - contains all the test 

resources - contains the testng xml like regression , sanity ect. 

refrence image : 

![image](https://user-images.githubusercontent.com/37447382/69047075-ad2b6e00-09fa-11ea-94f3-bff6bef74bf6.png)


### Test Report 

A detailed test report will be generated after each run and screen shot will be attached for both passed and failed test cases

example report :


![image](https://user-images.githubusercontent.com/37447382/69047138-c92f0f80-09fa-11ea-9e03-f42a6327f8e9.png)


![image](https://user-images.githubusercontent.com/37447382/69047227-f67bbd80-09fa-11ea-901c-dacde2394742.png)


Dashbord report :


![image](https://user-images.githubusercontent.com/37447382/69047191-e49a1a80-09fa-11ea-981f-a9954d93cda9.png)



### Test scenarios Covered:

•	Registration to the Website

•	Sign in

•	Add Product(s) to the cart

•	Sign out

### How to Run Tests: 
•	By using TestNg xml to run as TestNg suite

•	By using pom file and execute it as maven install option
