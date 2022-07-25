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

/* Powerpoint S5: ADD STEP (contains one step)
 Ongoing reference: Phase 2 (last phase) of Step A
 
 
 Lifecycle: Support Action Lifecycle > Step A  > Phase 1.2
 Support action :  S5 - Add Steps A & Skip to 1.1
 
 
 Support actions shortcut:
 Add step (same step as the current one-Step A)
 Skip until one of the phases inside the new ‘Step’added
 Result: new step is added after the current one by creating a new step
 
 
  */


///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')
String password_blemco = data_Dreyers.getValue(2, 2  )
String password_nturner = data_Dreyers.getValue(2, 6  )

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

//READ NOTEPAD FROM TC 19.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_refID.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
'Navigate to URL Dreyers Release'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

'Log in as blemco'
functions.I.Login_password('blemco', password_blemco)

'Screenshot: Login as blemco'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

//CREATE A NEW REF
'Click on + to create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click start a design phase button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

'Select Lifecycle'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), '36', false)

'settext Deliverable name'
def ref_name = ('P2_Auto_SAS_S5_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)) + functions.I.gettimedate()

WebUI.delay(1)

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_name"]']), ref_name)

'Screenshot: create ref page'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="createRefBottom"]']))

WebUI.delay(1)

'get refiD '
String refID2 = functions.I.RefID()

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

//PHASE 1.1
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

functions.I.SearchRefNo_xpath('P2_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID2) + '"]/td[13]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID2) + '"]/td[6]/a']))

WebUI.delay(1)

'Click Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: Lifecycle tab page'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on SAS buton'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div/button']))

WebUI.delay(1)

'Screenshot: SAS option'
WebUI.takeScreenshot()

WebUI.delay(1)

//CLCICK ON THE SAS WITH THE LABEL
'no of option present '
int x = 3
int i = 1

while ( i <=x)
{
	String Expected_SAS_Selected = '1. SAS S05: Add Steps A/ Skip Phase 1.1'
	String xpath_SAS ='/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div/div/a['+i+']'
	
	
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
'42 Choose option 1st : S5 - Add Step A - Skip Phase 1.1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div/div/a[1]']))
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

//1st STEP A - Completed
'Verify that attribute of step A - Complete'
String StepA_1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a']), 
    'class')

WebUI.verifyMatch(StepA_1, 'nav-link timeline-badge badge-xl  bg-complete ', false)

String StepA_11 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a')

WebUI.verifyMatch(StepA_11, 'SASStepA', false)

//2nd phase Step A - Added and active
'Verify that attribute of step A - active'
String StepA_2 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a']), 
    'class')

WebUI.verifyMatch(StepA_2, 'nav-link timeline-badge badge-xl  bg-pending active', false)

String StepA_22 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a')

WebUI.verifyMatch(StepA_22, 'SASStepA', false)

//Added Phase 1.1
String Name_StepAP1_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/div[1]/h3']))

WebUI.verifyMatch(Name_StepAP1_2, 'Phase 1.1 [Standard]', false)

String added_StepAP1_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/h6']))

if (added_StepAP1_2.contains('Added manually')) {
    WebUI.verifyEqual(1, 1)
} else {
    WebUI.verifyEqual(1, 2)
}

//Added Phase 1.2
String Name_StepAP2_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/h3']))

WebUI.verifyMatch(Name_StepAP2_2, 'Phase 1.2 [Standard Phase]', false)

//3rd Step B
String StepB_3 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']), 
    'class')

WebUI.verifyMatch(StepB_3, 'nav-link timeline-badge badge-xl  bg-waiting ', false)

String StepB_33 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a')

WebUI.verifyMatch(StepB_33, 'SASStepB', false)

'Go the ref list page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[2]/div/nav/ol/li[2]/a']))

'Search for ref '
functions.I.SearchRefNo_xpath('P2_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID2) + '"]/td[13]/a[3]']))

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

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P2_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

WebUI.delay(1)

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID2) + '"]/td[13]/a[2]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify lifecycle status'
String Lifecycle_Status = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID2) + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status, 'Phase 2.1 [Production]', false)

'Screenshot: Ref list page'
WebUI.takeScreenshot()

WebUI.closeBrowser()

