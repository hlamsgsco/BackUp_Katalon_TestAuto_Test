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

//DATA FILE USERNAME_PASSWORD [TAG]
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')
String password_jedun = data_Tag.getValue(3, 1)

String password_rrowland = data_Tag.getValue(3, 2)

String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 5)

String password_mderdour = data_Tag.getValue(3, 6)

String password_achatin = data_Tag.getValue(3, 7)

String password_tliu = data_Tag.getValue(3, 8)

String password_ccaramella = data_Tag.getValue(3, 9)

String password_achay = data_Tag.getValue(3, 10)

String password_cbono = data_Tag.getValue(3, 11)

String password_pmareri = data_Tag.getValue(3, 12)


//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)

/* SCENARIO TESTED
SCENARIO 1: Error message 'couldnt find sheet name' 
SCENARIO 2: CREATION OF MOTHER REF BY IMPORT 
Scenario 3: UPDATE MOTHER REF BY IMPORT
 */
//CLEAR ALL THE NOTEPAD USED
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_refID1.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_refID2.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_refID3.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//////////////////////////// LOGIN AS JEDUN  ///////////////////////////////////
'Log in as jedun'
functions.I.Login_password('jedun', password_jedun)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

WebUI.delay(1)

//CREATION AND MODIFICATION OF PROJECT
'Click on + to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

WebUI.delay(1)

'Select Project template '
functions.I.SelectFromList_Value('//*[@id="project_template"]', '11')


'Screenshot: creation project page'
WebUI.takeScreenshot()

'Click on create the project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(5)

'Screenshot: Project modif page'
WebUI.takeScreenshot()

def project_name = (('AutoTest_Chrome_ImportRef1_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)) + 
'_') + functions.I.gettimedate()

'Project name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_141"]']), project_name)

'Project type: RENOVATION'
functions.I.SelectFromList_Value('//*[@id="var_12"]', '1026')


'Domain'
functions.I.SelectFromList_Value('//*[@id="var_116"]', '1070')


'Development zone Required'
functions.I.SelectFromList_Value('//*[@id="var_262"]', '16352')


'PAD: 10/10/2030'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_14"]']), '10/10/2030')

'Division:ACD '
functions.I.SelectFromList_Value('//*[@id="var_15"]', '19')




'42 Signature: ACD Non reparti'
functions.I.SelectFromList_Value('//*[@id="var_16"]', '716')



'Franchise: ACD Non reparti'
functions.I.SelectFromList_Value('//*[@id="var_17"]', '14518')



'Brand: ACD Non reparti'
functions.I.SelectFromList_Value('//*[@id="var_18"]', '14541')



'SubBrand: ACD Non reparti'
functions.I.SelectFromList_Value('//*[@id="var_19"]', '14886')



'Axis: Fragrance'
functions.I.SelectFromList_Value('//*[@id="var_20"]', '3773')




'SubAxis: Men Fragrance'
functions.I.SelectFromList_Value('//*[@id="var_21"]', '246')




'Metier: Men Fragrance'
functions.I.SelectFromList_Value('//*[@id="var_22"]', '3854')


'DMI Contacts'
functions.I.select_multiplelist('//*[@id="selSource_23"]', '//*[@id="btnAdd_23"]', 'cbono')

WebUI.delay(2)

'C&A Contacts'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'alanglois')

String Project_No = functions.I.ProjectNo()

'Click on Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button/i']))

WebUI.delay(10)
//REF LIST PAGE
'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on + to import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Screenshot: selection of option'
WebUI.takeScreenshot()

'Click on option import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[2]']))

WebUI.delay(2)

//IMPORT REF PAGE
'Import ref page'
WebUI.takeScreenshot()

// SCEANARIO 1 : Error Msg 1 : There is no sheet
'Select import ref template: Import several Technical artwork briefs'
functions.I.SelectFromList_Value('//*[@id="import_tpl"]', '6')


functions.I.SelectFromList_Value('//*[@id="lfc_tpl"]', '29')

functions.I.UploadDoc_sendkey_field('//*[@id="xml_file"]', 'D:\\Upoad_File\\AUTOMATION Import ref template TAG\\A14.01 Import template.xlsx', 
    '')

WebUI.verifyTextNotPresent('Aucun fichier choisi', false)

'Import ref page: file uploaded'
WebUI.takeScreenshot()

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[1]']))

functions.I.Pagedown()

'Import ref page: Error msg is displayed'
WebUI.takeScreenshot()

String text1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_error"]']))

functions.I.print(text1)

