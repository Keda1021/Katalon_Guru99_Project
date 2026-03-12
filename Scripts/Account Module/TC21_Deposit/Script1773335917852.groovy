import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Open browser
WebUI.openBrowser('')
WebUI.navigateToUrl('https://demo.guru99.com/V4/')

//Login
WebUI.setText(findTestObject('Page_Login/txt_UserID'), 'mngr655719')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'UjymEsA')
WebUI.click(findTestObject('Page_Login/btn_login'))
//Go to Deposit page
WebUI.click(findTestObject('Deposit/link_Deposit'))

//Input data
WebUI.setText(findTestObject('Deposit/txt_AccountNo'), '180566')
WebUI.setText(findTestObject('Deposit/txt_Amount'), '500')
WebUI.setText(findTestObject('Deposit/txt_Description'), 'Deposit Test')

//Submit
WebUI.click(findTestObject('Deposit/btn_Submit'))

//Verify result
WebUI.verifyTextPresent('Transaction details of Deposit', false)

WebUI.closeBrowser()