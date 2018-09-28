package com.generic.tests.Registration;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.generic.page.Registration;
import com.generic.setup.Common;
import com.generic.setup.GlobalVariables;
import com.generic.setup.LoggingMsg;
import com.generic.setup.PagesURLs;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.RandomUtilities;
import com.generic.util.ReportUtil;
import com.generic.util.SASLogger;
import com.generic.util.dataProviderUtils;

public class RegistrationBase extends SelTestCase {

	// possible scenarios
	public static final String freshUser = "fresh";
	public static final String existingUser = "existing";
	public static final String emptyData = "empty";
	public static final String invalidUserID = "UserID";
	public static final String passwordMismatch = "Mismatch";
	public static final String invalidPassword = "UserPassword";
	
	//messagesValidations
	public static final String successMessage = "success";
	public static final String invalidEmail = "invalidEmail";
	public static final String titleError = "titleError";
	public static final String firstNameError = "firstNameError";
	public static final String lastNameError = "lastNameError";
	public static final String passwordError = "passwordError";
	public static final String confPasswordError = "confirmPasswordError";
	public static final String passwordRulesError = "passwordRuleError";
	public static final String passwordMisatchError = "passwordMismatchError";
	private String CurrentPageTitle;
	// used sheet in test
	public static final String testDataSheet = SheetVariables.registrationRegressionSheet;

	private static XmlTest testObject;
	
	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>() ;

	
	@BeforeTest
	public static void initialSetUp(XmlTest test) throws Exception {
		Testlogs.set(new SASLogger(test.getName() + test.getIndex()));
		testObject = test;
		
	}

