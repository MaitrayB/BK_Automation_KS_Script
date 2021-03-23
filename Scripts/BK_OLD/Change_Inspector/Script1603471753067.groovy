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

'Enter inspector name in filter'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspector_Filter'), findTestData('Inspection_Data').getValue(6, 
        3))

'Get inspection ID'
Inspection_ID = WebUI.getText(findTestObject('Page_Inspections Dashboard/First_Inspection_ID'))

'Get inspected name for compare'
Expected_Inspector_Name = WebUI.getText(findTestObject('Page_Inspections Dashboard/First_Inspector_Name'))

'Click on first inspector'
WebUI.click(findTestObject('Page_Inspections Dashboard/First_Inspector_Name'))

'Verify the title of update inspector'
WebUI.verifyElementText(findTestObject('Page_Inspections Dashboard/Change_Inspector_popup/Popup_title'), 'Change Inspector')

'Verify inspector label text'
WebUI.verifyElementText(findTestObject('Page_Inspections Dashboard/Change_Inspector_popup/Change_inspector_label'), 'Please give the reason for changing the inspector. *')

'Enter change inspector reason'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Change_Inspector_popup/Change_inspector_reason_input'), 'Inspector is ill. Automation test ' + 
    now)

'Click on submit button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Change_Inspector_popup/Submit_button'))

'Verify change inspector info message'
WebUI.verifyElementText(findTestObject('Page_Inspections Dashboard/Change_Inspector_popup/Change_inspector_info_message'), 
    'When you replace an inspector routes are not likely to be optimum. Please proceed with the manual change if there is a business need. You will be shown a list of available inspectors')

'Click on Change inspector button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Change_Inspector_popup/Change_inspector_button'))

'Verify info text'
WebUI.verifyElementText(findTestObject('Page_Inspections Dashboard/Change_Inspector_popup/Please_do_Label'), 'Please do this only in exceptional situations. What is the reason for overriding the optimizer? *')

'Enter change inspector reason'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Change_Inspector_popup/Change_inspector__reason_second_time'), 
    'Inspector is ill. Automation test ' + now)

'Click on new time radio button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Change_Inspector_popup/New_time_radio'))

'Click on submit button'
WebUI.click(findTestObject('Page_Inspections Dashboard/Change_Inspector_popup/Submit_button'))

'Wait for 7 seconds'
WebUI.delay(7)

'Clear the inspector name from the filter'
WebUI.clearText(findTestObject('Page_Inspections Dashboard/Inspector_Filter'))

'Refresh the page'
WebUI.refresh()

'Enter inspection ID in filter'
WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_id_Filter'), Inspection_ID)

'Get Actual inspector name for that inspection ID'
Actual_Inspector_Name = WebUI.getText(findTestObject('Page_Inspections Dashboard/First_Inspector_Name'))

'Compare expected and actual inspector name'
WebUI.verifyNotMatch(Actual_Inspector_Name, Expected_Inspector_Name, false)

WebUI.closeBrowser()

