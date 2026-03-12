import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// 1. Mở trình duyệt và truy cập trang web
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.G_Url)

WebUI.maximizeWindow()

// 2. Login (Sửa lại đường dẫn có thư mục trung gian Page_Guru99 Bank Home Page)
// Lưu ý: txt_UserID và txt_password phải khớp chính xác từng chữ cái như trong hình
WebUI.setText(findTestObject('Page_Login/Page_Guru99 Bank Home Page/txt_UserID'), 'mngr655719')

WebUI.setText(findTestObject('Page_Login/Page_Guru99 Bank Home Page/txt_password'), 'UjymEsA')

WebUI.click(findTestObject('Page_Login/Page_Guru99 Bank Home Page/btn_login'))

// 3. Chuyển sang trang Deposit (Các Object này nằm trực tiếp trong thư mục Deposit)
WebUI.click(findTestObject('Deposit/link_Deposit'))

// 4. Nhập dữ liệu Deposit
WebUI.setText(findTestObject('Deposit/txt_AccountNo'), '180566')

WebUI.setText(findTestObject('Deposit/txt_Amount'), '500')

WebUI.setText(findTestObject('Deposit/txt_Description'), 'Deposit Test')

// 5. Submit
WebUI.click(findTestObject('Deposit/Submit'))

// 6. Kiểm tra kết quả
WebUI.verifyTextPresent('Transaction details of Deposit', false)

// Đóng trình duyệt
WebUI.closeBrowser()

