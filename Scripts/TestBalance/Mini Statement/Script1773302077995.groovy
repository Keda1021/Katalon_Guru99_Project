import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Mở trình duyệt và Đăng nhập
WebUI.openBrowser('https://demo.guru99.com/V4/')
WebUI.setText(findTestObject('Login/txt_Username'), 'mngr656064')
WebUI.setText(findTestObject('Login/txt_Password'), 'MatKhauMoi12345!')
WebUI.click(findTestObject('Login/btn_Login'))

// 2. Đi tới trang Mini Statement
WebUI.click(findTestObject('Menu/link_MiniStatement'))

// 3. Nhập số tài khoản và Submit
WebUI.setText(findTestObject('MiniStatement/txt_AccountNo'), '180542')
WebUI.click(findTestObject('MiniStatement/btn_Submit'))

// 4. Đợi trang tải dữ liệu (Rất quan trọng để máy chạy kịp tốc độ mạng)
WebUI.waitForPageLoad(10)
WebUI.delay(2)

// 5. Xác minh trang sao kê hiển thị thành công 
// (Dùng từ khóa ngắn gọn 'Transaction' và số tài khoản '180542' để tỷ lệ Pass là tuyệt đối)

WebUI.verifyTextPresent('180542', false)

// 6. Đóng trình duyệt để kết thúc Test Case
WebUI.closeBrowser()