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

/* Powerpoint S43: ADD PHASE
 Ongoing reference: no last phase of last Step
 Add a phase belonging to the same  step
 Skip a phase inside the step
 Results:  the new phase is added correctly inside the current step after the phase where the SAS was launched, skip works correctly
 
 
 
  */
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')

String password_suser = data_Dreyers.getValue(2, 1 //R
    )

String password_blemco = data_Dreyers.getValue(2, 2 //R
    )

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

//READ NOTEPAD FROM TC 19.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_refID.txt')

//String refID35 = '3830'
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

WebUI.delay(1)

'Click start a design phase button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

WebUI.delay(1)

'Select Lifecycle'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), '36', false)

'settext Deliverable name'
def ref_name = ('P35_Auto_SAS_S43_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)) + functions.I.gettimedate()

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
String refID35 = functions.I.RefID()

functions.I.print('refID' + refID35)

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

//PHASE 1.1
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

functions.I.SearchRefNo_xpath('P35_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

////*[@id="source_3667"]/td[14]/a[3]
'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//PHASE 1.2
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//PHASE 2.1
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

//CLICK ACTION BUTTON FOR PROD
' Upload  file for Production Phase '
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[14]/a[2]']), 
    'color', FailureHandling.OPTIONAL)

functions.I.print(color1)

while (color1 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[14]/a[2]']))

    //UPLOAD A DOC - PDF
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[14]/a[2]']), 
        'color', FailureHandling.OPTIONAL)
}

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[6]/a']))

'Screenshot:Ref'
WebUI.takeScreenshot()

WebUI.delay(1)

'Approve for others'
functions.I.Approveforothers('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[2]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/img', 
    '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[2]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[6]/a[2]/span')

WebUI.delay(1)

'Go back to reflist page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

WebUI.delay(1)


// Phase 3.1
'61 Question: Submit phase'
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[14]/div[1]/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[14]/div[1]/div/a[1]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// Phase 3.2
'Screenshot:Ref'
WebUI.takeScreenshot()

'Question: Submit phase'
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[14]/div[1]/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[14]/div[1]/div/a[1]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// PHASE 3.3
'Screenshot:Ref'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//Phase 3.4
'Click on the SAS button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[14]/div[1]/button']))

////*[@id="source_3827"]/td[14]/div[1]/div/a[10]


//CLCICK ON THE SAS WITH THE LABEL
'no of option present '
int x = 20
int i = 1

while ( i <=x)
{
	String Expected_SAS_Selected = 'SAS S43: Skip P3.5/Add Phase 1.1/ Skip 1.1'
	//*[@id="source_' + refID35 + '"]/td[14]/div[1]/div/a[10]
	String xpath_SAS ='//*[@id="source_' + refID35 + '"]/td[14]/div[1]/div/a['+i+']'
	
	
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
'Click SAS 43 - 10th option '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID35 + '"]/td[14]/div[1]/div/a[10]']))
*/
'click on ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="confirmSupportActionShortcut"]']))

'Screenshot: SAS option'
WebUI.takeScreenshot()

'Click Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: Lifecycle tab page'
WebUI.takeScreenshot()

//3rd STEP C - Complete
'Verify if the Step C in the 3rd position is Complete'
String Status_StepC_3 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']), 
    'class')

WebUI.verifyMatch(Status_StepC_3, 'nav-link timeline-badge badge-xl  bg-complete ', false)

'Verify the Name of the 3rd Step C '
String Name_StepC_3 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a')

WebUI.verifyMatch(Name_StepC_3, 'SASStepC', false)

//4th ADDED STEP A - ACTIVE
'Verify if the Step A in the 4th position is Active'
String Status_StepA_4 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a']), 
    'class')

WebUI.verifyMatch(Status_StepA_4, 'nav-link timeline-badge badge-xl  bg-pending active', false)

'Verify the Name of the 4th Step A '
String Name_StepA_4 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a')

WebUI.verifyMatch(Name_StepA_4, 'SASStepA', false)

//ADDED STEP A - PHASE 1.1 - ACTIVE
//PHASE 1.1 IS ACTIVE
'Verify if the Step A - phase 1.1  in the 4th position is Pending'
String Status_StepAP11_4 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div/span']), 
    'class')

'Verify that the phase is pending'
WebUI.verifyMatch(Status_StepAP11_4, 'timeline-badge badge-md bg-pending ' , false)

'Verify the Name of the phase 1.1'
String Name_StepAP11_4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div/div/div[1]/div[1]/h3']))

WebUI.verifyMatch(Name_StepAP11_4, 'Phase 1.1 [Standard]', false)

//STARTED IS IS DISPLAYED IN THE PHASE 1.1
'Verify that Started is displayed in the Step A - Phase 1.1'
String Started_StepAP11_4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div/div/div[2]/div[1]']))

if (Started_StepAP11_4.contains('Started')) {
    WebUI.verifyEqual(1, 1)
} else {
    WebUI.verifyEqual(1, 2)
}

//ADDED IS IS DISPLAYED IN THE PHASE 1.1
'Verify that Started is displayed in the Step A - Phase 1.1'
String Added_StepAP11_4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div/div/div[2]/h6']))

if (Added_StepAP11_4.contains('Added manually')) {
    WebUI.verifyEqual(1, 1)
} else {
    WebUI.verifyEqual(1, 2)
}

//VERIFY THAT THERE IS NO 5th STEP
'Verify that there is no 5th Step'
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']), 
    10)

'Go the ref list page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[2]/div/nav/ol/li[2]/a']))

//REF LIST PAGE
'Screenshot: Ref List page'
WebUI.takeScreenshot()

//ADDED PHASE 1.1
'Verify lifecycle status'
String Lifecycle_Status1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + 
            '"]/td[11]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status1, 'Phase 1.1 [Standard]', false)

'Logout as suser'
functions.I.Logout()

'Login as blemco '
functions.I.Login_password('blemco', password_blemco)

'Screenshot: Login as blemco'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P35_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + '"]/td[13]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify lifecycle status'
String Lifecycle_Status3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID35) + 
            '"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status3, 'Complete', false)

'Screenshot: LC Complete'
WebUI.takeScreenshot()

'Close Browser'
WebUI.closeBrowser()

