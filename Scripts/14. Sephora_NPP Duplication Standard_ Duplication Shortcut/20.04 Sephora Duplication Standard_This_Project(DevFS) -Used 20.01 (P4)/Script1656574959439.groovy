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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory


///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD [SEPHORA]
def data_Sephora = TestDataFactory.findTestData("Data Files/Username_Password/Test_Sephora")
String password_atran = data_Sephora .getValue(2, 1) //R
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
def data_urlRELAUTO = TestDataFactory.findTestData("Data Files/URL/URL_relauto")
String Url_Sephora = data_urlRELAUTO .getValue(2, 1)

//READ NOTEPAD
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_ProjectNo.txt')
String refID = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refID.txt')
String ref_name1 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refIDName.txt')

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.04_Sephora_refID3.txt')


//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////
'Navigate to Sephora'
WebUI.openBrowser(Url_Sephora)

'Maximize Window'
WebUI.maximizeWindow()

'Log in as atran :  diadeis'
functions.I.Login_password('atran', password_atran)


'Click on LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Devpack - reflist page'
WebUI.takeScreenshot()

'Click on the duplication button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnduplicatereference"]']))

'Select 1 ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID + '"]/td[1]/label']))

'Click confirm button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

//POPUP
'Screenshot: Duplication Popup'
WebUI.takeScreenshot()

WebUI.delay(1)

'Select Lifecycle template  : FS PROCESS'
functions.I.SelectFromList_Label('//*[@id="lfc_tpl5"]', 'FS process')

'Click on the duplication button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

WebUI.delay(1)

'Get the no of ref created and verify that the no of ref created is 2'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '2')

//REF LIST PAGE
'Screenshot: REF LIST PAGE'
WebUI.takeScreenshot()


'Search ref'
functions.I.SearchRefNo_xpath('Copy 1 of', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Click on 1st ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[4]/a']))

WebUI.delay(1)

String dupli_refid = functions.I.RefID()
functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.04_Sephora_refID3.txt',  dupli_refid)


'Click on full phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_full_brief"]']))

WebUI.delay(1)


//VERIFY FIELD PREFILLE REF A
'Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('//*[@id="var_152"]', 'Complete')

'Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('//*[@id="var_50"]', 'Primaire')

'Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('//*[@id="var_49"]', 'Etui')

'click view parent '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

'Screenshot: Refpage'
WebUI.takeScreenshot()

WebUI.delay(1)

String parent_refid = functions.I.RefID()

'Verify that user is redirect to the parent ref'
WebUI.verifyNotMatch(parent_refid, dupli_refid, false)

WebUI.delay(1)

'Go back to ref list page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

WebUI.delay(1)

'Search ref'
functions.I.SearchRefNo_xpath('Copy 1 of', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Super edit'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[7]/div/button']), findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[7]/div/div/a[4]']))


'Set text for Component code'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_146"]']), 'TC20.04 Super edit component code - devfs')

'Click update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(1)

'VErify text is present on page'
WebUI.verifyTextPresent(' Components List', false)

'Close Browser'
WebUI.closeBrowser()