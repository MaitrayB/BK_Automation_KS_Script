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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.setText(findTestObject('Object Repository/Page_BoodsKapper/input_Customer Login_email'), GlobalVariable.Inspector_username)

WebUI.setText(findTestObject('Object Repository/Page_BoodsKapper/input_Customer Login_password'), GlobalVariable.Inspector_password)

WebUI.click(findTestObject('Object Repository/Page_BoodsKapper/button_Login'))

WebUI.click(findTestObject('Object Repository/Page_BoodsKapper/a_Inspections Dashboard'))

WebUI.switchToWindowTitle('Inspections Dashboard')

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/a_Add Inspection'))

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Client Name_completer-input form-cont_f62931'))

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Client Name_completer-input form-cont_f62931'), 
    findTestData('Inspection_Data').getValue(1, 1))

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Client Name_completer-input form-cont_f62931'), 
    Keys.chord(Keys.ARROW_DOWN))

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Landlord'))

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Landlord'), findTestData('Inspection_Data').getValue(
        2, 1))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Landlord'), Keys.chord(Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Landlord'), Keys.chord(Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Landlord'), Keys.chord(Keys.ARROW_DOWN))

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Unit_Address'))

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Unit_Address'), findTestData('Inspection_Data').getValue(
        4, 1))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Unit_Address'), Keys.chord(Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Unit_Address'), Keys.chord(Keys.ARROW_DOWN))

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Select_InspectionType'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/span_Housekeeping'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Method_listbox'))

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Virtual_method'))

WebUI.delay(1)

WebUI.setText(findTestObject('Page_Inspections Dashboard/Inspection_Popup/From_date'), now)

WebUI.deleteAllCookies(FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Page_Inspections Dashboard/Inspection_Popup/To_date'), now)

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Anytime_Radio'))

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Propose_Time_Button'))

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/TimeSlot_Radio'))

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Create_Button'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Date_Filter'), now)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Unit_Address_Filter'), findTestData('Inspection_Data').getValue(
        4, 1))

WebUI.delay(2)

'Enter address no in address filter criteria'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Unit_Address_Filter'), Keys.chord(Keys.SPACE))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('Page_Inspections Dashboard/Address_Field'), findTestData('Inspection_Data').getValue(
        5, 1))

WebUI.delay(3)

WebUI.closeBrowser()

