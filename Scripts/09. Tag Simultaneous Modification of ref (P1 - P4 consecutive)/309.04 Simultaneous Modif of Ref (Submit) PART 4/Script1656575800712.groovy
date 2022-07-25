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
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Tag')

String password_jedun = data_Tag.getValue(3, 1) //R
String password_tliu = data_Tag.getValue(3, 8) //R

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)

//READ FROM NOTEPAD
//D:\Upoad_File\zTest_Auto\Test_Projet_Login\Tag\309.01 Tag Project_No
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\309.01 Tag Project_No\\309.01_Tag_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\309.01 Tag Project_No\\309.01_Tag_refID.txt')

////////////////////////CHROME //////////////////////////
//////////////////USING THE SAME PROJECT AND REF AS IN 11.1 TAG SIMULTANEOUS MODIF //////////////////////////////
///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
System.setProperty('webdriver.chrome.driver', 'D:\\Katalon_Studio\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe')

'Brower 1'
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


'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

///////////////////////////////////////WINDOW 1 -  EDIT
'Ref List page: Click on Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[15]/a[3]']))

'Screenshot: W1 Ref submit page'
WebUI.takeScreenshot()

WebUI.delay(1)

/////////////////////////////////WINDOW 2 - super edit'Navigate to URL Tag Release'
'Browser 2'
WebDriver driver2 = new ChromeDriver()

DriverFactory.changeWebDriver(driver2 // first part of testDriverFactory.changeWebDriver(driver2)// second part of test
    )

WebUI.maximizeWindow()

WebUI.navigateToUrl(Url_Tag)

WebUI.waitForPageLoad(30)

'Login as tliu'
functions.I.Login_password('tliu', password_tliu)

'Screenshot: Navigate to URL Tag Release - window 2'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: ref list page (window 2)'
WebUI.takeScreenshot()

'Click submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[13]/a[3]']))

'Screenshot: ref modif page (window 2)'
WebUI.takeScreenshot()

'Select option Product category'
functions.I.SelectFromList_Value('//*[@id="var_57"]', '144')


'Select option Packaging Family'
functions.I.SelectFromList_Value('//*[@id="var_28"]', '62')

'Enter text Capacity'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_54"]']),'222')

'Select option Capacity unit'
functions.I.SelectFromList_Value('//*[@id="var_55"]', '122')


'Select option International artword agency'
functions.I.SelectFromList_Value('//*[@id="var_50"]', '15593')


'Click submit'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

'Verify Status of lifecycle'
functions.I.VerifyMatchText('//*[@id="source_' + refID+ '"]/td[11]/span[1]', 'C&A: Brief completion')


'Screenshot: Ref list page - window 1'
WebUI.takeScreenshot()

///////////////////////////////////////////SWITCH TO WINDOW 1
DriverFactory.changeWebDriver(driver1)

'Screenshot: Modif ref page - window 2'
WebUI.takeScreenshot()

'Click submit'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

'Verify toastr msg'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'Your changes can\'t be saved because another user updated values in this form in the meantime. Please reload the page to display them.')


'Click cancel'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/a']))

WebUI.delay(1)

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[6]/a']))

WebUI.delay(1)

'Click on full phase tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_full_brief"]']))

'Verify that the field is filled'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[3]/div', 'Other')

'Close Browser 1'
WebUI.closeBrowser()

'Switch to Browser 2'
DriverFactory.changeWebDriver(driver2)

'Close Browser 2'
WebUI.closeBrowser()

