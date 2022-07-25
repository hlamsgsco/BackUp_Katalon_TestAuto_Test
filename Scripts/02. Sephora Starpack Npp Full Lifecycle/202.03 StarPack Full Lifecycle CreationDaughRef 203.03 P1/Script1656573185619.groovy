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

//USERNAME & PASSWORD
def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

String password_suser = data.getValue(2, 1)

String password_aherms = data.getValue(2, 2 //R
    )

String password_agluszczynska = data.getValue(2, 3 //R
    )

String password_aterreshernandez = data.getValue(2, 5 //R
    )

String password_adelamatanieves = data.getValue(2, 7 //R
    )

//URL
def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

//Keyword log
KeywordLogger log = new KeywordLogger()

//Clear Notepad
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_PS.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_PTS.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_TD.txt')

////////////////////////////////////////////TEST START ////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Test'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

//LOG IN AS Packaging_1: adelamatanieves	 ~ dchi
'Log in as Packaging_1: adelamatanieves/ dchi'
functions.I.Login_password('adelamatanieves', password_adelamatanieves)

'Screenshot: Log as adelamatanieves'
WebUI.takeScreenshot()

'Click on the LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//CLICK ON CREATE PROJECT BUTTON
'Packaging_1: Click on + icon to create project '
WebUI.click(findTestObject('Object Repository/1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

//CREATION PROJECT PAGE
'Screenshot: Creation project page'
WebUI.takeScreenshot()

'define project name'
def project_name = (('TC4.01_AutoTest_Chrome_Starpack' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + 
'_') + functions.I.gettimedate()

'Set project name'
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name)

'Click on Create project '
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

WebUI.delay(1)

'Screenshot: Modify project page'
WebUI.takeScreenshot()

'Select from list Enseña: Dia'
functions.I.SelectFromList_Value('//*[@id="var_98"]', '122')

WebUI.delay(2)

'28 Select from list Buyer:Alejandro Martin Arbol'
functions.I.SelectFromList_Value('//*[@id="var_9"]', 'amartin_arbol')

WebUI.delay(2)

'Select from list Packaging Manager: ANAISABEL TERRÉSHERNÁNDEZ'
functions.I.SelectFromList_Value('//*[@id="var_10"]', 'aterreshernandez')

WebUI.delay(1)

'Add options > Multiple field list Ingeniero de Packaging'
functions.I.select_multiplelist('//*[@id="selSource_49"]', '//*[@id="btnAdd_49"]', 'nalonsobermejo')

WebUI.delay(1)

'Select from list Código del proveedor: 0075022'
functions.I.SelectFromList_Value('//*[@id="var_15"]', '292')

'Verify if the text box Nombre del proveedor is not blank'
value = WebUI.getAttribute(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/1.6 ModifyProPage _NDP'), 
    'value')

WebUI.delay(1)

if (value == 'MCBRIDE, S.A.') {
    'Nombre del proveedor is not empty'
    System.out.println('Value is filled with  value  MCBRIDE, S.A.- Test ok')

    assert true
} else {
    log.logFailed('Warning! Field Empty- Test KO')
}

WebUI.delay(1)

'SPACE OF AD - All - Att: Marcin Lewandowski ul. Śląska 14 60-614 Poznań POLAND +48 884 801 485'
functions.I.SelectFromList_Value('//*[@id="var_26"]', '94')

'SPACE OF AD - All - Att: Marcin Lewandowski ul. Śląska 14 60-614 Poznań POLAND +48 884 801 485'
functions.I.SelectFromList_Value('//*[@id="var_12"]', '94')

'Select from list Agencia de producción: "SPACE OF AD - Anna Gluszczynska - Att: Anna Gluszczynska ul. Śląska 14 60-614 Poznań POLAND +48 884 801 485"'
functions.I.SelectFromList_Value('//*[@id="var_27"]', '734')

'Select from list Agencia de Validador externo: EurofinsEspaña Food'
functions.I.SelectFromList_Value('//*[@id="var_71"]', 'efood')

'Screenshot: Modify project page - completed'
WebUI.takeScreenshot()

WebUI.delay(10)

'Click on update'
WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.waitForPageLoad(10)

WebUI.delay(5)

//END OF MODIFY PROJECT PAGE
'Get Project No'
String Project_No = functions.I.ProjectNo()

//CREATE REFERENCE
'Click on + to create ref '
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

'Click create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.delay(5)

'Screenshot: Creation Reference Page'
WebUI.takeScreenshot()

'Select lifecycle'
functions.I.SelectFromList_Value('//*[@id="ref_type"]', '6')

'Click + to create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))
WebUI.delay(5)
'Get refid'
String refID = functions.I.RefID()

'Screenshot: Modification Reference Page'
WebUI.takeScreenshot()
WebUI.delay(5)
'59 Input text code: 209293'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_28']), '209293')

'Input Vínculo con boceto: test Submarca'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_30']), 'test Submarca')

'Input Vínculo con bulto: test Submarca'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_31']), 'test Submarca Vínculo con bulto: test Submarca')

'Select from list Tipo de trabajo: title="AA.FF. cambio de proveedor /  Alterações da arte final pelo fornecedor /  Change of supplier artwork"'
functions.I.SelectFromList_Value('//*[@id="var_38"]', '24')

'Input Código de barras: Código de barras: 8480017155061'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_39']), '8480017155061')

'Multiple list Select from list País'
functions.I.select_multiplelist('//*[@id="selSource_19"]', '//*[@id="btnAdd_19"]', '22')

' list Select from list Idioma(s)'
functions.I.SelectFromList_Value('//*[@id="var_75"]', '26')

'Click save'
WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

'Logout as Ana'
functions.I.Logout()

//SUSER
'Log in as Setup: suser/ dchi'
functions.I.Login_password('suser', password_suser)

'Screenshot: Log as suser'
WebUI.takeScreenshot()

'Click LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Super Edit ref'
functions.I.superedit_ref(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.02 Suser super edit', [('refID') : 'source_' + 
            refID]), findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.03 Suser super edit (option)', 
        [('refID') : 'source_' + refID]))

