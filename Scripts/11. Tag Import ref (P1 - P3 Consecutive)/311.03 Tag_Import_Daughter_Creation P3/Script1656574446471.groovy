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

//DATA FIELD USERNAME_PASSWORD (TAG)
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

String password_alanglois = data_Tag.getValue(3, 14)


//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)
/* SCENARIOS TESTED
SCENARIO 7: CREATION OF DAUGHTER REF & MSG 'The reference will be linked to the reference “%name of the mother ref%”' IS DISPALYED
SCEANRIO 7B: CREATION OF DAUGHTER REF ON COMPLETED MOTHER

SCENARIO 8: IF THE DAUGHTER REF IS ALREADY LINKED TO THE A MOTHER REF, 'The reference is already linked to another reference' IS DISPAYED XXX BUG Not yet done

SCENARIO 9: UPDATE OF DAUGHTER REF
*/
//READ DATA FROM PREVIOUS NOTEPAD
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_ProjectNo.txt')

String refID1 = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_refID1.txt')

String refID2 = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_refID2.txt')

String refID3 = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\311.01 Tag_Project_No\\311.01_Tag_refID3.txt')


///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//LOGIN AS JEDUN
'Log in as jedun'
functions.I.Login_password('jedun', password_jedun)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

'Screenshot: Ref list page of Project MI002234'
WebUI.takeScreenshot()

WebUI.delay(1)

//REF LIST PAGE
'Screenshot: ref list page'
WebUI.takeScreenshot()

//CHANGE THE MOTHER KEY FIELD - ref 1
'Search for the ref 1 > FOREIGN_KEY_1\t'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords11"]']), 
    'FOREIGN_KEY_1')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[5]/button']))

' Super edit ref 1'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID3) + '"]/td[15]/div[2]/button']), findTestObject('1. Constant/xpath', 
        [('xpath') : ('//*[@id="source_' + refID3) + '"]/td[15]/div[2]/div/a[4]']))

'Change the mother FK - 210013482'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), 
    5)

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), 
    '210013482')

functions.I.Pagedown()

'Click update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

//CHANGE THE MOTHER KEY FIELD - ref 3
'Search for the ref 1 > FOREIGN_KEY 3\t'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords11"]']), 
    'FOREIGN_KEY_3')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[5]/button']))

'Super edit ref 3'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID1) + '"]/td[15]/div[2]/button']), findTestObject('1. Constant/xpath', 
        [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/div[2]/div/a[3]']))

'Change the mother FK- 220013482'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), 
    5)

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), 
    '230013482')

functions.I.Pagedown()

'Click update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

'Click on rest'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[5]/a[2]']))

'Veify the no of ref in the project = 3'
String Atcual_Ref_total_3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span']))

WebUI.verifyMatch(Atcual_Ref_total_3, '3', false)

'Logout as jedun'
functions.I.Logout()

//Log inas Audrey alanglois
'Screenshot: Login page'
WebUI.takeScreenshot()

'Login as C&A -  Audrey Langlois'
functions.I.Login_password('alanglois', password_alanglois)

'Click on Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

'Screenshot: Ref list page of Projec'
WebUI.takeScreenshot()

WebUI.delay(1)

//REF LIST PAGE
'Screenshot: ref list page'
WebUI.takeScreenshot()

//SCENARIO 7: CREATION OF DAUGHTER REF & MSG 'The reference will be linked to the reference “%name of the mother ref%”' IS DISPALYED
'Click on + to import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Screenshot: Selection of import page'
WebUI.takeScreenshot()

'Click on option import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[2]']))

WebUI.delay(2)

'Select import ref template: Import several Technical artwork briefs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="import_tpl"]']), 
    '6', false)

'Select lifecycle'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '29', false)

WebUI.delay(1)

'Upload file for import'
functions.I.UploadDoc_sendkey_field('//*[@id="xml_file"]', 'D:\\Upoad_File\\AUTOMATION Import ref template TAG\\F14.03 [Creation]Import template.xlsx', 
    '')

WebUI.verifyTextNotPresent('Aucun fichier choisi', false)

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on check file'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[1]']))

functions.I.Pagedown()

'Screenshot'
WebUI.takeScreenshot()

'Verify that the message is displayed correctly'
String Sucess_texte1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_create"]']))

functions.I.print(Sucess_texte1)

String Expected_Sucess_texte1 = (((((((((((' 2 RÉFÉRENCES WILL BE CREATED' + '\n') + 'XML Node 1 :') + '\n') + '  Référence "Greek" will be created') + 
'\n\n') + 'La référence va être liée à la référence “FOREIGN_KEY_1_FG_Carton_500OZ”') + '\n\n') + 'XML Node 2 :') + '\n') + 
'  Référence "Croatian" will be created') + '\n\n') + 'La référence va être liée à la référence “FOREIGN_KEY_3_FG_Carton_500OZ”'

functions.I.print(Expected_Sucess_texte1)

WebUI.verifyMatch(Sucess_texte1, Expected_Sucess_texte1, false)

