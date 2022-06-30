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
String password_blemco = data_Dreyers.getValue(2, 2)

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
'Screenshot: Navigate to URL Dreyer'
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

'Year : 2025'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_52"]']), 
    '111', false)

'Project Name Extention : Project name'
def project_name = (('TC407.01_Auto_LifecycleCondition_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) + 
'_') + functions.I.gettimedate()

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_91"]']), 
    project_name)

'21 Separator : GPI'
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

'Click on Modify this Project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(10)

String Project_No = functions.I.ProjectNo()

'Screenshot: Ref list page'
WebUI.takeScreenshot()

///////////////////////////////////////////////////////CREATION OF MOTHER REF /////////////////////////////
'Click on + to create MOTHER ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click start a design phase button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

'Select Lifecycle: [Do not Edit ] Mass submit Mother ref  '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '34', false)

'Enter the Mother ref  name'
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5) + '_Auto_A4B_MS_') + functions.I.gettimedate()

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

///////////////////////////////////////////////CREATION OF DAUGHTER 1 - APL
'Click on + TO CREATE daughter 1 '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID_Mother) + '"]/td[13]/a[1]']))

'Select Lifecycle: [Do not Edit] Mass Submit Daughter ref  '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '35', false)

'Screenshot: creation of daughter 1'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

String refID_Daughter1 = functions.I.RefID()

'Enter Deliverable name: '
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_137"]']), 
    'Daughter 1 MS')

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

WebUI.delay(1)

'Screenshot: Ref List page creation of daughter 1'
WebUI.takeScreenshot()

////////////////////////////////////////////Mass Submit //////////////////////////////
//////////////////1 option only //////////////////////////
'Hover over tooltip'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnMassSubmit"]']))

WebUI.delay(2)


String A_tooltip = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

'Verify tooltip'
WebUI.verifyMatch(A_tooltip, 'Test (1option)', false)

'Click Mass Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnMassSubmit"]/i']))

WebUI.delay(1)

'Check box 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID_Mother) + '"]/td[1]/label']))

'Click on Confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

WebUI.delay(1)

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify  msg'
String Amsg = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table/tbody/tr']))

WebUI.verifyMatch(Amsg, ref_name + ' Conditions not met: the condition LC3: Deliverable - Phase REview is not met', false)

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[2]/div[2]/div/button[1]']))

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Verify lifecycle status'
String L1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID_Mother) + '"]/td[14]/span[1]']))

WebUI.verifyMatch(L1, 'Mother Phase 1.1', false)

////////////////////////////////////////////SUBMIT DAUGHTER REF
'Uncheck mother ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID_Mother) + '"]/td[1]/label']))

'Check daughter ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID_Daughter1) + '"]/td[1]/label']))

'Click on Confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

WebUI.delay(1)

WebUI.takeScreenshot()

'Click submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

//////////////////////////////VERIFY MOTHER REF//////////////////////////////
'Screenshot: ref list page'
WebUI.takeScreenshot()

WebUI.delay(1)

'perform mass submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnMassSubmit"]/i']))

'Check box 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID_Mother) + '"]/td[1]/label']))

'Click on Confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

WebUI.delay(1)

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify  msg'
String Amsg_1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentOK"]/table/tbody/tr']))

WebUI.verifyMatch(Amsg_1, ref_name + ' Mother Phase 2.1', false)

'Click submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

////////////////////////////////////////////SUBMIT DAUGHTER 1.1  
'Screenshot: ref list page'
WebUI.takeScreenshot()

////////////////////////////MOTHER REF 
'Verify lifecycle status is Mother Phase 2.1'
String ALM1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID_Mother) + '"]/td[14]/span[1]']))

WebUI.verifyMatch(ALM1, 'Mother Phase 2.1', false)

////////////////////////////////////////////SUBMIT Mother ref & DAughter is submitted automatically

'Verify Daughter lifecycle status is Complete'
String ALD1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID_Daughter1) + '"]/td[14]/span']))

WebUI.verifyMatch(ALD1, 'Complete', false)

WebUI.closeBrowser()

