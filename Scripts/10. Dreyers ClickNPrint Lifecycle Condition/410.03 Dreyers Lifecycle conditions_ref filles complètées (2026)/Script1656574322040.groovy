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

///////////////////////////////// NAVIGATING TO DREYERS  ////////////////////////////////////////////
'Screenshot: Navigate to URL Dreyer Release'
WebUI.takeScreenshot()

'Log in '
functions.I.Login_password('blemco', password_blemco)

WebUI.delay(1)

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
def project_name = (('Auto_LifecycleCondition_Backup_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) + 
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
functions.I.print (Project_No)

'Screenshot: Ref list page'
WebUI.takeScreenshot()


///////////////////////////////////////////////////////CREATION OF MOTHER REF /////////////////////////////

'Click on + to create MOTHER ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click start a design phase button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

'Select Lifecycle: [Do not Edit] Mother ref  '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']),
	 '28', false)

'Enterthe Mother ref  name'
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5) + '_Auto_A4A_') + functions.I.gettimedate()


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

functions.I.print(refID_Mother)

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))



///////////////////////////////////////////////CREATION OF DAUGHTER 1 - Deliverable

'Click on + TO CREATE daughter 1 '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID_Mother+'"]/td[13]/a[1]']))

'Select Lifecycle: [Do not Edit] Daughter ref  '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']),
	 '29', false)

'Screenshot: creation of daughter 1'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))


String refID_Daughter1 = functions.I.RefID()
functions.I.print(refID_Daughter1)

'Enter Deliverable name: '
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_137"]']), 'Daughter 1')

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))


WebUI.delay(1)

'Screenshot: Ref List page creation of daughter 1'
WebUI.takeScreenshot()



///////////////////////////////////////////////CREATION OF DAUGHTER 2 - Deliverable
'Click on + TO CREATE daughter 2 '
//*[@id="source_2425"]/td[15]/a[1]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID_Mother+'"]/td[15]/a[1]']))

'Select Lifecycle: [Do not Edit] Daughter ref  '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']),
	 '29', false)

'Screenshot: creation of daughter 2'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))


String refID_Daughter2 = functions.I.RefID()
functions.I.print(refID_Daughter2)

'Enter Deliverable name: '
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_137"]']), 'Daughter 2')

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))


WebUI.delay(1)

'Screenshot: Ref List page creation of daughter 2'
WebUI.takeScreenshot()




//////////////////////////////////////////////////Daughter 1 
///////////////////////////////////////////////CREATION OF Grand DAUGHTER 1  - LABEL INFO

'Click on + TO CREATE grand daughter 1 '
//*[@id="source_2426"]/td[15]/div[1]/button
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID_Daughter1+'"]/td[15]/div[1]/button']))

WebUI.delay(2)

'Click on create Lable Information '
//*[@id="source_2426"]/td[15]/div[1]/div/a[2]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID_Daughter1+'"]/td[15]/div[1]/div/a[2]']))


'Select Lifecycle: [Do not edit] Grand Daughter 1 (Label)  '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']),
	 '30', false)

'Screenshot: creation of grand daughter 1'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))


String refID_GrandDaughter1 = functions.I.RefID()
functions.I.print(refID_GrandDaughter1)

'Enter Deliverable name: Grand Daughter 1'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_137"]']), 'Grand Daughter 1')

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

WebUI.delay(1)

'Screenshot: Ref List page creation of Grand daughter 1'
WebUI.takeScreenshot()

WebUI.delay(1)

///////////////////////////////////////////////CREATION OF Grand DAUGHTER 2  - APL

'Click on + TO CREATE grand daughter 2 '
//*[@id="ancre_2427"]/a[1]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_'+ refID_Daughter2+'"]/a[1]']))

WebUI.delay(2)

'Select Lifecycle: [Do not edit] Grand Daughter 2 (APL)  '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']),
	 '31', false)

'Screenshot: creation of grand daughter 2'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))


String refID_GrandDaughter2 = functions.I.RefID()
functions.I.print(refID_GrandDaughter2)

'Enter Deliverable name: Grand Daughter 2'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_137"]']), 'Grand Daughter 2')

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))


'Screenshot: Ref List page creation of Granddaughter 2'
WebUI.takeScreenshot()

WebUI.delay(1)



//////////////////////////////////////////////////Daughter 2
///////////////////////////////////////////////CREATION OF Grand DAUGHTER 3  - LABEL INFO

'Click on + TO CREATE grand daughter 3 '
//*[@id="source_2427"]/td[17]/div[1]/button
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID_Daughter2+'"]/td[17]/div[1]/button']))

WebUI.delay(2)

'Click on create Lable Information '
//*[@id="source_2427"]/td[17]/div[1]/div/a[2]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID_Daughter2+'"]/td[17]/div[1]/div/a[2]']))


'Select Lifecycle: [Do not edit] Grand Daughter 3 (Label)  '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']),
	 '30', false)

'Screenshot: creation of grand daughter 3'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))


String refID_GrandDaughter3 = functions.I.RefID()
functions.I.print(refID_GrandDaughter3)

'Enter Deliverable name: Grand Daughter 3'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_137"]']), 'Grand Daughter 3')

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

WebUI.delay(1)

'Screenshot: Ref List page creation of Grand daughter 3'
WebUI.takeScreenshot()

WebUI.delay(1)



///////////////////////////////////////////////CREATION OF Grand DAUGHTER 4  - APL

'Click on + TO CREATE grand daughter4 '
//*[@id="source_2427"]/td[17]/a[1]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+ refID_Daughter2+'"]/td[17]/a[1]']))

WebUI.delay(2)

'Select Lifecycle: [Do not edit] Grand Daughter 4 (APL)  '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']),
	 '31', false)

'Screenshot: creation of grand daughter 4'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))


