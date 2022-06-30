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

/* 	SCENARIO 1 : RIGHTS ON THE MASS SUBMIT /////////////////////////////////
Verify rights (MI002241)

A : JEDUN (ADMIN) SHOULD NOT BE ABLE TO SEE THE BUTTON MASS SUBMIT 

B.DMI SHOULD BE ABLE TO SEE THE BUTTON BUT SHOULD NOT BE ABLE TO SELECT REF 

Verify that the message ‘ one condition is not met’

a.when the user does not have the right to submit [lifecycle template] dmi  

b.in the setup of the mass submit, there is no setup for the ref to be submitted (MI002241)

*/



///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE: USERNAME & PASSWORD  - tag
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_jedun = data_Tag.getValue(3, 1)
String password_rrowland = data_Tag .getValue(3, 2)
String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 5)

String password_mderdour = data_Tag.getValue(3, 6)
String password_achatin = data_Tag .getValue(3, 7)
String password_tliu = data_Tag.getValue(3, 8)

String password_ccaramella = data_Tag.getValue(3, 9)

String password_achay = data_Tag.getValue(3, 10)
String password_cbono = data_Tag.getValue(3,11)
String password_pmareri = data_Tag.getValue(3,12)
String password_qeuzen = data_Tag.getValue(3,13)

String password_alanglois = data_Tag.getValue(3,14)
String password_bde_villeneuve = data_Tag.getValue(3,15)

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


//PROJECT AND REFID USED 
String Project_No = 'MI003388'
String refID1 =  '24280'

///////////////////////////// TEST BEGIN /////////////////////////////////////////




//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

///       	SCENARIO  : RIGHTS ON THE MASS SUBMIT EXISTING PROJECT MI002241 /////////////////////////////////
/////////// SCENARIO 1A bde_villeneuve (Valo/SRC/Scientific Director) SHOULD NOT BE ABLE TO SEE THE BUTTON MASS SUBMIT

'Log in as bde_villeneuve'
functions.I.Login_password('bde_villeneuve', password_bde_villeneuve)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

'Screenshot:  Ref list page of Project MI003388'
WebUI.takeScreenshot()

'Verify if the button mass submit is not displayed'
// /html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/a[1]
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div/button']),5)
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnMassSubmit"]']),5)

WebUI.delay(2)

'Logout'
functions.I.Logout()

////////////////////////////////SCEANRIO 1B.DMI SHOULD BE ABLE TO SEE THE BUTTON BUT SHOULD NOT BE ABLE TO SELECT REF 

'Log in as DMI - cbono'
functions.I.Login_password('cbono', password_cbono)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
////*[@id="form_filters"]/div[8]/button
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

'Screenshot: Ref list page of Project MI002241'
WebUI.takeScreenshot()

WebUI.delay(2)

'Click on the button masss submit'
/////*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div/button
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div/button']))

WebUI.delay(2)




'Click on option 1 masss submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnMassSubmit"]']))

WebUI.delay(2)


'Verify that the checkbox is disabled'
String Actual_diasable = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="allRefs"]']), 'disabled')
WebUI.verifyMatch(Actual_diasable, 'true', false)

'Verify that the icon is correct'
////*[@id="source_24280"]/td[1]/i
String Actual_ban = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID1+'"]/td[1]/i']), 'class')
WebUI.verifyMatch(Actual_ban, 'fas fa-ban temp-ban', false)

'Hover over the icon'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID1+'"]/td[1]/i']))


'Screenshot: Conditions is not met'
WebUI.takeScreenshot()

'Verify that text conditions not met'
String err1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))
WebUI.verifyMatch(err1, "Une des conditions n'est pas remplie pour soumettre cette référence", false)

'Verify Please select at least one reference to validate or  is displayed'
///html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/span[2]
String msg1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/span[2]']))
 WebUI.verifyMatch(msg1, ' Veuillez sélectionner au moins une référence pour valider ou', false)

'Verify that the button confirm submit'
String button_verify1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"] ']))
WebUI.verifyMatch(button_verify1, 'Confirmer la sélection', false)
 
'Click on cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/button[2]']))

WebUI.delay(1)
'Verify that the text is not displayed - Please select at least one reference to validate or'
WebUI.verifyTextNotPresent(' Veuillez sélectionner au moins une  référence pour valider ou ', false)

WebUI.closeBrowser()