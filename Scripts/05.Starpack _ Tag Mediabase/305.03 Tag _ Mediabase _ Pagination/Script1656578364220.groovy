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
String Project_No = 'MI002230'
'Log in as ADMIN – jedun'
functions.I.Login_password('jedun', password_jedun)

WebUI.delay(2)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_medibase_tab_1"]/a']))

WebUI.delay(2)

WebUI.refresh()

WebUI.delay(2)
WebUI.refresh()

WebUI.delay(2)

'Verify that pagination is visible'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="body_mediabase"]/div/div/div[2]/div']))

WebUI.takeScreenshot()
'Click page2'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="body_mediabase"]/div/div/div[2]/div/a[3]']))

WebUI.takeScreenshot()
WebUI.delay(2)
'Verify that page 02 is highlighted'
WebUI.verifyElementAttributeValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="body_mediabase"]/div/div/div[2]/div/a[3]']),
    'class', 'btn btn-icon btn-sm btn-light  border-0 btn-hover-primary active mr-2 my-1', 20)

'Click on next page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="body_mediabase"]/div/div/div[2]/div/a[7]']))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.verifyElementAttributeValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="body_mediabase"]/div/div/div[2]/div/a[4]']),
	 'class', 'btn btn-icon btn-sm btn-light  border-0 btn-hover-primary active mr-2 my-1', 20)

WebUI.verifyElementAttributeValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="body_mediabase"]/div/div/div[2]/div/a[3]']),
	 'class', 'btn btn-icon btn-sm btn-light ',  20)

WebUI.closeBrowser()
 