'Screenshot: Suser modification page '
WebUI.takeScreenshot()

//Modification od field SUPER EDIT
'Click yes'
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)', 
        [('field_ID') : 'field_var_40']))

'Lactose free picto - yes'
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)', 
        [('field_ID') : 'field_var_41']))

'ADILAC picto - yes'
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)', 
        [('field_ID') : 'field_var_42']))

'MSC picto - yes'
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)', 
        [('field_ID') : 'field_var_43']))

'Veggie picto - No'
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(No)', 
        [('field_ID') : 'field_var_44']))

'BIO-ECO picto -No'
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(No)', 
        [('field_ID') : 'field_var_45']))

'Spain Origin picto -No'
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(No)', 
        [('field_ID') : 'field_var_99']))

'Superdit : click save'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.05 Suser saves for super edit ref'))

'Logout as Suser'
functions.I.Logout()

//Packaging_1: adelamatanieves	 ~ dchi
'Log in as Packaging_1: adelamatanieves/ dchi'
functions.I.Login_password('adelamatanieves', password_adelamatanieves)

'Screenshot: Log as Ana'
WebUI.takeScreenshot()

'Click LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Ref List page: Ana click on proceed to next phase (1)'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[3]']))

'Ana submit next phase on ref page (1)'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.031 RefPg_AnnaSubmit', [('id') : '1']))

'Ana submit next phase on ref LIST page (2) '
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.03 Block anna'))

//To generate daughter ref PTS
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.04 Field yes_No (Auto Daughter ref)', 
        [('id') : '1']))

//To generate daughter ref Sample
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.04 Field yes_No (Auto Daughter ref)', 
        [('id') : '2']))

//To generate daughter ref GTD
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.04 Field yes_No (Auto Daughter ref)', 
        [('id') : '3']))

functions.I.Pagedown()

'Ana submit next phase Ref Pg(2)'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.05 RefPg_submit'))

WebUI.delay(2)

'Screenshot: Reference list page > Automatic creation of 3 daughter ref PTS /Product Sample/Technical Drawing '
WebUI.takeScreenshot()

'Packaging_1 Ana: log out'
functions.I.Logout()

//Ref id for the daughter ref
String refID_PTS = Integer.parseInt(refID) + 1

String refID_PS = Integer.parseInt(refID) + 2

String refID_TD = Integer.parseInt(refID) + 3

//Write notepad
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_ProjectNo.txt', 
    Project_No)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID.txt', 
    refID)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_PS.txt', 
    refID_PS)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_PTS.txt', 
    refID_PTS)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_TD.txt', 
    refID_TD)

//setup: suser	 ~ dchi
'Log in as Setup: suser/ dchi'
functions.I.Login_password('suser', password_suser)

'Screenshot: Log as suser'
WebUI.takeScreenshot()

'Click on LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Screenshot: Verification of 3 daughter refs created'
WebUI.takeScreenshot()

