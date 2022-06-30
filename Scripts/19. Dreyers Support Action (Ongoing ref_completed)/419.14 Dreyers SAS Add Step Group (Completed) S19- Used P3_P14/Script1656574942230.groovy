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

/* Powerpoint S19: ADD STEP GROUP (contains one step)
Completed lifecycle


Add step group (different step group as the current one)

Result: the new step is added after my current step in a new step, skip works correctly 

Support action :  S19: Add Step C / Skip Phase 3.5




 */
//READ NOTEPAD FROM TC 19.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_ Login\\Dreyers\\419.01\\419.1_Dreyers_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_ Login\\Dreyers\\419.01\\419.1_Dreyers_refID.txt')
String refID3 = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_ Login\\Dreyers\\419.01\\419.3_Dreyers_refID3.txt')



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
functions.I.SearchRefNo_xpath('P3_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')



 //SAS SUPPORT ACTION S19
'Screenshot:Ref'
WebUI.takeScreenshot()

//*[@id="source_3712"]/td[14]/div[1]/button
'Click on the SAS button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID3) + '"]/td[14]/div[1]/button']))

WebUI.delay(1)

'Screenshot: SAS option'
WebUI.takeScreenshot()

WebUI.delay(1)

'Choose the 6TH option- S19 '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID3+'"]/td[14]/div[1]/div/a[6]']))


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



// 4th STEP C - Completed
///html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a
String StepC_1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a']),
	'class')

WebUI.verifyMatch(StepC_1, 'nav-link timeline-badge badge-xl  bg-complete ', false)

String StepC_11 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a')

WebUI.verifyMatch(StepC_11, 'SASStepC', false)


//5th STEP A - Phase 3.5 IS ACTIVE
'Verify that attribute of step C - active'
String StepA_2 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']),
	'class')

WebUI.verifyMatch(StepA_2, 'nav-link timeline-badge badge-xl  bg-pending active', false)

String StepA_22 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a')

WebUI.verifyMatch(StepA_22, 'SASStepA', false)

//PHASE 3.5 IS STILL ACTIVE
String Started_StepA_12 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[5]/div/div[2]/div/div[2]/div[1]']))

if (Started_StepA_12.contains('Started')) {
	WebUI.verifyEqual(1, 1)
} else {
	WebUI.verifyEqual(1, 2)
}

//VERIFY NO STEPS AFTER
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[6]/a']), 5)



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
functions.I.SearchRefNo_xpath('P3_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot:Ref'
WebUI.takeScreenshot()

'Verify lifecycle status'
String Lifecycle_Status3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID3) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status3, 'Phase 1.2 [Standard Phase]', false)

'click on Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID3+'"]/td[13]/a[2]']))


'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))


'Verify lifecycle status'
String Lifecycle_Status4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID3) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status4, 'Complete', false)


'Close Browser'
WebUI.closeBrowser()

