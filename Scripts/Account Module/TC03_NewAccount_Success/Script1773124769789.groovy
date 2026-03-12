import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

// 1. LOGIN
// 2. VÀO TRANG NEW ACCOUNT (Dùng JS Click)
WebElement linkAcc = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_Home/link_NewAccount'), 10)

WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(linkAcc))

// 3. ĐỌC CUSTOMER ID TỪ FILE CỦA KIỆT
String projectDir = RunConfiguration.getProjectDir()

String filePath = projectDir + '/Data Files/CustomerID_List.csv'

File file = new File(filePath)

if (file.exists()) {
    List<String> allLines = file.readLines()

    // Lấy dòng cuối cùng, loại bỏ khoảng trắng
    String lastCustomerID = allLines.last().trim()

    println('>>> Đã lấy được ID: ' + lastCustomerID)

    WebUI.setText(findTestObject('Object Repository/Page_Home/input_CustomerID'), lastCustomerID)

    WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Home/Select_AccountType'), 'Savings', false)

    WebUI.setText(findTestObject('Object Repository/Page_Home/Initial_Deposit'), '500')

    WebUI.click(findTestObject('Object Repository/Page_Home/Submit_Button'))

    // --- THÊM BƯỚC NÀY ---
    // Đợi và chấp nhận Alert nếu có (Guru99 rất hay hiện Alert sau khi Submit)
    if (WebUI.verifyAlertPresent(5, FailureHandling.OPTIONAL)) {
        WebUI.acceptAlert()
    }
    
    // 5. LẤY ACCOUNT ID VÀ LƯU LẠI
    WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Account/lbl_AccountID'), 10)

    String accountID = WebUI.getText(findTestObject('Object Repository/Page_Account/lbl_AccountID'))

    // Kiểm tra giá trị trước khi ghi
    if ((accountID != null) && (accountID != '')) {
        String accPath = projectDir + '/Data Files/AccountID_List.csv'

        File accFile = new File(accPath)

        // Đảm bảo thư mục tồn tại
        accFile.getParentFile().mkdirs()

        accFile.append(accountID + '\n')

        println('>>> ĐÃ LƯU ACCOUNT ID THÀNH CÔNG: ' + accountID)
    } else {
        println('>>> CẢNH BÁO: accountID lấy được bị RỖNG, không có gì để ghi!')
    }
}

