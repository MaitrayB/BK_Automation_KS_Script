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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.base_url)

WebUI.click(findTestObject('Bob_login/Login_link'))

WebUI.sendKeys(findTestObject('Bob_login/Input_useremail'), GlobalVariable.Email)

WebUI.sendKeys(findTestObject('Bob_login/Input_password'), GlobalVariable.password)

WebUI.click(findTestObject('Bob_login/Submit_Button'))

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('Bob_Dashboard/Manage_RFTA'))

WebUI.switchToWindowIndex('1')

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('Bob_Manage_RFTA/Create_RFTA'))

WebUI.waitForElementVisible(findTestObject('Bob_Create_RFTA/Search_Agency_Input'), 0)

WebUI.sendKeys(findTestObject('Bob_Create_RFTA/Search_Agency_Input'), 'tx009')

WebUI.delay(4)

WebUI.click(findTestObject('Bob_Create_RFTA/Select_Agency'))

WebUI.sendKeys(findTestObject('Bob_Create_RFTA/First_Name'), findTestData('Bob_RFTA').getValue('Filed_Value', 1))

WebUI.sendKeys(findTestObject('Bob_Create_RFTA/Last_Name'), findTestData('Bob_RFTA').getValue('Filed_Value', 2))

WebUI.sendKeys(findTestObject('Bob_Create_RFTA/Email'), findTestData('Bob_RFTA').getValue('Filed_Value', 3))

WebUI.click(findTestObject('Bob_Create_RFTA/Save_Button'))

WebUI.sendKeys(findTestObject('Bob_Create_RFTA/Monthly_Rent'), '440')

WebUI.click(findTestObject('Bob_Create_RFTA/Allow_Pets_Radio'))

WebUI.click(findTestObject('Bob_Create_RFTA/User_Type_Radio'))

WebUI.click(findTestObject('Bob_Create_RFTA/Number_Of_Bedroom_Radio'))

WebUI.sendKeys(findTestObject('Bob_Create_RFTA/Street_Input'), findTestData('Bob_RFTA').getValue('Filed_Value', 4))

WebUI.sendKeys(findTestObject('Bob_Create_RFTA/House_Input'), findTestData('Bob_RFTA').getValue('Filed_Value', 5))

WebUI.sendKeys(findTestObject('Bob_Create_RFTA/City_Input'), findTestData('Bob_RFTA').getValue('Filed_Value', 6))

WebUI.selectOptionByValue(findTestObject('Bob_Create_RFTA/State_Dropdown'), 'TX', false)

WebUI.sendKeys(findTestObject('Bob_Create_RFTA/ZipCode_Inpt'), findTestData('Bob_RFTA').getValue('Filed_Value', 7))

WebUI.click(findTestObject('Bob_Create_RFTA/Button_Next'))

WebUI.click(findTestObject('Bob_Create_RFTA/Main_Next_Button'))

WebUI.delay(5)

WebUI.click(findTestObject('Bob_Create_RFTA/Save_As_New_Plan'))

WebUI.delay(10)

WebUI.click(findTestObject('Bob_Create_RFTA/Rent_Responsibility'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Create_RFTA/Signature_icon'))

WebUI.click(findTestObject('Bob_Create_RFTA/Digital_Signature_Verification_Yes_Radio'))

WebUI.click(findTestObject('Bob_Create_RFTA/Confirm_Button_Digital_Sign_Popup'))

WebUI.click(findTestObject('Bob_Create_RFTA/Digital_Signature_OK_Popup'))

WebUI.click(findTestObject('Bob_Create_RFTA/Digital_Signature_Gotit_Popup'))

WebUI.click(findTestObject('Bob_Create_RFTA/Rent_Responsibility_Save'))

WebUI.delay(15)

WebUI.sendKeys(findTestObject('Bob_Additional_Amenities/Year_Built'), '2012')

WebUI.sendKeys(findTestObject('Bob_Additional_Amenities/Square_Footage'), '191')

WebUI.click(findTestObject('Bob_Additional_Amenities/Bathroom_Radio'))

WebUI.sendKeys(findTestObject('Bob_Additional_Amenities/Bathroom_Input'), '1')

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Carpet'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Fireplace'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_AirCondition'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Garbage'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Dishwasher'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Microwave'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Store_Room'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Celling_Fan'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Handicap'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Assign_Parking'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Garage'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Carport'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Storm_Door'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Playground'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Hookup'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Washer_Dryer'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Laundry'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Enclosed_Balcony'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Gated_Complex'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Pest_Control'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Pool'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Lawn_Care'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_HEating_Source'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Two_Story'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Radio_Smoke_Detector'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Bob_Additional_Amenities/Input_Phone'), '9999999999')

WebUI.click(findTestObject('Bob_Additional_Amenities/Image_Icon'))

WebUI.click(findTestObject('Bob_Additional_Amenities/Digital_Signature_Yes_Radio'))

WebUI.click(findTestObject('Bob_Additional_Amenities/Button_Confirm'))

WebUI.click(findTestObject('Bob_Additional_Amenities/Button_OK'))

WebUI.click(findTestObject('Bob_Additional_Amenities/Button_Got_It'))

WebUI.delay(2)

WebUI.click(findTestObject('Bob_Additional_Amenities/Button_Save'))

WebUI.delay(15)

WebUI.click(findTestObject('Additional_Documents/Step_Additional_Documents'))

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Additional_Documents/Select_Document'), 'W9')

WebUI.uploadFile(findTestObject('Additional_Documents/Choose_File'), findTestData('Bob_RFTA').getValue('Filed_Value', 8))

WebUI.delay(2)

WebUI.click(findTestObject('Additional_Documents/Start_Uploading'))

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Additional_Documents/Select_Document'), 'Direct Deposit Form')

WebUI.uploadFile(findTestObject('Additional_Documents/Choose_File'), findTestData('Bob_RFTA').getValue('Filed_Value', 8))

WebUI.delay(2)

WebUI.click(findTestObject('Additional_Documents/Start_Uploading'))

WebUI.delay(5)

WebUI.click(findTestObject('Additional_Documents/Next_Button'))

