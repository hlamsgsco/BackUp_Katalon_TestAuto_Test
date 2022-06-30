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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

String password_suser = data.getValue(2, 1)

String password_aherms = data.getValue(2, 2)

String password_agluszczynska = data.getValue(2, 3)

String password_jmaciaszczyk = data.getValue(2, 4)

String password_aterreshernandez = data.getValue(2, 5)

String password_amartin_arbol = data.getValue(2, 6)

String password_adelamatanieves = data.getValue(2, 7)

String password_kcannoosamy_dia = data.getValue(2, 8)

String password_ysanzmonedero = data.getValue(2, 16)

String password_bsolletbravo = data.getValue(2, 17)

String password_agarciasanchez = data.getValue(2, 18)

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

/*
///////////////////////////////////////////////////////////////
//Keyword log
KeywordLogger log = new KeywordLogger()


String Project_No = 'MI000974'

String refID = '5934'


String refID_TD = Integer.parseInt(refID) + 1

*/
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Test'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

//LOG IN AS Packaging_1: adelamatanieves	 ~ dchi
'Log in as Packaging_1: adelamatanieves/ dchi'
functions.I.Login_password('adelamatanieves', password_adelamatanieves)

'Screenshot: Log as adelamatanieves'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//CLICK ON CREATE PROJECT BUTTON
'Packaging_1: Click on + icon to create project '
WebUI.click(findTestObject('xxx Todelete/3 ProjectListPage_Create_Project_Button'))

'Screenshot: Creation project page'
WebUI.takeScreenshot()

//DEFINE PROJECT NAME
def project_name = (('TC213.02_AutoTest_Chrome_Starpack' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(
    10)) + '_') + functions.I.gettimedate()

//NAME THE PROJECT
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name)

//CLICK ON CREATE PROJECT
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

WebUI.delay(1)

'Screenshot: Modify project page'
WebUI.takeScreenshot()

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
WebUI.selectOptionByValue(findTestObject('Object Repository/xxx Todelete/1.4 ModifyProPage_MF(IDP)'), 'nalonsobermejo', 
    true)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/xxx Todelete/1.41 ModifyProPage_AddMF'))

WebUI.delay(1)

'Select from list Código del proveedor: 0075022'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_15']), '292', false)

WebUI.delay(1)

'Verify if the text box Nombre del proveedor is not blank'
value = WebUI.getAttribute(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/1.6 ModifyProPage _NDP'), 
    'value')

WebUI.delay(1)

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

WebUI.delay(1)

'Screenshot: Modify project page - completed'
WebUI.takeScreenshot()

WebUI.delay(10)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.waitForPageLoad(10)

WebUI.delay(5)

//END OF MODIFY PROJECT PAGE
// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()

//CREATE REFERENCE
'47'
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

'Logout as Ana'
functions.I.Logout()

'Log in as Setup: suser/ dchi'
functions.I.Login_password('suser', password_suser)

'Screenshot: Log as suser'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//Super Edit ref
functions.I.superedit_ref(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.02 Suser super edit', [('refID') : 'source_' + 
            refID]), findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.03 Suser super edit (option)', 
        [('refID') : 'source_' + refID]))

'Screenshot: Suser modification page '
WebUI.takeScreenshot()

//Modification od field SUPER EDIT
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)', 
        [('field_ID') : 'field_var_40']))

//Lactose free picto - yes
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)', 
        [('field_ID') : 'field_var_41']))

//ADILAC picto - yes
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)', 
        [('field_ID') : 'field_var_42']))

//MSC picto - yes
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)', 
        [('field_ID') : 'field_var_43']))

//Veggie picto - No
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(No)', 
        [('field_ID') : 'field_var_44']))

//BIO-ECO picto -No
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(No)', 
        [('field_ID') : 'field_var_45']))

//Spain Origin picto -No
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(No)', 
        [('field_ID') : 'field_var_99']))

//save when superedit
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.05 Suser saves for super edit ref'))

'Logout as Suser'
functions.I.Logout()

//LOG IN AS Packaging_1: adelamatanieves	 ~ dchi
'Log in as Packaging_1: adelamatanieves/ dchi'
functions.I.Login_password('adelamatanieves', password_adelamatanieves)

'Screenshot: Log as Ana'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Ref List page: Ana click on proceed to next phase (1)'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[3]']))

'Ana submit next phase on ref page (1)'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.031 RefPg_AnnaSubmit', [('id') : '1']))

'Ana submit next phase on ref LIST page (2) '
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.03 Block anna'))

//To generate daughter ref PTS - No
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_2464_ModifFiche"]/div[2]/div[1]/div/div[1]/label[2]']))

