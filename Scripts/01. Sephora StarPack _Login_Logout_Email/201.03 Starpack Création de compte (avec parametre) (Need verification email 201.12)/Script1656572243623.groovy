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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

//DATA FILE USERNAME & PASSWORD [STARPACK]
def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

String password_suser = data.getValue(2, 1 //1
    )

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

//CLEAR NOTEPAD
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\201.03 StarPack_Login username\\login.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\201.03 StarPack_Login username.txt')

//Keyword log
KeywordLogger log = new KeywordLogger()

//GMAIL: Mediaboxtest.Creation@gmail.com 
String Email = 'mediaboxtest.creation@gmail.com'

String password_mediaboxCreation = 'Diadeis*1'

/////////////////////////////////////TEST START ///////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Test'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

//SCENARIO : User has the rights to see Usermanagement
'Login as suser'
functions.I.Login_password('suser', password_suser)

'Screenshot: Login as suser'
WebUI.takeScreenshot()

WebUI.waitForPageLoad(30)

'Click on the Menu > Settings'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_aside_menu"]/ul/li[11]/a/span[2]']))

'Screenshot: Menu > Settings'
WebUI.takeScreenshot()

'delay 3'
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

def Lastname = ('LN' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) + today.format('HHmmss')

def FirstName = 'FN' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)

'Enter Text: Last name'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userName']), Lastname)

'Enter Text: First name'
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userFirstName']), FirstName)

'Enter Text: E- Mail'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userDetails"]/div[2]/div[4]/div/input']), Email)

'Select from List: Company> diadeis'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userCompany']), '1', true)

'Select from List: User role > Commercial support'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userRole']), 'Commercial_support', 
    true)

'delay 1'
WebUI.delay(1)

'Page down'
functions.I.Pagedown()

'Select Role data details Multiplelist Brand Dia'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'selSource_Brand']), '122', true)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="userRoleParams_block"]/div/div/table/tbody/tr/td[2]/input[1]']))

String login = WebUI.getAttribute(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userLogin']), 'value')

WebUI.waitForPageLoad(30)

'Verify that the checkbox is checked'
functions.I.VerifyCheckboxChecked('Track Click', findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userTrackClick']))

String FirstName1 = WebUI.getAttribute(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userFirstName']), 'value')

String LastName1 = WebUI.getAttribute(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userName']), 'value')

'delay 3'
WebUI.delay(5)
//NOTEPAD
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\201.03 StarPack_Login username\\Name.txt', 
    (FirstName1 + ' ') + LastName1)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\201.03 StarPack_Login username\\login.txt', 
    login)

'delay 3'
WebUI.delay(10)

'Click on save and send email'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="CreateUser"]/div[3]/div/button[2]']))

'delay 3'
WebUI.delay(5)
/*
WebUI.navigateToUrl(Url_Starpack)


//SCENARIO : User has the rights to see Usermanagement
'Login as suser'
functions.I.Login_password('suser', password_suser)

'Screenshot: Login as suser'
WebUI.takeScreenshot()

WebUI.waitForPageLoad(30)

'Click on the Menu > Settings'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_aside_menu"]/ul/li[11]/a/span[2]']))

'Screenshot: Menu > Settings'
WebUI.takeScreenshot()

'delay 3'
WebUI.delay(3)
*/
'44 Search for login'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="users_table_filter"]/label/input']), login)

'delay 1'
WebUI.delay(1)

functions.I.verifymsg(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id=\'' + login) + '\']/td[5]']), login, log)

'Screenshot: User Management page'
WebUI.takeScreenshot()

'VErification of the new created user'
WebUI.delay(1)

'Click on edit user'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]/a']))

'Verify Last name'
String value1 = WebUI.getAttribute(findTestObject('Object Repository/Starpack USermanagement/1.06 UpdateUser id_UpdateUser_div2divdiv1div_no_divinput', 
        [('no') : '2']), 'value')

functions.I.print(value1)

'Verify Equal: Last Name'
WebUI.verifyEqual(value1, Lastname)

'Verify First Name'
String value2 = WebUI.getAttribute(findTestObject('Object Repository/Starpack USermanagement/1.06 UpdateUser id_UpdateUser_div2divdiv1div_no_divinput', 
        [('no') : '3']), 'value')

'Verify Equal: First name'
WebUI.verifyEqual(value2, FirstName)

String value3 = WebUI.getAttribute(findTestObject('Object Repository/Starpack USermanagement/1.06 UpdateUser id_UpdateUser_div2divdiv1div_no_divinput', 
        [('no') : '4']), 'value')

'Verify Equal: Email'
WebUI.verifyEqual(value3, Email)

'Verify that Diadeis is selected in List Company'
functions.I.VerifyListSelected_byValue('Company', findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userCompany']), 
    '1')

'Verify that the checkbox is checked'
functions.I.VerifyCheckboxChecked('Track Click', findTestObject('1. Constant/01_id_field_id', [('field_id') : 'userTrackClick']))

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="UpdateUser"]/div[2]/div/div[2]/div/a']))

'delay 1'
WebUI.delay(1)

//verification OF ROLES DATA
'Verify Roles data'

'Search for login'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="users_table_filter"]/label/input']), login)

'Click on roles'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div/div/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]/a']))

'delay 1'
WebUI.delay(1)

'Verify Brand selected Dia 122'
String value_role = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selDest_Brand"]/option']), 
    'value')

WebUI.verifyEqual(value_role, '122')

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="UpdateUser"]/div[3]/div/a']))

'Close Browser'
WebUI.closeBrowser()

