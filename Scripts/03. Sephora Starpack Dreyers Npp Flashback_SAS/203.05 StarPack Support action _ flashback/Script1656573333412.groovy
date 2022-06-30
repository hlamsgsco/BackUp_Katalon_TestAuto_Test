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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.junit.After as After
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import java.util.Date as Date
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

String password_aherms = data.getValue(2, 2)

String password_agluszczynska = data.getValue(2, 3)

String password_suser = data.getValue(2, 1)

String password_jmaciaszczyk = data.getValue(2, 4)

String password_aterreshernandez = data.getValue(2, 5)

String password_amartin_arbol = data.getValue(2, 6)

String password_adelamatanieves = data.getValue(2, 7)

String password_kcannoosamy_dia = data.getValue(2, 8)

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

/////////////////////////GENERAL INFO - CHROME//////////////////////////////////////
//Keyword log
KeywordLogger log = new KeywordLogger()

/*
String Project_No = 'MI000668'

String refID = '5402'

*/
'Navigate to URL StarpackTest'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

//////////////////////////CREATION OF PROJECT - AWIS///////////////////////////////
'Log in as Packaging_1: adelamatanieves/ dchi'
functions.I.Login_password('adelamatanieves', password_adelamatanieves)

'Screenshot: Log as adelamatanieves'
WebUI.takeScreenshot()

'Click on the LHS menu'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Packaging_1: Click on + icon to create project '
WebUI.click(findTestObject('Object Repository/1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

'Screenshot: Creation project page'
WebUI.takeScreenshot()

'DEFINE PROJECT NAME'
def project_name0 = (('AutoTest_Chrome_Starpack_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + 
'_') + functions.I.gettimedate()

'Enter: Name of project'
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name0)

'Click on button create project'
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

WebUI.delay(1)

'Screenshot: Modify project page'
WebUI.takeScreenshot()

'DEFINE PROJECT NAME'
def project_name1 = (('AutoTest_Chrome_Starpack_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(20)) + 
'_') + functions.I.gettimedate()

//NAME THE PROJECT
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name1)

WebUI.delay(1)

'Select from list Enseña: Dia'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_98']), '122', false)

WebUI.delay(1)

'Select from list Buyer:Alejandro Martin Arbol'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_9']), 'amartin_arbol', false)

WebUI.delay(1)

'Select from list Packaging Manager: ANAISABEL TERRÉSHERNÁNDEZ'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_10']), 'aterreshernandez', false)

WebUI.delay(1)

'Add options > Multiple field list Ingeniero de Packaging'
WebUI.selectOptionByValue(findTestObject('Object Repository/xxx Todelete/1.4 ModifyProPage_MF(IDP)'), 
    'nalonsobermejo', true)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/xxx Todelete/1.41 ModifyProPage_AddMF'))

WebUI.delay(1)

'Select from list Código del proveedor: 0075022'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_15']), '292', false)

WebUI.delay(1)

'SPACE OF AD - All - Att: Marcin Lewandowski ul. Śląska 14 60-614 Poznań POLAND +48 884 801 485'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_26']), '94', false)

WebUI.delay(1)

'SPACE OF AD - All - Att: Marcin Lewandowski ul. Śląska 14 60-614 Poznań POLAND +48 884 801 485'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_12']), '94', false)

WebUI.delay(1)

'Select from list Agencia de producción: "SPACE OF AD - Anna Gluszczynska - Att: Anna Gluszczynska ul. Śląska 14 60-614 Poznań POLAND +48 884 801 485"'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_27']), '734', false)

WebUI.delay(1)

'Select from list Agencia de Validador externo: EurofinsEspaña Food'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_71']), 'efood', false)

'Screenshot: Modify project page - completed'
WebUI.takeScreenshot()

WebUI.delay(5)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(10)

//END OF MODIFY PROJECT PAGE
// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()

///////////////////////CREATION OF REF ////////////////////////////////////////
//CREATE REFERENCE
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(10)

'Screenshot: Creation Reference Page'
WebUI.takeScreenshot()

//CHOOSE LIFECYCLE : 
//*[@id="ref_type"]
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'ref_type']), '6', false)

