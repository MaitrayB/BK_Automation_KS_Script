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

//def now = '01/07/2021'
println("now = $now")

'Browser opened'
WebUI.openBrowser('')

'Browser window maximized'
WebUI.maximizeWindow()

'Navigated to application URL'
WebUI.navigateToUrl('https://bob.ai/')

WebUI.click(findTestObject('Bob_login/Login_link'))

'Enter Username'
WebUI.setText(findTestObject('Bob_login/Input_useremail'), 'inspector.of.pha@gmail.com')

'Enter Password'
WebUI.setText(findTestObject('Bob_login/Input_password'), 'Bk@12345')

'Click on login button'
WebUI.click(findTestObject('Bob_login/Submit_Button'))

'Selected inspection type'
WebUI.delay(3)

'Click on Inspection Dashboard link'
WebUI.click(findTestObject('Bob_Dashboard/Inspection_Menu'))

'Selected inspection type'
WebUI.delay(3)

'Switch to inspection dashboard tab'
WebUI.switchToWindowTitle('Inspection Dashboard')

int count = 1

for (def index : (count..13)) {
    'Click on Add Inspection button'
    WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/a_Add Inspection'))

    WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Client Name_completer-input form-cont_f62931'))

    'Enter client email'
    WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Client Name_completer-input form-cont_f62931'), 
        findTestData('Prod_Inspection_data').getValue(3, count))

    'Selected inspection type'
    WebUI.delay(1)

    'Selected client'
    WebUI.sendKeys(findTestObject('Page_Inspections Dashboard/Inspection_Popup/input_Client Name_completer-input form-cont_f62931'), 
        Keys.chord(Keys.ARROW_DOWN))

    WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Select_InspectionType'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    switch (findTestData('Prod_Inspection_data').getValue(1, count)) {
        case 'Housekeeping':
            WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/span_Housekeeping'), FailureHandling.STOP_ON_FAILURE)

            break
        case 'Initial':
            WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/span_Initial'), FailureHandling.STOP_ON_FAILURE)

            break
        case 'Complaint':
            WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/span_Complaint'), FailureHandling.STOP_ON_FAILURE)

            break
        case 'Annual':
            WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/span_Annual'), FailureHandling.STOP_ON_FAILURE)

            break
        default:
            break
    }
    
    'Selected inspection type'
    WebUI.delay(1)

    WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Method_listbox'))

    'Selected inspection method as physical'
    switch (findTestData('Prod_Inspection_data').getValue(2, count)) {
        case 'Physical 1':
            WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Onsite_Method'))

            break
        case 'Physical 2':
            WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Onsite_Method'))

            break
        case 'Virtual':
            WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Virtual_method'))

            break
        default:
            break
    }
    
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

    WebUI.delay(2)

    'Click on Create button'
    WebUI.click(findTestObject('Page_Inspections Dashboard/Inspection_Popup/Create_Button'))

    WebUI.delay(2)

    count = (count + 1)
}

'Close browser'
WebUI.closeBrowser()