'74 Verify that the import button is present'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

'Click import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

//REF List PAGE
'ref list page'
WebUI.takeScreenshot()

'Verify the no of ref'
String Atcual_Ref_total = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span']))

WebUI.verifyMatch(Atcual_Ref_total, '5', false)

'ref list page - Greek'
WebUI.takeScreenshot()

'Search for the ref 1 > Greek\t'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords11"]']), 
    'Greek')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[11]/button']))

'Verify if the text Foreign key 1 is present on the page'
WebUI.verifyTextPresent('FOREIGN_KEY_1', false)

'Verify if the text Foreign key 2 is NOT present on the page'
WebUI.verifyTextNotPresent('FOREIGN_KEY_2', false)

'Verify if the text Foreign key 3 is NOT present on the page'
WebUI.verifyTextNotPresent('FOREIGN_KEY_3', false)

//VERIFY TEXT - REf Greek
'88 superedit on the ref daughter'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[15]/div/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[15]/div/div/a[4]']))

WebUI.delay(1)

WebUI.takeScreenshot()

WebUI.delay(2)

'1. Code SKU'
String Actual_SKU = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_106"]']), 
    'value')

'93'
WebUI.verifyMatch(Actual_SKU, 'MB179800', false)

'2. ADDITIONAL SKU CODE(S)'
String Actual_AdditionalSKU = WebUI.getText(findTestObject('1. Constant/xpath', [
            ('xpath') : '//*[@id="var_69"]']))

'95'
WebUI.verifyMatch(Actual_AdditionalSKU, 'ADDITIONAL SKU CODE(S) Part 1', false)

'3. GTIN CODE'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[2]/div[2]/div[5]/div[1]']), 
    5)

String Actual_gtin = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_126"]']), 
    'value')

WebUI.verifyMatch(Actual_gtin, '3337875678094', false)

'4. SHADE N°'
String Actual_SHADE = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_78"]']), 
    'value')

'33'
WebUI.verifyMatch(Actual_SHADE, 'SHADE N° part 1', false)

'5. PRODUCT TO BE NOTIFIED'
String Actual_Product = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-var_107-container"]']), 
    'title')

WebUI.verifyMatch(Actual_Product, 'No', false)

'6.Code ACI'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[2]/div[2]/div[5]/div[2]']), 
    3)

WebUI.takeScreenshot()

String Actual_aci = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_68"]']), 
    'value')

WebUI.verifyMatch(Actual_aci, '120001348', false)

'7.OLD ACI CODE'
String Actual_oldaci = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_108"]']), 
    'value')

WebUI.verifyMatch(Actual_oldaci, 'OLD ACI CODE part 1', false)

WebUI.takeScreenshot()

'8. LANGUAGE GROUP CODE'
String Actual_languagegroup = WebUI.getAttribute(findTestObject('1. Constant/xpath', 
        [('xpath') : '//*[@id="select2-var_70-container"]']), 'title')

WebUI.verifyMatch(Actual_languagegroup, 'H01', false)

'9. LANGUAGES'
String Actual_language = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selDest_10"]/option']))

WebUI.verifyMatch(Actual_language, 'Greek', false)

functions.I.Pagedown()

WebUI.takeScreenshot()

'10. Leader mkt'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[2]/div[2]/div[8]/div[2]']), 
    3)

String Actual_leadermkt = WebUI.getAttribute(findTestObject('1. Constant/xpath', 
        [('xpath') : '//*[@id="select2-var_166-container"]']), 'title')

WebUI.verifyMatch(Actual_leadermkt, 'Leader Country', false)

'10. Leader country'
String Actual_leadercountry = WebUI.getAttribute(findTestObject('1. Constant/xpath', 
        [('xpath') : '//*[@id="select2-var_71-container"]']), 'title')

WebUI.verifyMatch(Actual_leadercountry, 'Albania', false)

functions.I.Pagedown()

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/a']))

'Search for the ref 1 > Croatian'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords11"]']), 
    'Croatian')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[11]/button']))

'ref list page - Croatian'
WebUI.takeScreenshot()

'Verify if the text Foreign key 3 is present on the page'
WebUI.verifyTextPresent('FOREIGN_KEY_3', false)

'Verify if the text Foreign key 1 is NOT present on the page'
WebUI.verifyTextNotPresent('FOREIGN_KEY_1', false)

'Verify if the text Foreign key 2 is NOT present on the page'
WebUI.verifyTextNotPresent('FOREIGN_KEY_2', false)

//VERIFY TEXT - REf Croatian
'58 superedit on the ref daughter'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[15]/div/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[15]/div/div/a[4]']))

WebUI.delay(1)

WebUI.takeScreenshot()

WebUI.delay(2)

'1. Code SKU'
String Actual_SKU1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_106"]']), 
    'value')

WebUI.verifyMatch(Actual_SKU1, 'MB179801', false)