//CLICK ON CREATE REF BUTTON
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

//GET THE ID OF THE REF
String refID = functions.I.RefID()

System.out.println(refID)

'Screenshot: Modification Reference Page'
WebUI.takeScreenshot()

//*[@id="var_28"]
'Input text code: 209293'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_28']), '209293')

//[@id="var_30"]
'Input Vínculo con boceto: test Submarca'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_30']), 'test Submarca')

'Input Vínculo con bulto: test Submarca'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_31']), 'test Submarca Vínculo con bulto: test Submarca')

//*[@id="var_30"]
'Select from list Tipo de trabajo: title="AA.FF. cambio de proveedor /  Alterações da arte final pelo fornecedor /  Change of supplier artwork"'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_38']), '24', false)

//*[@id="var_39"]
'Input Código de barras: Código de barras: 8480017155061'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_39']), '8480017155061')

//*[@id="selSource_19"]
'Multiple list Select from list País'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'selSource_19']), '22', false)

WebUI.click(findTestObject('Object Repository/xxx Todelete/2.01 ModifyRef_Pais'))

//*[@id="var_75"]
'Multiple list Select from list Idioma(s)'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_75']), '26', false)

//CLICK SAVE
WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

//////////////////////////STEP 1 : Request & internal briefing/////////////////////////////////////
/////////////////////////Phase 1: Request////////////////////////////////////////////
'Screenshot: Reference List Page'
WebUI.takeScreenshot()

'Ref List page: Ana click on proceed to next phase (1)'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[3]']))

'Screenshot: Modif Reference Page'
WebUI.takeScreenshot()

'Ana submit next phase on ref page (1)'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.031 RefPg_AnnaSubmit', [('id') : '1']))

'Screenshot: Reference List Page'
WebUI.takeScreenshot()

/////////////////////////Phase 2: Briefing > TO SKIP////////////////////////////////////////////
'Click on ref name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[4]/a']))

WebUI.delay(5)

'Screenshot: Reference Page'
WebUI.takeScreenshot()

'Click on doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(2)

'61 Hover over the skip button'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div/a[3]']))

'Verify of tooltip present'
String Atooltip_skip = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

functions.I.print('Atooltip_skip ' + Atooltip_skip)

String Etooltip_skip = 'Saltar esta fase'

WebUI.verifyMatch(Atooltip_skip, Etooltip_skip, false)

'Screenshot: Doc tab- tooltip'
WebUI.takeScreenshot()

'Click skip button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div/a[3]']))

'Screenshot: Popup skip'
WebUI.takeScreenshot()

'Clickk cancel on the popup > No changed done'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[1]']))

'Screenshot: No changes'
WebUI.takeScreenshot()

'Click skip button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div/a[3]']))

'Screenshot: Popup skip'
WebUI.takeScreenshot()

//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]
'Click OK on the popup '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]']))

'Screenshot: Toastr success'
WebUI.takeScreenshot()

'Verify toastr - Skip sucess'
String Actual_Successmsg = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

String Expected_Successmsg = 'Se ha omitido la fase Briefing'

functions.I.print('Actual error msg - ' + Actual_Successmsg)

WebUI.verifyMatch(Actual_Successmsg, Expected_Successmsg, false)

'Click on step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a']))

///html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/a
'Click expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/a']))

WebUI.delay(1)

'Screenshot: Skip by is present'
WebUI.takeScreenshot()

'Verify that text - skip us present'
String ActualSkip_ES = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/h5']))

functions.I.print('Skip is displayed - ' + ActualSkip_ES)

String ExpectSkip_ES = 'Omitido por ANA DELAMATANIEVES'

WebUI.verifyMatch(ExpectSkip_ES, ActualSkip_ES, false)

'Click on the step phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a']))

WebUI.delay(5)

'Click Expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/div[2]/a']))

WebUI.delay(5)

'Screenshot: Skip automatically'
WebUI.takeScreenshot()

'Verify text "Skip automatically if group empty'
String ActualSkipAuto_ES = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/h5']))

functions.I.print('Skip is displayed - ' + ActualSkipAuto_ES)

String ExpectSkipAuto_ES = 'Skipped automatically (empty group)'

