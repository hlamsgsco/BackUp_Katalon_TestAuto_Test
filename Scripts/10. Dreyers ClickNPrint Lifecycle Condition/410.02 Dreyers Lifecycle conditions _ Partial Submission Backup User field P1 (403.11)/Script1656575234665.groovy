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

//DATA FILE : USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')
String password_blemco = data_Dreyers.getValue(2, 2)


//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

// NOTEPAD CLEAR
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_ProjectNo.txt')
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_Deliverable(D).txt')
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_Design(M).txt')
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_APL(GD).txt')
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_LI(GD).txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Dreyers'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

'Screenshot: Navigate to URL Dreyer Release'
WebUI.takeScreenshot()

'Log in blemco'
functions.I.Login_password('blemco', password_blemco)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///////////////////////////////// CREATION OF PROJECT  ////////////////////////////////////////////
'click on + button to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

'Screenshot: Project form'
WebUI.takeScreenshot()

'Select Project type from List(Button): Tier 2'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="field_var_24"]/div/div/label[2]']))

'Select APL requirement : One APL for eah Deliverable'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_89"]']), '123', false)

'Select Creative Services : Brinan Lemco'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_25"]']), 'modonnell', false)

functions.I.select_multiplelist('//*[@id="selSource_25"]', '//*[@id="btnAdd_25"]', 'blemco')

'Brand Haagen-Dazs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_9"]']), '18', false)

'Year : 2021'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_52"]']), '108', false)

'Project Name Extention : Project name'
def project_name = (('TC410.02_Auto_LifecycleCondition_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) + 
'_') + functions.I.gettimedate()

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_91"]']), project_name)

'21 Separator : GPI'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_30"]']), '97', false)

'Production Agency : GRO'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_11"]']), '334', false)

'RTS – release SeparatorL 09/13/2022'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_22"]']), '01/01/2030')

'FTP – Files to printerL 8/25/2022'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_23"]']), '01/01/2030')

'Due in plant date : 10/06/2022'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_14"]']), '01/01/2030')

'Marketing : Margaret Baugman & rachel jaiven'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_13"]']), 'mbaughman', false)

functions.I.select_multiplelist('//*[@id="selSource_13"]', '//*[@id="btnAdd_13"]', 'rjaiven')

'Regulatory : Ana Massoth/ Nicole Turner'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_27"]']), 'amassoth', false)

functions.I.select_multiplelist('//*[@id="selSource_27"]', '//*[@id="btnAdd_27"]', 'nturner')

'Legal(Artwork) : Lancaster Mary'
functions.I.select_multiplelist('//*[@id="selSource_167"]', '//*[@id="btnAdd_167"]', 'lmary')

'Legal(APL) : Barry Banjamin / Luisa Schwabe'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_166"]']), 'bbenjamin', false)

functions.I.select_multiplelist('//*[@id="selSource_166"]', '//*[@id="btnAdd_166"]', 'lschwabe')

'Consumer Affairs : Tatina alexeeva'
functions.I.select_multiplelist('//*[@id="selSource_26"]', '//*[@id="btnAdd_26"]', 'talexeeva')

'Tech Packagin :Bob harandi / bayete / jocelyn ferer'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_29"]']), 'bharandi', false)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_29"]']), 'bmilhomme', false)

functions.I.select_multiplelist('//*[@id="selSource_29"]', '//*[@id="btnAdd_29"]', 'rmorrone_2')

functions.I.Pagedown()

'Click on Modify this Project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(10)

String Project_No = functions.I.ProjectNo()

'Screenshot: Ref list page'
WebUI.takeScreenshot()

///////////////////////////////// CREATION OF MOTHER REFERENCE  ////////////////////////////////////////////
'Click on + to create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click start a design phase button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

'Click on Deliverable name'
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5) + '_Auto_') + functions.I.gettimedate()

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_name"]']), ref_name)

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[2]/div[2]/div/button']))

'Screenshot: Lifecycle complete'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[6]/a']))

'get refiD '
String refID = functions.I.RefID()

String refID_daughter1 = Integer.parseInt(refID) + 1

String refID_LI = Integer.parseInt(refID) + 2

String refID_APL = Integer.parseInt(refID) + 3

'Click on fils dariane'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

'Verify that lifecycle is complete'
String lifecyclestatus1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + 
            '"]/td[12]/span']))

WebUI.verifyMatch(lifecyclestatus1, 'Complete', false)

//////////////////////////////CREATION OF DAUGHTER REF  1 ////////////////////////////////////
'Click on + to create daughter'
WebUI.click(findTestObject('TAG/id_refid_td13_a', [('refID') : 'source_' + refID]))

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

WebUI.delay(3)

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_daughter1) + '"]/td[15]/a[2]']))

'Screenshot: Ref list page> Daughter ref created'
WebUI.takeScreenshot()

///////////////////////////	MODIFICATION OF DAUGHER 1 ///////////////////////
WebUI.delay(1)

'Enter text: Deliverable name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_137"]']), 'Auto_Daughter_1')

'Click on Label Information Required? yes'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="field_var_90"]/div/div/label[1]']))

'Click 3D Required? yes'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="field_var_155"]/div/div/label[1]']))

'Subbrand: candy'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_15"]']), '77', false)

'Packaging size:1.5Oz '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_17"]']), '153', false)

'Package Type: Club'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_106"]']), '145', false)

'Click on proceed to next phase'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

///////////////////////////	DAughter : Phase 2 : Waiting for APL & LI ///////////////////////
//////////////////////////ERROR MSG as DAUGHTER REF NOT COMPLETED  - PART 1 ////////////////////////
'Screenshot: 2  DAughter refs created'
WebUI.takeScreenshot()

'Verify that lifecycle is Waiting for APL and LI'
String lifecyclestatus2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_daughter1) + 
            '"]/td[16]/span[1]']))

WebUI.verifyMatch(lifecyclestatus2, 'Waiting for APL and LI', false)

WebUI.delay(1)

//////////////////////////LIFECYCLE CONDITION - ERROR MSG 1 ///////////////////////
'Daughter ref  : Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="ancre_' + refID_APL) + '"]/a']))

'toastr: The condition Label Information Complete is not matched'
String toastr1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

WebUI.verifyMatch(toastr1, 'The condition \'Label Information Complete\' is not matched', false)

'Screenshot: Toastr for lifecyclecondition '
WebUI.takeScreenshot()

'Verify that lifecycle is still Waiting for APL and LI'
String lifecyclestatus3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_daughter1) + 
            '"]/td[16]/span[1]']))

WebUI.verifyMatch(lifecyclestatus3, 'Waiting for APL and LI', false)

'Click on proceed to next phasse'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[17]/a[2]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify the lifecycle of daughter ref'
String lifecyclestatus4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_daughter1) + 
            '"]/td[16]/span[1]']))

'verify match'
WebUI.verifyMatch(lifecyclestatus4, 'Artwork Upload', false)

'Verify the lifecycle of granddaughter ref'
String lifecyclestatus5 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + 
            '"]/td[16]/span[1]']))

WebUI.verifyMatch(lifecyclestatus5, 'Complete', false)


//WRITE NOTEPAD
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_ProjectNo.txt', Project_No)
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_Deliverable(D).txt', refID_daughter1)
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_Design(M).txt', refID)
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_APL(GD).txt', refID_APL)
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_LI(GD).txt', refID_LI)

WebUI.closeBrowser()