WebUI.verifyMatch(text1, ('CHECK FILE RESULT : ERROR' + '\n') + '   Couldn\'t find the sheet "AC TEC Template_CPD" in the excel file.', 
    false)

'Verify that the import button is Not present'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

//CANCEL
'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/a']))

WebUI.delay(1)

'Ref list page '
WebUI.takeScreenshot()

'Click on + to import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click on option import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[2]']))

WebUI.delay(2)

'Import ref page'
WebUI.takeScreenshot()

//S
'Select import ref template: Import several Technical artwork briefs'
functions.I.SelectFromList_Value('//*[@id="import_tpl"]', '7')

'Upload file for import'
functions.I.UploadDoc_sendkey_field('//*[@id="xml_file"]', 'D:\\Upoad_File\\AUTOMATION Import ref template TAG\\A14.01 Import template.xlsx', 
    '')

WebUI.verifyTextNotPresent('Aucun fichier choisi', false)

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on check file'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[1]']))

'Screenshot'
WebUI.takeScreenshot()

functions.I.Pagedown()

'Screenshot'
WebUI.takeScreenshot()

'Verify that the message is displayed correctly'
String text2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_title_create"]']))

WebUI.verifyMatch(text2, ' 3 REFERENCES WILL BE CREATED', false)

String text3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_message_create"]/div']))

functions.I.print(text3)

String Expected_text3 = ((((((((('XML Node 1 :' + '\n') + '  Reference "FOREIGN_KEY_3" will be created') + '\n\n') + 'XML Node 2 :') + 
'\n') + '  Reference "FOREIGN_KEY_2" will be created') + '\n\n') + 'XML Node 3 :') + '\n') + '  Reference "FOREIGN_KEY_1" will be created'

WebUI.verifyMatch(text3, Expected_text3, false)

'Verify that the import button is present'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

'Click on import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

WebUI.delay(2)

'Screenshot:Ref List page'
WebUI.takeScreenshot()

////*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1
'Verify that the counter has increased by 3'
String A_Refcounter1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1']))

functions.I.print(A_Refcounter1)

WebUI.verifyMatch(A_Refcounter1, ' References List (3)', false)

WebUI.takeScreenshot()

////////////////////////////////////////////////////REFERENCE 1
'117 Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[6]/a']))

WebUI.delay(1)

WebUI.takeScreenshot()

String refID1 = functions.I.RefID_tag()

functions.I.print(refID1)

WebUI.delay(1)

'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//1 Reference informations
'124 PRODUCT CATEGORY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[3]/div', 
    'Gift')

'PACKAGING FAMILY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[4]/div', 
    'Carton')

'126 PACKAGING TYPE'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[5]/div', 
    'Tertiary')

'CAPACITY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[6]/div', 
    '500')

'CAPACITY OTHER'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[8]/div', 
    '')

'CAPACITY UNIT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[7]/div', 
    'ML')

'ACI CODE TO PRINT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[9]/div', 
    '200318855')

'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//Artwork informations
'INTERNATIONAL ARTWORK AGENCY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div', 
    'Diadeis')

'C&A BRIEF'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div', 
    'C&A BRIEF')

'PRINTING TECHNOLOGY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[10]/div', 
    ('Digital' + '\n') + 'Silk Screen')

'LIST OF COLORS'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[11]/div', 
    'pink')

'NUMBER OF COLORS'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[12]/div', 
    '4')

'FINITION'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[13]/div', 
    ('Iriodin' + '\n') + 'Soft Touch')

'GTIN CODE TO PRINT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[15]/div', 
    'No')

'ACG CODE (OR RELATED)'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[16]/div', 
    'No')

functions.I.Pagedown()

'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//CContact informations
'REPRO AGENCY NAME'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div', 
    'Diadeis')

'PRINTER (SUPPLIER)'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[2]/div', 
    '00002025 - ORLANDO ANTONIO TRASPORTI S.N.C.')

'SUPPLIER RANK 2'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[3]/div', 
    '00000007 - ROMATIC MANUFACTURING COMPANY THE')

'PLANT NAME'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[4]/div', 
    'Burgos')

'Click on the fils dariane'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

//////////////////////////////////////////REFERENCE 2
////*[@id="fiches"]/table/tbody/tr[2]/td[6]/a/span
'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[6]/a']))

WebUI.delay(1)

WebUI.takeScreenshot()

String refID2 = functions.I.RefID_tag()

functions.I.print(refID2)

WebUI.delay(1)

