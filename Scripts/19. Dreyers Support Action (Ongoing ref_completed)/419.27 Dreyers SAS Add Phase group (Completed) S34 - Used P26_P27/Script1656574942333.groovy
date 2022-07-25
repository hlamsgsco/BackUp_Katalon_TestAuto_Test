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
/* Powerpoint S34: ADD PHASE GROUP
 Completed lifecycle
 
 Add phase group (phase group belonging to another step)
 2. Skip to one phase from the new ‘phase group’
 
 Expected:  the phase group should be added after the current step by creating a new step
 
 Support action :   S30: Add Phase Group Step A/ Skip to Phase 1.1
 
 */
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')
String password_suser = data_Dreyers.getValue(2, 1) //R
String password_blemco = data_Dreyers.getValue(2, 2) //R
String password_nturner = data_Dreyers.getValue(2, 6) //R

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)


//READ NOTEPAD FROM TC 19.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_refID.txt')
String refID26 = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.26_Dreyers_refID26.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
'Navigate to URL Dreyers Release'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

'Log in as suser'
functions.I.Login_password('suser', password_suser)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

//REF COMPLETED
functions.I.SearchRefNo_xpath('P26_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID26) + '"]/td[6]/a']))

'Click Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot:Lifecycle tab'
WebUI.takeScreenshot()

'Click on steps'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']))

'Click on the SAS button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[11]/div/div[1]/div[2]/div/button']))

'Screenshot: SAS option'
WebUI.takeScreenshot()

WebUI.delay(1)

//CLCICK ON THE SAS WITH THE LABEL
'no of option present '
int x = 15
int i = 1

while ( i <=x)
{
	String Expected_SAS_Selected = 'SAS S30: Add Phase Group SA/ Skip to Phase 1.1'
	String xpath_SAS ='/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[11]/div/div[1]/div[2]/div/div/a['+i+']'
	
	
	String Actual_SAS = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))
	functions.I.print(i)
	
	if (Actual_SAS.contains(Expected_SAS_Selected))
	{
		functions.I.click_button_javascriptS(xpath_SAS)
		
		break
		}
		i =i+1
	}
/*
'Choose the 7th option-   S30'
functions.I.click_button_javascriptS('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[11]/div/div[1]/div[2]/div/div/a[7]')
*/

'Screenshot: SAS popup'
WebUI.takeScreenshot()

'click on ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="confirmSupportActionShortcut"]']))

'Screenshot: SAS option'
WebUI.takeScreenshot()

'Click Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: Lifecycle tab page'
WebUI.takeScreenshot()


// 3rd STEP C - Completed
String StepC_1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']), 
    'class')

WebUI.verifyMatch(StepC_1, 'nav-link timeline-badge badge-xl  bg-complete ', false)

String StepC_11 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a')

WebUI.verifyMatch(StepC_11, 'SASStepC', false)

//4th STEP A - Phase 1.1 IS ACTIVE
'Verify that attribute of step A - active'
String StepA_2 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a']), 
    'class')

WebUI.verifyMatch(StepA_2, 'nav-link timeline-badge badge-xl  bg-pending active', false)

String StepA_22 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a')

WebUI.verifyMatch(StepA_22, 'SASStepA', false)

//PHASE 1.1 IS STILL ACTIVE
String StepA_11 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div[1]/div/div[1]/div[1]/h3']))
WebUI.verifyMatch(StepA_11, 'Phase 1.1 [Standard]', false)

String Started_StepA_11 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div[1]/div/div[2]/div[1]']))


if (Started_StepA_11.contains('Started')) {
    WebUI.verifyEqual(1, 1)
} else {
    WebUI.verifyEqual(1, 2)
}



'Logout'
functions.I.Logout()


'Log in as blemco'
functions.I.Login_password('blemco', password_blemco)


'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P26_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()


'Verify lifecycle status'
String Lifecycle_Status66 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID26) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status66, 'Phase 1.1 [Standard]', false)

////*[@id="source_3715"]/td[13]/a[3]
'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID26) + '"]/td[13]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//Added Phase Step A - Phase  1.2
'Verify lifecycle status'
String Lifecycle_Status3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID26) + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status3, 'Phase 1.2 [Standard Phase]', false)

'Logout'
functions.I.Logout()



'Login as nturner'
functions.I.Login_password('nturner', password_nturner)

'Screenshot: Login as lmary'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P26_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot:Ref'
WebUI.takeScreenshot()



'click on Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+'"]/td[13]/a[2]']))


'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))


'Verify lifecycle status'
String Lifecycle_Status4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID26) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status4, 'Complete', false)


WebUI.closeBrowser()
