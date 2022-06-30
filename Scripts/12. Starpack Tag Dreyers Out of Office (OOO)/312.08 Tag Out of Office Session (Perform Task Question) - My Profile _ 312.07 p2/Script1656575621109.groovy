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

/* SCENARIO TESTED
 
 SCENARIO 2: [NON ADMIN]
 
 
 NTIL QUESTION PAHSE
 LOG IN ASDIADEIS BackOffice Repro Agency
 ADD DELEGATE
 LOGIN AS ADMIN
 COMPLETE TASK AS DELEGATE
 
 TASK PROD PAHSE
 
 SGUY SHOULD RECEIVE EMAIL
 
  */
//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')
String password_suser = data_Tag.getValue(3, 21 )
String password_avieu_brasseur = data_Tag.getValue(3, 23 )

String password_sguy = data_Tag.getValue(3, 24  )

String password_bmartin = data_Tag.getValue(3, 26  )

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


//NOTEPAD
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\312.07 Tag _Project_No\\312.07_Tag_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\312.07 Tag _Project_No\\312.07_Tag_refID1.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

'Login  '
functions.I.Login_password('bmartin', password_bmartin)

WebUI.delay(1)

'Screenshot '
WebUI.takeScreenshot()

'Get task No'
double task_b4_bmartin = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')

WebUI.delay(1)

'Go to my profile'
functions.I.Go_to_MyProfile()

'Screenshot: MyProfile page '
WebUI.takeScreenshot()

//ADD DELEGATE - 1 aschs
'Click on Add delegate - 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

'Select date From : Previous'
functions.I.Delegate_Select_date_PreviousMonth('//*[@id="delegation_linenew1"]/td[2]/div')

WebUI.delay(1)

'Select date To: Next: previous month'
functions.I.Delegate_Select_date_NextMonth('//*[@id="delegation_linenew1"]/td[4]/div')
WebUI.delay(3)
'Select suser'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 'suser', 
    false)

WebUI.delay(1)

'Screenshot: MyProfile - delegate 1'
WebUI.takeScreenshot()

WebUI.delay(1)

'Enter Text'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegationSettings"]/div[2]/input']), 'Benoit martin is out of office')

functions.I.Pagedown()

'click on update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[3]')

///////////EMAIL  - SHOULD RECEIVE 
'Login  '
functions.I.Login_password('sguy', password_sguy)

'Go to my profile'
functions.I.Go_to_MyProfile()

'Screenshot: MyProfile page '
WebUI.takeScreenshot()

//ADD DELEGATE - 1 avieu_brasseur
'Click on Add delegate - 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))
WebUI.delay(1)
'Select date From : Previous'
functions.I.Delegate_Select_date_PreviousMonth('//*[@id="delegation_linenew1"]/td[2]/div')

WebUI.delay(1)

'Select date To: Next: previous month'
functions.I.Delegate_Select_date_NextMonth('//*[@id="delegation_linenew1"]/td[4]/div')
WebUI.delay(1)
'Select avieu_brasseur'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), 'avieu_brasseur', 
    false)
WebUI.delay(1)
'Screenshot: MyProfile - delegate 1'
WebUI.takeScreenshot()

WebUI.delay(1)

functions.I.Pagedown()

'click on update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[3]')

WebUI.delay(1)

//email  for delegate: backup
'Login  '
functions.I.Login_password('avieu_brasseur', password_avieu_brasseur)

'Screenshot: Popup'
WebUI.takeScreenshot()

'Click on close button for popup'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_delegations"]/div/div/div[1]/button']))

'Click on menu'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

'Click on my profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]']))

WebUI.delay(1)

'Check the checkbox - receive email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegationSettings"]/div[2]/div[4]/table/tbody/tr/td[3]/label']))

WebUI.delay(1)

'Screenshot: Checkbox cheked'
WebUI.takeScreenshot()

functions.I.Pagedown()

'click on update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

WebUI.delay(1)

'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[4]')

WebUI.delay(1)

'Login  '
functions.I.Login_password('suser', password_suser)

WebUI.delay(1)

'Screenshot '
WebUI.takeScreenshot()

'Click on close button for popup'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_delegations"]/div/div/div[1]/button']))

'Go to LHS menu: Projects'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search for project'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot:  ref list page '
WebUI.takeScreenshot()

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[6]/a']))

WebUI.delay(1)

'Screenshot: c ref page '
WebUI.takeScreenshot()

'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]']))

functions.I.Pagedown()

'96 Screenshot:  lifecycle tab page '
WebUI.takeScreenshot()

'74 Tooltip: Message is displayed'
functions.I.Verify_Mouse_Over_tooltip('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/div/i', 
    '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div', 
    ((('Out of the office' + '\n') + 'Benoit martin is out of office') + '\n') + 'Tasks delegated to : suser')

'Click on next step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a']))

WebUI.delay(1)

'Click on expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/div[2]/a']))

'Screenshot:  lifecycle tab page '
WebUI.takeScreenshot()

WebUI.delay(1)

'102Tooltip: Message is displayed'
functions.I.Verify_Mouse_Over_tooltip('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/i', 
    '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/div', 
    ('Out of the office' + '\n\n') + 'Tasks delegated to : avieu_brasseur')

WebUI.delay(1)

'Click on menu'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

WebUI.delay(1)

'Click on bmartin'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]/img']))

WebUI.delay(1)

'Go to LHS menu: Projects'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

WebUI.delay(1)

'Search for project'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

WebUI.delay(1)

'42Click on bmartin'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/a[2]']))

WebUI.delay(1)

'Screenshot:  ref list page '
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on submit'
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(1)

double task_af_bmartin = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/span')

functions.I.print('task_B4' + task_af_bmartin)

WebUI.verifyEqual(task_af_bmartin, task_b4_bmartin - 1)

WebUI.delay(1)

'Click on go back to my acccount'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/span/a']))

WebUI.delay(1)

'Screenshot:  admin page  '
WebUI.takeScreenshot()

'Click on Menu'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

double tsk1 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]/span')

WebUI.verifyEqual(task_af_bmartin, tsk1)

'Close Browser'
WebUI.closeBrowser()

