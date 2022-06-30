import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.google.common.base.Functions as Functions
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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

/* TASK
 * 
 * 
 * 
 * 
 */


///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD [SEPHORA]
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Test_Sephora')
String password_atran = data_Sephora.getValue(2, 1) //R
String password_devpack = data_Sephora.getValue(2, 14) //R
  
//DATA FILE URL [SEPHORA]
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Sephora = data_urlRELAUTO.getValue(2, 1)

//READ NOTEPAD & CLEAR NOTEPAD
functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.02_Sephora_ProjectNo2.txt')
functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.02_Sephora_refID2.txt')

String Project_No = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refID.txt')
String ref_name1 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refIDName.txt')

/////////////////////////////////////////////////TEST START /////////////////////////////////////////
'Navigate to Sephora'
WebUI.openBrowser(Url_Sephora)

'Maximize Window'
WebUI.maximizeWindow()

//ATRAN - VERIFY TASK
'Log in as atran :  diadeis'
functions.I.Login_password('atran', password_atran)

'Task: Get the no. of task - before'
double task_atran_b4_1 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')

'Logout as atran'
functions.I.Logout()

//DEVPACK
'Log in as Devpack  :  diadeis'
functions.I.Login_password('devpack', password_devpack)

'Click on LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[5]/button')

'Screenshot: Devpack - reflist page'
WebUI.takeScreenshot()

'Click on the duplication button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnduplicatereference"]']))

'Select 1 ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[1]/label']))

'Click confirm button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

//POPUP
'Screenshot: Duplication Popup'
WebUI.takeScreenshot()

'Click in a new project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="list_project_type"]/label[3]']))

WebUI.delay(2)

'Select Project template: Standard Project'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="project_template"]']), '11', false)

'click plus: No of copies = 2'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="div_multiple_copies"]/div/div/span/button[1]']))

WebUI.delay(2)

'Select Lifecycle template: FS Process'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl5"]']), '24', false)

'Screenshot: Duplication Popup: New in a Project/ No of Copies = 2'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click duplicate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

WebUI.delay(5)

'Get Project no.'
String Project_No2 = functions.I.ProjectNo()

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Verify that the project no is not same'
WebUI.verifyNotMatch(Project_No, Project_No2, false)

'Get the no of ref created and verify that the no of ref created is 2'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '2')

'Verify the naming of the references contain Copy of '
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[5]/a', 
    'Copy 1 of Component_' + ref_name1)

functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[5]/a', 
    'Copy 2 of Component_' + ref_name1)

//DUPLICATED REF A
'Click on the 1st ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[5]/a']))

WebUI.delay(1)

'Get the refid of the ref - PART A'
String refid2 = functions.I.RefID()

functions.I.print(refid2)

'Verify that the button view parent is displayed'
WebUI.verifyElementClickable(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

'Screenshot: Ref view 1'
WebUI.takeScreenshot()

//VERIFY FIELD PREFILLE REF A
'Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('//*[@id="var_152"]', 'Complete')

'Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('//*[@id="var_50"]', 'Primaire')

'Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('//*[@id="var_49"]', 'Etui')

'Go back to ref list page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

'Screenshot: Ref List page'
WebUI.takeScreenshot()

//DUPLICATED REF B
'Click on the 2ND ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[5]/a']))

'Get the refid of the ref - PART B'
String refid3 = functions.I.RefID()

functions.I.print(refid3)

'Verify that the button view parent is displayed'
WebUI.verifyElementClickable(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

'Screenshot: Ref view 2'
WebUI.takeScreenshot()

//VERIFY FIELD PREFILLE REF B
'Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('//*[@id="var_152"]', 'Complete')

'Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('//*[@id="var_50"]', 'Primaire')

'Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('//*[@id="var_49"]', 'Etui')

//PROJECT FIELD PREFILLED
'Click on view project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[3]']))

WebUI.delay(2)

'Code project - 1234'
functions.I.VerifyMatchText('//*[@id="var_27"]', '12345')

'Category - Hair'
functions.I.VerifyMatchText('//*[@id="var_28"]', 'Hair')

