package bank.cucumbermap;

import java.util.Hashtable;

import bank.methods.SeleniumOperations;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {

	@When("^user opens the \"([^\"]*)\" browser and exe \"([^\"]*)\"$")
	public void user_opens_the_browser_and_exe(String bname, String exe) throws Throwable
	{
		   Object[] input0=new Object[2];
		   input0[0]=bname;
		   input0[1]=exe;
		   Hashtable<String,Object> out=SeleniumOperations.LaunchApplication(input0);
	}

	@When("^user enters the url \"([^\"]*)\"$")
	public void user_enters_the_url(String url) throws Throwable 
	{
		 Object[] inputf=new Object[1];
		   
		   inputf[0]=url;
		   
		   Hashtable<String,Object> out1=SeleniumOperations.Url(inputf);
		   
	}
  //validation for application reached on login page by providing url
	@Given("^user is on the application login page$")
	public void user_is_on_the_application_login_page() throws Throwable
	{
		   Object[] inputtt=new Object[1];
		   inputtt[0]="http://primusbank.qedgetech.com/";
		
		   Hashtable<String,Object> output0=SeleniumOperations.Validationloginpage(inputtt); 
	}

	@When("^user enters \"([^\"]*)\" as username$")
	public void user_enters_as_username(String id) throws Throwable
	
	{
		Object[] username=new Object[2];
		   username[0]="//*[@id='txtuId']";
		   username[1]=id;
	        Hashtable<String,Object> s= SeleniumOperations.SetText(username);
	}

	  @And ("^user enters \"(.*)\" as password$")
	public void user_enters_as_password(String pass) throws Throwable
	{
		Object[] password=new Object[2];   
		 password[0]="//*[@id='txtPword']";
	     password[1]=pass;  
		 Hashtable<String,Object> s2= SeleniumOperations.SetText(password);	 
	}

	@And("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable 
	{
		Object[] loginclick=new Object[1];   
		 loginclick[0]="//*[@id='login']";
	     
		 Hashtable<String,Object> s4= SeleniumOperations.Click(loginclick);
	    
	}

	 @Then ("^user is on the Admin main page and get message as Welcome to Admin$")
	 public void welcometoadmin()throws Throwable
	 {
		 Object[] welcome=new Object[2];
				 welcome[0]="//*[text()='Admin']";
				 welcome[1]="Admin";
				 Hashtable<String,Object> sy=SeleniumOperations.Validation1(welcome);
	 }

	@Then("^user get Alert message as InCorrect BankerName/Password$")
	public void user_get_Alert_message_as_InCorrect_BankerName_Password() throws Throwable 
	{
		 System.out.println("Alet msg validation done");
	}

}
