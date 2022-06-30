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

///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')
String password_blemco = data_Dreyers.getValue(2, 2) //R
String password_mbaughman = data_Dreyers.getValue(2, 5) //R
String password_nturner = data_Dreyers.getValue(2, 6) //R
String password_talexeeva = data_Dreyers.getValue(2, 7)  //R

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Dreyers Test'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

///////////////////////////////// NAVIGATING TO DREYERS  ////////////////////////////////////////////
'Screenshot: Navigate to URL Dreyer Test'
WebUI.takeScreenshot()

'Log in '
functions.I.Login_password('blemco', password_blemco)

WebUI.delay(1)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///////////////////////////////// CREATION OF PROJECT  ////////////////////////////////////////////
'click on + button to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

'Screenshot: Project form'
WebUI.takeScreenshot()

'Select Project type from List(Button): Tier 2'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="field_var_24"]/div/div/label[2]']))

'Select APL requirement : One APL for eah Deliverable'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_89"]']), 
    '123', false)

'Select Creative Services : Brinan Lemco'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_25"]']), 
    'modonnell', false)

functions.I.select_multiplelist('//*[@id="selSource_25"]', '//*[@id="btnAdd_25"]', 'blemco')

'Brand Haagen-Dazs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_9"]']), 
    '18', false)

'Year : 2026'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_52"]']), 
    '112', false)

'Project Name Extention : Project name'
def project_name = (('TC406.01_Auto_PartialSubmission' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) + 
'_') + functions.I.gettimedate()

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_91"]']), 
    project_name)

'Separator : GPI'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_30"]']), 
    '97', false)

'Production Agency : GRO'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_11"]']), 
    '334', false)

'RTS – release SeparatorL 09/13/2022'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_22"]']), 
    '01/01/2030')

'FTP – Files to printerL 8/25/2022'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_23"]']), 
    '01/01/2030')

'Due in plant date : 10/06/2022'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_14"]']), 
    '01/01/2030')

'Marketing : Margaret Baugman & rachel jaiven'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_13"]']), 
    'mbaughman', false)

functions.I.select_multiplelist('//*[@id="selSource_13"]', '//*[@id="btnAdd_13"]', 'rjaiven')

'Regulatory : Ana Massoth/ Nicole Turner'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_27"]']), 
    'amassoth', false)

functions.I.select_multiplelist('//*[@id="selSource_27"]', '//*[@id="btnAdd_27"]', 'nturner')

'Legal(Artwork) : Lancaster Mary'
functions.I.select_multiplelist('//*[@id="selSource_167"]', '//*[@id="btnAdd_167"]', 'lmary')

'Legal(APL) : Barry Banjamin / Luisa Schwabe'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_166"]']), 
    'bbenjamin', false)

functions.I.select_multiplelist('//*[@id="selSource_166"]', '//*[@id="btnAdd_166"]', 'lschwabe')

'Consumer Affairs : Tatina alexeeva'
functions.I.select_multiplelist('//*[@id="selSource_26"]', '//*[@id="btnAdd_26"]', 'talexeeva')

'Tech Packagin :Bob harandi / bayete / jocelyn ferer'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_29"]']), 
    'bharandi', false)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_29"]']), 
    'bmilhomme', false)

functions.I.select_multiplelist('//*[@id="selSource_29"]', '//*[@id="btnAdd_29"]', 'rmorrone_2')

functions.I.Pagedown()

WebUI.delay(10)

'Click on Modify this Project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

String Project_No = functions.I.ProjectNo()

'Screenshot: Ref list page'
WebUI.takeScreenshot()

///////////////////////////////////////////////////////CREATION OF MOTHER REF /////////////////////////////
'Click on + to create MOTHER ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click start a design phase button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

'Select Lifecycle: [Do not Edit 2] Mother ref  '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '32', false)

'Enter the Mother ref  name'
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5) + '_Auto_A4B_') + functions.I.gettimedate()

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_name"]']), 
    ref_name)

'Screenshot: CREATION ref page'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

'Screenshot: Modif ref page'
WebUI.takeScreenshot()

WebUI.delay(1)

String refID_Mother = functions.I.RefID()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

'Logout'
functions.I.Logout()

///////////////////////////////////////////PART 1/3 To submit
'Login as nicole turner'
functions.I.Login_password('nturner', password_nturner)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search Project'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Screenshot: Ref List page  '
WebUI.takeScreenshot()

'Click on proceed to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' +
			refID_Mother) + '"]/td[13]/a[2]']))


'Click on proceed '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="ModifFiche"]/div[1]/div/button[2]')]))

'Screenshot: Ref List page  '
WebUI.takeScreenshot()

'Verify Lifecycle status'
String L1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_'+refID_Mother+'"]/td[12]/span[1]')]))

WebUI.verifyMatch(L1, 'Mother Phase 1.1', false)

'Logout'
functions.I.Logout()

///////////////////////////////////////////PART 2/3 To submit
'Login as Tatina Alexeeva'
functions.I.Login_password('talexeeva', password_talexeeva)

'Click on the LHS menu'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search Project'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="form_filters"]/div[4]/button')]))

'Screenshot: Ref List page  '
WebUI.takeScreenshot()

'Click on proceed to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' +
			refID_Mother) + '"]/td[13]/a[2]']))


'Click on proceed '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="ModifFiche"]/div[1]/div/button[2]')]))

'Screenshot: Ref List page  '
WebUI.takeScreenshot()

'Verify Lifecycle status'
String L2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_'+refID_Mother+'"]/td[12]/span[1]')]))

WebUI.verifyMatch(L2, 'Mother Phase 1.1', false)

'Logout'
functions.I.Logout()

///////////////////////////////////////////PART 3/3 To submit
'Login as mbaughman'
functions.I.Login_password('mbaughman', password_mbaughman)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search Project'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="form_filters"]/div[4]/button')]))
 
'Screenshot: Ref List page  '
WebUI.takeScreenshot()

'Click on proceed to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' +
			refID_Mother) + '"]/td[14]/a[2]']))

'Click on proceed '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="ModifFiche"]/div[1]/div/button[2]')]))

'Screenshot: Ref List page  '
WebUI.takeScreenshot()

'Verify Lifecycle status'
String L3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_'+refID_Mother+'"]/td[12]/span[1]')]))

WebUI.verifyMatch(L3, 'Mother Phase 2.1', false)

WebUI.closeBrowser()