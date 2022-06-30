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


/* SCENARIO TESTED :
 THIS TESTCASE SHOULD BE RUN BEFORE RUNNING THE OTHER TEST SUITE SO THAT IT DOES NOT MAKE CONFLICT WITH THE TESTING.
 
 IN THIS TESTCASE, IT WILL VERIFY THE PASSWORD OF THE USERS USED IN THE TESTSUITE. [DREYERS]
 */


///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD DREYERS]
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')

String password_suser = data_Dreyers.getValue(2, 1)
String password_blemco = data_Dreyers.getValue(2, 2)
String password_amassoth = data_Dreyers.getValue(2, 3)
String password_bharandi = data_Dreyers.getValue(2, 4)
String password_mbaughman = data_Dreyers.getValue(2,5)
String password_nturner = data_Dreyers.getValue(2,6)
String password_talexeeva = data_Dreyers.getValue(2,7)
String  password_bmilhomme = data_Dreyers.getValue(2,8)
String password_rjaiven = data_Dreyers.getValue(2,9)

String password_agarcia = data_Dreyers.getValue(2,10)
String password_bcollins = data_Dreyers.getValue(2,11)
String password_jryan = data_Dreyers.getValue(2,12)
String password_lmary = data_Dreyers.getValue(2,13)
/*
 * 
 * agarcia,diadeis
bcollins,diadeis
 */
//DATA FILE URL[DREYER]
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////

//BROWSE & MAXIMIZE BROWSER
WebUI.openBrowser(Url_Dreyer)
WebUI.maximizeWindow()
WebUI.waitForPageLoad(30)

//VERIFICATION OF PASSSWORD FOR:

//1 suser
functions.I.Login_password('suser', password_suser)
functions.I.Logout()

//2 blemco
functions.I.Login_password('blemco', password_blemco)
functions.I.Logout()

//3 amassoth
functions.I.Login_password('amassoth', password_amassoth)
WebUI.delay(1)
functions.I.Logout()

//4 bharandi
functions.I.Login_password('bharandi', password_bharandi)
functions.I.Logout()

//5 mbaughman
functions.I.Login_password('mbaughman', password_mbaughman)
functions.I.Logout()

//6 nturner
functions.I.Login_password('nturner', password_nturner)
functions.I.Logout()

//7talexeeva
functions.I.Login_password('talexeeva', password_talexeeva)
functions.I.Logout()

//8 bmilhomme
functions.I.Login_password('bmilhomme', password_bmilhomme)
functions.I.Logout()


// 9 rjaiven
functions.I.Login_password('rjaiven', password_rjaiven)
functions.I.Logout()

// 10agarcia
functions.I.Login_password('agarcia', password_agarcia)
functions.I.Logout()

// 11bcollins
functions.I.Login_password('bcollins', password_bcollins)
functions.I.Logout()

// 12 jryan
functions.I.Login_password('jryan', password_jryan)
functions.I.Logout()

//13 lmary
functions.I.Login_password('lmary', password_lmary)
functions.I.Logout()


//CLOSE BROWSER
WebUI.closeBrowser()

//////////////////////////////////////////////////////////////////////END TEST  ///////////////////////////////////////////////////