import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.junit.After as After
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

//USERNAME & PASSWORD  - SEPHORA -  10 Aug 2021
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Test_Sephora')

String password_atran = data_Sephora.getValue(2, 1)

String password_marketing = data_Sephora.getValue(2, 2)

String password_regulatory = data_Sephora.getValue(2, 3)

String password_studio = data_Sephora.getValue(2, 4)

String password_iraz = data_Sephora.getValue(2, 5)

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Sephora = data_urlTESTAUTO.getValue(2, 1)

//CLEAR NOTEPAD
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Sephora\\102.02\\102.02_Sephora_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Sephora\\102.02\\102.02_Sephora_refID.txt')

KeywordLogger log = new KeywordLogger()

/////////////////////////////////////TEST START ///////////////////////////////
'Navigate to Sephora Test'
WebUI.openBrowser(Url_Sephora)

WebUI.maximizeWindow()

//LOG IN AS ATRAN ~ DIADEIS
'Log in as Devfs  : atran/ diadeis'
functions.I.Login_password('atran', password_atran)

WebUI.takeScreenshot()

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//CREATE PROJECT 
'Click on + icon to project'
WebUI.click(findTestObject('Object Repository/1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

'Click on Create Project buttpm'
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

////////////////////////////////PROJECT NAME  - ERROR MESSAGE (HARD CODED)///////////////////////////////////////////////
'Toastr is displayed "Project: Please fill project name" '
functions.I.verifyErrormsg_toastr('Project name ', findTestObject('Control Tag/1.1Toastr_name_msg'), 'Please fill project name', 
    log)

'The star *  is displayed next to project name & Toastr  is displayed'
functions.I.verifystar('Project name', findTestObject('Object Repository/Control Tag/1.2 asteriximage_controltag', [('field_name') : 'prj_name']), 
    log)

'Click on cancel button'
WebUI.click(findTestObject('Object Repository/Control Tag/1.3 ProjectCreationPage_cancelbutton'))

////////////////////////////////END PROJECT NAME  - ERROR MESSAGE///////////////////////////////////////////////
//PROJECT CREATIOM
'Click on + icon to create project '
WebUI.click(findTestObject('Object Repository/1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

'Screenshot: Creation of Project page'
WebUI.takeScreenshot()

'Define Project Name'
def project_name = (('TC102.02_AutoTest_FullLifecycle_ Controltag_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(
    5)) + '_') + functions.I.gettimedate()

'Set Project Name'
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name)

'Click on create project'
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

WebUI.delay(5)

'Screenshot: Modfication Project Page'
WebUI.takeScreenshot()

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_DevFS_field'), 'atran', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_DevFS_button'))

WebUI.delay(5)

'Click Update project'
WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(5)

//END OF MODIFY PROJECT PAGE
//REF LIST PAGE
'Get Project No'
String Project_No = functions.I.ProjectNo()

WebUI.delay(2)

//CREATE REFERENCE
'Click + to create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

'Click create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(25)

////////////////////////////////LIFECYCLE AND COMPONENT  NAME  - ERROR MESSAGE (Hard coded)///////////////////////////////////////////////
// The star should be displayed
'Screenshot: The star should be displayed next to Lifecycle field & Component field'
WebUI.takeScreenshot()

'The star is displayed next to Lifecycle name field'
functions.I.verifystar('Lifecycle', findTestObject('Object Repository/Control Tag/1.2 asteriximage_controltag', [('field_name') : 'lifecycle_block']), 
    log)

'The star is displayed next to Component name field'
functions.I.verifystar('Component name', findTestObject('Object Repository/Control Tag/1.2 asteriximage_controltag', [('field_name') : 'ref_name']), 
    log)

'Select Lifecycle FS Process'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/6 ReferenceList_Choose Lifecycle'), 'FS process', false)

'Click create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

//TOASTR SHOULD BE DISPLAYED - Component name
String ErrorMsg1 = 'Please fill in a component name'

'Verify toastr msg'
functions.I.verifyErrormsg_toastr('Component name field ', findTestObject('Control Tag/1.1Toastr_name_msg'), ErrorMsg1, 
    log)

'Screenshot: Toastr is displayed for component name"'
WebUI.takeScreenshot()

'Deselect ref template'
WebUI.click(findTestObject('Object Repository/Control Tag/1.4 Refpage_deselect'))

'Define ref name'
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10) + '_') + functions.I.gettimedate()

