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

/*
Scenario 1 : Flashback sur une ref complete
PART A: Add a phase 
[Phase de la même lifecycle et même step] - Question phase
Vérifier que la phase est ajoutée en dessous du même step
Vérifier que l'utilisateur a un task quand on ajoute la phase
Vérifier que le task diminue quand l'utilisateur a fini son task
Vérifier qu'on peut soumettre la phase
 */


//USERNAME & PASSWORD  - SEPHORA 
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Test_Sephora')
String password_atran = data_Sephora.getValue(2, 1) //R
String password_marketing = data_Sephora.getValue(2, 2) //R
String password_iraz = data_Sephora.getValue(2, 5) //R
String password_lmorel = data_Sephora.getValue(2, 11) //R

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData("Data Files/URL/URL_testauto")
String Url_Sephora = data_urlTESTAUTO .getValue(2, 1)

//READ PROJECT NO FROM TEST CASE 3.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_ Login\\Sephora\\102.01\\102.01_Sephora_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_ Login\\Sephora\\102.01\\102.01_Sephora_refID.txt')


///////////////////////////////////////TEST START ///////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to Sephora Test'
WebUI.openBrowser(Url_Sephora)

WebUI.maximizeWindow()

// MARKETING: VERIFY TASK
'Login as marketing'
functions.I.Login_password('marketing', password_marketing)

WebUI.delay(1)

'Screenshot: task '
WebUI.takeScreenshot()

'verify task'
String task1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

'Logout'
functions.I.Logout()

//LRAZ 
'Log in as Iraz'
functions.I.Login_password('lraz', password_iraz)

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

'Click on the link ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[4]/a']))

WebUI.delay(2)

'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Click on step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a']))

WebUI.delay(3)

//////////////////////////////////////////////////////////////////////////////////////////////////////html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[6]/div/div/div/div[1]/div[2]/div/a[1]
'Click on + to add phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div/div/div[1]/div[2]/div/a[1]']))

WebUI.delay(1)

'Screenshot: Popup'
WebUI.takeScreenshot()

'Verify tthe title of the popup'
String Actual_title1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/form[2]/div/div/div/div[1]/h4[2]']))

'Verify Match'
WebUI.verifyMatch(Actual_title1, 'Select steps or phases to add after the phase: DDC update', false)

'Add Phase'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_phase"]']), '71', false)

'Click on Add'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addphase"]/div/div/div[3]/button[2]']))

'Screenshot: added '
WebUI.takeScreenshot()

WebUI.delay(2)

'Verify that no step is created'
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']), 
    5)

'Verify added by text'
String Actual_added1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[2]/h6']))

String test1 = Actual_added1.contains('Added manually')

WebUI.verifyMatch(test1, 'true', false)

String test2 = Actual_added1.contains('By Lorriane RAZAFINDRAMISA')

WebUI.verifyMatch(test2, 'true', false)

WebUI.delay(1)

'Logout'
functions.I.Logout()

//MARKETING
'Login as marketing'
functions.I.Login_password('marketing', password_marketing)

'Screenshot: task '
WebUI.takeScreenshot()

'verify task'
String Atask2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

String task2 = Integer.parseInt(task1) + 1

'Verify that task is correct'
WebUI.verifyMatch(Atask2, task2, false)

'Click on task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

'Screenshot: added '
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on see all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[3]/a']))

WebUI.delay(1)

'Screenshot: added '
WebUI.takeScreenshot()

WebUI.delay(1)

'Search for DDC'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2_taskTypes"]']), 'DDC_to_update', 
    false)

WebUI.delay(1)

'Screenshot: added '
WebUI.takeScreenshot()

'Click'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_task_filters"]/div[5]/button']))

WebUI.delay(1)

'Click on ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr/td[1]/a']))

WebUI.delay(1)

'Choose 1st option '
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/div/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/div/div/a[1]']))

'Click on submit '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/form/div[1]/div/button[2]']))

'Screenshot: added '
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify if the lifecycle is complete'
String lifecycle_complete1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + 
            '"]/td[5]/span']))

WebUI.verifyMatch(lifecycle_complete1, 'Complete', false)

WebUI.delay(1)

'verify task'
String Atask3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

WebUI.verifyMatch(Atask3, task1, false)

'Logout'
functions.I.Logout()

//[Phase de la même lifecycle et different step] - Production phase
//LOG IN AS ATRAN ~ DIADEIS
'Log in as Devfs  : atran/ diadeis'
functions.I.Login_password('lraz', password_iraz)

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

'Click on the link ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[4]/a']))

WebUI.delay(2)

'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Click on step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a']))

