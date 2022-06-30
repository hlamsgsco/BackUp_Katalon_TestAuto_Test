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
SCENARIO 10: In the project there are refs standby/ cancel/ deleted'.  2 refs are updated (standby and cancel) and 1 ref created (deleted)

 */
String Project_No = 'MI003395'

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

////*[@id="form_filters"]/div[7]/button
'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

'Screenshot: ref listpage'
WebUI.takeScreenshot()

////////////////////////////////// CHANGES OF THE FK //////////////////////////
//IMPORT OF DAUGHTER REF
//DEL REF MOTHER
'Screenshot'
WebUI.takeScreenshot()

'26 Click on + to import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Screenshot: Selection of import page'
WebUI.takeScreenshot()

'Click on option import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[2]']))

WebUI.delay(2)

'Screenshot'
WebUI.takeScreenshot()

'Select import ref template: Import several Technical artwork briefs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="import_tpl"]']), 
    '2', false)

WebUI.delay(1)

'34 Select lifecycle'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '66', false)

'Upload file for import'
functions.I.UploadDoc_sendkey_field('//*[@id="xml_file"]', 'D:\\Upoad_File\\AUTOMATION Import ref template TAG\\H14.04[DEL mother]Import template daughter.xlsx', 
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
String Actual_error1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_error"]']))

functions.I.print(Actual_error1)

String Expected_error1 = ((((((((('CHECK FILE RESULT : ERROR' + '\n') + 'XML Node 1 :') + '\n') + 'None of several references to link found in the project') + 
'\n\n') + 'XML Node 1 :') + '\n') + 'Can not update or create reference with this node :') + '\n') + '  No references matches to the foreign key value "420001348"'

functions.I.print(Expected_error1)

WebUI.verifyMatch(Actual_error1, Expected_error1, false)

'Verify that the import button is present'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/a']))

//Import mother ref
//same fK as deleted  > creeation
//standby > update
//cancelled > up
'Screenshot'
WebUI.takeScreenshot()

'Click on + to import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Screenshot: Selection of import page'
WebUI.takeScreenshot()

'Click on option import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[2]']))

WebUI.delay(2)

'55 Select import ref template: Import several Technical artwork briefs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="import_tpl"]']), 
    '7', false)

WebUI.delay(1)

'Upload file for import'
functions.I.UploadDoc_sendkey_field('//*[@id="xml_file"]', 'D:\\Upoad_File\\AUTOMATION Import ref template TAG\\I14.04[status mother]Import template.xlsx', 
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

//Creation mother
'Verify that the message is displayed correctly'
String Actual_test1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_create"]']))

functions.I.print(Actual_test1)

String Expected_test1 = (((' 1 REFERENCES WILL BE CREATED' + '\n') + 'XML Node 1 :') + '\n') + '  Reference "FOREIGN_KEY_DELETED" will be created'

functions.I.print(Expected_test1)

WebUI.verifyMatch(Actual_test1, Expected_test1, false)

//Update3
//cancel ref //standby
String Actual_test2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_update"]/div[2]']))

functions.I.print(Actual_test2)

String Expected_test2 = ((((((((((((((('XML Node 2 (Marketing product name : FOREIGN_KEY_CANCEL) :' + '\n') + '1 Reference will be updated :') + 
'\n') + '  MI003395 - FOREIGN_KEY_CANCEL___') + '\n\n') + 'XML Node 3 (Marketing product name : FOREIGN_KEY_STANDBY) :') + 
'\n') + '1 Reference will be updated :') + '\n') + '  MI003395 - FOREIGN_KEY_STANDBY___') + '\n\n') + 'XML Node 4 (Marketing product name : FOREIGN_KEY_TO_UPDATE) :') + 
'\n') + '1 Reference will be updated :') + '\n') + '  MI003395 - FOREIGN_KEY_TO_UPDATE___'

functions.I.print(Expected_test2)

WebUI.verifyMatch(Actual_test2, Expected_test2, false)

'Verify that the import button is present'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

'Click import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

'Click reset'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[5]/a[2]']))

'Screenshot'
WebUI.takeScreenshot()

'Verify the total ref no'
String total_5 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span']))

WebUI.verifyMatch(total_5, '5', false)

//CHANGE THE MOTHER KEY FIELD - cancel ref
'Search for the ref 1 > \tFOREIGN_KEY_CANCEL\t'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords11"]']), 
    'FOREIGN_KEY_CANCEL')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[5]/button']))

