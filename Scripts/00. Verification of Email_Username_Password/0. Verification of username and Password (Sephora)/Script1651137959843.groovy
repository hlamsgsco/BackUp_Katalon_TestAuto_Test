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


/*  SCENARIO TESTED :
 THIS TESTCASE SHOULD BE RUN BEFORE RUNNING THE OTHER TEST SUITE SO THAT IT DOES NOT MAKE CONFLICT WITH THE TESTING.
 
 IN THIS TESTCASE, IT WILL VERIFY THE PASSWORD OF THE USERS USED IN THE TESTSUITE. [SEPHORA]
 */


///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD [SEPHORA]
def data_Sephora = TestDataFactory.findTestData("Data Files/Username_Password/Test_Sephora")
String password_atran = data_Sephora .getValue(2, 1)
String password_marketing = data_Sephora .getValue(2, 2)
String password_regulatory =data_Sephora.getValue(2, 3)
String password_studio = data_Sephora .getValue(2, 4)
String password_iraz =data_Sephora .getValue(2, 5)
String password_cmouzawak = data_Sephora .getValue(2, 6)
String password_aalbeaux =data_Sephora .getValue(2, 7)
String password_hgarnier  =data_Sephora .getValue(2, 8)
String password_emartineau= data_Sephora.getValue(2,9)
String password_suser	= data_Sephora.getValue(2,10)
String password_lmorel	= data_Sephora.getValue(2,11)
String password_ageindreau	= data_Sephora.getValue(2,12)

String password_ytallant	= data_Sephora.getValue(2,13)

//DATA FILE URL [SEPHORA]
def data_urlTESTAUTO = TestDataFactory.findTestData("Data Files/URL/URL_testauto")
String Url_Sephora = data_urlTESTAUTO .getValue(2, 1)


//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////

//BROWSE & MAXIMIZE BROWSER
WebUI.openBrowser(Url_Sephora)

WebUI.maximizeWindow()


//VERIFICATION OF PASSSWORD FOR:

//1 atran
functions.I.Login_password('atran', password_atran)
functions.I.Logout()

//2 marketing
functions.I.Login_password('marketing', password_marketing)
functions.I.Logout()

//3 regulatory
functions.I.Login_password('regulatory', password_regulatory)
functions.I.Logout()

//4 studio
functions.I.Login_password('studio', password_studio)
functions.I.Logout()

//5 iraz
functions.I.Login_password('lraz', password_iraz)
functions.I.Logout()

//6 cmouzawak
functions.I.Login_password('cmouzawak', password_cmouzawak)
functions.I.Logout()

//7 aalbeaux
functions.I.Login_password('aalbeaux', password_aalbeaux)
functions.I.Logout()

//8 hargnier
functions.I.Login_password('hgarnier', password_hgarnier)
functions.I.Logout()

//9 emartineau
functions.I.Login_password('emartineau', password_emartineau)
functions.I.Logout()
//10 suser
functions.I.Login_password('suser', password_suser)
functions.I.Logout()

//11 lmorel
functions.I.Login_password('lmorel', password_lmorel)
functions.I.Logout()


//12 ageindreau
functions.I.Login_password('ageindreau', password_ageindreau)
functions.I.Logout()

//13 ytallant
functions.I.Login_password('ytallant', password_ytallant)
functions.I.Logout()

//CLOSE BROWSER
WebUI.closeBrowser()

//////////////////////////////////////////////////////////////////////END TEST  ///////////////////////////////////////////////////