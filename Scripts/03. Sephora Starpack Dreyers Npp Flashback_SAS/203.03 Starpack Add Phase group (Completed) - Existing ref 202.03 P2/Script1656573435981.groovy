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

///////////////////////////////////////////////////////////////
/*
 * PART C: add a phase group
[Phase même lifecycle et même step] - Question phase
Vérifier que l'utilisateur peut ajouter une phase > La phase est ajoutée en dessous du même step
Vérifier que l'utilisateur peut avancer la phase
Scenario 2: Flashback sur une ref incomplète
PART A: Add a phase - au milieu du lifecycle
Vérifier que l'utilisateur peut ajouter une phase > La phase est ajoutée en dessous du même step
Add phase : Vérifier le nombre d'option dans la list est est inférieur au nombre qu'on a à la fin du lifecycle
Add phase group : Vérifier le nombre d'option dans la list est est inférieur au nombre qu'on a à la fin du lifecycle
PART B: add a phase group - à la fin du lifecycle
Vérifier que l'utilisateur peut ajouter un phase group du même lifecycle
Add phase : Vérifier le nombre d'option dans la list est est superieur au nombre qu'on a à la fin du lifecycle
Add phase group : Vérifier le nombre d'option dans la list est est superieur au nombre qu'on a à la fin du lifecycle
 */
//DATA FILE FOR PASSWORD AND USERNAME
def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

String password_suser = data.getValue(2, 1 //R
    )

String password_aherms = data.getValue(2, 2 //R
    )

//DATA FILE FROM URL
def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

//READ FROM NOTEPAD
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID.txt')

String refID_PS = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_PS.txt')

String refID_PTS = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_PTS.txt')

String refID_TD = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_TD.txt')

//////////////////////////////////////////////////////////////TEST START /////////////////////////////////////
'Navigate to URL StarpackTest'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

'Log in as  suser/ dchi'
functions.I.Login_password('suser', password_suser)

'Screenshot: Log in as suser'
WebUI.takeScreenshot()

'Click on the LHS menu'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot:  Project list page'
WebUI.takeScreenshot()

WebUI.delay(3)

'19. search for ref'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords11"]']), 'PTS')

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_PTS) + '"]/td[4]/a']))

'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: Lifecycle page'
WebUI.takeScreenshot()

'Click on step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li/a']))

'Screenshot: lifecycle page step is expanded'
WebUI.takeScreenshot()

'Click on + to add phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[3]/div/div[1]/div[2]/div/a[1]']))

WebUI.delay(1)

'Screenshot: add phases Popup '
WebUI.takeScreenshot()

'Add Phase'
functions.I.SelectFromList_Value('//*[@id="added_grp_phase"]', '9')

WebUI.delay(1)

'Screenshot: add phases option selected'
WebUI.takeScreenshot()

'Click on Add'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addphase"]/div/div/div[3]/button[2]']))

WebUI.delay(1)

functions.I.Pagedown()

'Verify if phase group is added'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[4]/div/div[1]', 
    'PTS')

functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[5]/div/div[1]/div[1]', 
    'PTS Approval')

'Screenshot: Lifecycle tab'
WebUI.takeScreenshot()

'Click on + to add phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[4]/div/div[1]/div[2]/div/a[1]']))

WebUI.delay(1)

int Entries1 = WebUI.getNumberOfTotalOption(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_phase"]']))

WebUI.verifyEqual(Entries1, 4)

int Entries2 = WebUI.getNumberOfTotalOption(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_grp_phase"]']))

WebUI.verifyEqual(Entries2, 2)

'Add Phase'
functions.I.SelectFromList_Value('//*[@id="added_phase"]', '112')

'Click on Add'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addphase"]/div/div/div[3]/button[2]']))

functions.I.Pagedown()

'Screenshot: Lifecycle tab'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify match'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[5]/div/div[1]', 
    'Complete PTS')

functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[6]/div/div[1]/div[1]', 
    'PTS Approval')

'Click on delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[6]/div/div[1]/div[2]/div/a[2]']))

WebUI.delay(2)

'Screenshot: delete popup'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on Ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

WebUI.delay(1)

//PART B: add a phase group - à la fin du lifecycle
'Click on  at the End of the lifecycle '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[5]/div/div[1]/div[2]/div/a[1]']))

int Entries3 = WebUI.getNumberOfTotalOption(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_phase"]']))

int Entries4 = WebUI.getNumberOfTotalOption(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_grp_phase"]']))

'Select Phase'
functions.I.SelectFromList_Value('//*[@id="added_grp_phase"]', '6')

'Screenshot: popup'
WebUI.takeScreenshot()

'Click on Add'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addphase"]/div/div/div[3]/button[2]']))

'Click on step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[2]/a']))

'Screenshot: Step added'
WebUI.takeScreenshot()

'Verify PAF'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div[1]', 
    'PAF')

'Verify final artwork'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/div[1]', 
    'Final artworks')

'Logout'
functions.I.Logout()

'Login as aherms'
functions.I.Login_password('aherms', password_aherms)

'Screenshot: Log in as aherms'
WebUI.takeScreenshot()

'Click on the LHS menu'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page of Project'
WebUI.takeScreenshot()

WebUI.delay(1)

//REF LIST PAGE
'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[9]/a[2]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

WebUI.takeScreenshot()

'Verify lifecycle status'
functions.I.VerifyMatchText(('//*[@id="source_' + refID_PTS) + '"]/td[6]/span[2]', 'Complete PTS')

'Logout'
functions.I.Logout()

'Login as suser'
functions.I.Login_password('suser', password_suser)

'Screenshot: Log in as suser'
WebUI.takeScreenshot()

'Click on the LHS menu'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Screenshot: Project List page'
WebUI.takeScreenshot()

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

WebUI.delay(1)

//REF LIST PAGE
'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_PTS) + '"]/td[4]/a']))

'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

functions.I.Pagedown()

'Screenshot: Lifecycle tab page'
WebUI.takeScreenshot()

'Click on + '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[5]/div/div[1]/div[2]/div/a[1]']))

'Select Phase'
functions.I.SelectFromList_Value('//*[@id="added_grp_phase"]', '6')

'Click on Add'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addphase"]/div/div/div[3]/button[2]']))

'Screenshot: Steps added'
WebUI.takeScreenshot()

'VErify that no steps is created'
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']), 
    0)

'Close Browser'
WebUI.closeBrowser()

