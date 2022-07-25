import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.google.common.base.Functions as Functions
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

/* 
VERIFY THAT USER CAN DUPLICATE IN ANOTHER PROJECT 2
 */
///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD [SEPHORA]
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Test_Sephora')

String password_atran = data_Sephora.getValue(2, 1 //R
    )

String password_suser = data_Sephora.getValue(2, 10 //R
    )

//DATA FILE URL [SEPHORA]
def data_urlAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Sephora = data_urlAUTO.getValue(2, 1)

//READ NOTEPAD & CLEAR NOTEPAD
String Project_No1 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_ProjectNo.txt')

String refID1 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refID.txt')

String ref_name1 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.01_Sephora_refIDName.txt')

String Project_No2 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.02_Sephora_ProjectNo2.txt')

String refID2 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\20.01\\20.02_Sephora_refID2.txt')


/////////////////////////////////////////////////TEST START /////////////////////////////////////////
'Navigate to Sephora'
WebUI.openBrowser(Url_Sephora)

'Maximize Window'
WebUI.maximizeWindow()

'Log in as atran :  diadeis'
functions.I.Login_password('suser', password_suser)

'Click on LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No1, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[10]/button')

'Screenshot: Devpack - reflist page'
WebUI.takeScreenshot()
WebUI.delay(1)
'Click on the duplication button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnduplicatereference"]']))

'Select 1 ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[1]/label']))

'Click confirm button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

//POPUP
'Screenshot: Duplication Popup'
WebUI.takeScreenshot()

'Click in a Existing project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="list_project_type"]/label[2]']))

WebUI.delay(2)

'Click on project no'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="is_old_project"]/div/span/span[1]/span/span[2]']))

WebUI.delay(1)

////*[@id="kt_body"]/span/span/span[1]/input
'Enter text'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/span/span/span[1]/input']), Project_No2)

WebUI.delay(1)

'Click on the option'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-nbProject-results"]/li']))

'Enter No of copies = 50'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="nb_copies"]']), '50')

WebUI.delay(2)

'Select Lifecycle template: [CR] Lifecycle (Empty Group)'
functions.I.SelectFromList_Value('//*[@id="lfc_tpl5"]', '32')

'Screenshot: Duplication Popup: Existing Project/ No of Copies = 50'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click duplicate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

WebUI.delay(5)

'Get Project no.'
String Project_No3 = functions.I.ProjectNo()

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Verify that the project no is not same'
WebUI.verifyMatch(Project_No3, Project_No2, false)

'Get the no of ref created and verify that the no of ref created is 52'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '52')

functions.I.SearchRefNo_xpath('Copy 50 of', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[5]/button')

functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '1')

//DUPLICATED 50th
'Click on the 1st ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[4]/a']))

WebUI.delay(1)

'Get the refid of the ref - PART A'
String refid52 = functions.I.RefID()

'Verify that the button view parent is displayed'
WebUI.verifyElementClickable(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

'Screenshot: Ref view 52'
WebUI.takeScreenshot()



//VERIFY FIELD PREFILLE REF A
'47  Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[1]/div', 
    'Complete')

'Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[4]/div', 
    'Primaire')

'Verify that field have been prefilled - DDC Complete'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[6]/div', 
    'Etui')

'Go back to ref list page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Click on the 1st ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[4]/a']))

'Click on view parent'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

'Screenshot: Ref view 1'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify that user is redirected to the original ref'
String refidp = functions.I.RefID()

WebUI.verifyMatch(refidp, refID1, false)

'Logout as devpack'
functions.I.Logout()

//ATRAN -
'Log in as atran :  diadeis'
functions.I.Login_password('atran', password_atran)

'Click on LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No2, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

WebUI.delay(1)

'Search ref'
functions.I.SearchRefNo_xpath('Copy 50 of', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'ref list page: Click Submit '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refid52) + '"]/td[7]/a']))

WebUI.delay(1)

'Set text : Closing date DDC'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_36"]']), '05/05/2022', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'Set text : sending date DDC'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_37"]']), '18/06/2023', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'ref modif page: Click Submit Phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

'Click on modify project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]/div[2]/div/a']))

WebUI.delay(1)

'Select studio'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'studio')

'Click update proj'
WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(1)

'ref list page: Click Submit '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refid52) + '"]/td[7]/a']))

WebUI.delay(1)

'Set text : Closing date DDC'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_36"]']), '05/05/2022', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'Set text : sending date DDC'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_37"]']), '18/06/2023', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'ref modif page: Click Submit Phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Lifecycle Status:'
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refid52) + '"]/td[5]/span[1]']), 
    'Phase 1.2')

'Super edit ref'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refid52) + '"]/td[7]/div/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refid52) + '"]/td[7]/div/div/a[4]']))

'Screenshot: Ref Modif'
WebUI.takeScreenshot()

'Set text for Component code'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_146"]']), 'Super edit component code - TC20.3')

'Click update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(1)

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Click on reflink'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refid52) + '"]/td[4]/a']))

WebUI.delay(3)

'Click on full phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_full_brief"]']))

WebUI.delay(1)

'Verify that Component code'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[5]/div', 'Super edit component code - TC20.3')

'Logout as atran'
functions.I.Logout()

WebUI.closeBrowser()

