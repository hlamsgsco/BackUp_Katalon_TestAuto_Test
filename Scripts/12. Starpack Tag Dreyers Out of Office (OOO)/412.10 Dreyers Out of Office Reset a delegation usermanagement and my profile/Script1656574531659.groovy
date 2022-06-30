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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD DREYERS]
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')

String password_suser = data_Dreyers.getValue(2, 1 )
String password_agarcia = data_Dreyers.getValue(2, 10 )
String password_bcollins = data_Dreyers.getValue(2, 11   )

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

/////////////////////////////////////TEST START ///////////////////////////////
'Navigate to URL Dreyer Test '
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

WebUI.takeScreenshot()

'Login as suser'
functions.I.Login_password('suser', password_suser)

'Go to my profile'
functions.I.Go_to_MyProfile()

WebUI.delay(1)

'Click on new delegate period'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

//add a usser with previous date
//agarcia
'Click on From'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/div/input']))

WebUI.delay(1)

'Click previous twice'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[7]/div[1]/table/thead/tr[2]/th[1]']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[7]/div[1]/table/thead/tr[2]/th[1]']))

'Click on date '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[2]/td[2]']))

'Click on To'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/div/input']))

WebUI.delay(1)

'Click previous once'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[7]/div[1]/table/thead/tr[2]/th[1]']))

'Click on date '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[2]/td[2]']))

WebUI.delay(2)

'Select user'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 'agarcia', 
    false)

//bcollins
'Click on new delegate period'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

WebUI.delay(2)

'Click on From'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div/input']))

WebUI.delay(1)

'Click previous twice'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[7]/div[1]/table/thead/tr[2]/th[1]']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[7]/div[1]/table/thead/tr[2]/th[1]']))

'Click on date '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[2]/td[2]']))

'Click on To'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[4]/div/input']))

WebUI.delay(1)

'Click previous once'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[7]/div[1]/table/thead/tr[2]/th[1]']))

'Click on date '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[2]/td[2]']))

'Select user'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new2"]']), 'bcollins', 
    false)

functions.I.Pagedown()

WebUI.delay(1)

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

//agarcia
String style_From = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[1]']), 
    'style')

String style_From1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[2]']), 
    'style')

String style_To = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[3]']), 
    'style')

String style_To1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[4]']), 
    'style')

String style_delegate = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[5]']), 
    'style')

WebUI.verifyMatch(style_From, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(style_From1, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(style_To, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(style_To1, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(style_delegate, 'opacity: 0.5; pointer-events: none;', false)

//bcollins
String style_Fromb = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[1]']), 
    'style')

String style_From1b = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[2]']), 
    'style')

String style_Tob = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[3]']), 
    'style')

String style_To1b = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[4]']), 
    'style')

String style_delegateb = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[5]']), 
    'style')

WebUI.verifyMatch(style_Fromb, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(style_From1b, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(style_Tob, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(style_To1b, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(style_delegateb, 'opacity: 0.5; pointer-events: none;', false)

WebUI.delay(1)

//REFERESH DELEGATE
'Refresh delegate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[6]/button[2]']))

WebUI.delay(1)

//agarcia
String style_Fromr = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[1]']), 
    'style')

String style_Fromrr = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[2]']), 
    'style')

String style_Tor = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[3]']), 
    'style')

String style_Torr = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[4]']), 
    'style')

String style_delegater = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[5]']), 
    'style')

WebUI.verifyMatch(style_Fromr, 'opacity: 1;', false)

WebUI.verifyMatch(style_Fromrr, 'opacity: 1;', false)

WebUI.verifyMatch(style_Tor, 'opacity: 1;', false)

WebUI.verifyMatch(style_Torr, 'opacity: 1;', false)

WebUI.verifyMatch(style_delegater, 'opacity: 1;', false)

WebUI.delay(2)

'Click on To'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[4]/div/input']))

WebUI.delay(1)

'Click on next '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/thead/tr[2]/th[3]']))

'Click on next '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/thead/tr[2]/th[3]']))

'Delay 1'
WebUI.delay(1)

'Click on date '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[2]/td[2]']))

functions.I.Pagedown()

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'91'
functions.I.Logout()

'Login as agarcia'
functions.I.Login_password('agarcia', password_agarcia)

'Delay 1'
WebUI.delay(1)

'Verify that popup is displayed'
WebUI.verifyTextPresent('Accounts delegated to me', false)

'Click on continue with my account'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_delegations"]/div/div/div[3]/button']))


'Delay 1'
WebUI.delay(1)

functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[4]')

'Login as bcollins'
functions.I.Login_password('bcollins', password_bcollins)

'Delay 1'
WebUI.delay(1)


'Verify that popup is displayed'
WebUI.verifyTextNotPresent('Accounts delegated to me', false)
functions.I.Logout()