'2. ADDITIONAL SKU CODE(S)'
String Actual_AdditionalSKU1 = WebUI.getText(findTestObject('1. Constant/xpath', 
        [('xpath') : '//*[@id="var_69"]']))

functions.I.print(Actual_AdditionalSKU1)

String Actual_AdditionalSKU2 = 'ADDITIONAL SKU CODE(S) Part 2'

WebUI.verifyMatch(Actual_AdditionalSKU1, Actual_AdditionalSKU2, false)

'3. GTIN CODE'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[2]/div[2]/div[5]/div[1]']), 
    5)

String Actual_gtin1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_126"]']), 
    'value')

WebUI.verifyMatch(Actual_gtin1, '3337875678094', false)

'4. SHADE N°'
String Actual_SHADE1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_78"]']), 
    'value')

WebUI.verifyMatch(Actual_SHADE1, 'SHADE N° part 2', false)

'5. PRODUCT TO BE NOTIFIED'
String Actual_Product1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [
            ('xpath') : '//*[@id="select2-var_107-container"]']), 'title')

WebUI.verifyMatch(Actual_Product1, 'Yes', false)

'6.Code ACI'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[2]/div[2]/div[5]/div[2]']), 
    3)

WebUI.takeScreenshot()

String Actual_aci1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_68"]']), 
    'value')

WebUI.verifyMatch(Actual_aci1, '120001348', false)

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_68"]']), 
    '920001348')

'7.OLD ACI CODE'
String Actual_oldaci1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_108"]']), 
    'value')

WebUI.verifyMatch(Actual_oldaci1, 'OLD ACI CODE part 2', false)

'agence'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[2]/div[2]/div[7]/div[2]']), 
    3)

WebUI.takeScreenshot()

///html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[2]/div[2]/div[7]/div[2]/div[1]/div/span
'8. LANGUAGE GROUP CODE'
String Actual_languagegroup1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', 
        [('xpath') : '//*[@id="select2-var_70-container"]']), 'title')

WebUI.verifyMatch(Actual_languagegroup1, '165', false)

'9. LANGUAGES'
String Actual_language1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selDest_10"]/option']))

WebUI.verifyMatch(Actual_language1, 'Croatian', false)

functions.I.Pagedown()

WebUI.takeScreenshot()

'10. Leader mkt'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[2]/div[2]/div[8]/div[2]']), 
    3)

String Actual_leadermkt1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', 
        [('xpath') : '//*[@id="select2-var_166-container"]']), 'title')

WebUI.verifyMatch(Actual_leadermkt1, 'Leader Country', false)

'10. Leader country'
String Actual_leadercountry1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', 
        [('xpath') : '//*[@id="select2-var_71-container"]']), 'title')

WebUI.verifyMatch(Actual_leadercountry1, 'France', false)

functions.I.Pagedown()

'Click Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

//SCENARIO 9: UPDATE OF DAUGHTER REF
'Click on + to import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Screenshot: Selection of import page'
WebUI.takeScreenshot()

'Click on option import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[2]']))

WebUI.delay(2)

'Select import ref template: Import several Technical artwork briefs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="import_tpl"]']), 
    '6', false)

WebUI.delay(1)

'Select lifecycle'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '29', false)

WebUI.delay(1)

'Upload file for import'
functions.I.UploadDoc_sendkey_field('//*[@id="xml_file"]', 'D:\\Upoad_File\\AUTOMATION Import ref template TAG\\G14.03 [Update]Import template.xlsx', 
    '')

WebUI.verifyTextNotPresent('Aucun fichier choisi', false)

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on check file'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[1]']))

functions.I.Pagedown()

'Screenshot'
WebUI.takeScreenshot()

'Verify that the message is displayed correctly'
String Sucess_texte2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_update"]']))

functions.I.print(Sucess_texte2)

String Expected_Sucess_texte2 = (((((((' 1 RÉFÉRENCES WILL BE UPDATED' + '\n') + 'XML Node 1 (ACI code : 920001348) :') + 
'\n') + '1 Référence will be updated :') + '\n') + '  ') + Project_No) + ' - FOREIGN_KEY_3_FG_Carton_500OZ_SHADE N° part 2__HR_165_920001348_'

functions.I.print(Expected_Sucess_texte2)

'54'
WebUI.verifyMatch(Sucess_texte2, Expected_Sucess_texte2, false)

'Verify that the import button is present'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[11]/a[2]']))

'Search for the ref 1 >French\t'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords11"]']), 
    'French')

'194'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[11]/button']))

WebUI.delay(2)

'Super edit ref 1'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[15]/div/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[15]/div/div/a[4]']))

'2. ADDITIONAL SKU CODE(S)'
String Actual_AdditionalSKU11 = WebUI.getText(findTestObject('1. Constant/xpath', 
        [('xpath') : '//*[@id="var_69"]']))

WebUI.verifyMatch(Actual_AdditionalSKU11, 'ADDITIONAL SKU CODE(S) Part 5 (mofication)', false)

'Click on cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/a']))

WebUI.closeBrowser()

