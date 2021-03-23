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

'Get First Inspection ID'
Inspection_ID = WebUI.getText(findTestObject('Page_Inspections Dashboard/First_Inspection_ID'))

'Get First Inspection Date'
Expected_Inspection_Date = WebUI.getText(findTestObject('Page_Inspections Dashboard/First_Inspection_Date'))

'Click on First Inspection Date'
WebUI.click(findTestObject('Page_Inspections Dashboard/First_Inspection_Date'))

'Verify Change Inspection Popup title'
WebUI.verifyElementText(findTestObject('Page_Inspections Dashboard/Change_Inspection_Date_popup/Popup_title'), 'Change Inspection Date')

'Verify info message of Please change date and time'
WebUI.verifyElementText(findTestObject('Page_Inspections Dashboard/Change_Inspection_Date_popup/Info_message'), 'Please change the date and time only in exceptional situations as the date and time have been communicated to the client and landlord. Do you want to proceed?')

'Verify \'Yes\' button is visible or not'
WebUI.verifyElementVisible(findTestObject('Page_Inspections Dashboard/Change_Inspection_Date_popup/Yes_button'))

'Verify \'No\' button is visible or not'
WebUI.verifyElementVisible(findTestObject('Page_Inspections Dashboard/Change_Inspection_Date_popup/No_button'))

'Click on \'Yes\' button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Change_Inspection_Date_popup/Yes_button'))

'Set today\'s date for re schedule the inspection'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Change_Inspection_Date_popup/Reschedule_Date'), now)

'Click on date picker for close the date picker'
WebUI.click(findTestObject('Page_Inspections Dashboard/Change_Inspection_Date_popup/Date_picker'))

'Wait for the 2 seconds'
WebUI.delay(2)

'Click on Any time radio button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Change_Inspection_Date_popup/Anytime_radio'))

'Click on Propose inspection time radio button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Change_Inspection_Date_popup/Propose_inspection_button'))

'wait for 5 seconds'
WebUI.delay(5)

'Select suitable time radio button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Change_Inspection_Date_popup/Select_date_time_radio'))

'Click on Save button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Change_Inspection_Date_popup/Save_button'))

'Wait for 5 seconds'
WebUI.delay(5)

'Refresh the page'
WebUI.refresh()

'Enter inspection id which we changed'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_id_Filter'), Inspection_ID)

'Get inspection date'
Actual_Inspection_Date = WebUI.getText(findTestObject('Page_Inspections Dashboard/First_Inspection_Date'))

'Compare expected and actual inspection time. which is updated or not'
WebUI.verifyNotMatch(Actual_Inspection_Date, Expected_Inspection_Date, false)

WebUI.closeBrowser()

