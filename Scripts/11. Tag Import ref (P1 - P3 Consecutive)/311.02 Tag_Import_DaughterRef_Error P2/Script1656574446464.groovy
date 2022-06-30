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


//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)

/* SCENARIOS TESTED
SCENARIO 4: IF MOTHER FK IS EMPTY IN THE EXCEL, ERROR MSG 'The linked reference is missing in the file' IS DISPLAYED 

SCENARIO 5: IF MOTHER FK IS NOT EMPTY & IN THE PROJECT NO REF HAS THE SAME MOTHER FK, ERROR MSG 'None of several references to link found in the project' IS DISPLAYED

SCENARIO 6:IF MOTHER FK IS NOT EMPTY & IN THE PROJECT MANY REFS HAS THE SAME MOTHER FK, ERROR MSG 'None of several references to link found in the project' IS DISPLAYED
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

WebUI.delay(3)

//REF LIST PAGE

'Click on + to import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(3)

'Click on option import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[2]']))

WebUI.delay(2)

//IMPORT REF PAGE
'Import ref page'
WebUI.takeScreenshot()

//SCENARIO 4: IF MOTHER FK IS EMPTY IN THE EXCEL, ERROR MSG 'The linked reference is missing in the file' IS DISPLAYED
'Select import ref template: Import several Technical artwork briefs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="import_tpl"]']), 
    '6', false)

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '29', false)

functions.I.UploadDoc_sendkey_field('//*[@id="xml_file"]', 'D:\\Upoad_File\\AUTOMATION Import ref template TAG\\C14.02 [Empty mother key]Import template.xlsx', 
    '')

WebUI.verifyTextNotPresent('Aucun fichier choisi', false)

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[1]']))

functions.I.Pagedown()

'ERror message CHECK FILE RESULT : ERROR + CHECK FILE RESULT : WARNING'
WebUI.takeScreenshot()

//check file result
String textc1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_error"]']))

functions.I.print(textc1)

String textac1 = ((((((((('CHECK FILE RESULT : ERROR' + '\n') + 'XML Node 1 :') + '\n') + 'None of several references to link found in the project') + 
'\n\n') + 'XML Node 1 :') + '\n') + 'Can not update or create reference with this node :') + '\n') + '  No references matches to the foreign key value "120001348"'

functions.I.print('Actual > ' + textac1)

functions.I.print('Expected > ' + textc1)

WebUI.verifyMatch(textc1, textac1, false)

//CHECK FILE RESULT : WARNING
String textc2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_warning"]']))

functions.I.print(textc2)

String textac2 = ((('CHECK FILE RESULT : WARNING' + '\n') + 'XML Node 1 :') + '\n') + 'The linked reference is missing in the file'

functions.I.print('Actual > ' + textac2)

functions.I.print('Expected > ' + textc2)

WebUI.verifyMatch(textc2, textac2, false)

'Verify that the import button is Not present'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/a']))

WebUI.delay(1)

//SCENARIO 5: IF MOTHER FK IS NOT EMPTY & IN THE PROJECT NO REF HAS THE SIMILAR MOTHER FK, ERROR MSG 'None of several references to link found in the project' IS DISPLAYED
'Ref List page'
WebUI.takeScreenshot()

'Click on + to import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

WebUI.takeScreenshot()

'Click on option import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[2]']))

WebUI.delay(2)

'Import ref page'
WebUI.takeScreenshot()

'Select import ref template: Import several Technical artwork briefs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="import_tpl"]']), 
    '6', false)

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '29', false)

'Upload file for import'
functions.I.UploadDoc_sendkey_field('//*[@id="xml_file"]', 'D:\\Upoad_File\\AUTOMATION Import ref template TAG\\D14.02 [No similar mother key]Import template.xlsx', 
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

'Verify that the Error message is displayed correctly'
String textd3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_error"]']))

functions.I.print(textd3)

String Expected_textad3 = ((((((((('CHECK FILE RESULT : ERROR' + '\n') + 'XML Node 1 :') + '\n') + 'None of several references to link found in the project') + 
'\n\n') + 'XML Node 1 :') + '\n') + 'Can not update or create reference with this node :') + '\n') + '  No references matches to the foreign key value "120001348"'

functions.I.print(Expected_textad3)

'82'
WebUI.verifyMatch(textd3, Expected_textad3, false)

'Verify that the import button is present'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/a']))

//SCENARIO 6:IF MOTHER FK IS NOT EMPTY & IN THE PROJECT MANY REFS HAS THE SAME MOTHER FK, ERROR MSG 'None of several references to link found in the project' IS DISPLAYED
'Screenshot:Ref List page'
WebUI.takeScreenshot()

'Click on + to import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click on option import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[2]']))

WebUI.delay(2)

'Import ref page'
WebUI.takeScreenshot()

'Select import ref template: Import several Technical artwork briefs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="import_tpl"]']), 
    '6', false)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']),
	'29', false)

WebUI.delay(1)

'Upload file for import'
functions.I.UploadDoc_sendkey_field('//*[@id="xml_file"]', 'D:\\Upoad_File\\AUTOMATION Import ref template TAG\\E14.02 [Multiple Same mother key]Import template.xlsx', 
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

'Verify that the Error message is displayed correctly'
String texte3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_error"]']))

functions.I.print(texte3)

String Expected_textae3 = ((((((((('CHECK FILE RESULT : ERROR' + '\n') + 'XML Node 1 :') + '\n') + 'None of several references to link found in the project') + 
'\n\n') + 'XML Node 1 :') + '\n') + 'Can not update or create reference with this node :') + '\n') + '  No references matches to the foreign key value "120001348"'

functions.I.print(Expected_textae3)

'107'
WebUI.verifyMatch(texte3, Expected_textae3, false)

'Verify that the import button is present'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/a']))

WebUI.closeBrowser()

