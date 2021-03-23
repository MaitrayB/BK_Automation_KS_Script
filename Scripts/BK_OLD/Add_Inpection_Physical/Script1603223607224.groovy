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
WebUI.click(findTestObject('Object Repository/Page_BoodsKapper/a_Inspections Dashboard'))

'Switch to inspection dashboard tab'
WebUI.switchToWindowTitle('Inspections Dashboard')

'Click on Add Inspection button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/a_Add Inspection'))

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Client Name_completer-input form-cont_f62931'))

'Enter client email'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Client Name_completer-input form-cont_f62931'), 
    findTestData('Inspection_Data').getValue(1, 2))

'Selected client'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Client Name_completer-input form-cont_f62931'), 
    Keys.chord(Keys.ARROW_DOWN))

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Landlord'))

'Enter landlord email'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Landlord'), findTestData('Inspection_Data').getValue(
        2, 2))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Landlord'), Keys.chord(Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Landlord'), Keys.chord(Keys.BACK_SPACE))

WebUI.delay(2)

'Selected landlord'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Landlord'), Keys.chord(Keys.ARROW_DOWN))

WebUI.delay(1)

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Unit_Address'))

'Enter Unit address no'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Unit_Address'), findTestData('Inspection_Data').getValue(
        4, 2))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Unit_Address'), Keys.chord(Keys.BACK_SPACE))

WebUI.delay(2)

'Selected address'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Unit_Address'), Keys.chord(Keys.ARROW_DOWN))

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Select_InspectionType'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'Selected inspection type'
WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/span_Housekeeping'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Method_listbox'))

'Selected inspection method as physical'
WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Onsite_Method'))

WebUI.delay(1)

'Entered from date'
WebUI.setText(findTestObject('Page_Inspections Dashboard/Inspection_Popup/From_date'), now)

'Entered To date'
WebUI.setText(findTestObject('Page_Inspections Dashboard/Inspection_Popup/To_date'), now)

'Clicked on Anytime radio button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Anytime_Radio'))

'Clicked on Propose time button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Propose_Time_Button'))

'Selected Time slots radio'
WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/TimeSlot_Radio'))

'Click on Create button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Create_Button'))

WebUI.delay(2)

'Entered date in filter criteria'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Date_Filter'), now)

WebUI.delay(2)

'Enter address no in address filter criteria'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Unit_Address_Filter'), findTestData('Inspection_Data').getValue(
        4, 2))

WebUI.delay(2)

'Enter address no in address filter criteria'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Unit_Address_Filter'), Keys.chord(Keys.SPACE))

WebUI.delay(2)

'Verify address matches'
WebUI.verifyElementText(findTestObject('Page_Inspections Dashboard/Address_Field'), findTestData('Inspection_Data').getValue(
        5, 2))

WebUI.delay(3)

'Close browser'
WebUI.closeBrowser()

