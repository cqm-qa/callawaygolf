package com.generic.tests.HomePage;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.generic.page.HomePage;
import com.generic.page.Registration;
import com.generic.page.SignIn;
import com.generic.selector.HomePageSelectors;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.PagesURLs;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.ReportUtil;
import com.generic.util.SASLogger;
import com.generic.util.dataProviderUtils;

public class HomePageBase extends SelTestCase {

	// possible scenarios
	public static final String update = "update";
	public static final String verify = "verify";
	public static final String header = "header";
	public static final String carouselSlide = "carousel slide";
	public static final String footer = "footer";
	public static final String body = "body";

	// used sheet in test
	public static final String testDataSheet = SheetVariables.HomePageRegressionSheet;

	private static XmlTest testObject;
	
	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>() ; 
	
	@BeforeTest
	public static void initialSetUp(XmlTest test) throws Exception {
		Testlogs.set(new SASLogger(test.getName() + test.getIndex()));
		testObject = test;
	}

	@DataProvider(name = "HP_SC", parallel = true)
	//concurrency maintenance on sheet reading 
	public static Object[][] loadTestData() throws Exception {
		getBrowserWait(testObject.getParameter("browserName"));
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}


	@Test(dataProvider = "HP_SC")
	public void HomePageRegressionTest(String caseId, String runTest, String desc, String proprties, String baseline) throws Exception {
		Testlogs.set(new SASLogger("HP_SC "+getBrowserName()));
		//Important to add this for logging/reporting 
		setTestCaseReportName(SheetVariables.HPTestCaseId);
		//Testlogs.get().debug("Case Browser: "  + testObject.getParameter("browserName") );
		logCaseDetailds(MessageFormat.format(LoggingMsg.TEST_CASE_DESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc));
		
//		String baseline_browser = baseline+"_"+getBrowserName().replace(" ", "_");
		
		try {
			LinkedHashMap<String, String> userdetails = null;
			userdetails = (LinkedHashMap<String, String>) users.get("U-02");
			String caseMail = getSubMailAccount(userdetails.get(Registration.keys.email));
			Testlogs.get().debug("Login mail is: " + caseMail);
			Testlogs.get().debug((String) userdetails.get(Registration.keys.password));
			SignIn.fillLoginFormAndClickSubmit(caseMail, (String) userdetails.get(Registration.keys.password));
			sassert().assertTrue(SignIn.checkUserAccount(), LoggingMsg.USER_IS_NOT_LOGGED_IN_SUCCESSFULLY);
			
			String url = PagesURLs.getHomePage();
			getDriver().get(url);
			Thread.sleep(1500);
			
			if (proprties.contains(this.update))
			{
				if (proprties.contains(this.header))
					HomePage.visualTesting.updateHeaderBaselines(baseline);
				if (proprties.contains(this.carouselSlide))
					HomePage.visualTesting.updateCarouselSlideBaselines(baseline);
				if (proprties.contains(this.footer))
					HomePage.visualTesting.updateFooterBaseline(baseline);
				if (proprties.contains(this.body))
					HomePage.visualTesting.updateBodyBaseline(baseline);
				
				HomePage.visualTesting.prepareBaselineforLogs(baseline);
			}
			if (proprties.contains(this.verify))
			{
				if (proprties.contains(this.header))
					sassert().assertTrue(HomePage.visualTesting.verifyHeader(baseline),"<font color=#f442cb>headerbase lines are not same site header </font>");
				if (proprties.contains(this.carouselSlide))
					sassert().assertTrue(HomePage.visualTesting.verifyCarouselSlide(baseline),"<font color=#f442cb>Carousel Slide is not same site Carousel Slide </font>");
				if (proprties.contains(this.footer))
					sassert().assertTrue(HomePage.visualTesting.verifyFooter(baseline),"<font color=#f442cb>headerbase line is not same site footer </font>");
				if (proprties.contains(this.body))
					sassert().assertTrue(HomePage.visualTesting.verifyBody(baseline),"<font color=#f442cb>headerbase line is not same site body </font>");
				
				HomePage.visualTesting.prepareBaselineforLogs(baseline);
			}
			if (proprties.contains("check top nav links")) // "verify top nav, place order links"))
			{
				
				Testlogs.get().debug("check Clup Links Correct");
				HomePage.topNav.clickTopNavLink(0);
				HomePage.topNav.clickSecondaryNavigation(0);
				for (int index = 0; index < 7; index++) {
					sassert().assertTrue(HomePage.topNav.isSecondarySubNavigationLinkCorrect(index), "<font color=#f442cb>Clup Link (" + index+") are not working as expected </font>");	
				}
				Testlogs.get().debug("check Clup Odyssey Putters Links Correct");
						HomePage.topNav.clickNavlinktertiarySecondaryNavigation(0);
						for (int i = 0; i < 2; i++) {
							sassert().assertTrue(HomePage.topNav.isThirdNavigationLinkCorrect(i), "<font color=#f442cb>Odyssey Putters Link (" + i +") are not working as expected </font>");	
						}

			Testlogs.get().debug("check Clup Toulon Putters Links Correct");
						HomePage.topNav.clickNavlinktertiarySecondaryNavigation(1);
						for (int i = 0; i < 10; i++) {
							sassert().assertTrue(HomePage.topNav.isThirdNavigationLinkCorrect(i), "<font color=#f442cb>Toulon Putters Link (" +i +") are not working as expected </font>");	
						}
					
				
				Testlogs.get().debug("check Balls Links Corret");
				HomePage.topNav.clickTopNavLink(0);
				sassert().assertTrue(HomePage.topNav.isSecondaryNavigationLinkCorrect(0), "<font color=#f442cb>Balls link is not working as expected </font>");
				
				Testlogs.get().debug("check Accessories Links Corret");
				HomePage.topNav.clickTopNavLink(0);
				HomePage.topNav.clickSecondaryNavigation(2);
				for (int index = 0; index < 5; index++) {
					sassert().assertTrue(HomePage.topNav.isNavlinktertiarySecondSubTarget2LinkCorrect(index), "<font color=#f442cb>Accessories Link (" +index +") are not working as expected </font>");	
				}

//				Testlogs.get().debug("check Golf Bags Links Corret");
//				HomePage.topNav.clickSecondSubTarget2SubBtn(0);
//				for (int index = 0; index < 3; index++) {
//					sassert().assertTrue(HomePage.topNav.isNavlinktertiarySecondSubTarget2_0Correct(index), "<font color=#f442cb>Golf Bags Link (" +index +") are not working as expected </font>");	
//				}
//				
//				Testlogs.get().debug("check Bag Accessories Links Corret");
//				HomePage.topNav.clickSecondSubTarget2SubBtn(1);
//				for (int index = 0; index < 3; index++) {
//					sassert().assertTrue(HomePage.topNav.isNavlinktertiarySecondSubTarget2_3Correct(index), "<font color=#f442cb>Bag Accessories Link (" +index +") are not working as expected </font>");	
//				}
				
			}
			
			if (proprties.contains("check top nav links"))//"verify top nav, CheckStatus links"))
			{
				
				Testlogs.get().debug("Verify Order Status Links");
				HomePage.topNav.clickTopNavLink(1);
				HomePage.topNav.clickSecondaryNavigation(3);
				sassert().assertTrue(HomePage.topNav.CheckStatus.checkOrderStatusPage(), "<font color=#f442cb>Order status link is not working correctly </font>");
				sassert().assertTrue(HomePage.getServerError(), "<font color=#f442cb>Server Error is displayed for Order status link </font>");
				getDriver().get(url);
			}
			
			if (proprties.contains("check top nav links")) //"verify top nav, BillPay links"))
			{
				
				Testlogs.get().debug("Verify BillPay Links");
				HomePage.topNav.clickTopNavLink(2);
				HomePage.topNav.clickSecondaryNavigation(4);
				sassert().assertTrue(HomePage.topNav.BillPay.checkBillPayPage(), "<font color=#f442cb>Bill Pay link is not working correctly </font>");
				sassert().assertTrue(HomePage.getServerError(), "<font color=#f442cb>Server Error is displayed for BillPay link </font>");
				getDriver().get(url);
			}
			
			if (proprties.contains("check top nav links")) //verify top nav, Compensation links"))
			{
				
				Testlogs.get().debug("Verify Compensation Links");
				HomePage.topNav.clickTopNavLink(3);
				sassert().assertTrue(false, "<font color=#f442cb>Compensation link is not implemented yet");
			//	Common.returnPreviousPage();
		//	TODO update this with Compensation requirements.
				
//				HomePage.topNav.clickSecondaryNavigation(5);
//				sassert().assertTrue(HomePage.topNav.Compensation.checkCompensationPage(), "Compensation link is not working correctly");
				
			}
			
			if (proprties.contains("check top nav links")) //"verify top nav, Trade In Returns links"))
			{
				
				Testlogs.get().debug("Verify Trade In Returns Links");
				HomePage.topNav.clickTopNavLink(4);
				
				Testlogs.get().debug("Verify Trade In Returns Links");
				HomePage.topNav.clickSecondaryNavigation(5);
				sassert().assertTrue(HomePage.topNav.TradeInReturns.checkTradeInTradeUpBtn(), "<font color=#f442cb>Trade In Returns Link is not working correctly </font>");
			//	sassert().assertTrue(false, "Trade In Returns Link is not working correctly");
				sassert().assertTrue(HomePage.getServerError(), "<font color=#f442cb>Server Error is displayed for Trade In Trade Up link </font>");
				getDriver().get(url);
				
				HomePage.topNav.clickTopNavLink(4);
				HomePage.topNav.clickSecondaryNavigation(6);
				sassert().assertTrue(HomePage.topNav.TradeInReturns.checkDemoReturnsPageURL(), "<font color=#f442cb>Demo Returns Link is not working correctly </font>");
				sassert().assertTrue(HomePage.topNav.TradeInReturns.checkDemoReturnsPageForm(), "<font color=#f442cb>Demo Returns page is opened cprrectly </font>");
				getDriver().get(url);
				
				HomePage.topNav.clickTopNavLink(4);
				HomePage.topNav.clickSecondaryNavigation(7);
				sassert().assertTrue(HomePage.topNav.TradeInReturns.checkFitCartReturnsPage(), "<font color=#f442cb>Fit Cart Returns Link is not working correctly </font>");
				sassert().assertTrue(HomePage.topNav.TradeInReturns.checkFitCartReturnsPageHeader(), "<font color=#f442cb>Fit Cart Returns page is not opened correctly </font>");
				getDriver().get(url);
			}

			if (proprties.contains("check top nav links"))//verify top nav,  Resources links")) {
			{
				Testlogs.get().debug("check Resources Links");

				HomePage.topNav.clickTopNavLink(5);
				HomePage.topNav.clickSecondaryNavigation(8);

				Testlogs.get().debug("check Products Links");

				sassert().assertTrue(HomePage.topNav.Resources.checkUPCListsBtn(), "<font color=#f442cb>UPC Lists link is not working as expected </font>");
				sassert().assertTrue(HomePage.topNav.Resources.checkProductSetupSheetsBtn(), "<font color=#f442cb>Product Setup Sheets link is not working as expected </font>");
				sassert().assertTrue(HomePage.topNav.Resources.checkCatalogsBtn(), "<font color=#f442cb>Catalogs link is not working as expected </font>");

				HomePage.topNav.clickSecondaryNavigation(9);

				Testlogs.get().debug("check Pricing Policies Links");

				sassert().assertTrue(HomePage.topNav.Resources.checkWholesalePriceListBtn(), "<font color=#f442cb>Wholesale PriceList link is not working as expected </font>");
				sassert().assertTrue(HomePage.topNav.Resources.checkNPIP_MAPSalesPolicyBtn(), "<font color=#f442cb>NPIP MAP Sales Policy link is not working as expected </font>");
				sassert().assertTrue(HomePage.topNav.Resources.checkInternetAdvertisingPolicyBtn(), "<font color=#f442cb>InternetAdvertisingPolicy link is not working as expected </font>");
				sassert().assertTrue(HomePage.topNav.Resources.checkOffPremisesSalesPolicyBtn(), "<font color=#f442cb>OffPremisesSalesPolicy link is not working as expected </font>");

				Testlogs.get().debug("check Sales Tools Links");
				HomePage.topNav.clickSecondaryNavigation(10);
				sassert().assertTrue(HomePage.topNav.Resources.checkCustomClubAvailabilityBtn(), "<font color=#f442cb>CustomClubAvailability link is not working as expected </font>");
				sassert().assertTrue(HomePage.topNav.Resources.checkProductImagesBtn(), "<font color=#f442cb>ProductImages link is not working as expected </font>");
				sassert().assertTrue(HomePage.topNav.Resources.checkProductTrainingBtn(), "<font color=#f442cb>ProductTraining link is not working as expected </font>");
				sassert().assertTrue(HomePage.topNav.Resources.checkCurrentPromotionsBtn(), "<font color=#f442cb>CurrentPromotions link is not working as expected </font>");
				sassert().assertTrue(HomePage.topNav.Resources.checkMarketingAssetsBtn(), "<font color=#f442cb>kMarketingAssets link is not working as expected </font>");
				sassert().assertTrue(HomePage.topNav.Resources.checkLogoGuideBtn(), "<font color=#f442cb>LogoGuide link is not working as expected </font>");

			}
			if (proprties.contains("check footer links")) {
				
				HomePage.footer.clickFooterLink(0);
				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.contactUs), "<font color=#f442cb>ContactUs link is not working as expected </font>");
				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for Contact Us link");
				getDriver().get(url);
				
				sassert().assertTrue(HomePage.footer.checkBtnHref(HomePageSelectors.NPIP_MAP_Policies, 1), "<font color=#f442cb>NPIP MAP Policies link is not working as expected </font>");
				
				HomePage.footer.clickFooterLink(2);
				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.PrivacyPolicy), "<font color=#f442cb>Privacy Policy link is not working as expected </font>");
				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for Privacy Policy link");
				getDriver().get(url);
				
				HomePage.footer.clickFooterLink(3);
				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.Legal), "<font color=#f442cb>Legal link is not working as expected </font>");
				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for Privacy Policy link");
				getDriver().get(url);
				
				sassert().assertTrue(HomePage.footer.checkBtnHref(HomePageSelectors.InternetAdvertisingAndSalesPolicy, 4), "<font color=#f442cb>Internet Advertising and Sales Policy link is not working as expected </font>");
				
				HomePage.footer.clickFooterLink(5);
				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.PriceLists), "<font color=#f442cb>Price Lists link is not working as expected </font>");
				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for Price Lists link");
				getDriver().get(url);
				
				HomePage.footer.clickFooterLink(6);
				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.Catalogs), "<font color=#f442cb>Catalogs link is not working as expected </font>");
				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for Catalogs link");
				getDriver().get(url);
				
				HomePage.footer.clickFooterLink(7);
				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.ProductImages), "<font color=#f442cb>Product Images link is not working as expected </font>");
				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for Product Images link");
				getDriver().get(url);
				
				HomePage.footer.clickFooterLink(8);
				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.LogoSpecsAndPlacement), "<font color=#f442cb>Logo Specs And Placement link is not working as expected </font>");
				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for Logo Specs And Placement link");
				getDriver().get(url);
				
				HomePage.footer.clickFooterLink(9);
				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.CurrentPromotions), "<font color=#f442cb>Current Promotions link is not working as expected </font>");
				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for Current Promotions link");
				getDriver().get(url);
				
				HomePage.footer.clickFooterLink(10);
				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.ProductSetupSheetUPCList), "<font color=#f442cb>Product Setup Sheet / UPC Listlink is not working as expected </font>");
				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for Product Setup Sheet / UPC List link");
				getDriver().get(url);
				
				HomePage.footer.clickFooterLink(11);
				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.callawaygolf), "<font color=#f442cb>callawaygolf link is not working as expected </font>");
				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for callawaygolf link");
				getDriver().get(url);
				
				HomePage.footer.clickFooterLink(12);
				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.callawaygolfpreowned), "<font color=#f442cb>callawaygolfpreowned link is not working as expected </font>");
				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for callawaygolfpreowned link");
				getDriver().get(url);
				
			//	HomePage.footer.clickFooterLink(13);
				sassert().assertTrue(HomePage.footer.checkBtnHref(HomePageSelectors.pressReleases, 1), "<font color=#f442cb>press Releases link is not working as expected </font>");

//				HomePage.footer.clickFooterLogo(0);
//				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.callawaygolf), "<font color=#f442cb>callawaygolf logo is not working as expected </font>");
//				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for callawaygolf logo");
//				getDriver().get(url);
//				
//				HomePage.footer.clickFooterLogo(1);
//				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.odysseygolf), "<font color=#f442cb>odysseygolf logo is not working as expected </font>");
//				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for odysseygolf logo");
//				getDriver().get(url);
//				
//				HomePage.footer.clickFooterLogo(2);
//				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.ogio), "<font color=#f442cb>ogio logo is not working as expected </font>");
//				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for ogio logo");
//				getDriver().get(url);
//				
//				HomePage.footer.clickFooterLogo(3);
//				sassert().assertTrue(HomePage.footer.checkPageURL(HomePageSelectors.travismathew), "<font color=#f442cb>travismathew logo is not working as expected </font>");
//				sassert().assertTrue(HomePage.getServerError(), "Server Error is displayed for travismathew logo");
//				getDriver().get(url);
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