WebUI.verifyMatch(ExpectSkipAuto_ES, ActualSkipAuto_ES, false)

'Click on the fils d ariane'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[2]/div/nav/ol/li[2]/a']))

'Screenshot: REf List page'
WebUI.takeScreenshot()

'Verify that Lifecycle: PAF'
String Alifecycle_PAF = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[7]/span[2]']))

functions.I.print('Lifecycle - ' + Alifecycle_PAF)

String Elifecycle_PAF = 'PAF'

WebUI.verifyMatch(Alifecycle_PAF, Elifecycle_PAF, false)

/////////////////////////////   STEP 2: PAF & Final artworks ////////////////////////////////////////
/////////////////////////Phase 2: PAF > TO DELETE AA.FF.////////////////////////////////////////////
'Click on ref name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[4]/a']))

'Click on doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

functions.I.Pagedown()

'Hover over the delete button'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a[2]']))

'Screenshot: Tooltip delete'
WebUI.takeScreenshot()

'Verify of tooltip present'
String Atooltip_del = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

String Etooltip_del = 'Borrar esta fase'

WebUI.verifyMatch(Atooltip_del, Etooltip_del, false)

'Click on delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a[2]']))

'Screenshot: Popup delete'
WebUI.takeScreenshot()

'Line 111 Click on OK in popup delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

'Screenshot: Toastr success for delete'
WebUI.takeScreenshot()

'Verify toastr success'
String ActualSuceessDel = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

functions.I.print('Skip is displayed - ' + ActualSuceessDel)

String Exp_SuceessDel = 'The phase Final artworks has been removed'

WebUI.verifyMatch(ActualSuceessDel, Exp_SuceessDel, false)

'Screenshot: Lifecycle - Final Artworks phase deleted'
WebUI.takeScreenshot()

WebUI.delay(1)

'Logout as ana'
functions.I.Logout()

///////////////////////////////////////////////////SUSER//////////////////////////////////////////////////////////
'Log in as suser/ dchi'
functions.I.Login_password('suser', password_suser)

'Screenshot :Login as SUSER'
WebUI.takeScreenshot()

'Click on LHS menu'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

/////////////////////////Phase 2: PAF > TO ADD Phase AA.FF.////////////////////////////////////////////
'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Click on ref name'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.03 suser id_source_refID__td4_a', [('refID') : 'source_' + 
            refID]))

'click on doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Hover over the add phase'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a[1]']))

'Screenshot: Doc Tab - tooltip Add phase'
WebUI.takeScreenshot()

'Verify tooltip - Add phases'
String Atooltip_AddPhase = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

functions.I.print('tooltip Actual for Add phase -' + Atooltip_AddPhase)

String Etooltip_AddPhase = 'Add phases'

WebUI.verifyMatch(Atooltip_AddPhase, Etooltip_AddPhase, false)

'Click on the add phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a[1]']))

WebUI.delay(1)

'Pop up : Select Add a phase'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'added_phase']), '52', false)

'Screenshot: Popup of Select steps or phases to add after the phase: PAF'
WebUI.takeScreenshot()

'Pop up: Click on Add'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addphase"]/div/div/div[3]/button[2]']))

'Verify toastr successfully added'
String Asuccess_AddPhase = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

functions.I.print('tooltip Actual for Add phase -' + Asuccess_AddPhase)

String Esuccess_AddPhase = 'The phase Final artworks has been added after the phase PAF'

WebUI.verifyMatch(Asuccess_AddPhase, Esuccess_AddPhase, false)

'Screenshot: Success msg'
WebUI.takeScreenshot()

'Verify that Final Artwork has been added'
String APhase = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/h3']))

String EPhase = 'Final artworks'

WebUI.verifyMatch(APhase, EPhase, false)

'142 Click on expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/a']))

WebUI.delay(1)

'Screenshot: Added Phase'
WebUI.takeScreenshot()

'Verify that Final Artwork has been added'
def AddedPhase_A = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[2]/h6']))

functions.I.print('added manually -' + AddedPhase_A)

'78'
String date = functions.I.gettimedate_Format()

String AddedPhase_E = ' Added manually ' + date

