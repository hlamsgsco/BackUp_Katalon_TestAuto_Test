import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

//CHANGES DONE ON: 28/04/2022
/*
 IN THIS TEST CASE, BELOW SCENARIOS ARE TESTED: 
 Scenario 1: Log in as fake user
'Scenario 2: Log in Correct Username &  Correct password'
'Scenario 3: Enter correct username & incorrect password'
'Scenario 4: Enter empty password'
'Scenario 5: Enter Empty username '
'Scenario 6: Empty Username & Password'
 */
///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD [SEPHORA]
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Test_Sephora')

String password_aalbeaux = data_Sephora.getValue(2, 7)

//DATA FILE URL[SEPHORA]
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Sephora = data_urlTESTAUTO.getValue(2, 1)

KeywordLogger log = new KeywordLogger()

//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////
'Navigate to URL Sephora Test '
WebUI.openBrowser(Url_Sephora)

WebUI.maximizeWindow()

//SCENARIO 1 : Connexion avec un mauvais username
'Scenario 1: Log in as fake user'
functions.I.Login_password('fake_user', 'dchi')

'Verify that access is denied'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="errorline"]']))

'Verify Error msgs is displayed'
functions.I.verifymsg(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="errorline"]']), 'Accès refusé', log)

'Screenshot for scenario 1'
WebUI.takeScreenshot()

WebUI.delay(2)

'Clear Username & Password'
functions.I.ClearLoginandPasswordField()

//SCENARIO 2 : Connexion avec un bon username et un bon mdp
long ts1 = System.currentTimeMillis()

'Scenario 2: Log in Correct Username &  Correct password'
functions.I.Login_password('aalbeaux', password_aalbeaux)

WebUI.waitForPageLoad(60)

'Verify if name is correctly displayed'
functions.I.verifymsg(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/h1/span[1]']), 
    'Aline', log)

long ts2 = System.currentTimeMillis()

println(('Login duration: ' + (ts2 - ts1)) + ' miliseconds.')

'Screenshot for scenario 2: Log in successfully'
WebUI.takeScreenshot()

WebUI.delay(2)

WebUI.waitForPageLoad(30)

'Logout'
functions.I.Logout()

'Verify that user is back on login page'
WebUI.verifyElementVisible(findTestObject('Object Repository/HL Full Lifecycle/1 LoginPage_input_Login_field'))

'Screenshot for scenario 2: Log out  successfully'
WebUI.takeScreenshot()

WebUI.delay(2)

//SCENARIO 3 : Connexion avec un mauvais mdp
'Scenario 3: Enter correct username & incorrect password'
functions.I.Login_password('aalbeaux', 'yoo')

'Access should be denied'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="errorline"]']))

functions.I.verifymsg(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="errorline"]']), 'Accès refusé', log)

'Screenshot for scenario 3: Error message is diplayed'
WebUI.takeScreenshot()

WebUI.delay(2)

'Clear Username & Password'
functions.I.ClearLoginandPasswordField()

//SCENARIO 4 : Connexion avec le champ mdp vide
'Scenario 4: Enter empty password'
functions.I.Login_password('aalbeaux', '')

'Access should be denied'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="errorline"]']))

functions.I.verifymsg(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="errorline"]']), 'Accès refusé', log)

'Screenshot for scenario 4: Error message is diplayed'
WebUI.takeScreenshot()

WebUI.delay(2)

'Clear Username & Password'
functions.I.ClearLoginandPasswordField()

//SCENARIO 5 : Connexion avec le champ username vide
'Scenario 5: Enter Empty username '
functions.I.Login_password('', 'diadeis')

'Access should be denied'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="errorline"]']))

functions.I.verifymsg(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="errorline"]']), 'Accès refusé', log)

WebUI.delay(2)

'Clear Username & Password'
functions.I.ClearLoginandPasswordField()

//SCENARIO 6 : Connexion avec le champ username vide
'Scenario 6: Empty Username & Password'
functions.I.Login_password('', '')

'Access should be denied'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="errorline"]']))

functions.I.verifymsg(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="errorline"]']), 'Accès refusé', log)

'Screenshot for scenario 6: Error message is diplayed'
WebUI.takeScreenshot()

WebUI.closeBrowser()