'Segment - BATH BODY'
functions.I.VerifyMatchText('//*[@id="var_29"]', 'BATH BODY')

'Type - One Shot'
functions.I.VerifyMatchText('//*[@id="var_31"]', 'One Shot')

'Scope -Europe '
functions.I.VerifyMatchText('//*[@id="var_32"]', 'Europe')

'MAD - FALL'
functions.I.VerifyMatchText('//*[@id="var_34"]', 'Fall')

'Year - 2021'
functions.I.VerifyMatchText('//*[@id="var_35"]', '2021')

'Devt FS - Aurelie Tran'
functions.I.VerifyMatchText('//*[@id="var_23"]', 'Aurelie Tran')

'Devt PACK - blank'
functions.I.VerifyMatchText('//*[@id="var_22"]', '')

'Logout as devpack'
functions.I.Logout()

//ATRAN - VERIFY TASK
'Log in as atran :  diadeis'
functions.I.Login_password('atran', password_atran)

'Task: Get the no. of task - before'
double task_atran_af_2 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')

WebUI.verifyEqual(task_atran_af_2, task_atran_b4_1 + 2)

'Click on LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No2, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

WebUI.delay(1)

//1ST REF
'Click on the 1st ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refid2) + '"]/td[4]/a']))

WebUI.delay(1)

'Screenshot: Ref view 1'
WebUI.takeScreenshot()

'Click on view parent'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

'Screenshot: Ref view 1'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify that user is redirected to the original ref'
String refid4 = functions.I.RefID()

WebUI.verifyMatch(refid4, refID, false)

//2ND REF
'Go back to project list'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[1]/a']))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No2, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

WebUI.delay(1)

'Click on the 2nd ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refid3) + '"]/td[4]/a']))

WebUI.delay(1)

'Screenshot: Ref view 2'
WebUI.takeScreenshot()

'Click on view parent'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

'Screenshot: Ref view 2'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify that user is redirected to the original ref'
String refid5 = functions.I.RefID()

WebUI.verifyMatch(refid5, refID, false)

// SUPER EDIT DUPLICATED REF
'Go back to project list'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[1]/a']))

WebUI.delay(1)

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No2, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

WebUI.delay(1)

'Super edit a ref'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') :'//*[@id="source_' + refid2 + '"]/td[7]/div/button']), findTestObject('1. Constant/xpath', [('xpath') :'//*[@id="source_' + refid2+ '"]/td[7]/div/div/a[4]']))

'Screenshot: Ref Modif'
WebUI.takeScreenshot()

'Set text for Component code'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_146"]']), 'Super edit component code - atran')

'Click update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(1)

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'ref list page: Click Submit [hase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refid2) + '"]/td[7]/a']))

WebUI.delay(1)

//VERIFY FIELD PREFILLE REF A
'Verify that field have been prefilled - DDC : Complete'
String DCC = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-var_152-container"]']), 'title')
WebUI.verifyMatch(DCC, 'Complete', false)


'Verify that field have been prefilled - Pack type: Primaire'
String PT = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-var_50-container"]']), 'title')
 WebUI.verifyMatch(PT, 'Primaire', false)


'Verify that field have been prefilled - Component type: Etui'
String CT = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-var_49-container"]']), 'title')
 WebUI.verifyMatch(CT, 'Etui', false)

'Verify that field have been prefilled - Component code'
String CC = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_146"]']), 'value')
 WebUI.verifyMatch(CC, 'Super edit component code - atran', false)



'Set text : Closing date DDC'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_36"]']), '05/05/2022', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'Set text : sending date DDC'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_37"]']), '18/06/2023', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'ref modif page: Click Submit Phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Lifecycle Status:'
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refid2+'"]/td[5]/span[1]']), 'Marketing part')

'Task: Get the no. of task - after 3'
double task_atran_af_3 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')

WebUI.verifyEqual(task_atran_af_2, task_atran_af_3 + 1)

'Logout as atran'
functions.I.Logout()


functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.02_Sephora_ProjectNo2.txt', Project_No2)
WebUI.closeBrowser()
