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

//USERNAME & PASSWORD  
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Test_Sephora')

String password_emartineau = data_Sephora.getValue(2, 9)

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Sephora = data_urlTESTAUTO.getValue(2, 1)

/////////////////////////////////////TEST START ///////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to Sephora Test'
WebUI.openBrowser(Url_Sephora)

WebUI.maximizeWindow()

//LOG IN emartineau
'Log in as emartineau'
functions.I.Login_password('emartineau', password_emartineau)

'Screenshot: Log as emartineau'
WebUI.takeScreenshot()

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//////////////////////////////////////////////////CREATION OF PROJECT NAME ///////////////////////////////////
'Click on + icon to create project '
WebUI.click(findTestObject('xxx Todelete/3 ProjectListPage_Create_Project_Button'))

'Screenshot: Click + button'
WebUI.takeScreenshot()

'Define Project Name'
def project_name = (('TC104.01_AutoTest_Chrome_EmptyGroup_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(
    10)) + '_') + functions.I.gettimedate()

'Set Project Name'
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name)

'Screenshot: Create Project Page'
WebUI.takeScreenshot()

'Click Create Project'
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

' Screenshot: Modification Project Page: Field filled'
WebUI.takeScreenshot()

///// EXPAND & COLLAPSE OF Project
WebUI.delay(1)

'Click Collapse'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_4294_ModifFiche"]/div[1]/div[2]/a']))

WebUI.delay(1)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_4294_ModifFiche"]/div[2]']), 
    FailureHandling.OPTIONAL)

'Screenshot: Collapse'
WebUI.takeScreenshot()

'Expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_4294_ModifFiche"]/div[1]/div[2]/a']))

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_4294_ModifFiche"]/div[2]']), 
    FailureHandling.OPTIONAL)

WebUI.delay(10)

'Screenshot: Expand'
WebUI.takeScreenshot()

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

//END OF MODIFY PROJECT PAGE
//REF LIST PAG
'Get Project No'
String Project_No = functions.I.ProjectNo()

//////////////////////////////////////////////////CREATION OF REF ///////////////////////////////////
'Click create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(25)

'Select lifecycle template: 32'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/6 ReferenceList_Choose Lifecycle'), '32', false)

'Define Project Name'
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10) + '_EmptyGroup_') + functions.I.gettimedate()

'Set Project Name'
WebUI.setText(findTestObject('HL Full Lifecycle/6 Reference_input_Component name_field'), 'Component_' + ref_name)

'Screenshot: Create Reference Page: Lifecycle selected & Name filled'
WebUI.takeScreenshot()

'Click Create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

'Get ref ID'
String refID = functions.I.RefID()

' Screenshot: Modification ref Page'
WebUI.takeScreenshot()

///// EXPAND & COLLAPSE OF REF
WebUI.delay(1)

'Click Collapse'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_7196_ModifFiche"]/div[1]/div[2]/a']))

WebUI.delay(1)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_7196_ModifFiche"]/div[2]']), 
    FailureHandling.OPTIONAL)

'Screenshot: Collapse'
WebUI.takeScreenshot()

'Click Expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_7196_ModifFiche"]/div[1]/div[2]/a']))

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_7196_ModifFiche"]/div[2]']), 
    FailureHandling.OPTIONAL)

WebUI.delay(1)

'Screenshot: Expand'
WebUI.takeScreenshot()

' Click Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[1]']))

WebUI.delay(3)

///////////////////////////////////STEP 1 - PHASE 1.1///////////////////////
'User : Proceed to next Phase'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

//REFERENCE PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

/////////////////////////////EMPTY GROUP PAGE 1 - USER FIELD  /////////////////////
'Screenshot: Empty Group user field'
WebUI.takeScreenshot()

String Actual_Error_msg1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]']))

functions.I.print(Actual_Error_msg1)

String Expected_Error_msg1 = ((('Studio (Project)' + '\n') + 'This group has no related user') + '\n') + 'Modify this project'

WebUI.verifyMatch(Actual_Error_msg1, Expected_Error_msg1, false)

'click on modify this project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]/div[2]/div/a']))

//////////////////////////PROJECT PAGE//////////////////////////////
'Screenshot: Project PAge'
WebUI.takeScreenshot()

WebUI.delay(1)

'Select Studio'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'studio')

'Click on update '
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

///////////////////////////////////STEP 1 - PHASE 1.2///////////////////////
'Verify that the phase has changed'
String Actual_status1 = WebUI.getText(findTestObject('Object Repository/TAG/id_refid_td5_span1', [('refID') : 'source_' + 
            refID]))

WebUI.verifyMatch(Actual_status1, 'Phase 1.2', false)

'Click on submit'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

'Screenshot: ref modif page'
WebUI.takeScreenshot()

'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

/////////////////////////////EMPTY GROUP PAGE 2 - USER FIELD  /////////////////////
'Screenshot: Empty Group filtered group'
WebUI.takeScreenshot()

String Actual_Error_msg2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]']))

functions.I.print(Actual_Error_msg2)

String Expected_Error_msg2 = ((((('Printer_FG' + '\n') + 'Potential problem with these fields:') + '\n') + 'Printer (Component)') + 
'\n') + 'Modify this component brief'

WebUI.verifyMatch(Actual_Error_msg2, Expected_Error_msg2, false)