'Login as suser'
functions.I.Login_password('suser', password_suser)

'Go to my profile'
functions.I.Go_to_MyProfile()

WebUI.delay(1)

//add a usser with previous date
//agarcia
'Click on To'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[4]/div/input']))

WebUI.delay(1)

'Click previous once'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[7]/div[1]/table/thead/tr[2]/th[1]']))

'Click on date '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[2]/td[2]']))

functions.I.Pagedown()

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'Go to setting > Usermanagement'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_aside_menu"]/ul/li[13]/a']))

WebUI.delay(2)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_aside_menu"]/ul/li[13]/div/ul/li[2]/a']))

'Screenshot: User management '
WebUI.takeScreenshot()

'Search for suser'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="users_table_filter"]/label/input']), 'suser')

WebUI.delay(2)

'Click select all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selectAllUser"]']))

WebUI.delay(1)

'Select manage delegate'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2_grouped_actions"]']), 'setdelegation', 
    false)

WebUI.delay(1)

'Click ok '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="send_action_grouped"]']))

//bcollins
'Verify if delegate is desactivate'
String ustyle_From = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[1]']), 
    'style')

String ustyle_From1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[2]']), 
    'style')

String ustyle_To = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[3]']), 
    'style')

String ustyle_To1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[4]']), 
    'style')

String ustyle_delegate = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[5]']), 
    'style')

WebUI.verifyMatch(ustyle_From, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(ustyle_From1, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(ustyle_To, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(ustyle_To1, 'opacity: 0.5; pointer-events: none;', false)

WebUI.verifyMatch(ustyle_delegate, 'opacity: 0.5; pointer-events: none;', false)

'Click on refresh'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[6]/button[2]']))

WebUI.delay(1)

String style_Fromru = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[1]']), 
    'style')

String style_Fromrru = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[2]']), 
    'style')

String style_Toru = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[3]']), 
    'style')

String style_Torru = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[4]']), 
    'style')

String style_delegateru = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[5]']), 
    'style')

WebUI.verifyMatch(style_Fromru, 'opacity: 1;', false)

WebUI.verifyMatch(style_Fromrru, 'opacity: 1;', false)

WebUI.verifyMatch(style_Toru, 'opacity: 1;', false)

WebUI.verifyMatch(style_Torru, 'opacity: 1;', false)

WebUI.verifyMatch(style_delegateru, 'opacity: 1;', false)

WebUI.delay(2)


//bcollins
'Click on To'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[1]/td[4]/div']))


WebUI.delay(2)
'Click on next '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/thead/tr[2]/th[3]']))
WebUI.delay(2)
'Click on next '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/thead/tr[2]/th[3]']))
WebUI.delay(2)
'Click on next '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/thead/tr[2]/th[3]']))

'Delay 1'
WebUI.delay(1)

'Click on date '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[4]/div[1]/table/tbody/tr[4]/td[4]']))

'Delay 1'
WebUI.delay(1)

//aga
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[2]/td[6]/button[2]']))


'Click on To'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[2]/td[4]/div/div']))
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div/table/tbody/tr[2]/td[4]/div/input']))


WebUI.delay(2)
'Click on next '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/thead/tr[2]/th[3]']))
WebUI.delay(2)
'Click on next '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/thead/tr[2]/th[3]']))
WebUI.delay(2)
'Click on next '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/thead/tr[2]/th[3]']))

'Delay 1'
WebUI.delay(1)

'Click on date '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[4]/div[1]/table/tbody/tr[4]/td[4]']))

'Delay 1'
WebUI.delay(1)



'Click on ok '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_change_delegations"]']))

functions.I.Logout()

'Login as agarcia'
functions.I.Login_password('agarcia', password_agarcia)

'Delay 1'
WebUI.delay(1)

'Verify that popup is displayed'
WebUI.verifyTextPresent('Accounts delegated to me', false)

'Delay 1'
WebUI.delay(1)

'Click on close button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[3]/div/div/div[1]/button']))

functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[4]')

'Login as bcollins'
functions.I.Login_password('bcollins', password_bcollins)

'Delay 1'
WebUI.delay(1)

'Verify that popup is displayed'
WebUI.verifyTextPresent('Accounts delegated to me', false)

'Click on continue with my account'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_delegations"]/div/div/div[3]/button']))

functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[4]')

'Login as suser'
functions.I.Login_password('suser', password_suser)

'Go to my profile'
functions.I.Go_to_MyProfile()

functions.I.Pagedown()

//////////////////////////////////////////////html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[6]/button[1]
'Click on delete'
functions.I.click_button_javascriptS('/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[6]/button[1]')

WebUI.delay(1)

functions.I.click_button_javascriptS('/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[6]/button[1]')

'Click update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'Delay 1'
WebUI.delay(5)

'Close Browser'
WebUI.closeBrowser()

