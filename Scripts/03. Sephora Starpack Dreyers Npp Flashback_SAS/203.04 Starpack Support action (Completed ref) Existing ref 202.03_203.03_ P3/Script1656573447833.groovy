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

/* IN THIS TEST CASE , SCENARIO TESTED:
 * 
 */

//DATA FILE: USERNAME & PASSWORD - STARPACK
def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')
String password_aterreshernandez = data.getValue(2, 5) //R

//DATA FILE: URL - STARPACK
def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')
String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

//READ FROM NOTEPAD TC 4.01 - 15.03 - 16.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID.txt')
String refID_PS = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_PS.txt')
String refID_PTS = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_PTS.txt')
String refID_TD = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\StarPack\\202.01 StarPack _Project_No\\202.01_StarPack_refID_TD.txt')


///Support action used : AW sin brief - Go back to PAF from sample reception 2
//////////////////////////////////////TEST START //////////////////////////////////////

'Navigate to URL Starpack Test'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

'Log in as  aterreshernandez'
functions.I.Login_password('aterreshernandez', password_aterreshernandez)

'Screenshot: Log in as aterreshernandez'
WebUI.takeScreenshot()

'Click on LHS menu'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

'Screenshot: Ref list page of Project'
WebUI.takeScreenshot()

WebUI.delay(1)

//REF LIST PAGE
'Screenshot: ref list page'
WebUI.takeScreenshot()

	
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[4]/a[1]']))
 

'Click on the lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))
 
WebUI.delay(1)

'Click on the step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']))
 
functions.I.Pagedown()

'Screenshot: Lifecycle tab '
WebUI.takeScreenshot()

'VErify if the button support action is present'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[4]/div/div[1]/div[2]/div/a[4]']))
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[4]/div/div[1]/div[2]/div/a[1]']))
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[4]/div/div[1]/div[2]/a']))

WebUI.verifyElementClickable(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[4]/div/div[1]/div[2]/div/a[4]']))
////////////////////////////////////

'Click on the breadcrum'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))
 
 WebUI.takeScreenshot()
 
WebUI.delay(1)

'Click on the support action'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[2]']))
 
 WebUI.takeScreenshot()

WebUI.delay(1)


'Click on OK'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[2]/button[2]']))
 
WebUI.delay(1)

/////////////////////////////////////////////////////////////////////////////

WebUI.takeScreenshot()

'Click on the lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))
 
'step 1 & 2'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a']))
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']))

'Click on the breadcrum'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))
 

'Verify lifecycle status'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[7]/span[2]', 'PAF')


 //UPLOAD
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[2]']), 'color', FailureHandling.OPTIONAL)

while (color1 == 'rgba(255, 255, 255, 1)') {
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[2]']))

'Supplier Upload doc for production phase'
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

if (WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[3]']), 10, FailureHandling.OPTIONAL)) {
	color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[3]']), 'color', FailureHandling.OPTIONAL)

} else {
	color1 = 'white'
}
}

'Approve doc'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a[2]']))

'Screenshot ref list page'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify lifecycle status'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[7]/span[2]', 'Buyer supplier approval-L1')

'Close Broswer'
WebUI.closeBrowser()