//To generate daughter ref Sample - No
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_2464_ModifFiche"]/div[2]/div[2]/div/div[1]/label[2]']))

//To generate daughter ref GTD - Yes	
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_2464_ModifFiche"]/div[2]/div[3]/div/div[1]/label[1]']))

//Scroll down
functions.I.Pagedown()

//Submit to next phase
'Ana submit next phase Ref Pg(2)'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.05 RefPg_submit'))

WebUI.delay(2)

'Screenshot: Reference list page > Automatic creation of 3 daughter ref PTS /Product Sample/Technical Drawing '
WebUI.takeScreenshot()

//Packaging Ana Logout.
'Packaging_1 Ana: log out'
functions.I.Logout()

//Ref id for the daughter ref
String refID_TD = Integer.parseInt(refID) + 1

////////////////////////////////////DAUGHTER REFERNCE PTS PHASE 1///////////////////////////////////////////
'Login as suser '
functions.I.Login_password('suser', password_suser)

'Screenshot: Login as suser'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

////////////////////////////////////DAUGHTER TD >PHASE 1: TD SUBMIT NEXT PHASE
'Daughter ref TD: submit TD  - Phase 1'
String color1 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
        [('refID') : 'source_' + refID_TD]), 'color', FailureHandling.OPTIONAL)

functions.I.print(color1)

'148'
while (color1 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
            [('refID') : 'source_' + refID_TD]))

    'Supplier Upload doc for production phase'
    WebUI.takeScreenshot()

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdataaddition1.jpg', 'testdataaddition1.jpg')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    'Agency 2 - Yolanda Sanz Monedero'
    WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), '651', false)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    functions.I.click_button_javascript(findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
            [('refID') : 'source_' + refID_TD]), 10, FailureHandling.OPTIONAL)) {
        color1 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
                [('refID') : 'source_' + refID_TD]), 'color', FailureHandling.OPTIONAL //*[@id="source_5294"]/td[8]/a
            )

        'Agency 2 - Yolanda Sanz Monedero'
        WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), '651', false)
    } else {
        color1 = 'white'
    }
}

'Logout as Supplier'
functions.I.Logout()

//LOGIN AS AGENCY2 ysanzmonedero
'Login as AGENCY2 ysanzmonedero'
functions.I.Login_password('ysanzmonedero', password_ysanzmonedero)

'Screenshot :Login'
WebUI.takeScreenshot()

'Click on task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

'121 Click see all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[3]/a']))

WebUI.delay(1)

String taskno_1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[1]/h3/span']))

double taskno_11 = Double.parseDouble(taskno_1)

int n = 1

while (n <= taskno_11) {
    String result = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[' + 
                n) + ']/td[1]/a']), FailureHandling.OPTIONAL)

    if (result.contains(Project_No)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[' + 
                    n) + ']/td[1]/a']))

        break
    } else {
        n = (n + 1)

        if (n > taskno_11) {
            break
        }
    }
}

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="BtnrefusalButton"]']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="disable_rejectionButton"]']))

WebUI.delay(1)

double taskno_22 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')

WebUI.verifyEqual(taskno_11 - 1, taskno_22)

functions.I.Logout()

////////////////////////////////////////////////
'Login as AGENCY2 ysanzmonedero'
functions.I.Login_password('agarciasanchez', password_agarciasanchez)

'Screenshot :Login as AGENCY2 agarciasanchez'
WebUI.takeScreenshot()

double task_no3 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')

functions.I.Logout()

////////////////////////////////////DAUGHTER TD >PHASE 1: TD SUBMIT NEXT PHASE
'Login as suser '
functions.I.Login_password('suser', password_suser)

'Screenshot: Login as suser'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

////////////////////////////////////DAUGHTER TD >PHASE 1: TD SUBMIT NEXT PHASE
'Daughter ref TD: submit TD  - Phase 1'
String color2 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
        [('refID') : 'source_' + refID_TD]), 'color', FailureHandling.OPTIONAL)

functions.I.print(color2)

'148'
while (color2 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
            [('refID') : 'source_' + refID_TD]))

    'Supplier Upload doc for production phase'
    WebUI.takeScreenshot()

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdataaddition1.jpg', 'testdataaddition1.jpg')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    'Agency 2 -Agency 2 - Adela Garcia Sanchez'
    WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), '645', false)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    functions.I.click_button_javascript(findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
            [('refID') : 'source_' + refID_TD]), 10, FailureHandling.OPTIONAL)) {
        color2 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
                [('refID') : 'source_' + refID_TD]), 'color', FailureHandling.OPTIONAL //*[@id="source_5294"]/td[8]/a
            )

        'Agency 2 - Agency 2 - Adela Garcia Sanchez'
        WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), '645', false)
    } else {
        color2 = 'white'
    }
}

