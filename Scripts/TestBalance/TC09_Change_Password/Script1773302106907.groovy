import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// ==========================================
// 1. ĐĂNG NHẬP VỚI MẬT KHẨU GỐC
// ==========================================
WebUI.openBrowser(GlobalVariable.G_Url)

WebUI.setText(findTestObject('Login/txt_Username'), 'mngr656064')

WebUI.setText(findTestObject('Login/txt_Password'), 'MatKhauMoi12345!')

WebUI.click(findTestObject('Login/btn_Login'))

// Chờ trang Dashboard load xong để tránh lỗi WebElementNotFound
WebUI.waitForElementVisible(findTestObject('Menu/link_ChangePassword'), 10)

WebUI.waitForElementClickable(findTestObject('Menu/link_ChangePassword'), 10)

// ==========================================
// 2. THỰC HIỆN ĐỔI SANG MẬT KHẨU TẠM
// ==========================================
WebUI.click(findTestObject('Menu/link_ChangePassword'))

WebUI.setText(findTestObject('ChangePassword/txt_OldPassword'), 'MatKhauMoi12345!')

WebUI.setText(findTestObject('ChangePassword/txt_NewPassword'), 'MatKhauMoi1234!')

WebUI.setText(findTestObject('ChangePassword/txt_ConfirmPassword'), 'MatKhauMoi1234!')

WebUI.click(findTestObject('ChangePassword/btn_SubmitPass'))

// Bắt Alert báo thành công và đóng lại (web tự động văng ra trang Login)
WebUI.waitForAlert(5)

String alertText1 = WebUI.getAlertText()

WebUI.verifyMatch(alertText1, '.*Password is Changed.*', true)

WebUI.acceptAlert()

// ==========================================
// 3. TEARDOWN - ĐĂNG NHẬP LẠI & TRẢ LẠI MẬT KHẨU GỐC
// ==========================================
// Đăng nhập lại bằng MẬT KHẨU TẠM THỜI
WebUI.setText(findTestObject('Login/txt_Username'), 'mngr656064')

WebUI.setText(findTestObject('Login/txt_Password'), 'MatKhauMoi1234!')

WebUI.click(findTestObject('Login/btn_Login'))

// Chờ trang Dashboard load xong lần 2
WebUI.waitForElementVisible(findTestObject('Menu/link_ChangePassword'), 10)

WebUI.waitForElementClickable(findTestObject('Menu/link_ChangePassword'), 10)

// Vào lại menu Change Password
WebUI.click(findTestObject('Menu/link_ChangePassword'))

// Đổi ngược từ Mật khẩu tạm thời về lại Mật khẩu gốc
WebUI.setText(findTestObject('ChangePassword/txt_OldPassword'), 'MatKhauMoi1234!')

WebUI.setText(findTestObject('ChangePassword/txt_NewPassword'), 'MatKhauMoi12345!')

WebUI.setText(findTestObject('ChangePassword/txt_ConfirmPassword'), 'MatKhauMoi12345!')

WebUI.click(findTestObject('ChangePassword/btn_SubmitPass'))

// Bắt Alert báo thành công lần 2 và đóng lại
WebUI.waitForAlert(5)

String alertText2 = WebUI.getAlertText()

WebUI.verifyMatch(alertText2, '.*Password is Changed.*', true)

WebUI.acceptAlert()

WebUI.closeBrowser()