'click on Modify this component brief'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]/div[3]/div/a']))

//////////////////////////////MODIFY REF//////////////////////////////////////
'Screenshot: ref modif page'
WebUI.takeScreenshot()

WebUI.delay(1)

'Select printer'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_18"]']), '180', false)

' Click Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[1]']))
 

'Click on submit'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

///////////////////////////////////STEP 2 - PHASE 2.1///////////////////////
'Screenshot: ref list page '
WebUI.takeScreenshot()

'Verify that the phase has changed'
String Actual_status2 = WebUI.getText(findTestObject('Object Repository/TAG/id_refid_td5_span1', [('refID') : 'source_' + 
            refID]))

WebUI.verifyMatch(Actual_status2, 'Phase 2.1', false)

WebUI.takeScreenshot()

'Click on send to complete'
functions.I.submitquesiton_ref(findTestObject('Object Repository/TAG/id_refid_td7_div_1', [('refID') : 'source_' + refID]), 
    findTestObject('Object Repository/TAG/id_refid_td7_div1_div_a1', [('refID') : 'source_' + refID]))

'Screenshot: modif page'
WebUI.takeScreenshot()

' Select from list '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_133"]']), '268', false)

'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

/////////////////////////////EMPTY GROUP PAGE 3 - USER FIELD + Group Approval /////////////////////
'Screenshot: Empty Group User field + group approval'
WebUI.takeScreenshot()

String Actual_Error_msg3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]']))

functions.I.print(Actual_Error_msg3)

String Expected_Error_msg3 = ((((((('Studio (Project)' + '\n') + 'Potential problem with these fields:') + '\n') + 'External agency (Component)') + 
'\n') + 'ANAIS LEFEVRE') + '\n') + 'Modify this component brief'

WebUI.verifyMatch(Actual_Error_msg3, Expected_Error_msg3, false)

'click on Modify this component brief'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]/div[3]/div/a']))

//////////////////////////////MODIFY REF//////////////////////////////////////
'Screenshot: ref modif page'
WebUI.takeScreenshot()

WebUI.delay(1)

' Click Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[1]']))

'Click on road 1'
functions.I.submitquesiton_ref(findTestObject('Object Repository/TAG/id_refid_td7_div_1', [('refID') : 'source_' + refID]), 
    findTestObject('Object Repository/TAG/id_refid_td7_div1_div_a2', [('refID') : 'source_' + refID]))

'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

/////////////////////////////EMPTY GROUP PAGE 4 - USER FIELD + Group Approval /////////////////////
'Screenshot: Empty Group User field + group approval'
WebUI.takeScreenshot()

String Actual_Error_msg4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]']))

functions.I.print(Actual_Error_msg4)

String Expected_Error_msg4 = ((((((('Studio (Project)' + '\n') + 'Potential problem with these fields:') + '\n') + 'External agency (Component)') + 
'\n') + 'ANAIS LEFEVRE') + '\n') + 'Modify this component brief'

WebUI.verifyMatch(Actual_Error_msg4, Expected_Error_msg4, false)

'click on Modify this component brief'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]/div[3]/div/a']))

//////////////////////////////MODIFY REF//////////////////////////////////////
'Screenshot: ref modif page'
WebUI.takeScreenshot()

WebUI.delay(1)

'Select External agency'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_133"]']), '253', false)

' Click Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[1]']))

'Click on road 1'
functions.I.submitquesiton_ref(findTestObject('Object Repository/TAG/id_refid_td7_div_1', [('refID') : 'source_' + refID]), 
    findTestObject('Object Repository/TAG/id_refid_td7_div1_div_a2', [('refID') : 'source_' + refID]))

'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

///////////////////////////////////STEP 1 - PHASE 1.2///////////////////////
'Screenshot: ref list page '
WebUI.takeScreenshot()

'Verify that the phase has changed'
String Actual_status3 = WebUI.getText(findTestObject('Object Repository/TAG/id_refid_td5_span1', [('refID') : 'source_' + 
            refID]))

WebUI.verifyMatch(Actual_status3, 'Phase 1.2', false)

'User: Click on send to'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

///////////////////////////////////STEP 2 - PHASE 2.1///////////////////////
'Screenshot: ref list page '
WebUI.takeScreenshot()

'Verify that the phase has changed'
String Actual_status4 = WebUI.getText(findTestObject('Object Repository/TAG/id_refid_td5_span1', [('refID') : 'source_' + 
            refID]))

WebUI.verifyMatch(Actual_status4, 'Phase 2.1', false)

WebUI.takeScreenshot()

'Click on send to complete'
functions.I.submitquesiton_ref(findTestObject('Object Repository/TAG/id_refid_td7_div_1', [('refID') : 'source_' + refID]), 
    findTestObject('Object Repository/TAG/id_refid_td7_div1_div_a1', [('refID') : 'source_' + refID]))

'Screenshot: modif page'
WebUI.takeScreenshot()

'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

///////////////////////////////////Complete///////////////////////
'Screenshot: ref list page '
WebUI.takeScreenshot()

'Verify that the phase has changed to Complete'
String Actual_status5 = WebUI.getText(findTestObject('Object Repository/TAG/id_refid_td5_span', [('refID') : 'source_' + 
            refID]))

WebUI.verifyMatch(Actual_status5, 'Complete', false)

'Close Browser'
WebUI.closeBrowser()

