import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// login
WebUI.callTestCase(findTestCase('Common/TC01_Login_Success'), [:], FailureHandling.STOP_ON_FAILURE)

// click delete account
WebUI.click(findTestObject('Page_Account/a_Delete Account'))

// lấy đường dẫn project
String projectDir = RunConfiguration.getProjectDir()

// đọc file CSV
String filePath = projectDir + '/Data Files/AccountID_List.csv'

File file = new File(filePath)

List<String> allLines = file.readLines()

String lastAccountID = allLines.last().trim()

// nhập account id
WebUI.setText(findTestObject('Page_Account/input_Account No_accountno'), lastAccountID)

// submit
WebUI.click(findTestObject('Page_Account/submit_delete'))

// accept alert
WebUI.acceptAlert()

WebUI.acceptAlert()

