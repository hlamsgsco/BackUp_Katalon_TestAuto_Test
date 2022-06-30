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

//USERNAME & PASSWORD FOR LOGIN - STARPACK

def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

String password_suser = data.getValue(2, 1)



def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Starpack = data_urlTestAUTO.getValue(2, 2)


String login = 'flndhx162043'

//GMAIL: Mediabox.modif.com
String password_mediaboxCreation = 'Diadeis*1'

/////////////////////////////////////TEST START ///////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL StarpackTest'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'functions Login'
functions.I.Login_password('suser', password_suser)

'Screenshot : Log in as suser'
WebUI.takeScreenshot()

'Click on the Menu > Settings'
WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_aside_menu"]/ul/li[11]/a/span[2]']))

'Screenshot : Settings Menu'
WebUI.takeScreenshot()


'delay 3'
WebUI.delay(3)

'Click on user management'
WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_aside_menu"]/ul/li[11]/div/ul/li[2]/a/span']))


'delay 1'
WebUI.delay(1)

'Search for login'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="users_table_filter"]/label/input']), login)

WebUI.delay(1)


'Screenshot : Search'
WebUI.takeScreenshot()

'delay 1'
WebUI.delay(1)

'click reset password'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="flndhx162043"]/td[14]/a']))

'Screenshot : Sucess message'
WebUI.takeScreenshot()

String actualmsg = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

String Expectedmsg = 'Login information email sent to ' + login

'Verify Equal: Login information email sent to <LOGIN> '
WebUI.verifyEqual(actualmsg, Expectedmsg)

'Close Browser'
WebUI.closeBrowser()

