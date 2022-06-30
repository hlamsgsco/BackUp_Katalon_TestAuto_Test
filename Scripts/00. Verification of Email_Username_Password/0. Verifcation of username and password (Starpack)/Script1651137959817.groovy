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
THIS TESTCASE SHOULD BE RUN BEFORE EXECUTING THE OTHER TEST SUITE SO THAT IT DOES NOT MAKE CONFLICT WITH THE TESTING.

IN THIS TESTCASE, IT WILL VERIFY THE PASSWORD OF THE USERS USED IN THE TESTSUITE. [STARPACK]
*/


///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILES USERNAME_PASSWORD [STARPACK]
//def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

def data = TestDataFactory.findTestData('null')

String password_suser = data.getValue(2, 1)
String password_aherms =data.getValue(2, 2)
String password_agluszczynska = data.getValue(2, 3)
String password_jmaciaszczyk =data.getValue(2, 4)
String password_aterreshernandez = data .getValue(2, 5)
String password_amartin_arbol = data .getValue(2, 6)
String password_adelamatanieves = data .getValue(2, 7)
String password_kcannoosamy_dia = data .getValue(2, 8)
String password_jmarest = data.getValue(2, 9)
String password_jmartinez_almarza = data.getValue(2, 10)
String password_dcrow = data.getValue(2, 11)
String password_ncurnier = data.getValue(2, 12)
String password_mdelrio = data .getValue(2, 13)
String password_1packaging2 = data.getValue(2, 14)
String password_afron = data.getValue(2, 15)
String password_ysanzmonedero = data.getValue(2, 16)
String password_bsolletbravo = data.getValue(2, 17)
String password_agarciasanchez = data.getValue(2, 18)

/*
//DATA FILES URL [STARPACK]
def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Starpack = data_urlTestAUTO.getValue(2, 2)
*/
def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Starpack = data_urlTestAUTO.getValue(2, 7)

//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
WebUI.openBrowser( Url_Starpack)

WebUI.maximizeWindow()


//VERIFICATION OF PASSSWORD FOR:

//1. suser
functions.I.Login_password('suser', password_suser)
functions.I.Logout()

//2. aherms
functions.I.Login_password('aherms', password_aherms)
functions.I.Logout()

//3. agluszczynska
functions.I.Login_password('agluszczynska', password_agluszczynska)
functions.I.Logout()

//4. jmaciaszczyk
functions.I.Login_password('jmaciaszczyk', password_jmaciaszczyk)
functions.I.Logout()

//5. aterreshernandez
functions.I.Login_password('aterreshernandez', password_aterreshernandez)
functions.I.Logout()

//6. amartin_arbol
functions.I.Login_password('amartin_arbol', password_amartin_arbol)
functions.I.Logout()

//7. adelamatanieves
functions.I.Login_password('adelamatanieves', password_adelamatanieves)
functions.I.Logout()

//8. kcannoosamy_dia
functions.I.Login_password('kcannoosamy_dia', password_kcannoosamy_dia)
functions.I.Logout()

//9 jmarest
functions.I.Login_password('jmarest', password_jmarest)
functions.I.Logout()


//10 jmartinez_almarza
functions.I.Login_password('jmartinez_almarza', password_jmartinez_almarza)
functions.I.Logout()




//11 dcrow
functions.I.Login_password('dcrow', password_dcrow )
functions.I.Logout()


//12 ncurnier 
functions.I.Login_password('ncurnier', password_ncurnier )
functions.I.Logout()

//13 mdelrio
functions.I.Login_password('mdelrio', password_mdelrio)
functions.I.Logout()

//14  1packaging2 
functions.I.Login_password('1packaging2', password_1packaging2 )
functions.I.Logout()

//15 afro
functions.I.Login_password('afron', password_afron)
functions.I.Logout()

// 16 String password_ysanzmonedero = data.getValue(2, 16)
functions.I.Login_password('ysanzmonedero', password_ysanzmonedero)
functions.I.Logout()

// 17 String password_bsolletbravo = data.getValue(2, 17)
functions.I.Login_password('bsolletbravo', password_bsolletbravo)
functions.I.Logout()

// 18 String password_agarciasanchez = data.getValue(2, 18)
functions.I.Login_password('agarciasanchez', password_agarciasanchez)
functions.I.Logout()

//CLOSE BROWSER
WebUI.closeBrowser()

//////////////////////////////////////////////////////////////////////END TEST ///////////////////////////////////////////////////
