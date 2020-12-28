package bank.cucumbermap;

import java.util.Hashtable;

import bank.methods.SeleniumOperations;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search {
    //branch click
	@When("^user click on branches$")
	public void userclickbranches() throws Throwable 
	{
		 Object[] branchclick=new Object[1];   
		 branchclick[0]="//*[@src='images/Branches_but.jpg']";
	     
		 Hashtable<String,Object> sb= SeleniumOperations.Click(branchclick); 
	}
	
//DropDown for country
	@And("^User select \"(.*)\" as country$")
	public void selectcountry(String cname) throws Throwable 
	{
		Object[] country=new Object[2];   
		 country[0]="//*[@name='lst_countryS']";
	     country[1]=cname; 
		 Hashtable<String,Object> sbd= SeleniumOperations.DropDown(country);
	}
	//DropDown for state
	@And ("^User select \"(.*)\" as state$")
	public void selectstate(String statename) throws Throwable
	{
		Object[] state=new Object[2];   
		 state[0]="//*[@id='lst_stateS']";
	     state[1]=statename; 
		 Hashtable<String,Object> s7= SeleniumOperations.DropDown(state); 
	}
	//DropDown for city
	@And ("^User select \"(.*)\" as city$")
	public void selectcity(String cityname) throws Throwable
	{
		Object[] city=new Object[2];   
		 city[0]="//*[@id='lst_cityS']";
	     city[1]=cityname; 
		 Hashtable<String,Object> s70= SeleniumOperations.DropDown(city); 
	}
    //click on search
	@And("^user click on search button$")
	public void user_click_on_search_button() throws Throwable
	{
		 Object[] searchclick=new Object[1];   
		 searchclick[0]="//*[@type='image' and @id='btn_search']";
		 Hashtable<String,Object> sbd78= SeleniumOperations.Click(searchclick);
	}
	//validation for searched result
	@Then ("^User is able to view list of branches available at \"(.*)\"$")
	public void ViewBank(String branches) throws Throwable
	{
		 Object[] welcome=new Object[2];
		 welcome[0]="(//*[text()='MUMBAI'])[1]";
		 welcome[1]=branches;
		 Hashtable<String,Object> sy=SeleniumOperations.Validation1(welcome);
	}

}
