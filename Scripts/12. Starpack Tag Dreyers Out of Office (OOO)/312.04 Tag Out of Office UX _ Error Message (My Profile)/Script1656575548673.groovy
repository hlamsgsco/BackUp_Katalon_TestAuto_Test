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
 SCENARIO 1: [ADMIN] VERIFY THAT THE OUT OF OFFICE SECTION IS DISPLAYED CORRECTLY IN THE MYPROFILE [LABELLING / EXPAND & COLLAPSE]
 
 SCENARIO 2: [ADMIN] UPDATE WITHOUT MAKING ANY CHANGES
 
 SCENARIO 3: [ADMIN] USER ADDS 3 LINE FOR THE NEW DELEGATION
 
 SCENARIO 4: [ADMIN] ERROR MESSAGE DISPLAYED
 PART A : "Please fill in delegate user" & "Please fill in delegation's dates"
 PART B: WRONG DATE FORMAT Error : Bad delegation period
 PART C:  Error : Please fill in delegation's dates
 
 SCENARIO 5: TOOLTIP
  */
//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_jedun = data_Tag.getValue(3, 1 //R
    )

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag '
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//SCENARIO 1: [ADMIN] VERIFY THAT THE OUT OF OFFICE SECTION IS DISPLAYED CORRECTLY IN THE MYPROFILE
'Log in as jedun'
functions.I.Login_password('jedun', password_jedun)

'Screenshot: Login as Jedun'
WebUI.takeScreenshot()

'Go to my profile'
functions.I.Go_to_MyProfile()

WebUI.delay(2)

'Screenshot: MyProfile Page'
WebUI.takeScreenshot()

// EXPAND & COLLAPSE
'Out of Office section: Click on the collapse button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegationSettings"]/div[1]/div[2]/a']))

WebUI.delay(5)

'Verify the out of office is NOT visible'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegationSettings"]/div[2]/h6[1]']))

'Screenshot: Out of office section is collapsed'
WebUI.takeScreenshot()

WebUI.delay(5)

'Out of Office section: Click on the expand button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegationSettings"]/div[1]/div[2]/a']))

WebUI.delay(2)

'Verify the out of office is visible'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegationSettings"]/div[2]/h6[1]']))

'Screenshot: Out of office section is expanded'
WebUI.takeScreenshot()

//VERIFY THE LABELLING
'1. Verify that the text My active delegations is displayed'
functions.I.VerifyMatchText('//*[@id="delegationSettings"]/div[2]/h6[1]', 'My active delegations')

'2. Verify that the text Use this feature to delegate your work when you are out of office. You can setup up to 3 periods is displayed'
functions.I.VerifyMatchText('//*[@id="delegationSettings"]/div[2]/div[1]', 'Use this feature to delegate your work when you are out of office. You can setup up to 3 periods')

'3. Verify that the text New delegation period  is displayed'
functions.I.VerifyMatchText('//*[@id="btn_add_delegation"]', 'New delegation period')

'4. Verify that the text Define a status message  is displayed'
functions.I.VerifyMatchText('//*[@id="delegationSettings"]/div[2]/h6[2]', 'Define a status message')

'5. Verify that the text This message will be visible to all your colleagues  is displayed'
String A_Placeholder = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegationSettings"]/div[2]/input']), 
    'placeholder')

WebUI.verifyMatch(A_Placeholder, 'This message will be visible to all your colleagues', false)

'6. Verify that the text Accounts delegated to me  is displayed'
functions.I.VerifyMatchText('//*[@id="delegationSettings"]/div[2]/h6[3]', 'Accounts delegated to me')

'7. Verify that the text The following users are out of office and have delegated their tasks to you  is displayed'
functions.I.VerifyMatchText('//*[@id="delegationSettings"]/div[2]/div[3]', 'The following users are out of office and have delegated their tasks to you')

'Delay 1'
WebUI.delay(1)

//SCENARIO 2: UPDATE WITHOUT MAKING ANY CHANGES
'Click on update without making any changes'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[1]/div/button']))

'Delay 1'
WebUI.delay(1)

'VErify that there is no alert'
WebUI.verifyAlertNotPresent(5)

'Screenshot: No Toastr is displayed'
WebUI.takeScreenshot()

WebUI.delay(1)

//THE LINE FROM & TO
//SCEANRIO 3: USER ADDS 3 LINE FOR THE NEW DELEGATION 
//NO LINE
'Verify that the line  FROM TO is not visible - not yet clicking on the button new delegate '
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew1"]']), 2)

WebUI.delay(1)

//1ST LINE
'Click on the button new delegate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

WebUI.delay(1)

'Verify that 1st line is displayed correctly'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew1"]']))