'Screenshot'
WebUI.takeScreenshot()

'47n Super edit ref 1 cancel'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24376"]/td[15]/div[2]/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[15]/div[2]/div/a[3]']))

//' the mother FK- 600318855'
//WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), 
//   5)
String Actual_test4 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), 
    'value')

WebUI.verifyMatch(Actual_test4, '600318855', false)

functions.I.Pagedown()

'Click cancel'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/a']))

//CHANGE THE MOTHER KEY FIELD - standy ref
'Search for the ref 1 > \tFOREIGN_KEY_STANDBY\t'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords11"]']), 
    'FOREIGN_KEY_STANDBY')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[5]/button']))

'Screenshot'
WebUI.takeScreenshot()

' Super edit ref 1 STANDBY\t'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24377"]/td[15]/div[2]/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[15]/div[2]/div/a[4]']))

//'Change the mother FK- 600318855'
//WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), 
//  5)
String Actual_test5 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), 
    'value')

WebUI.verifyMatch(Actual_test5, '800318855', false)

functions.I.Pagedown()

'Click cancel'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/a']))

//CHANGE THE MOTHER KEY FIELD - sFOREIGN_KEY_TO_UPDATE
'Search for the ref 1 > \tFOREIGN_KEY_TO_UPDATE\t'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords11"]']), 
    'FOREIGN_KEY_TO_UPDATE')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[5]/button']))

'Screenshot'
WebUI.takeScreenshot()

'25 Super edit ref 1 FOREIGN_KEY_TO_UPDATE\t'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24378"]/td[15]/div[2]/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[15]/div[2]/div/a[4]']))

//'Change the mother FK- 700318855'
//WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), 
//   5)
String Actual_test6 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), 
    'value')

WebUI.verifyMatch(Actual_test6, '700318855', false)

functions.I.Pagedown()

'Click cancel'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/a']))

//Import daughter ref 
'Click on + to import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Screenshot: Selection of import page'
WebUI.takeScreenshot()

'Click on option import ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[2]']))

WebUI.delay(2)

'110 Select import ref template: Import several Technical artwork briefs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="import_tpl"]']), 
    '2', false)

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '66', false)

WebUI.delay(1)

'Upload file for import'
functions.I.UploadDoc_sendkey_field('//*[@id="xml_file"]', 'D:\\Upoad_File\\AUTOMATION Import ref template TAG\\J14.04[DEL mother]Import template daughter.xlsx', 
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
String Actual_s1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="control_block_create"]']))

functions.I.print(Actual_s1)

String Expected_s1 = (((((' 1 REFERENCES WILL BE CREATED' + '\n') + 'XML Node 1 :') + '\n') + '  Reference "French" will be created') + 
'\n\n') + 'The reference will be linked to the reference “FOREIGN_KEY_DELETED”'

functions.I.print(Expected_s1)

'39'
WebUI.verifyMatch(Actual_s1, Expected_s1, false)

'Click import'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[7]/div/button[2]']))

'Click on rest'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[5]/a[2]']))

'Screenshot'
WebUI.takeScreenshot()

'Verify the total ref no'
String total_6 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span']))

WebUI.verifyMatch(total_6, '6', false)

//CHANGE THE MOTHER KEY FIELD - cancel ref
'Search for the ref 1 > \tFrench\t'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords11"]']), 
    'French')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[5]/button']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(2)

functions.I.Pagedown()
//'135'
//WebUI.verifyMatch(WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24424"]/td[13]/span[1]'])), 
//    'C&A/APM: Brief completion', false)

WebUI.closeBrowser()

