import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.google.common.base.Functions
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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.Dimension as Dimension
import org.openqa.selenium.Point as Point
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import com.kms.katalon.core.testobject.ConditionType as ConditionType

//////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - tag
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_jedun = data_Tag.getValue(3, 1) //R
String password_tliu = data_Tag.getValue(3, 8) //R


//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


//CLEAR NOTEPAD 11.01 TO USE IN TC 11.02/ 11.03/ 11.04
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\309.01 Tag_Project_No\\309.01_Tag_ProjectNo.txt')
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\309.01 Tag_Project_No\\309.01_Tag_refID.txt')



////////////////////////CHROME
///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
System.setProperty('webdriver.chrome.driver', 'D:\\Katalon_Studio\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe')

WebDriver driver1 = new ChromeDriver()

DriverFactory.changeWebDriver(driver1) // first part of testDriverFactory.changeWebDriver(driver2)// second part of test

WebUI.navigateToUrl(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//////////////////////////////////////////////WINDOW 1 - ADMIN ///////////////////
///////////////////////////////////////////////////////////////////CREATION OF PROJECT /////////////
'Log in as ADMIN – jedun'
functions.I.Login_password('jedun', password_jedun)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

/////////////////////////////////////CREATION OF PROJECT
'Click on + to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

WebUI.delay(1)

'Screenshot: create a project'
WebUI.takeScreenshot()

'Select project template'
functions.I.SelectFromList_Value('//*[@id="project_template"]', '11')

'Click on create the project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(2)

'Screenshot: Modify  a project'
WebUI.takeScreenshot()

'Enter Project name'
def Project_name = (('AutoTest_Tag_SimultaneousRef_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + 
'_') + functions.I.gettimedate()

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_141"]']), 
    Project_name)

'Project type'
functions.I.SelectFromList_Value('//*[@id="var_12"]', '1025')

'Domain'
functions.I.SelectFromList_Value('//*[@id="var_116"]', '1070')

'Development zone Required'
functions.I.SelectFromList_Value('//*[@id="var_262"]', '16352')


'Enter PAD date'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_14"]']), 
    '10/10/2020')

'Division '
functions.I.SelectFromList_Value('//*[@id="var_15"]', '57')

WebUI.delay(2)

'Signature '
functions.I.SelectFromList_Value('//*[@id="var_16"]', '46')

WebUI.delay(2)

'Franchise '
functions.I.SelectFromList_Value('//*[@id="var_17"]', '12174')
WebUI.delay(2)
'Brand'
functions.I.SelectFromList_Value('//*[@id="var_18"]', '12414')
WebUI.delay(2)
'Fragrance'
functions.I.SelectFromList_Value('//*[@id="var_20"]', '3773')
WebUI.delay(2)
'46.'
functions.I.SelectFromList_Value('//*[@id="var_21"]', '246')
WebUI.delay(2)
'Metier'
functions.I.SelectFromList_Value('//*[@id="var_22"]', '3853')

'Select DMI contacts Multiple list'
functions.I.SelectFromList_Value('//*[@id="selSource_23"]', 'achatin')

functions.I.select_multiplelist('//*[@id="selSource_23"]', '//*[@id="btnAdd_23"]', 'tliu')

WebUI.delay(1)

'C&A contacts'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'asamyn')

WebUI.delay(3)

'Click on update project'
WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(10)

'Get project no.'
String Project_No = functions.I.ProjectNo()

'Screenshot: Ref List page '
WebUI.takeScreenshot()

////////////////////////////////////////////CREATION OF MOTHER REF 
'Click on + to create a ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

'Click on create a brief'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[1]']))

'Screenshot: Ref creation page '
WebUI.takeScreenshot()

'Select ref template'
functions.I.SelectFromList_Value('//*[@id="ref_type"]', '5')

'Click on create a brief'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(1)

'Get the Ref id'
String refID = functions.I.RefID_tag()

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[1]/a']))

WebUI.delay(1)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\309.01 Tag_Project_No\\309.01_Tag_ProjectNo.txt', Project_No)
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\309.01 Tag_Project_No\\309.01_Tag_refID.txt', refID)

///////////////////////////////////////WINDOW 1 - SUPER EDIT
'76admin super edit'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[15]/div[2]/button']), findTestObject('1. Constant/xpath', 
        [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/div[2]/div/a[4]']))

WebUI.delay(1)

'Enter text:W1_SUPER_EDIT_JEDUN '

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_117"]']), 
    'W1_SUPER_EDIT_JEDUN')

currentWindow = WebUI.getWindowIndex()

/////////////////////////////////WINDOW 2 - super edit'Navigate to URL Tag Release'
//WebUI.switchToWindowIndex(currentWindow  + 1)
WebDriver driver2 = new ChromeDriver()

DriverFactory.changeWebDriver(driver2 // first part of testDriverFactory.changeWebDriver(driver2)// second part of test
    )

WebUI.maximizeWindow()

WebUI.navigateToUrl(Url_Tag)

WebUI.waitForPageLoad(30)

functions.I.Login_password('tliu', password_tliu)

'Screenshot: Navigate to URL Tag Release - window 2'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

WebUI.delay(3)
'Tina super edit'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[13]/div/button']), findTestObject('1. Constant/xpath', 
        [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/div/div/a[4]']))

WebUI.delay(1)

'Enter text : W2_SUPER_EDIT_TINA' 
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_117"]']), 
    'W2_SUPER_EDIT_TINA')

'Click update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

'Verify toastr msg'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'Modifications of the reference W2_SUPER_EDIT_TINA____ have been saved')

///////////////////////////////////////////SWITCH TO WINDOW 1
'Switch to Browser 1'
DriverFactory.changeWebDriver(driver1)

'Click on update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

'Verify toastr msg'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'Your changes can\'t be saved because another user updated values in this form in the meantime. Please reload the page to display them.')

'Click cancel'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/a']))

WebUI.delay(1)

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[6]/a']))

WebUI.delay(1)

'Verify that the field has been saved'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/span', 'W2_SUPER_EDIT_TINA')


'Close Browser 1'
WebUI.closeBrowser()

'Switch to Browser 2'
DriverFactory.changeWebDriver(driver2)

'Close Browser 2'
WebUI.closeBrowser()

