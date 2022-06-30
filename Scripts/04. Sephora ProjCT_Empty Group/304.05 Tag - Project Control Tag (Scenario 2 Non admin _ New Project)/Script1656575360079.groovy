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

///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - tag
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_jedun = data_Tag.getValue(3, 1)
String password_rrowland = data_Tag .getValue(3, 2)
String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 5)

String password_mderdour = data_Tag.getValue(3, 6)
String password_achatin = data_Tag .getValue(3, 7)
String password_tliu = data_Tag.getValue(3, 8)

String password_ccaramella = data_Tag.getValue(3, 9)

String password_achay = data_Tag.getValue(3, 10)
String password_cbono = data_Tag.getValue(3,11)
String password_pmareri = data_Tag.getValue(3,12)
String password_qeuzen = data_Tag.getValue(3,13)


///DATA FIELD URL
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

//SCENARIO 2 : EXISTING PROJECT CONTROL TAG ON PROJECT IS DISPLAYED FOR NON -ADMIN USER
//////////////////////////// LOGIN AS NON ADMIN International agency  ///////////////////////////////////

'Log in as ADMIN – jedun'
functions.I.Login_password('rrowland', password_rrowland)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))
'Click on + to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

WebUI.delay(1)


'Screenshot: Create Project page'
WebUI.takeScreenshot()

'Select Project template '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="project_template"]']), '14', false)

'Click on create the project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))
 
WebUI.delay(5)

'Screenshot: Modify this project  PAge'
WebUI.takeScreenshot()


'Verify * is displayed for the field Project name'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/form/div[2]/div[2]/div[2]/div[2]/div[1]/label/img']), 10)

'Verify * is displayed for the field Project type'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/form/div[2]/div[2]/div[2]/div[2]/div[3]/label/img']), 10)
 
'Verify * is displayed for the field Domain'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/form/div[2]/div[2]/div[2]/div[2]/div[5]/label/img']), 10)
 
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/form/div[2]/div[2]/div[2]/div[2]/div[6]/label/img']), 10)


'Verify * is displayed for the field PAD'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/form/div[2]/div[2]/div[2]/div[2]/div[7]/label/img']), 10)
 

'Verify * is displayed for the field Division'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/form/div[2]/div[2]/div[3]/div[2]/div[1]/label/img']), 10)
 
'Verify * is displayed for the field Signature'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/form/div[2]/div[2]/div[3]/div[2]/div[2]/label/img']), 10)
 

WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/form/div[2]/div[2]/div[3]/div[2]/div[3]/label/img']), 10)
 


WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/form/div[2]/div[2]/div[3]/div[2]/div[4]/label/img']), 10)
 

WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/form/div[2]/div[2]/div[3]/div[2]/div[6]/label/img']), 10)


'Click on Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button/i']))
 
 WebUI.closeBrowser()