'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//1 Reference informations
'124 PRODUCT CATEGORY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[3]/div', 
    'Gift')

'PACKAGING FAMILY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[4]/div', 
    'Carton')

'126 PACKAGING TYPE'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[5]/div', 
    'Tertiary')

'CAPACITY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[6]/div', 
    '500')

'CAPACITY OTHER'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[8]/div', 
    '')

'CAPACITY UNIT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[7]/div', 
    'ML')

'ACI CODE TO PRINT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[9]/div', 
    '200318855')

'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//Artwork informations
'INTERNATIONAL ARTWORK AGENCY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div', 
    'Diadeis')

'C&A BRIEF'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div', 
    'C&A BRIEF')

'PRINTING TECHNOLOGY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[10]/div', 
    ('Digital' + '\n') + 'Silk Screen')

'LIST OF COLORS'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[11]/div', 
    'pink')

'NUMBER OF COLORS'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[12]/div', 
    '4')

'FINITION'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[13]/div', 
    ('Iriodin' + '\n') + 'Soft Touch')

'GTIN CODE TO PRINT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[15]/div', 
    'No')

'ACG CODE (OR RELATED)'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[16]/div', 
    'No')

functions.I.Pagedown()

'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//CContact informations
'REPRO AGENCY NAME'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div', 
    'Diadeis')

'PRINTER (SUPPLIER)'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[2]/div', 
    '00002025 - ORLANDO ANTONIO TRASPORTI S.N.C.')

'SUPPLIER RANK 2'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[3]/div', 
    '00000007 - ROMATIC MANUFACTURING COMPANY THE')

'PLANT NAME'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[4]/div', 
    'Burgos')

'Click on the fils dariane'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

//////////////////////////////////////////REFERENCE 3
////*[@id="fiches"]/table/tbody/tr[2]/td[6]/a/span
'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[6]/a']))

WebUI.delay(1)

WebUI.takeScreenshot()

String refID3 = functions.I.RefID_tag()

functions.I.print(refID3)

WebUI.delay(1)

////////////////////////////////////////////notepad////////////////////
////////////////////////////notepad
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_ProjectNo.txt', Project_No)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_refID1.txt', refID1)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_refID2.txt', refID2)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_refID3.txt', refID3)

/////////////////////////////////////////////
'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//1 Reference informations
'124 PRODUCT CATEGORY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[3]/div', 
    'Gift')

'PACKAGING FAMILY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[4]/div', 
    'Carton')

'126 PACKAGING TYPE'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[5]/div', 
    'Tertiary')

'CAPACITY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[6]/div', 
    '500')

'CAPACITY OTHER'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[8]/div', 
    '')

'CAPACITY UNIT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[7]/div', 
    'ML')

'ACI CODE TO PRINT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[9]/div', 
    '200318855')

'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//Artwork informations
'INTERNATIONAL ARTWORK AGENCY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div', 
    'Diadeis')

'C&A BRIEF'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div', 
    'C&A BRIEF')

'PRINTING TECHNOLOGY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[10]/div', 
    ('Digital' + '\n') + 'Silk Screen')

'LIST OF COLORS'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[11]/div', 
    'pink')

'NUMBER OF COLORS'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[12]/div', 
    '4')

'FINITION'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[13]/div', 
    ('Iriodin' + '\n') + 'Soft Touch')

'GTIN CODE TO PRINT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[15]/div', 
    'No')

'ACG CODE (OR RELATED)'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[16]/div', 
    'No')

functions.I.Pagedown()

'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//CContact informations
'REPRO AGENCY NAME'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div', 
    'Diadeis')

'PRINTER (SUPPLIER)'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[2]/div', 
    '00002025 - ORLANDO ANTONIO TRASPORTI S.N.C.')

'SUPPLIER RANK 2'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[3]/div', 
    '00000007 - ROMATIC MANUFACTURING COMPANY THE')

'PLANT NAME'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[4]/div', 
    'Burgos')

'Click on the fils dariane'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

///////////////////////////////////////////COMPLETE A REF 
WebUI.delay(1)

'Screenshot: Ref List page'
WebUI.takeScreenshot()

////*[@id="ancre_24449"]/a[3]
'1. Ref List page: Submit a phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="ancre_' + refID3) + '"]/a[3]']))

'214. Modif page: proceed to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify that lifecycle status us complete'
functions.I.VerifyMatchText(('//*[@id="source_' + refID1) + '"]/td[11]/span', 'Complete')

//////////////////////////////////////////////UPDATE A MOTHER REF
'Click on + to import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

