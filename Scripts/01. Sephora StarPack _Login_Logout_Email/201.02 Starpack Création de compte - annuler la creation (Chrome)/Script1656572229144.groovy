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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

/* TEST CASE TO VERIFY THE CREATION OF AN USER ACCOUNT THEN THE USER CLICK CANCEL
 * THE USER SHOULD NOT BE PRESENT ON THE LIST OF USER
 * EMAIL SHOULD NOT BE SENT
 */


//USERNAME & PASSWORD FOR LOGIN - STARPACK 
def data = TestDataFactory.findTestData("Data Files/Username_Password/Test_Starpack")
String password_suser = data .getValue(2, 1) //1

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

//GMAIL: Mediabox.cancel@gmail.com // password: Diadeis*1
String password_gmailcancel = 'Diadeis*1'

//Keyword log
KeywordLogger log = new KeywordLogger()



//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////


//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Test '
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

//SCENARIO 1: User has the rights to see Usermanagement
'Login as suser'
functions.I.Login_password('suser', password_suser)

'Screenshot: Login as suser'
WebUI.takeScreenshot()

WebUI.waitForPageLoad(30)

'Verify that Settings is present in the menu'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_aside_menu"]/ul/li[11]/a/span[2]']))

'Click on the Menu > Settings'
WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_aside_menu"]/ul/li[11]/a/span[2]']))

'Screenshot : Settings Menu'
WebUI.takeScreenshot()


'delay 3'
WebUI.delay(3)

'Verify that user management is present'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_aside_menu"]/ul/li[11]/div/ul/li[2]/a/span']))

'Click on user management'
WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_aside_menu"]/ul/li[11]/div/ul/li[2]/a/span']))

WebUI.waitForPageLoad(30)

'Click create user button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div/div[1]/div/a[3]']))

WebUI.waitForPageLoad(30)

'Screenshot: User creation Page'
WebUI.takeScreenshot()

'Enter Text: Last name'
WebUI.setText(findTestObject('1. Constant/01_id_field_id',[('field_id'):'userName']), 'ancell')

'Enter Text: First name'
WebUI.setText(findTestObject('1. Constant/01_id_field_id',[('field_id'):'userFirstName']), 'c')


'Enter Text: E- Mail'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[4]/div/input']), 'Mediabox.cancel@gmail.com')

'Select from List: Company> diadeis'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id',[('field_id'):'userCompany']),  '1', true)

'Select from List: User role > Commercial support'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id',[('field_id'):'userRole']), 'Commercial_support', true)

'delay 1'
WebUI.delay(1)

'Page down'
functions.I.Pagedown()

'Select Role data details Multiplelist Brand Dia'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id',[('field_id'):'selSource_Brand']), '122', true)

'Click on add'
WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="userRoleParams_block"]/div/div/table/tbody/tr/td[2]/input[1]']))

'Verify if the log in is generated automatically'
WebUI.verifyElementAttributeValue(findTestObject('1. Constant/01_id_field_id',[('field_id'):'userLogin']), 'value', 'cancell', 20)

WebUI.waitForPageLoad(30)

'Click on cancel'
WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="CreateUser"]/div[3]/div/a']))

WebUI.delay(3)

'Search for cancel@testautodiadeis.com'
WebUI.setText(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="users_table_filter"]/label/input']), 'cancel@testautodiadeis.com')
 
'delay 1'
WebUI.delay(1)

'Verify Message no matching records found is displayed'
 String CT = WebUI.getText(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="users_table"]/tbody/tr/td']))
 functions.I.verifymsg(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="users_table"]/tbody/tr/td']),'No matching records found', log)


'Screenshot: No matching records found '
WebUI.takeScreenshot()

'Logout as suser'
functions.I.Logout()

'Close Browser'
WebUI.closeBrowser()
