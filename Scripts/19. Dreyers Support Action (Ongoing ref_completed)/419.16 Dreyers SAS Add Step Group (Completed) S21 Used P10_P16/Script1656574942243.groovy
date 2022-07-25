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
/* Powerpoint S20: ADD STEP GROUP (contains more than one step)
 Completed lifecycle
 
 Add step group (Step A and Step C)
 Result: the steps are added correctly in a new step each one , skip works correctly OK
 
 Support action :  S20: Add Step Group AC/ Skip Phase 1.2
 */
  
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')

String password_suser = data_Dreyers.getValue(2, 1) //R
String password_blemco = data_Dreyers.getValue(2, 2) //R
String password_nturner = data_Dreyers.getValue(2, 6) //R
String password_lmary = data_Dreyers.getValue(2, 13) //R

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

//READ NOTEPAD FROM TC 19.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_refID.txt')
String refID10 = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.10_Dreyers_refID10.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
'Navigate to URL Dreyers'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

'Log in as suser'
functions.I.Login_password('suser', password_suser)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: suser Ref list page'
WebUI.takeScreenshot()

//REF COMPLETED
functions.I.SearchRefNo_xpath('P10_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID10) + '"]/td[6]/a']))

'Click Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot:Lifecycle tab'
WebUI.takeScreenshot()

'Click on steps'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']))

'Click on the SAS button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[5]/div/div[5]/div/div[1]/div[2]/div/button']))

'Screenshot: SAS option'
WebUI.takeScreenshot()

WebUI.delay(1)

//CLCICK ON THE SAS WITH THE LABEL
'no of option present '
int x = 15
int i = 1

while ( i <=x)
{
	String Expected_SAS_Selected = 'SAS S21 - Add Step Group C&A / Skip P3.4 [Complete]'
	String xpath_SAS ='/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[5]/div/div[5]/div/div[1]/div[2]/div/div/a['+i+']'
	
	
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
'Choose the 8th option-   S21'
functions.I.click_button_javascriptS('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[5]/div/div[5]/div/div[1]/div[2]/div/div/a[8]')
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

// 5rd STEP C - Completed
String StepC_1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']), 
    'class')

WebUI.verifyMatch(StepC_1, 'nav-link timeline-badge badge-xl  bg-complete ', false)

String StepC_11 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a')

WebUI.verifyMatch(StepC_11, 'SASStepC', false)

//6th STEP C - Phase 3.4 IS ACTIVE
'Verify that attribute of step C - active'
String StepC_2 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[6]/a']), 
    'class')

WebUI.verifyMatch(StepC_2, 'nav-link timeline-badge badge-xl  bg-pending active', false)

String StepC_22 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[6]/a')

WebUI.verifyMatch(StepC_22, 'SASStepC', false)

//PHASE 3.4 IS STILL ACTIVE
String Started_StepC_34 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[6]/div/div[4]/div/div[2]/div[1]']))

if (Started_StepC_34.contains('Started')) {
    WebUI.verifyEqual(1, 1)
} else {
    WebUI.verifyEqual(1, 2)
}

//7th STEP A - Waiting
'Verify that attribute of step C - active'
String StepA_3 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[7]/a']), 
    'class')

WebUI.verifyMatch(StepA_3, 'nav-link timeline-badge badge-xl  bg-waiting ', false)

String StepA_33 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[7]/a')

WebUI.verifyMatch(StepA_33, 'SASStepA', false)

'Logout'
functions.I.Logout()

//ADDED 3.4
'Login as nturner '
functions.I.Login_password('nturner', password_nturner)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: nturner - Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P10_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

WebUI.delay(1)

//Phase Step C - Phase  3.4
'Verify lifecycle status'
String Lifecycle_Status1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID10) + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status1, 'Phase 3.4 [Standard]', false)

'click on Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID10) + '"]/td[13]/a[2]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//Phase Step C - Phase  3.5
'Verify lifecycle status'
String Lifecycle_Status2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID10) + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status2, 'Phase 3.5[Prod]', false)

functions.I.Logout()

'Login as lmary'
functions.I.Login_password('lmary', password_lmary)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: lamry Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P10_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot:Ref'
WebUI.takeScreenshot()

//CLICK ACTION BUTTON FOR PROD
' Upload  file for Production Phase '
String color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID10) + 
            '"]/td[13]/a']), 'color', FailureHandling.OPTIONAL)

while (color3 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID10) + '"]/td[13]/a']))

    'SELECT APPROVAL WORKFLOW'
    WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="id_approval_flow_tpl"]']), 
        '80', false)

    //UPLOAD A DOC - PDF
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(8)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID10) + '"]/td[13]/a']), 
        'color', FailureHandling.OPTIONAL)
}

'Logout'
functions.I.Logout()

'Login as blemco '
functions.I.Login_password('blemco', password_blemco)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: blemco Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P10_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Approve a doc'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID10) + 
            '"]/td[13]/a[2]']))

'Verify lifecycle status'
String Lifecycle_Status66 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID10) + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status66, 'Phase 1.1 [Standard]', false)

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID10) + '"]/td[13]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//Added Phase Step A - Phase  1.2
'Verify lifecycle status'
String Lifecycle_Status3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID10) + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status3, 'Phase 1.2 [Standard Phase]', false)

'Logout'
functions.I.Logout()

WebUI.closeBrowser()

