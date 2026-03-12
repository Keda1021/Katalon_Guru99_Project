import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/TC01_Login_Success'), [:])

WebUI.click(findTestObject('Customer/link_EditCustomer'))

WebUI.setText(findTestObject('Customer/txt_customerID'), '12345')

WebUI.click(findTestObject('Customer/btn_submit'))

WebUI.setText(findTestObject('Customer/txt_address'), 'New Address')

WebUI.click(findTestObject('Customer/btn_submitUpdate'))

WebUI.verifyTextPresent('Customer details updated Successfully', false)

WebUI.callTestCase(findTestCase('Common/TC02_Logout'), [:])