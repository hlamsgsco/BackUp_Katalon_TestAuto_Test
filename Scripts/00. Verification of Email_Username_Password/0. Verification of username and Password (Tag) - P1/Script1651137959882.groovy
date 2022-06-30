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
import ch.qos.logback.core.joran.conditional.ElseAction as ElseAction
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

/*  SCENARIO TESTED :
 
THIS TESTCASE SHOULD BE RUN BEFORE RUNNING THE OTHER TEST SUITE SO THAT IT DOES NOT MAKE CONFLICT WITH THE TESTING.

IN THIS TESTCASE, IT WILL VERIFY THE PASSWORD OF THE USERS USED IN THE TESTSUITE. [TAG]
FOR TAG THE VERIFICATION OF USERS ARE DIFFERENCT BCOZ OF THE DUMP

PART 1: CHANGING THE PASSWORD OF THE USER
PART 2:VERIFICATION OF PASSWORD

*/
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD [TAG]
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_jedun = data_Tag.getValue(3, 1)

String password_rrowland = data_Tag.getValue(3, 2)

String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 5)

String password_mderdour = data_Tag.getValue(3, 6)

String password_achatin = data_Tag.getValue(3, 7)

String password_tliu = data_Tag.getValue(3, 8)

String password_ccaramella = data_Tag.getValue(3, 9)

String password_achay = data_Tag.getValue(3, 10)

String password_cbono = data_Tag.getValue(3, 11)

String password_pmareri = data_Tag.getValue(3, 12)

String password_qeuzen = data_Tag.getValue(3, 13)

String password_alanglois = data_Tag.getValue(3, 14)

String password_bde_villeneuve = data_Tag.getValue(3, 15)

String password_scai = data_Tag.getValue(3, 16)

String password_bzavaglia = data_Tag.getValue(3, 17)

String password_mraoul = data_Tag.getValue(3, 18)

String password_idiaz = data_Tag.getValue(3, 19)

String password_asalama = data_Tag.getValue(3, 20)

String password_suser = data_Tag.getValue(3, 21)

String password_etaraskin = data_Tag.getValue(3, 22)

String password_avieu_brasseur = data_Tag.getValue(3, 23)

String password_sguy = data_Tag.getValue(3, 24)

String password_asch = data_Tag.getValue(3, 25)

String password_bmartin = data_Tag.getValue(3, 26)

String password_icoindeau = data_Tag.getValue(3, 27)

String password_alafon = data_Tag.getValue(3, 28)

String password_aamiot = data_Tag.getValue(3, 29)

String password_daguirre = data_Tag.getValue(3, 30)

String password_aomoto = data_Tag.getValue(3, 31)

String password_apetit = data_Tag.getValue(3, 32)

String password_asamyn = data_Tag.getValue(3, 33)

String password_mcazeaux = data_Tag.getValue(3, 34)

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)

//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()


//1 jedun
functions.I.Login_password_2('jedun', password_jedun)

//2 rrowland
functions.I.Login_password_2('rrowland', password_rrowland)

//3 stest
functions.I.Login_password_2('stest', password_stest)

//4 itroin
functions.I.Login_password_2('itroin', password_itroin)

//5 igedik
functions.I.Login_password_2('igedik', password_igedik)

//6 mderdour
functions.I.Login_password_2('mderdour', password_mderdour)

//7 achatin
functions.I.Login_password_2('achatin', password_achatin)

//8 tliu
functions.I.Login_password_2('tliu', password_tliu)

//9 ccaramella
functions.I.Login_password_2('ccaramella', password_ccaramella)

//10 achay
functions.I.Login_password_2('achay', password_achay)

//11cbono
functions.I.Login_password_2('cbono', password_cbono)

//12 pmareri
functions.I.Login_password_2('pmareri', password_pmareri)

//13  qeuzen
functions.I.Login_password_2('qeuzen', password_qeuzen)

//14  alanglois
functions.I.Login_password_2('alanglois', password_alanglois)

//15 bde_villeneuve
functions.I.Login_password_2('bde_villeneuve', password_bde_villeneuve)

//16 scai
functions.I.Login_password_2('scai', password_scai)

//17 bzavaglia
functions.I.Login_password_2('bzavaglia', password_bzavaglia)

//18 mraoul
functions.I.Login_password_2('mraoul', password_mraoul)

//19 idiaz 
functions.I.Login_password_2('idiaz', password_idiaz)

//20 asalama
functions.I.Login_password_2('asalama', password_asalama)

// 21 suser 
functions.I.Login_password_2('suser', password_suser)

//22 etaraski 
functions.I.Login_password_2('etaraskin', password_etaraskin)

//23 avieu_brasseur 
functions.I.Login_password_2('avieu_brasseur', password_avieu_brasseur)

//24 sguy
functions.I.Login_password_2('sguy', password_sguy)

//25 asch
functions.I.Login_password_2('asch', password_asch)

//26 bmartin
'66'
functions.I.Login_password_2('bmartin', password_bmartin)

//27 icoindeau 
functions.I.Login_password_2('icoindeau', password_icoindeau)

//28 alafon 
functions.I.Login_password_2('alafon', password_alafon)

//29 aamiot 
functions.I.Login_password_2('aamiot', password_aamiot)

//30 daguirre 
functions.I.Login_password_2('daguirre', password_daguirre)

//31 aomoto
functions.I.Login_password_2('aomoto', password_aomoto)

//32 apetit 
functions.I.Login_password_2('apetit', password_apetit)

//33 asamyn 
functions.I.Login_password_2('asamyn', password_asamyn)

//33 password_mcazeaux
functions.I.Login_password_2('mcazeaux', password_mcazeaux)

//CLOSE BROWSER
WebUI.closeBrowser()

