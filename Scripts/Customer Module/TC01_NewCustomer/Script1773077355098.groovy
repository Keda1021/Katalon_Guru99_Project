import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

// --- BƯỚC 1: GỌI LOGIN (Đã khớp tên TC01_Login_Success) ---
WebUI.callTestCase(findTestCase('Test Cases/Common/TC01_Login_Success'), [:], FailureHandling.STOP_ON_FAILURE)

// --- BƯỚC 2: TẠO DATA NGẪU NHIÊN ---
String suffix = System.currentTimeMillis().toString().substring(8)

String randomEmail = ('kiet_' + suffix) + '@gmail.com'

// --- BƯỚC 3: ĐIỀN FORM (Đã khớp folder Page_AddCustomer) ---
WebUI.click(findTestObject('Object Repository/Page_AddCustomer/link_NewCustomer'))

WebUI.setText(findTestObject('Object Repository/Page_AddCustomer/Customer_Name'), 'Kiet')

WebUI.click(findTestObject('Object Repository/Page_AddCustomer/Gender'))

WebUI.setText(findTestObject('Object Repository/Page_AddCustomer/Date_of_Birth'), '01011995')

WebUI.setText(findTestObject('Object Repository/Page_AddCustomer/Address'), '123 HCM City')

WebUI.setText(findTestObject('Object Repository/Page_AddCustomer/City'), 'Saigon')

WebUI.setText(findTestObject('Object Repository/Page_AddCustomer/State'), 'District')

WebUI.setText(findTestObject('Object Repository/Page_AddCustomer/PIN'), '123456')

WebUI.setText(findTestObject('Object Repository/Page_AddCustomer/Mobile Number'), '0901234567')

WebUI.setText(findTestObject('Object Repository/Page_AddCustomer/E-mail'), randomEmail)

WebUI.setText(findTestObject('Object Repository/Page_AddCustomer/Password'), '123456')

// --- BƯỚC 4: SUBMIT VÀ LẤY ID ---
WebUI.click(findTestObject('Object Repository/Page_AddCustomer/Submit Button'))

// 1. Đợi ID xuất hiện và lấy giá trị
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_AddCustomer/lbl_CustomerID'), 15)

String customerID = WebUI.getText(findTestObject('Object Repository/Page_AddCustomer/lbl_CustomerID'))

// 2. Lưu vào GlobalVariable để chạy Suite liên tục
GlobalVariable.G_CustomerID = customerID

println('>>> DA LUU ID VAO GLOBAL: ' + GlobalVariable.G_CustomerID)

// 3. LƯU RA FILE CSV ĐỂ CHIA SẺ CHO NHÓM
// Đường dẫn sẽ nằm ngay trong folder dự án của bạn cho dễ tìm
String filePath = RunConfiguration.getProjectDir() + '/Data Files/CustomerID_List.csv'

// Nội dung ghi vào file (CustomerID)
File file = new File(filePath)

// Kiểm tra nếu folder Data Files chưa có thì tạo mới
file.getParentFile().mkdirs()

// Ghi đè (hoặc dùng .append nếu muốn lưu dồn nhiều ID qua các lần chạy)
file.append('CustomerID\n' + customerID)

println('>>> DA LUU ID VAO FILE: ' + filePath)

WebUI.callTestCase(findTestCase('Common/TC02_Logout'), [:], FailureHandling.STOP_ON_FAILURE)

