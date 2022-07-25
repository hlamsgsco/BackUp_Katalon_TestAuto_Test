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

///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')

String password_suser = data_Dreyers.getValue(2, 1)

String password_blemco = data_Dreyers.getValue(2, 2)

String password_amassoth = data_Dreyers.getValue(2, 3)

String password_bharandi = data_Dreyers.getValue(2, 4)

String password_mbaughman = data_Dreyers.getValue(2, 5)

String password_nturner = data_Dreyers.getValue(2, 6)

String password_talexeeva = data_Dreyers.getValue(2, 7)

String password_bmilhomme = data_Dreyers.getValue(2, 8)

String password_rjaiven = data_Dreyers.getValue(2, 9)

String password_agarcia = data_Dreyers.getValue(2, 10)

String password_bcollins = data_Dreyers.getValue(2, 11)

String password_jryan = data_Dreyers.getValue(2, 12)

String password_lmary = data_Dreyers.getValue(2, 13)

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

/* Powerpoint S18: ADD STEP GROUP (contains one step)
Completed lifecycle


Add step group (same step group as the current one)

Expected: new step group should be added after the current step by creating a new step





 */
//READ NOTEPAD FROM TC 19.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.1_Dreyers_refID.txt')
String refID9 = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\419.01\\419.9_Dreyers_refID9.txt')



///////////////////////////// TEST BEGIN /////////////////////////////////////////

'Navigate to URL Dreyers Release'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()


'Log in as suser'
functions.I.Login_password('suser', password_suser)


'Screenshot: Login as suser'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))


'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')


'Screenshot: Ref list page'
WebUI.takeScreenshot()

//REF COMPLETED
functions.I.SearchRefNo_xpath('P9_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')



 //SAS SUPPORT ACTION S18
'Screenshot:Ref'
WebUI.takeScreenshot()

//*[@id="source_3712"]/td[14]/div[1]/button
'Click on the SAS button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID9) + '"]/td[14]/div[1]/button']))

WebUI.delay(1)

'Screenshot: SAS option'
WebUI.takeScreenshot()

WebUI.delay(1)

'Choose the 5TH option- S18 '
//*[@id="source_3712"]/td[14]/div[1]/div/a[5]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID9 + '"]/td[14]/div[1]/div/a[5]']))


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

// 1st STEP C - Completed
///html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a
String StepC_1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a']),
	'class')

WebUI.verifyMatch(StepC_1, 'nav-link timeline-badge badge-xl  bg-complete ', false)

String StepC_11 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a')

WebUI.verifyMatch(StepC_11, 'SASStepC', false)


//2nd STEP C - Phase 3.5 IS ACTIVE
'Verify that attribute of step C - active'
String StepC_2 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']),
	'class')

WebUI.verifyMatch(StepC_2, 'nav-link timeline-badge badge-xl  bg-pending active', false)

String StepC_22 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a')

WebUI.verifyMatch(StepC_22, 'SASStepC', false)

//PHASE 3.5 IS STILL ACTIVE
String Started_StepCP5_1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[5]/div/div[5]/div/div[2]/div[1]']))

if (Started_StepCP5_1.contains('Started')) {
	WebUI.verifyEqual(1, 1)
} else {
	WebUI.verifyEqual(1, 2)
}

//VERIFY THAT THERE IS NO PHASE AFTER
'Verify that there is no phase after 3.5'
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[5]/div/div[6]/div/div[1]/div[1]/h3']),
	10)

//VERIFY NO STEPS AFTER
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[6]/a']), 5)


'Logout'
functions.I.Logout()

'Login as lmary'
functions.I.Login_password('lmary', password_lmary)

'Screenshot: Login as lmary'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P9_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot:Ref'
WebUI.takeScreenshot()

//CLICK ACTION BUTTON FOR PROD
' Upload  file for Production Phase '
String color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID9) +
			'"]/td[13]/a']), 'color', FailureHandling.OPTIONAL)

while (color3 == 'rgba(255, 255, 255, 1)') {
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID9) + '"]/td[13]/a']))

	'SELECT APPROVAL WORKFLOW'
	WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="id_approval_flow_tpl"]']),
		'80', false)

	//UPLOAD A DOC - PDF
	functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']),
		'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

	'Screenshot: Production phase Field Upload doc'
	WebUI.takeScreenshot()

	WebUI.delay(10)

	//REF PAGE: CLICK ON PROCEED TO NEXT PHASE
	WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

	WebUI.delay(5)

	color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID9) + '"]/td[13]/a']),
		'color', FailureHandling.OPTIONAL)
}

'Logout'
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
functions.I.SearchRefNo_xpath('P9_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

////*[@id="source_3668"]/td[13]/a[2]
'Approve a doc'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID9) +
			'"]/td[13]/a[2]']))

'Verify lifecycle status'
String Lifecycle_Status6 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID9) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status6, 'Complete', false)

WebUI.takeScreenshot()

WebUI.closeBrowser()
