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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import ch.qos.logback.core.joran.conditional.ElseAction as ElseAction
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

/*  SCENARIO TESTED :
 THIS TESTCASE SHOULD BE RUN BEFORE RUNNING THE OTHER TEST SUITE SO THAT IT DOES NOT MAKE CONFLICT WITH THE TESTING.
 
 IN THIS TESTCASE, IT WILL VERIFY THE PASSWORD OF THE USERS USED IN THE TESTSUITE. [SEPHORA]
 */
///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD [SEPHORA]
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Test_Sephora')

String password_atran = data_Sephora.getValue(2, 1 //R
    )

String password_studio = data_Sephora.getValue(2, 4 //R
    )

//DATA FILE URL [SEPHORA]
def data_urlAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Sephora = data_urlAUTO.getValue(2, 1)

//CLEAR NOTEPAD
functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refID.txt')

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refIDName.txt')

/////////////////////////////////////////////////TEST START /////////////////////////////////////////
'Navigate to Sephora'
WebUI.openBrowser(Url_Sephora)

'Maximize Window'
WebUI.maximizeWindow()

'Screenshot: Login page'
WebUI.takeScreenshot()

'Log in as Devfs  : atran/ diadeis'
functions.I.Login_password('atran', password_atran)

'Click on LHS menu'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//CREATION OF PROJECT
'Click on + icon '
WebUI.click(findTestObject('Object Repository/1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

'Screenshot: Click + button'
WebUI.takeScreenshot()

//DEFINE PROJECT NAME
def project_name = (('AutoTest_Chrome_Duplication_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)) + 
'_') + functions.I.gettimedate()

'Enter Project name'
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name)

'Screenshot: Create Project Page'
WebUI.takeScreenshot()

'Click on the button create project'
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

'Screenshot: Modification Project Page: Field filled'
WebUI.takeScreenshot()

// MODIFY PROJECT PAGE
'Set Text: Project Field - 12345'
WebUI.setText(findTestObject('HL Full Lifecycle/5 ModifyProjPage_input_code_project_field'), '12345')

'Select List Category - Hair'
functions.I.SelectFromList_Value('//*[@id="var_28"]', '240')

'Select List Segment - Bath Body'
functions.I.SelectFromList_Label('//*[@id="var_29"]', 'BATH BODY')

'Select List Type - One Shot'
functions.I.SelectFromList_Label('//*[@id="var_31"]', 'One Shot')

'Select Multiple list List Scope - 20'
functions.I.select_multiplelist('//*[@id="selSource_32"]', '//*[@id="btnAdd_32"]', '20')

'Select List MAD - Christmas '
functions.I.SelectFromList_Label('//*[@id="var_34"]', 'Fall')

'Select List Year - 2021'
functions.I.SelectFromList_Value('//*[@id="var_35"]', '119')

///*[@id="selSource_22"]
'Select Multiple List DevPack - devpack'
functions.I.select_multiplelist('//*[@id="selSource_22"]', '//*[@id="btnAdd_22"]', 'devpack')

'Select Multiple List DevFS - atran'
functions.I.select_multiplelist('//*[@id="selSource_23"]', '//*[@id="btnAdd_23"]', 'atran')

'Select Multiple List Marketing - marketing'
functions.I.select_multiplelist('//*[@id="selSource_21"]', '//*[@id="btnAdd_21"]', 'marketing')

'Select Multiple List Regulatory - Regulatory'
functions.I.select_multiplelist('//*[@id="selSource_25"]', '//*[@id="btnAdd_25"]', 'regulatory')

'Select Multiple List Studio - Studio'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'studio')

WebUI.delay(5)

'Click update proj'
WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(5)

//END OF MODIFY PROJECT PAGE
// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()

'Click on + button to create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

'Click on create button'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(25)

'Select Lifecycle template  : FS PROCESS'
functions.I.SelectFromList_Label('//*[@id="lfc_tpl"]', 'FS process')

//DEFINE REFERENCE NAME
def ref_name = (('TC20_Sephora_Duplication_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)) + '_') + 
functions.I.gettimedate()

'Enter ref name'
WebUI.setText(findTestObject('HL Full Lifecycle/6 Reference_input_Component name_field'), 'Component_' + ref_name)

'Screenshot: Create Reference Page: Lifecycle FS Process selected & Name filled\r\n'
WebUI.takeScreenshot()

'Click on create button'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

WebUI.delay(5)

//GET THE ID OF THE REF
String refID = functions.I.RefID()

//MODIFICATION OF REFERENCE FORM//
'DDC Status'
functions.I.SelectFromList_Label('//*[@id="var_152"]', 'Complete')

'Closing date DDC & sending date of the decor doc'
WebUI.click(findTestObject('Object Repository/Control Tag/2.4 Closing Date'))

WebUI.click(findTestObject('Object Repository/Control Tag/2.5 Closing date (choose date)'))

WebUI.delay(1)

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_la-calendar_field'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Control Tag/2.5 Closing date (choose date)'))

'Pack type'
functions.I.SelectFromList_Label('//*[@id="var_50"]', 'Primaire')

'Component type'
functions.I.SelectFromList_Label('//*[@id="var_49"]', 'Etui')

//'Printer'
//functions.I.SelectFromList_Label(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_printer'), 'AIRCOS')
WebUI.scrollToElement(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'), 10)

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

'Screenshot: Modification Reference Page: Fields Filled\r\n'
WebUI.takeScreenshot()

WebUI.delay(3)

// END OF MODIFICATION OF REFERENCE FORM
//REFERENCE LIST PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
'User atran: Proceed to next Phase\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

//REFERENCE PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
'User atran: Click on send to marketing button\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_button_Send to Marketing'))

