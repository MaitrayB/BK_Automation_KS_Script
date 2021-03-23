import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def now = new Date().format('MM/dd/yyyy')

println("now = $now")

'Browser opened'
WebUI.openBrowser('')

'Browser window maximized'
WebUI.maximizeWindow()

'Navigated to application URL'
WebUI.navigateToUrl(GlobalVariable.URL)

'Enter Username'
WebUI.setText(findTestObject('Object Repository/Page_BoodsKapper/input_Customer Login_email'), GlobalVariable.Inspector_username)

'Enter Password'
WebUI.setText(findTestObject('Object Repository/Page_BoodsKapper/input_Customer Login_password'), GlobalVariable.Inspector_password)

'Click on login button'
WebUI.click(findTestObject('Object Repository/Page_BoodsKapper/button_Login'))

'Click on Inspection Dashboard link'
WebUI.click(findTestObject('Page_BoodsKapper/a_Case_Dashboard'))

'Switch to inspection dashboard tab'
WebUI.switchToWindowTitle('Case Management Dashboard')

WebUI.click(findTestObject('Page_Case_Dashboard/Add_Case'))

WebUI.click(findTestObject('Page_Case_Dashboard/Case_Popup/input_client_name'))

WebUI.sendKeys(findTestObject('Page_Case_Dashboard/Case_Popup/input_client_name'), findTestData('Case_Data').getValue(1, 
        1))

'Selected client'
WebUI.sendKeys(findTestObject('Page_Case_Dashboard/Case_Popup/input_client_name'), Keys.chord(Keys.ARROW_DOWN))

WebUI.click(findTestObject('Page_Case_Dashboard/Case_Popup/Creating_Case_for'))

//String a = "findTestData('Case_Data').getValue(3,1))";
String Creating_Case_for = findTestData('Case_Data').getValue(3, 1)

if (Creating_Case_for == 'Client') {
    WebUI.click(findTestObject('Page_Case_Dashboard/Case_Popup/Case_for_Client'))
} else {
    WebUI.click(findTestObject('Page_Case_Dashboard/Case_Popup/Case_for_Landlord'))
}

WebUI.click(findTestObject('Page_Case_Dashboard/Case_Popup/Reason'))

WebUI.click(findTestObject('Page_Case_Dashboard/Case_Popup/Select_reason'))

WebUI.click(findTestObject('Page_Case_Dashboard/Case_Popup/Create'))

WebUI.verifyElementText(findTestObject('Page_Case_Dashboard/Case_Popup/Create_Case_Label'), 'Create a Case')

WebUI.verifyElementVisible(findTestObject('Page_Case_Dashboard/Case_Popup/Close_icon'))

WebUI.verifyElementVisible(findTestObject('Page_Case_Dashboard/Case_Popup/Success_Icon'))

WebUI.verifyElementVisible(findTestObject('Page_Case_Dashboard/Case_Popup/Close_button'))

WebUI.click(findTestObject('Page_Case_Dashboard/Case_Popup/Close_button'))

WebUI.verifyElementText(findTestObject('Page_Case_Dashboard/Add_a_case_manager_text'), 'Add a Case Manager')

WebUI.verifyElementText(findTestObject('Page_Case_Dashboard/Reason_text'), findTestData('Case_Data').getValue(4, 1))

GlobalVariable.Case_ID = WebUI.getText(findTestObject('Page_Case_Dashboard/Case_ID'))

