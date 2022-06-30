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

////////////////////SCENARIO 1 : EXISTING PROJECT (MI002230) CONTROL TAG ON PROJECT IS DISPLAYED FOR ADMIN USER////////////////



///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - tag
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_jedun = data_Tag.getValue(3, 1)


//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


///////////////////////////// TEST BEGIN /////////////////////////////////////////

//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//////////////////////SCENARIO 1 EXISTING PROJECT (MI002230) CONTROL TAG ON PROJECT IS DISPLAYED FOR ADMIN USER ///////////////////////////////
//////////////////////////// LOGIN AS ADMIN JEDUN  ///////////////////////////////////
String Project_No = 'MI003388'
'Log in as ADMIN – jedun'
functions.I.Login_password('jedun', password_jedun)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

'Screenshot: Ref list page of Project MI003388'
WebUI.takeScreenshot()

'Click on Modify this Project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[2]']))

WebUI.delay(5)

'Screenshot: Modify this project  PAge'
WebUI.takeScreenshot()

'Verify * is displayed for the field Project name'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_26437_ModifFiche"]/div[2]/div[1]/label/img']), 10)

'Verify * is displayed for the field Project type'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_26437_ModifFiche"]/div[2]/div[3]/label/img']), 10)
 
'Verify * is displayed for the field Domain'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_26437_ModifFiche"]/div[2]/div[5]/label/img']), 10)
 
'Verify * is displayed for the field PAD'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_26437_ModifFiche"]/div[2]/div[6]/label/img']), 10)
 
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_26437_ModifFiche"]/div[2]/div[7]/label/img']), 5)

'Screenshot: Modify this project  PAge'
WebUI.takeScreenshot()

'Verify * is displayed for the field Division'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_26447_ModifFiche"]/div[2]/div[1]/label/img']), 10)
 
'Verify * is displayed for the field Signature'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_26447_ModifFiche"]/div[2]/div[2]/label/img']), 10)
 
 'Screenshot: Modify this project  PAge'
 WebUI.takeScreenshot()
 
'Click on cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/a']))
 
WebUI.closeBrowser()