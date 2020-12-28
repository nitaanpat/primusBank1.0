Feature: Login Feature

  Background: user is successfully logged in
  When user opens the "chrome" browser and exe "E:\\PrimusBank\\src\\test\\resources\\DRIVERS\\chromedriver.exe"
  And user enters the url "http://primusbank.qedgetech.com/"

 @SmokeTest 
  Scenario: Login Functionality for valid username and password
  Given user is on the application login page
  When user enters "Admin" as username
  And user enters "Admin" as password
  And user clicks on login button
  Then user is on the Admin main page and get message as Welcome to Admin
  
  Scenario: Login Functionality for valid username and invalid password
  Given user is on the application login page
  When user enters "Admin" as username
  And user enters "primus" as password
  And user clicks on login button
  Then user get Alert message as InCorrect BankerName/Password

  
  Scenario: Login Functionality for invalid username and valid password
  Given user is on the application login page
  When user enters "demo" as username
  And user enters "Admin" as password
  And user clicks on login button
  Then user get Alert message as InCorrect BankerName/Password

  
 
  