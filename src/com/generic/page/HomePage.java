package com.generic.page;


import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import com.generic.selector.HomePageSelectors;
import com.generic.setup.EnvironmentFiles;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
/**
 * The Class HomePage.
 */
public class HomePage extends SelTestCase {

	public static class leftNav {
		public static void clickStoreFinder() throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.storeFinder);
				valuesArr.add("");
				SelectorUtil.clickButton(subStrArr, 0);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		public static void clickMyAccount() throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.myAccountIcon);
				valuesArr.add("");
				SelectorUtil.clickButton(subStrArr, 0);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		public static void clickMiniCartIcon() throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.miniCartIcon);
				valuesArr.add("");
				SelectorUtil.clickButton(subStrArr, 0);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}
	}

	public static class search {
		public static void clicksearchIcon() throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.searchIcon);
				valuesArr.add("");
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		public static void typeSearch(String search) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.searchInput);
				valuesArr.add(search);
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}

		public static void submitSearch() throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.submitSearch);
				valuesArr.add("");
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

	}

	public static class topNav {

		public static class placeOrder {

			public static boolean isClupLinksCorrect() throws Exception {

				try {
					getCurrentFunctionName(true);
					clickTopNavLink(0);
					clickSecondaryNavigation(0);

					for (int index = 0; index < 9; index++) {
						isSecondarySubNavigationLinkCorrect(index);
						if (index == 6) {
							clickNavlinktertiaryThirdNavigation(index);
							for (int i = 0; i < 2; i++) {
								isThirdNavigationLinkCorrect(i);
							}
						}

						else if (index == 7) {
							clickNavlinktertiaryThirdNavigation(index);
							for (int i = 0; i < 10; i++) {
								isThirdNavigationLinkCorrect(i);
							}
						}
					}
					getCurrentFunctionName(false);
					return true;
				} catch (Exception e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean isBallsLinksCorrect() throws Exception {

				try {
					getCurrentFunctionName(true);
					clickTopNavLink(0);
					isSecondaryNavigationLinkCorrect(0);
					return true;
				} catch (Exception e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean isAccessoriesLinksCorrect() throws Exception {

				try {
					getCurrentFunctionName(true);
					clickTopNavLink(0);
					clickSecondaryNavigation(2);
					for (int index = 0; index < 7; index++) {
						isSecondarySubNavigationLinkCorrect(index);
					}
					return true;
				} catch (Exception e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
		}

		public static class  CheckStatus {
			
			public static void clickTopNavLink(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.topNanLink);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 1);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickSecondaryNavigation(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.secondaryNavigation);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 3);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static boolean checkOrderStatusPage() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("mycompanyorders");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

		}

		public static class  BillPay {
			public static void clickTopNavLink(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.topNanLink);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 2);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickSecondaryNavigation(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.secondaryNavigation);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 4);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static boolean checkBillPayPage() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("mycompanyinvoices");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
		}

		public static class Compensation {
			
			public static void clickTopNavLink(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.topNanLink);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr,3);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickSecondaryNavigation(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.secondaryNavigation);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 5);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static boolean checkCompensationPage() throws Exception {
				try {
					getCurrentFunctionName(true);
                //TODO update Compensation page validation test based on the requirement 
					return false;
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
		}

		public static class TradeInReturns {
			
			public static void clickTopNavLink(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.topNanLink);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 4);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickSecondaryNavigation(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.secondaryNavigation);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, index);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static boolean checkTradeInTradeUpBtn() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("tradeUp");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
			
			public static boolean checkDemoReturnsPage() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("demoReturns");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
			public static boolean checkFitCartReturnsPage() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("fitCartReturns");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
			
		}
		
public static class  Resources {
			
	public static boolean checkUPCListsBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondarySubNavigationLink);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 7);
			getCurrentFunctionName(false);
			return href.contains("UPCLists");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	public static boolean checkProductSetupSheetsBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondarySubNavigationLink);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 8);
			getCurrentFunctionName(false);
			return href.contains("ProductSetupSheets");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static boolean checkCatalogsBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondarySubNavigationLink);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 9);
			getCurrentFunctionName(false);
			return href.contains("Catalogs");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static boolean checkWholesalePriceListBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondSubTarget1);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 0);
			getCurrentFunctionName(false);
			return href.contains("www.callawayconnect.com/SecureContent/ProductCenter/2018_Callaway_Wholesale_PriceList_US.pdf");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static boolean checkNPIP_MAPSalesPolicyBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondSubTarget1);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 1);
			getCurrentFunctionName(false);
			return href.contains("www.callawayconnect.com/SecureContent/ProductCenter/2018_Callaway_NPIPMAP.pdf");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static boolean checkInternetAdvertisingPolicyBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondSubTarget1);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 2);
			getCurrentFunctionName(false);
			return href.contains("www.callawayconnect.com/SecureContent/ProductCenter/2018_Callaway_Internet_Advertising_SalesPolicy.pdf");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static boolean checkOffPremisesSalesPolicyBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondSubTarget1);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 3);
			getCurrentFunctionName(false);
			return href.contains("www.callawayconnect.com/SecureContent/ProductCenter/2018_OffPremises_SalesPolicy_US.pdf");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static boolean checkCustomClubAvailabilityBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondSubTarget2);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 5);
			getCurrentFunctionName(false);
			return href.contains("cgmediacontentus.blob.core.windows.net/connect/ProductCenter/ConstrainedComponents.xlsx");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static boolean checkProductImagesBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondSubTarget2);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 6);
			getCurrentFunctionName(false);
			return href.contains("thebunker.callawaygolf.com");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static boolean checkProductTrainingBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondSubTarget2);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 7);
			getCurrentFunctionName(false);
			return href.contains("training");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static boolean checkCurrentPromotionsBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondSubTarget2);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 8);
			getCurrentFunctionName(false);
			return href.contains("creative/promotions");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static boolean checkMarketingAssetsBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondSubTarget2);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 9);
			getCurrentFunctionName(false);
			return href.contains("callawaymedia.com");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static boolean checkLogoGuideBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.navlinktertiarySecondSubTarget2);
			valuesArr.add("");
			String href = SelectorUtil.getAttr(subStrArr, "href", 10);
			getCurrentFunctionName(false);
			return href.contains("cgmediacontentus.blob.core.windows.net/connect/ProductCenter/LogoGuide.pdf");
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	
	
	
	
	
}

		public static void clickTopNavLink(int linkID) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.topNanLink);
				valuesArr.add("");
				SelectorUtil.clickButton(subStrArr, linkID);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		public static void clickSecondaryNavigation(int linkID) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.secondaryNavigation);
				valuesArr.add("");
				SelectorUtil.clickButton(subStrArr, linkID);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		public static String getLinkNavSecondaryNavigation(int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.secondaryNavigationLink);
				valuesArr.add("");
				String href = SelectorUtil.getAttr(subStrArr, "href", index);
				getCurrentFunctionName(false);
				return href;
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		public static String getLinkNavSecondaryNavigationName(int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.secondaryNavigationLink);
				valuesArr.add("");
				String Name = SelectorUtil.getAttr(subStrArr, "title", index).split(" ")[0].split("/")[0].replace("-", "");
				getCurrentFunctionName(false);
				return Name;
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}

		public static void clickNavlinktertiarySecondaryNavigation(int linkID) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.navlinktertiarySecondarySubNavigation);
				valuesArr.add("");
				SelectorUtil.clickButton(subStrArr, linkID);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		public static String getLinkNavSecondarySubNavigation(int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.navlinktertiarySecondarySubNavigationLink);
				valuesArr.add("");
				String href = SelectorUtil.getAttr(subStrArr, "href", index);
				getCurrentFunctionName(false);
				return href;
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		public static String getLinkNavSecondarySubNavigationName(int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.navlinktertiarySecondarySubNavigationLink);
				valuesArr.add("");
				String Name = SelectorUtil.getAttr(subStrArr, "title", index).split(" ")[0].split("/")[0].replace("-", "");
				if (Name == "Complete")
					Name = "PACKAGEDSETS";
				getCurrentFunctionName(false);
				return Name;
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}

		public static String getLinkisNavlinktertiarySecondSubTarget2Link(int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.navlinktertiarySecondarySubNavigationLink);
				valuesArr.add("");
				String href = SelectorUtil.getAttr(subStrArr, "href", index);
				getCurrentFunctionName(false);
				return href;
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		public static String getLinkisNavlinktertiarySecondSubTarget2Name(int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.navlinktertiarySecondarySubNavigationLink);
				valuesArr.add("");
				String Name = SelectorUtil.getAttr(subStrArr, "title", index).split(" ")[0].split("/")[0].replace("-", "");
				if (Name == "Complete")
					Name = "PACKAGEDSETS";
				getCurrentFunctionName(false);
				return Name;
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}
		
		public static void clickNavlinktertiaryThirdNavigation(int linkID) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.navlinktertiaryThirdNavigation);
				valuesArr.add("");
				SelectorUtil.clickButton(subStrArr, linkID);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		public static String getLinkNavThirdNavigation(int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.navlinktertiaryThirdNavigationLink);
				valuesArr.add("");
				String href = SelectorUtil.getAttr(subStrArr, "href", index);
				getCurrentFunctionName(false);
				return href;
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		public static String getLinkNavThirdNavigationName(int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.navlinktertiaryThirdNavigationLink);
				valuesArr.add("");
				String title = SelectorUtil.getAttr(subStrArr, "title", index).split(" ")[0].split("/")[0].replace("-", "");
				getCurrentFunctionName(false);
				return title;
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}

		public static boolean isSecondaryNavigationLinkCorrect(int index) throws Exception {
			logs.debug("isSecondaryNavigationLinkCorrect?");
			return (getLinkNavSecondaryNavigation(index).toLowerCase()
					.contains(getLinkNavSecondaryNavigationName(index).toLowerCase()) ? true : false);
		}

		public static boolean isSecondarySubNavigationLinkCorrect(int index) throws Exception {
			logs.debug("isSecondarySubNavigationLinkCorrect?");
			return (getLinkNavSecondarySubNavigation(index).toLowerCase()
					.contains(getLinkNavSecondarySubNavigationName(index).toLowerCase()) ? true : false);
		}

		public static boolean isNavlinktertiarySecondSubTarget2LinkCorrect(int index) throws Exception {
			logs.debug("isNavlinktertiarySecondSubTarget2LinkCorrect?");
			return (getLinkNavSecondarySubNavigation(index).toLowerCase()
					.contains(getLinkNavSecondarySubNavigationName(index).toLowerCase()) ? true : false);
		}
		public static boolean isThirdNavigationLinkCorrect(int index) throws Exception {
			logs.debug("isThirdNavigationLinkCorrect?");
			return (getLinkNavThirdNavigation(index).toLowerCase()
					.contains(getLinkNavThirdNavigationName(index).toLowerCase()) ? true : false);
		}
	}

	public static class footer {
		
		public static void clickFooterLink(int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.footerLinks);
				valuesArr.add("");
				SelectorUtil.clickButton(subStrArr, index);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}
		
		public static boolean checkPageURL(String pageUrl) throws Exception {
			try {
				getCurrentFunctionName(true);
				logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
				String url = SelTestCase.getDriver().getCurrentUrl();
				getCurrentFunctionName(false);
				return url.contains(pageUrl);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}
		
		public static boolean checkBtnHref(String href, int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				List<String> subStrArr = new ArrayList<String>();
				List<String> valuesArr = new ArrayList<String>();
				subStrArr.add(HomePageSelectors.footerLinks);
				valuesArr.add("");
				String ActualHref = SelectorUtil.getAttr(subStrArr, "href", index);
				getCurrentFunctionName(false);
				return ActualHref.contains(href);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}
		
		public static class HELP {
			public static String getTitle() throws Exception {
				getCurrentFunctionName(true);
				try {
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerMainContainersTitle);
					valuesArr.add("");
					SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
					logs.debug(MessageFormat.format(LoggingMsg.ERROR_MSG, SelectorUtil.textValue.get()));
					getCurrentFunctionName(false);
					return SelectorUtil.textValue.get();
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkContactUsBtn() throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					String href = SelectorUtil.getAttr(subStrArr, "href", 0);
					getCurrentFunctionName(false);
					return href.contains("ContactUs");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}
			
			public static void clickContactUs(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 0);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static boolean checkContactUsPageURL() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains(HomePageSelectors.contactUs);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

		}

		public static class DOCUMENTS {
			public static String getTitle() throws Exception {
				getCurrentFunctionName(true);
				try {
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerMainContainersTitle);
					valuesArr.add("index,1");
					SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
					logs.debug(MessageFormat.format(LoggingMsg.ERROR_MSG, SelectorUtil.textValue.get()));
					getCurrentFunctionName(false);
					return SelectorUtil.textValue.get();
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static void click_NPIP_MAP_Policies(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 1);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}
			public static boolean checkNPIP_MAP_PoliciesBtn() throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					String href = SelectorUtil.getAttr(subStrArr, "href", 1);
					getCurrentFunctionName(false);
					return href.contains(HomePageSelectors.NPIP_MAP_Policies);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickPrivacyPolicy(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 2);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static boolean checkPrivacyPolicyBtn() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains(HomePageSelectors.PrivacyPolicy);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}
			
			public static void clickLegal(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 3);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickInternetAdvertisingAndSalesPolicy(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 4);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static boolean check_NPIP_MAP_Policies_PageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					String Selector = HomePageSelectors.NPIP_MAP_Policies;
					List<String> subStrArr = new ArrayList<String>();
					subStrArr.add(Selector);
					getCurrentFunctionName(false);
					return SelectorUtil.isDisplayed(subStrArr);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkPrivacyPolicyPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					String Selector = HomePageSelectors.PrivacyPolicy;
					List<String> subStrArr = new ArrayList<String>();
					subStrArr.add(Selector);
					getCurrentFunctionName(false);
					return SelectorUtil.isDisplayed(subStrArr);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkLegalPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					String Selector = HomePageSelectors.Legal;
					List<String> subStrArr = new ArrayList<String>();
					subStrArr.add(Selector);
					getCurrentFunctionName(false);
					return SelectorUtil.isDisplayed(subStrArr);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkInternetAdvertisingAndSalesPolicyPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					String Selector = HomePageSelectors.InternetAdvertisingAndSalesPolicy;
					List<String> subStrArr = new ArrayList<String>();
					subStrArr.add(Selector);
					getCurrentFunctionName(false);
					return SelectorUtil.isDisplayed(subStrArr);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

		}

		public static class ProductResources {
			public static String getTitle() throws Exception {
				getCurrentFunctionName(true);
				try {
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerMainContainersTitle);
					valuesArr.add("index,2");
					SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
					logs.debug(MessageFormat.format(LoggingMsg.ERROR_MSG, SelectorUtil.textValue.get()));
					getCurrentFunctionName(false);
					return SelectorUtil.textValue.get();
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static void clickPriceLists(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 5);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickCatalogs(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 6);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickProductImages(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 7);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickLogoSpecsAndPlacement(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 8);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static void clickCurrentPromotions(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 9);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static void clickProductSetupSheetUPCList(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 10);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static boolean checkPriceListsPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					String Selector = HomePageSelectors.PriceLists;
					List<String> subStrArr = new ArrayList<String>();
					subStrArr.add(Selector);
					getCurrentFunctionName(false);
					return SelectorUtil.isDisplayed(subStrArr);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkCatalogsPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					String Selector = HomePageSelectors.Catalogs;
					List<String> subStrArr = new ArrayList<String>();
					subStrArr.add(Selector);
					getCurrentFunctionName(false);
					return SelectorUtil.isDisplayed(subStrArr);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkProductImagesPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					String Selector = HomePageSelectors.ProductImages;
					List<String> subStrArr = new ArrayList<String>();
					subStrArr.add(Selector);
					getCurrentFunctionName(false);
					return SelectorUtil.isDisplayed(subStrArr);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkLogoSpecsAndPlacementPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					String Selector = HomePageSelectors.LogoSpecsAndPlacement;
					List<String> subStrArr = new ArrayList<String>();
					subStrArr.add(Selector);
					getCurrentFunctionName(false);
					return SelectorUtil.isDisplayed(subStrArr);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkCurrentPromotionsPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					String Selector = HomePageSelectors.CurrentPromotions;
					List<String> subStrArr = new ArrayList<String>();
					subStrArr.add(Selector);
					getCurrentFunctionName(false);
					return SelectorUtil.isDisplayed(subStrArr);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkProductSetupSheetUPCListPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					String Selector = HomePageSelectors.ProductSetupSheetUPCList;
					List<String> subStrArr = new ArrayList<String>();
					subStrArr.add(Selector);
					getCurrentFunctionName(false);
					return SelectorUtil.isDisplayed(subStrArr);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
		}

		public static class CallawayBrand {
			public static String getTitle() throws Exception {
				getCurrentFunctionName(true);
				try {
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerMainContainersTitle);
					valuesArr.add("index,3");
					SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
					logs.debug(MessageFormat.format(LoggingMsg.ERROR_MSG, SelectorUtil.textValue.get()));
					getCurrentFunctionName(false);
					return SelectorUtil.textValue.get();
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static void clickCallawayGolf(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 11);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickCallawayGolfPreOwned(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 12);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickPressReleases(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLinks);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 13);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static boolean checkCallawayGolfPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("https://cmp.callawaygolf.com/");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkCallawayGolfPreOwnedPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("https://www.callawaygolfpreowned.com/");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkPressReleasesPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("http://ir.callawaygolf.com/");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
		}
		
		public static class logo
		{

			public static void clickCallawaygolf(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLogos);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 0);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickBlog_odysseygolf(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLogos);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 1);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickOgio(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLogos);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 2);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static void clickTravismathew(int index) throws Exception {
				try {
					getCurrentFunctionName(true);
					List<String> subStrArr = new ArrayList<String>();
					List<String> valuesArr = new ArrayList<String>();
					subStrArr.add(HomePageSelectors.footerLogos);
					valuesArr.add("");
					SelectorUtil.clickButton(subStrArr, 3);
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}

			}

			public static boolean checkCallawaygolfPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("callawaygolf");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkBlog_odysseygolfPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("odysseygolf");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkOGIOPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("ogio");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}

			public static boolean checkTravismathewPageHeader() throws Exception {
				try {
					getCurrentFunctionName(true);
					logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
					String url = SelTestCase.getDriver().getCurrentUrl();
					getCurrentFunctionName(false);
					return url.contains("travismathew");
				} catch (NoSuchElementException e) {
					logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
					}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
		}
	}

	public static class visualTesting {

		public static void prepareBaselineforLogs(String baselines) throws Exception {

			getCurrentFunctionName(true);
			for (String baseline : baselines.split(",")) {

				baseline = baseline + "_" + getBrowserName().replace(" ", "_");
				String VTAs = EnvironmentFiles.getVisualTestingAssetsPath();
				String baselineAbsPath = VTAs + "/" + baseline + ".png";
				String logs_dir = EnvironmentFiles.getLogFilePath();
				File baseLineFile = new File(baselineAbsPath);
				FileUtils.copyFileToDirectory(baseLineFile, Paths.get(logs_dir).toFile());
				String baselinePathInLogs = logs_dir + "/" + baseline + ".png";
				logs.debug("IMAGE:<br><a target=\"_blank\" href=" + baseline + ".png" + "><img src=" + baseline + ".png"
						+ " alt=" + baseline + ".png" + " style=\"width:150px\"></a>");
			}
			getCurrentFunctionName(false);
		}

		public static void updateCarouselSlideBaselines(String baselines) throws Exception {
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			getCurrentFunctionName(true);
			int i = 0;
			for (String baseline : baselines.split(",")) {
				baseline = baseline + "_" + getBrowserName().replace(" ", "_");
				logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, baseline));
				clickCarouselIndicators(i);
				i++;
				subStrArr.add(HomePageSelectors.ContentSlotcarousel);
				valuesArr.add("VisualTesting");
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
				String imagePath = EnvironmentFiles.getVisualTestingAssetsPath() + "/" + baseline + ".png";
				ImageIO.write(SelectorUtil.screenShot.get().getImage(), "PNG", new File(imagePath));
				logs.debug("IMAGE:<br><a target=\"_blank\" href=" + baseline + ".png" + "><img src=" + baseline + ".png"
						+ " alt=" + baseline + ".png" + " style=\"width:150px\"></a>");
			}
			getCurrentFunctionName(false);
		}

		public static void updateHeaderBaselines(String baselines) throws Exception {
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			getCurrentFunctionName(true);
			int i = 0;
			for (String baseline : baselines.split(",")) {
				baseline = baseline + "_" + getBrowserName().replace(" ", "_");
				logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, baseline));
				if (baseline.contains("top")) {
					subStrArr.add(HomePageSelectors.topNavigation);
				} else {
					subStrArr.add(HomePageSelectors.middleNavigation);
				}
				valuesArr.add("VisualTesting");
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
				String imagePath = EnvironmentFiles.getVisualTestingAssetsPath() + "/" + baseline + ".png";
				ImageIO.write(SelectorUtil.screenShot.get().getImage(), "PNG", new File(imagePath));
				logs.debug("IMAGE:<br><a target=\"_blank\" href=" + baseline + ".png" + "><img src=" + baseline + ".png"
						+ " alt=" + baseline + ".png" + " style=\"width:150px\"></a>");
			}
			getCurrentFunctionName(false);
		}

		public static void updateFooterBaseline(String baselines) throws Exception {
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			getCurrentFunctionName(true);
			int i = 0;
			for (String baseline : baselines.split(",")) {
				baseline = baseline + "_" + getBrowserName().replace(" ", "_");
				logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "guest mail", baseline));
				if (baseline.contains("Top")) {
					subStrArr.add(HomePageSelectors.footerTopSection);
				} else if (baseline.contains("Banner1")) {
					subStrArr.add(HomePageSelectors.footerBanner1);
				} else {
					subStrArr.add(HomePageSelectors.footerBanner2);
				}
				valuesArr.add("VisualTesting");
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
				String imagePath = EnvironmentFiles.getVisualTestingAssetsPath() + "/" + baseline + ".png";
				ImageIO.write(SelectorUtil.screenShot.get().getImage(), "PNG", new File(imagePath));
				logs.debug("IMAGE:<br><a target=\"_blank\" href=" + baseline + ".png" + "><img src=" + baseline + ".png"
						+ " alt=" + baseline + ".png" + " style=\"width:150px\"></a>");
				subStrArr.clear();
				valuesArr.clear();
			}
			getCurrentFunctionName(false);
		}

		public static void updateBodyBaseline(String baselines) throws Exception {
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			getCurrentFunctionName(true);
			for (String baseline : baselines.split(",")) {
				baseline = baseline + "_" + getBrowserName().replace(" ", "_");
				logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "guest mail", baseline));
				if (baseline.contains("HP_OrderStatus")) {
					subStrArr.add(HomePageSelectors.body_OrderStatus);
				} else if (baseline.contains("HP_BillPay")) {
					subStrArr.add(HomePageSelectors.body_BillPay);
				} else if (baseline.contains("HP_rowPie")) {
					subStrArr.add(HomePageSelectors.body_rowPie);
				} else if (baseline.contains("HP_rowBPlegend")) {
					subStrArr.add(HomePageSelectors.body_rowBPlegend);
				} else {
					subStrArr.add(HomePageSelectors.body);
				}
				valuesArr.add("VisualTesting");
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
				String imagePath = EnvironmentFiles.getVisualTestingAssetsPath() + "/" + baseline + ".png";
				ImageIO.write(SelectorUtil.screenShot.get().getImage(), "PNG", new File(imagePath));
				logs.debug("IMAGE:<br><a target=\"_blank\" href=" + baseline + ".png" + "><img src=" + baseline + ".png"
						+ " alt=" + baseline + ".png" + " style=\"width:150px\"></a>");
				subStrArr.clear();
				valuesArr.clear();
			}
			getCurrentFunctionName(false);
		}

		public static boolean verifyHeader(String baselines) throws Exception {
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			getCurrentFunctionName(true);
			for (String baseline : baselines.split(",")) {
				logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, baseline));
				if (baseline.contains("top")) {
					subStrArr.add(HomePageSelectors.topNavigation);
				} else {
					subStrArr.add(HomePageSelectors.middleNavigation);
				}
				valuesArr.add("VisualTesting");
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
				String imagePath = EnvironmentFiles.getLogFilePath() + "/" + baseline + "_actual.png";
				BufferedImage actualImage = SelectorUtil.screenShot.get().getImage();

				ImageIO.write(SelectorUtil.screenShot.get().getImage(), "PNG", new File(imagePath));
				logs.debug("IMAGE:<br><a target=\"_blank\" href=" + baseline + "_actual.png" + "><img src=" + baseline
						+ "_actual.png" + " alt=" + baseline + "_actual.png" + " style=\"width:150px\"></a>");

				String BaseImagePath = EnvironmentFiles.getVisualTestingAssetsPath() + "/" + baseline + ".png";

				BufferedImage expectedImage = ImageIO.read(new File(BaseImagePath));

				ImageDiffer imgDiff = new ImageDiffer();
				ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);

				getCurrentFunctionName(false);
				return !diff.hasDiff();
			}
			return false;
		}

		public static boolean verifyCarouselSlide(String baselines) throws Exception {
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			getCurrentFunctionName(true);
			int i = 0;
			for (String baseline : baselines.split(",")) {
				logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, baseline));
				clickCarouselIndicators(i);
				i++;
				subStrArr.add(HomePageSelectors.ContentSlotcarousel);
				valuesArr.add("VisualTesting");
				baseline = baseline + "_" + getBrowserName().replace(" ", "_");
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
				String imagePath = EnvironmentFiles.getLogFilePath() + "/" + baseline + "_actual.png";
				BufferedImage actualImage = SelectorUtil.screenShot.get().getImage();

				ImageIO.write(SelectorUtil.screenShot.get().getImage(), "PNG", new File(imagePath));
				logs.debug("IMAGE:<br><a target=\"_blank\" href=" + baseline + "_actual.png" + "><img src=" + baseline
						+ "_actual.png" + " alt=" + baseline + "_actual.png" + " style=\"width:150px\"></a>");

				String BaseImagePath = EnvironmentFiles.getVisualTestingAssetsPath() + "/" + baseline + ".png";

				BufferedImage expectedImage = ImageIO.read(new File(BaseImagePath));

				ImageDiffer imgDiff = new ImageDiffer();
				ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
				subStrArr.clear();
				valuesArr.clear();
				getCurrentFunctionName(false);
				return !diff.hasDiff();
			}
			return false;
		}

		public static boolean verifyFooter(String baselines) throws Exception {
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			getCurrentFunctionName(true);
			int i = 0;
			for (String baseline : baselines.split(",")) {
				logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, baseline));
				if (baseline.contains("Top")) {
					subStrArr.add(HomePageSelectors.footerTopSection);
				} else if (baseline.contains("Banner1")) {
					subStrArr.add(HomePageSelectors.footerBanner1);
				} else {
					subStrArr.add(HomePageSelectors.footerBanner2);
				}
				valuesArr.add("VisualTesting");
				baseline = baseline + "_" + getBrowserName().replace(" ", "_");
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
				String imagePath = EnvironmentFiles.getLogFilePath() + "/" + baseline + "_actual.png";
				BufferedImage actualImage = SelectorUtil.screenShot.get().getImage();

				ImageIO.write(SelectorUtil.screenShot.get().getImage(), "PNG", new File(imagePath));
				logs.debug("IMAGE:<br><a target=\"_blank\" href=" + baseline + "_actual.png" + "><img src=" + baseline
						+ "_actual.png" + " alt=" + baseline + "_actual.png" + " style=\"width:150px\"></a>");

				String BaseImagePath = EnvironmentFiles.getVisualTestingAssetsPath() + "/" + baseline + ".png";

				BufferedImage expectedImage = ImageIO.read(new File(BaseImagePath));

				ImageDiffer imgDiff = new ImageDiffer();
				ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
				subStrArr.clear();
				valuesArr.clear();
				getCurrentFunctionName(false);
				return !diff.hasDiff();
			}
			return false;
		}

		public static boolean verifyBody(String baselines) throws Exception {
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			getCurrentFunctionName(true);
			for (String baseline : baselines.split(",")) {
				logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, baseline));
				if (baseline.contains("HP_OrderStatus")) {
					subStrArr.add(HomePageSelectors.body_OrderStatus);
				} else if (baseline.contains("HP_BillPay")) {
					subStrArr.add(HomePageSelectors.body_BillPay);
				} else if (baseline.contains("HP_rowPie")) {
					subStrArr.add(HomePageSelectors.body_rowPie);
				} else if (baseline.contains("HP_rowBPlegend")) {
					subStrArr.add(HomePageSelectors.body_rowBPlegend);
				} else {
					subStrArr.add(HomePageSelectors.body);
				}
				valuesArr.add("VisualTesting");
				baseline = baseline + "_" + getBrowserName().replace(" ", "_");
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
				String imagePath = EnvironmentFiles.getLogFilePath() + "/" + baseline + "_actual.png";
				BufferedImage actualImage = SelectorUtil.screenShot.get().getImage();

				ImageIO.write(SelectorUtil.screenShot.get().getImage(), "PNG", new File(imagePath));
				logs.debug("IMAGE:<br><a target=\"_blank\" href=" + baseline + "_actual.png" + "><img src=" + baseline
						+ "_actual.png" + " alt=" + baseline + "_actual.png" + " style=\"width:150px\"></a>");

				String BaseImagePath = EnvironmentFiles.getVisualTestingAssetsPath() + "/" + baseline + ".png";

				BufferedImage expectedImage = ImageIO.read(new File(BaseImagePath));

				ImageDiffer imgDiff = new ImageDiffer();
				ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
				subStrArr.clear();
				valuesArr.clear();
				getCurrentFunctionName(false);
				return !diff.hasDiff();
			}
			return false;
		}
	}

	private static void clickCarouselIndicators(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(HomePageSelectors.carouselSlideID);
			valuesArr.add("");
			SelectorUtil.clickButton(subStrArr, index);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static Boolean getServerError() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Server Error"));
			subStrArr.add(HomePageSelectors.serverError);
			valuesArr.add("");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
			return !SelectorUtil.textValue.get().contains("Server Error");
		} catch (NoSuchElementException e) {
			return true;
		}
		
	}

}
