import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.google.common.base.Functions as Functions
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
/* Powerpoint S33: ADD PHASE GROUP
 Completed lifecycle
 1. Add phase group (phase group belonging to the current step)
 2. Skip to one phase from the new ‘phase group’
 
 Result: new phase group is added inside the current step
 SAS : S27: Add Phase Group Step C/ Skip P3.1
 
 */
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')
String password_suser = data_Dreyers.getValue(2, 1) //R
String password_blemco = data_Dreyers.getValue(2, 2) //R
String password_nturner = data_Dreyers.getValue(2, 6) //R
String password_talexeeva = data_Dreyers.getValue(2, 7) //R
String password_jryan = data_Dreyers.getValue(2, 12) //R
String password_lmary = data_Dreyers.getValue(2, 13) //R

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

//READ NOTEPAD FROM TC 19.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_refID.txt')
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.26_Dreyers_refID26.txt')
//String refID26 = '3787'

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

//CREATE A NEW REF
'Click on + to create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

'Click start a design phase button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

WebUI.delay(1)

'Select Lifecycle'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), '36', false)

'settext Deliverable name'
def ref_name = ('P26_Auto_SAS_S33_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)) + functions.I.gettimedate()

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
String refID26 = functions.I.RefID()

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

//PHASE 1.1
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

functions.I.SearchRefNo_xpath('P26_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+'"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//PHASE 1.2
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+'"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//PHASE 2.1
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

//CLICK ACTION BUTTON FOR PROD
' Upload  file for Production Phase '
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID26) + '"]/td[14]/a[2]']), 'color', FailureHandling.OPTIONAL)

while (color1 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
                refID26) + '"]/td[14]/a[2]']))

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
                refID26) + '"]/td[14]/a[2]']), 'color', FailureHandling.OPTIONAL)
}

'Screenshot: Ref List page'
WebUI.takeScreenshot()


'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+'"]/td[6]/a']))
 
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
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+'"]/td[14]/div[1]/button']), findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+'"]/td[14]/div[1]/div/a[1]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// Phase 3.2
'Screenshot:Ref'
WebUI.takeScreenshot()

'Question: Submit phase'
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+'"]/td[14]/div[1]/button']), findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+'"]/td[14]/div[1]/div/a[1]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// PHASE 3.3
'Screenshot:Ref'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+ '"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// PHASE 3.4
'Screenshot:Ref'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+ '"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// Phase 3.5
//CLICK ACTION BUTTON FOR PROD
' Upload  file for Production Phase '
String color2 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 +
			'"]/td[14]/a[2]']), 'color', FailureHandling.OPTIONAL)

while (color2 == 'rgba(255, 255, 255, 1)') {
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 +'"]/td[14]/a[2]']))

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

	WebUI.delay(3)

	color2 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 +
			'"]/td[14]/a[2]']), 'color', FailureHandling.OPTIONAL)
}

'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+'"]/td[6]/a']))
 
 'Screenshot:Ref'
WebUI.takeScreenshot()

WebUI.delay(1)

'Approve for others'

functions.I.Approveforothers('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[2]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/img','/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[2]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[6]/a[2]/span')

'Go back to reflist page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

WebUI.delay(1)

//Completed ref
 'Click on the SAS'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+'"]/td[14]/div[1]/button']))
 
WebUI.delay(1)

//CLCICK ON THE SAS WITH THE LABEL
'no of option present '
int x = 20
int i = 1

while ( i <=x)
{
	String Expected_SAS_Selected = 'SAS S27: Add Phase Group Step C/ Skip P3.1'
	//*[@id="source_' + refID35 + '"]/td[14]/div[1]/div/a[10]
	String xpath_SAS ='//*[@id="source_'+refID26+'"]/td[14]/div[1]/div/a['+i+']'
	
	
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
'Click SAS 9th option - SAS 27'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID26+'"]/td[14]/div[1]/div/a[9]']))
*/

'Screenshot: Lifecycle tab page'
WebUI.takeScreenshot()

WebUI.delay(1)

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

