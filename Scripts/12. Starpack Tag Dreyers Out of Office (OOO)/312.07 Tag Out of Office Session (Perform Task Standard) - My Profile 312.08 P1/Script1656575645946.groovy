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
 
 SCENARIO 1: [NON ADMIN]
 
 TASK: STANDARD PHASE NEW PROJECT EG BRIEF FOR OONE + NO EMAIL SENT
 LOGIN AS DMI AMD ADD DELEGATE
 CREATE A NEW PROJECT - DMI PACK
 SEE IF THE TASK IS INCREASE
 COMPLETE THE TASK VIA MENU
 'Click on cotinue with my account'
 
 CBONO SHOULD NOT RECEIVE EMAIL
 
  */
//POST CONDITION CBONO & BMARTIN & sguy MUST NOT HAVE ANY DELEGATE
//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_jedun = data_Tag.getValue(3, 1 //R
    )

String password_cbono = data_Tag.getValue(3, 11 //R
    )

String password_asch = data_Tag.getValue(3, 25 //R
    )

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


//NOTEPAD
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\312.07 Tag _Project_No\\312.07_Tag_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\312.07 Tag _Project_No\\312.07_Tag_refID1.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

'Delay 2'
WebUI.delay(2)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//ADD DELEGATION 
'Login  '
functions.I.Login_password('cbono', password_cbono)

'Get task No'
double task_b4_cbono = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')

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

WebUI.delay(2)

'Select date To: Next: previous month'
functions.I.Delegate_Select_date_NextMonth('//*[@id="delegation_linenew1"]/td[4]/div')

'Select asch'
functions.I.SelectFromList_Value('//*[@id="delegation_select_user_new1"]', 'asch')

WebUI.delay(1)

'Uncheck checkbox email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew1"]/td[7]/label']))

'Screenshot: MyProfile - delegate 1'
WebUI.takeScreenshot()

WebUI.delay(1)

//ADD DELEGATE - 2 suser
'Click on Add delegate - 2'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

'Select date From : Previous'
functions.I.Delegate_Select_date_PreviousMonth('//*[@id="delegation_linenew2"]/td[2]/div')

WebUI.delay(1)

'Select date To: Next: previous month'
functions.I.Delegate_Select_date_NextMonth('//*[@id="delegation_linenew2"]/td[4]/div')

WebUI.delay(1)

'Select suser'
functions.I.SelectFromList_Value('//*[@id="delegation_select_user_new2"]', 'suser')

'Uncheck checkbox email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew2"]/td[7]/label']))

'Screenshot: MyProfile - delegate 1'
WebUI.takeScreenshot()

WebUI.delay(1)

//ADD DELEGATE - 3 afron
'Click on Add delegate - 3'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

'Select date From : Previous'
functions.I.Delegate_Select_date_PreviousMonth('//*[@id="delegation_linenew3"]/td[2]/div')

WebUI.delay(2)

'Select date To: Next: previous month'
functions.I.Delegate_Select_date_NextMonth('//*[@id="delegation_linenew3"]/td[4]/div')

WebUI.delay(2)

'Select afron'
functions.I.SelectFromList_Value('//*[@id="delegation_select_user_new3"]', 'afron')

'Uncheck checkbox email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_linenew3"]/td[7]/label']))

'Screenshot: MyProfile - delegate 3'
WebUI.takeScreenshot()

WebUI.delay(1)

functions.I.Pagedown()

'click on update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[3]')

WebUI.delay(1)

//log in as jedun : CREATION OF PROJECT FOR DMI
'Log in as jedun'
functions.I.Login_password('jedun', password_jedun)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Click on + to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

WebUI.delay(1)

'Screenshot: create a project'
WebUI.takeScreenshot()

'Select project template - MARKETING PROJECT PACK'
functions.I.SelectFromList_Value('//*[@id="project_template"]', '11')

'Click on create the project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(2)

//MODIF PROJECT
'Screenshot: Modify  a project'
WebUI.takeScreenshot()

