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

////////////////////SCENARIO 1 : EXISTING PROJECT (MI002230) CONTROL TAG ON PROJECT IS DISPLAYED FOR ADMIN USER////////////////
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - tag
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')
String password_stest = data_Tag.getValue(3, 3) //R
String password_kmullen = data_Tag.getValue(3, 35) //R

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


//EXITING PROJECT
String Project_No = 'MI003392'
String refID = '24365'

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

///////////////////////////VERIFY TASK /////////////////////////////
//USER1 itroin
'Log in as kmullen'
functions.I.Login_password('kmullen', password_kmullen)

'Get Task for kmullen'
double user1_bf = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

'Screnshot: Task before submitting > kmullen '
WebUI.takeScreenshot()

'Logout as user1- bzavaglia'
functions.I.Logout()

//////////////////////////// LOGIN AS adminf F  ///////////////////////////////////
'Log in as ADMIN – stest'
functions.I.Login_password('stest', password_stest)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page of Project '
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24365"]/td[8]/a']))

//REF LIST PAGE 
'Click on Document'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))

WebUI.delay(1)

'Screenshot: Document > Preview'
WebUI.takeScreenshot()

'Click on Approval Doc'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_doc_AW"]']))

'Screenshot: Document > Approval workflow'
WebUI.takeScreenshot()

//TOOLTIP ADD APPROVER
'Hover over add approver'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="level_apl_0"]/div[1]/div[2]/a[2]']))

'Tooltip: Add approval user'
String tooltip_adduser_actual = WebUI.getText(findTestObject('1. Constant/xpath', 
        [('xpath') : '/html/body/div[9]/div[2]']))

'Verify that the tooltip - Add approval users'
WebUI.verifyMatch(tooltip_adduser_actual, 'Add approval users', false)

//POPUP
'Click add approver'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="level_apl_0"]/div[1]/div[2]/a[2]']))

'Screenshot : Popup (Add approvers)'
WebUI.takeScreenshot()

WebUI.delay(1)

/// TOASTR  Please select a group
'Click on add approver'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addvalideur"]/div/div/div[3]/button[2]']))

'Verify toastr for Please select a group'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'Please select a group')

'Screenshot: Please select a group'
WebUI.takeScreenshot()

// TOASTR 2 Please select a new user approver
'Select approve for group/ field'
functions.I.SelectFromList_Value('//*[@id="added_group_approval"]', '23')

'Click on add approver'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addvalideur"]/div/div/div[3]/button[2]']))

'Verify toastr for Please select a group'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'Please select a new user approver')

'Screenshot: Please select a new user approver'
WebUI.takeScreenshot()

//ADD ALL APPROVER
'Select approve for group/ field'
functions.I.SelectFromList_Value('//*[@id="added_group_approval"]', '23')

'Select new approvers - add all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnAddAll0"]']))

'Screenshot: Add all'
WebUI.takeScreenshot()

//REMOVE ALLL
'Select new appover - remove all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnRemoveAll0"]']))

'Screenshot: Remove all'
WebUI.takeScreenshot()

WebUI.delay(2)

'Verify option is empty'
WebUI.verifyOptionPresentByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selDestUsers"]']), 
    '', false, 20, FailureHandling.OPTIONAL)

WebUI.delay(2)
//ADD MULITPLE USER
'Add approver'
//functions.I.SelectFromList_Value('//*[@id="selSourceUsers"]', 'bzavaglia')
functions.I.SelectFromList_Value('//*[@id="selSourceUsers"]', 'kmullen')
functions.I.select_multiplelist('//*[@id="selSourceUsers"]', '//*[@id="btnAdd0"]', 'adouglas')

WebUI.delay(1)

'Screenshot: Selected approver'
WebUI.takeScreenshot()

'Remove an approver'
functions.I.select_multiplelist('//*[@id="selDestUsers"]', '//*[@id="btnRemove0"]', 'adouglas')

'Screenshot: 1 approver removed'
WebUI.takeScreenshot()

'Click on add approver'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addvalideur"]/div/div/div[3]/button[2]']))

'Logout'
functions.I.Logout()

////////VERIFY TASK AFTER ADDING USER
//USER1 itroin
'Login as kmullen'
functions.I.Login_password('kmullen', password_kmullen)


'Verify Task User1 -  kmullen '
double user1_af = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')


'Screnshot: Task before submitting > kmullen '
WebUI.takeScreenshot()

'Logout as user1- kmullen'
functions.I.Logout()

'Logout as user2- kmullen'
WebUI.verifyEqual(user1_af, user1_bf + 1)


WebUI.closeBrowser()
