package com.generic.tests.login;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.generic.page.Registration;
import com.generic.page.SignIn;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.PagesURLs;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.ReportUtil;
import com.generic.util.SASLogger;

import com.generic.util.dataProviderUtils;

public class LoginBase extends SelTestCase {

	private static int testCaseID;
	// used sheet in test
	public static final String testDataSheet = SheetVariables.loginSheet;
	private static XmlTest testObject;

	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>();

	@BeforeTest
	public static void initialSetUp(XmlTest test) throws Exception {
		Testlogs.set(new SASLogger(test.getName() + test.getIndex()));
		testObject = test;
	}

	@DataProvider(name = "Login", parallel = true)
	// concurrency maintenance on sheet reading
	public static Object[][] loadTestData() throws Exception {
		getBrowserWait(testObject.getParameter("browserName"));
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@SuppressWarnings("unchecked") // avoid warning from linked hashmap
	@Test(dataProvider = "Login")
	public void LoginRegressionTest(String caseId, String runTest, String desc, String proprties, String email,
			String fieldsValidation) {

		Testlogs.set(new SASLogger("Login " + getBrowserName()));
		// Important to add this for logging/reporting
		setTestCaseReportName("Login Case");
		// Testlogs.get().debug("Case Browser: " +
		// testObject.getParameter("browserName") );
		logCaseDetailds(MessageFormat.format(LoggingMsg.TEST_CASE_DESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc, proprties.replace("\n", "<br>- ")));

		String caseMail = "";
		LinkedHashMap<String, String> userdetails = null;
		if (!email.equals("")) {
			userdetails = (LinkedHashMap<String, String>) users.get(email);
			caseMail = getSubMailAccount(userdetails.get(Registration.keys.email));
			Testlogs.get().debug("Mail will be used is: " + caseMail);
		}

		try {
			String url = PagesURLs.getHomePage() + PagesURLs.getLoginPage();
		//	getDriver().get(url);
			Thread.sleep(500);
			if (proprties.equals("Success login")) {
				Testlogs.get().debug("Login mail is: " + caseMail);
				Testlogs.get().debug((String) userdetails.get(Registration.keys.password));
				SignIn.fillLoginFormAndClickSubmit(caseMail, (String) userdetails.get(Registration.keys.password));
				sassert().assertTrue(SignIn.checkUserAccount(), LoggingMsg.USER_IS_NOT_LOGGED_IN_SUCCESSFULLY);
			}
			if (proprties.equals("invalidUserEmail")) {
				SignIn.fillLoginFormAndClickSubmit(caseMail.replace("@", ""), "1234567");
				String alertMessage = SignIn.getErrologinMessage();
				sassert().assertTrue(alertMessage.contains(fieldsValidation),
						"Error message is not as expected" + fieldsValidation + " : " + alertMessage);
			}
			if (proprties.equals("invalidUserPassword")) {
				Testlogs.get().debug(caseMail);
				SignIn.fillLoginFormAndClickSubmit(caseMail, "");
				String passwordMessage = SignIn.getErrologinMessage();
				sassert().assertTrue(passwordMessage.contains(fieldsValidation),
						"Error message is not as expected" + fieldsValidation + " : " + passwordMessage);
				
			}
			if (proprties.equals("wrongUserPassword")) {
				Testlogs.get().debug(caseMail);
				SignIn.fillLoginFormAndClickSubmit(caseMail, "invalid123");
				String loginformMessage = SignIn.getErrologinMessage();
				String failureMessage = MessageFormat.format(LoggingMsg.ACTUAL_EXPECTED_ERROR, loginformMessage,
						fieldsValidation);
				sassert().assertTrue(loginformMessage.contains(fieldsValidation), failureMessage);
			}
			if (proprties.equals("emptyData")) {
				SignIn.fillLoginFormAndClickSubmit("", "");
				String loginformMessage = SignIn.getErrologinMessage();
				String failureMessage = MessageFormat.format(LoggingMsg.ACTUAL_EXPECTED_ERROR, loginformMessage,
						fieldsValidation);
				sassert().assertTrue(loginformMessage.contains(fieldsValidation), failureMessage);
			}

			if (proprties.equals("Forgot password -Valid Email")) {
				SignIn.clickForgotPasswordBtn();
				SignIn.typeForgottenPwdEmail(caseMail);
				SignIn.clickForgotPasswordSubmitBtn();
				Thread.sleep(1500);
				String alertMessage = SignIn.getAlertPositiveForgottenPasswordd();
				String failureMessage = MessageFormat.format(LoggingMsg.ACTUAL_EXPECTED_ERROR, alertMessage,
						fieldsValidation);
				sassert().assertTrue(alertMessage.contains(fieldsValidation), failureMessage);
			}
			if (proprties.equals("Forgot password -Invalid Email")) {
				if(!getBrowserName().contains("mobile"))
				{
					SignIn.clickForgotPasswordBtn();
					SignIn.typeForgottenPwdEmail(caseMail.replace("@", ""));
					SignIn.clickForgotPasswordSubmitBtn();
					Thread.sleep(1500);
					String alertMessage = SignIn.getForgottenPwdEmailError();
					String failureMessage = MessageFormat.format(LoggingMsg.ACTUAL_EXPECTED_ERROR, alertMessage,
							fieldsValidation);
					sassert().assertTrue(alertMessage.contains(fieldsValidation), failureMessage);
				}
			}
			
			if (proprties.equals("Forgot user name -Valid Email")) {
				SignIn.clickForgotUserNameBtn();
			//	sassert().assertTrue(SignIn.checkForgotUserNameForm());
				sassert().assertTrue(false, "Forgot User Name is not implemented yet");
				//TODO check the requirement for "Forgot user name" functionality.
				
			}
			if (proprties.equals("Forgot user name -Invalid Email")) {
				if(!getBrowserName().contains("mobile"))
				{
					SignIn.clickForgotUserNameBtn();
					//	sassert().assertTrue(SignIn.checkForgotUserNameForm());
					sassert().assertTrue(false, "Forgot User Name is not implemented yet");
				//TODO check the requirement for "Forgot user name" functionality.
				}
			}
			if (proprties.equals("Sign up")) {
				if(!getBrowserName().contains("mobile"))
				{
					SignIn.clickSignUpBtn();
					sassert().assertTrue(Registration.checkRegisterSection());
				}
			}
			if (proprties.equals("credit application valid email")) {
				if(!getBrowserName().contains("mobile"))
				{
					SignIn.clickCreditApplicationBtn();
					sassert().assertTrue(SignIn.checkCreditApplicationForm());
					SignIn.typeCreditApplicationEmail(caseMail);
					SignIn.clickCreditApplicationNextBtn();
					sassert().assertTrue(false, "NEXT button is disapled");
					//TODO check the requirement for "credit application" functionality.
				}
			}
			
			if (proprties.equals("credit application invalid email")) {
				if(!getBrowserName().contains("mobile"))
				{
					SignIn.clickCreditApplicationBtn();
					sassert().assertTrue(SignIn.checkCreditApplicationForm());
					SignIn.typeCreditApplicationEmail(caseMail.replace("@", ""));
					SignIn.clickCreditApplicationNextBtn();
					sassert().assertTrue(false, "NEXT button is disapled");
					//TODO check the requirement for "credit application" functionality.
				}
			}
			
			if (proprties.equals("Success login NON US user")) {
				if(!getBrowserName().contains("mobile"))
				{
					sassert().assertTrue(false, "change country menu is un changable");
					//TODO check the requirement for "credit application" functionality.
				}
			}
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
