import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/TC01_Login_Success'), [:])

WebUI.click(findTestObject('Customer/link_NewCustomer'))

WebUI.setText(findTestObject('Customer/txt_customerName'), 'thu')

WebUI.click(findTestObject('Customer/radio_male'))

WebUI.setText(findTestObject('Customer/txt_dob'), '1990-01-01')

WebUI.setText(findTestObject('Customer/txt_address'), 'HCM city')

WebUI.setText(findTestObject('Customer/txt_city'), 'HCM')

WebUI.setText(findTestObject('Customer/txt_state'), 'HCM')

WebUI.setText(findTestObject('Customer/txt_pin'), '123456')

WebUI.setText(findTestObject('Customer/txt_phone'), '0988888888')

WebUI.setText(findTestObject('Customer/txt_email'), 'abc123')

WebUI.setText(findTestObject('Customer/txt_password'), '123456')

WebUI.click(findTestObject('Customer/btn_submitUpdate'))


WebUI.verifyTextPresent('Email-ID is not valid', false)


accFile.getParentFile().mkdirs()

WebUI.callTestCase(findTestCase('Common/TC02_Logout'), [:])