//Ref List page : If there is only 1 Standard Duplication 
//User clicks on the button > No Options are displayed
'79 Mouse Over the duplication button'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnduplicatereference"]']))

WebUI.delay(1)

'Screenshot: Ref List Page'
WebUI.takeScreenshot()

'Verify that tooltip is displayed'
String tooltip_dupli1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

WebUI.verifyMatch(tooltip_dupli1, 'Duplicate a component', false)

'Click on the duplication button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnduplicatereference"]']))

//VERIFY THAT BUTTON ''CONFIRM'' IS NOT CLICKABLE IF NO REF IS SELECTED & CLICKABLE IF 1 REF SELECTED
'Verify that button confirm is not clickable'
WebUI.verifyElementNotClickable(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

'Screenshot: Ref List Page - msg'
WebUI.takeScreenshot()

'Verify if the msg  Please select at least one component to validate  is displayed'
String msg_dupli1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/span[2]']))

WebUI.verifyMatch(msg_dupli1, ' Please select at least one component to validate or', false)

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/button[2]']))

'Click on the duplication button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnduplicatereference"]']))

'Select 1 ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[1]/label']))

'Screenshot: Ref List Page - no msg'
WebUI.takeScreenshot()

'Text is not present when selecting a ref'
WebUI.verifyTextNotPresent('Please select at least one component to validate or', false)

'Click confirm button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

WebUI.delay(1)

'Screenshot: Duplication Popup'
WebUI.takeScreenshot()

//UX POPUP DUPLICATION
//TITLE 
'Verify the title of the duplication'
String title_dupli1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="window_title"]']))

WebUI.verifyMatch(title_dupli1, 'Duplicate component(s)', false)

//NO OF COPIES > LIMIT IS 50
////*[@id="nb_copies"]
String NoCopy_1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="nb_copies"]']), 'value')

'Verify that no of copy is 1'
WebUI.verifyMatch(NoCopy_1, '1', false)

'click minus '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="div_multiple_copies"]/div/div/span/button[2]']))

String NoCopy_01 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="nb_copies"]']), 'value')

'Verify that no of copy is 1'
WebUI.verifyMatch(NoCopy_01, '1', false)

'Screenshot: Duplication Popup: No of Copy = 1'
WebUI.takeScreenshot()

'Set Copy to 49'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="nb_copies"]']), '49')

'click plus'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="div_multiple_copies"]/div/div/span/button[1]']))

String NoCopy_50 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="nb_copies"]']), 'value')

'Verify that no of copy is 1'
WebUI.verifyMatch(NoCopy_50, '50', false)

'click plus'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="div_multiple_copies"]/div/div/span/button[1]']))

String NoCopy_050 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="nb_copies"]']), 'value')

'Verify that no of copy is 50'
WebUI.verifyMatch(NoCopy_050, '50', false)

'Screenshot: Duplication Popup: No of Copy = 50'
WebUI.takeScreenshot()

//VERIFY NO OF COPY NON ALPHA
'Set Copy to abc'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="nb_copies"]']), '40ABC')

//ERROR MSG
//IN THIS PROJECT > EMPTY LIFECYCLE
'Click duplicate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

'Verify Toastr In this Project: Verify Error msg when empty lifecycle'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div', 'Please select a Lifecycle template')

'Screenshot: Error msg 1'
WebUI.takeScreenshot()

//IN AN EXISTING PROJECT > EMPTY PROJECT NAME OR NO
'Click In an existing Project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="list_project_type"]/label[2]']))

'Click duplicate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

'Verify Toastr In existing Project: Verify Error msg when empty Project No'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div', 'Error invalid data : Project name or number')

'Screenshot: Error msg 2'
WebUI.takeScreenshot()

//IN NEW PROJECT >  EMPTY PROJECT TEMPLATE
'Click In new Project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="list_project_type"]/label[3]']))

'Click duplicate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

String Error3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div']))

'In existing Project: Verify Error msg when empty Project No'
WebUI.verifyMatch(Error3, 'No project template found', false, FailureHandling.CONTINUE_ON_FAILURE)

'Screenshot: Error msg 3'
WebUI.takeScreenshot()

//CLOSE
'Click close button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_duplicate_reference"]/div/div/div[3]/div/button[1]']))

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Verify that checkbox is checked'
WebUI.verifyElementChecked(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="allRefs"]']), 2)

'Click confirm'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

'Verify that ref is selected'
String tree_dupli1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ref_tree"]/div']))

if (tree_dupli1.contains('Component_TC20_Sephora_Duplication_')) {
    WebUI.verifyMatch('1', '1', false)
} else {
    WebUI.verifyMatch('1', '2', false)
}

'Click close button (top)'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_duplicate_reference"]/div/div/div[1]/button']))

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Verify that checkbox is checked'
WebUI.verifyElementChecked(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="' + refID) + '"]']), 2)

functions.I.Logout()

//RIGHTS FOR STUDIO
'Log in as studio '
functions.I.Login_password('studio', password_studio)

'Click on LHS menu'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref List page'
WebUI.takeScreenshot()

String tooltip1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/a[1]']), 
    'id')

String tooltip2 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/a[3]']), 
    'id')

WebUI.verifyMatch(tooltip1, 'btnMassEditRefs', false)

WebUI.verifyMatch(tooltip2, 'btnMassReview', false)

functions.I.Logout()

//NOTEPAD WRITE THE PROJECT AND REF ID
functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_ProjectNo.txt', Project_No)

functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refID.txt', refID)

functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refIDName.txt', ref_name)

'Close Browser'
WebUI.closeBrowser()

