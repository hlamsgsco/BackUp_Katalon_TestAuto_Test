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

/* Powerpoint S4: ADD STEP (contains one step)
 Ongoing reference: Phase 1 (no last phase) of Step A
 
 Support action used: S4 - Skip 1.2 / Add Step A / Skip 1.1
 
 Phase: Phase : Step A  > Phase 1.1
 
 Ongoing reference: Phase 1 (no last phase) of Step A
 Support actions shortcut:
 Skip to last phase of the current step
 Add step (same step as the current one)
 Skip until one of the phases inside the ‘Step’ added
 
 Expected: Skip to the next phase as defined in the SAS + add a new step after the current step + skip until the phase defined in the SAS
 
 
  */
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')

String password_blemco = data_Dreyers.getValue(2, 2) //R
String password_nturner = data_Dreyers.getValue(2, 6) //R

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

//CLEAR NOTEPAD 11.01 TO USE IN TC 11.02/ 11.03/ 11.04
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_ProjectNo.txt')
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_refID.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
'Navigate to URL Dreyers Release'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

//////////////////////////////// NAVIGATING TO DREYERS  ////////////////////////////////////////////
'Log in as blemco'
functions.I.Login_password('blemco', password_blemco)

'Screenshot: Login as blemco'
WebUI.takeScreenshot()

'Click on the LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///////////////////////////////// CREATION OF PROJECT  ////////////////////////////////////////////
'Click on + button to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

'Screenshot: Project form'
WebUI.takeScreenshot()

'Select Project type from List(Button): Tier 2'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="field_var_24"]/div/div/label[2]']))

'Select APL requirement : One APL for eah Deliverable'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_89"]']), '123', false)

'Select Creative Services : Brinan Lemco'
functions.I.select_multiplelist('//*[@id="selSource_25"]', '//*[@id="btnAdd_25"]', 'blemco')

'Brand Haagen-Dazs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_9"]']), '18', false)

'Year : 2025'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_52"]']), '111', false)

'Project Name Extention : Project name'
def project_name = (('Auto_SAS_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) + '_') + functions.I.gettimedate()

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
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_13"]']), 'mbaughman', 
    false)

functions.I.select_multiplelist('//*[@id="selSource_13"]', '//*[@id="btnAdd_13"]', 'rjaiven')

'Regulatory : Ana Massoth/ Nicole Turner'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_27"]']), 'amassoth', 
    false)

functions.I.select_multiplelist('//*[@id="selSource_27"]', '//*[@id="btnAdd_27"]', 'nturner')

'Legal(Artwork) : Lancaster Mary'
functions.I.select_multiplelist('//*[@id="selSource_167"]', '//*[@id="btnAdd_167"]', 'lmary')

'Legal(APL) : Barry Banjamin / Luisa Schwabe'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_166"]']), 'bbenjamin', 
    false)

functions.I.select_multiplelist('//*[@id="selSource_166"]', '//*[@id="btnAdd_166"]', 'lschwabe')

'Consumer Affairs : Tatina alexeeva'
functions.I.select_multiplelist('//*[@id="selSource_26"]', '//*[@id="btnAdd_26"]', 'talexeeva')

'Tech Packagin :Bob harandi / bayete / jocelyn ferer'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_29"]']), 'bharandi', 
    false)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_29"]']), 'bmilhomme', 
    false)

functions.I.select_multiplelist('//*[@id="selSource_29"]', '//*[@id="btnAdd_29"]', 'rmorrone_2')

functions.I.Pagedown()

'Screenshot: Project form filled'
WebUI.takeScreenshot()

WebUI.delay(6)

'Click on Modify this Project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(2)

'Get Project No.'
String Project_No = functions.I.ProjectNo()

'Screenshot: Ref list page'
WebUI.takeScreenshot()

///////////////////////////////// CREATION OF MOTHER REFERENCE  ////////////////////////////////////////////
'Click on + to create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click start a design phase button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))


'Select Lifecycle'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), '36', false)

'Set Ref Name'
def ref_name = ('P1_Auto_SAS_S4_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)) + functions.I.gettimedate()


WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_name"]']), ref_name)


'Screenshot: create ref page'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="createRefBottom"]']))

WebUI.delay(1)

'Screenshot: Ref Form page'
WebUI.takeScreenshot()