//VERIFICATION OF DAUGHTER REF
'107 Verify that Daughter ref PTS has been created'
functions.I.verifyDaughterrefCreated(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.01 Suser Ref Daughter verification', 
        [('refID_PTS') : 'source_' + refID_PTS]), 'PTS', log)

'Verify that Daughter ref Product Sample has been created'
functions.I.verifyDaughterrefCreated(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.01 Suser Ref Daughter verification', 
        [('refID_PTS') : 'source_' + refID_PS]), 'Product Sample', log)

'Verify that Daughter ref Technical Drawing has been created'
functions.I.verifyDaughterrefCreated(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.01 Suser Ref Daughter verification', 
        [('refID_PTS') : 'source_' + refID_TD]), 'Technical Drawing', log)

//END VERIFICATION OF DAUGHTER REF
'logout as suser'
functions.I.Logout()

////////////////////////////////////DAUGHTER REFERNCE PTS PHASE 1///////////////////////////////////////////
'Login as Supplier 0075022 Herms - Anna Carrascoca - aherms '
functions.I.Login_password('aherms', password_aherms)

'Screenshot: Login as Supplier'
WebUI.takeScreenshot()

'Click on LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

////////////////////////////////////DAUGHTER PTS >PHASE 1: PTS SUBMIT NEXT PHASE
'Daughter ref PTS: submit PTS briefing - Phase 1'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.01 Supplier proceed to next phase(PTS)', 
        [('field_id') : 'ancre_' + refID_TD]))

'Supplier modifies the daughter ref pts - part A'
WebUI.takeScreenshot()

'PTS upload field'
functions.I.UploadDoc_sendkey_field('//*[@id="var_77"]', 'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1')

'PTS Text field Datos de contacto del proveedor'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_46']), 'Datos de contacto del proveedor - Text Field')

functions.I.Pagedown()

'REFERNCE PG: Supplier: PTS send to next phase '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

'Supplier send PTS - Phase 1 (Complete)'
WebUI.takeScreenshot()

/////////////////////////////////DAUGHTER PS >PHASE 1: PS SUBMIT NEXT PHASE
'Daughter ref PTS: submit PS  - Phase 1'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
        [('refID') : 'source_' + refID_PS]))

'Supplier modifies the daughter ref PS - part A'
WebUI.takeScreenshot()

'PS Text field Número de seguimiento del envío de la muestra de producto'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_24']), 'Número de seguimiento del envío de la muestra de producto- Text Field')

'Supplier send to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

'REFERNCE PG: Supplier send PS - Phase 1 (Complete)'
WebUI.takeScreenshot()

////////////////////////////VRIFY THAT EXPAND & COLLAPSE OF REF LIST PAGE//////////////////////////
//////COLLAPSE
WebUI.delay(1)

'Click Collapse'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[4]/a[2]']))

WebUI.delay(1)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

'Screenshot: Collapse'
WebUI.takeScreenshot()

//////EXPAND
'Click Expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[4]/a[2]']))

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

'Screenshot: Expand'
WebUI.takeScreenshot()

//////COLLAPSE ALL //*[@id="all_a"]
WebUI.delay(1)

'Click Collapse all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="all_a"]']))

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[4]/a[1]']), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

'Screenshot: Collapse'
WebUI.takeScreenshot()

//////EXPAND ALL
'Click Expand all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="all_a"]']))

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[4]/a[1]']), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[4]/a']), 
    FailureHandling.STOP_ON_FAILURE)

////////////////////////////////////DAUGHTER TD >PHASE 1: TD SUBMIT NEXT PHASE
'Daughter ref TD: submit TD  - Phase 1'
String color1 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
        [('refID') : 'source_' + refID_TD]), 'color', FailureHandling.OPTIONAL)

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

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    functions.I.click_button_javascript(findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
            [('refID') : 'source_' + refID_TD]), 10, FailureHandling.OPTIONAL)) {
        color1 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
                [('refID') : 'source_' + refID_TD]), 'color', FailureHandling.OPTIONAL //*[@id="source_5294"]/td[8]/a
            )
    } else {
        color1 = 'white'
    }
}

'Logout as Supplier'
functions.I.Logout()

//LOGIN AS AGENCY2 Anna Gluszczynska
'Login as AGENCY2 Anna Gluszczynska : agluszczynska/dchi'
functions.I.Login_password('agluszczynska', password_agluszczynska)

'Screenshot :Login as AGENCY2 Anna Gluszczynska'
WebUI.takeScreenshot()

'Click on the LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//////////////////////////////////// FOR DAUGHTER TD
'Click on REVIEW BUTTON(EYE)'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.01 agency_2 RefPg_Prodbutton(Eye)', [('refID') : 'source_' + 
            refID_TD]))

