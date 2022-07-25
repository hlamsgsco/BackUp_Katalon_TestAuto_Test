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

//test
///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD [SEPHORA]
def data_Sephora = TestDataFactory.findTestData("Data Files/Username_Password/Test_Sephora")
String password_atran = data_Sephora .getValue(2, 1) //R


//DATA FILE URL [SEPHORA]
def data_urlAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Sephora = data_urlAUTO .getValue(2, 1)

//READ NOTEPAD
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refID.txt')
String ref_name1 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refIDName.txt')

 String refID2 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.04_Sephora_refID3.txt')
 
 
//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////
'Navigate to Sephora'
WebUI.openBrowser(Url_Sephora)

'Maximize Window'
WebUI.maximizeWindow()

'Log in as atran :  diadeis'
functions.I.Login_password('atran', password_atran)


'Click on LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')


'Screenshot: Ref List page'
WebUI.takeScreenshot()

//CANCEL REF
'click option button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID2+'"]/td[7]/div/button']))

WebUI.delay(1)

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID2+'"]/td[7]/div/div/a[2]']))

WebUI.delay(1)

'Click ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

'Verify that status is cancel'
functions.I.VerifyMatchText('//*[@id="source_'+refID2+'"]/td[5]/span', 'Canceled')

'Screenshot: Ref List page - cancelled'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on close project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[4]']))

'Verify toastr'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'You cannot close this project because it contains at least 1 reference not completed, not deleted or not cancelled.')

'Screenshot: Toastr'
WebUI.takeScreenshot()


'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')


'Screenshot: Ref List page'
WebUI.takeScreenshot()


//Standby ref
'click option button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[7]/div/button']))

WebUI.delay(5)

'Click standby'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[7]/div/div/a[1]']))

WebUI.delay(5)

'Click ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="validButtonStdBy"]']))

'VErify that status is standby'
functions.I.VerifyMatchText('//*[@id="source_'+refID+'"]/td[5]/span', 'Stand by')


'Screenshot: Ref List page - standby'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on close project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[4]']))

'Verify toastr'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'You cannot close this project because it contains at least 1 reference not completed, not deleted or not cancelled.')

'Screenshot: Toastr'
WebUI.takeScreenshot()

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')


'Screenshot: Ref List page'
WebUI.takeScreenshot()


//Delete ref
'click option button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[7]/div/button']))

WebUI.delay(5)

'Click delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[7]/div/div/a[3]']))

WebUI.delay(1)



'Click ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

'Verify that status is deleted'
functions.I.VerifyMatchText('//*[@id="source_'+refID+'"]/td[5]/span', 'Deleted')


'Screenshot: Ref List page - deleted'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on close project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[4]']))

'Verify toastr'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'Project closed.')


//VERIFY BUTTON CREATE IS NOT DISPLAYED
'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Verify button create is not displayed'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

//REOPEN PROJECT
'Click on close project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[4]']))

'Verify toastr'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'Project re-opened.')

//BUTTON CREATE DISPLAYED
'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Verify button create is displayed'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))
