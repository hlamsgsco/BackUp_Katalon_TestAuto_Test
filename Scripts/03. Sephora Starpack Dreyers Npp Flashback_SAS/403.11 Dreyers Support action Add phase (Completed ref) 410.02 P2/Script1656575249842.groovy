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

*/
///////////////////////////////////BEFORE TEST ///////////////////////////////////////
//DATA FILE: USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Test_Dreyer')
String password_blemco = data_Dreyers.getValue(2, 2)
String password_nturner = data_Dreyers.getValue(2, 6)
String password_bmilhomme = data_Dreyers.getValue(2, 8)

//DATA FILE : URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Dreyer = data_urlTESTAUTO.getValue(2, 4)


//READ FROM NOTEPAD
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_Design(M).txt')
String refID_daughter1 = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_Deliverable(D).txt')
String refID_APL = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_APL(GD).txt')
String refID_LI = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Dreyers\\410.02\\410.02_Dreyers_refID_LI(GD).txt')

///////////////////////////// TEST BEGIN ///////////////////////////////////////////////////////////
'Navigate to URL Dreyers Test'
WebUI.openBrowser(Url_Dreyer)

WebUI.maximizeWindow()

'Screenshot: Navigate to URL Dreyer Test'
WebUI.takeScreenshot()

'Log in as CS blemco'
functions.I.Login_password('blemco', password_blemco)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

WebUI.delay(1)

/////////////////////////////////////////////SCEANRIO 1 :REF LIsT PAGE RESTART FOR  RG & TECH PACK//////////////////////////////////
'Verify if the button support action is displayed'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[17]/div[1]/button']))


WebUI.delay(1)

'Screenshot: tooltip'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify tooltip support actions shortcuts'
String Actual_SAS = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

WebUI.delay(1)

WebUI.verifyMatch(Actual_SAS, 'Support action shortcuts', false)

'Click on SAS button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[17]/div[1]/button']))

WebUI.delay(1)


//CLCICK ON THE SAS WITH THE LABEL
'no of option present '
int x = 20
int i = 1

while ( i <=x)
{
	String Expected_SAS_Selected1 = 'Restart for Regulatory and Tech Pack'

	String xpath_SAS1 ='//*[@id="source_' + refID_LI + '"]/td[17]/div[1]/div/a['+i+']'
	
	
	String Actual_SAS1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS1]))
	functions.I.print(i)
	
	if (Actual_SAS1.contains(Expected_SAS_Selected1))
	{
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS1]))


		
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
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[2]/button[2]']))
'Verify toastr missing SAS'
String Actual_SASmiss = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

WebUI.verifyMatch(Actual_SASmiss, 'Support action reason is missing', false)

'Screenshot: toastr missing SAS'
WebUI.takeScreenshot()

WebUI.delay(1)

'Select reason: Rejection from Artwork Agency'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_support_action_reason"]']), 
    '1', false)

'Click on OK'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[2]/button[2]']))

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

WebUI.verifyMatch(Actual_InfoInput1, 'Information Input: Regulatory and Tech Pack', false)

'Logout'
functions.I.Logout()

//////////////////1. REgulatory User 1 : nturner
'Log in as nturner'
functions.I.Login_password('nturner', password_nturner)

'Screenshot: Login as nturner'
WebUI.takeScreenshot()

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

WebUI.verifyMatch(alfs1, 'Information Input: Regulatory and Tech Pack', false)

'Click on  submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[17]/a[2]']))

'Screenshot: ref modif page'
WebUI.takeScreenshot()

'Click on  submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify lifecycle status'
String alfs2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[16]/span[1]']))

WebUI.verifyMatch(alfs2, 'Information Input: Regulatory and Tech Pack', false)

'verify task'
String Atask2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

String task2 = Integer.parseInt(task1) - 1

WebUI.verifyMatch(Atask2, task2, false)

functions.I.Logout()

//////////////////2. Tech Packaging : Bayete Milhomme
'Log in as CS blemco'
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