'Get refiD '
String refID = functions.I.RefID()


'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

'Screenshot: Ref List page'
WebUI.takeScreenshot()


//SAS SUPPORT ACTION S4 - 1ST OPTION
'Click on the SAS button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/div[1]/button']))

WebUI.delay(1)

'Screenshot: SAS option'
WebUI.takeScreenshot()

WebUI.delay(1)

//CLCICK ON THE SAS WITH THE LABEL
'no of option present '
int x = 20
int i = 1

while ( i <=x)
{
	String Expected_SAS_Selected = 'SAS: S4 - Skip 1.2 / Add Step A / Skip 1.1'
		String xpath_SAS ='//*[@id="source_' + refID + '"]/td[13]/div[1]/div/a['+i+']'
	
	
	String Actual_SAS = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))

	
	if (Actual_SAS.contains(Expected_SAS_Selected))
	{
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))

			break
		}
		i =i+1
	}

'Screenshot: SAS popup'
WebUI.takeScreenshot()

'click on ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="confirmSupportActionShortcut"]']))

'Screenshot: Brief tab Page'
WebUI.takeScreenshot()


'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))



'Screenshot: Lifecycle tab'
WebUI.takeScreenshot()

WebUI.delay(1)

//Class of Step A in the 1ST Position - COMPLETED
'Verify if the Step A in the 1st position is Complete'
String Status_StepA_1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a']), 
    'class')
WebUI.verifyMatch(Status_StepA_1, 'nav-link timeline-badge badge-xl  bg-complete ', false)

//Name of Step A
'Verify the Name of the 1st Step A '
String Name_StepA_1 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a')
WebUI.verifyMatch(Name_StepA_1, 'SASStepA', false)

//Class of Step A in the 2ND Position - ADDED & ACTIVE 
'Verify if the Step A in the 2nd position is Active'
String Status_StepA_2 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a']), 
    'class')
WebUI.verifyMatch(Status_StepA_2, 'nav-link timeline-badge badge-xl  bg-pending active', false)


//Name of Step A
'Verify the Name of the 2nd Step A'
String Name_StepA_2 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a')
WebUI.verifyMatch(Name_StepA_2, 'SASStepA', false)

//ADDED STEP A PHASE 1.1 - ACTIVE
'Verify the Name of the ADDED pahse 1.1 '
String Name_StepAP11_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/div[1]/h3']))
WebUI.verifyMatch(Name_StepAP11_2, 'Phase 1.1 [Standard]', false)


'Verify that Added is displayed in the Step A - Phase 1.1'
String Added_StepAP11_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/h6']))

if (Added_StepAP11_2.contains('Added manually'))
 {WebUI.verifyEqual(1, 1)}
else {WebUI.verifyEqual(1, 2)}


//Added Phase 1.2
'Verify the Name of the ADDED phase 1.2 '
String Name_StepAP12_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/h3']))
WebUI.verifyMatch(Name_StepAP12_2, 'Phase 1.2 [Standard Phase]', false)


//3rd Step B - WAITING
'Verify if the Step B in the 3rd position is Waiting'
String Status_StepB_3 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']),
	'class')
WebUI.verifyMatch(Status_StepB_3, 'nav-link timeline-badge badge-xl  bg-waiting ', false)

//Name of Step B
'Verify the Name of the 3rd Step B'
String Name_StepB_3 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a')
WebUI.verifyMatch(Name_StepB_3, 'SASStepB', false)

'Go the ref list page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[2]/div/nav/ol/li[2]/a']))

'Screenshot: Ref List Page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[13]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Logout'
functions.I.Logout()

//SUBMIT THE PHASE THAT HAVE BEEN ADDED
'Login as nturner '
functions.I.Login_password('nturner', password_nturner)

WebUI.delay(1)

'Screenshot: Login as nturner'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[13]/a[2]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify lifecycle status'
String Lifecycle_Status = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[12]/span[1]']))
WebUI.verifyMatch(Lifecycle_Status, 'Phase 2.1 [Production]', false)


'Screenshot: Ref list page'
WebUI.takeScreenshot()

//CLEAR NOTEPAD 11.01 TO USE IN TC 11.02/ 11.03/ 11.04
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_ProjectNo.txt', Project_No)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_refID.txt', refID)

'Close Browser'
WebUI.closeBrowser()