	@DataProvider(name = "Registration", parallel = true)
	//concurrency maintenance on sheet reading 
	public static Object[][] loadTestData() throws Exception {
		getBrowserWait(testObject.getParameter("browserName"));
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@SuppressWarnings("unchecked") // avoid warning from linked hashmap
	@Test(dataProvider = "Registration")
	public void registrationRegressionTest(String caseId, String runTest, String desc, String proprties,
			String fieldsValidation) throws Exception {
		
		Testlogs.set(new SASLogger("registration "+getBrowserName()));
		//Important to add this for logging/reporting 
		setTestCaseReportName("Registration Case");
		//Testlogs.get().debug("Case Browser: "  + testObject.getParameter("browserName") );
		logCaseDetailds(MessageFormat.format(LoggingMsg.REGISTRATIONDESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc, proprties.replace("\n", "<br>- ")));
		
		String thankUMsg = (fieldsValidation.split("ThankyouValidation:").length >2) ? fieldsValidation.split("ThankyouValidation:")[0].split("\n")[0]:"";
		String countryValidation =(fieldsValidation.split("countryValidation:").length >2) ?  fieldsValidation.split("countryValidation:")[0].split("\n")[0]:"";
		String titleValidation = (fieldsValidation.split("titleValidation:").length >2) ? fieldsValidation.split("titleValidation:")[0].split("\n")[0]:"";
		String nameValidation = (fieldsValidation.split("nameValidation:").length >2) ? fieldsValidation.split("nameValidation:")[0].split("\n")[0]:"";
		String companyNameValidation = (fieldsValidation.split("companyNameValidation:").length >2) ? fieldsValidation.split("companyNameValidation:")[0].split("\n")[0]:"";
		String addressLine1Validation =(fieldsValidation.split("addressLine1Validation:").length >2) ?  fieldsValidation.split("addressLine1Validation:")[0].split("\n")[0]:"";
		String cityValidation = (fieldsValidation.split("cityValidation:").length >2) ? fieldsValidation.split("cityValidation:")[0].split("\n")[0]:"";
		String postalCodeValidation = (fieldsValidation.split("postalCodeValidation:").length >2) ? fieldsValidation.split("postalCodeValidation:")[0].split("\n")[0]:"";
		String positionValidation = (fieldsValidation.split("positionValidation:").length >2) ? fieldsValidation.split("positionValidation:")[0].split("\n")[0]:"";
		String phoneValidation = (fieldsValidation.split("phoneValidation:").length >2) ? fieldsValidation.split("phoneValidation:")[0].split("\n")[0]:"";
		String emailValidation = (fieldsValidation.split("EmailValidation:").length >2) ? fieldsValidation.split("EmailValidation:")[0].split("\n")[0]:"";

		//click on register new user button
		//Registration.goToRegistrationForm();
		
		//prepare random address details
		LinkedHashMap<String, String> addressDetails = (LinkedHashMap<String, String>) addresses.get("A1");
		//Prepare registration data 
		String message = "QA Automation Test";
		//String password = "P11p"+RandomUtilities.getRandomPassword(8);
		String email = RandomUtilities.getRandomEmail();
		String url = PagesURLs.getHomePage() + PagesURLs.getRegistrationPage();
		logs.debug("Registration page: "+ url);
		getDriver().get(url);
		Thread.sleep(1000);
	//	CurrentPageTitle = getDriver().getTitle();
		try {
			if (proprties.contains(freshUser)) {
				//register new user and validate the results
				Registration.fillAndClickRegister(addressDetails.get(Registration.keys.country), addressDetails.get(Registration.keys.title),
						addressDetails.get(Registration.keys.userName), addressDetails.get(Registration.keys.companyName),
						addressDetails.get(Registration.keys.adddressLine),addressDetails.get(Registration.keys.adddressLine2),
						addressDetails.get(Registration.keys.city),addressDetails.get(Registration.keys.postal),
						addressDetails.get(Registration.keys.position),addressDetails.get(Registration.keys.phone),
						addressDetails.get(Registration.keys.extension), email, email, message, 1);
				
				String registrationSuccessMsg = Registration.getRegistrationSuccessMessage();
				sassert().assertTrue(registrationSuccessMsg.toLowerCase().contains(thankUMsg), 
						"Regestration Success, validation failed Expected to have in message: " + thankUMsg +" but Actual message is: " + registrationSuccessMsg);
			}
			
			if (proprties.contains("New NON US user")) {
				//register new user and validate the results
				addressDetails = (LinkedHashMap<String, String>) addresses.get("A5");
				Registration.fillAndClickRegister(addressDetails.get(Registration.keys.country), addressDetails.get(Registration.keys.title),
						addressDetails.get(Registration.keys.userName), addressDetails.get(Registration.keys.companyName),
						addressDetails.get(Registration.keys.adddressLine),addressDetails.get(Registration.keys.adddressLine2),
						addressDetails.get(Registration.keys.city),addressDetails.get(Registration.keys.postal),
						addressDetails.get(Registration.keys.position),addressDetails.get(Registration.keys.phone),
						addressDetails.get(Registration.keys.extension), email, email, message, 1);
				
				String registrationSuccessMsg = Registration.getRegistrationSuccessMessage();
				sassert().assertTrue(registrationSuccessMsg.toLowerCase().contains(thankUMsg), 
						"Regestration Success, validation failed Expected to have in message: " + thankUMsg +" but Actual message is: " + registrationSuccessMsg);
			}
			
			if (proprties.contains(existingUser)) {
				// take any user as template
				LinkedHashMap<String, String> userdetails = (LinkedHashMap<String, String>) users.get("U-02");
				email = userdetails.get(Registration.keys.email);
				email=getSubMailAccount(email);
				logs.debug("Registration mail: "+email);
				Registration.fillAndClickRegister(addressDetails.get(Registration.keys.country), addressDetails.get(Registration.keys.title),
						addressDetails.get(Registration.keys.userName), addressDetails.get(Registration.keys.companyName),
						addressDetails.get(Registration.keys.adddressLine),addressDetails.get(Registration.keys.adddressLine2),
						addressDetails.get(Registration.keys.city),addressDetails.get(Registration.keys.postal),
						addressDetails.get(Registration.keys.position),addressDetails.get(Registration.keys.phone),
						addressDetails.get(Registration.keys.extension), email, email, message, 1);
				String validationMsg = Registration.negativeAlerts();
				sassert().assertTrue(validationMsg.contains(emailValidation), "Mail validation failed, Expected: " + emailValidation +" Actual: " + validationMsg);
			}
			if (proprties.contains(emptyData)) {
				Registration.clickRegisterButton();
				// switch To Default Content
				if (getBrowserName().equals(GlobalVariables.browsers.IE)
						|| getBrowserName().equals(GlobalVariables.browsers.firefox))
				{
					Registration.switchToDefaultContent();
					Thread.sleep(3000);
				}
				
				String validationMsg = Registration.getcountryError();
				sassert().assertTrue(validationMsg.contains(countryValidation),
						"Country validation failed Expected: " + countryValidation + " Actual: " + validationMsg);

				validationMsg = Registration.getTitleError();
				sassert().assertTrue(validationMsg.contains(titleValidation),
						"Title validation failed Expected: " + titleValidation + " Actual: " + validationMsg);
			
				validationMsg = Registration.getuserNameError();
				sassert().assertTrue(validationMsg.contains(nameValidation),
						"Name validation failed Expected: " + nameValidation + " Actual: " + validationMsg);

				validationMsg = Registration.getcompanyNameError();
				sassert().assertTrue(validationMsg.contains(companyNameValidation),
						"Company name validation failed Expected: " + companyNameValidation + " Actual: " + validationMsg);
				
				validationMsg = Registration.getAddressLine1Error();
				sassert().assertTrue(validationMsg.contains(addressLine1Validation),
						"Address line1 validation failed Expected: " + addressLine1Validation + " Actual: " + validationMsg);
				
				validationMsg = Registration.getcityError();
				sassert().assertTrue(validationMsg.contains(cityValidation),
						"City validation failed Expected: " + cityValidation + " Actual: " + validationMsg);
				
				validationMsg = Registration.getPostalCodeError();
				sassert().assertTrue(validationMsg.contains(postalCodeValidation),
						"Postal code validation failed Expected: " + postalCodeValidation + " Actual: " + validationMsg);
				
				validationMsg = Registration.getPositionError();
				sassert().assertTrue(validationMsg.contains(positionValidation),
						"Position validation failed Expected: " + positionValidation + " Actual: " + validationMsg);
				
				validationMsg = Registration.getPhoneError();
				sassert().assertTrue(validationMsg.contains(phoneValidation),
						"Phone validation failed Expected: " + phoneValidation + " Actual: " + validationMsg);
				
				validationMsg = Registration.getEmailAddressError();
				sassert().assertTrue(validationMsg.contains(emailValidation),
						"Mail validation failed Expected: " + emailValidation + " Actual: " + validationMsg);

			}
			if (proprties.contains(invalidUserID)) {
				email = "invalid";
				Registration.fillAndClickRegister(addressDetails.get(Registration.keys.country), addressDetails.get(Registration.keys.title),
						addressDetails.get(Registration.keys.userName), addressDetails.get(Registration.keys.companyName),
						addressDetails.get(Registration.keys.adddressLine),addressDetails.get(Registration.keys.adddressLine2),
						addressDetails.get(Registration.keys.city),addressDetails.get(Registration.keys.postal),
						addressDetails.get(Registration.keys.position),addressDetails.get(Registration.keys.phone),
						addressDetails.get(Registration.keys.extension), email, email, message, 1);
				
				String validationMsg = Registration.getEmailAddressError();
				sassert().assertTrue(validationMsg.contains(emailValidation),
						"Mail validation failed Expected: " + emailValidation + " Actual: " + validationMsg);
			}
			
			Thread.sleep(2000);
			sassert().assertAll();
			Common.testPass();
		} catch (Throwable t) {
			setTestCaseDescription(getTestCaseDescription());
			Testlogs.get().debug(MessageFormat.format(LoggingMsg.DEBUGGING_TEXT, t.getMessage()));
			t.printStackTrace();
			String temp = getTestCaseReportName();
			Common.testFail(t, temp);
			ReportUtil.takeScreenShot(getDriver(), testDataSheet + "_" + caseId);
			Assert.assertTrue(false, t.getMessage());
		} // catch
	}// test
}