if (AddedPhase_A.contains(AddedPhase_E)) {
    if (AddedPhase_A.contains('By s user')) {
        functions.I.print('OK - added manually is written')

        assert true
    }
}

/////////////////////////Phase 2: PAF > TO SKIP PAF////////////////////////////////////////////
WebUI.delay(5)

////*[@id="level_50543"]/div[1]/div[2]/div/a[3]
///html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a[3]
functions.I.Pagedown()

'Mouse over Skip'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a[3]']))

WebUI.delay(1)

///html/body/div[9]/div[2]
'Line 152 Verify tooltip - Skip phases'
String A_SkipPhase_480 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

functions.I.print('tooltip Actual for Skip phase -' + A_SkipPhase_480)

//String E_SkipPhase_480 = '×'+'/n'+'Lifecycle'+'/n'+'The phase Final artworks has been added after the phase PAF'
String E_SkipPhase_480 = 'Skip this phase'

'180'

//WebUI.verifyMatch(A_SkipPhase_480, E_SkipPhase_480, false)
'Click on SKIP'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a[3]']))

'Screenshot: Popup for skip'
WebUI.takeScreenshot()

'Click ok for skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/form[4]/div/div/div/div[3]/button[2]']))

WebUI.delay(5)

'186 VErify if the shortcut action is present'
WebUI.verifyElementClickable(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a[4]']))

WebUI.delay(2)

//*[@id="level_50774"]/div[1]/div[2]/div/a[4]
'175 Verify toolip shortcut action'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a[4]']))

WebUI.delay(1)

String Atooltip_SA = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

functions.I.print('tooltip Actual for Add phase -' + Atooltip_SA)

String Etooltip_SA = 'Go back to PAF'

'Screenshot: Tooltip for SAS'
WebUI.takeScreenshot()

WebUI.verifyMatch(Atooltip_SA, Etooltip_SA, false)

'Click fils dariane'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]']))

//*[@id="refID"]/td[9]/a[4]
'33On the ref list page : Verify that the shortcut action is present'
WebUI.verifyElementClickable(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.04 suser id_refID_td9_a4', 
        [('refID') : 'source_' + refID]))

////*[@id="source_5333"]/td[9]/a[4]
'hover over Support action button'
WebUI.mouseOver(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.04 suser id_refID_td9_a4', [('refID') : 'source_' + 
            refID]))

'Screenshot: SAS button'
WebUI.takeScreenshot()

WebUI.delay(1)

///html/body/div[9]/div[2]
'Verify that tooltip is present'
String Atooltip_SA2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

functions.I.print('tooltip Actual for SA -' + Atooltip_SA2)

String Etooltip_SA2 = 'Go back to PAF'

WebUI.verifyMatch(Atooltip_SA2, Etooltip_SA2, false)

'Logout as suser'
functions.I.Logout()

///////////////////////////////////////////////Supplier AHHERMS//////////////////////////////////////////////
////////////////////////////////////VERIFY RIGHTS - SUPPLER DOES NOT HAVE RIGHTS/////////////////////////////
functions.I.Login_password('aherms', password_aherms)

WebUI.delay(2)

//CLICK ON THE SIDE MENU: PROJECTS
'194'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

'Ref list page , button support action is not present'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.07 Agency1 id_refID_td8', 
        [('refID') : 'source_' + refID]), 10)

'Screenshot: REf List page'
WebUI.takeScreenshot()

'199 Click on ref name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[4]/a']))

'Click on doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(5)

'Screenshot: Doc tab'
WebUI.takeScreenshot()

'Lifecycle : No SKIP is present'
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a[5]']), 
    10)

///html/body/div[1]/div[2]/div[9]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/a
///html/body/div[1]/div[2]/div[9]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a[4]
'Lifecycle : No support action button is present'
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a[6]']), 
    10)

'Logout as supplier'
functions.I.Logout()

/////////////////////////////////////////////////Suppport /////////////////////////////////////////////
functions.I.Login_password('kcannoosamy_dia', password_kcannoosamy_dia)

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Screenshot: Login as Support '
WebUI.takeScreenshot()

///SEARCH FOR PROJECT
//*[@id="form_filters"]/div[4]/button
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

