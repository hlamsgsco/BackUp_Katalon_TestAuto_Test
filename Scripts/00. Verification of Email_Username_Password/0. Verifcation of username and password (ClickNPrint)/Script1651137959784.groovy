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

/* SCENARIO TESTED: 
 THIS TESTCASE SHOULD BE RUN BEFORE EXECUTING THE OTHER TEST SUITE SO THAT IT DOES NOT MAKE CONFLICT WITH THE TESTING.
 
 IN THIS TESTCASE, IT WILL VERIFY THE PASSWORD OF THE USERS USED IN THE TESTSUITE. [Click N Print]
 */

///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD [CLICKNPRINT]
def data = TestDataFactory.findTestData("Data Files/Username_Password/Test_ClicknPrint")
String password_suser = data .getValue(2, 1)
String password_gbouquard =data .getValue(2, 2)
String password_jde_rcr = data .getValue(2, 3)

//DATA FILE URL[CLICKNPRINT]
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_ClicknPrint = data_urlTESTAUTO.getValue(2, 6)

//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////

//BROWSE & MAXIMIZE BROWSER
WebUI.openBrowser( Url_ClicknPrint)

WebUI.maximizeWindow()


//VERIFICATION OF PASSSWORD FOR:
//1. suser
functions.I.Login_password('suser', password_suser)
functions.I.Logout()


//2. gbouquard
functions.I.Login_password('gbouquard', password_gbouquard )
functions.I.Logout()

//3. jde_rcr
functions.I.Login_password('jde_rcr', password_jde_rcr )
functions.I.Logout()

//CLOSE BROWSER
WebUI.closeBrowser()

//////////////////////////////////////////////////////////////////////END TEST  ///////////////////////////////////////////////////