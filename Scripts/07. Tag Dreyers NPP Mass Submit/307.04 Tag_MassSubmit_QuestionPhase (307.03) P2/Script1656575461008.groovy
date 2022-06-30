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

/* 	SCENARIO 1 : RIGHTS ON THE MASS SUBMIT /////////////////////////////////
Verify rights (MI002241)

C : PMARERI C&A SHOULD BE ABLE TO PERFORM MASS SUBMIT

SCENARIO 2: Control tag  + Mass submit*/
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - tag
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

String password_qeuzen = data_Tag.getValue(3, 13)

String password_alanglois = data_Tag.getValue(3, 14)

String password_bde_villeneuve = data_Tag.getValue(3, 15)

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\307.03 Tag_Project\\307.03_Tag_ProjectNo.txt')

String refID1 = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\307.03 Tag_Project\\307.03_Tag_refID.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

'Log in as rrowland'
functions.I.Login_password('rrowland', password_rrowland)

'Screenshot: Log in as rrowland'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

WebUI.delay(1)

'Screenshot:  Ref list page of Project'
WebUI.takeScreenshot()

WebUI.delay(1)

'30 Click on + to create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

'Click on ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

'Screenshot:REf Creation page'
WebUI.takeScreenshot()

'Select ref template'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ref_type"]']), '13', false)

WebUI.delay(1)

'Click on create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(5)

'Screenshot: ref modif  page '
WebUI.takeScreenshot()

'40 Marketing product name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_117"]']), 'MKT_PART_2')

'PC > Select from list: FAke'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_57"]']), '134', false)

'PF > Select form list : aCcesory'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_28"]']), '15738', false)

String refID2 = functions.I.RefID_tag()

functions.I.print(refID2)

'Click save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

WebUI.delay(1)

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'ClickSubmit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[15]/a[2]']))

WebUI.delay(1)

'ClickSubmit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click option2'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[2]']))

'Get text'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_151"]']), 'TEST - Question')

'Screenshot'
WebUI.takeScreenshot()

'Click '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[1]']))

WebUI.delay(1)

/////////////////////////////////////////ROAD 1
'Click on mass submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/button']))

WebUI.delay(1)

'Choose option 1 send back to dmi'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/div/a[1]']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

////*[@id="fiches"]/table/tbody/tr[2]/td[1]/label
'54 Check all > checkbox 1'
WebUI.check(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_"]/th[1]/label']))

'Click confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

'Click send to agency'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

' 30 Verify lifecycle'
String Actual_text1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[12]/span[1]']))

functions.I.print(Actual_text1)

WebUI.verifyMatch(Actual_text1, 'DMI: Brief completion', false)

String Actual_text2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/span[1]']))

functions.I.print(Actual_text2)

WebUI.verifyMatch(Actual_text2, 'DMI: Brief completion', false)

/////////////////////////////////////////SEND TO AGENCY
'Click on mass submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/button']))

WebUI.delay(1)

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

'Choose option5 send to c&A'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/div/a[3]']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

'Check 2 checkbox'
WebUI.check(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/thead/tr/th[1]/label']))

'Click confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

'Click C&A'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(2)

//REF1
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords14"]']), 'MKT_PART_1')

WebUI.delay(2)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[10]/button']))

WebUI.delay(2)

//FILL IN MANDATORY FIELD
//*[@id="fiches"]/table/tbody/tr/td[15]/a
'39 Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[15]/a[2]']))

WebUI.delay(1)

'Screenshot'
WebUI.takeScreenshot()

functions.I.Pagedown()

'Printer supplier> Select form list : 3D TECHNOPACK | IND, Silvassa'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_48"]']), '64', false)

'Click update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

'Screenshot'
WebUI.takeScreenshot()

//REF2
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords14"]']), 'MKT_PART_2')

WebUI.delay(2)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[10]/button']))

WebUI.delay(2)

//REF2
//FILL IN MANDATORY FIELD
'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[15]/a[2]']))

WebUI.delay(1)

'Screenshot'
WebUI.takeScreenshot()

functions.I.Pagedown()

'Printer supplier> Select form list : 3D TECHNOPACK | IND, Silvassa'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_48"]']), '64', false)

'Click update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(2)

'REset filteres'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[10]/a[2]']))

//PERFORM MAASS SUBMIT FOR THE 2 REF
'Click mass submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/button']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

/////////////////////////////////////////road FOR 2REFS
'Choose option1 SEND BACK TO DMI'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/div/a[1]']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

'35 Check checkbox 1 & 2'
WebUI.check(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_"]/th[1]/label']))

'Click confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

'Click send to agency'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

'31 Verify lifecycle'
String Actual_text3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[12]/span[1]']))

functions.I.print(Actual_text3)

WebUI.verifyMatch(Actual_text3, 'DMI: Brief completion', false)

String Actual_text4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]']))

functions.I.print(Actual_text4)

WebUI.verifyMatch(Actual_text4, 'C&A: Brief completion', false)

WebUI.closeBrowser()

