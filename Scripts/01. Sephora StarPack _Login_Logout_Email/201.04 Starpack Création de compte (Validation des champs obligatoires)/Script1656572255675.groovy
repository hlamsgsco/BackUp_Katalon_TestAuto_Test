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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

//SCENARIO 1 : ALL REQUIRED FIELDS ARE EMPTY
//SCENARIO 2: COMPANY BLANK
//SCENARIO 3: Last Name blank
//SCENARIO 4: First name blank
//SCENARIO 5A: Login blank
//SCENARIO 5B: Login 3 char
//SCENARIO 5C: Login with 19 char
//SCENARIO 6A: EMAIL BLANK
//SCENARIO 6B: INVALID EMAIL
//SCENARIO 7: ROLE DATE MISSING
//SCENARIO 8: LOGIN EXIST
//USERNAME & PASSWORD FOR LOGIN - STARPACK : 10 June 2021
/*

String password_suser = 'dchi' //suser
String password_aherms ='dchi' //supplier
String password_agluszczynska = 'dchi'//agency_2
String password_jmaciaszczyk ='dchi' //agency1
String password_aterreshernandez = 'dchi' //Packaging_1
String password_amartin_arbol = 'dchi1' // Buyer
String password_adelamatanieves = 'dchi1' //Packaging_1
String password_kcannoosamy_dia = 'dchi1'
*/
def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')
String password_suser = data.getValue(2, 1)

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

KeywordLogger log = new KeywordLogger()

//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Test'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

today = new Date()

def Lastname = ('LN' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) + today.format('HHmmss')

def FirstName = 'FN' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)

//SCENARIO 1 : ALL REQUIRED FIELDS ARE EMPTY
'SCENARIO 1 : ALL REQUIRED FIELDS ARE EMPTY'

'Login as suser'
functions.I.Login_password('suser', password_suser)

functions.I.GoToUserManagement()

'Click create user button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div/div[1]/div/a[3]']))

//VERIFICATION OF STARS 
'Verify if star is displayed on'

'Last Name'
functions.I.verifystar('Last name', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[1]/label/img']), 
    log)

'First Name'
functions.I.verifystar('First Name', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[2]/label/img']), 
    log)

'Login'
functions.I.verifystar('Login', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[3]/label/img']), 
    log)

'E-mail '
functions.I.verifystar('Login', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[4]/label/img']), 
    log)

'Company '
functions.I.verifystar('Company', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[5]/label/img']), 
    log)

'Expiration date'
functions.I.verifystar('Expiration date', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[8]/label/img']), 
    log)

'User role '
functions.I.verifystar('User Role', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[9]/label/img']), 
    log)

'Click on save and send email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[2]']))

'Screenshot: Scenario 1 > Toastr is displayed '
WebUI.takeScreenshot()

'VErify if toastr is present'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div']))

WebUI.delay(3)

//SCENARIO 2: COMPANY BLANK
'SCENARIO 2: COMPANY BLANK'

'Enter Text: Last name'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userName']), Lastname)

'Enter Text: First name'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userFirstName']), FirstName)

'Enter Text: E- Mail'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[4]/div/input']), 'TEST@TEST.com')

'Select from List: User role > ADMIN'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userRole']), 'admin', true)

WebUI.delay(1)

functions.I.Pagedown()

'Click on save and send email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[2]']))

WebUI.delay(1)

'Screenshot: Scenario 2  > Toastr is displayed '
WebUI.takeScreenshot()

'Verify Error message for company '
functions.I.verifyErrormsg_toastr('Company', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']), 
    'Company missing', log)

//SCENARIO 3: Last Name blank
'SCENARIO 3: Last Name blank'

//LAST NAME
'Clear Text: Last name'
WebUI.clearText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userName']), FailureHandling.STOP_ON_FAILURE)

//COMPANY 
'Select from List: Company> diadeis'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userCompany']), '1', true)

WebUI.delay(1)

functions.I.Pagedown()

'Click on save and send email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[2]']))

WebUI.delay(3)

'Screenshot: Scenario3 > Toastr is displayed '
WebUI.takeScreenshot()

'Verify Error message for Last Name '
functions.I.verifyErrormsg_toastr('Company', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']), 
    'Name missing', log)

