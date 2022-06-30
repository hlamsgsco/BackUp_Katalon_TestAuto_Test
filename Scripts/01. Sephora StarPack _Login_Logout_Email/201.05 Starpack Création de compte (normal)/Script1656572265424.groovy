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
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.apache.commons.lang.RandomStringUtils

import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

def data = TestDataFactory.findTestData("Data Files/Username_Password/Test_Starpack")
String password_suser = data .getValue(2, 1) //1

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Starpack = data_urlTestAUTO.getValue(2, 2)


KeywordLogger log = new KeywordLogger()

// EMAIL - PASSWORD
String password_mediaboxCreation = 'Diadeis*1'


//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Test'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

WebUI.takeScreenshot()


    'SCENARIO : User has the rights to see Usermanagement'
    'Login as suser'
    functions.I.Login_password('suser', password_suser)

    WebUI.takeScreenshot()

    WebUI.waitForPageLoad(30)

    'Click on the Menu > Settings'
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_aside_menu"]/ul/li[11]/a/span[2]']))

    WebUI.takeScreenshot()

    WebUI.delay(3)

    'Click user management'
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_aside_menu"]/ul/li[11]/div/ul/li[2]/a/span']))

    WebUI.waitForPageLoad(30)

    'Click create user button'
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div/div[1]/div/a[3]']))

    WebUI.waitForPageLoad(30)

    'Screenshot: User creation Page'
    WebUI.takeScreenshot()
	
	today = new Date()
	def Lastname = (('LN' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)+ today.format("HHmmss")) )
	def FirstName = (('FN' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) ) 
	
    'Enter Text: Last name'
    WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userName']), Lastname)

    'Enter Text: First name'
    WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userFirstName']),FirstName)


    'Enter Text: E- Mail'
    WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[4]/div/input']), 
        'mediaboxtest.creation@gmail.com')

    'Select from List: Company> diadeis'
    WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', 
            [('field_id') : 'userCompany']), '1', true)

    'Select from List: User role > admin'
    WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', 
            [('field_id') : 'userRole']), 'admin', true)
	
	'Uncheck Do not track clicks'
	WebUI.click(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userTrackClick']))
	 
	
	
    WebUI.delay(1)

    functions.I.Pagedown()

   
    String login = WebUI.getAttribute(findTestObject('1. Constant/01_id_field_id',   [('field_id') : 'userLogin']), 'value')
	

	
	
		functions.I.print(login)

    WebUI.waitForPageLoad(30)

  
    'Click on save' 
      WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[1]']))

    WebUI.delay(3)

  

    'Search for login'
    WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="users_table_filter"]/label/input']), login)

    WebUI.delay(1)

   
	
	functions.I.verifymsg(findTestObject('1. Constant/xpath', [('xpath') : "//*[@id='" + login+"']/td[5]"]),
		login, log)

    WebUI.takeScreenshot()

    functions.I.Logout()
	
	WebUI.closeBrowser()
	