'Verify lifecycle status is Complete'
String alfs3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[16]/span[1]']))

WebUI.verifyMatch(alfs3, 'Complete', false)

functions.I.Logout()

//////////////////////////blemco
'Log in as CS blemco'
functions.I.Login_password('blemco', password_blemco)

'Screenshot: Login as blemco'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[10]/a[1]/span']))

'Click lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: lifecycle tab'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on 1st step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a']))

'Screenshot: step 1'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on Expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div/div/div[1]/div[2]/a']))

'Screenshot: reason display'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify reason on lifecycle'
String alr1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div/div/div[2]/h5']))

WebUI.verifyMatch(alr1, 'CHOSEN REASON : "Rejection from Artwork Agency" By Brian Lemco', false)

'Click on 2nd step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a']))

WebUI.delay(1)

'Screenshot: 2nd step'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click SAS'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div/div/div[1]/div[2]/div/button']))

WebUI.delay(1)

/////////////////////////////////////////////SCEANRIO 2 : [Option4] TECH PACK//////////////////////////////////
'Choose option 4'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/a[4]']))

WebUI.delay(1)

'Select reason: Internal correction'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_support_action_reason"]']), 
    '2', false)

'Screenshot: support action popup'
WebUI.takeScreenshot()

'Click on OK'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[3]/button[2]']))

'Go the lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: Lifecycle tab'
WebUI.takeScreenshot()

'Verify phase added'
String alp1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/h3']))

WebUI.verifyMatch(alp1, 'Information Input : Tech Pack Only', false)

WebUI.delay(1)

'Click on Expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/div[2]/a']))

WebUI.delay(1)

'Screenshot: lifecycle tab'
WebUI.takeScreenshot()

'Verify reason on lifecycle'
String alr2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/h5[1]']))

WebUI.verifyMatch(alr2, 'CHOSEN REASON : "Internal Correction" By Brian Lemco', false)

functions.I.Pagedown()

'Click SAS'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/button']))

WebUI.delay(1)

/////////////////////////////////////////////SCEANRIO 2 : [Option4] TECH PACK//////////////////////////////////
'Choose option 1 '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div/a[1]']))

WebUI.delay(1)

'Select reason: Internal correction'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_support_action_reason"]']), 
    '2', false)

'Screenshot: support action popup'
WebUI.takeScreenshot()

'Click on OK'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[3]/button[2]']))

'Go the lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: Lifecycle tab'
WebUI.takeScreenshot()

'Verify that the Steps has been added'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']))

WebUI.delay(1)

'Click on 3rd step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']))

WebUI.delay(1)

'Verify header'
String Actual_InfoInput11 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div/div/div[1]/div[1]']))

WebUI.verifyMatch(Actual_InfoInput11, 'Information Input', false)

'Click breadcrumb'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[2]/div/nav/ol/li[2]/a']))

WebUI.delay(1)

'Verify lifecycle status'
String alfs14 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[16]/span[1]']))

WebUI.verifyMatch(alfs14, 'Information  Input : Tech Pack Only', false)

//Information Input : Tech Pack Only
'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[10]/a[1]/span']))

'Click lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: lifecycle tab'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on 3rd step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']))

'Screenshot: step 3'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div/div/div[1]/div[2]/div/a[2]']))

WebUI.takeScreenshot()

WebUI.delay(1)

'Click on delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

functions.I.Pagedown()

'  Click on Skip'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a[3]']))

WebUI.takeScreenshot()

WebUI.delay(1)

'Select reason: '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_support_action_reason_skip"]']), 
    '1', false)

'Click on OK'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_skip_phase"]/div/div/div[3]/button[2]']))

WebUI.delay(5)

'Click breadcrumb'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

WebUI.delay(1)

'Verify lifecycle status'
String alfs15 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_LI) + '"]/td[16]/span']))

WebUI.verifyMatch(alfs15, 'Complete', false)

WebUI.closeBrowser()

