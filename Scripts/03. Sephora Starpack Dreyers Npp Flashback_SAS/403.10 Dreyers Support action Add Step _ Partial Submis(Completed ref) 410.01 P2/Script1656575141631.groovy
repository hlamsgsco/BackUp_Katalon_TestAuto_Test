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

/*SCEANRIO TESTED
Restart for marketing, regulatory and Tech Pack (Add a step)
Vérifier que le bouton SAS s'affiche sur le ref list page et le lifecycle tab
S'il y a beaucoup d'option, vérifier que le tooltip 'Support action shortcuts' s'affiche correctement
Vérifier que le popup reason for support action s'affiche
Vérifier que le toastr 'missing reason' s'affiche si le support action reason n'est pas sélectionné.
Vérifier qu'un step est ajouté.
*/
///////////////////////////////////BEFORE TEST ///////////////////////////////////////
//DATA FILE: USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')
String password_blemco = data_Dreyers.getValue(2, 2) //R
String password_amassoth = data_Dreyers.getValue(2, 3) //R
String password_nturner = data_Dreyers.getValue(2, 6) //R
String password_bmilhomme = data_Dreyers.getValue(2, 8) //R
String password_rjaiven = data_Dreyers.getValue(2, 9) //R

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)

//READ FROM NOTEPAD
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_ Login\\Dreyers\\410.01\\410.01_Dreyers_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_ Login\\Dreyers\\410.01\\410.01_Dreyers_refID_Design(M).txt')
String refID_daughter1 = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_ Login\\Dreyers\\410.01\\410.01_Dreyers_refID_Deliverable(D).txt')
String refID_APL = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_ Login\\Dreyers\\410.01\\410.01_Dreyers_refID_APL(GD).txt')
String refID_LI = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_ Login\\Dreyers\\410.01\\410.01_Dreyers_refID_LI(GD).txt')

///////////////////////////// TEST BEGIN ///////////////////////////////////////////////////////////
'Navigate to URL Dreyers Release'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

///////////////////////////////// NAVIGATING TO DREYERS  ////////////////////////////////////////////
'Screenshot: Navigate to URL Dreyer Test'
WebUI.takeScreenshot()

'Log in as CS blemco'
functions.I.Login_password('blemco', password_blemco)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Verify if the button support action is displayed'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID_LI + '"]/td[17]/div[1]/button']))

WebUI.delay(1)

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(2)

'Verify tooltip support actions shortcuts'
String Actual_SAS1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

WebUI.verifyMatch(Actual_SAS1, 'Support action shortcuts', false)

/////////////////////////////////////////////SCEANRIO 1 :RESTART FOR MKT, RG & TECH PACK//////////////////////////////////
'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[10]/a']))

'Go the lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: Lifecycle tab'
WebUI.takeScreenshot()

WebUI.delay(2)

'Click on step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li/a']))

WebUI.delay(1)

'Screenshot: SAS'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify if the button support action is displayed'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div/div/div[1]/div[2]/div/button']))

WebUI.delay(1)

'Screenshot: tooltip'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify tooltip support actions shortcuts'
String Actual_SAS = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

WebUI.verifyMatch(Actual_SAS, 'Support action shortcuts', false)

'Click on SAS button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div/div/div[1]/div[2]/div/button']))

WebUI.delay(1)

'no of option present '
int x = 20
int i = 1

while ( i <=x)
{
	String Expected_SAS_Selected2 = 'Restart for Marketing, Regulatory and Tech Pack'
	String xpath_SAS2 ='/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div/div/div[1]/div[2]/div/div/a['+i+']'
	
	
	String Actual_SAS2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS2]))
	functions.I.print(i)
	
	if (Actual_SAS2.contains(Expected_SAS_Selected2))
	{
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS2]))

		
		break
		}
		i =i+1
	}

WebUI.delay(1)

'Verify Reason support actions shortcuts'
String Actual_SASReason = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="id_div_support_action_reason"]/label']))

WebUI.verifyMatch(Actual_SASReason, 'Select a support action reason', false)

