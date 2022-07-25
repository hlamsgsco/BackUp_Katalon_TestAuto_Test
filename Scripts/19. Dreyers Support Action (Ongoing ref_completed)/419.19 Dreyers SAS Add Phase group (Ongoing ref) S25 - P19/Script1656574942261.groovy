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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

/* Powerpoint S25: ADD PHASE GROUP
 Ongoing reference: Phase 1 (no last phase) of the Step A
 Add phase group (phase group belonging to the current step)
 Skip until one of the phases inside the new ‘phase group’
 Result: phase group is added in current step just after the phase where we launched the SAS, skip works correctly OK
 
 Lifecycle: Support Action P2 > Step A  > Phase 1.1
 Support action : S25 : Add PG Step A/ Skip Phase 1.1
  */

///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')
String password_blemco = data_Dreyers.getValue(2, 2) //R
String password_lmary = data_Dreyers.getValue(2, 13) //R

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

//READ NOTEPAD FROM TC 19.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_refID.txt')
//String refID19 = '3759'

///////////////////////////// TEST BEGIN /////////////////////////////////////////
'Navigate to URL Dreyers'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

'Log in as blemco'
functions.I.Login_password('blemco', password_blemco)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: blemco - Ref list page'
WebUI.takeScreenshot()

//CREATE A NEW REF
'Click on + to create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

'Click start a design phase button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

WebUI.delay(1)

'Select Lifecycle'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), '37', false)

'settext Deliverable name'
def ref_name = ('P19_Auto_SAS_S25_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)) + functions.I.gettimedate()

WebUI.delay(1)

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_name"]']), ref_name)

'Screenshot: create ref page'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="createRefBottom"]']))

WebUI.delay(1)

'Screenshot: Ref Form page'
WebUI.takeScreenshot()

'get refiD '
String refID19 = functions.I.RefID()

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

//PHASE 1.1
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

functions.I.SearchRefNo_xpath('P19_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID19+'"]/td[6]/a']))
 
WebUI.delay(1)

'Click Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: Lifecycle tab page'
WebUI.takeScreenshot()

WebUI.delay(1)

//3rd option SAS 25
'Click on SAS buton'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[1]/div[2]/div/button']))
WebUI.delay(1)

//CLCICK ON THE SAS WITH THE LABEL
'no of option present '
int x = 3
int i = 1

while ( i <=x)
{
	String Expected_SAS_Selected = 'S25 : Add PG Step A/ Skip Phase 1.1'
	String xpath_SAS ='/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[1]/div[2]/div/div/a['+i+']'
	
	
	String Actual_SAS = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))
	functions.I.print(i)
	
	if (Actual_SAS.contains(Expected_SAS_Selected))
	{
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))
		
		break
		}
		i =i+1
	}
	
/*
'Click 3rd option on SAS 25 buton'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[1]/div/div[1]/div[2]/div/div/a[3]']))

WebUI.delay(1)
*/
'Screenshot: SAS popup'
WebUI.takeScreenshot()

WebUI.delay(1)

'click on ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="confirmSupportActionShortcut"]']))

'Click Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: Lifecycle tab page'
WebUI.takeScreenshot()

//1st phase Step A - Added and active
'Verify that attribute of step A - active'
String StepA_1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a']),
	'class')
WebUI.verifyMatch(StepA_1, 'nav-link timeline-badge badge-xl  bg-pending active', false)

String StepA11= functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a')
WebUI.verifyMatch(StepA11, 'SASStepA', false)

//Added Phase 1.1
String Name_StepAP1_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/h3']))
WebUI.verifyMatch(Name_StepAP1_2, 'Phase 1.1 [Standard]', false)

String ST_StepAP1_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[3]/div/div[2]/div[1]']))

if (ST_StepAP1_2.contains('Started'))
 {WebUI.verifyEqual(1, 1)}
else {WebUI.verifyEqual(1, 2)}

String added_StepAP1_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[3]/div/div[2]/h6']))

if (added_StepAP1_2.contains('Added manually'))
 {WebUI.verifyEqual(1, 1)}
else {WebUI.verifyEqual(1, 2)}

//Added Phase 1.2
String Name_StepAP2_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[3]/div/div[1]/div[1]/h3']))
WebUI.verifyMatch(Name_StepAP2_2, 'Phase 1.2 [Standard Phase]', false)

//Phase 1.2
String Name_StepAP2_3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[4]/div/div[1]/div[1]/h3']))
WebUI.verifyMatch(Name_StepAP2_3, 'Phase 1.2 [Standard Phase]', false)

//2nd Step B
String StepB_3 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a']),
	'class')
WebUI.verifyMatch(StepB_3, 'nav-link timeline-badge badge-xl  bg-waiting ', false)

String StepB_33 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a')
WebUI.verifyMatch(StepB_33, 'SASStepB', false)

'Logout'
functions.I.Logout()

'Login as lmary'
functions.I.Login_password('lmary', password_lmary)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Search for ref '
functions.I.SearchRefNo_xpath('P19_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: lamary Ref list page'
WebUI.takeScreenshot()

'Verify lifecycle status'
String Lifecycle_Status33 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID19) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status33, 'Phase 1.2 [Standard Phase]', false)

'click on Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID19+'"]/td[13]/a[2]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//Added Phase 1.2
'Verify lifecycle status'
String Lifecycle_Status44 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID19) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status44, 'Phase 1.2 [Standard Phase]', false)

'click on Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID19+'"]/td[13]/a[2]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// Phase 1.2
'Verify lifecycle status'
String Lifecycle_Status4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID19) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status4, 'Phase 2.1 [Production]', false)

WebUI.closeBrowser()