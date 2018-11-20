package com.generic.tests.accountSetup;

import java.text.MessageFormat;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import java.util.LinkedHashMap;

import com.generic.page.Registration;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.PagesURLs;
import com.generic.setup.SelTestCase;
import com.generic.util.dataProviderUtils;
import com.generic.util.ReportUtil;
import com.generic.util.SASLogger;

public class AccountsSetup extends SelTestCase {

	// used sheet in test
	public static final String testDataSheet = "AccountSetup";

	private static XmlTest testObject;

	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>();
    private static String thankUMsg = "User registered with success.";

@BeforeTest
	public static void initialSetUp(XmlTest test) throws Exception {
		Testlogs.set(new SASLogger("Account_setup"));
		testObject = test;
	}

	@DataProvider(name = "Account_Setup", parallel = true)
	public static Object[][] loadTestData() throws Exception {
		// concurrency mentainance on sheet reading
		getBrowserWait(testObject.getParameter("browserName"));

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@SuppressWarnings("unchecked") // avoid warning from linked hashmap
	@Test(dataProvider = "Account_Setup")
	public void accountSetupBaseTest(String caseId, String runTest, String products, String shippingType,String shippingMethod, String payment,
			String shippingAddress, String billingAddress,String userType, String email) throws Exception {
		// Important to add this for logging/reporting
		Testlogs.set(new SASLogger("AccountSetup_" + getBrowserName()));
		setTestCaseReportName("AccountSetup Case");
		logCaseDetailds(MessageFormat.format(LoggingMsg.CHECKOUTDESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), email, email, payment, shippingMethod));

		LinkedHashMap<String, String> addressDetails = (LinkedHashMap<String, String>) addresses
				.get(shippingAddress);
		
		String Pemail = "";
		String message = "QA Automation Test";
		LinkedHashMap<String, String> userdetails = null; 
		if (!email.equals(""))
		{
			userdetails = (LinkedHashMap<String, String>) users.get(email);
			Pemail = getSubMailAccount(userdetails.get(Registration.keys.email));
			Testlogs.get().debug("Mail will be used is: " + Pemail);
		}
		
		try {
			Testlogs.get().debug(Pemail);
			String url = PagesURLs.getHomePage() + PagesURLs.getRegistrationPage();
			logs.debug("Registration page: "+ url);
			getDriver().get(url);
				//register new user and validate the results
			Testlogs.get().debug("country be used is: "+ addressDetails.get(Registration.keys.country));
			Testlogs.get().debug("title be used is: "+ addressDetails.get(Registration.keys.title));
			Registration.fillAndClickRegister(
				    addressDetails.get(Registration.keys.userName), addressDetails.get(Registration.keys.accountName),
					addressDetails.get(Registration.keys.adddressLine),addressDetails.get(Registration.keys.adddressLine2),
					addressDetails.get(Registration.keys.city),addressDetails.get(Registration.keys.region),
					addressDetails.get(Registration.keys.postal),addressDetails.get(Registration.keys.accountNumber)
					,addressDetails.get(Registration.keys.phone),email, addressDetails.get(Registration.keys.enteredBy), message, 1);
				
				String registrationSuccessMsg = Registration.getRegistrationSuccessMessage();
				sassert().assertTrue(registrationSuccessMsg.toLowerCase().contains(thankUMsg), 
						"Regestration Success, validation failed Expected to have in message: " + thankUMsg +" but Actual message is: " + registrationSuccessMsg);
			ReportUtil.takeScreenShot(getDriver(), testDataSheet + "_" + caseId);
			
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
}// class
