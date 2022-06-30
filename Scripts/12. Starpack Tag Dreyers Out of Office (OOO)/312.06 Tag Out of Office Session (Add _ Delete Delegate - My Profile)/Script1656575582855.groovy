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
import static java.util.Calendar.*
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_jedun = data_Tag.getValue(3, 1)

String password_rrowland = data_Tag.getValue(3, 2)

String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 2)

String password_mderdour = data_Tag.getValue(3, 6)

String password_achatin = data_Tag.getValue(3, 7)

String password_tliu = data_Tag.getValue(3, 8)

String password_ccaramella = data_Tag.getValue(3, 9)

String password_achay = data_Tag.getValue(3, 10)

String password_cbono = data_Tag.getValue(3, 11)

String password_pmareri = data_Tag.getValue(3, 12)

String password_qeuzen = data_Tag.getValue(3, 13)

String password_alanglois = data_Tag.getValue(3, 14)

String password_bde_villeneuve = data_Tag.getValue(3, 12)

String password_scai = data_Tag.getValue(3, 16)

String password_bzavaglia = data_Tag.getValue(3, 17)

String password_asamyn = data_Tag.getValue(3, 18)

String password_idiaz = data_Tag.getValue(3, 19)

String password_asalama = data_Tag.getValue(3, 20)

String password_suser = data_Tag.getValue(3, 21)

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)

/* SCENARIO TESTED

SCENARIO 1: [ADMIN]
PART A :  ADDING DELEGATION  - OK
 - ADMIN TECH : SUSER
 
PART B: VERIFICATION OF WARINING POPUP - OK

PART C: POPUP SWITCH ACCOUNT  - OK
 
PART D: MENU TO GO BACK TO THE DELEGATE
 
 - DIADEIS ON BACKOFFICE : abilliaud
   - APM : t_apm
   
 SCENARIO 2: 
 SWITCH TO MYACCOUNT WHEN LOGOUT & LOGIN 
 
 SCENARIO 3 : DELETE A DELEGATE
 
 


 

 */

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

'Delay 2'
WebUI.delay(2)

'Screenshot: Navigate to URL Tag'
WebUI.takeScreenshot()

//SCENARIO 1: [ADMIN] VERIFY DOMAIN - DIFFERENT AND SAME DOMAIN IN THE LIST
'Log in as jedun'
functions.I.Login_password('jedun', password_jedun)

'Screenshot: Login as Jedun'
WebUI.takeScreenshot()

//PART A: ADDING DELEGATION - 1ST USER: T_APM
'Go to my profile'
functions.I.Go_to_MyProfile()

'Click on new delegate period'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

'Delay 2'
WebUI.delay(2)

'FROM: Click on the date picker '
functions.I.Delegate_Select_date_PreviousMonth('//*[@id="delegation_start_date_new1"]')

'Delay 1'
WebUI.delay(1)

'TO: Click on the date picker'
functions.I.Delegate_Select_date_NextMonth('//*[@id="delegation_end_date_new1"]')

'Screenshot: To '
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

'Select suser for the delegate user'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 
    'suser', false)

'Delay 1'
WebUI.delay(1)

'Screenshot: User selected '
WebUI.takeScreenshot()

'Pagedown'
functions.I.Pagedown()

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'Get the date From'
String Date_From = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/div/input']), 
    'value')

functions.I.print('From: ' + Date_From)

'Get the date To'
String Date_To = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/div/input']), 
    'value')

functions.I.print('To: ' + Date_To)

'53 Verify that the checkbox is checked'
functions.I.VerifyCheckboxChecked('Delegatee 1', findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[7]/label/input']))

functions.I.Pagedown()

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'Delay : 1'
WebUI.delay(1)

'Screenshot: My profile page '
WebUI.takeScreenshot()

'Delay : 1'
WebUI.delay(1)

'Logout'
functions.I.Logout()

//LOGIN AS DELEGATE 1: SUSER
'Log in as suser'
functions.I.Login_password('suser', password_suser)

'Delay : 1'
WebUI.delay(1)

'Screenshot: My profile page '
WebUI.takeScreenshot()

'Delay : 1'
WebUI.delay(1)

//PART B: VERIFICATION OF WARINING POPUP
'Verify if popup is displayed correctly - Accounts delegated to me'
functions.I.VerifyMatchText('//*[@id="modal_delegations"]/div/div/div[1]/h3', 'Accounts delegated to me')

'Verify if popup is displayed correctly - The following users are out of office and have delegated their tasks to you'
functions.I.VerifyMatchText('//*[@id="modal_delegations"]/div/div/span[1]', 'The following users are out of office and have delegated their tasks to you')

'Verify if popup is displayed correctly - You can easily switch account by clicking on your profile'
functions.I.VerifyMatchText('//*[@id="modal_delegations"]/div/div/span[1]', 'The following users are out of office and have delegated their tasks to you')

'Verify that the element is present'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_delegations"]/div/div/div[2]/div/div/div/div[1]/div/i']), 
    2)

'Verify the name displayed'
functions.I.VerifyMatchText('//*[@id="modal_delegations"]/div/div/div[2]/div/div/div/div[2]/h6', 'Jaswant EDUN')

String sDate = functions.I.getnextday_ddmmyyyy(Date_To)

'Verify the date selected'
functions.I.VerifyMatchText('//*[@id="modal_delegations"]/div/div/div[2]/div/div/div/div[2]/div', (Date_From + ' - ') + 
    sDate)