'Set ref name'
WebUI.setText(findTestObject('HL Full Lifecycle/6 Reference_input_Component name_field'), 'Component_' + ref_name)

'Click on update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

//TOASTR SHOULD BE DISPLAYED - Lifecycle
String ErrorMsg2 = 'Please select a life cycle'

'Verify Toastr'
functions.I.verifyErrormsg_toastr('Lifecycle  field ', findTestObject('Control Tag/1.1Toastr_name_msg'), ErrorMsg2, log)

'Screenshot:Toastr displayed for lifecycle'
WebUI.takeScreenshot()

'Select Lifecycle template  FS PRocess'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/6 ReferenceList_Choose Lifecycle'), 'FS process', false)

'Click on create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

'Get ref ID'
String refID = functions.I.RefID()

////////////////////////////////ENF OF LIFECYCLE AND COMPONENT  NAME  - ERROR MESSAGE///////////////////////////////////////////////
'Click on save'
WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

//REF LIST PAGE
'User atran: Proceed to next phase'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/2 Reflist_submit(atran)', [('refID') : 'source_' + refID]))

' Screenshot: Modification Reference Page'
WebUI.takeScreenshot()

////////////////////////////////REFERENCE FIELD  - ERROR MESSAGE///////////////////////////////////////////////
// VERIFCATION OF STAR NEXT TO FIELD
'Closing date DDC'
functions.I.verifystar('Closing date DDC', findTestObject('Object Repository/Control Tag/1.5 Controltag_onForm', [('field_id') : '2']), 
    log)

'Sending date of the decor document'
functions.I.verifystar('Sending date of the decor document', findTestObject('Object Repository/Control Tag/1.5 Controltag_onForm', 
        [('field_id') : '2']), log)

'Pack type'
functions.I.verifystar('Pack typemandatory', findTestObject('Object Repository/Control Tag/1.5 Controltag_onForm', [('field_id') : '2']), 
    log)

WebUI.scrollToElement(findTestObject('Object Repository/Control Tag/1.5 Controltag_onForm', [('field_id') : '2']), 1)

'Component type'
functions.I.verifystar('Component type', findTestObject('Object Repository/Control Tag/1.5 Controltag_onForm', [('field_id') : '2']), 
    log)

//REFERENCE PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
'User atran: Click on send to marketing button\r\n'
WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight)', [])

WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/8 sendtomarketing(atran)'))

//ERROR MESSAGE PAGE - Project & Reference
'Screenshot: Verification ERROR message page - Project & Reference '
WebUI.takeScreenshot()

//Error msg - Project
String bError_msg_actualP = WebUI.getText(findTestObject('Object Repository/Control Tag/1.12 CT Project (atran)'))

List<String> lines2P = new ArrayList<String>()

line2sP = bError_msg_actualP.split('\n')

//CHECK ALL LINE
if ((((lines2P.contains('Type is missing') && lines2P.contains('Category is missing')) && lines2P.contains('Segment is missing')) && 
lines2P.contains('MAD is missing')) && lines2P.contains('Year is missing')) {
    System.out.println('Error messages are displayed for the Project fields: "Category is missing" , "Segment is missing", "MAD is missing" & "Year is missing"')

    assert true
} else {
    System.out.println('KO - Missing Control tag on Project')

    log.logFailed('WARNING! The Project Control tag error messages are not displayed the fields: Category, Segment, MAD, Year,  -  Test KO')
}

//Error Msg - Ref
String bError_msg_actual = WebUI.getText(findTestObject('Object Repository/Control Tag/2.1 CT_ref(atran)'))

List<String> lines2 = new ArrayList<String>()

line2s = bError_msg_actual.split('\n')

//CHECK ALL LINE
if (((lines2.contains('Sending date of the decor document is missing') && lines2.contains('Closing date DDC is missing')) && 
lines2.contains('Component type is missing')) && lines2.contains('Pack type is missing')) {
    System.out.println('Error messages are displayed on Ref : "Sending date of the decor document is missing", "Closing date DDC is missing", "Component type is missing" & "Pack type is missing"')

    assert true
} else {
    System.out.println('KO - Missing Control Tag on Reference')

    log.logFailed('WARNING! The Reference Control tag error messages are not displayed the fields: Closing date DDC,Sending date of the decor document,Pack type, Component type -  Test KO')
}

//END OF ERROR MESSAGE PAGE - Project & Reference
'ATRAN: click on modify project button'
WebUI.click(findTestObject('Object Repository/Control Tag/2.2 ButtonModifyProject'))

