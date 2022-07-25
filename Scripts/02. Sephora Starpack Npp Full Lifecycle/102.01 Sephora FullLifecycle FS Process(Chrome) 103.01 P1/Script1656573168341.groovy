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
import org.openqa.selenium.Keys as Keys
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

/* IN THIS TESTCASE, SCENARIO TESTED:
 * FULL LIFECYCLE: FS PROCESS 
 * COMPLETED LIFECYCLE
 * USER CAN SUBMIT
 * USER CAN APPROVE DOC
 */
//DATA FILE : USERNAME & PASSWORD  - SEPHORA 
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Test_Sephora')

String password_atran = data_Sephora.getValue(2, 1 //R
    )

String password_marketing = data_Sephora.getValue(2, 2 //R
    )

String password_regulatory = data_Sephora.getValue(2, 3 //R
    )

String password_studio = data_Sephora.getValue(2, 4 //R
    )

String password_cmouzawak = data_Sephora.getValue(2, 6 //R
    )

String password_iraz = data_Sephora.getValue(2, 5 //R
    )

//DATA FILE : URL - SEPHORA
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Sephora = data_urlTESTAUTO.getValue(2, 1)

//CLEAR NOTEPAD
//D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Sephora\\102.01\102.01_Sephora_ProjectNo.txt
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Sephora\\102.01\\102.01_Sephora_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Sephora\\102.01\\102.01_Sephora_refID.txt')

/////////////////////////////////////////////////TEST START /////////////////////////////////////////
'Navigate to Sephora Test'
WebUI.openBrowser(Url_Sephora)

'Maximize Window'
WebUI.maximizeWindow()

'Screenshot: Login page'
WebUI.takeScreenshot()

'Log in as Devfs  : atran/ diadeis'
functions.I.Login_password('atran', password_atran)

'Screenshot: Log as atran'
WebUI.takeScreenshot()

'Click on LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//CREATION OF PROJECT
'Click on + icon to create project '
WebUI.click(findTestObject('Object Repository/1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

'Screenshot: Click + button'
WebUI.takeScreenshot()

def project_name = (('TC102.01_AutoTest_FullLifecycle_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + 
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
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_category_field'), 'Hair', true)

'Select List Segment - Bath Body'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_segment_field'), 'BATH BODY', true)

'Select List Type - One Shot'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_type_field'), 'One Shot', true)

'Select Multiple list List Scope - 20'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Scope_field'), '20', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Add_Scope_field'))

'Select List MAD - Christmas '
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_MAD_field'), 'Christmas', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_date_select2-var_35-container_field'))

'Select List Year - 119'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_year_field'), '119', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_date_select2-var_35-container_field'))

'Select Multiple List DevPack - devpack'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_DevPack_field'), 'devpack', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Add_DevPack_field'))

'Select Multiple List DevFS - atran'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_DevFS_field'), 'atran', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_DevFS_button'))

'Select Multiple List Marketing - marketing'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Marketing_field'), 'marketing', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Marketing_button'))

'Select Multiple List Regulatory - Regulatory'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Regulatory_field'), 'regulatory', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Regulatory_button'))

'Select Multiple List Studio - Studio'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Studio_field'), 'studio', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Studio_button'))

'delay 5'
WebUI.delay(5)

'Click Update project'
WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

'delay 5'
WebUI.delay(5)

//END OF MODIFY PROJECT PAGE
//REF LIST PAGE
'Get Project No'
String Project_No = functions.I.ProjectNo()

'Click on + button to create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

'Click on create button'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(25)

'Select Lifecycle template  : FS PROCESS'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/6 ReferenceList_Choose Lifecycle'), 'FS process', false)

'Define ref name'
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10) + '_') + functions.I.gettimedate()

'Enter ref name'
WebUI.setText(findTestObject('HL Full Lifecycle/6 Reference_input_Component name_field'), 'Component_' + ref_name)

'Screenshot: Create Reference Page: Lifecycle FS Process selected & Name filled'
WebUI.takeScreenshot()

'Click on create button'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

WebUI.delay(5)

'Get ref ID'
String refID = functions.I.RefID()

//MODIFICATION OF REFERENCE FORM
'DDC Status'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_DDC Status_field'), 'Complete', false)

'Closing date DDC & sending date of the decor doc'
WebUI.click(findTestObject('Object Repository/Control Tag/2.4 Closing Date'))

