import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// 1. Đăng nhập
WebUI.openBrowser(GlobalVariable.G_Url)

WebUI.setText(findTestObject('Login/txt_Username'), 'mngr656064')

WebUI.setText(findTestObject('Login/txt_Password'), 'MatKhauMoi12345!')

WebUI.click(findTestObject('Login/btn_Login'))

// 2. Đi tới trang Balance Enquiry
WebUI.click(findTestObject('Menu/link_BalanceEnquiry'))

// 3. Nhập số tài khoản và Submit
WebUI.setText(findTestObject('BalanceInquiry/txt_AccountNo'), '180542' // Nhập Account ID thật ở đây
    )

WebUI.click(findTestObject('BalanceInquiry/btn_Submit'))

// 4. Xác minh bảng chi tiết số dư đã hiển thị thành công
WebUI.verifyElementVisible(findTestObject('BalanceInquiry/lbl_BalanceResult'))

WebUI.closeBrowser()