//SCENARIO 4: First name blank
'SCENARIO 4: First name blank'

'Clear Text: First name'
WebUI.clearText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userFirstName']), FailureHandling.STOP_ON_FAILURE)

//ADd last name
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userName']), Lastname)

WebUI.delay(1)

functions.I.Pagedown()

'Click on save and send email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[2]']))

WebUI.delay(3)

'Screenshot: Scenario4 > Toastr is displayed '
WebUI.takeScreenshot()

'Verify Error message for First Name'
functions.I.verifyErrormsg_toastr('Company', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']), 
    'First Name missing', log)

//SCENARIO 5A: Login blank
'SCENARIO 5A: Login blank'

'Click on cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/a']))

'Click create user button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div/div[1]/div/a[3]']))

'Enter Text: Last name'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userName']), Lastname)

'Enter Text: First name'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userFirstName']), FirstName)

'Enter Text: E- Mail'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[4]/div/input']), 'TEST@TEST.com')

'Select from List: Company> diadeis'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userCompany']), '1', true)

'Select from List: User role > ADMIN'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userRole']), 'admin', true)

'Login clear'
WebUI.clearText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userLogin']), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

functions.I.Pagedown()

'Click on save and send email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[2]']))

WebUI.delay(3)

'Screenshot: Scenario5A > Toastr is displayed '
WebUI.takeScreenshot()

'Verify Error message for Login '
functions.I.verifyErrormsg_toastr('Login', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']), 
    'This login must contain beetween 4 and 18 characters', log)

//SCENARIO 5B: Login with 3 characters
//Insert Login
'SCENARIO 5B: Login with 3 characters'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userLogin']), 'ter')

'Click on save and send email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[2]']))

'Screenshot: Scenario5B > Toastr is displayed '
WebUI.takeScreenshot()

functions.I.verifyErrormsg_toastr('Login', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']), 
    'This login must contain beetween 4 and 18 characters', log)

//SCENARIO 6A: EMAIL blank
'SCENARIO 6A: EMAIL blank'

'Clear Text: E- Mail'
WebUI.clearText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[4]/div/input']))

'Insert Login'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userLogin']), 'ter12')

'Click on save and send email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[2]']))

WebUI.delay(3)

'Screenshot: Scenario6A > Toastr is displayed '
WebUI.takeScreenshot()

'Verify Error message for Email '
functions.I.verifyErrormsg_toastr('Email', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']), 
    'Email missing', log)

//SCENARIO 6B: INVALID EMAIL
'SCENARIO 6B: INVALID EMAIL'

//EMAIL
'Enter Text: E- Mail'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[4]/div/input']), 'TESTT.com')

'Click on save and send email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[2]']))

WebUI.delay(3)

'Screenshot: Scenario6B > Toastr is displayed '
WebUI.takeScreenshot()

'Verify Error message for Email '
functions.I.verifyErrormsg_toastr('Email', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']), 
    'Invalid email', log)

//SCENARIO 7: ROLE DATE MISSING
//EMAIL
WebUI.clearText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[4]/div/input']))

'Enter Text: E- Mail'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[4]/div/input']), 'TESTT@test.com')

//USER ROLE
'Select from List: User role > Commercial_support'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userRole']), 'Commercial_support', 
    true)
WebUI.delay(3)

'Click on save and send email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[2]']))

'102 Verify Error message for Login '
functions.I.verifyErrormsg_toastr('Company', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']), 
    'Brand missing', log)

'Screenshot: Scenario7 > Toastr is displayed '
WebUI.takeScreenshot()

//SCENARIO 8: LOGIN EXIST
//USER ROLE
'Select from List: User role > admin'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userRole']), 'admin', true)

//LOGIN CLEAR
WebUI.clearText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userLogin']), FailureHandling.STOP_ON_FAILURE)

//Input existing login
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userLogin']), 'aherms')

'Click on save and send email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[2]']))

WebUI.delay(3)

'Screenshot: Scenario8 > Toastr is displayed '
WebUI.takeScreenshot()

'Verify Error message for Login '
functions.I.verifyErrormsg_toastr('Company', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']), 
    ' This login is already used', log)

WebUI.closeBrowser()

