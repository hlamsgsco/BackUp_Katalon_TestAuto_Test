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

//DATA FILE USERNAME & PASSWORD [STARPACK]
def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

String password_suser = data.getValue(2, 1)

String password_aherms = data.getValue(2, 2)

String password_agluszczynska = data.getValue(2, 3)

String password_jmaciaszczyk = data.getValue(2, 4)

String password_aterreshernandez = data.getValue(2, 5)

String password_amartin_arbol = data.getValue(2, 6)

String password_adelamatanieves = data.getValue(2, 7)

String password_kcannoosamy_dia = data.getValue(2, 8)

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

/////////////////////////////////////TEST START ///////////////////////////////
'Navigate to URL Starpack Test '
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

WebUI.takeScreenshot()

'Login as suser'
functions.I.Login_password('suser', password_suser)

'Screenshot: Login as suser'
WebUI.takeScreenshot()

'Click on the Menu > Settings'
WebUI.click(findTestObject('xxx Todelete/1.0 R_Menu_Settings id_kt_aside_menu_ul_li11aspan2'))

'Screenshot: Usermanagement page'
WebUI.takeScreenshot()

WebUI.delay(3)

'Click user management'
WebUI.click(findTestObject('xxx Todelete/1.01_Menu_Usermanagement id_kt_aside_menu_ul_li11div_ul_li2aspan'))

'Search for '
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="users_table_filter"]/label/input']), 'mediabox.outofoffice1@gmail.com')

WebUI.delay(1)

'Click select all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selectAllUser"]']))

WebUI.delay(1)

'Select manage delegate'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2_grouped_actions"]']), 'setdelegation', 
    false)

WebUI.delay(1)

'Screenshot: Checkbox checked'
WebUI.takeScreenshot()

'Click ok '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="send_action_grouped"]']))

'Verify that 1/2/3users is displayed'
functions.I.VerifyMatchText('//*[@id="UpdateDelegations"]/div[1]/h5', 'Arthur FRON\'s active delegations')

functions.I.VerifyMatchText('//*[@id="UpdateDelegations"]/div[2]/h5', 'agency1 1\'s active delegations')

functions.I.VerifyMatchText('//*[@id="UpdateDelegations"]/div[3]/h5', 'packaging1 1\'s active delegations')

//USER 1
'Afro: Add delegate for the 1st user'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation_afron"]']))

WebUI.delay(1)

'Click ok '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_change_delegations"]']))

'Verify error message'
String err1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div[1]/div[2]']))

String err2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div[2]/div[2]']))

WebUI.verifyMatch(err1, 'Error : Please fill in delegate user', false)

WebUI.verifyMatch(err2, 'Error : Please fill in delegation\'s dates', false)

'Screenshot: Error msg'
WebUI.takeScreenshot()

WebUI.delay(5)

'41 Select date From : Previous'
functions.I.UserManagement_Delegate_Select_date_PreviousMonth('//*[@id="delegation_start_date_afron_new1"]')
WebUI.delay(3)
'Select date To: Next month'
functions.I.UserManagement_Delegate_Select_date_NextMonth('//*[@id="delegation_end_date_afron_new1"]')
WebUI.delay(3)
'Select asch'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_afron_new1"]']), 
    'jmartinez_almarza', false)
WebUI.delay(3)
'Afro: Verify button Add delegate '
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation_afron"]']), 2)

'Screenshot: asch added'
WebUI.takeScreenshot()

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation_afron"]']))

//USER 2
//PART1
'agency1 1s active delegations: Add delegate for the 1st user'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation_1agency1"]']))

'Select date From : Previous'
functions.I.UserManagement_Delegate_Select_date_PreviousMonth('//*[@id="delegation_start_date_1agency1_new1"]')

WebUI.delay(1)

'Select date To: Next: previous month'
functions.I.UserManagement_Delegate_Select_date_NextMonth('//*[@id="delegation_end_date_1agency1_new1"]')
WebUI.delay(3)
'Select_almeida'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_1agency1_new1"]']), 
    '_almeida', false)

'Screenshot: almeida added'
WebUI.takeScreenshot()

//PART 2
'agency1 1s active delegations: Add delegate for the 2nd user'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation_1agency1"]']))

'Select date From : Previous'
functions.I.UserManagement_Delegate_Select_date_PreviousMonth('//*[@id="delegation_start_date_1agency1_new2"]')

WebUI.delay(3)

'Select date To: Next: previous month'
functions.I.UserManagement_Delegate_Select_date_NextMonth('//*[@id="delegation_end_date_1agency1_new2"]')
WebUI.delay(3)
'Select 1packaging1'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_1agency1_new2"]']), 
    '1packaging1', false)

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation_1agency1"]']))

'Screenshot: 1packaging1 added'
WebUI.takeScreenshot()

//USER 3
//PART1
'agency1 1s active delegations: Add delegate for the 1st user'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation_1packaging1"]']))

'Select date From : Previous'
functions.I.UserManagement_Delegate_Select_date_PreviousMonth('//*[@id="delegation_start_date_1packaging1_new1"]')

WebUI.delay(1)

'Select date To: Next: previous month'
functions.I.UserManagement_Delegate_Select_date_NextMonth('//*[@id="delegation_end_date_1packaging1_new1"]')

'Select_almeida'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_1packaging1_new1"]']), 
    '_almeida', false)

'Screenshot: almeida added'
WebUI.takeScreenshot()

//PART 2
'agency1 1s active delegations: Add delegate for the 2nd user'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation_1packaging1"]']))

'Select date From : Previous'
functions.I.UserManagement_Delegate_Select_date_PreviousMonth('//*[@id="delegation_start_date_1packaging1_new2"]')

WebUI.delay(1)

'Select date To: Next: previous month'
functions.I.UserManagement_Delegate_Select_date_NextMonth('//*[@id="delegation_end_date_1packaging1_new2"]')

'Select 1packaging1'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_1packaging1_new2"]']), 
    'fazer', false)

'Screenshot:1packaging added'
WebUI.takeScreenshot()

//PART 3
'agency1 1s active delegations: Add delegate for the 3rd user'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation_1packaging1"]']))

'Select date From : Previous'
functions.I.UserManagement_Delegate_Select_date_PreviousMonth('//*[@id="delegation_start_date_1packaging1_new3"]')

WebUI.delay(1)

'Select date To: Next: previous month'
functions.I.UserManagement_Delegate_Select_date_NextMonth('//*[@id="delegation_end_date_1packaging1_new3"]')

'Select 1packaging1'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_1packaging1_new3"]']), 
    'jmartinez_almarza', false)

WebUI.delay(1)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation_1packaging1"]']))

'Screenshot: 1packaging added'
WebUI.takeScreenshot()

'Click ok '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_change_delegations"]']))

'Screenshot: usermanagement page'
WebUI.takeScreenshot()

'Close Browser'
WebUI.closeBrowser()