//3rd STEP C - Phase 3.1 IS ACTIVE
'Verify that attribute of step C - active'
String StepC_1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']), 
    'class')

WebUI.verifyMatch(StepC_1, 'nav-link timeline-badge badge-xl  bg-pending active', false)

String StepC_11 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a')

WebUI.verifyMatch(StepC_11, 'SASStepC', false)

//PHASE 3.1 IS STILL ACTIVE
String StepC_4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[7]/div/div[1]/div[1]/h3']))

WebUI.verifyMatch(StepC_4, 'Phase 3.1 [Question]', false)

String Started_StepCP3_1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[7]/div/div[2]/div[1]']))

if (Started_StepCP3_1.contains('Started')) {
    WebUI.verifyEqual(1, 1)
} else {
    WebUI.verifyEqual(1, 2)
}

// VERIFY THAT 4TH STEP DOES NOT EXIST
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a']), 
    10)

'Go the ref list page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[2]/div/nav/ol/li[2]/a']))

//ADDED PHASE 1.1
'Verify lifecycle status'
String Lifecycle_Status1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + 
            '"]/td[11]/span[1]']))

WebUI.verifyMatch( Lifecycle_Status1, 'Phase 3.1 [Question]', false)

'Logout'
functions.I.Logout()

'Login as talexeeva'
functions.I.Login_password('talexeeva', password_talexeeva)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Search for ref '
functions.I.SearchRefNo_xpath('P26_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Question: Submit phase'
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID26) + '"]/td[13]/div[1]/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID26) + '"]/td[13]/div[1]/div/a[1]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Screenshot:Ref'
WebUI.takeScreenshot()

//ADDED PHASE 3.2
'Verify lifecycle status'
String Lifecycle_Status2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status2, 'Phase 3.2 [Question]', false)

'Logout '
functions.I.Logout()

'Login as nturner '
functions.I.Login_password('nturner', password_nturner)

WebUI.delay(1)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Search for ref '
functions.I.SearchRefNo_xpath('P26_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Question: Submit phase'
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + '"]/td[13]/div/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID26) + '"]/td[13]/div/div/a[1]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//ADDED PHASE 3.3
'Verify lifecycle status'
String Lifecycle_Status3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status3, 'Phase 3.3 [Standard]', false)

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Logout'
functions.I.Logout()

'Login as ryan'
functions.I.Login_password('jryan', password_jryan)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Search for ref '
functions.I.SearchRefNo_xpath('P26_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + '"]/td[14]/a[2]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//ADDED PHASE 3.4
'Verify lifecycle status'
String Lifecycle_Status4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status4, 'Phase 3.4 [Standard]', false)

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Logout'
functions.I.Logout()

'Login as nturner '
functions.I.Login_password('nturner', password_nturner)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Search for ref '
functions.I.SearchRefNo_xpath('P26_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + '"]/td[13]/a[2]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//ADDED PHASE 3.5
'Verify lifecycle status'
String Lifecycle_Status5 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status5, 'Phase 3.5[Prod]', false)

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Logout'
functions.I.Logout()

'Login as lmary'
functions.I.Login_password('lmary', password_lmary)

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

//CLICK ACTION BUTTON FOR PROD
' Upload  file for Production Phase '
String color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + 
            '"]/td[13]/a']), 'color', FailureHandling.OPTIONAL)

while (color3 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26+ '"]/td[13]/a']))

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

    color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + '"]/td[13]/a']), 
        'color', FailureHandling.OPTIONAL)
}

'Logout'
functions.I.Logout()

'Login as blemco '
functions.I.Login_password('blemco', password_blemco)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Search for ref '
functions.I.SearchRefNo_xpath('P26_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Approve a doc'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + 
            '"]/td[13]/a[2]']))

'Verify lifecycle status'
String Lifecycle_Status6 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID26 + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status6, 'Complete', false)

WebUI.takeScreenshot()

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.26_Dreyers_refID26.txt', refID26)

WebUI.closeBrowser()