'Verify that the button switch account is displayed'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_delegations"]/div/div/div[2]/div/div/div/div[3]/a']), 
    2)

'Verify that the button continue with my account is present'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_delegations"]/div/div/div[3]/button']), 
    2)

'Verify You can easily switch account by clicking on your profile is displayed'
functions.I.VerifyMatchText('//*[@id="modal_delegations"]/div/div/span[2]', 'You can easily switch account by clicking on your profile')

'Delay : 1'
WebUI.delay(1)

//PART C: POPUP SWITCH ACCOUNT
'Click on the button switch account'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_delegations"]/div/div/div[2]/div/div/div/div[3]/a']))

'Delay : 1'
WebUI.delay(1)

'Screenshot: Jedun account '
WebUI.takeScreenshot()

'Verify the msg go back is displayed'
functions.I.VerifyMatchText('//*[@id="kt_header"]/div/div[2]/div[1]/span', 'Currently logged as Jaswant EDUNGo back to my account')

String s = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/span']))

functions.I.print('msg ' + s)

'Click on the link - go back to my acocunt'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/span/a']))

'Delay : 1'
WebUI.delay(1)

'Screenshot: Admin account '
WebUI.takeScreenshot()

'Admin'
functions.I.VerifyMatchText('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/span', 'Admin')

'Active delegate circle'
String acdel = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']), 'class')
WebUI.verifyMatch(acdel, 'avatar-circle-small active-delegation', false)


//PART D: MENU TO GO BACK TO THE DELEGATE
'Click on the menu - for the my profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

'Delay : 1'
WebUI.delay(1)

'Verify that delegate is displayed'
functions.I.VerifyMatchText('//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/div', 'Accounts delegated to me')

'Verify that Acounts delegated to me + Jaswant is displayed'
functions.I.VerifyMatchText('//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[1]/div', ('Switch account' + '\n') + 'Jaswant EDUN')

'Verify task - 0'
functions.I.VerifyMatchText('//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[1]/span', '0')

'Delay : 1'
WebUI.delay(1)

'Click on my profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]']))

functions.I.Pagedown()

'Delay : 1'
WebUI.delay(1)

'32 Verify that account delegate to me is displayed'
functions.I.VerifyMatchText('//*[@id="delegationSettings"]/div[2]/div[4]/table/tbody/tr/td[2]/div', 'Jaswant EDUN')

'Click on the menu - for the my profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

'Click on the menu - delgate  for the my profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[1]']))

'Delay : 1'
WebUI.delay(1)

//JEDU ACCOUNT
'Screenshot: Jedun account '
WebUI.takeScreenshot()

'Verify text GO BACK TO MY ACCOUNT'
functions.I.VerifyMatchText('//*[@id="kt_header"]/div/div[2]/div[1]/span', 'Currently logged as Jaswant EDUNGo back to my account')

'Delay : 1'
WebUI.delay(1)

//SCENARIO 2:   SWITCH TO MYACCOUNT WHEN LOGOUT & LOGIN 
//PART A : JEDU ACCOUNT LOGOUT
'Logout'
functions.I.click_button_javascriptS('/html/body/div[1]/div[2]/div[1]/div/div[2]/div[3]/div[1]')

WebUI.delay(1)

functions.I.click_button_javascriptS('//*[@id="kt_header"]/div/div[2]/div[3]/div[2]/a[2]')

//PART B: LOGIN & LOGOUT
'Log in as suser'
functions.I.Login_password('suser', password_suser)

'Click on the menu '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

'Click on the menu - delgate  for the my profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[1]']))

'Delay : 1'
WebUI.delay(1)

//JEDU ACCOUNT
'Screenshot: Jedun account '
WebUI.takeScreenshot()

'Verify text GO BACK TO MY ACCOUNT'
functions.I.VerifyMatchText('//*[@id="kt_header"]/div/div[2]/div[1]/span', 'Currently logged as Jaswant EDUNGo back to my account')

'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[3]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[3]/div[2]/a[2]')

// SCENARIO 3: DELETE A DELEGATE
'Log in as jedun'
functions.I.Login_password('jedun', password_jedun)

'Screenshot: Login as Jedun'
WebUI.takeScreenshot()

//PART A: ADDING DELEGATION - 1ST USER: T_APM
'Go to my profile'
functions.I.Go_to_MyProfile()

'Click on delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[6]/button[1]']))

'Delay : 1'
WebUI.delay(1)

'Click on Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[1]/div/button']))

'Delay : 1'
WebUI.delay(1)

'33 Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[3]')

'Log in as suser'
functions.I.Login_password('suser', password_suser)

'Screenshot: Login as suser'
WebUI.takeScreenshot()

'Active delegate circle - Not present'
String acdel1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']), 'class')
WebUI.verifyMatch(acdel1, 'avatar-circle-small', false)

'Click on the menu - for the my profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))


'Delay : 1'
WebUI.delay(1)

'Screenshot: Menu'
WebUI.takeScreenshot()

'Delay : 1'
WebUI.delay(1)

'Verify that delegate is Not displayed'
WebUI.verifyTextNotPresent('Accounts delegated to me', false)

'Delay : 1'
WebUI.delay(1)
'Click myprofile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[1]']))


'Verify that account delegate to me is Not displayed'
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegationSettings"]/div[2]/div[4]/table/tbody/tr/td[2]/div/i']), 
    2)

'Screenshot: User Not selected '
WebUI.takeScreenshot()



'Close Browser'
WebUI.closeBrowser()