WebUI.click(findTestObject('Object Repository/Control Tag/2.5 Closing date (choose date)'))

'delay 1'
WebUI.delay(1)

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_la-calendar_field'))

'delay 1'
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Control Tag/2.5 Closing date (choose date)'))

'Pack type'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_Pack_Type'), 'Primaire', false)

'Component type'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_Component_Type'), 'Etui', false)

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_printer'), 'AIRCOS', false)

WebUI.scrollToElement(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'), 10)

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

'Screenshot: Modification Reference Page: Fields Filled\r\n'
WebUI.takeScreenshot()

WebUI.delay(3)

// END OF MODIFICATION OF REFERENCE FORM
//REFERENCE LIST PAGE
'User atran: Proceed to next Phase'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

'User atran: Click on send to marketing button'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_button_Send to Marketing'))

'Logout as atran'
functions.I.Logout()

//LOG IN AS MARKETING 
'Log in as marketing'
functions.I.Login_password('marketing', password_marketing)

'Log as marketing'
WebUI.takeScreenshot()

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//REF LIST PAGE
'User marketing: Proceed to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/9 RefPage_i_B_fa fa-arrow-circle-right_1', [('refID') : 'source_' + refID]))

'User marketing: click on send to regulatory'
WebUI.click(findTestObject('HL Full Lifecycle/9 RefPage_button_Send to Regulatory'))

'Logout as marketing'
functions.I.Logout()

//LOGIN AS REGULATORY
'Log in as regulatory'
functions.I.Login_password('regulatory', password_regulatory)

'Screenshot: Log as regulatory'
WebUI.takeScreenshot()

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//REFERENCE LIST PAGE
'User regulatory: Proceed to next phase (Question)\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/10.1_RefPage_questionphase', [('refID') : 'source_' + refID]))

'Screenshot: User reulatory proceed next phase'
WebUI.takeScreenshot()

'Click on 1st option '
WebUI.click(findTestObject('HL Full Lifecycle/10.2 ReferencPAge_button_Send to studio', [('refID') : 'source_' + refID]))

'Click Submit phase'
WebUI.click(findTestObject('HL Full Lifecycle/10.3 RefPage_Submitstudio'))

'Logout as regulatory'
functions.I.Logout()

//LOGIN AS STUDIO -
'Login as studio'
functions.I.Login_password('studio', password_studio)

'Screenshot: Log as studio'
WebUI.takeScreenshot()

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//REF LIST PAGE
WebUI.waitForElementClickable(findTestObject('HL Full Lifecycle/10.10 RefPage_Question', [('refID') : 'source_' + refID]), 
    10)

'User studio: proceed to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/10.10 RefPage_Question', [('refID') : 'source_' + refID]))

WebUI.click(findTestObject('HL Full Lifecycle/11 ReferencePage_Question_a_Accept the brief', [('refID') : 'source_' + refID]))

//MODIF REF PAGE
'Select option form list'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_133"]']), '282', false)

'Click on accept Brief'
WebUI.click(findTestObject('HL Full Lifecycle/11 RefPage_Button_AcceptBrief', [('refID') : 'source_' + refID]))

WebUI.delay(3)

//PROD
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
    'color', FailureHandling.OPTIONAL)

while (color1 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']))

    //UPLOAD A DOC - PDF
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
        'color', FailureHandling.OPTIONAL)
}

'Logout as studio'
functions.I.Logout()

//MARKETING
'Log in as marketing'
functions.I.Login_password('marketing', password_marketing)

'Log as marketing'
WebUI.takeScreenshot()

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Serach Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Approve by clicking on ref link'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']))

'Logout as marketing'
functions.I.Logout()

//LOGIN AS REgulatory
'Log in as regulatory'
functions.I.Login_password('regulatory', password_regulatory)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search a Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.waitForPageLoad(10)

'User marketing: Click on view doc'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']))

WebUI.takeScreenshot()

'Logout as marketing'
functions.I.Logout()

//LOGIN AS FS atran
'Login as atran'
functions.I.Login_password('atran', password_atran)

'Login as atran'
WebUI.takeScreenshot()

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search a Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.delay(10)

'Approve by clicking on ref link'
functions.I.AWF_approve_byaction(findTestObject('Object Repository/HL Full Lifecycle/Function AWFAction2', [('refID') : 'source_' + 
            refID]))

