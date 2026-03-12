import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

// 1. LOGIN
WebUI.callTestCase(findTestCase('Test Cases/Common/TC01_Login_Success'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. VÀO TRANG NEW ACCOUNT (Dùng JS Click)
WebElement linkAcc = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_Home/link_NewAccount'), 10)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(linkAcc))

// 3. ĐỌC CUSTOMER ID TỪ FILE CỦA KIỆT
String projectDir = RunConfiguration.getProjectDir()
String filePath = projectDir + "/Data Files/CustomerID_List.csv"
File file = new File(filePath)

if (file.exists()) {
	List<String> allLines = file.readLines()
	// Lấy dòng cuối cùng, loại bỏ khoảng trắng
	String lastCustomerID = allLines.last().trim()
	println ">>> Đã lấy được ID: " + lastCustomerID

	// 4. ĐIỀN FORM
	WebUI.setText(findTestObject('Object Repository/Page_Home/input_CustomerID'), lastCustomerID)
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Home/Select_AccountType'), 'Savings', false)
	WebUI.setText(findTestObject('Object Repository/Page_Home/Initial_Deposit'), '500')
	WebUI.click(findTestObject('Object Repository/Page_Home/Submit_Button'))

	// 5. LẤY ACCOUNT ID VÀ LƯU LẠI
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Account/lbl_AccountID'), 10)
	String accountID = WebUI.getText(findTestObject('Object Repository/Page_Account/lbl_AccountID'))
	
	String accPath = projectDir + "/Data Files/AccountID_List.csv"
	new File(accPath).append(accountID + "\n")
	println ">>> ĐÃ LƯU ACCOUNT ID: " + accountID
} else {
	println ">>> LỖI: Không tìm thấy file CSV tại " + filePath
}

// 6. LOGOUT
WebUI.callTestCase(findTestCase('Test Cases/Common/TC02_Logout'), [:], FailureHandling.STOP_ON_FAILURE)