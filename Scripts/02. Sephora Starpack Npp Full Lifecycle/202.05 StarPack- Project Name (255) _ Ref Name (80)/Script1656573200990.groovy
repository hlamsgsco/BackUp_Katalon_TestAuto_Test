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

def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

String password_suser = data.getValue(2, 1)

String password_aherms = data.getValue(2, 2)

String password_agluszczynska = data.getValue(2, 3)

String password_jmaciaszczyk = data.getValue(2, 4)

String password_aterreshernandez = data.getValue(2, 5)

String password_amartin_arbol = data.getValue(2, 6)

String password_adelamatanieves = data.getValue(2, 7)

String password_kcannoosamy_dia = data.getValue(2, 8)

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

/////////////////////////GENERAL INFO - CHROME//////////////////////////////////////
//Keyword log
//KeywordLogger log = new KeywordLogger()
/*String Project_No = 'MI000502'

String refID = '5095'
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
WebUI.click(findTestObject('Object Repository/1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

'Screenshot: Creation project page'
WebUI.takeScreenshot()

//DEFINE PROJECT NAME - 255
def project_name0 = (('AutoTest_Chrome_Starpack_Long_ProjectName_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(
    10)) + '_') + functions.I.gettimedate()

// def project_name = (('AutoTest_Chrome_Starpack_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(210)) +   '_') + functions.I.gettimedate()
//NAME THE PROJECT
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name0)

//CLICK ON CREATE PROJECT
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

WebUI.delay(1)

'Screenshot: Modify project page'
WebUI.takeScreenshot()

//DEFINE PROJECT NAME - 255
def project_name1 = ((('AutoTest_Chrome_Starpack__Long_ProjectName_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(
    195)) + '_') + functions.I.gettimedate()) + '_tesst'

//NAME THE PROJECT
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name1)

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

'30'
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

WebUI.delay(5)

'Screenshot: Modify project page - completed'
WebUI.takeScreenshot()

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(5)

//END OF MODIFY PROJECT PAGE
// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()

'Click on view Project'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/1.01 View Project id_card_project_div2_div_div3a3'))

'verify the no. of char in the text box'
String project_name = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="common_details"]/div[2]/div/div']))

functions.I.print((('No. of char for the project ' + project_name) + '  >   ') + project_name.length())

if (project_name.length() != 255) {
    assert false
}

'Click on the fils dariance'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]']))

///////////////////////CREATION OF REF ////////////////////////////////////////
//CREATE REFERENCE
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(10)

'Screenshot: Creation Reference Page'
WebUI.takeScreenshot()

//CHOOSE LIFECYCLE : 
//*[@id="ref_type"]
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'ref_type']), '11', false)

def ref_name1 = ((('Long _name_Ref_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(47)) + '_') + functions.I.gettimedate()) + 
'_testttt'

'Input the reference name'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_name']), ref_name1)

'verify the no. of char in the text box'
String text_ref_name1 = WebUI.getAttribute(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_name']), 'value')

functions.I.print((('No. of char for the ref ' + text_ref_name1) + '  >   ') + text_ref_name1.length())

if (text_ref_name1.length() != 80) {
    assert false
}

//CLICK ON CREATE REF BUTTON
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

//GET THE ID OF THE REF
String refID = functions.I.RefID()

System.out.println(refID)

WebUI.delay(1)

'Screenshot: Modification Reference Page'
WebUI.takeScreenshot()

//*[@id="var_28"]
'Input text code: 209293'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_28']), '209293')

WebUI.delay(20)

//[@id="var_30"]
////*[@id="var_30"]
'61 Input Vínculo con boceto: test Submarca'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_30']), 'test Submarca')

//*[@id="var_31"]
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

'Ref List page: Ana click on proceed to next phase (1)'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[3]']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.031 RefPg_AnnaSubmit', [('id') : '1']))

'Click on the ref name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[4]/a']))

'Click on doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

///html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div/a[3]
'71 Click on skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div/a[3]']))

'Screenshot: Popup skip'
WebUI.takeScreenshot()

'Click ok to Skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]']))

'Clickt step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a']))

'Line 75 click expand button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/a']))

'Screenshot: Phase skipped'
WebUI.takeScreenshot()

'Verify that the phase has been skipped'
String A_Skip_Anna = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/h5']))

functions.I.print('Skip this phase - ' + A_Skip_Anna)

String E_Skip_Anna = 'Omitido por ANA DELAMATANIEVES'

WebUI.verifyMatch(E_Skip_Anna, A_Skip_Anna, false)

///html/body/div[1]/div[2]/div[9]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a
'Click on step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a']))

'delete phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a[2]']))

'Line 83 Click ok to del'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

'Click on skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div/div/div[1]/div[2]/div/a[3]']))

///*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]
//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]
'85 Click ok to Skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]']))

'Click on the fils dariance'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]']))

WebUI.delay(1)

String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[3]']), 
    'color', FailureHandling.OPTIONAL)

functions.I.print(color1)

// /html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[3]
while (color1 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[3]']))

    'Supplier Upload doc for production phase'
    WebUI.takeScreenshot()

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdataaddition1.jpg', 'testdataaddition1.jpg')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

    WebUI.delay(5)

    if (WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[3]']), 
        10, FailureHandling.OPTIONAL)) {
        color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[3]']), 
            'color', FailureHandling.OPTIONAL //*[@id="source_5294"]/td[8]/a
            )
    } else {
        color1 = 'white'
    }
}


'94 Click on the ref name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[4]/a']))

'Click on the Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'delete phase 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[3]/div/div[1]/div[2]/div/a[2]']))

'xClick ok to del'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

'delete phase 2'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[3]/div/div[1]/div[2]/div/a[2]']))

'Click ok to del'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

'Click on the doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))

'Click on the doc tab > approval workflow'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_doc_AW"]']))

'Click on ?'
functions.I.Approveforothers('//*[@id="level_apl_0"]/div[2]/div[2]/div/div', '//*[@id="level_apl_0"]/div[2]/div[2]/div/div/div[6]/a[2]/span')


'Go back to reflist page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))



'Verify Status - Completed'
String status = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[7]/span']))



WebUI.verifyMatch(status, 'Completado', false)

WebUI.closeBrowser()

