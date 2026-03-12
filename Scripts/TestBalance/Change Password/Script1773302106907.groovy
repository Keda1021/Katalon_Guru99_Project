import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Đăng nhập
WebUI.openBrowser('https://demo.guru99.com/V4/')
WebUI.setText(findTestObject('Login/txt_Username'), 'mngr656064')
WebUI.setText(findTestObject('Login/txt_Password'), 'MatKhauMoi123!')
WebUI.click(findTestObject('Login/btn_Login'))

// 2. Đi tới trang Change Password
WebUI.click(findTestObject('Menu/link_ChangePassword'))

// 3. Điền thông tin mật khẩu
WebUI.setText(findTestObject('ChangePassword/txt_OldPassword'), 'MatKhauMoi123!')
WebUI.setText(findTestObject('ChangePassword/txt_NewPassword'), 'MatKhauMoi1234!')
WebUI.setText(findTestObject('ChangePassword/txt_ConfirmPassword'), 'MatKhauMoi1234!')

// 4. Submit
WebUI.click(findTestObject('ChangePassword/btn_SubmitPass'))

// 5. Thường hệ thống này sẽ trả ra một hộp thoại cảnh báo (Alert) thông báo thành công.
// Bạn bắt Alert và xác minh nội dung của nó.
WebUI.waitForAlert(5)
String alertText = WebUI.getAlertText()
WebUI.verifyMatch(alertText, '.*Password is Changed.*', true)
WebUI.acceptAlert()

WebUI.closeBrowser()