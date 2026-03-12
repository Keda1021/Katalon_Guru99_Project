import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import internal.GlobalVariable as GlobalVariable



// --- BƯỚC 1: TẠO EMAIL NGẪU NHIÊN (Để không bao giờ bị trùng) ---
String suffix = System.currentTimeMillis().toString().substring(8)
String randomEmail = 'kiet_' + suffix + '@gmail.com'

// --- BƯỚC 2: ĐIỀN FORM DÙNG BIẾN (Hứng dữ liệu từ CSV Binding) ---
WebUI.click(findTestObject('Object Repository/Page_Customer/link_NewCustomer'))

// Dùng các biến v_... đã khai báo trong tab Variables
WebUI.setText(findTestObject('Object Repository/Page_Customer/Customer_Name'), v_Name)

// Chọn Gender (Giả sử mặc định là Male, nếu muốn đổi có thể dùng biến v_Gender)
WebUI.click(findTestObject('Object Repository/Page_Customer/Gender'))

WebUI.setText(findTestObject('Object Repository/Page_Customer/Date_of_Birth'), v_Dob)

WebUI.setText(findTestObject('Object Repository/Page_Customer/Address'), v_Addr)

WebUI.setText(findTestObject('Object Repository/Page_Customer/City'), v_City)

WebUI.setText(findTestObject('Object Repository/Page_Customer/State'), v_State)

WebUI.setText(findTestObject('Object Repository/Page_Customer/PIN'), v_Pin)

WebUI.setText(findTestObject('Object Repository/Page_Customer/Mobile Number'), v_Mobile)

// Email dùng hàng auto-gen
WebUI.setText(findTestObject('Object Repository/Page_Customer/E-mail'), randomEmail)

WebUI.setText(findTestObject('Object Repository/Page_Customer/Password'), v_Pass)

// --- BƯỚC 3: SUBMIT VÀ LẤY ID ---
WebUI.click(findTestObject('Object Repository/Page_Customer/Submit Button'))

// Đợi ID xuất hiện và lấy giá trị
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Customer/lbl_CustomerID'), 15)
String customerID = WebUI.getText(findTestObject('Object Repository/Page_Customer/lbl_CustomerID'))

// --- BƯỚC 4: LƯU TRỮ DỮ LIỆU THÔNG MINH ---

// 1. Lưu vào GlobalVariable để các bài Account, Deposit chạy tiếp luôn trong Suite này
GlobalVariable.G_CustomerID = customerID
println('>>> DA LUU ID VAO GLOBAL: ' + GlobalVariable.G_CustomerID)

// 2. Lưu ra file CSV để làm bằng chứng (Evidence) hoặc dùng cho buổi demo khác
String filePath = RunConfiguration.getProjectDir() + '/Data Files/CustomerID_List.csv'
File file = new File(filePath)

// Tạo folder nếu chưa có
file.getParentFile().mkdirs()

// Kiểm tra: Nếu file chưa có hoặc trống thì ghi Header, nếu có rồi thì chỉ ghi ID mới
if (!file.exists() || file.length() == 0) {
    file.write("CustomerID\n")
}
file.append(customerID + "\n")

println('>>> DA LUU ID VAO FILE: ' + filePath)