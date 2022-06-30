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

C : PMARERI C&A SHOULD BE ABLE TO PERFORM MASS SUBMIT

SCENARIO 2: Control tag  + Mass submit
VERIFICATION OF TASK
*/
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE: USERNAME & PASSWORD  - TAG
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

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


//PROJECT AND REFID USED 
String Project_No = 'MI003388'

String refID1 = '24280'


///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag '
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag'
WebUI.takeScreenshot()

///       	SCENARIO  : RIGHTS ON THE MASS SUBMIT EXISTING PROJECT MI002241 /////////////////////////////////
/////////// SCENARIO 1A JEDUN (ADMIN) SHOULD NOT BE ABLE TO SEE THE BUTTON MASS SUBMIT
'Log in as c&A – scai'
functions.I.Login_password('scai', password_scai)

'VErify no of task'

////*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span
'VErify no of task'
String task1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

'Click on task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

'Click on 1st task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/a/div[2]/span[1]']))

WebUI.delay(1)

'VErify that MI003388 is on the page'
WebUI.verifyTextPresent(Project_No, false)

'Screenshot:  Ref list page'
WebUI.takeScreenshot()

////*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/button
'Mouse Over'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/button']))
WebUI.delay(1)
'Verify tooltip of the mass submit'
String Actual_tooltip_masssubmit = WebUI.getText(findTestObject('1. Constant/xpath', 
        [('xpath') : '/html/body/div[9]/div[2]']))

WebUI.verifyMatch(Actual_tooltip_masssubmit, 'Mass-submit', false)


 WebUI.delay(1)

'Click on mass-submit button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/button']))

WebUI.delay(2)

////////////////////////////////////////////////////////CHOOSING OPTION 2 /////////////////////////////////////////
////////////////////////////////////////THERE IS NO REF ////////////////////////////////////////////////
'34 Click on option 2 masss submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/div/a[2]']))

WebUI.delay(2)

'Verify that the checkbox is disabled'
String Actual_diasable = WebUI.getAttribute(findTestObject('1. Constant/xpath', [
            ('xpath') : '//*[@id="allRefs"]']), 'disabled')

WebUI.verifyMatch(Actual_diasable, 'true', false)

////*[@id="source_24280"]/td[1]/i
'44 Verify that the icon is correct'
String Actual_ban = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24280"]/td[1]/i']), 
    'class')

WebUI.verifyMatch(Actual_ban, 'fas fa-ban temp-ban', false)

'Hover over the icon'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID1) + '"]/td[1]/i']))

'Screenshot: Conditions is not met'
WebUI.takeScreenshot()

'41 Verify that text conditions not met'
String err1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[9]/div[2]']))

WebUI.verifyMatch(err1, 'One of the conditions is not met to submit this reference', false)

'Verify Please select at least one reference to validate or  is displayed'
String msg1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/span[2]']))

WebUI.verifyMatch(msg1, ' Please select at least one reference to validate or', false)

'Verify that the button confirm submit'
String button_verify1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

WebUI.verifyMatch(button_verify1, 'Confirm selection', false)

'Click on cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/button[2]']))

////////////////////////////////////////////////////////CHOOSING OPTION 3 /////////////////////////////////////////
//////////////////////////////////////////CHECKBOX 1///////////////////////////////////
///////////////////////////////ERROR MSG for the control tag////////////////////////////////////
'Screenshot: REF LIST PAGE'
WebUI.takeScreenshot()

'Click on mass-submit button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/button']))

WebUI.delay(2)

////*[@id="btnMassSubmit"]
'Click on option 3 masss submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/div/a[3]']))

'52 Check the 1st checkbox'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + 
            refID1) + '"]/td[1]']))

'53 Click on confirm selection'
WebUI.delay(2)

WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1']), 
    5)

functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

WebUI.delay(1)

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

////////////////////////////////////////UX : POPUP ////////////////////////////////
'Verify the title of the poppup mass submit: Mass submit validation'
String Actual_Title_masssubmit = WebUI.getText(findTestObject('1. Constant/xpath', 
        [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[1]']))

WebUI.verifyMatch(Actual_Title_masssubmit, 'Mass submit validation', false)

'Verify the title of card 1 : List of  references ready for submission (0)'
String Actual_Title_card1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_submitable_references"]/div[1]/div[1]/h3']))

functions.I.print(Actual_Title_card1)

WebUI.verifyMatch(Actual_Title_card1, 'List of references ready for submission (0)', false)

'Verify the title of card 2 : List of  references ready for submission (1)'
String Actual_Title_card2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_nonsubmitable_references"]/div[1]/div[1]/h3']))

functions.I.print(Actual_Title_card2)

WebUI.verifyMatch(Actual_Title_card2, 'List of references with errors (1)', false)

'Verify msg control tag error'
String Actual_Title_msg22 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table/tbody/tr/td[2]']))

functions.I.print(Actual_Title_msg22)

WebUI.verifyMatch(Actual_Title_msg22, 'Missing mandatory information at reference level', false)

'VErify that the button is not clickable'
WebUI.verifyElementNotClickable(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

///////////////////////////////////////CLOSE _ CANCEL BUTTON _ COLLAPSE/ EXPAND//////////////////////
'Click on close button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[1]/button']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'58 Verify that the checkbox remain check'
WebUI.verifyElementChecked(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="'+refID1+'"]']), 
    0)

///////////////////////////////////////////////REF 1
//Modification of ref for 2refs . fill in all the fields control tag
'71 click on  submit for ref1 - 14906'

functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_24282"]/a[1]']))

//WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_14904"]/a']))
//Fill in all the control tag field - REF 1
'Product category: FAke '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_57"]']), 
    '134', false)

'Packaging family: Accessory'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_28"]']), 
    '15738', false)