'Approve doc'
functions.I.AWF_approve_view()

WebUI.delay(1)

'agency2 asumit next phase for daughter ref TD'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_TD) + '"]/td[9]/a']))

'Verify Lifecycle status - Complete'
functions.I.VerifyMatchText(('//*[@id="source_' + refID_TD) + '"]/td[6]/span', 'Complete')

'Status: Completed for Daughter TD \r\n'
WebUI.takeScreenshot()

//////////////////////////////////// FOR DAUGHTER PTS PHASE 2
'Agency2 clicks on question button'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.02 Agency_2_refPg_questionbutton', [('ref_ID') : 'ancre_' + 
            refID_TD]))

WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.021 Agency_2_RefPg_question_approve', [
            ('ref_ID') : 'ancre_' + refID_TD]))

WebUI.delay(1)

'Screenshot: Popup for the question phase'
WebUI.takeScreenshot()

'Agency2 clicks OK'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

WebUI.delay(1)

//////////////////////////////////// FOR DAUGHTER PTS - PHASE 3 (LAST)
'Agency2 clic submit on the ref listk'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.03 id_refID_a', [('refID') : 'ancre_' + 
            refID_TD]))

//VERIFICATION OF REF COMPLETED FOR PTS
'Verification of status: Completed'
functions.I.VerifyMatchText(('//*[@id="source_' + refID_PTS) + '"]/td[6]/span', 'Complete')

'Status: Completed for Daughter PTS'
WebUI.takeScreenshot()

//////////////////////////////////// FOR DAUGHTER PS - PHASE 2
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_PS) + '"]/td[9]/a']))

'verify if the lifecycle of the mother ref is Wait for PTS/Sample/Tech drawing '
functions.I.VerifyMatchText(('//*[@id="source_' + refID) + '"]/td[6]/span[2]', 'Wait for PTS/Sample/Tech drawing')

//////////////////////////////////// FOR DAUGHTER PS - PHASE 3 (LAST)
'Agency click on proceed to next phase - PS'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.04 Agency1 id_refID_td9_a2', [('refID') : 'source_' + 
            refID_PS]))

'Agency upload doc'
functions.I.UploadDoc_sendkey_field('//*[@id="var_47"]', 'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1')

'Aency clicks submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

'verify the mother ref has proceeded to the next phase automatially: The lifecycle of the mother ref is PAF '
functions.I.VerifyMatchText(('//*[@id="source_' + refID) + '"]/td[6]/span[2]', 'PAF')

'Agency click on upload button'
String color2 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.06 Agency1 id_refID_a', 
        [('refID') : 'ancre_' + refID_PS]), 'color', FailureHandling.OPTIONAL)

while (color2 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.06 Agency1 id_refID_a', [('refID') : 'ancre_' + 
                refID_PS]))

    'Supplier Upload doc for production phase'
    WebUI.takeScreenshot()

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdataaddition1.jpg', 'testdataaddition1.jpg')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

    WebUI.delay(5)

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
            [('refID') : 'source_' + refID_TD]), 10, FailureHandling.OPTIONAL)) {
        color2 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', 
                [('refID') : 'source_' + refID_TD]), 'color', FailureHandling.OPTIONAL)
    } else {
        color2 = 'white'
    }
}

'Logout as Agency'
functions.I.Logout()

//ANAISABEL TERRÉSHERNÁNDEZ
'Login as ANAISABEL TERRÉSHERNÁNDEZ '
functions.I.Login_password('aterreshernandez', password_aterreshernandez)

'Screenshot :Login as ANAISABEL TERRÉSHERNÁNDEZ'
WebUI.takeScreenshot()

'Click on the LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[7]/button']))

//////////////////FOR MOTHER REF 
'Anaisabel click on the review button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="ancre_' + refID_PS) + '"]/a[2]']))

'Approve doc'
functions.I.AWF_approve_view()

'Logout as Anais'
functions.I.Logout()

//LOGIN AS SUSER
'Login as suser'
functions.I.Login_password('suser', password_suser)

'Screenshot: Log as suser'
WebUI.takeScreenshot()

'Click on the LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//APPROVE PERMANENTLY FOR OTHERS - PART 1
'Click on ref link'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.02 suser id_source_refID__td4_a1', [('refID') : 'source_' + 
            refID]))

//Click on ? approve permanently for others
'suser: Click on ? approve permanently for others - supplier'
functions.I.Approvepermanentlyforothers('//*[@id="level_apl_1"]/div[2]/div[4]/div/div', '//*[@id="level_apl_1"]/div[2]/div[4]/div/div/div[6]/a[2]/span')

