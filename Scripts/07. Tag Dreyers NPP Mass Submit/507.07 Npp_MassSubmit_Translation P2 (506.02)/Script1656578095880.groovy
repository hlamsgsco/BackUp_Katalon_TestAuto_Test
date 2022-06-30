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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.junit.After as After
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

/////////////////////////////SCENARIO NPP : LSS LIFECYCLE (2) /////////////////////
//STEP 1: CREATION
//PHASE 1 : LSS PREFILL
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - NPP
def data_Npp = TestDataFactory.findTestData('Data Files/Username_Password/Test_Npp')

String password_ncur = data_Npp.getValue(2, 1)

String password_akim = data_Npp.getValue(2, 2)

String password_sschunke = data_Npp.getValue(2, 3)

String password_abrazhnikovapx = data_Npp.getValue(2, 4)

String password_afrappaz = data_Npp.getValue(2, 5)

String password_alarkins = data_Npp.getValue(2, 6)

String password_cdemonchy = data_Npp.getValue(2, 7)


//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Npp = data_urlTESTAUTO.getValue(2, 5)


////////////////////////////NAVIGATE TO NPP ///////////////////////////////////
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\NPP\\506.02\\506.02_NPP_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\NPP\\506.02\\506.02_NPP_refID.txt')

'Navigate to NPP'
WebUI.openBrowser(Url_Npp)

// http://mdb-release.diadeis.lan/MediaboxIndependence/?MBI_datasource=
WebUI.maximizeWindow()

'Screenshot: Navigate to Npp'
WebUI.takeScreenshot()

////////////////////////////CREATION OF PROJECT - LSS ///////////////////////////////////
'Log in as Product Platform – All users'
functions.I.Login_password('ncur', password_ncur)

' Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

WebUI.delay(1)

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[9]/button')

WebUI.delay(5)

'Screenshot:  '
WebUI.takeScreenshot()

'PP Approval: Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_84"]']), 
    'akim', false)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(1)

'Screenshot:  '
WebUI.takeScreenshot()

'Px Approval: Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_76"]']), 
    'afrappaz', false)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(1)

'Screenshot:  '
WebUI.takeScreenshot()

'Nutritionist Approval: Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

//*[@id="ModifFiche"]/div[1]/div/div/button
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(1)

'Screenshot:  '
WebUI.takeScreenshot()

//*[@id="ModifFiche"]/div[1]/div/div/button
'Local RSA RU Approval: Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

WebUI.delay(1)

'52'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_56"]']), 
    'ctralrsa', false)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(1)

'Screenshot:  '
WebUI.takeScreenshot()

//*[@id="ModifFiche"]/div[1]/div/div/button
'Local RSA FR Approval: Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_69"]']), 
    'ekolkina', false)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(1)

'Screenshot:  '
WebUI.takeScreenshot()

//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button
'Local RSA UK Approval: Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_146"]']), 
    'sesther', false)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(1)

'Screenshot:  '
WebUI.takeScreenshot()

//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button
'Central RSA Approval: Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_147"]']), 
    'aogunsanya', false)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(1)

'Screenshot:  '
WebUI.takeScreenshot()

'88. Language settup: edit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/a[2]']))

WebUI.delay(1)

functions.I.select_multiplelist('//*[@id="selSource_default_target_language"]', '//*[@id="btn_add_default_target_language"]', 
    'EN')

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_72"]']), 
    '10/10/2030')

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_116"]']), 
    '10/10/2030')

functions.I.select_multiplelist('//*[@id="selSource_61"]', '//*[@id="btnAdd_61"]', '2144')

functions.I.Pagedown()

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[1]']))

WebUI.delay(1)

'Screenshot:  '
WebUI.takeScreenshot()

'29Perform mass submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnMassSubmit"]']))

WebUI.delay(1)

'Check ref1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[1]/label']))

WebUI.delay(1)

'Click confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

WebUI.delay(1)

'Screenshot:  '
WebUI.takeScreenshot()

'Verify  msg'
String Amsg_1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table/tbody/tr/td[2]']))

'104\r\n'
WebUI.verifyMatch(Amsg_1, 'Missing mandatory information at reference level (Translation)', false)

'Click on cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[2]/div[2]/div/button[1]']))

///////////////////////////////////////Edit Source text
'Click on edit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[1]/button']))

WebUI.delay(1)

'Click on edit source text'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[1]/div/a[2]']))

WebUI.delay(2)

'Click on + to add translation field manually'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_newfield_zone"]']))

WebUI.delay(2)

'Select Analytical constituents - Snacks / Biscuits - UKRAINE only'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_new"]']), 
    '189', false)

WebUI.delay(2)

functions.I.Pagedown()

'Click add'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="add_newtranslationfield"]']))

WebUI.delay(3)

//WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[1]']), '5')
'Click save'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[2]/button[1]']))

WebUI.delay(2)

'Click close'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[2]/a']))

'Perform mass submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnMassSubmit"]']))

WebUI.delay(1)

'Check ref1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[1]/label']))

WebUI.delay(1)

'Click confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

WebUI.delay(1)

'Screenshot:  '
WebUI.takeScreenshot()

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

WebUI.delay(2)

////*[@id="fiches"]/table/tbody/tr[1]/td[7]/span[2]
'VErify lifecycle template - Mother'
String ALM1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[7]/span[2]']))

WebUI.verifyMatch(ALM1, 'Waiting for translation', false)

'VErify lifecycle template - DAughter'
String ALD1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span[2]']))

///html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span[2]
WebUI.verifyMatch(ALD1, 'MKT Translation', false)

'Click mother ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[5]/a[1]']))

WebUI.delay(2)

WebUI.takeScreenshot()

'Click on text content'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_text_content_brief"]']))

WebUI.delay(2)

'Verify that element is present'
String ATX1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="my_table"]/tbody/tr/td[9]']))

///html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span[2]
WebUI.verifyMatch(ATX1, 'Analytical constituents - Snacks / Biscuits - UKRAINE only', false)

WebUI.closeBrowser()