'CApacity: 100'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_54"]']), 
    '100')

'Capacity unit:CM2'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_55"]']), 
    '122', false)

functions.I.Pagedown()

'Click on update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[1]']))

////////////////////////////////REF 2
//Modification of ref for 2refs . fill in all the fields control tag
'click on  submit for ref2 - 14904'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_24283"]/a[1]']))

//WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ancre_14905"]/a']))
//Fill in all the control tag field
'Product category: FAke '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_57"]']), 
    '134', false)

'Packaging family: Accessory'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_28"]']), 
    '15738', false)

'CApacity: 100'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_54"]']), 
    '100')

'Capacity unit:CM2'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_55"]']), 
    '122', false)

functions.I.Pagedown()

'Click on update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[1]']))

WebUI.delay(1)

'Screenshot: REF LIST PAGE'
WebUI.takeScreenshot()

///////////////////////////////PERFORM MASSSUBMIT
'Click on mass-submit button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/button']))

WebUI.delay(2)

////*[@id="btnMassSubmit"]
'Click on option 3 masss submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[2]/div/a[3]']))

///*[@id="allRefs"]
' Check the all checkbox'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_"]/th[1]']))

' Click on confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

WebUI.delay(1)

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

'Verify the counter for submission = 2 '
String ACount1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_submitable_references"]/div[1]/div[1]']))

WebUI.verifyMatch(ACount1, 'List of references ready for submission (2)', false)

'Verify the counter for submission = 24 '
String ACount2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_nonsubmitable_references"]/div[1]/div[1]/h3']))

WebUI.verifyMatch(ACount2, 'List of references with errors (24)', false)

'Verify ref name - Complete'
String A_nextphase = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentOK"]/table/tbody/tr[1]']))

functions.I.print(A_nextphase)

'35'
WebUI.verifyMatch(A_nextphase, 'MASS_SUBMIT_CONTROL_TAG_PART_1__Fake_Accessory_100CM2 Complete', false)

'Verify error message displayed'
String A_errormsg = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table/tbody/tr[1]']))

functions.I.print(A_errormsg)

'101\r\n'
WebUI.verifyMatch(A_errormsg, 'MASS_SUBMIT_CONTROL_TAG_PART_1____ Missing mandatory information at reference level', false)

////////////////////////////////////COLLAPSE
//CARD 1
'CARD 1 : Verify that the Expand-collapse works'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_submitable_references"]/div[1]/div[2]/a']))

WebUI.delay(1)

'Screenshot: Popup collapse card 1'
WebUI.takeScreenshot()

'Verify that the card is not visible'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentOK"]/table/tbody']))

//CARD 2
'CARD 2: Verify that the Expand-collapse works'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_nonsubmitable_references"]/div[1]/div[2]/a']))

WebUI.delay(1)

'Screenshot: Popup collapse card 1'
WebUI.takeScreenshot()

'Verify that the card is visible'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table']))

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[2]/div[2]/div/button[1]']))

'Click on confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

////////////////////////////////////EXPAND
//CARD 1
'CARD 1 : Verify that the Expand-collapse works'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_submitable_references"]/div[1]/div[2]/a']))

WebUI.delay(1)

'Verify that the card is visible'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentOK"]/table/tbody']))

WebUI.delay(1)

'Screenshot: Popup expand card 1'
WebUI.takeScreenshot()

//CARD 2
'CARD 2: Verify that the Expand-collapse works'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_nonsubmitable_references"]/div[1]/div[2]/a']))

WebUI.delay(1)

'Screenshot: Popup collapse card 1'
WebUI.takeScreenshot()

'Verify that the card is visible'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table']))

'Click cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[2]/div[2]/div/button[1]']))

'Click on confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Scroll to element'
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']), 
    5)

'Click on send agency'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

'Screenshot: Popup Progress bar'
WebUI.takeScreenshot()

//popup
//WebUI.waitForElementNotVisible(findTestObject('Page_CuraHomepage/btn_MakeAppointment'), 20)
'Screenshot: Success msg'
WebUI.takeScreenshot()

//Success: the selected references have been successfully submitted
'Verify that that msg success is displayed'
String A_mssgsucess = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

WebUI.verifyMatch(A_mssgsucess, 'Success: the selected references have been successfully submitted', false)

'66 Verify the lifecycle status - part 1 '
String A_LS1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24280"]/td[12]/span']))

////*[@id="source_14903"]/td[12]/span
'133 '
WebUI.verifyMatch(A_LS1, 'Complete', false)

'Verify the lifecycle status - part 2 '
String A_LS2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24281"]/td[12]/span']))

WebUI.verifyMatch(A_LS2, 'Complete', false)

'14905'
String A_LS5 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24282"]/td[12]/span[1]']))

WebUI.verifyMatch(A_LS5, 'C&A/APM: Brief completion', false)


WebUI.closeBrowser()

