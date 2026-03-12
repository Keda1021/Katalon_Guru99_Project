import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://demo.guru99.com/V4/')

//Login
WebUI.setText(findTestObject('Page_Login/txt_UserID'), 'mngr655719')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'UjymEsA')
WebUI.click(findTestObject('Page_Login/btn_login'))
//Go to Fund Transfer
WebUI.click(findTestObject('FundTransfer/link_FundTransfer'))

//Input transfer info
WebUI.setText(findTestObject('FundTransfer/txt_PayersAccountNo'), '180566')
WebUI.setText(findTestObject('FundTransfer/txt_PayeesAccountNo'), '180566')
WebUI.setText(findTestObject('FundTransfer/txt_Amount'), '200')
WebUI.setText(findTestObject('FundTransfer/txt_Description'), 'Transfer Test')

//Submit
WebUI.click(findTestObject('FundTransfer/btn_Submit'))

//Verify result
WebUI.verifyTextPresent('Fund Transfer Details', false)

WebUI.closeBrowser()