String refID_GrandDaughter4 = functions.I.RefID()
functions.I.print(refID_GrandDaughter4)

'Enter Deliverable name: Grand Daughter 4'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_137"]']), 'Grand Daughter 4')

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))


'Screenshot: Ref List page creation of Granddaughter 4'
WebUI.takeScreenshot()

WebUI.delay(1)



///////////////////////////////////////////////Submit Phase 1 for Grand daughter 1//////////////////////////////
'Click on submit'
//*[@id="ancre_2427"]/a[2]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_'+ refID_Daughter2+ '"]/a[2]']))


'Screenshot: Ref modif page GD1:  Submit next phase '
WebUI.takeScreenshot()

'Click on submit next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))


'Screenshot: Ref List page Lifecycle Status  GD1:  GD1 Phase 2.1 '
WebUI.takeScreenshot()


WebUI.delay(1)

'Verify the lifecycle status of the granddaughter ref 1'
String Actual_Lifecycle1_GD1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+  refID_GrandDaughter1+'"]/td[16]/span[1]']))

WebUI.verifyMatch(Actual_Lifecycle1_GD1, 'GD1 Phase 2.1', false)

///////////////////////////////////////////////Submit Phase 1 for Grand daughter 2//////////////////////////////
'Click on submit'
//*[@id="ancre_2431"]/a[2]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_'+ refID_GrandDaughter3+ '"]/a[2]']))


'Screenshot: Ref modif page GD1:  Submit next phase '
WebUI.takeScreenshot()

'Click on submit next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))
 
WebUI.delay(1)

'Verify the lifecycle status of the granddaughter ref 2'
//*[@id="source_2430"]/td[16]/span[1]
String Actual_Lifecycle1_GD2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+  refID_GrandDaughter2+'"]/td[16]/span[1]']))

WebUI.verifyMatch(Actual_Lifecycle1_GD2, 'GD2 Phase 2.1', false)


'Screenshot: Ref List page '
WebUI.takeScreenshot() 

///////////////////////////////////////////////Submit Phase 2.1 for Grand daughter 1//////////////////////////////
'Click on submit'
//*[@id="ancre_2427"]/a[2]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_'+ refID_Daughter2+ '"]/a[2]']))


'Screenshot: Ref modif page GD1:  Submit next phase '
WebUI.takeScreenshot()

'Click on submit next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))


'Screenshot: Ref List page '
WebUI.takeScreenshot()

WebUI.delay(1)


'Verify the lifecycle status for Granddaughter 1 - Complete'
//*[@id="source_2429"]/td[16]/span
String Actual_Lifecycle2_GD1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+  refID_GrandDaughter1+'"]/td[16]/span']))
 
 WebUI.verifyMatch(Actual_Lifecycle2_GD1, 'Complete', false)

'Verify the lifecycle status for Daughter 1: Daughter Phase 1.1'
//*[@id="source_2426"]/td[16]/span[1]
String Actual_Lifecycle1_D1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+  refID_Daughter1+'"]/td[16]/span[1]']))
 
 WebUI.verifyMatch(Actual_Lifecycle1_D1, 'Daughter Phase 1.1', false)

'Verify the lifecycle status for Daughter 2: Daughter Phase 1.1'
//*[@id="source_2427"]/td[16]/span[1]
String Actual_Lifecycle1_D2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+  refID_Daughter2+'"]/td[16]/span[1]']))
 
 WebUI.verifyMatch(Actual_Lifecycle1_D2, 'Daughter Phase 1.1', false)

///////////////////////////////////////////////Submit Phase 2.1 for Grand daughter 2//////////////////////////////
'Click on submit'
//*[@id="ancre_2431"]/a[2]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_'+ refID_GrandDaughter3 + '"]/a[2]']))


'Screenshot: Ref modif page GD2:  Submit next phase '
WebUI.takeScreenshot()

'Click on submit next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Screenshot: Ref List page '
WebUI.takeScreenshot()


'Verify the lifecycle status for Granddaughter 1 - Complete'
//*[@id="source_2429"]/td[16]/span
String Actual_Lifecycle2_GD11 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+  refID_GrandDaughter1+'"]/td[16]/span']))
 
 WebUI.verifyMatch(Actual_Lifecycle2_GD11, 'Complete', false)

'Verify the lifecycle status for Daughter 1: Daughter Phase 2.1'
//*[@id="source_2426"]/td[16]/span[1]
String Actual_Lifecycle1_D12 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+  refID_Daughter1+'"]/td[16]/span[1]']))
 
 WebUI.verifyMatch(Actual_Lifecycle1_D12, 'Daughter Phase 2.1', false)

'Verify the lifecycle status for Daughter 2: Daughter Phase 1.1'
//*[@id="source_2427"]/td[16]/span[1]
String Actual_Lifecycle1_D22 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+  refID_Daughter2+'"]/td[16]/span[1]']))
 
 WebUI.verifyMatch(Actual_Lifecycle1_D22, 'Daughter Phase 1.1', false)

'Screenshot: Ref List page '
WebUI.takeScreenshot()

////////////////////////////////////////////////DAUGHTER 1 Submit
'Click on submit'
//*[@id="ancre_2430"]/a[2]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_'+ refID_GrandDaughter2 + '"]/a[2]']))


'Screenshot: Ref modif page GD2:  Submit next phase '
WebUI.takeScreenshot()

'Click on submit next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Screenshot: Ref List page '
WebUI.takeScreenshot()

'Verify the lifecycle status for Daughter 1: Complete'
String Actual_Lifecycle_D1_Complete = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+  refID_Daughter1+'"]/td[16]/span']))
 
 WebUI.verifyMatch(Actual_Lifecycle_D1_Complete, 'Complete', false)

WebUI.closeBrowser()