WebUI.delay(1)

'Click on + to add phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[4]/div/div[2]/div/div[1]/div[2]/div/a[1]']))

WebUI.delay(1)

'Add Phase'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_phase"]']), '79', false)

WebUI.delay(1)

'Screenshot: Popup '
WebUI.takeScreenshot()

'Click'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addphase"]/div/div/div[3]/button[2]']))

WebUI.delay(1)

'Verify that step is created'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']))

WebUI.takeScreenshot()

//Added manually 25/11/2021 11:44 By Lorriane RAZAFINDRAMISA
'Verify added by text'
String Actual_added2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[5]/div/div/div/div[2]/h6']))

String test12 = Actual_added2.contains('Added manually')

WebUI.verifyMatch(test12, 'true', false)

String test22 = Actual_added2.contains('By Lorriane RAZAFINDRAMISA')

WebUI.verifyMatch(test22, 'true', false)

'Logout'
functions.I.Logout()

//LMOREL
'Login as Lmorel'
functions.I.Login_password('lmorel', password_lmorel)

'verify task'
String Atask33 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

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

'Verify Lifecycle status id BAG PROD (Printer)'
String lf1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[5]/span[1]']))

WebUI.verifyMatch(lf1, 'BAG PROD (Printer)', false)

'Click on submit'
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']), 
    'color', FailureHandling.OPTIONAL)



while (color1 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']))

    ' Upload doc for production phase'
    WebUI.takeScreenshot()

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdataaddition1.pdf', 'testdataaddition1.pdf')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    functions.I.click_button_javascript(findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    if (WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']), 
        10, FailureHandling.OPTIONAL)) {
        color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']), 
            'color', FailureHandling.OPTIONAL)
    } else {
        color1 = 'white'
    }
}

'Verify task'
String Atask4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

int task4 = Integer.parseInt(Atask33) - 1

WebUI.verifyEqual(Integer.parseInt(Atask4), task4)

'Logout'
functions.I.Logout()

//ATRAN
'Login as atran'
functions.I.Login_password('atran', password_atran)

'Click on the LHS Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for Project No'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '/html/body/div[1]/div[1]/div[2]/div/ul/li[2]/div/div/form/div[4]/button')

'Screenshot: Ref list page of Project'
WebUI.takeScreenshot()

WebUI.delay(1)

'Approve via extender'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID+ '"]/td[7]/a']))

WebUI.delay(1)

'Verify Lifecycle Status is Complete'
String lf2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[5]/span']))

WebUI.verifyMatch(lf2, 'Complete', false)

'Logout'
functions.I.Logout()

//[Phase de la même lifecycle et different step] - Production phase
//LOG IN AS ATRAN ~ DIADEIS
'Log in as lraz'
functions.I.Login_password('lraz', password_iraz)

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

'Click on the link ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[4]/a']))

WebUI.delay(2)

'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Click on step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']))

WebUI.delay(1)

'154 Click on + to add phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[5]/div/div[2]/div/div[1]/div[2]/a[3]']))

WebUI.delay(1)

'Add Phase'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="added_phase"]']), '47', false)

WebUI.delay(1)

'Screenshot: Popup '
WebUI.takeScreenshot()

'Click'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_addphase"]/div/div/div[3]/button[2]']))

WebUI.delay(1)

'Verify that step is created'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[6]/a']))

WebUI.delay(1)

WebUI.takeScreenshot()

'Logout'
functions.I.Logout()

//LOG IN AS ATRAN ~ DIADEIS
'Log in as Devfs  : atran/ diadeis'
functions.I.Login_password('atran', password_atran)

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

'Verify Lifecycle Status is  FS Part'
String lf3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[5]/span']))

WebUI.verifyMatch(lf3, 'FS Part', false)

'Click on the link ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[4]/a']))

WebUI.delay(2)

'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Click on step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[6]/a']))

WebUI.delay(1)

'Screenshot: lifecycle page'
WebUI.takeScreenshot()

'Verify added by text'
String Actual_added4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[6]/div/div/div/div[2]/h6']))

String test14 = Actual_added4.contains('Added manually')

WebUI.verifyMatch(test14, 'true', false)

String test24 = Actual_added4.contains('By Lorriane RAZAFINDRAMISA')

WebUI.verifyMatch(test24, 'true', false)

'Click on breadcrumb'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']))

'Screenshot: ref modif page'
WebUI.takeScreenshot()

'Click submit phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Verify Lifecycle Status is complete'
String lf4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[5]/span']))

WebUI.verifyMatch(lf4, 'Complete', false)

WebUI.closeBrowser()

