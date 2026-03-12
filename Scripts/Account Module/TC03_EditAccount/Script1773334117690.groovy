import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// LOGIN
WebUI.callTestCase(findTestCase('Common/TC01_Login_Success'), [:], FailureHandling.STOP_ON_FAILURE)

// CLICK EDIT ACCOUNT
WebUI.click(findTestObject('Page_Account/a_Edit Account'))

// LẤY ACCOUNT ID TỪ FILE
String projectDir = RunConfiguration.getProjectDir()

String filePath = projectDir + '/Data Files/AccountID_List.csv'

File file = new File(filePath)

if (file.exists()) {
    List<String> allLines = file.readLines()

    if (allLines.size() > 0) {
        String lastAccountID = allLines.last().trim()

        println('>>> Account ID: ' + lastAccountID)

        WebUI.setText(findTestObject('Page_Account/input_Account No_accountno'), lastAccountID)

        WebUI.click(findTestObject('Page_Account/submit_edit'))

        // Đợi trang Edit Account
        WebUI.waitForElementVisible(findTestObject('Page_EditAccount/select_accounttype'), 10)

        // Đổi loại account
        WebUI.selectOptionByLabel(findTestObject('Page_EditAccount/select_accounttype'), 'Current', false)

        WebUI.click(findTestObject('Page_Account/submit_edit'))

        println('>>> Edit Account thành công')
    }
}

