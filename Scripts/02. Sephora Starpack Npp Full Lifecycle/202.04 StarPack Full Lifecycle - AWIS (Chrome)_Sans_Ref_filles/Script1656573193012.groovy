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

String password_kcannoosamy_dia = data.getValue(2, 8)

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

///////////////////////////////////////////////////////////////
//Keyword log
KeywordLogger log = new KeywordLogger()

/*
String Project_No = 'MI000416'
String refID = '4917'
*/
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Test'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

String password_adelamatanieves = data.getValue(2, 7)

//try {
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
def project_name0 = (('TC4.02_AutoTest_Chrome_Starpack_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(
    10)) + '_') + functions.I.gettimedate()

// def project_name = (('AutoTest_Chrome_Starpack_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(210)) +   '_') + functions.I.gettimedate()
//NAME THE PROJECT
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name0)

//CLICK ON CREATE PROJECT
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

WebUI.delay(1)

'Screenshot: Modify project page'
WebUI.takeScreenshot()

'Select from list Enseña: Dia'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_98']), '122', false)

WebUI.delay(2)

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

WebUI.delay(5)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(2)

//END OF MODIFY PROJECT PAGE
// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()

WebUI.delay(2)

//CREATE REFERENCE
'39'
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

'Ref List page: Ana click on proceed to next phase (1)'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[3]']))

//*[@id="ModifFiche"]/div[1]/div/button[2]
//*[@id="ModifFiche"]/div['${id}']/div/button[2]
'Ana submit next phase on ref page (1)'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.031 RefPg_AnnaSubmit', [('id') : '1']))

'Ana submit next phase on ref LIST page (2) '
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.03 Block anna'))

//To generate daughter ref PTS -NO
//*[@id="card_phase_group_2464_ModifFiche"]/div[2]/div[1]/div/div/label[2]
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.041 Field daughter (NO)', 
        [('id') : '1']))

//To generate daughter ref Sample
//*[@id="card_phase_group_2464_ModifFiche"]/div[2]/div[2]/div/div/label[2]
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.041 Field daughter (NO)', 
        [('id') : '2']))

//To generate daughter ref GTD
//*[@id="card_phase_group_2464_ModifFiche"]/div[2]/div[3]/div/div/label[2]
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.041 Field daughter (NO)', 
        [('id') : '3']))

//Scroll down
functions.I.Pagedown()

//Submit to next phase
'Ana submit next phase Ref Pg(2)'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.05 RefPg_submit'))

WebUI.delay(2)

'Screenshot: Reference list page > Automatic creation of 3 daughter ref PTS /Product Sample/Technical Drawing '
WebUI.takeScreenshot()

//*[@id="block_20210501-123721-359-FKRFDGGII5"]/td[10]/a[2]
'Agency click on upload button'
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[2]']), 
    'color', FailureHandling.OPTIONAL)

functions.I.print(color1)

////*[@id='${refID}']/td[9]/a[2]
////*[@id="source_5282"]/td[9]/a[2]
////*[@id="source_5282"]/td[8]/a
////*[@id="source_5286"]/td[9]/a
//*[@id="source_5290"]/td[9]/a[2]
while (color1 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[2]']))

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

    if (WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[2]']), 
        10, FailureHandling.OPTIONAL)) {
        color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[2]']), 
            'color', FailureHandling.OPTIONAL //*[@id="source_5294"]/td[8]/a
            )
    } else {
        color1 = 'white'
    }
}

/* WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[2]']))

    //Agency upload doc for production phase
    'Agency upload doc for production phase '
    functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('1. Constant/xpath', 
            [('xpath') : '//*[@id="dropZoneinit"]']))

    'Agency click on next phase'
    functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))
*/
'Logout as Agency'
functions.I.Logout()

//ANAISABEL TERRÉSHERNÁNDEZ
'Login as ANAISABEL TERRÉSHERNÁNDEZ '
functions.I.Login_password('aterreshernandez', password_aterreshernandez)

'Screenshot :Login as ANAISABEL TERRÉSHERNÁNDEZ'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[7]/button']))

//////////////////FOR MOTHER REF
//Click on review button(eye)
//*[@id="ancre_4906"]/a[2] > //*[@id="${refID}"]/a[2]
'Anaisabel click on the review button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[2]']))

WebUI.delay(2)

//functions.I.AWF_approve()
'87'
functions.I.AWF_approve_view()

'Logout as Anais'
functions.I.Logout()

//Log in as aherms
'Login as aherms'
functions.I.Login_password('aherms', password_aherms)

'Screenshot: Log as Anna Gluszczynska'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//*[@id="source_4916"]/td[8]/a
'Anaisabel click on the review button'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.07 Agency1 id_refID_td8', [('refID') : 'source_' + 
            refID]))

//functions.I.AWF_approve()
WebUI.waitForPageLoad(5)

WebUI.mouseOver(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))

WebUI.delay(1)

WebUI.click(findTestObject('HL Full Lifecycle/Function_AppButton'))

WebUI.delay(1)

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="approvePermButton"]']))

WebUI.delay(1)

'Logout as aherms'
functions.I.Logout()

//LOG IN AS password_amartin_arbol	 ~ dchi
'Log in as Packaging_1: adelamatanieves/ dchi'
functions.I.Login_password('amartin_arbol', password_amartin_arbol)

