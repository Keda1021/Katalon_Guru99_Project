import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/TC01_Login_Success'), [:])

WebUI.click(findTestObject('Customer/link_EditCustomer'))

WebUI.setText(findTestObject('Customer/txt_customerID'), '12345')

WebUI.click(findTestObject('Customer/btn_resetEdit'))

WebUI.verifyElementPresent(findTestObject('Customer/txt_customerID'), 5)

WebUI.callTestCase(findTestCase('Common/TC02_Logout'), [:])