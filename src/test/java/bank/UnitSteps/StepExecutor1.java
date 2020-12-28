package bank.UnitSteps;

import java.util.Hashtable;

import org.junit.Test;

import bank.methods.SeleniumOperations;

public class StepExecutor1 implements Parameters 
{
	
	public static void main(String[] args) throws Exception
	{
		
         //Browser Launch 
           Object[] input0=new Object[2];
		   input0[0]=bname;
		   input0[1]=driverexepath;
		   Hashtable<String,Object> out=SeleniumOperations.LaunchApplication(input0);
		  
		
		   
	  	  //url Launch
		   Object[] inputf=new Object[1];
		   
		   inputf[0]="http://primusbank.qedgetech.com/";
		   
		   Hashtable<String,Object> out1=SeleniumOperations.Url(inputf);
		   
		   //Username 
		   Object[] username=new Object[2];
		   username[0]="//*[@id='txtuId']";
		   username[1]="Admin";
	        Hashtable<String,Object> s= SeleniumOperations.SetText(username);
	        
		     //password
		     Object[] password=new Object[2];   
			 password[0]="//*[@id='txtPword']";
		     password[1]="Admin";  
			 Hashtable<String,Object> s2= SeleniumOperations.SetText(password);	 
			 
			 //Login button click
		     Object[] loginclick=new Object[1];   
			 loginclick[0]="//*[@id='login']";
		     
			 Hashtable<String,Object> s4= SeleniumOperations.Click(loginclick); 
			
			 
			 //Click on Branches
				   
			 Object[] branchclick=new Object[1];   
			 branchclick[0]="//*[@src='images/Branches_but.jpg']";
		     
			 Hashtable<String,Object> sb= SeleniumOperations.Click(branchclick); 
			 
			//Country(DropDown)
		     Object[] country=new Object[2];   
			 country[0]="//*[@name='lst_countryS']";
		     country[1]="INDIA"; 
			 Hashtable<String,Object> sbd= SeleniumOperations.DropDown(country);
			 
			//State(DropDown)
		     Object[] state=new Object[2];   
			 state[0]="//*[@id='lst_stateS']";
		     state[1]="MAHARASTRA"; 
			 Hashtable<String,Object> s7= SeleniumOperations.DropDown(state);
			 
			//City(DropDown)
		     Object[] city=new Object[2];   
			 city[0]="//*[@id='lst_cityS']";
		     city[1]="MUMBAI"; 
			 Hashtable<String,Object> s70= SeleniumOperations.DropDown(city);
			 
			
			 //Click on Search 
			 Object[] searchclick=new Object[1];   
			 searchclick[0]="//*[@type='image' and @id='btn_search']";
		     
			 Hashtable<String,Object> sbd78= SeleniumOperations.Click(searchclick); 
			 
			 
	}

}
