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

//POST CONDITION L mdelrio should not have deletegate 
def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

String password_suser = data.getValue(2, 1)

String password_aherms = data.getValue(2, 2)

String password_agluszczynska = data.getValue(2, 3)

String password_jmaciaszczyk = data.getValue(2, 4)

String password_aterreshernandez = data.getValue(2, 5)

String password_amartin_arbol = data.getValue(2, 6)

String password_adelamatanieves = data.getValue(2, 7)

String password_kcannoosamy_dia = data.getValue(2, 8)

String password_jmarest = data.getValue(2, 9)

String password_jmartinez_almarza = data.getValue(2, 10)

String password_dcrow = data.getValue(2, 11)

String password_ncurnier = data.getValue(2, 12)

String password_mdelrio = data.getValue(2, 13)

String password_1packaging2 = data.getValue(2, 14)

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Test'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

functions.I.Login_password('mdelrio', password_mdelrio)

'Click on menu'
functions.I.Go_to_MyProfile()

'Add delegate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_add_delegation"]']))

WebUI.delay(3)

'From'
functions.I.Delegate_Select_date_PreviousMonth('//*[@id="delegation_start_date_new1"]')

WebUI.delay(3)

'To'
functions.I.Delegate_Select_date_NextMonth('//*[@id="delegation_end_date_new1"]')

WebUI.delay(3)

//1packaging1
'Select user'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegation_select_user_new1"]']), '1packaging2', 
    false, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

functions.I.Logout()

'Log in as Packaging2:'
functions.I.Login_password('1packaging2', password_1packaging2)

'Screenshot: Log'
WebUI.takeScreenshot()

WebUI.delay(1)

'Continue accounts'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_delegations"]/div/div/div[3]/button']))

'Click menu'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

WebUI.delay(1)

'Click profile'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]']))

WebUI.delay(1)

functions.I.Pagedown()

WebUI.delay(1)

'Click chekbox'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[4]/table/tbody/tr/td[3]/label']))

WebUI.delay(1)

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[4]')

'Log in as Packaging_1: adelamatanieves/ dchi'
functions.I.Login_password('adelamatanieves', password_adelamatanieves)

'Screenshot: Log as adelamatanieves'
WebUI.takeScreenshot()

WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Packaging_1: Click on + icon to create project '
WebUI.click(findTestObject('xxx Todelete/3 ProjectListPage_Create_Project_Button'))

'Screenshot: Creation project page'
WebUI.takeScreenshot()

//DEFINE PROJECT NAME - 255
def project_name0 = (('AutoTest_Chrome_Starpack_OutOfOffice' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(
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

WebUI.delay(1)

'Screenshot: Modify project page - completed'
WebUI.takeScreenshot()

WebUI.delay(5)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(2)

//END OF MODIFY PROJECT PAGE
// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()

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
WebUI.delay(2)
//CLICK ON CREATE REF BUTTON
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))
WebUI.delay(2)

//GET THE ID OF THE REF
String refID = functions.I.RefID()



'Screenshot: Modification Reference Page'
WebUI.takeScreenshot()

'Input text code: 209293'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_28']), '209293')

'Input Vínculo con boceto: test Submarca'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_30']), 'test Submarca')

'Input Vínculo con bulto: test Submarca'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_31']), 'test Submarca Vínculo con bulto: test Submarca')

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

'Click on reflink'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[4]/a']))

WebUI.delay(1)

'Click on lifecyle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

functions.I.Pagedown()

WebUI.delay(2)

'102 Verify if the user name is -Mónica DelRio'
int i = 1

while (i <= 8) {
    ///html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div/div[3]
    ///html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[2]/div[2]/div[8]/div/div[3]
    String name = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[2]/div[2]/div[' + 
                i) + ']/div/div[3]']))

    if (name == 'Mónica DelRio') {
        '100 Verify icon'
        WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[2]/div[2]/div[' + 
                    i) + ']/div/div[1]/div/i']))

        '102Mouseover icon'
        WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[2]/div[2]/div[' + 
                    i) + ']/div/div[1]/div/i']))

        WebUI.delay(1)

        ///html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[2]/div[2]/div[8]/div/div[1]/div/div
        String tooltip1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[2]/div[2]/div[' + 
                    i) + ']/div/div[1]/div/div']))

        functions.I.print(tooltip1)

        WebUI.verifyMatch(tooltip1, ('Ausente de oficina' + '\n\n') + 'Tareas delegadas a : 1packaging2', false)

        i = 9
    } else {
        i = (i + 1)
    }
}

'Logout'
functions.I.Logout()

functions.I.Login_password('mdelrio', password_mdelrio)

'Screenshot: Log in'
WebUI.takeScreenshot()

'Click on menu'
functions.I.Go_to_MyProfile()

functions.I.Pagedown()

'Click on delete icon'
functions.I.click_button_javascriptS('/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/form/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[6]/button[1]')

WebUI.delay(1)

'Click on Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

WebUI.delay(1)

WebUI.closeBrowser()

