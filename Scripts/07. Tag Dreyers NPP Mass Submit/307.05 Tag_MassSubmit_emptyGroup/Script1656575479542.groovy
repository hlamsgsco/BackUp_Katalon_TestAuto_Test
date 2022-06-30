import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.google.common.base.Functions as Functions
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

//////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
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


/////////////////////////////////EMPTY GROUP///////////////////////////////////////////
/////////////////////////////////EXISTING PROJECT : MI002230 ////////////////////////
/////////////
///////////////////S1 EMPTY GROUP - EMPTY FIELD (FILTERED GROUP : PRINTER- 1 FIELD)/////////////////////
///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//////////////////////SCENARIO 1 EXISTING PROJECT (MI002232)IS DISPLAYED FOR ADMIN USER ///////////////////////////////
//////////////////////////// LOGIN   ///////////////////////////////////
'Log in as ADMIN – rrowland'
functions.I.Login_password('jedun', password_jedun)

'Screenshot: Log in '
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

/////////////////////////PROJECTION CREATION
////*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/div[1]/button
'Click on + to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

WebUI.delay(1)

'Screenshot: Create Project page'
WebUI.takeScreenshot()

'Select Project template '
functions.I.SelectFromList_Value('//*[@id="project_template"]', '12')

'Click on create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

'Screenshot: creation project page'
WebUI.takeScreenshot()

///
'Project name: Project name mass submit'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_141"]']), 'Project:MASS SUBMIT (Empty Group)')

WebUI.delay(2)

'Domain'
functions.I.SelectFromList_Value('//*[@id="var_116"]', '1070')

WebUI.delay(2)

'Development zone Required'
functions.I.SelectFromList_Value('//*[@id="var_262"]', '16352')
WebUI.delay(2)
'Select Division :CPD'
functions.I.SelectFromList_Value('//*[@id="var_15"]', '57')
WebUI.delay(2)
'37 Select Signature: Garnier '
functions.I.SelectFromList_Value('//*[@id="var_16"]', '58')

WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_15"]']), 5)

WebUI.delay(4)

//'Brand: Acne'
'Axis: Skin Care'
functions.I.SelectFromList_Value('//*[@id="var_20"]', '40')

'SubAxis: Sun care '
functions.I.SelectFromList_Value('//*[@id="var_21"]', '197')

'C&A contacts: pmareri'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'pmareri')

String Project_No = functions.I.ProjectNo()

'Screenshot: Project modif page'
WebUI.takeScreenshot()

'Click on Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button/i']))

WebUI.delay(10)

'Screenshot: ref list page'
WebUI.takeScreenshot()

///////////////////////////////////CREATION OF MOTHER REF
'Click on + to create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

'Click on ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[1]']))

'Select ref template'
functions.I.SelectFromList_Value('//*[@id="ref_type"]', '11')

'Select Lifecycle template'
functions.I.SelectFromList_Value('//*[@id="lfc_tpl"]', '43')

'Screenshot: creation ref page'
WebUI.takeScreenshot()

'Click on create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(2)

String refID = functions.I.RefID_tag()

'Screenshot: Edit ref page'
WebUI.takeScreenshot()

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[1]/a']))

WebUI.delay(1)

//////////////////////////REF Modif page
////*[@id="source_15177"]/td[17]/div[1]/button
'62 create daughter ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[16]/div[1]/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[16]/div[1]/div/a[1]']))

'Screenshot: Ref creation page'
WebUI.takeScreenshot()

'Select lifecycle'
functions.I.SelectFromList_Value('//*[@id="lfc_tpl"]', '65')

'C&A click on create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

'Screenshot: Ref modif page'
WebUI.takeScreenshot()

String refId_d1 = functions.I.RefID_tag()

'Select languages: Afirkaans'
functions.I.select_multiplelist('//*[@id="selSource_10"]', '//*[@id="btnAdd_10"]', '1303')

