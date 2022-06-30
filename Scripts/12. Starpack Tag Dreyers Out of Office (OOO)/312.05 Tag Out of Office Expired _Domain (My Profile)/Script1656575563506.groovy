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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory


/* SCENARIO TESTED UX
 SCENARIO 1: [ADMIN] EMAIL DOMAIN
 PART A : SAME DOMAIN
 PART B: DIFFERENT DOMAIN
 PART C :EXPIRED USER
 
 SCENARIO 2: [NON ADMIN]
 PART A :  VERIFY DOMAIN - DIFFERENT  DOMAIN + SETUP
 
 SCENARIO 3: [NON ADMIN]
  PART A : SAME DOMAIN
 PART B: DIFFERENT DOMAIN
  PART C :EXPIRED USER
 
 */

//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')
String password_jedun = data_Tag.getValue(3, 1) //R
String password_cbono = data_Tag.getValue(3, 11) //R
String password_asalama = data_Tag.getValue(3, 20) //R

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.delay(2)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//SCENARIO 1: [ADMIN] VERIFY DOMAIN - DIFFERENT AND SAME DOMAIN IN THE LIST
'Log in as jedun'
functions.I.Login_password('jedun', password_jedun)

'Go to my profile'
functions.I.Go_to_MyProfile()

'Click on new delegate period'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

'Delay 2'
WebUI.delay(2)

'FROM: Click on the date picker '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew1"]/td[2]/div']))

'Delay 2'
WebUI.delay(2)

'FROM: Click on the date 2 '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[1]/td[4]']))

'Screenshot: From '
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

'TO: Click on the date picker'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew1"]/td[4]/div']))

'Delay 2'
WebUI.delay(2)

'TO: Click on the date 20 '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[4]/td[2]']))

'Screenshot: To '
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

//NOT SAME DOMAIN + NOT SETUP
'NOT SAME DOMAIN + NOT SETUP: Verify cbono option is not present in the list of user'
WebUI.verifyOptionNotPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'cbono', false, 2)

'Verify avieu_brasseur option is not present in the list of user'
WebUI.verifyOptionNotPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'avieu_brasseur', false, 2)

'Verify sguy option is not present in the list of user'
WebUI.verifyOptionNotPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'sguy', false, 2)

'Verify aivanisevic option is not present in the list of user'
WebUI.verifyOptionNotPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'aivanisevic', false, 2)

'Verify asalama option is not present in the list of user'
WebUI.verifyOptionNotPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'asalama', false, 2)

//EXPIRED USER
'EXPIRED USER: Verify adaniel\t option is not present in the list of user'
WebUI.verifyOptionNotPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'adaniel', false, 2)

//SAME DOMAIN + NON ADMIN
'SAME DOMAIN + NON ADMIN: Verify t_apm option is not present in the list of user'
WebUI.verifyOptionPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    't_apm', false, 2)

'Select t_apm'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    't_apm', false)

'Delay 1'
WebUI.delay(1)

'Screenshot: User selected '
WebUI.takeScreenshot()

'Logout'
functions.I.Logout()

'Delay 1'
WebUI.delay(1)

//SCENARIO 2: [NON ADMIN] VERIFY DOMAIN - DIFFERENT  DOMAIN + SETUP
'Log in as cbono'
functions.I.Login_password('cbono', password_cbono)


'Go to my profile'
functions.I.Go_to_MyProfile()


//P1
'Click on new delegate period'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

'Delay 2'
WebUI.delay(2)

'FROM: Click on the date picker '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew1"]/td[2]/div']))

'Delay 2'
WebUI.delay(2)

'FROM: Click on the date 2 '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[1]/td[4]']))

'Screenshot: From '
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

'TO: Click on the date picker'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew1"]/td[4]/div']))

'Delay 2'
WebUI.delay(2)

'TO: Click on the date 20 '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[4]/td[2]']))

'Screenshot: To '
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

//DIFFERENT DOMAIN + NON ADMIN
'Verify t_apm\t option is Not present in the list of user'
WebUI.verifyOptionNotPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    't_apm', false, 2)

//DIFFERENT DOMAIN + NON ADMIN
'Verify avieu_brasseur\t\t option is Not present in the list of user'
WebUI.verifyOptionNotPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'avieu_brasseur', false, 2)

//EXPIRED USER
'EXPIRED USER: Verify adaniel\t option is not present in the list of user'
WebUI.verifyOptionNotPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'adaniel', false, 2)

'Total No of options'
TotalOptions = WebUI.getNumberOfTotalOption(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']))

'Verify the no of option'
WebUI.verifyNotEqual(TotalOptions, 0)

//DIFFERENT DOMAIN + SETUP
'Select t_apm'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'suser', false)

'Delay 1'
WebUI.delay(1)

'Screenshot: User selected '
WebUI.takeScreenshot()

'Logout'
functions.I.Logout()

'Delay 1'
WebUI.delay(1)

//SCENARIO 3: [NON ADMIN] - SAME TITLE DIFFERENT DOMAIN + SETUP + DIFFERENT TITLE SAME DOMAIN
'Log in as asalama'
functions.I.Login_password('asalama', password_asalama)


'Go to my profile'
functions.I.Go_to_MyProfile()

'Click on new delegate period'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

WebUI.delay(2)

'FROM: Click on the date picker '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew1"]/td[2]/div']))

'Delay 2'
WebUI.delay(2)

'FROM: Click on the date 2 '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[1]/td[4]']))

'Screenshot: From '
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

'TO: Click on the date picker'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew1"]/td[4]/div']))

'Delay 2'
WebUI.delay(2)

'TO: Click on the date 20 '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[4]/td[2]']))

'Screenshot: To '
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

//SAME DOMAIN + NOT SETUP
'Verify avieu_brasseur\t is  present in the list of user'
WebUI.verifyOptionPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'avieu_brasseur', false, 2)

//SAME DOMAIN + NOT SETUP
'Verify aivanisevic option is  present in the list of user'
WebUI.verifyOptionPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'aivanisevic', false, 2)

//SAME DOMAIN + NOT SETUP
//'97 Verify sguy option is  present in the list of user'
//WebUI.verifyOptionPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
 //   'sguy', false, 2)

//DIFFRENT DOMAIN + SETUP
'Verify suser option is  present in the list of user'
WebUI.verifyOptionPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'suser', false, 2)

//EXPIRED USER
'EXPIRED USER: Verify adaniel\t option is not present in the list of user'
WebUI.verifyOptionNotPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'adaniel', false, 2)

'Select avieu_brasseur'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'avieu_brasseur', false)

'Delay 1'
WebUI.delay(1)

'Screenshot: User selected '
WebUI.takeScreenshot()

'Logout'
functions.I.Logout()

'Close Browser'
WebUI.closeBrowser()