'Verify that the 1st checkbox is checked'
functions.I.VerifyCheckboxChecked('email notif 1', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew1"]/td[7]/label/input']))

//2ND LINE
'Click on the button new delegate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

WebUI.delay(1)

'Verify that 2nd line is displayed correctly'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew2"]']))

'Verify that the 2nd checkbox is checked'
functions.I.VerifyCheckboxChecked('email notif 2', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew2"]/td[7]/label/input']))

//3RD LINE + NO BUTTON
'Click on the button new delegate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

'Delay 1'
WebUI.delay(1)

'Verify that 3rd line is displayed correctly'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew3"]']))

'Verify that button is no longer visible'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

'Verify that the 3rd checkbox is checked'
functions.I.VerifyCheckboxChecked('email notif 3', findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew3"]/td[7]/label/input']))

'Screenshot: Section out of office - 3 lines + No button'
WebUI.takeScreenshot()

//SCENARIO 4: DELETE ICON
'click on the 2nd delete icon '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew2"]/td[6]/button[1]']))

'Verify that button is visible'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

'click on the 1st delete icon '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew1"]/td[6]/button[1]']))

//SCENARIO 4: [ADMIN] ERROR MESSAGE DISPLAYED
//PART A : "Please fill in delegate user" & "Please fill in delegation's dates"
'Click on the Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[1]/div/button']))

'Verify text for toastr 1 : Error : Please fill in delegate user & toastr 2 : Error : Please fill in delegations dates'
String at = ((((((((('×' + '\n') + 'Error') + '\n') + 'Error : Please fill in delegate user') + '\n') + '×') + '\n') + 'Error') + 
'\n') + 'Error : Please fill in delegation\'s dates'

functions.I.VerifyMatchText('//*[@id="toast-container"]', at)

WebUI.delay(3)

//PART B: WRONG DATE FORMAT Error : Bad delegation period
'From'
functions.I.Delegate_Select_date_NextMonth('//*[@id="delegation_linenew3"]/td[2]/div')
WebUI.delay(1)
'To'
functions.I.Delegate_Select_date_PreviousMonth('//*[@id="delegation_linenew3"]/td[4]/div')

WebUI.delay(5)

'70 Select user'
functions.I.SelectFromList_Value('//*[@id="delegation_select_user_new3"]', 'achay')

'Screenshot: user is selected '
WebUI.takeScreenshot()

functions.I.Pagedown()

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'Delay 1'
WebUI.delay(1)

'22 Verify text for toastr 1 : Error : Please fill in delegate user'
functions.I.VerifyMatchText('//*[@id="toast-container"]/div/div[2]', 'Error : Bad delegation period')

'Screenshot: Toastr is displayed '
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)


'delete'
functions.I.click_button_javascriptS('//*[@id="delegation_linenew3"]/td[6]/button[1]')

WebUI.delay(1)

'Click on the button new delegate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

WebUI.delay(1)

WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userAccount"]/div[1]/div[1]/h3']), 2)

'72 From'
functions.I.Delegate_Select_date_PreviousMonth('/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/div/input')

'To'
functions.I.Delegate_Select_date_NextMonth('/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[4]/div/input')

functions.I.Pagedown()

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'126 Verify text for toastr  : Error : Please fill in delegate user'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'Error : Please fill in delegate user')

'Screenshot: tOASTR  '
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

'Scroll up'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[1]/div/a']), 5)

//SCENARIO 5: TOOLTIP
'15 Select user'
functions.I.SelectFromList_Value('//*[@id="delegation_select_user_new1"]', 'achay')

'Screenshot: user selected  '
WebUI.takeScreenshot()

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'Delay 1'
WebUI.delay(1)

'Scroll up'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userAccount"]/div[1]/div[1]/h3']), 5)

'Delay 2'
WebUI.delay(2)

'Verify tooltip from'
functions.I.Verify_Mouse_Over_tooltip('/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/div', 
    '/html/body/div[7]/div[2]', 'Date at 00:00')

'Delay 1'
WebUI.delay(1)

'Verify tooltip to'
functions.I.Verify_Mouse_Over_tooltip('/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[3]/div', 
    '/html/body/div[7]/div[2]', 'Date at 23:59')

'Delay 1'
WebUI.delay(1)

'Verify tooltip delete delegation'
functions.I.Verify_Mouse_Over_tooltip('/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[6]/button[1]', 
    '/html/body/div[7]/div[2]', 'Delete this delegation')

'Delay 1'
WebUI.delay(1)

'Verify tooltip reset delegation'
functions.I.Verify_Mouse_Over_tooltip('/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[6]/button[2]', 
    '/html/body/div[7]/div[2]', 'Reset this delegation')

//DELETE
'Click on delete icon'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[6]/button[1]']))

functions.I.Pagedown()

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'Screenshot: MyProfile Page  '
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

'Close Browser'
WebUI.closeBrowser()

