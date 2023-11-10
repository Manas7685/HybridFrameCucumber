package com.stepdefinitions;

	import java.util.List;
	import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.pageobjects.LoginPage;
import com.pageobjects.MyAccountPage;
import com.utility.Log;

import io.cucumber.datatable.DataTable;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;

	public class AccountPageStepDef  {

		private LoginPage loginPage = new LoginPage();
		private MyAccountPage accountPage=new MyAccountPage();
		
		private static Logger logger = Logger.getLogger(AccountPageStepDef .class);

		@Given("user has already logged in to application")
		public void user_has_already_logged_in_to_application(DataTable credTable) {

			List<Map<String, String>> credList = credTable.asMaps();
			String userName = credList.get(0).get("username");
			String password = credList.get(0).get("password");

			
			loginPage.enterEmailAddress(userName);
			loginPage.enterPassword(password);
			accountPage = loginPage.clickOnLoginButton();

		}

		@Given("user is on Accounts page")
		public void user_is_on_accounts_page() {
			String title = accountPage.getAccountsPageTitle();
			System.out.println("Accounts Page title is: " + title);
		}

		@Then("user gets accounts section")
		public void user_gets_accounts_section(DataTable sectionsTable) {

			List<String> expAccountSectionsList = sectionsTable.asList();
			
			System.out.println("Expected accounts section list: " + expAccountSectionsList);

			List<String> actualAccountSectionsList = accountPage.getAccountsSectionsList();
			System.out.println("Actual accounts section list: " + actualAccountSectionsList);

		

			
			try
			{
				Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));
				logger.info("********** TC006 : Validate MyAccount Page : Passed **********");
			}
			catch(Exception e)
			{
				logger.error("********** TC006 : Validate MyAccount Page : Failed  **********");
			}
		}

		@Then("accounts section count should be {int}")
		public void accounts_section_count_should_be(Integer expectedSectionCount) {
			
			Log.startTestCase("Validating List count of account page");
			try
			{
			Assert.assertTrue(accountPage.getAccountsSectionCount() == expectedSectionCount);
			logger.info("********** TC006 : Validate MyAccount Page List : Passed **********");
			}
			catch(Exception e)
			{
				logger.error("********** TC006 : Validate MyAccount Page List : Failed  **********");
			}
			Log.endTestCase("Validating List count of account page");}
		
		
		
		@Then("page title should be {string}")
		public void page_title_should_be(String string) {
			Log.startTestCase("PageTitleValidation");
			try
			{
			Assert.assertTrue(accountPage.getAccountsPageTitle().equalsIgnoreCase(string));
			logger.info("********** TC006 : Validate MyAccount Page List : Passed **********");
			}
			catch(Exception e)
			{
				logger.error("********** TC006 : Validate MyAccount Page List : Failed  **********");
			}
		    Log.endTestCase("PageTitleValidation");
		}

	}
	