' Screenshot: Redirect to Modification Project Page'
WebUI.takeScreenshot()

// MODIFY PROJECT PAGE
WebUI.setText(findTestObject('HL Full Lifecycle/5 ModifyProjPage_input_code_project_field'), '12345')

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_category_field'), 'Hair', true)

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_segment_field'), 'BATH BODY', true)

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_type_field'), 'One Shot', true)

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Scope_field'), '20', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Add_Scope_field'))

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_MAD_field'), 'Christmas', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_date_select2-var_35-container_field'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_year_field'), '119', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_date_select2-var_35-container_field'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_DevPack_field'), 'devpack', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Add_DevPack_field'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Marketing_field'), 'marketing', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Marketing_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Regulatory_field'), 'regulatory', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Regulatory_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Studio_field'), 'studio', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Studio_button'))

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

//REF LIST PAGE
'User atran: Proceed to next phase'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/2 Reflist_submit(atran)', [('refID') : 'source_' + refID]))

'Click on Submit'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/8 sendtomarketing(atran)'))

'Screenshot: Verification ERROR message page - Reference '
WebUI.takeScreenshot()

//Error Msg - Ref
String bError_msg_actual1 = WebUI.getText(findTestObject('Object Repository/Control Tag/2.1 CT_ref(atran)'))

List<String> lines21 = new ArrayList<String>()

line2s = bError_msg_actual1.split('\n')

//CHECK ALL LINE
if (((lines21.contains('Sending date of the decor document is missing') && lines21.contains('Closing date DDC is missing')) && 
lines21.contains('Component type is missing')) && lines21.contains('Pack type is missing')) {
    System.out.println('Error messages are displayed on Ref fields: "Sending date of the decor document is missing", "Closing date DDC is missing", "Component type is missing" & "Pack type is missing"')

    assert true
} else {
    System.out.println('KO - Missing Control Tag on Reference')

    log.logFailed('WARNING! The Control tag error messages are not displayed the fields: Closing date DDC,Sending date of the decor document,Pack type, Component type -  Test KO')
}

WebUI.delay(1)

'User atran: click on modify component button'
WebUI.click(findTestObject('Object Repository/Control Tag/2.23 Button Modify Component (atran)'))

'User atran: click on cancel button'
WebUI.click(findTestObject('Object Repository/Control Tag/2.3 cancelbutton(atran)'))

//REF LIST PAGE: CLICK ON ACTION BUTTON
'User atran: Proceed to next phase'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/2 Reflist_submit(atran)', [('refID') : 'source_' + refID]))

'User atran: modify the following fields:'

//MODIFICATION OF REFERENCE FORM//
'1. DDC Status'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_DDC Status_field'), 'Complete', false)

'2. Closing date DDC & sending date of the decor doc'
WebUI.click(findTestObject('Object Repository/Control Tag/2.4 Closing Date'))

WebUI.click(findTestObject('Object Repository/Control Tag/2.5 Closing date (choose date)'))

WebUI.delay(1)

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_la-calendar_field'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Control Tag/2.5 Closing date (choose date)'))

'3. Pack type'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_Pack_Type'), 'Primaire', false)

'4. Component type'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_Component_Type'), 'Etui', false)

'5. Printer'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_printer'), 'AIRCOS', false)

WebUI.waitForPageLoad(5)

// END OF MODIFICATION OF REFERENCE FORM
'User atran: Click on send to marketing button\r\n'
WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight)', [])

WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/8 sendtomarketing(atran)'))

'Logout as atran'
functions.I.Logout()

//LOG IN AS MARKETING 
'Log in as marketin'
functions.I.Login_password('marketing', password_marketing)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Get Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

WebUI.delay(1)

//REF LIST PAGE
'User marketing: Proceed to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/9 RefPage_i_B_fa fa-arrow-circle-right_1', [('refID') : 'source_' + refID]))

'User marketing: click on send to regulatory'
WebUI.click(findTestObject('HL Full Lifecycle/9 RefPage_button_Send to Regulatory'))

'Screenshot: user marketing: Successfully send next phase '
WebUI.takeScreenshot()

'Logout as marketing'
functions.I.Logout()

// REGULATORY
'Log in as regulatory'
functions.I.Login_password('regulatory', password_regulatory)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//REFERENCE LIST PAGE
'User regulatory: Proceed to next phase (Question)\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/10.1_RefPage_questionphase', [('refID') : 'source_' + refID]))

