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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

//USERNAME & PASSWORD  - NPP
def data_Npp = TestDataFactory.findTestData('Data Files/Username_Password/Test_Npp')
String password_ncur = data_Npp.getValue(2, 1) //R
String password_aogunsanya = data_Npp.getValue(2, 11) //R

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Npp = data_urlTESTAUTO.getValue(2, 5)

//READ FROM NOTEPAD TC 16.08
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\NPP\\503.12\\503.12_NPP_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\NPP\\503.12\\503.12_NPP_refID.txt')

//////////////////////////////////////////////Test Begin ///////////////////////
////////////////////////////NAVIGATE TO NPP ///////////////////////////////////
'Navigate to NPP'
WebUI.openBrowser(Url_Npp)


WebUI.maximizeWindow()

'Screenshot: Navigate to Npp'
WebUI.takeScreenshot()

////////////////////////////CREATION OF PROJECT - LSS ///////////////////////////////////
'Log in as Product Platform – All users'
functions.I.Login_password('ncur', password_ncur)

'Screenshot: Log as Product manager'
WebUI.takeScreenshot()

'Go to the project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[9]/button')

'Screenshot: ref list page'
WebUI.takeScreenshot()

WebUI.delay(1)

'25 Click on the subtranslation'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/a']))

'Click on the Lifecycle tabb'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(2)

'Screenshot: lifecycle tab'
WebUI.takeScreenshot()

'Click on steps'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li/a']))

WebUI.delay(1)

functions.I.Pagedown()

WebUI.delay(1)

//////////////////////////////////////ADD PHASES : Translation - Agency -> MKT -> RSA / Translation / RSA Translation
'29 Click on add phases'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[6]/div/div[1]/div[2]/div/a[1]']))

WebUI.delay(1)

'Selectlist'
functions.I.SelectFromList_Value('//*[@id="added_phase"]', '113')

'Screenshot: popup'
WebUI.takeScreenshot()

'Click on OK'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addphase"]/div/div/div[3]/button[2]']))

WebUI.delay(1)

'Screenshot: lifecycle tab'
WebUI.takeScreenshot()

'Click on the breadcrum'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

WebUI.delay(2)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Verify lifecycle template'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span[2]', 'RSA Translation')


'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]')

///////////////////////////////USER 1 Submit
'Login as aogunsany'
functions.I.Login_password('aogunsanya', password_aogunsanya)

'Ana Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[20]/button')

WebUI.delay(2)

'Screenshot: Ref list '
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[12]/a[2]']))

WebUI.delay(1)

'Screenshot: Ref list '
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify lifecycle template'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[9]/span', 'Translation - Agency -> MKT -> RSA')


WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Close Browser'
WebUI.closeBrowser()