'Select leader marketing : leader country'
functions.I.SelectFromList_Value('//*[@id="var_166"]', '1191')

'Select leader  country:Afghanistan'
functions.I.SelectFromList_Value('//*[@id="var_71"]', '1366')

'Select Approver countries/zones: Afghanistan'
functions.I.select_multiplelist('//*[@id="selSource_72"]', '//*[@id="btnAdd_72"]', '1366')

WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[3]/div[1]/button']), 
    20)

'72 Click save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[3]/div[1]/button']))

functions.I.Logout()

//////////////LOGIN AS C&A
'Log in as C&A - pmareri'
functions.I.Login_password('pmareri', password_pmareri)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

///////////////////////////////MASS SUBMIT
'Click mass submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/button']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

'Choose 1 SEND (a-cpd)'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/div/a[1]']))

'Screenshot'
WebUI.takeScreenshot()

'Check checkbox 1'
WebUI.check(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refId_d1) + '"]/td[1]/label']))

'48 Click confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

'Verify error message'
String Actual_text1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table/tbody/tr/td[2]']))

functions.I.print(Actual_text1)

WebUI.verifyMatch(Actual_text1, ('Missing mandatory information at reference level' + '\n') + 'empty groups', false)

'verify that button is not clickable'
WebUI.verifyElementNotClickable(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[2]/div[2]/div/button[1]']))

'Screenshot'
WebUI.takeScreenshot()

//////////////////////FILL IN MANDATORY FIELDS
////*[@id="source_24472"]/td[15]/a[1]
'36 Update ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refId_d1) + '"]/td[15]/a[1]']))

'approval date'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_89"]']), '12/12/2030')

'95 Update ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[1]']))

///////////////////////////////MASS SUBMIT
'Click mass submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/button']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

'28 Choose 1 SEND (a-cpd)'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/div/a[1]']))

'Screenshot'
WebUI.takeScreenshot()

'Check checkbox 1'
WebUI.check(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refId_d1) + '"]/td[1]/label']))

'Click confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

'Verify error message'
String Actual_text2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table/tbody/tr/td[2]']))

functions.I.print(Actual_text2)

WebUI.verifyMatch(Actual_text2, 'empty groups', false)

'verify that cutton is not clickable'
WebUI.verifyElementNotClickable(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[2]/div[2]/div/button[1]']))

'Screenshot'
WebUI.takeScreenshot()

'33 Update ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refId_d1) + '"]/td[15]/a[1]']))

'Select languages: Spainish'
functions.I.select_multiplelist('//*[@id="selSource_10"]', '//*[@id="btnAdd_10"]', '1040')

'Select leader  country:Afghanistan'
functions.I.SelectFromList_Value('//*[@id="var_71"]', '1055')

'Select Approver countries/zones: Spain'
functions.I.select_multiplelist('//*[@id="selSource_72"]', '//*[@id="btnAdd_72"]', '1055')

functions.I.Pagedown()

'Click on Update ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[1]']))

///////////////////////////////MASS SUBMIT
'Click mass submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/button']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

'Choose 1 SEND (a-cpd)'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/div/a[1]']))

'Screenshot'
WebUI.takeScreenshot()

'Check checkbox 1'
WebUI.check(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refId_d1) + '"]/td[1]/label']))

'Click confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

////*[@id="tablecontentNOK"]/table/tbody/tr/td[2]
'Verify  message'
String Actual_text3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentOK"]/table/tbody/tr/td[2]']))

functions.I.print(Actual_text3)

WebUI.verifyMatch(Actual_text3, 'Leader MKT: Brief completion', false)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify Lifecycle stauts'
String Actual_text4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refId_d1) + '"]/td[13]/span[1]']))

//*[@id="source_24472"]/td[13]/span[1]
functions.I.print(Actual_text4)

WebUI.verifyMatch(Actual_text4, 'Leader MKT: Brief completion', false)

WebUI.closeBrowser()