/////////////////////////////////////////STEP 2:  PAF & Final artworks ////////////////////////////////////
///////////////////////////////////////PHASE 3: FINAL ARTWORKS //////////////////////////////////////////
//REF LIST PAGE
'210 Verify that Support action is present on the ref list page'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[9]/a']), 
    10)

'Screenshot: Support Action on the ref list page '
WebUI.takeScreenshot()

'Hover over the support action'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[9]/a']))

'Verify tooltip - Go back to PAF'
String Atooltip_SkipPhase_Support = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

functions.I.print('tooltip Actual for Add phase -' + Atooltip_SkipPhase_Support)

String Etooltip_SkipPhase_Support = 'Go back to PAF'

WebUI.verifyMatch(Atooltip_SkipPhase_Support, Etooltip_SkipPhase_Support, false)

'Screenshot: ref list page tooltip'
WebUI.takeScreenshot()

//LIFECYCLE TAB
'Click on ref name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[4]/a']))

WebUI.delay(5)

'Click on doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(5)

'Screenshot: Support action is displayed on Lifeycle tab '
WebUI.takeScreenshot()

'Verify that support action is displayed on the lifecycle tab'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a[4]']))

// /html/body/div[8]
'Verify tooltip - Go back to PAF'
String ALtooltip_SkipPhase_Support = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

functions.I.print('tooltip Actual for Add phase -' + ALtooltip_SkipPhase_Support)

String ELtooltip_SkipPhase_Support = 'Go back to PAF'

WebUI.verifyMatch(ALtooltip_SkipPhase_Support, ELtooltip_SkipPhase_Support, false)

'Click on the support action'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a[4]']))

WebUI.delay(1)

'Screenshot: Popup for SAS'
WebUI.takeScreenshot()

//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]
'Click ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[3]/button[2]']))

'Click on lifecycle  tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(2)

WebUI.takeScreenshot()

functions.I.Pagedown()

// /html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div[1]/div/div[2]/h6
'75 VErify that Added manually is displayed'
String LAddedPhase_A1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[4]/div/div[2]/h6']))

String date1 = functions.I.gettimedate_Format()

String LAddedPhase_E1 = ' Added manually ' + date1

if (LAddedPhase_A1.contains(LAddedPhase_E1)) {
    if (LAddedPhase_A1.contains('By Kormaley Cannoosamy')) {
        functions.I.print('OK - added manually is written')

        assert true
    }
}

WebUI.delay(1)

////html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[5]/div/div[1]/div[2]/a
///html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[5]/div/div[2]/h6
'220 Click on Expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[5]/div/div[1]/div[2]/a']))

functions.I.Pagedown()

WebUI.delay(2)

WebUI.takeScreenshot()

///html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[5]/div/div[2]/h6
///html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div[1]/div/div[2]/h6
'220 VErify that Added manually is displayed 2'
String LAddedPhase_A2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[5]/div/div[2]/h6']))

String date2 = functions.I.gettimedate_Format()

String LAddedPhase_E2 = ' Added manually ' + date2

if (LAddedPhase_A2.contains(LAddedPhase_E2)) {
    if (LAddedPhase_A2.contains('By Kormaley Cannoosamy')) {
        functions.I.print('OK - added manually is written')

        assert true
    }
}

'Screenshot : Lifecycle > Support Action OK'
WebUI.takeScreenshot()

'Logout as Support'
functions.I.Logout()

/////////////////////////////////////////////////Ssuser /////////////////////////////////////////////
functions.I.Login_password('suser', password_suser)

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Screenshot: Login as Suser '
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[1]/a']))

///SEARCH FOR PROJECT
//*[@id="form_filters"]/div[4]/button
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

WebUI.delay(1)

//*[@id="${refID}"]/td[4]/a
////*[@id="source_4974"]/td[4]/a
'Click on ref name'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.03 suser id_source_refID__td4_a', [('refID') : 'source_' + 
            refID]))

'Click on doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(2)

'Line 230 Click on Skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[4]/div/div[1]/div[2]/div/a[3]']))

//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]
'Click OK'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]']))

WebUI.delay(1)

