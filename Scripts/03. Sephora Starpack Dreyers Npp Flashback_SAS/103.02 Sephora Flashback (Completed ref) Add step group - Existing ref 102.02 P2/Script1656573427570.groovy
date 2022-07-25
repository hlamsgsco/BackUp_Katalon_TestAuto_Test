import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.junit.After as After
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

/*
Scenario 1 : Flashback sur une ref complete
PART B: add a step group
Vérifier que l'utilisateur peut ajouter une step group
Vérifier que l'utilisateur peut soumettre la phase
Vérifier que les steps sont bien ajoutés.
 */

//USERNAME & PASSWORD  - SEPHORA
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Test_Sephora')
String password_studio = data_Sephora.getValue(2, 4)
String password_iraz = data_Sephora.getValue(2, 5)

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData("Data Files/URL/URL_testauto")
String Url_Sephora = data_urlTESTAUTO .getValue(2, 1)

//READ PROJECT NO FROM TEST CASE 3.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Sephora\\102.02\\102.02_Sephora_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Sephora\\102.02\\102.02_Sephora_refID.txt')

//BROWSE & MAXIMIZE BROWSER
'Navigate to Sephora Test'
WebUI.openBrowser(Url_Sephora)

WebUI.maximizeWindow()

//Lraz 
'Log in as lraz'
functions.I.Login_password('lraz', password_iraz)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '/html/body/div[1]/div[1]/div[2]/div/ul/li[2]/div/div/form/div[4]/button')

WebUI.delay(1)

//REF LIST PAGE
'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on the link ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[4]/a']))

WebUI.delay(2)

'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Click on 4th  step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a']))

WebUI.delay(1)

'Click on + to add phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div/div/div[1]/div[2]/div/a[1]']))

WebUI.delay(1)

'Screenshot: Popup '
WebUI.takeScreenshot()

'Add Phase'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_grp_step"]']), 
    '11', false)

'Click on Add'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addphase"]/div/div/div[3]/button[2]']))

WebUI.delay(2)

'Verify that no step is created'
WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']),5)

WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[6]/a']),5)

functions.I.Logout()

//STUDIO
'Log in as studio'
functions.I.Login_password('studio', password_studio)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '/html/body/div[1]/div[1]/div[2]/div/ul/li[2]/div/div/form/div[4]/button')

'Screenshot: Ref list page of Project'
WebUI.takeScreenshot()

WebUI.delay(1)

//REF LIST PAGE
'Screenshot: ref list page'
WebUI.takeScreenshot()

'Verify Lifecycle Status : Studio ACK'
String lf1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[5]/span[1]']))

WebUI.verifyMatch(lf1, 'Studio ACK', false)

functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[8]/div/button']), findTestObject('1. Constant/xpath', 
        [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/div/div/a']))

'Click submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Verify Lifecycle Stauts : DDC Prod'
String lf2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[5]/span[1]']))

WebUI.verifyMatch(lf2, 'DDC Prod', false)

WebUI.closeBrowser()

