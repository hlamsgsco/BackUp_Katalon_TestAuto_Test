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
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_jedun = data_Tag.getValue(3, 1) //R
String password_tliu = data_Tag.getValue(3, 8) //R


//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Tag = data_urlTESTAUTO.getValue(2, 3)

//READ FROM NOTEPAD
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\309.01 Tag Project_No\\309.01_Tag_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\309.01 Tag Project_No\\309.01_Tag_refID.txt')

////////////////////////CHROME //////////////////////////
//////////////////USING THE SAME PROJECT AND REF AS IN 11.1 TAG SIMULTANEOUS MODIF //////////////////////////////
///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
System.setProperty('webdriver.chrome.driver', 'D:\\Katalon_Studio\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe')

'Browser 1'
WebDriver driver1 = new ChromeDriver()

DriverFactory.changeWebDriver(driver1 )

WebUI.delay(1)

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

'Search for project'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

///////////////////////////////////////WINDOW 1 -  EDIT
'admin submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[15]/a[3]']))

WebUI.delay(1)

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_143"]']), 
    'W1_UPDATE_JEDUN_PART2')

/////////////////////////////////WINDOW 2 - super edit'Navigate to URL Tag Release'

'Browser 2'
WebDriver driver2 = new ChromeDriver()

DriverFactory.changeWebDriver(driver2  )

WebUI.maximizeWindow()

WebUI.delay(1)

'Navigate to TAG'
WebUI.navigateToUrl(Url_Tag)

WebUI.waitForPageLoad(30)

'Login as tliu'
functions.I.Login_password('tliu', password_tliu)

'Screenshot: Navigate to URL Tag Release - window 2'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'tlium submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[13]/a[3]']))

WebUI.delay(1)

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_143"]']), 
    'W2_UPDATE_TLIU_PART2')

'Screenshot: Update page - window1 '
WebUI.takeScreenshot()

'admin update'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[1]']))

WebUI.delay(1)

'Verify that ref list is display on page'
WebUI.verifyTextPresent('References List', false)

'Screenshot: Ref list page - window 1'
WebUI.takeScreenshot()

///////////////////////////////////////////SWITCH TO WINDOW 1
'Switch to Browser 1'
DriverFactory.changeWebDriver(driver1)

'Screenshot: Modif ref page - window 2'
WebUI.takeScreenshot()

'Click on save'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[1]']))

'Verify toastr msg'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'Your changes can\'t be saved because another user updated values in this form in the meantime. Please reload the page to display them.')

'Click cancel'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/a']))

WebUI.delay(1)

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+ '"]/td[6]/a']))
WebUI.delay(1)

String text = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[8]/div']))

'Verify text has been saved.'
WebUI.verifyMatch(text, 'W2_UPDATE_TLIU_PART2', false)

'Close Browser 1'
WebUI.closeBrowser()

'Switch Browser 2'
DriverFactory.changeWebDriver(driver2)

'Close Broswer 2'
WebUI.closeBrowser()