WebUI.delay(1)

//REFERENCE LIST PAGE
'User atran: Submit to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submit_AurelieTran', [('refID') : 'source_' + refID]))

WebUI.delay(1)

//MODIFICATION REFERENCE PAGE
WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Question_sendtodiadeis', [('refID') : 'source_' + refID]))

WebUI.delay(3)

WebUI.setText(findTestObject('HL Full Lifecycle/15 RefPage_Field_CODEEAN'), 'Code EAn Test')

WebUI.setText(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_photogravuremandatory'), 'Brief photogravuremandatory')

WebUI.setText(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_NoRepro'), 'Number of colors Repromandatory')

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_PrinterType'), '109', false)

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_ML_add'))

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_MAD_suppliermandatory'))

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_MAD_yr'))

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_MAD_suppliermandatory'))

WebUI.scrollToElement(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submittodiadies'), 5)

'Screenshot : User atran > Edit Reference '
WebUI.takeScreenshot()

functions.I.click_button_javascript(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submittodiadies'))

'Logout as atran'
functions.I.Logout()

//CYRIL
'Log in as Cyril '
functions.I.Login_password('cmouzawak', password_cmouzawak)

'Log as Cyril'
WebUI.takeScreenshot()

'Click on the LHS Project tab'
WebUI.click(findTestObject('HL Full Lifecycle/2 LHSMenu_Projet(FR)'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/2 Filter_ Button_FR_Apply'))

//REFERENCE LIST PAGE
'Click on submit '
WebUI.click(findTestObject('HL Full Lifecycle/16 RefListPg_Button_Submit_Cyril', [('refID') : 'source_' + refID]))

WebUI.delay(1)

'User Cyril: Upload adoc'
functions.I.UploadDoc_sendkey_field('//*[@id="var_123"]', 'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

WebUI.delay(1)

'Click on submit'
WebUI.click(findTestObject('HL Full Lifecycle/16 RefPg_Button_SubmitCyril'))

'Screenshot: Upload doc'
WebUI.takeScreenshot()

'Logout as Cyril'
functions.I.Logout()

//LOGIN AS IRAZ
'Log in as Iraz'
functions.I.Login_password('lraz', password_iraz)

'Log as Iraz'
WebUI.takeScreenshot()

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.delay(3)

//PRODUCTION PHASE: UPLOAD DOC
String color2 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
    'color', FailureHandling.OPTIONAL)

while (color2 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']))

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    WebUI.click(findTestObject('HL Full Lifecycle/9.1 REfPg_Button_Upload_IR_Part 1'))

    WebUI.delay(5)

    color2 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
        'color', FailureHandling.OPTIONAL)
}

'Logout as Iraz'
functions.I.Logout()

//LOGIN AS FS Aurelie tran
'Login as atran'
functions.I.Login_password('atran', password_atran)

'Login as atran'
WebUI.takeScreenshot()

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search Project'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Click on ref link'
WebUI.click(findTestObject('HL Full Lifecycle/14 RefListPg_Reflink2', [('refID') : 'source_' + refID]))

WebUI.delay(5)
'165 User atran approve doc'
functions.I.AWF_approve()

'Screenshot: User atran approve doc'
WebUI.takeScreenshot()

'CLICK ON ACTION BUTTON – QUESTION PHASE'
WebUI.click(findTestObject('HL Full Lifecycle/17 Ref_Button_Submit_question', [('refID') : 'source_' + refID]))

'CLICK ON DDC UPDATED - OPTION'
WebUI.click(findTestObject('HL Full Lifecycle/17 Ref_Options_DDCupdated', [('refID') : 'source_' + refID]))

'Click on DDC Updated'
WebUI.click(findTestObject('HL Full Lifecycle/17.1 Ref_Question_DDCUpdated'))

'Verify Status: Completed'
functions.I.status(findTestObject('HL Full Lifecycle/Status', [('refID') : 'source_' + refID]))

'Status: LC Completed'
WebUI.takeScreenshot()

//NOTEPAD WRITE THE PROJECT AND REF ID
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Sephora\\102.01\\102.01_Sephora_ProjectNo.txt', 
    Project_No)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Sephora\\102.01\\102.01_Sephora_refID.txt', refID)

'Close Browser'
WebUI.closeBrowser()

