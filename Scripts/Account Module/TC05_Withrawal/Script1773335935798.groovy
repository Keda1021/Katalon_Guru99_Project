import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://demo.guru99.com/V4/')

//Login
WebUI.setText(findTestObject('Page_Login/txt_UserID'), 'mngr655719')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'UjymEsA')
WebUI.click(findTestObject('Page_Login/btn_login'))
//Go to Withdrawal page
WebUI.click(findTestObject('Withdrawal/link_Withdrawal'))

//Input withdrawal info
WebUI.setText(findTestObject('Withdrawal/txt_AccountNo'), '180566')
WebUI.setText(findTestObject('Withdrawal/txt_Amount'), '100')
WebUI.setText(findTestObject('Withdrawal/txt_Description'), 'Withdraw Test')

//Submit
WebUI.click(findTestObject('Withdrawal/btn_Submit'))

//Verify
WebUI.verifyTextPresent('Transaction details of Withdrawal', false)

WebUI.closeBrowser()