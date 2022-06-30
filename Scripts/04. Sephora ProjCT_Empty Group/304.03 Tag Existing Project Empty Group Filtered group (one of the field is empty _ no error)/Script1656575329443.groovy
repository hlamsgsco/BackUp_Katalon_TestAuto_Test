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

//////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - tag
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_jedun = data_Tag.getValue(3, 1)

// Change to
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

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


String Project_No = 'MI003394'

String ref_ID = '14874'

/////////////////////////////////EMPTY GROUP///////////////////////////////////////////
/////////////////////////////////EXISTING PROJECT : MI002230 ////////////////////////
////////////////////////////////S1 EMPTY GROUP - EMPTY FIELD (FILTERED GROUP : PRINTER- 1 FIELD)///////////////////// 
///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//////////////////////SCENARIO 1 EXISTING PROJECT (MI002232) CONTROL TAG ON PROJECT IS DISPLAYED FOR ADMIN USER ///////////////////////////////
//////////////////////////// LOGIN AS DMI  ///////////////////////////////////
'Log in as C&A - pmareri'
functions.I.Login_password('pmareri', password_pmareri)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

//////////////////////////REF Modif page
'C&A click on create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24374"]/td[15]/a[2]']))

'Screenshot: Ref modif page'
WebUI.takeScreenshot()

'Select languages'
functions.I.select_multiplelist('//*[@id="selSource_10"]', '//*[@id="btnAdd_10"]', '1303')

'Select leader marketing '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_166"]']), '1191', false)

'Select LC'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_71"]']), '1518', false)

'Submit to next phase'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

'Click breacrumb'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

'35'
WebUI.delay(3)

//*[@id="source_24374"]/td[15]/a[2]
'34 C&A click on create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24374"]/td[15]/a[2]']))

'Screenshot: Ref modif page'
WebUI.takeScreenshot()

'Select leader marketing '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_71"]']), '', false)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_166"]']), '1190', false)

'Submit to next phase'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[1]']))

WebUI.delay(1)

'Verify text'
String lifecycle_status = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24374"]/td[13]/span[1]']))

////*[@id="source_24374"]/td[13]/span[1]
WebUI.verifyMatch(lifecycle_status, 'Plant: Brief completion', false)

WebUI.closeBrowser()