WebUI.delay(1)

//APPROVE FOR OTHERS - PART 2
/*'199 Click on ref link'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.02 suser id_source_refID__td4_a1', [('refID') : 'source_' + 
            refID]))
*/
'suser: Click on ? approve for others - Buyer'
functions.I.Approveforothers('//*[@id="level_apl_1"]/div[2]/div[2]/div/div/div[1]/img', '//*[@id="level_apl_1"]/div[2]/div[2]/div/div/div[6]/a[2]/span')

WebUI.delay(1)

//APPROVE FOR OTHERS - PART 3
/*'Click on ref link'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.02 suser id_source_refID__td4_a1', [('refID') : 'source_' + 
            refID]))
*/
'suser: Click on ? approve for others'
functions.I.Approveforothers('//*[@id="level_apl_2"]/div[2]/div[2]/div/div', '//*[@id="level_apl_2"]/div[2]/div[2]/div/div/div[6]/a[2]/span')

WebUI.delay(1)

'logout as suser'
functions.I.Logout()

// Anna Gluszczynska
'Login as Anna Gluszczynska'
functions.I.Login_password('agluszczynska', password_agluszczynska)

'Screenshot: Log s Anna Gluszczynska'
WebUI.takeScreenshot()

'Click on the LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'agency 2 click on submit'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2', [('refID') : 'ancre_' + 
            refID_PS]))

functions.I.UploadDoc_sendkey_field('//*[@id="var_25"]', 'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1')

'agency 2 click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

'logout as Ana Agency 2r'
functions.I.Logout()

//aherms
'Login as aherms'
functions.I.Login_password('aherms', password_aherms)

'Screenshot: Log as Anna Gluszczynska'
WebUI.takeScreenshot()

'Click on the LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Click on upload doc'
String color3 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2', 
        [('refID') : 'ancre_' + refID_PS]), 'color', FailureHandling.OPTIONAL)

while (color3 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2', [('refID') : 'ancre_' + 
                refID_PS]))

    'Supplier Upload doc for production phase'
    WebUI.takeScreenshot()

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdataaddition1.jpg', 'testdataaddition1.jpg')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    functions.I.click_button_javascript(findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2', 
            [('refID') : 'ancre_' + refID_PS]), 10, FailureHandling.OPTIONAL)) {
        color3 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2', 
                [('refID') : 'ancre_' + refID_PS]), 'color', FailureHandling.OPTIONAL)
    } else {
        color3 = 'white'
    }
}

'logout as Anna Gluszczynska'
functions.I.Logout()

//ANAISABEL TERRÉSHERNÁNDEZ
'Login as aterreshernandez'
functions.I.Login_password('aterreshernandez', password_aterreshernandez)

'Screenshot :Login as ANAISABEL TERRÉSHERNÁNDEZ'
WebUI.takeScreenshot()

'Click on the LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[7]/button']))

'Ana clicks on review button'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2', [('refID') : 'ancre_' + 
            refID_PS]))

WebUI.delay(3)

'228 Approve doc'
functions.I.AWF_approve_view()

'logout as ANAISABEL TERRÉSHERNÁNDEZ'
functions.I.Logout()

//aherms
'Login as aherms'
functions.I.Login_password('aherms', password_aherms)

'Screenshot: Log as Anna Gluszczynska'
WebUI.takeScreenshot()

'Click on the LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Ana clicks on next phase'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2', [('refID') : 'ancre_' + 
            refID_PS]))

'Ana input text in field: Número de seguimiento del envío de la muestra de packagingmandatory'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_48']), 'Número de seguimiento del envío de la muestra de packagingmandatory')

'Ana click on next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

'logout as Anna Gluszczynska'
functions.I.Logout()

//ANAISABEL TERRÉSHERNÁNDEZ
'Login as ANAISABEL TERRÉSHERNÁNDEZ '
functions.I.Login_password('aterreshernandez', password_aterreshernandez)

'Screenshot :Login as ANAISABEL TERRÉSHERNÁNDEZ'
WebUI.takeScreenshot()

'Click on the LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[7]/button']))

'ANAISABEL TERRÉSHERNÁNDEZ clicks on next phase'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2', [('refID') : 'ancre_' + 
            refID_PS]))

'Verify if status is complete for the mother ref'
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[7]/span']), 
    'Completado')

'Screenshot : Mother Ref completed'
WebUI.takeScreenshot()

'Close Browser'
WebUI.closeBrowser()

