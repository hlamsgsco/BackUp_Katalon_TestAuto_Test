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

/* MI 003394
 * 
 * 
 */
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

String ref_ID = '24383'

/////////////////////////////////EMPTY GROUP///////////////////////////////////////////
/////////////////////////////////EXISTING PROJECT : MI002230 ////////////////////////
/////////////
///////////////////S1 EMPTY GROUP - EMPTY FIELD (FILTERED GROUP : PRINTER- 1 FIELD)///////////////////// 
///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//////////////////////SCENARIO 1 EXISTING PROJECT (MI002232)IS DISPLAYED FOR ADMIN USER ///////////////////////////////
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

////*[@id="cardctrlphase"]/div[2]/div[9]/a[2]
//*[@id="ancre_24373"]/a[2]
'Click on submit ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_24373"]/a[2]']))

'Submit to next phase'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

/////////////////////////////////////////////Empty Group Page ////////////////////////////////////////////////////
///////////////////////////////////EXPAND & COLLAPSE OF EMPTY GROUP//////////////////////////////////////
'Screenshot: Empty Group Page'
WebUI.takeScreenshot()

'Verify title > Error : empty groups '
String empty_G1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[1]/div[1]/h3/span']))

functions.I.print(empty_G1)

WebUI.verifyMatch(empty_G1, 'Error : empty groups', false)

'Click on  Collapse'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[1]/div[2]/a']))

WebUI.delay(2)

'35 Verify that element is Not visible'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]']))

//*[@id="cardctrlphase"]/div[2]
'Click on Expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[1]/div[2]/a']))

'Verify that element is visible'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]']))

//////////////////////////////////text is present//////////////////////////////////////
'Title Empty Group'
String EmptyG_title = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[1]/div[1]/h3/span']))

functions.I.print(EmptyG_title)

WebUI.verifyMatch('Error : empty groups', EmptyG_title, false)

'Error message '
String EmptyG_PotentialProb = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]']))

functions.I.print(EmptyG_PotentialProb)

String Expected_EmotyG_msg = ((((((((((((((((((((((((((((((((((((('Local Marketing (Leader) + Sub-Axis' + '\n') + 'Potential problem with these fields:') + 
'\n') + 'Signature (Project)') + '\n') + 'Garnier') + '\n') + 'Sub Axis (Project)') + '\n') + 'Hair Care') + '\n') + 'Leader country (Reference)') + 
'\n') + 'Algeria') + '\n') + 'Local Marketing (Approver) + Sub-Axis') + '\n') + 'Potential problem with these fields:') + 
'\n') + 'Signature (Project)') + '\n') + 'Garnier') + '\n') + 'Sub Axis (Project)') + '\n') + 'Hair Care') + '\n') + 'Approver countries/zones (Reference)') + 
'\n') + 'Belize') + '\n') + 'Algeria') + '\n') + 'Cambodia (kampuchea)') + '\n') + 'Modify this project') + '\n') + 'Modify this reference brief'

functions.I.print(Expected_EmotyG_msg)

WebUI.verifyMatch(Expected_EmotyG_msg, EmptyG_PotentialProb, false)

////*[@id="cardctrlphase"]/div[2]/div[9]/a[1]
'Click on modify project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]/div[9]/a[1]']))

WebUI.delay(1)

'User is redirected to the project page'
WebUI.takeScreenshot()

'The field Project name  is present'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_141"]']), 5)

'Modify project name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_141"]']), '[Do not Edit] Existing Project Auto for Control Tag  Empty Group (Part 2) modif')

'Click on update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(1)

'Verify if the project name has been modified'
String ProjectName = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[1]/div[1]/h3']))

functions.I.print(ProjectName)

'56'
WebUI.verifyMatch(ProjectName, 'Garnier_Ga.Min Neo_2021_[Do not Edit] Existing Project Auto for Control Tag Empty Group (Part 2) modif - MI003394', 
    false)

WebUI.delay(1)

'44 Click on submit ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_24373"]/a[2]']))

WebUI.delay(1)

'Submit to next phase'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Screenshot: Empty Group Page'
WebUI.takeScreenshot()

'76 Click on modify ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]/div[9]/a[2]']))

WebUI.delay(1)

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[1]/a']))

//*[@id="source_15092"]/td[16]/a
'21 Click on submit ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_24373"]/a[2]']))

WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_71"]']), 5)

'Select leader  country'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_71"]']), '1055', false)

'Select Approver countries/zones'
functions.I.select_multiplelist('//*[@id="selSource_72"]', '//*[@id="btnAdd_72"]', '1055')

'Submit to next phase'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//*[@id="source_24371"]/td[13]/span[1]
'70 Verify text'
String lifecycle_status = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24371"]/td[13]/span[1]']))

WebUI.verifyMatch(lifecycle_status, 'Leader MKT: Brief completion', false)

WebUI.closeBrowser()