'Screenshot: Log as amartin_arbol'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//CLICKS ON REVIEW BUTTON
//*[@id="source_4916"]/td[9]/a[2]
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.04 Agency1 id_refID_td9_a2', [('refID') : 'source_' + 
            refID]))

functions.I.AWF_approve_view()

'Logout as amartin_arbol'
functions.I.Logout()

//ANAISABEL TERRÉSHERNÁNDEZ
'Login as ANAISABEL TERRÉSHERNÁNDEZ '
functions.I.Login_password('aterreshernandez', password_aterreshernandez)

WebUI.delay(3)

//CLICK ON THE SIDE MENU: PROJECTS
'116'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[7]/button']))

//////////////////FOR MOTHER REF
//Click on review button(eye)
/// /html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[2]
'Anaisabel click on the review button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[2]']))

WebUI.delay(3)

//functions.I.AWF_approve()
'118'
functions.I.AWF_approve_view()

'Logout as aterreshernandez'
functions.I.Logout()

//Log in as Anna Gluszczynska
'Login as Anna Gluszczynska'
functions.I.Login_password('agluszczynska', password_agluszczynska)

'Screenshot: Log s Anna Gluszczynska'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//*[@id="source_4916"]/td[9]/a[2]
'clicks on submit button'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.04 Agency1 id_refID_td9_a2', [('refID') : 'source_' + 
            refID]))

//agency2 upload doc
//Object Repository/StarPack - Full Lifecycle (AWIS)/1.0 ModifyProPage_List(Ensena)
//*[@id="card_phase_group_1238_ModifFiche"]/div[2]/div/div/label
// functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('1. Constant/xpath', 
//  [('xpath') : '//*[@id="card_phase_group_1238_ModifFiche"]/div[2]/div/div/label']))
functions.I.UploadDoc_sendkey_field('//*[@id="var_25"]', 'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1')

//agency 2 click on submit
//*[@id="ModifFiche"]/div[3]/div/button[2]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

//Logout as Anna
'logout '
functions.I.Logout()

//Log in as aherms
'Login as aherms'
functions.I.Login_password('aherms', password_aherms)

'Screenshot: Log as Anna Gluszczynska'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//Click on upload doc
//*[@id="source_4916"]/td[9]/a[2]
'Aherm click on upload button'
String color2 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.04 Agency1 id_refID_td9_a2', 
        [('refID') : 'source_' + refID]), 'color', FailureHandling.OPTIONAL)

functions.I.print(color2)

while (color2 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.04 Agency1 id_refID_td9_a2', [('refID') : 'source_' + 
                refID]))

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

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.04 Agency1 id_refID_td9_a2', 
            [('refID') : 'source_' + refID]), 10, FailureHandling.OPTIONAL)) {
        color2 = WebUI.getCSSValue(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.04 Agency1 id_refID_td9_a2', 
                [('refID') : 'source_' + refID]), 'color', FailureHandling.OPTIONAL)
    } else {
        color2 = 'white'
    }
}

//Logout as Anna Gluszczynska
'logout as Anna Gluszczynska'
functions.I.Logout()

// LOG IN AS ANAISABEL TERRÉSHERNÁNDEZ
'Login as aterreshernandez\t'
functions.I.Login_password('aterreshernandez', password_aterreshernandez)

'Screenshot :Login as ANAISABEL TERRÉSHERNÁNDEZ'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[7]/button']))

//CLICK ON REVIEW BUTTON
//*[@id="ancre_4906"]/a[2]
'Ana clicks on review button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[2]']))

//functions.I.AWF_approve()
functions.I.AWF_approve_view()

//Logout as ANAISABEL TERRÉSHERNÁNDEZ
'logout as ANAISABEL TERRÉSHERNÁNDEZ'
functions.I.Logout()

//Log in as aherms
'Login as aherms'
functions.I.Login_password('aherms', password_aherms)

'Screenshot: Log as Anna Gluszczynska'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON NEXT PHASE
'Ana clicks on next phase'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.04 Agency1 id_refID_td9_a2', [('refID') : 'source_' + 
            refID]))

//Input text
//*[@id="var_48"]
'Ana input text in field: Número de seguimiento del envío de la muestra de packagingmandatory'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_48']), 'Número de seguimiento del envío de la muestra de packagingmandatory')

//Click on next phase
//*[@id="ModifFiche"]/div[3]/div/button[2]
'Ana click on next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

//Logout as Anna Gluszczynska
'logout as Anna Gluszczynska'
functions.I.Logout()

//ANAISABEL TERRÉSHERNÁNDEZ
'Login as ANAISABEL TERRÉSHERNÁNDEZ '
functions.I.Login_password('aterreshernandez', password_aterreshernandez)

'Screenshot :Login as ANAISABEL TERRÉSHERNÁNDEZ'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[7]/button']))

//CLICK ON NEXT PHASE
/// /html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[2]
'ANAISABEL TERRÉSHERNÁNDEZ clicks on next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[2]']))

'Verify if status is complete for the mother ref'
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[7]/span']), 
    'Completado')

'Screenshot : Mother Ref completed'
WebUI.takeScreenshot()

WebUI.closeBrowser()