////*[@id="kt_subheader"]/div/nav/ol/li[2]/a
'68 Click on the fils dariance'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

WebUI.delay(1)

'Screenshot: Support action is displayed on ref list page '
WebUI.takeScreenshot()

//*[@id="source_4989"]/td[9]/a[4]
'Click on the support action button'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.04 suser id_refID_td9_a4', [('refID') : 'source_' + 
            refID]))

'Screenshot: Popup Support action is displayed '
WebUI.takeScreenshot()

//*[@id="modal_support_action_shortcut"]/div/div/div[2]/button[2]
'Click on ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[2]/button[2]']))

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[1]/a']))

///SEARCH FOR PROJECT
//*[@id="form_filters"]/div[4]/button
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

WebUI.delay(1)

'verify thaht PAF is displayed on the ref list page'
String A_Status_Lifecycle = WebUI.getText(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.08 Agency2 Lifecycle status id_refID_td6_span2', 
        [('refID') : 'source_' + refID]))

functions.I.print('tooltip Actual for Add phase -' + A_Status_Lifecycle)

String E_Status_Lifecycle = 'PAF'

WebUI.verifyMatch(A_Status_Lifecycle, E_Status_Lifecycle, false)

'Screenshot:Status for the lifecycle is PAF '
WebUI.takeScreenshot()

'Click on ref name'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.03 suser id_source_refID__td4_a', [('refID') : 'source_' + 
            refID]))

'Click on doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Click on delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[7]/div/div[1]/div[2]/div/a[2]']))

'249 Click ok to delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

'Screenshot:Status for Phase deleted '
WebUI.takeScreenshot()

'Click on skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[6]/div/div[1]/div[2]/div/a[3]']))

'Click ok to Skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]']))

'Screenshot:Phase skip '
WebUI.takeScreenshot()

'Click on step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']))

'Click delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[2]/div/div[1]/div[2]/div/a[2]']))

'Click ok to delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

'Screenshot: Phase deleted '
WebUI.takeScreenshot()

'Click on skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[1]/div/div[1]/div[2]/div/a[3]']))

'Click ok to Skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]']))

'Click on the fils dariance ref name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

//REF LIST : support action should be displayed
//*[@id="source_4989"]/td[9]/a[2]
//*[@id="source_4990"]/td[9]/a[3]
'Verify that the support action is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.06 suser id_refID_td9_a3', 
        [('refID') : 'source_' + refID]), 10)

'Hover over support action'
WebUI.mouseOver(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.06 suser id_refID_td9_a3', [('refID') : 'source_' + 
            refID]))

///html/body/div[8]/div[2]
///html/body/div[8]/div[2]
'Verify tooltip - Go back PAF'
String A_Status_Lifecycle_Completed = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

functions.I.print('tooltip Actual for Status -' + A_Status_Lifecycle_Completed)

String E_Status_Lifecycle_Completed = 'Go back to PAF'

WebUI.verifyMatch(A_Status_Lifecycle_Completed, E_Status_Lifecycle_Completed, false)

'Click on support action'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.06 suser id_refID_td9_a3', [('refID') : 'source_' + 
            refID]))

//*[@id="modal_support_action_shortcut"]/div/div/div[2]/button[2]
'Click ok '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[2]/button[2]']))

'Click on doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

//verify that steps have beeen added
'Click on skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div[1]/div/div[1]/div[2]/div/a[3]']))

'Click ok to Skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]']))

'Click on skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[1]/div[2]/div/a[3]']))

'Click ok to Skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]']))

'Click on steps'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']))

'Click on delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[5]/div/div[2]/div/div[1]/div[2]/div/a[2]']))

'Click ok to del'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

'Click on skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/a[3]']))

'Click ok to Skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]']))

'Click on the fils dariance ref name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

//*[@id="source_4993"]/td[9]/a[2]
'Click submit'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.04 Agency1 id_refID_td9_a2', [('refID') : 'source_' + 
            refID]))

//*[@id="source_4993"]/td[9]/a[2]
'Verify that support action is diplayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.04 Agency1 id_refID_td9_a2', 
        [('refID') : 'source_' + refID]), 10)

WebUI.closeBrowser()

