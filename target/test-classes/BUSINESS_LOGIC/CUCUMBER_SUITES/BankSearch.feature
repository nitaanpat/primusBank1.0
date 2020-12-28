Feature: Search Functionality
Background: user is successfully logged in
  When user opens the "chrome" browser and exe "E:\\PrimusBank\\src\\test\\resources\\DRIVERS\\chromedriver.exe"
  And user enters the url "http://primusbank.qedgetech.com/"
  When user enters "Admin" as username
  And user enters "Admin" as password
  And user clicks on login button
  Then user is on the Admin main page and get message as Welcome to Admin
 
 @EndToEnd 
Scenario: Search button functinality for valid data
When user click on branches
And User select "INDIA" as country
And User select "MAHARASTRA" as state
And User select "MUMBAI" as city
And user click on search button
Then User is able to view list of branches available at "MUMBAI"