'Screenshot: popup SAS'
WebUI.takeScreenshot()

'Click on OK'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[3]/button[2]']))

'Verify toastr missing SAS'
String Actual_SASmiss = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

WebUI.verifyMatch(Actual_SASmiss, 'Support action reason is missing', false)

'Screenshot: toastr missing SAS'
WebUI.takeScreenshot()

WebUI.delay(1)

'Select reason: Internal correction'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_support_action_reason"]']), '2', 
    false)

'Click on OK'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[3]/button[2]']))

'Go the lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: Lifecycle tab'
WebUI.takeScreenshot()

'Verify that the Steps has been added'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a']))

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a']))

functions.I.Pagedown()

'Verify header'
String Actual_InfoInput1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div/div/div[1]/div[1]/h3']))

WebUI.verifyMatch(Actual_InfoInput1, 'Information Input', false)

'Verify Regulatory is added'
String Actual_reg = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div/div/div[2]/h5[2]']))

WebUI.verifyMatch(Actual_reg, 'Regulatory', false)

'Verify Tech Packaging is added'
String Actual_reg1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div/div/div[2]/h5[3]']))

WebUI.verifyMatch(Actual_reg1, 'Tech Packaging', false)

'Verify Marketing is added'
String Actual_reg22 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div/div/div[2]/h5[4]']))

WebUI.verifyMatch(Actual_reg22, 'Marketing', false)

WebUI.delay(5)

' Logout'
functions.I.Logout()

//////////////////1. REgulatory User 1 : nturner
'Log in as nturner'
functions.I.Login_password('nturner', password_nturner)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'VErify no of task'
String task1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

'Verify lifecycle status'
String alfs1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[16]/span[1]']))

WebUI.verifyMatch(alfs1, 'Information  Input', false)

'Click on  submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[17]/a[2]']))

'Screenshot: ref modif page'
WebUI.takeScreenshot()

'Click on  submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify lifecycle status'
String alfs2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[16]/span[1]']))

WebUI.verifyMatch(alfs2, 'Information  Input', false)

'verify task'
String Atask2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

String task2 = Integer.parseInt(task1) - 1

WebUI.verifyMatch(Atask2, task2, false)

functions.I.Logout()

//////////////////2. REgulatory User 2: 'amassoth'
'Log in as amassoth'
functions.I.Login_password('amassoth', password_amassoth)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on  submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[17]/a[2]']))

'Screenshot: ref modif page'
WebUI.takeScreenshot()

'Click on  submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

functions.I.Logout()

//////////////////3. Tech Packaging : Bayete Milhomme
'Log in as bmilhomme'
functions.I.Login_password('bmilhomme', password_bmilhomme)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on  submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[18]/a[2]']))

'Screenshot: ref modif page'
WebUI.takeScreenshot()

'Click on  submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

'Verify lifecycle status'
String alfs3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[16]/span[1]']))

WebUI.verifyMatch(alfs3, 'Information  Input', false)

functions.I.Logout()

//////////////////////////blemco
'Log in as CS blemco'
functions.I.Login_password('blemco', password_blemco)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_daughter1) + '"]/td[10]/a[1]/span']))

'Click lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Click add phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[3]/div/div[1]/div[2]/div/a[1]']))

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_phase"]']), '80', false)

'Click ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addphase"]/div/div/div[3]/button[2]']))

WebUI.delay(1)

functions.I.Pagedown()

'Click Skip'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[3]/div/div[1]/div[2]/div/a[3]']))

'Click ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]']))

functions.I.Logout()

//////////////////4. Tech Packaging user 1 rjaiven
'Log in as rjaiven'
functions.I.Login_password('rjaiven', password_rjaiven)

'Screenshot: Login '
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on  submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[18]/a[2]']))

'Screenshot: ref modif page'
WebUI.takeScreenshot()

'Click on  submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Verify lifecycle status is complete'
String alfs4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[16]/span']))

WebUI.verifyMatch(alfs4, 'Complete', false)

WebUI.closeBrowser()