'Screenshot: User reulatory proceed next phase'
WebUI.takeScreenshot()

'Click 1st option'
WebUI.click(findTestObject('HL Full Lifecycle/10.2 ReferencPAge_button_Send to studio', [('refID') : 'source_' + refID]))

'Click Submit next phase'
WebUI.click(findTestObject('HL Full Lifecycle/10.3 RefPage_Submitstudio'))

'Screenshot: user studio: Successfully send next phase '
WebUI.takeScreenshot()

'Logout as regulatory'
functions.I.Logout()

//LOGIN AS STUDIO - dchi
'Login as studio'
functions.I.Login_password('studio', password_studio)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//REF LIST PAGE
WebUI.waitForElementClickable(findTestObject('HL Full Lifecycle/10.10 RefPage_Question', [('refID') : 'source_' + refID]), 
    10)

'User studio: proceed to next phase\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/10.10 RefPage_Question', [('refID') : 'source_' + refID]))

WebUI.click(findTestObject('HL Full Lifecycle/11 ReferencePage_Question_a_Accept the brief', [('refID') : 'source_' + refID]))

// CLICK ON ACCEPT BRIEF
WebUI.click(findTestObject('HL Full Lifecycle/11 RefPage_Button_AcceptBrief', [('refID') : 'source_' + refID]))

WebUI.delay(1)

//PRODUCTION PHASE: UPLOAD DOC
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
    'color', FailureHandling.OPTIONAL)

while (color1 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']))

    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
        'color', FailureHandling.OPTIONAL)
}

WebUI.delay(2)

'Screenshot: user studio: Successfully send next phase '
WebUI.takeScreenshot()

'Log out as studio'
functions.I.Logout()

//LOGIN AS Marketing
'Login as Marketing'
functions.I.Login_password('marketing', password_marketing)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.delay(2)

'Approve doc'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']))

'Screenshot: user marketing: Successfully approved doc '
WebUI.takeScreenshot()

'Log out as studio'
functions.I.Logout()

//LOGIN AS Regulatory
'Login as regulatory'
functions.I.Login_password('regulatory', password_regulatory)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.waitForPageLoad(10)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'User regulatory: Click on view doc'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']))

'Screenshot: user regulatory: Successfully approved doc '
WebUI.takeScreenshot()

'Logout as reg'
functions.I.Logout()

//LOGIN AS FS atran
'Login as atran'
functions.I.Login_password('atran', password_atran)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.waitForPageLoad(5)

'Appprove doc'
functions.I.AWF_approve_byaction(findTestObject('Object Repository/HL Full Lifecycle/Function AWFAction2', [('refID') : 'source_' + 
            refID]))

WebUI.delay(1)

'User atran: Submit to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submit_AurelieTran', [('refID') : 'source_' + refID]))

WebUI.delay(1)

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Question_sendtodiadeis', [('refID') : 'source_' + refID]))

////////////////////////////////REFERENCE FIELDS  - ERROR MESSAGE///////////////////////////////////////////////
WebUI.scrollToElement(findTestObject('Object Repository/Control Tag/3.0 codeEANCT(atran)'), 1)

'The star is displayed next to Code EAN field'
functions.I.verifystar('Code EAN', findTestObject('Object Repository/Control Tag/3.0 codeEANCT(atran)'), log)

WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight)', [])

'The star is displayed next to Brief photogravure'
functions.I.verifystar('Brief photogravure', findTestObject('Object Repository/Control Tag/3.1 BP_CT'), log)

'The star is displayed next to Number of colors Repro field'
functions.I.verifystar('Number of colors Repro', findTestObject('Object Repository/Control Tag/3.1 NoColorCT'), log)

'The star is displayed next to MAD supplier'
functions.I.verifystar('MAD supplier', findTestObject('Object Repository/Control Tag/3.1 MADCT'), log)

'The star is displayed next to Print type'
functions.I.verifystar('Print type', findTestObject('Object Repository/Control Tag/3.1 PrinterTypeCT'), log)

WebUI.scrollToElement(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submittodiadies'), 5)

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submittodiadies'))

//Toastr
'Screenshot: Verification Toastr message on Reference '
WebUI.takeScreenshot()

'Click cancel'
WebUI.click(findTestObject('Object Repository/Control Tag/3.1 cancel(atran)'))

////////////////////////////////END REFERENCE FIELDS  - ERROR MESSAGE///////////////////////////////////////////////
//REFERENCE LIST PAGE: ACTION BUTTON
'User atran: Submit to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submit_AurelieTran', [('refID') : 'source_' + refID]))

