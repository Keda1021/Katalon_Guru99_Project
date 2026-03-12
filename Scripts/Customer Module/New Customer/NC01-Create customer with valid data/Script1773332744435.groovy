import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.testobject.TestObject

import org.openqa.selenium.WebElement
import java.util.Arrays

// Step 1 - Login
WebUI.callTestCase(findTestCase('Common/TC01_Login_Success'), [:])

// Step 2 - Click New Customer
TestObject newCusObj = findTestObject('Customer/link_NewCustomer')
WebElement linkCus = WebUiCommonHelper.findWebElement(newCusObj, 10)

WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(linkCus))

// Step 3 - Fill form
WebUI.setText(findTestObject('Customer/txt_customerName'), 'thu')

WebUI.click(findTestObject('Customer/radio_male'))

WebUI.setText(findTestObject('Customer/txt_dob'), '1990-01-01')

WebUI.setText(findTestObject('Customer/txt_address'), 'HCM city')

WebUI.setText(findTestObject('Customer/txt_city'), 'HCM')

WebUI.setText(findTestObject('Customer/txt_state'), 'HCM')

WebUI.setText(findTestObject('Customer/txt_pin'), '123456')

WebUI.setText(findTestObject('Customer/txt_phone'), '0988888888')

WebUI.setText(findTestObject('Customer/txt_email'), 'thu' + System.currentTimeMillis() + '@gmail.com')

WebUI.setText(findTestObject('Customer/txt_password'), '123456')

WebUI.click(findTestObject('Customer/btn_submitUpdate'))

// Step 4 - Lấy Customer ID
String accountID = WebUI.getText(findTestObject('Page_AddCustomer/lbl_customerID'))

// Step 5 - Lưu vào file
String projectDir = RunConfiguration.getProjectDir()

String accPath = projectDir + '/Data Files/CustomerID_List.csv'

File accFile = new File(accPath)

accFile.getParentFile().mkdirs()

accFile << accountID + '\n'

println('>>> ĐÃ LƯU CUSTOMER ID: ' + accountID)

// Step 6 - Logout
WebUI.callTestCase(findTestCase('Common/TC02_Logout'), [:])