'Logout '
functions.I.Logout()

'Login as AGENCY2 ysanzmonedero'
functions.I.Login_password('agarciasanchez', password_agarciasanchez)

'Screenshot :Login as AGENCY2 agarciasanchez'
WebUI.takeScreenshot()

double task_no4 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')

WebUI.verifyEqual(task_no3, task_no4 - 1)

'Click on task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

'Click see all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[3]/a']))

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[1]/div/form/select']), 
    '250', false)

WebUI.delay(1)

int m = 1

while (m <= task_no4) {
    ///html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a
    ///html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[61]/td[1]/a
    ///html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[62]/td[1]/a
    String result = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[' + 
                m) + ']/td[1]/a']), FailureHandling.OPTIONAL)

    if (result.contains(Project_No)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[' + 
                    m) + ']/td[1]/a']))

        break
    } else {
        m = (m + 1)

        if (m > taskno_11) {
            break
        }
    }
}

///*[@id="aff_doc_preview"]
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_doc_preview"]']))

'Logout '
functions.I.Logout()

////////////////////////////////////DAUGHTER TD >PHASE 1: TD SUBMIT NEXT PHASE
'Login as suser '
functions.I.Login_password('suser', password_suser)

'Screenshot: Login as suser'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

////////////////////////////////////DAUGHTER TD >PHASE 1: TD SUBMIT NEXT PHASE
////*[@id="source_5927"]/td[9]/a
////*[@id="source_5933"]/td[9]/a
'Daughter ref TD: submit TD  - Phase 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_TD) + '"]/td[9]/a']))

'Supplier Upload doc for production phase'
WebUI.takeScreenshot()

//UPLOAD A DOC
functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 'D:\\Upoad_File\\Upload doc\\testdataaddition1.jpg', 
    'testdataaddition1.jpg')

'Screenshot: Production phase Field Upload doc'
WebUI.takeScreenshot()

WebUI.delay(10)

'Agency 2 -Agency 2 - Beatriz Sollet Bravo'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), '650', false)

//REF PAGE: CLICK ON PROCEED TO NEXT PHASE
functions.I.click_button_javascript(findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

WebUI.delay(5)

'Logout '
functions.I.Logout()

'Login as AGENCY2 bsolletbravo'
functions.I.Login_password('bsolletbravo', password_bsolletbravo)

'Screenshot :Login as AGENCY2 bsolletbravo'
WebUI.takeScreenshot()

double task_no5 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')

'Click on task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

'Click see all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[3]/a']))

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[1]/div/form/select']), 
    '250', false)

WebUI.delay(1)

int k = 1

while (k <= task_no5) {
    ///html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a
    ///html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[61]/td[1]/a
    ///html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[62]/td[1]/a
    String result = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[' + 
                k) + ']/td[1]/a']), FailureHandling.OPTIONAL)

    if (result.contains(Project_No)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[' + 
                    k) + ']/td[1]/a']))

        break
    } else {
        k = (k + 1)

        if (k > task_no5) {
            break
        }
    }
}

functions.I.AWF_approve_view()

WebUI.delay(1)

'188'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[5]/td[11]/a']))

WebUI.delay(1)

double task_no6 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')

WebUI.verifyEqual(task_no6, task_no5 - 1)

'Logout '
functions.I.Logout()

/////////////////CLOSE PROJECT
'Login as suser '
functions.I.Login_password('suser', password_suser)

'Screenshot: Login as suser'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.delay(1)

'Click on close project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[4]']))

'VErify the toastr isdisplayed'
String Expected_R = 'You cannot close this project because it contains at least 1 reference not completed, not deleted or not cancelled.'

String Actual_R = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

WebUI.verifyMatch(Actual_R, Expected_R, false)

'Screenshot: toastr'
WebUI.takeScreenshot()

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.delay(1)

'Click on ...'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[9]/div[2]/button']))

WebUI.delay(1)

'Click on delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[9]/div[2]/div/a[3]']))

WebUI.delay(1)

'Screenshot: popup delete'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

WebUI.delay(1)

'Click on close project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[4]']))

////*[@id="toast-container"]/div/div[2]
'VErify the msg isdisplayed'
String Expected_R2 = 'Project closed.'

String Actual_R2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

WebUI.verifyMatch(Actual_R2, Expected_R2, false)

WebUI.closeBrowser()

