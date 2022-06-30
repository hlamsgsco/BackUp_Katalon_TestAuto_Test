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

String password_jmarest = data.getValue(2, 9)

String password_jmartinez_almarza = data.getValue(2, 10)

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)


/////////////////////////////////////TEST START ///////////////////////////////
'Navigate to URL Starpack Test'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

'Login as jmartinez_almarza'
functions.I.Login_password('jmartinez_almarza', password_jmartinez_almarza)

'Delay 1'
WebUI.delay(1)

'Screenshot: Login as lmarza + Popup displayed'
WebUI.takeScreenshot()

'Verify popup is displayed'
functions.I.VerifyMatchText('//*[@id="modal_delegations"]/div/div/div[1]/h3', 'Cuentas delegadas a mí')

'Verify Arthur is displayed'
functions.I.VerifyMatchText('//*[@id="modal_delegations"]/div/div/div[2]/div/div/div[1]/div[2]/h6', 'Arthur FRON')

'15 Verify 1pging 1acka is displayed'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[3]/div/div/div[2]/div/div/div[2]/div[2]/h6', 'packaging1 1')

'Click on continue to account'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_delegations"]/div/div/div[3]/button']))

'VErify the circle is displayed'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']), 
    2)

'Click on menu'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

'Click on my profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[3]']))

WebUI.delay(1)

'Screenshot: MyProfile'
WebUI.takeScreenshot()


functions.I.Pagedown()

'22 Verify the user is displayed'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[4]/table/tbody/tr[1]/td[2]/div', 'Arthur FRON')

functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div', 'packaging1 1')

'Click update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[5]')

'Login as suser'
functions.I.Login_password('suser', password_suser)

'Screenshot: Login as suser'
WebUI.takeScreenshot()

'Click on the Menu > Settings'
WebUI.click(findTestObject('xxx Todelete/1.0 R_Menu_Settings id_kt_aside_menu_ul_li11aspan2'))

WebUI.takeScreenshot()

WebUI.delay(3)

'Click user management'
WebUI.click(findTestObject('xxx Todelete/1.01_Menu_Usermanagement id_kt_aside_menu_ul_li11div_ul_li2aspan'))

'Screenshot: Usermanagement'
WebUI.takeScreenshot()

'Search for '
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="users_table_filter"]/label/input']), 
    'mediabox.outofoffice1@gmail.com')

WebUI.delay(2)

'Click select all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selectAllUser"]']))

WebUI.delay(1)

'Select manage delegate'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2_grouped_actions"]']), 
    'setdelegation', false)

WebUI.delay(1)

'Screenshot: Usermanagement > Manage delegate selected'
WebUI.takeScreenshot()

'Click ok '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="send_action_grouped"]']))

WebUI.delay(1)

'Screenshot: Usermanagement > Manage delegate popup'
WebUI.takeScreenshot()

//user 1
'delete delegation'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[6]/button[1]']))

//user 2
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div[2]/table/tbody/tr[1]/td[6]/button[1]']))

functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div[2]/table/tbody/tr/td[6]/button[1]']))

//user 3
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div[3]/table/tbody/tr[1]/td[6]/button[1]']))

functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div[3]/table/tbody/tr[1]/td[6]/button[1]']))

functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[6]/div/div/div[2]/div/form/div[3]/table/tbody/tr/td[6]/button[1]']))

WebUI.delay(1)

'Screenshot: Usermanagement Popup deleted'
WebUI.takeScreenshot()

'Click ok '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_change_delegations"]']))

functions.I.Logout()

'Login as jmartinez_almarza'
functions.I.Login_password('jmartinez_almarza', password_jmartinez_almarza)

WebUI.delay(1)

'Screenshot: Login as almarxa'
WebUI.takeScreenshot()

'Verify popup is NOT displayed'
WebUI.verifyTextNotPresent('Cuentas delegadas a mí', false)

'Click on menu'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

'Click on my profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[1]']))

WebUI.delay(1)

'Screenshot: MyProfile'
WebUI.takeScreenshot()

WebUI.delay(1)

'VErify the user is Not displayed'
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegationSettings"]/div[2]/div[4]/table/tbody/tr[1]/td[2]/div/i']), 
    2)

functions.I.Logout()

'Close Browser'
WebUI.closeBrowser()