'Enter Project name'
def Project_name = (('AutoTest_Tag_Outofoffice_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + '_') + 
functions.I.gettimedate()

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_141"]']), Project_name)

'Project type'
functions.I.SelectFromList_Value('//*[@id="var_12"]', '1025')

'Domain'
functions.I.SelectFromList_Value('//*[@id="var_116"]', '1070')

'Development zone '
functions.I.SelectFromList_Value('//*[@id="var_262"]', '16352')

'Enter PAD date'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_14"]']), '10/10/2020')

'Division '
functions.I.SelectFromList_Value('//*[@id="var_15"]', '19')

WebUI.delay(1)

'Signature '
functions.I.SelectFromList_Value('//*[@id="var_16"]', '716')

WebUI.delay(1)

'Franchise '
functions.I.SelectFromList_Value('//*[@id="var_17"]', '14518')

'Brand'
functions.I.SelectFromList_Value('//*[@id="var_18"]', '14541')

'Fragrance'
functions.I.SelectFromList_Value('//*[@id="var_20"]', '3773')

functions.I.SelectFromList_Value('//*[@id="var_21"]', '246')

'Metier'
functions.I.SelectFromList_Value('//*[@id="var_22"]', '3853')

'DMI contacts '
functions.I.SelectFromList_Value('//*[@id="selSource_23"]', 'cbono')

functions.I.select_multiplelist('//*[@id="selSource_23"]', '//*[@id="btnAdd_23"]', 'mengli')

WebUI.delay(1)

'C&A contacts'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'bmartin')

WebUI.delay(3)

'Click on update project'
WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(10)

'Get project no.'
String Project_No = functions.I.ProjectNo()

'Screenshot: Ref List page '
WebUI.takeScreenshot()

///CREATION OF REF 
'Click on + to create a ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

'Click on create a brief'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[1]']))

'Screenshot: Ref creation page '
WebUI.takeScreenshot()

'Select ref template -MULTIPLE ARTWORD WITH MASTER DESIGN'
functions.I.SelectFromList_Value('//*[@id="ref_type"]', '5')

'Click on create a brief'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(1)

'Get the Ref id'
String refID = functions.I.RefID_tag()

'Enter Text : Marketing product name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_117"]']), 'OUTOFOFFICE_PART_1')

WebUI.delay(1)

'Select Product category -MULTIPLE ARTWORD WITH MASTER DESIGN'
functions.I.SelectFromList_Value('//*[@id="var_57"]', '134')

'Select Packaging family - Accessory'
functions.I.SelectFromList_Value('//*[@id="var_28"]', '15738')

'Enter Text : Capacity'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_54"]']), '100')

WebUI.delay(1)

'Select Capacity unit'
functions.I.SelectFromList_Value('//*[@id="var_55"]', '122')

'Select Packaging family - Accessory'
functions.I.SelectFromList_Value('//*[@id="var_50"]', '15917')

functions.I.Pagedown()

WebUI.delay(1)

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

'Screenshot: Ref List page '
WebUI.takeScreenshot()


WebUI.delay(5)

'101 Logout'
functions.I.Logout()

WebUI.delay(1)

//DELEGATE 1
'Login  '
functions.I.Login_password('asch', password_asch)

WebUI.delay(1)

'Screenshot: Popup '
WebUI.takeScreenshot()

'Click on cotinue with my account'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_delegations"]/div/div/div[3]/button']))

WebUI.delay(1)

'Click on my profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

'Get task no'
double taskaftercbono = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[1]/span')

WebUI.verifyEqual(task_b4_cbono + 1, taskaftercbono)

WebUI.delay(1)

'Screenshot:  '
WebUI.takeScreenshot()

'Click on switch to another account'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[1]/img']))

'Get task no'
double taskaftercbono_1 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/span')

WebUI.verifyEqual(taskaftercbono_1, taskaftercbono)

WebUI.delay(1)

WebUI.delay(1)

'Screenshot: cbono account '
WebUI.takeScreenshot()

'Go to LHS menu: Projects'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search for project'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

'Screenshot: cbono account - ref list page '
WebUI.takeScreenshot()

'Click on submit ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[14]/a[3]']))

WebUI.delay(1)

'Screenshot: cbono account > Modif ref page '
WebUI.takeScreenshot()

'Click on submit ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Get task no'
double taskaftercbono_2 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/span')

WebUI.verifyEqual(taskaftercbono_2, taskaftercbono - 1)

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[6]/a']))

WebUI.delay(1)

'Screenshot: cbono account >  ref page '
WebUI.takeScreenshot()

'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]']))

'Screenshot: cbono account >  lifecycle tab page '
WebUI.takeScreenshot()

'Click Expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[1]/div[2]/a']))

WebUI.delay(2)

'Screenshot: cbono account >  lifecycle tab page :Expand '
WebUI.takeScreenshot()

'Get text '
String textt = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[2]/div[1]']))

WebUI.verifyMatch(textt, '.*Par Alexandre Schwalberg au nom de Carole Bono.*', true, FailureHandling.STOP_ON_FAILURE)

'Click on switch to user'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/span/a']))

WebUI.delay(2)

'Screenshot: '
WebUI.takeScreenshot()

'Click on my profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

'Get task no'
double taskaftercbono_test = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[1]/span')

WebUI.verifyEqual(taskaftercbono_2, taskaftercbono_test)

//NOTEPAD
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\312.07 Tag _Project_No\\312.07_Tag_ProjectNo.txt', Project_No)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\312.07 Tag _Project_No\\312.07_Tag_refID1.txt', refID)

'Close Browser'
WebUI.closeBrowser()