WebUI.delay(1)

'Click Submit'
WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Question_sendtodiadeis', [('refID') : 'source_' + refID]))

WebUI.delay(1)

//MODIFICATION REFERENCE PAGE
'Screenshot: Modification Ref Page '
WebUI.takeScreenshot()

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

WebUI.delay(2)

'Logout as atran'
functions.I.Logout()

//LOGIN AS STUDIO 
'Log in as Studio'
functions.I.Login_password('studio', password_studio)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.waitForElementClickable(findTestObject('Object Repository/HL Full Lifecycle/16.11 Ref_Submit Studio(studio)', [('refID') : 'source_' + 
            refID]), 10)

'Click Submit'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/16.11 Ref_Submit Studio(studio)', [('refID') : 'source_' + 
            refID]))

WebUI.delay(1)

'The star is displayed next to Exe files'
functions.I.verifystar('Exe files archive', findTestObject('Object Repository/Control Tag/1.2.1 asterix exe'), log)

//REF PAGE
WebUI.click(findTestObject('HL Full Lifecycle/16 RefPg_Button_SubmitCyril'))

'Screenshot: Verification Error message on Reference '
WebUI.takeScreenshot()

//VERIFY ERROR MSG
functions.I.verifyErrormsg_EXACT('Exe files archive', findTestObject('Object Repository/Control Tag/3.3 Errormsg(studio)'), 
    'Exe files archive is missing', log)

'Click modify Project'
WebUI.click(findTestObject('Control Tag/2.2 ButtonModifyProject'))

WebUI.delay(1)

'Upload file'
functions.I.UploadDoc_sendkey_field('//*[@id="var_123"]', 'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

WebUI.delay(1)

'Screenshot: Upload field  '
WebUI.takeScreenshot()

WebUI.delay(1)

' Click Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[1]']))
 

//REFERENCE LIST PAGE: 
'Click Submit'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/16.11 Ref_Submit Studio(studio)', [('refID') : 'source_' + 
            refID]))

'Click Submit'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/16.3 submit(studio)'))

'Logout as studio'
functions.I.Logout()

//LOGIN AS IRAZ - diadeis
'Log in as Iraz'
functions.I.Login_password('lraz', password_iraz)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Screenshot: ref listpage'
WebUI.takeScreenshot()

WebUI.delay(3)

//PRODUCTION PHASE: UPLOAD DOC
String color2 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
    'color', FailureHandling.OPTIONAL)

while (color2 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']))

    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    WebUI.click(findTestObject('HL Full Lifecycle/9.1 REfPg_Button_Upload_IR_Part 1'))

    WebUI.delay(5)

    color2 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
        'color', FailureHandling.OPTIONAL)
}

WebUI.delay(1)

'Logout as Iraz'
functions.I.Logout()

//LOGIN AS FS Aurelie tran
'Login as atran'
functions.I.Login_password('atran', password_atran)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Click on review button'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/14.1 RefList_Eye(Atran)', [('refID') : 'source_' + refID]))

WebUI.delay(1)

'Screenshot: User atran approve doc'
WebUI.takeScreenshot()

'Approve doc'
functions.I.AWF_approve_view()

'Screenshot: User atran approve doc'
WebUI.takeScreenshot()

'Click on Submit'
WebUI.click(findTestObject('HL Full Lifecycle/17 Ref_Button_Submit_question', [('refID') : 'source_' + refID]))

'User atran question phase option'
WebUI.takeScreenshot()

'Click 1st option'
WebUI.click(findTestObject('HL Full Lifecycle/17 Ref_Options_DDCupdated', [('refID') : 'source_' + refID]))

'Click update'
WebUI.click(findTestObject('HL Full Lifecycle/17.1 Ref_Question_DDCUpdated'))

'Verify Status: completed'
functions.I.status(findTestObject('HL Full Lifecycle/Status', [('refID') : 'source_' + refID]))

'Status: Completed'
WebUI.takeScreenshot()

//Notepad write
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Sephora\\102.02\\102.02_Sephora_ProjectNo.txt', 
    Project_No)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Sephora\\102.02\\102.02_Sephora_refID.txt', refID)

WebUI.closeBrowser()

