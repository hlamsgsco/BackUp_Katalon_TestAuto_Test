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

//////////////////////////////TO VERIFY ///////////////////////
////////////////////SCENARIO 1 :

/*
Sceanrio 3:B - Completed/RTP Release to Repro Prod
												


D - Completed to Repro prod
A - AW File Release to AW Prod
A - Repro Prod to AW Prod
D - AW File Release to AW Prod
D - Repro Prod to AW Prod


 */


///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - tag
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')
String password_jedun = data_Tag.getValue(3, 1)

String password_rrowland = data_Tag.getValue(3, 2)

String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 5)

String password_mderdour = data_Tag.getValue(3, 6)

String password_achatin = data_Tag.getValue(3, 7)

String password_tliu = data_Tag.getValue(3, 8)

String password_ccaramella = data_Tag.getValue(3, 9)

String password_achay = data_Tag.getValue(3, 10)

String password_cbono = data_Tag.getValue(3, 11)

String password_pmareri = data_Tag.getValue(3, 12)

String password_qeuzen = data_Tag.getValue(3, 13)

String password_alanglois = data_Tag.getValue(3, 14)

String password_bzavaglia = data_Tag.getValue(3, 15)
String password_asamyn =data_Tag.getValue(3, 16)
String password_mraoul	=data_Tag.getValue(3, 17)

String password_idiaz	=data_Tag.getValue(3, 18)

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


//Existing Project
String Project_No ='MI003396'

String refID = '24384'


///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag '
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag '
WebUI.takeScreenshot()

'Login as jedun '
functions.I.Login_password('jedun', password_jedun)


'Screenshot: Login '
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for project'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[7]/button']))

WebUI.delay(1)

'Screenshot: reflist page'
WebUI.takeScreenshot()

'Clcik on ref link 24384 '
WebUI.click( findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24384"]/td[8]/a']))
 
WebUI.delay(1)

'Click on lifecycle '
WebUI.click( findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(1)

'Screenshot: lifecycle tab'
WebUI.takeScreenshot()

'Click on step '
WebUI.click( findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li/a']))


WebUI.delay(1)

'Click on SAS button '
WebUI.click( findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[4]/div/div[1]/div[2]/div/a[4]']))


WebUI.delay(1)


'Screenshot: popup page'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click OK'
WebUI.click( findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[3]/button[2]']))



'Click on breadcrumd '
WebUI.click( findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'status lifecycel'
String status1 = WebUI.getText (findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24384"]/td[13]/span[1]']))

WebUI.verifyMatch(status1, 'Agency: Repro production', false)


WebUI.closeBrowser()