WebUI.takeScreenshot()

'Click on option import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[2]']))

WebUI.delay(2)

/////////////////////////////////////////PART 2  1UPDATE///////////////////////////////////////////////
'Select import ref template: Import several Technical artwork briefs'
functions.I.SelectFromList_Value('//*[@id="import_tpl"]', '7')

'Upload file for import'
functions.I.UploadDoc_sendkey_field('//*[@id="xml_file"]', 'D:\\Upoad_File\\AUTOMATION Import ref template TAG\\B14.01 Import template.xlsx', 
    '')

WebUI.verifyTextNotPresent('Aucun fichier choisi', false)

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on check file'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[1]']))

WebUI.delay(1)

'Screenshot'
WebUI.takeScreenshot()

functions.I.Pagedown()

'Screenshot'
WebUI.takeScreenshot()

'Verify that the message is displayed correctly'
String texxt = ((((((((((((((((((((((('XML Node 1 (Marketing product name : FOREIGN_KEY_3) :' + '\n') + '1 Reference will be updated :') + 
'\n') + '  ') + Project_No) + ' - FOREIGN_KEY_3_Gift_Carton_500ML') + '\n') + '\n') + 'XML Node 2 (Marketing product name : FOREIGN_KEY_2) :') + 
'\n') + '1 Reference will be updated :') + '\n') + '  ') + Project_No) + ' - FOREIGN_KEY_2') + '\n') + '\n') + 'XML Node 3 (Marketing product name : FOREIGN_KEY_1) :') + 
'\n') + '1 Reference will be updated :') + '\n') + '  ') + Project_No) + ' - FOREIGN_KEY_1'

functions.I.print('Expected' + texxt)

functions.I.print('Actual' + WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_message_update"]'])))

'236'
functions.I.VerifyMatchText('//*[@id="control_message_update"]', texxt)

////////////////////////////VRIFY THAT EXPAND & COLLAPSE OF REF LIST PAGE//////////////////////////
//////COLLAPSE
WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_update"]/div[1]/div[2]/a']))

WebUI.delay(1)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_update"]/div[2]']), 
    FailureHandling.STOP_ON_FAILURE)

'Screenshot: Collapse'
WebUI.takeScreenshot()

//////EXPAND
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_update"]/div[1]/div[2]/a']))

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_update"]/div[2]']), 
    FailureHandling.STOP_ON_FAILURE)

'Screenshot: Expand'
WebUI.takeScreenshot()

'Click on import'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

////////////////////////////////////////////////////REFERENCE 2
////*[@id="source_24454"]/td[6]/a
'246 Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID2) + '"]/td[6]/a']))

WebUI.delay(1)

WebUI.takeScreenshot()

WebUI.delay(1)

'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//1 Reference informations
'251 PRODUCT CATEGORY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[3]/div', 
    'FG')

'PACKAGING FAMILY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[4]/div', 
    'Carton')

'126 PACKAGING TYPE'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[5]/div', 
    'Secondary')

'CAPACITY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[6]/div', 
    '500')

'CAPACITY OTHER'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[8]/div', 
    '500 ML')

'CAPACITY UNIT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[7]/div', 
    'OZ')

'ACI CODE TO PRINT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[9]/div', 
    '200013482')

'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//Artwork informations
'INTERNATIONAL ARTWORK AGENCY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div', 
    'Diadeis')

'C&A BRIEF'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div', 
    'C&A BRIEF (Modif)')

'PRINTING TECHNOLOGY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[10]/div', 
    'Dry Offset')

'LIST OF COLORS'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[11]/div', 
    'Yellow')

'NUMBER OF COLORS'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[12]/div', 
    '100')

'FINITION'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[13]/div', 
    ('Glossy' + '\n') + 'Matt')

'GTIN CODE TO PRINT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[15]/div', 
    'Yes')

'ACG CODE (OR RELATED)'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[16]/div', 
    'Yes')

functions.I.Pagedown()

'Screenshot: Ref > View phase'
WebUI.takeScreenshot()

//CContact informations
'REPRO AGENCY NAME'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div', 
    'Diadeis')

'PRINTER (SUPPLIER)'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[2]/div', 
    '00000073 - CRYSTAL INTERNATIONAL | CAN, Toronto')

'SUPPLIER RANK 2'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[3]/div', 
    '00002399 - SEUFERT TRANSPARENT VERPACKUNGEN | DEU, Rodgau')

'PLANT NAME'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[4]/div', 
    'Burgos')

WebUI.closeBrowser()

