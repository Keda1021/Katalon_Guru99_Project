import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject

TestObject logout = findTestObject('Page_AddCustomer/link_Logout')

WebUI.waitForElementVisible(logout, 10)

WebUI.scrollToElement(logout, 3)

WebUI.executeJavaScript("arguments[0].click();", 
    Arrays.asList(WebUI.findWebElement(logout)))

WebUI.closeBrowser()