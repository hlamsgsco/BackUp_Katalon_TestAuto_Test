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
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')
String password_suser = data_Dreyers.getValue(2, 1)

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)


///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Test'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

/////////////////////////////////SCENARIO 3  SCOPE PROJECT AND REF ////////////////////////////////////////////
String Project_No = 'MI000208'

'Screenshot: Navigate to URL Dreyer Release'
WebUI.takeScreenshot()

'Log in as ADMIN – suser'
functions.I.Login_password('suser', password_suser)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page of Project MI000215'
WebUI.takeScreenshot()

'Click on Modify this Project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[2]']))

WebUI.delay(5)

'Screenshot: Modify this project  PAge'
WebUI.takeScreenshot()

'Verify * is displayed for the field Project Type'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="field_var_24"]/label/img']), 
    10)

'Verify * is displayed for the field APL requirement '
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3877_ModifFiche"]/div[2]/div[2]/label/img']), 
    10)

'Verify * is displayed for the field Creative Services '
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3880_ModifFiche"]/div[2]/div[2]/label/img']), 
    10)

'Verify * is displayed for the field Brand'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3880_ModifFiche"]/div[2]/div[2]/label/img']), 
    10)

'Verify * is displayed for the field Year'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3880_ModifFiche"]/div[2]/div[3]/label/img']), 
    10)

'Verify * is displayed for the field Separator'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3880_ModifFiche"]/div[2]/div[5]/label/img']), 
    10)

'Verify * is displayed for the field Production Agency'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3880_ModifFiche"]/div[2]/div[6]/label/img']), 
    10)

WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3895_ModifFiche"]/div[2]/div[1]/label/img']), 
    5)

'Screenshot: Modify this project  PAge'
WebUI.takeScreenshot()

'Verify * is displayed for the field Marketing'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3895_ModifFiche"]/div[2]/div[1]/label/img']), 
    10)

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/a']))

WebUI.delay(10)
'Screenshot: Modify this project  PAge'
WebUI.takeScreenshot()

//EDIT PAGE
'Click on edit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_2157"]/td[16]/a[1]']))

'Screenshot: Edit PAge'
WebUI.takeScreenshot()

'Verify * is displayed for the field Production Agency'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3770_ModifFiche"]/div[2]/div[4]/label/img']), 
    10)

'Verify * is displayed for the field Separator'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3770_ModifFiche"]/div[2]/div[5]/label/img']), 
    10)

'Verify * is displayed for the field Creative Services'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3785_ModifFiche"]/div[2]/div[1]/label/img']), 
    10)


'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[1]/a']))

'Screenshot: REf Lsit pa PAge'
WebUI.takeScreenshot()

//SUPER EDIT PAGE
'Super Edit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_2157"]/td[16]/div[2]/button']))

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_2157"]/td[16]/div[2]/div/a[4]']))

WebUI.delay(1)



'Screenshot: Super Edit PAge'
WebUI.takeScreenshot()

'Verify * is displayed for the field Separator'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3951_ModifFiche"]/div[2]/div[4]/label/img']), 
    10)

'Verify * is displayed for the field Production Agency'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3951_ModifFiche"]/div[2]/div[5]/label/img']), 
    10)

'Screenshot: Super Edit PAge'
WebUI.takeScreenshot()

'Verify * is displayed for the field Creative Services'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3968_ModifFiche"]/div[2]/div[1]/label/img']), 
    10)

'Verify * is displayed for the field  Marketing'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3968_ModifFiche"]/div[2]/div[2]/label/img']), 
    10)

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/a']))

//PROCEED TO NEXT PHASE PAGE
'Click on proceed to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_2157"]/td[16]/a[2]']))

'Screenshot: Proceed to next phase  Page'
WebUI.takeScreenshot()

'Verify * is displayed for the field Production Agency'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3770_ModifFiche"]/div[2]/div[4]/label/img']), 
    10)

'Verify * is displayed for the field Separator'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3770_ModifFiche"]/div[2]/div[5]/label/img']), 
    10)

WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3785_ModifFiche"]/div[2]/div[1]/label/img']), 
    5)

'Verify * is displayed for the field Creative Services '
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3785_ModifFiche"]/div[2]/div[1]/label/img']), 
    10)

'Verify * is displayed for the field Marketing'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_3785_ModifFiche"]/div[2]/div[2]/label/img']), 
    10)

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/a']))

WebUI.closeBrowser()
