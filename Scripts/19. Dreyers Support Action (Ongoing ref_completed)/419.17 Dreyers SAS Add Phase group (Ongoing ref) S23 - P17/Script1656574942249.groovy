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


/* Powerpoint S23: ADD PHASE GROUP
 Ongoing reference : Phase 1 (no last phase) of the Step A
 Lifecycle: Support Action Lifecycle > Step A  > Phase 1.1
 Support action : S23: Skip P1.2/ Add PG 1.1_1.2/ Skip P1.1
 
 Support actions shortcut:
 Skip to phase 2- last phase of the current step
 Add phase group (phase group belonging to the current step)
 Skip until one of the phases inside the new ‘phase group’
  */

///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')
String password_suser = data_Dreyers.getValue(2, 1)//R
String password_blemco = data_Dreyers.getValue(2, 2) //R
String password_nturner = data_Dreyers.getValue(2, 6) //R
String password_lmary = data_Dreyers.getValue(2, 13) //R

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

//READ NOTEPAD FROM TC 19.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_refID.txt')
//String  refID17 = '3727'

////////////////////////////// TEST BEGIN /////////////////////////////////////////

'Navigate to URL Dreyers'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

'Log in as blemco'
functions.I.Login_password('blemco', password_blemco)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: blemco Ref list page'
WebUI.takeScreenshot()

//CREATE A NEW REF
'Click on + to create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click start a design phase button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

WebUI.delay(1)

'Select Lifecycle'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), '36', false)

'settext Deliverable name'
def ref_name = ('P17_Auto_SAS_S23_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)) + functions.I.gettimedate()

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
String refID17 = functions.I.RefID()

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

//PHASE 1.1
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

functions.I.SearchRefNo_xpath('P17_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Click on SAS buton'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID17+'"]/td[13]/div[1]/button']))

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
	String Expected_SAS_Selected = 'SAS S23: Skip P1.2/ Add PG 1.1_1.2/ Skip P1.1'
	//*[@id="source_' + refID35 + '"]/td[14]/div[1]/div/a[10]
	String xpath_SAS ='//*[@id="source_'+refID17+'"]/td[13]/div[1]/div/a['+i+']'
	
	
	String Actual_SAS = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))
	functions.I.print(i)
	
	if (Actual_SAS.contains(Expected_SAS_Selected))
	{
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))

		//functions.I.click_button_javascriptS(xpath_SAS)
		
		break
		}
		i =i+1
	}


/*
'Choose option 2nd :  S23: Skip P1.2/ Add PG 1.1_1.2/ Skip P1.1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID17+'"]/td[13]/div[1]/div/a[2]']))
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

String StepA_11 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a')
WebUI.verifyMatch(StepA_11, 'SASStepA', false)

//Added Phase 1.1
String Name_StepAP1_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[3]/div/div[1]/div[1]/h3']))
WebUI.verifyMatch(Name_StepAP1_2, 'Phase 1.1 [Standard]', false)

String added_StepAP11_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[3]/div/div[2]/h6']))

if (added_StepAP11_2.contains('Added manually'))
 {WebUI.verifyEqual(1, 1)}
else {WebUI.verifyEqual(1, 2)}

String added_StepAP1_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[3]/div/div[2]/div[1]']))

if (added_StepAP1_2.contains('Started'))
 {WebUI.verifyEqual(1, 1)}
else {WebUI.verifyEqual(1, 2)}

//Added Phase 1.2
String Name_StepAP2_2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[4]/div/div[1]/div[1]/h3']))
WebUI.verifyMatch(Name_StepAP2_2, 'Phase 1.2 [Standard Phase]', false)

//2nd Step B
String StepB_3 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a']),
	'class')
WebUI.verifyMatch(StepB_3, 'nav-link timeline-badge badge-xl  bg-waiting ', false)

String StepB_33 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a')
WebUI.verifyMatch(StepB_33, 'SASStepB', false)

'Go the ref list page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[2]/div/nav/ol/li[2]/a']))

'Search for ref '
functions.I.SearchRefNo_xpath('P17_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID17+'"]/td[13]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Logout'
functions.I.Logout()

'Login as nturner'
functions.I.Login_password('nturner', password_nturner)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Search for ref '
functions.I.SearchRefNo_xpath('P17_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: nturner Ref list page'
WebUI.takeScreenshot()

'Verify lifecycle status'
String Lifecycle_Status3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID17) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status3, 'Phase 1.2 [Standard Phase]', false)

'click on Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID17+'"]/td[13]/a[2]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify lifecycle status'
String Lifecycle_Status4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID17) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status4, 'Phase 2.1 [Production]', false)

functions.I.Logout()

'Log in as suser'
functions.I.Login_password('suser', password_suser)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

functions.I.SearchRefNo_xpath('P17_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')
  
//CLICK ACTION BUTTON FOR PROD
' Upload  file for Production Phase '
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' +
			refID17) + '"]/td[14]/a[2]']), 'color', FailureHandling.OPTIONAL)

while (color1 == 'rgba(255, 255, 255, 1)') {
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' +
				refID17) + '"]/td[14]/a[2]']))

	//UPLOAD A DOC - PDF
	functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']),
		'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1')

	'Screenshot: Production phase Field Upload doc'
	WebUI.takeScreenshot()

	WebUI.delay(8)

	//REF PAGE: CLICK ON PROCEED TO NEXT PHASE
	WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

	WebUI.delay(4)

	color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' +
				refID17) + '"]/td[14]/a[2]']), 'color', FailureHandling.OPTIONAL)
}

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID17+'"]/td[6]/a']))
 
 'Screenshot:Ref'
WebUI.takeScreenshot()

WebUI.delay(1)

'Approve for others'
functions.I.Approveforothers('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[2]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/img','/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[2]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[6]/a[2]/span')


WebUI.delay(1)

'Go back to reflist page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

WebUI.delay(1)


// Phase 3.1
'Question: Submit phase'
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID17+'"]/td[14]/div[1]/button']), findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID17+'"]/td[14]/div[1]/div/a[1]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// Phase 3.2
'Screenshot:Ref'
WebUI.takeScreenshot()

'Question: Submit phase'
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID17+'"]/td[14]/div[1]/button']), findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID17+'"]/td[14]/div[1]/div/a[1]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// PHASE 3.3
'Screenshot:Ref'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID17+ '"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// PHASE 3.4
'Screenshot:Ref'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID17+ '"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//PHASE 3.5
'Logout'
functions.I.Logout()

'Login as lmary'
functions.I.Login_password('lmary', password_lmary)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Search for ref '
functions.I.SearchRefNo_xpath('P17_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: lmary Ref list page'
WebUI.takeScreenshot()

//CLICK ACTION BUTTON FOR PROD
' Upload  file for Production Phase '
String color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID17) +
			'"]/td[13]/a']), 'color', FailureHandling.OPTIONAL)

while (color3 == 'rgba(255, 255, 255, 1)') {
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID17) + '"]/td[13]/a']))

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

	WebUI.delay(4)

	color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID17) + '"]/td[13]/a']),
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
functions.I.SearchRefNo_xpath('P17_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Approve a doc'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID17) +
			'"]/td[13]/a[2]']))

'Verify lifecycle status'
String Lifecycle_Status6 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID17) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status6, 'Complete', false)

WebUI.closeBrowser()